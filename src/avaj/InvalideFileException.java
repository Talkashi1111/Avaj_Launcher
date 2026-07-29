package avaj;

//extends the runtimeException
public class InvalideFileException extends IllegalArgumentException {
	public InvalideFileException(String msg) {
		super(msg);
	}
}
