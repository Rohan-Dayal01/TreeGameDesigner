/**
 * @author Rohan Dayal
 * @ID_Number 112768867
 * @Recitation 02
 */

package homework5;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Class defines the AdventureDesigner class. This class serves as the driver
 * for testing the SceneTree and SceneNode classes in this game application.
 * Contains static SceneTree game object to be used in the running of the
 * application
 */
public class AdventureDesigner {
	static SceneTree game;
	/**
	 * Main Method to drive the game creator and player simulation using
	 * a ternary tree.
	 * @exception FullSceneException e is caught and handled for case that
	 * new SceneNode is attempted to be added as a child, but already a node
	 * has three children
	 * @exception InputMismatchException is caught and handles the case where 
	 * unexpected input given
	 * @exception NoSuchNodeException is caught and handled for when trying
	 * to make reference to a node that does not exist.
	 */
	public static void main(String[]args) {
		Scanner rod = new Scanner(System.in);
		System.out.println("Creating a story... \n");
		System.out.print("Please enter a title: ");
		String title = rod.nextLine();
		System.out.println();
		System.out.print("Please enter a scene: ");
		String description = rod.nextLine();
		game = new SceneTree(title, description);
		System.out.println();
		System.out.println("Scene #1 added");
		String entd = "";
		while(!entd.equals("Q")) {
			entd="";
			System.out.println("A) Add Scene\n" + 
					"R) Remove Scene\n" + 
					"S) Show Current Scene\n" + 
					"P) Print Adventure Tree\n" + 
					"B) Go Back A Scene\n" + 
					"F) Go Forward A Scene\n" + 
					"G) Play Game\n" + 
					"N) Print Path To Cursor\n" + 
					"M) Move scene\n" + 
					"Q) Quit\n");
			System.out.print("Please enter a selection: ");
			entd = rod.next();
			entd = entd.toUpperCase();
			System.out.println();
			try {
			if(entd.equals("A")) {
				System.out.println("Please enter a title:");
				rod.nextLine();
				String t1 = rod.nextLine();
				System.out.println("Please enter a scene:");
				String descrip = rod.nextLine();
				game.addNewNode(t1, descrip);
				int curID = SceneNode.getNumScenes();
				System.out.println("Scene #"+(curID-1)+" added.");	
					
			}
			else if(entd.equals("R")) {
				System.out.println("Please enter an option?");
				String option = rod.next();
				String removed = game.getOption(option).getTitle();
				game.removeScene(option);
				System.out.println(removed +" removed.");
			}
			else if(entd.equals("S")) {
				game.getCursor().displayFullScene();
			}
			else if(entd.equals("P")) {
				System.out.println(game.toString());
			}
			else if(entd.equals("B")) {
				game.moveCursorBackwards();
				System.out.println("Succesfully moved back to " + game.getCursor().
						getTitle());
			}
			else if(entd.equals("F")) {
				System.out.println("Which option do you wish to go to?");
				String option = rod.next();
				game.moveCursorForward(option);
				System.out.println("Successfully moved to " + game.getCursor().
						getTitle());
			}
			else if(entd.equals("G")) {
				SceneNode ogCurs = game.getCursor();
				game.setCursor(game.getRoot());
				playGame();
				game.setCursor(ogCurs);
			}
			else if(entd.equals("N")) {
				System.out.println(game.getPathFromRoot());
			}
			else if(entd.equals("M")) {
				System.out.println("Move current scene to:");
				int newID = rod.nextInt();
				game.moveScene(newID);
				System.out.println("Succesfully moved scene.");
			}
			else if(entd.equals("Q")) {
				System.out.println("Program terminating successfully.");
				break;
			}
			System.out.println();	
			}
			catch(FullSceneException e) {
				System.out.println(e.getMessage());
			}
			catch(NoSuchNodeException e) {
				System.out.println(e.getMessage());
			}
			catch(InputMismatchException e){
				rod.next();
				System.out.println("Please check that you are entering a "
						+ "number"
						+ " if necessary, or a letter if necessary.");
			}
			catch(Exception e) {
				System.out.println("An error occurred. Please try again.");
				entd="";
			}
			
		}
	}
	/**
	 * 
	 * Void method to run the game simulation of this constructed ternary tree
	 * 
	 * @exception NoSuchNodeException e is caught and handled for the case
	 * where we attempt to move the cursor forward, but there is no next
	 * child to go to.
	 * 
	 */
	public static void playGame() {
		Scanner rod = new Scanner(System.in);
		System.out.println("Now beginning game...");
		boolean running = true;
		while(running) {
			System.out.println(game.getCursor().getTitle());
			System.out.println(game.getCursor().getDescription());
			
			if(game.getCursor().getLeft()!=null)
				System.out.println("A) "+game.getCursor().getLeft().
						getTitle());
			if(game.getCursor().getMiddle()!=null)
				System.out.println("B) "+game.getCursor().getMiddle().
						getTitle());
			if(game.getCursor().getRight()!=null)
				System.out.println("C) " + game.getCursor().getRight().
						getTitle());
			
			if(game.getCursor().isEnding()) {
				running=false;
				System.out.println("The End.");
				System.out.println("Returning back to creation mode.");
				break;
			}
			System.out.println("Enter an option.");
			String option = rod.next();
			try {
			game.moveCursorForward(option);
			}
			catch(NoSuchNodeException e) {
				System.out.println(e.getMessage());
			}
		}
	}
}
