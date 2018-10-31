package game.logic;

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
	
	public void chooseForAll() {
		for(int i = 0; i < numberOfPeople; i++) {
			int ran;
			
			do {
				ran = (int)(Math.random() * numberOfPeople);
			}while(i == ran);
			
			group[i].setChoice(group[ran]);
		}
	}
	
	public Person getPerson(int i) {
		return (i < numberOfPeople)? group[i] : null;
	}
	
	public int size() {
		return numberOfPeople;
	}
}
