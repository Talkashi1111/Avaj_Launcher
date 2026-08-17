package avaj;

public class Coordinates {
	private int longitude;
	private int latitude;
	private int height;

	Coordinates(int p_longitude, int p_latitude, int p_height) {
		this.longitude = p_longitude;
		this.latitude = p_latitude;
		this.height = p_height;
	}

	public int getLongitude() {
		return this.longitude;
	}

	public int getLatitude() {
		return this.latitude;
	}

	public int getHeight() {
		return this.height;
	}

	public void setHeight(int h) {
		height = Math.max(0, Math.min(h, 100));
	}

	public void setLatitude(int lat) {
		latitude = lat;
	}

	public void setLongitude(int longitude) {
		this.longitude = longitude;
	}
}
// when building the flyable, i will need to check if the : height is between 0
// and 100, if the name of the aircraft is valid, and that there are first 2
// words and than 3 integers, if not throw an exception and don't build the
// coordinates or aircraft. if not throw an exeption
