/**
 * @author Rohan Dayal
 */

package homework5;
/**
 * Class defines ParentChildSwapException which is used to make sure
 * moving a node does not result in the tree being broken. Extends Exception
 */
public class ParentChildSwapException extends Exception {
	/**
	 * Constructor for ParentChildSwapException object
	 * @param message is String to be passed to super constructor
	 * when an object of this type is created.
	 */
	public ParentChildSwapException(String message) {
		super(message);
	}
}
