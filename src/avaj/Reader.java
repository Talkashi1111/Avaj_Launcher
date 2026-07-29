package avaj;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Reader {
	Reader() {
	}

	Flyable parseIntoAircraft(String[] words) {
		String type = words[0];
		String name = words[1];
		int longitude, latitude, height;
		try {
			longitude = Integer.parseInt(words[2]);
			latitude = Integer.parseInt(words[3]);
			height = Integer.parseInt(words[4]);

		} catch (NumberFormatException e) {
			throw new InvalideFileException("Error: coordinates longitude, height and latitude must be an integer.");
		}
		if ((0 >= height) || (latitude <= 0) || (longitude <= 0)) {
			throw new InvalideFileException("Error: coordinates must be between 1 to 100");
		}
		Coordinates p_coordinates = new Coordinates(longitude, latitude, height);
		Flyable newAircraft = AircraftFactory.getInstance().newAircraft(type, name, p_coordinates);
		return newAircraft;

	}

	public int read(String filename, WeatherTower tower) {
		try (BufferedReader buf = new BufferedReader(new FileReader(filename));) {
			String line;
			line = buf.readLine();
			if (line == null)
				throw new InvalideFileException("Error: file is empty");
			int i;
			try {
				i = Integer.parseInt(line);
			} catch (NumberFormatException e) {
				throw (new InvalideFileException("Error: first line of file must be an integer"));
			}
			if (i < 0)
				throw new InvalideFileException("Error: first line of file must be a positive integer");
			int lineCount;
			for (lineCount = 0; (line = buf.readLine()) != null; lineCount++) {
				// System.out.println(line);
				String[] words = line.trim().split("\\s+");// TODO parse this arguments
				if (words.length != 5) {
					throw new InvalideFileException(
							"Error: line must containe aircraft in the form of \\\"TYPE NAME LONGITUDE LATITUDE HEIGHT\\");
				}
				Flyable new_aircraft = parseIntoAircraft(words);
				new_aircraft.registerTower(tower);
			}
			if (lineCount == 0) {
				throw new InvalideFileException(
						"Error: file must contain at least one aircraft in the form of \"TYPE NAME LONGITUDE LATITUDE HEIGHT\"");
			}
			return i;
		} catch (IOException e) {
			throw new InvalideFileException("Couldn't open file: " + filename);
		}
	}
}
