package game.logic;

public class Person {
	
	private boolean standing;
	private Person choice;
	
	public Person() {
		standing = true;
	}
	
	public void setStanding(boolean bool) {
		standing = bool;
	}
	
	public boolean getStanding() {
		return standing;
	}
	
	public void setChoice(Person person) {
		choice = person;
	}
	
	public Person getChoice() {
		return choice;
	}
	
}
