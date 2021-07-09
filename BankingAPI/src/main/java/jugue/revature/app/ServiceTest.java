package jugue.revature.app;

import jugue.revature.repositories.Clientdao;
import jugue.revature.repositories.ClientdaoImpl;
import jugue.revature.services.ClientService;
import jugue.revature.services.ClientServiceImpl;

public class ServiceTest {

	public static void main(String[] args) {
		Clientdao cldao=new ClientdaoImpl();
		ClientService clsv=new ClientServiceImpl(cldao);
		System.out.println(clsv.getAllClients());
		System.out.println(clsv.getClient(1));

	}

}
