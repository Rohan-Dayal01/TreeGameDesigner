/**
 * @author Rohan Dayal
 * @ID_Number 112768867
 * @Recitation 02
 */
package homework5;
/**
 * Class defines the SceneNode object.
 * SceneNode has the instance variables private String title, private String
 * sceneDescription, private int sceneID, private SceneNode left, private
 * SceneNode middle, private SceneNode right, private SceneNode parent,
 * and the static int numScenes, which is used to keep track of the number of
 * Scene Objects created.
 */
public class SceneNode {
	private String title;
	private String sceneDescription;
	private int sceneID;
	private SceneNode left=null;
	private SceneNode middle=null;
	private SceneNode right=null;
	private SceneNode parent = null;
	private static int numScenes=1;
	/**
	 * No arg constructor for SceneNode() object
	 */
	public SceneNode() {
		title = "";
		sceneDescription ="";
		sceneID = numScenes++;
	}
	/**
	 * Overloaded constructor for SceneNode object
	 * @param title is String title parameter to which this.title is set to
	 * @param description is String which this.description is set to
	 * @param parent is SceneNode which this.parent is set to have a reference
	 */
	public SceneNode(String title, String description, SceneNode parent) {
		this.parent = parent;
		this.title = title;
		this.sceneDescription = description;
		this.sceneID = numScenes++;
	}
	/**
	 * Void method addSceneNode adds a SceneNode object to be a child for 
	 * this SceneNode object
	 * @param scene is SceneNode object to be assigned as one of this node's 
	 * children
	 * @throws FullSceneException when left, middle, and right are all occupied
	 * and cannot be set to anything else
	 */
	public void addSceneNode(SceneNode scene) throws FullSceneException{
		if(left==null)
			left = scene;
		else if(middle==null)
			middle = scene;
		else if(right==null)
			right = scene;
		else
			throw new FullSceneException("Sorry, cannot add this scene as "
					+ "current node has left, middle, and right children all "
					+ "occupied.");
	}
	/**
	 * Boolean method to determine whether this SceneNode is an ending node
	 * in the story
	 * @return true if not child nodes. Otherwise, return false
	 */
	public boolean isEnding() {
		if(left==null&&middle==null&&right==null) {
			return true;
		}
		return false;
	}
	/**
	 * Void method to print the title and description of the scene
	 */
	public void displayScene() {
		System.out.println(title);
		System.out.println(sceneDescription);
	}
	/**
	 * Void method to print the full information for this scene object
	 */
	public void displayFullScene() {
		System.out.println("Scene ID #"+sceneID);
		System.out.println("Title: "+title);
		System.out.println("Scene: " + sceneDescription);
		String lprint=left==null?"":"'"+left.getTitle()+"' (#"+left.getID()+")"
				+ "";
		String mprint=middle==null?"":", '"+middle.getTitle()+"' (#"+middle.
				getID()+")";
		String rprint=right==null?"":", '"+right.getTitle()+"' (#"+right.
				getID()+")";
		
		String nonePrint = "";
		if(left==null&&middle==null&&right==null) {
			nonePrint = "NONE";
		}
		String fullPrint ="Leads to: "+nonePrint+""+lprint+" "+mprint+" "+rprint;
		//fullPrint = fullPrint.substring(0,fullPrint.length()-1);
		System.out.println(fullPrint);
		
	}
	/**
	 * toString() method for SceneNode object
	 */
	public String toString() {
		return title+" (#"+sceneID+")";
	}
	/**
	 * Getter method for numScenes
	 * @return numScenes
	 */
	public static int getNumScenes() {
		return numScenes;
	}
	/**
	 * Setter method for parent instance variable
	 * @param parent is SceneNode which this.parent is to be set to
	 */
	public void setParent(SceneNode parent) {
		this.parent = parent;
	}
	/**
	 * Is getter method for parent node of this SceneNode
	 * @return SceneNode parent
	 */
	public SceneNode getParent() {
		return parent;
	}
	/**
	 * Setter method for title of SceneNode
	 * @param title is String which this.title is to be set equal to
	 */
	public void setTitle(String title) {
		this.title = title;
	}
	/**
	 * Setter method for the description of this SceneNode
	 * @param description is String which sceneDescription is set equal to
	 */
	public void setDescription(String description) {
		sceneDescription = description;
	}
	/**
	 * Setter method for the sceneID number
	 * @param sceneID is int which this.sceneID is set equal to
	 */
	public void setID(int sceneID) {
		this.sceneID = sceneID;
	}
	/**
	 * Setter method for SceneNode left
	 * @param left is SceneNode this.left is set equal to
	 */
	public void setLeft(SceneNode left) {
		this.left = left;
	}
	/**
	 * Setter method for SceneNode middle
	 * @param middle is SceneNode this.middle is set equal to
	 */
	public void setMiddle(SceneNode middle) {
		this.middle = middle;
	}
	/**
	 * Setter method for SceneNode right
	 * @param right is SceneNode this.right is set equal to
	 */
	public void setRight(SceneNode right) {
		this.right = right;
	}
	/**
	 * Getter method for the title of SceneNode
	 * @return String title
	 */
	public String getTitle() {
		return title;
	}
	/**
	 * Getter method for sceneDescription of this SceneNode
	 * @return String sceneDescription
	 */
	public String getDescription() {
		return sceneDescription;
	}
	/**
	 * Getter method for sceneID
	 * @return int sceneID
	 */
	public int getID() {
		return sceneID;
	}
	/**
	 * Getter method for left SceneNode
	 * @return SceneNode left
	 */
	public SceneNode getLeft() {
		return left;
	}
	/**
	 * Getter method for middle SceneNode
	 * @return SceneNode middle
	 */
	public SceneNode getMiddle() {
		return middle;
	}
	/**
	 * Getter method for right SceneNode
	 * @return SceneNode right
	 */
	public SceneNode getRight() {
		return right;
	}
	
	
}
