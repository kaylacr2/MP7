/**
 * Invalid major exception is thrown when a major is not within the specified list.
 */
package rafloreseunjung;

/**
 * @author Eunjung, Raflores
 */
public class InvalidMajorException extends Exception {
	/**
	 * Generated serial.
	 */
	private static final long serialVersionUID = -7264924053007416858L;

	InvalidMajorException (String s) {
		super(s);
	}
}
