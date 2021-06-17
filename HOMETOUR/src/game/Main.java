package game;

import java.util.Scanner;

import fixtures.Room;

public class Main {

	
	private static  RoomManager rm =new RoomManager(4);
	
	//boolean variable for control if our game is running
	private  static boolean tour =true;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		// call the method init() from RoomManager class
		  
		   rm.init();
 
		
		Player player=new Player();
		
		System.out.println("Hometour is a game that allows you to visit all rooms of the house ");
		System.out.println("We have  4 directions namely east, west, north and south");
		System.out.println("The available rooms are the Dining room, the kitchen, the bathroom, the bedroom ");
		System.out.println("To play, just use the go command followed by - then the direction for example go-east ,for quit type exit");
		
		player.setcurrentRoom(rm.getStartingRoom());
		printRoom(player);
		while (tour) {
						
			
			  String[] answer=collectInput();
			  parse(answer, player);
		}
		
		System.out.println("Thanks for the Game ");
		 System.exit(0);
		 
		 
		
	}
	
	private static void printRoom(Player player) {
		System.out.println(" The       current Room  is : ");
		System.out.println(" ******     ******      ******");
		System.out.println(" Name : " + player.getcurrentRoom().getName());
		System.out.println(" shortDescription : " + player.getcurrentRoom().getShortDescription());
		System.out.println(" longDescription : " + player.getcurrentRoom().getLongDescription());
	}

	
	  private static String[] collectInput() {
		  System.out.println("Please Run your command  ");
			    Scanner sc=new Scanner(System.in);
				 String  entry =sc.nextLine();
				 String[] split =entry.split("-");
							  	 		 
		  return split;
	 
	  }
	 
		
	private static void parse(String[] command, Player player) {
String cmd=command[0].toLowerCase();
String direction=null;
if (command.length>1) {
	direction=command[1].toLowerCase();
}




if ((cmd.equals("go")) & (command.length>1))
{
	System.out.println("you are going to :  " +direction);
	
	Room walk=player.getcurrentRoom().getExit(direction);
	if (walk==null) {
		System.out.println("No Room in this direction");
	}
	else {
		
		player.setcurrentRoom(walk);
		printRoom(player);
		
	}
	
}
//Handle the case of exit command and wrong commands 

if ((cmd.equals("exit"))||(cmd.equals("exit") & (direction==null))) {
	tour=false;
} 
if(( (command.length==1)&(direction==null)) & (tour==true)) {
	System.out.println("WRONG command,for playing  use the go command followed by - then the direction for example go-east ,for quit type exit");
}




	}
}
