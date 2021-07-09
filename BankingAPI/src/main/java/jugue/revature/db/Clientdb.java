package jugue.revature.db;

import jugue.revature.models.Client;
import java.util.HashMap;
import java.util.Map;




public class Clientdb {

	public static Map<Integer, Client> clients=new HashMap<Integer,Client>();
	public static int count=1;
	

	static {
		Client cl1=new Client(1,"Jugue", "Nkuzu","Ndilu","20789987644","jnk@gmail.com",0L,"18 swicth st apt8");
		Client cl2=new Client(2,"Yorguedi", "Nkuzu","Matondo","80789987644","ymnk@gmail.com",1L,"19 swicth st apt8");
		Client cl3=new Client(3,"Cathy", "Divita","Nkuzu","90789987644","cds@gmail.com",5L,"78 borrow st apt3");
		Client cl4=new Client(4,"Yorlein", "Nkuzu","Ndilu","30789987644","yol@gmail.com",4L,"98 bts st apt1");
		clients.put(count++,cl1);
		clients.put(count++,cl2);
		clients.put(count++,cl3);
		clients.put(count++,cl4);
		
	}


}
