package jugue.revature.repositories;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;



import jugue.revature.db.Clientdb;
import jugue.revature.models.Client;

public class ClientdaoImpl implements Clientdao {

	@Override
	public Client getClient(int client_id) {
		
		return Clientdb.clients.get(client_id);
		
	}

	@Override
	public List<Client> getAllClients() {
		List<Client> clientList = new ArrayList<Client>();
		Set<Integer> keys = Clientdb.clients.keySet();
		for(Integer key: keys) 
		{
			clientList.add(Clientdb.clients.get(key));
		}
		
		return clientList;
	}

	@Override
	public Client addClient(Client cl) {
		cl.setClient_Id(Clientdb.count++);
		Clientdb.clients.put(cl.getClient_Id(), cl);
		
		return cl;
	}

	@Override
	public Client updateClient(Client cl) {
		
		Clientdb.clients.replace(cl.getClient_Id(), cl);
		return cl;
	}

	@Override
	public Client deleteClient(int client_id) {
		
		return Clientdb.clients.remove(client_id);
	}

}
