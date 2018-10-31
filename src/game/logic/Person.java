package game.logic;

/**
 * @author Bram Pulles
 * This class handles everything regarding a person.
 */
public class Person {
	
	/**
	 * The identifier can be used as an id for the persons.
	 */
	private static int identifier = 0;
	private int id;
	
	private boolean standing;
	private Person choice;
	
	public Person() {
		standing = true;
		id = identifier;
		identifier++;
	}
	
	public void setStanding(boolean bool) {
		standing = bool;
	}
	
	/**
	 * @return If a person is standing (true) or not (false).
	 */
	public boolean getStanding() {
		return standing;
	}
	
	/**
	 * @param person This person is the persons choice.
	 */
	public void setChoice(Person person) {
		choice = person;
	}
	
	public Person getChoice() {
		return choice;
	}
	
	public int getID() {
		return id;
	}
	
	public static void resetID() {
		identifier = 0;
	}
	
}
