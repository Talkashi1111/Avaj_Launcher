package avaj;

public class WeatherProvider {
	private static WeatherProvider instance;
	private static final String[] weather = { "RAIN", "FOG", "SUN", "SNOW" };

	private WeatherProvider() {
	}

	public static WeatherProvider getInstance() {
		if (instance == null)
			instance = new WeatherProvider();
		return instance;
	}

	public String getCurrentWeather(Coordinates p_coordinates) {
		int sum = (p_coordinates.getHeight() * 7) + (p_coordinates.getLatitude() * 11)
				+ (p_coordinates.getLongitude() * 13);
		return weather[sum % 4];
	}

}
