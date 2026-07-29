package avaj;

public class WeatherTower extends Tower {
	public String getWeather(Coordinates p_coordinates) {
		String weather = WeatherProvider.getInstance().getCurrentWeather(p_coordinates);
		return weather;
	}

	public void changeWeather() {
		conditionChanged();
	}
}
