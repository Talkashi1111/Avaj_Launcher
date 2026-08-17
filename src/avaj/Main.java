package avaj;

import java.io.FileNotFoundException;
import java.io.PrintStream;

public class Main {
	public static void main(String[] args) {
		if (args.length != 1) {
			System.out.println("usage: inputfile.txt");
			return;
		}
		int simulationCount;
		WeatherTower tower = new WeatherTower();
		PrintStream copy_console = System.out;
		try {
			System.setOut(new PrintStream("simulation.txt"));
		} catch (FileNotFoundException e) {
			System.out.println("Error: failed to created file simulation.txt");
			return;
		}
		try {
			Reader reader = new Reader();
			simulationCount = reader.read(args[0], tower);
			for (int i = 0; i < simulationCount; i++)
				tower.changeWeather();
			System.out.flush();

		} catch (InvalideFileException e) {
			copy_console.println(e.getMessage());

		}
	}
}
