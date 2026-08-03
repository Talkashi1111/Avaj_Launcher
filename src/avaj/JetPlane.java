package avaj;

public class JetPlane extends Aircraft {

	JetPlane(long p_id, String p_name, Coordinates p_coordinate) {
		super(p_id, p_name, p_coordinate);
	}

	public void updateConditions() {
		String curr_weather = weatherTower.getWeather(coordinates);
		switch (curr_weather) {
			case "RAIN": {
				coordinates.setLatitude(coordinates.getLatitude() + 5);
				System.out.println(this.toString() + ": drops falls on my plane");
				break;
			}
			case "SUN": {
				coordinates.setLatitude(coordinates.getLatitude() + 10);
				if (coordinates.getHeight() + 2 <= 100)
					coordinates.setHeight(coordinates.getHeight() + 2);
				System.out.println(this.toString() + ": Screw you sunny weather! i'm too height");
				break;
			}
			case "FOG": {
				coordinates.setLatitude(coordinates.getLatitude() + 1);
				System.out.println(this.toString() + ": fog inside my jet :S");
				break;
			}
			case "SNOW": {
				coordinates.setHeight(coordinates.getHeight() - 7);
				System.out.println(this.toString() + ": BRRR i'm freazing here!");
				if (coordinates.getHeight() <= 0) {
					weatherTower.unregister(this);
				}
				break;
			}
			default: {
				throw new IllegalStateException("Error: unknown weather condition");
			}

		}
	}

}
