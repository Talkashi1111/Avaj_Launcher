package avaj;

public class AircraftFactory {

	static private long counter_aircrafts = 1;
	private static AircraftFactory instance;

	private AircraftFactory() {
	}

	static public AircraftFactory getInstance() {
		if (instance == null) {
			instance = new AircraftFactory();
		}
		return instance;
	}

	public Flyable newAircraft(String p_type, String p_name, Coordinates p_coordinates) {
		long id = counter_aircrafts++;
		switch (p_type) {
			case "Balloon": {
				return new Balloon(id, p_name, p_coordinates);
			}
			case "Helicopter": {
				return new Helicopter(id, p_name, p_coordinates);
			}
			case "JetPlane": {
				return new JetPlane(id, p_name, p_coordinates);
			}
			default: {
				throw new InvalideFileException("Error: Aircraft type is not recognized : " + p_type);
			}
		}
	}

}
