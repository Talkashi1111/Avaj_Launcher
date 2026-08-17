package avaj;

import java.io.FileNotFoundException;
import java.io.PrintStream;

public class Main {
	public static void main(String[] args) {
		if (args.length != 1) {
			System.out.println("usage: inputfile.txt");
			System.exit(1);
		}
		WeatherTower tower = new WeatherTower();
		PrintStream copy_console = System.out;
		try {
			Scenario scenario = new Reader().read(args[0]);
			try (PrintStream out = new PrintStream("simulation.txt")) {
				System.setOut(out);
				for (Flyable f : scenario.aircrafts()) {
					f.registerTower(tower);
				}
				for (int i = 0; i < scenario.simulationCount(); i++)
					tower.changeWeather();
			}
		} catch (InvalideFileException e) {
			copy_console.println(e.getMessage());
			System.exit(1);

		} catch (FileNotFoundException e) {
			copy_console.println("Error: failed to create file simulation.txt");
			System.exit(1);
		}
	}
}
