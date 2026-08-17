package avaj;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;
import java.util.ArrayList;

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
		if ((0 > height) || (latitude <= 0) || (longitude <= 0)) {
			throw new InvalideFileException("Error: coordinates must be between 0 to 100");
		}
		if (height > 100)
			height = 100;
		Coordinates p_coordinates = new Coordinates(longitude, latitude, height);
		Flyable newAircraft = AircraftFactory.getInstance().newAircraft(type, name, p_coordinates);
		return newAircraft;

	}

	public Scenario read(String filename) {
		List<Flyable> aircraft = new ArrayList<>();
		try (BufferedReader buf = new BufferedReader(new FileReader(filename))) {
			String line = buf.readLine().trim();
			if (line == null)
				throw new InvalideFileException("Error: file is empty");
			int simulationCount;
			try {
				simulationCount = Integer.parseInt(line);
			} catch (NumberFormatException e) {
				throw (new InvalideFileException("Error: first line of file must be an integer"));
			}
			if (simulationCount <= 0)
				throw new InvalideFileException("Error: first line of file must be a positive integer");

			while ((line = buf.readLine()) != null) {
				if (line.isBlank())
					throw new InvalideFileException("Error: empty line is not accepted");
				String[] words = line.trim().split("\\s+");
				if (words.length != 5) {
					throw new InvalideFileException(
							"Error: line must contain aircraft in the form of \"TYPE NAME LONGITUDE LATITUDE HEIGHT\"");
				}
				aircraft.add(parseIntoAircraft(words));
			}
			if (aircraft.isEmpty()) {
				throw new InvalideFileException(
						"Error: file must contain at least one aircraft in the form of \"TYPE NAME LONGITUDE LATITUDE HEIGHT\"");
			}
			return new Scenario(simulationCount, aircraft);
		} catch (IOException e) {
			throw new InvalideFileException("Couldn't open file: " + filename);
		}
	}
}
