/**
 * @author Rohan Dayal
 * @ID_Number 112768867
 * @Recitation 02
 */

package homework5;
/**
 * Class defines the FullSceneException class and extends Exception 
 */
public class FullSceneException extends Exception{
	/**
	 * Constructor for the FullSceneException object which is thrown
	 * when a SceneNode has all children full
	 * @param message is the String to be passed to the super constructor
	 * for the message where this Exception is thrown
	 */
	public FullSceneException(String message) {
		super(message);
	}
}
