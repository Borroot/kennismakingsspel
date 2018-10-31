package game.logic;

/**
 * @author Bram Pulles
 * This class handles everything for a group of people.
 *
 */
public class Group {
	
	private int numberOfPeople;
	private Person group[];
	
	public Group(int numberOfPeople) {
		this.numberOfPeople = numberOfPeople;
		initializeGroup();
	}
	
	private void initializeGroup() {
		group = new Person[numberOfPeople];
		
		for(int i = 0; i < numberOfPeople; i++) {
			group[i] = new Person();
		}
	}
	
	/**
	 * This function lets every person choose another person randomly.
	 */
	public void chooseForAll() {
		for(int i = 0; i < numberOfPeople; i++) {
			int ran;
			
			do {
				ran = (int)(Math.random() * numberOfPeople);
			}while(i == ran);
			
			group[i].setChoice(group[ran]);
		}
	}
	
	/**
	 * @param i
	 * @return The ith person of the group.
	 */
	public Person getPerson(int i) {
		return (i < numberOfPeople)? group[i] : null;
	}
	
	public int size() {
		return numberOfPeople;
	}
}
