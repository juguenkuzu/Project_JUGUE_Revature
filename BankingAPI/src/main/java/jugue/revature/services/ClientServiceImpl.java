package jugue.revature.services;

import java.util.List;



import jugue.revature.models.Client;
import jugue.revature.repositories.*;

public class ClientServiceImpl implements ClientService {

	public Clientdao cldao;

	public ClientServiceImpl(Clientdao cldao) {
		this.cldao = cldao;
	}

	@Override
	public Client getClient(int client_id) {
		return cldao.getClient(client_id);

	}

	@Override
	public List<Client> getAllClients() {

		return cldao.getAllClients();
	}

	@Override
	public Client addClient(Client cl) {
		return cldao.addClient(cl);
	}

	@Override
	public Client updateClient(Client cl) {
		return cldao.updateClient(cl);
	}

	@Override
	public Client deleteClient(int client_id) {

		return cldao.deleteClient(client_id);

	}

}
