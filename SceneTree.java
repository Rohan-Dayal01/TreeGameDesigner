/**
 * @author Rohan Dayal
 * @ID_Number 112768867
 * @Recitation 02
 */
package homework5;
/**
 * Class defines SceneTree object. SceneTree has SceneNode instance variables
 * of private SceneNode root, private SceneNode cursor
 *
 */
public class SceneTree {
	private SceneNode root=null;
	private SceneNode cursor=null;
	/**
	 * No argument constructor for SceneTree object
	 */
	public SceneTree() {
		root = new SceneNode();
		cursor = root;
	}
	/**
	 * Constructor for SceneTree with parameters for information 
	 * of the root node
	 * @param title is String which root is to have its title set to
	 * @param scene is String which root is to have its sceneDescription
	 * Cursor is instantiated to begin at root
	 */
	public SceneTree(String title, String scene) {
		root = new SceneNode(title, scene, null);
		cursor = root;
	}
	/**
	 * Getter method for cursor of this SceneTree
	 * @return SceneNode cursor - a reference to the SceneNode object the
	 * cursor of this SceneTree is at
	 */
	public SceneNode getCursor() {
		return cursor;
	}
	/**
	 * Setter method for the cursor
	 * @param node is SceneNode which cursor is to be set equal to
	 */
	public void setCursor(SceneNode node) {
		cursor = node;
	}
	/**
	 * Is method to easily return the child of the cursor based on
	 * the letter entered (A for left, B for middle, C for right)
	 * @param o is String letter entered to indicate which child SceneNode
	 * is desired 
	 * @return SceneNode of the child which is desired
	 * @throws NoSuchNodeException if the cursor doesn't have a child
	 * at the designated position, or the user has entered an invalid position
	 * letter
	 */
	public SceneNode getOption(String o) throws NoSuchNodeException{
		if(o.equals("A")) {
			if(cursor.getLeft()==null)
				throw new NoSuchNodeException("No left child to get.");
			return cursor.getLeft();
		}
		else if(o.equals("B")) {
			if(cursor.getMiddle()==null)
				throw new NoSuchNodeException("No middle child to get.");
			return cursor.getMiddle();
		}
		else if(o.equals("C")) {
			if(cursor.getRight()==null)
				throw new NoSuchNodeException("No right child to get.");
			return cursor.getRight();
		}
		else {
			throw new NoSuchNodeException("Please enter a valid input letter "
					+ "(A, B, or C depending on"
					+ " what is available.");
		}
	}
	/**
	 * Method adds new node to be the child of the cursor
	 * @param title is title for the new SceneNode
	 * @param sceneDescription is sceneDescription for the new SceneNode
	 * @throws FullSceneException when the cursor has SceneNode objects
	 * assigned to left, middle, and right instance variables.
	 */
	public void addNewNode(String title, String sceneDescription) throws 
	FullSceneException{
		SceneNode novel;
		if(cursor.getLeft()==null) {
			novel = new SceneNode(title,sceneDescription,cursor);
			cursor.setLeft(novel);
		}
		else if(cursor.getMiddle()==null){
			novel = new SceneNode(title,sceneDescription,cursor);
			cursor.setMiddle(novel);
		
		}
		else if(cursor.getRight()==null){
			novel = new SceneNode(title,sceneDescription,cursor);
			cursor.setRight(novel);
		}
		else
			throw new FullSceneException("Sorry, cannot add this scene as "
					+ "current node has left, middle, and right children all "
					+ "occupied.");
	}
	/**
	 * Method to remove a given child of cursor based on the letter input
	 * @param option is String representing which child is to be removed
	 * @throws NoSuchNodeException is thrown when invalid position is given
	 * or when there is no child at the desired removal point
	 */
	public void removeScene(String option)throws NoSuchNodeException {
		if(option.equals("A")) {
			if(cursor.getLeft()==null)
				throw new NoSuchNodeException("No left child node to remove "
						+ "from cursor.");
			else {
				cursor.setLeft(cursor.getMiddle());
				cursor.setMiddle(cursor.getRight());
				cursor.setRight(null);
			}
		}
		else if(option.equals("B")) {
			if(cursor.getMiddle()==null)
				throw new NoSuchNodeException("No middle child node to remove"
						+ " from cursor.");
			else {
				cursor.setMiddle(cursor.getRight());
				cursor.setRight(null);
			}
		}
		else if(option.equals("C")) {
			if(cursor.getRight()==null)
				throw new NoSuchNodeException("No right child node to remove "
						+ "from cursor.");
			else
				cursor.setRight(null);
		}
		else
			throw new NoSuchNodeException("Sorry, cannot remove node as invalid"
					+ " position given");
	}
	/**
	 * Void method to move the cursor back to its parent method
	 * @throws NoSuchNodeException when cursor does not have a SceneNode parent
	 * to go back to
	 */
	public void moveCursorBackwards() throws NoSuchNodeException{
		if(cursor.getParent()==null)
			throw new NoSuchNodeException("Cursor does not have a parent SceneN"
					+ "ode.");
		cursor = cursor.getParent();
		
	}
	/**
	 * Void method to move the cursor forward to one of the child nodes
	 * @param option is String representing which child node to move to
	 * @throws NoSuchNodeException is thrown when invalid letter entered for 
	 * position, or when no SceneNode exists at the desired left, middle, or 
	 * right child nodes
	 */
	public void moveCursorForward(String option) throws NoSuchNodeException{
		if(option.charAt(0)=='A') {
			if(cursor.getLeft()==null)
				throw new NoSuchNodeException("No left-child exists from this"
						+ " node.");
			else
				cursor = cursor.getLeft();
		}
		else if(option.charAt(0)=='B') {
			if(cursor.getMiddle()==null)
				throw new NoSuchNodeException("No middle-child exists from this"
						+ " node.");
			else
				cursor = cursor.getMiddle();
		}
		else if(option.charAt(0)=='C') {
			if(cursor.getRight()==null)
				throw new NoSuchNodeException("No right-child exists from this"
						+ " node.");
			else
				cursor = cursor.getRight();
		}
		else {
			throw new NoSuchNodeException("Invalid option entered to move "
					+ "cursor to. Please enter "
					+ "letter 'A', 'B', or'C' (depending on whether they are"
					+ " printed options)");
		}
	}
	/**
	 * Getter method for SceneTree root
	 * @return SceneNode root
	 */
	public SceneNode getRoot() {
		return root;
	}
	/**
	 * Method to move the cursor SceneNode to be a child of a SceneNode that is
	 * chosen
	 * @param sceneIDToMoveTo is int designating which Node program will move 
	 * cursor to be child of.
	 * @throws NoSuchNodeException is thrown when seeking to access a node that
	 * does not exist in the SceneTree
	 * @throws FullSceneException is thrown when seeking to move cursor to be
	 * child of a node which already has left, middle, and right positions full
	 */
	public void moveScene(int sceneIDToMoveTo) throws NoSuchNodeException, 
	FullSceneException{
		//Must make sure to find the parent node of this new one
		if(searchTreeStart(root, sceneIDToMoveTo)==null)
			throw new NoSuchNodeException("Cannot move cursor to specified node"
					+ " ID as does not exist.");
		if(parentChildProblem(sceneIDToMoveTo)==true)
			System.out.println("Cannot move cursor to be child of specified node"
					+ " because cursor is parent of specified node.");
		else {
			SceneNode novelParent = searchTreeStart(root, sceneIDToMoveTo);
			if(novelParent.getLeft()==null) {
				novelParent.setLeft(cursor);
				if(cursor.getParent().getLeft().equals(cursor)) {//if previously was left child, moving things over now
					cursor.getParent().setLeft(cursor.getParent().getMiddle());
					cursor.getParent().setMiddle(cursor.getParent().getRight());
					cursor.getParent().setRight(null);
				}
				else if(cursor.getParent().getMiddle().equals(cursor)) {//if previously was middle child, moving right node to middle
					cursor.getParent().setMiddle(cursor.getParent().getRight());
					cursor.getParent().setRight(null);
				}
				else if(cursor.getParent().getRight().equals(cursor))//if previously was right child, making it null
					cursor.getParent().setRight(null);
				cursor.setParent(novelParent);
			}
			else if(novelParent.getMiddle()==null) {
				novelParent.setMiddle(cursor);
				if(cursor.getParent().getLeft().equals(cursor)) {//if previously was left child, moving things over now
					cursor.getParent().setLeft(cursor.getParent().getMiddle());
					cursor.getParent().setMiddle(cursor.getParent().getRight());
					cursor.getParent().setRight(null);
				}
				else if(cursor.getParent().getMiddle().equals(cursor)) {//if previously was middle child, moving right node to middle
					cursor.getParent().setMiddle(cursor.getParent().getRight());
					cursor.getParent().setRight(null);
				}
				else if(cursor.getParent().getRight().equals(cursor))//if previously was right child, making it null
					cursor.getParent().setRight(null);
				cursor.setParent(novelParent);
			}
			else if(novelParent.getRight()==null) {
				novelParent.setRight(cursor);
				if(cursor.getParent().getLeft().equals(cursor)) {//if previously was left child, moving things over now
					cursor.getParent().setLeft(cursor.getParent().getMiddle());
					cursor.getParent().setMiddle(cursor.getParent().getRight());
					cursor.getParent().setRight(null);
				}
				else if(cursor.getParent().getMiddle().equals(cursor)) {//if previously was middle child, moving right node to middle
					cursor.getParent().setMiddle(cursor.getParent().getRight());
					cursor.getParent().setRight(null);
				}
				else if(cursor.getParent().getRight().equals(cursor))//if previously was right child, making it null
					cursor.getParent().setRight(null);
				cursor.setParent(novelParent);
			}
			else
				throw new FullSceneException("Cannot move cursor to be child of"
						+ " specified node"
						+ " because node has no open spaces.");
		}
	}
	/**
	 * Method to get the path from the root to the current cursor node
	 * @return String with titles of all the SceneNodes needing to be followed
	 */
	public String getPathFromRoot() {
		String thePath="";
		SceneNode iterator = cursor;
		while(iterator!=null) {
			thePath=", "+iterator.getTitle()+thePath;
			iterator = iterator.getParent();
		}
		return thePath.substring(1);
	}
	/**
	 * Method used just to print the tree. Doesn't follow recursion just 
	 * used for testing purposes. 
	 * @param key is SceneNode to start printing from
	 */
	public void printTree(SceneNode key) {
		
		System.out.println(key.toString());
		if(key.getLeft()!=null) {	
			printTree(key.getLeft());
		}
		if(key.getMiddle()!=null) {	
			printTree(key.getMiddle());
		}
		if(key.getRight()!=null) {	
			printTree(key.getRight());
		}
	}
	/**
	 * toString() method of the SceneTree class
	 * @return a String representing this SceneTree object
	 * Calls on toStringHelper method
	 */
	public String toString() {
		String treePrintOut="";
		return toStringHelper(root, treePrintOut,0,"");
	}
	/**
	 * Helper method to get the String representation of this SceneTree
	 * @param key is the initial SceneNode to begin from in the SceneTree 
	 * @param treePrintOut is a String which will be concatenated and
	 * eventually returned as representing this SceneTree
	 * @param depth is int representing the depth level in the tree
	 * @param lMR is String to add on to the beginning of each SceneNode
	 * title in the SceneTree
	 * @return String representation of the SceneTree
	 */
	public String toStringHelper(SceneNode key,String treePrintOut, int depth,
			String lMR) {
		treePrintOut ="    ".repeat(depth)+lMR+" "+key.toString();
		//System.out.println(key.toString());
		if(cursor==key)
			treePrintOut = treePrintOut+" *";
		treePrintOut = treePrintOut+"\n";
		if(key.getLeft()!=null) {	
			treePrintOut+=toStringHelper(key.getLeft(),treePrintOut,depth+1,
					"A)");
		}
		if(key.getMiddle()!=null) {	
			treePrintOut+=toStringHelper(key.getMiddle(),treePrintOut,depth+1,
					"B)");
		}
		if(key.getRight()!=null) {	
			treePrintOut+=toStringHelper(key.getRight(),treePrintOut,depth+1,
					"C)");
		}
		return treePrintOut;
	}
	/**
	 * Boolean method to check that we are not moving the cursor to be the
	 * child of one of its own children, as this would destroy the tree
	 * @param sceneIDToMoveTo is int sceneID of the node we desire to move to
	 * @return true if there is a problem and position to be moved to is child 
	 * of current. False otherwise
	 * @throws NoSuchNodeException thrown if no node of desired sceneIDToMoveTo
	 * exists in this tree
	 */
	public boolean parentChildProblem(int sceneIDToMoveTo) 
			throws NoSuchNodeException {
		//This will start at the node searchTreeStart returns
		//will go in while loop until iterator node is null
		//if on the way the iterator equals cursor, return true
		//which would indicate that the swap cannot occur
		//Otherwise, return false which would mean we can do the swap
		if(searchTreeStart(root,sceneIDToMoveTo)==null)
			throw new NoSuchNodeException("Cannot move cursor to specified nod"
					+ "e ID as node doesn't exist");
		SceneNode iterator = searchTreeStart(root,sceneIDToMoveTo);
		while(iterator!=null) {//will equal null after calling getParent() to the root
			if(iterator.equals(cursor)) {
				return true;
			}
			iterator = iterator.getParent();
		}
		return false;
	}
	/**
	 * Method to start the search of this SceneTree
	 * @param root is root of the tree where search will begin
	 * @param id is sceneID of the SceneNode we are searching for
	 * @return SceneNode with sceneID = id
	 */
	public SceneNode searchTreeStart(SceneNode root, int id) {
		SceneNode searchFor = null;
		return searchTernaryTree(root,id,searchFor);
	}
	/**
	 * Method that actually conducts the recursive traversal and search
	 * of the ternary tree
	 * @param root is where the subtree begins to traverse from in
	 * each level of recursion
	 * @param id is int sceneID of the desired SceneNode
	 * @param searchFor is variable to be passed around, so that when
	 * the correct SceneNode is found, it can be identified and is not lost
	 * @return SceneNode searchFor
	 */
	public SceneNode searchTernaryTree(SceneNode root, int id,SceneNode 
			searchFor) {
		
		if(root.getID()==id)
			return root;
		
		//System.out.println(root.toString());
		if(root.getLeft()!=null&&searchFor==null) {	
			searchFor = searchTernaryTree(root.getLeft(),id,searchFor);
		}
		if(root.getMiddle()!=null&&searchFor==null) {
			searchFor = searchTernaryTree(root.getMiddle(),id,searchFor);
			}
		if(root.getRight()!=null&&searchFor==null) {
			searchFor = searchTernaryTree(root.getRight(),id,searchFor);
			}
		return searchFor;
	}
	
	
}
