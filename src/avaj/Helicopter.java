package avaj;

public class Helicopter extends Aircraft {
	Helicopter(long p_id, String p_name, Coordinates p_coordinates) {
		super(p_id, p_name, p_coordinates);
	}

	public void updateConditions() {
		String curr_weather = weatherTower.getWeather(coordinates);
		switch (curr_weather) {
			case "RAIN": {
				coordinates.setLongitude(coordinates.getLongitude() + 5);
				System.out.println(this.toString() + ": raining non stop here!");
				break;
			}
			case "SUN": {
				coordinates.setLongitude(coordinates.getLongitude() + 10);
				System.out.println(this.toString() + ": Sun is high and im flying higher!");
				if (coordinates.getHeight() + 2 <= 100)
					coordinates.setHeight(coordinates.getHeight() + 2);
				break;
			}
			case "FOG": {
				System.out.println(this.toString() + ": I have to escape this foggy clouds!");
				if (coordinates.getHeight() + 1 <= 100)
					coordinates.setHeight(coordinates.getHeight() + 1);
				break;
			}
			case "SNOW": {
				coordinates.setHeight(coordinates.getHeight() - 12);
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
