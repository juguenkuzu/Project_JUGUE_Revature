package jugue.revature.app;

import jugue.revature.repositories.*;

import java.util.List;

import jugue.revature.models.Client;

public class SimulatorApp {

	public static void main(String[] args) {
	
		Clientdao cldao =new ClientdaoImpl();
		List<Client> clients=cldao.getAllClients();
		System.out.println("====GET ALL CLIENT====");
		System.out.println(clients);
		System.out.println("====GET CLIENT ID====");
		System.out.println(cldao.getClient(3));
		
		Client cl=new Client(5,"Yorhana", "Nkuzu","sonikatazi","30789987644","yorhana@gmail.com",8L,"9 bts st apt17");
		//m = mr.addMovie(m);
		cl=cldao.addClient(cl);
		
		System.out.println("====ADD CLIENT====");
		System.out.println(cl);
		System.out.println(cldao.getAllClients());

		cl.setFirstname("yorca");
		cl=cldao.updateClient(cl);
		System.out.println("====UPDATE CLIENT====");
		System.out.println(cl);
		System.out.println(cldao.getClient(cl.getClient_Id()));
		
		cldao.deleteClient(cl.getClient_Id());
		System.out.println("====DELETE CLIENT====");
		System.out.println(cldao.getAllClients());
		
		/*
		 * mr.deleteMovie(m.getId()); System.out.println("===DELETE MOVIE===");
		 * System.out.println(mr.getAllMovies());
		 */
	}

}
