package fixtures;

public class Room extends Fixture{
	
	private Room [] exits= new Room[4];
	
	 
	
	public Room(String name, String shortDescription, String longDescription) {
		super(name, shortDescription, longDescription);
		
		
	}
	

	
	
	public Room[] getExits() {
		return this.exits;
	}
	
	public Room getExit(String direction) {
		int pos=0;
		direction =direction.toLowerCase();
		switch (direction) {
		case "east":
			return exits[1];

		case "west":
			return exits[2];
		case "north":
			
			return exits[0];
			
		case "south":
			return exits[3];
		}
		return null;
		
	
	}
	
	public void setExits(Room[] roomsexit) {
		this.exits = roomsexit;
	}

	// Overloaded setter method. Allows us to set single exit based on index...
	public void setExits(Room roomexit, int index) {
		this.exits[index] = roomexit;
	}
}
