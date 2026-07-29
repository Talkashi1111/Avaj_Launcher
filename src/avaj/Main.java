package avaj;

public class Main {
	public static void main(String[] args) {
		if (args.length != 1) {
			System.out.println("usage: inputfile.txt");
			return;
		}
		int simulationCount;
		WeatherTower tower = new WeatherTower();
		try {
			Reader reader = new Reader();
			simulationCount = reader.read(args[0], tower);
			for (int i = 0; i < simulationCount; i++)
				tower.changeWeather();

		} catch (InvalideFileException e) {
			System.out.println(e.getMessage());

		}
	}
}
