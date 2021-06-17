package game;
import fixtures.*;

public class RoomManager {
	private Room startingRoom;
	private Room[] rooms;
	

	
	public RoomManager(int i) {
		// TODO Auto-generated constructor stub
		super();
	
		rooms =new Room[i];
		
	}





	public Room getStartingRoom() {
		return startingRoom;
	}



	public void setStartingRoom(Room startingRoom) {
		this.startingRoom = startingRoom;
	}



	public Room[] getRooms() {
		return rooms;
	}



	public void setRooms(Room[] rooms) {
		this.rooms = rooms;
	}



	public void init() 	{
Room room1=new Room("Diningroom", "Dining room is a room for consuming food", "A kitchen is a room or part of a room used for cooking and food preparation in a dwelling or in a commercial establishment");	
this.rooms[0]=room1;

Room room2=new Room("Kitchen", "kitchen is the room  where we cook food", "Historically the dining room is furnished with a rather large dining table and a number of dining chairs");	
this.rooms[1]=room2;

Room room3=new Room("Bathroom", "Bathroom is the room which contains the toilet and  shower", "bathroom' is sometimes used to refer to any room in a residence that contains a toilet, regardless of the inclusion of a bath or shower.");	
this.rooms[2]=room3;

Room room4=new Room("Bedroom", "Bedroom is a room for sleeping", "A bedroom is a room situated within a residential or accommodation unit characterised by its usage for sleeping");	
this.rooms[3]=room4;

startingRoom=room1;




  //Set exit directions for  Dining room 
room1.setExits(room3,0);//north
  room1.setExits(room2,1);//east
  room1.setExits(room4,2);//west
  
  
  //Set exit directions for kitchen  
 room2.setExits(room1,2);//west
  
  //Set exit directions  for BathRoom
   room3.setExits(room1,3);//south
  
  
  //Set exit directions for BedRoom    
 room4.setExits(room1,1);//east
 

}


}