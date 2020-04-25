/**
 * @author Rohan Dayal
 * @ID_Number 112768867
 * @Recitation 02
 */

package homework5;
/**
 * Class definition for NoSuchNodeException class. Extends Exception class
 */
public class NoSuchNodeException extends Exception{
	/**
	 * Constructor for NoSuchNodeException object which is thrown when
	 * seeking to access a node that does not exist.
	 * @param message is String message passed to super constructor
	 */
	public NoSuchNodeException(String message) {
		super(message);
	}
}
