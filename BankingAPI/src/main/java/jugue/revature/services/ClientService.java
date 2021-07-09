package jugue.revature.services;

import java.util.List;

import jugue.revature.models.Client;

public interface ClientService {

	public Client getClient(int client_id);

	public List<Client> getAllClients();

	public Client addClient(Client cl);

	public Client updateClient(Client cl);

	public Client deleteClient(int client_id);

	// public Client checkout(Client cl);

	// public boolean checkin(Client cl);

}
