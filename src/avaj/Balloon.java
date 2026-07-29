package avaj;

public class Balloon extends Aircraft {
	Balloon(long p_id, String p_name, Coordinates p_coordinates) {
		super(p_id, p_name, p_coordinates);
	}

	public void updateConditions() {
		String curr_weather = weatherTower.getWeather(coordinates);
		switch (curr_weather) {
			case "RAIN": {
				coordinates.setHeight(coordinates.getHeight() - 5);
				System.out.println(this.toString() + ": It's raining man");
				if (coordinates.getHeight() <= 0) {
					weatherTower.unregister(this);
				}
				break;
			}
			case "SUN": {
				coordinates.setLongitude(coordinates.getLongitude() + 2);
				System.out.println(this.toString() + ": Sun is high and im flying higher!");
				if (coordinates.getHeight() + 4 <= 100)
					coordinates.setHeight(coordinates.getHeight() + 4);
				break;
			}
			case "FOG": {
				coordinates.setHeight(coordinates.getHeight() - 3);
				System.out.println(this.toString() + ": BRRR i'm freazing here!");
				if (coordinates.getHeight() <= 0) {
					weatherTower.unregister(this);
				}
				break;
			}
			case "SNOW": {
				coordinates.setHeight(coordinates.getHeight() - 15);
				System.out.println(this.toString() + ": SNOWY WEATHER");
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
