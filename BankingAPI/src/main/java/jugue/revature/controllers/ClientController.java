package jugue.revature.controllers;

import io.javalin.http.Handler;
import jugue.revature.models.Client;
import jugue.revature.services.ClientService;
import java.util.List;

import com.google.gson.Gson;


public class ClientController {

	ClientService clsv;
	Gson gson = new Gson();

	public ClientController(ClientService clsv) {
		this.clsv = clsv;
	}

	public Handler getAllClients = (context) -> {
		List<Client> clients = clsv.getAllClients();
		context.result(gson.toJson(clients));
		context.status(200);
	};

	public Handler getClientById = (ctx) -> {
		String input = ctx.pathParam("id");
		int id;
		try {
			id = Integer.parseInt(input);
		} catch (NumberFormatException e) {
			id = -1;
		}
		Client cl = clsv.getClient(id);

		if (cl != null) {
			ctx.result(gson.toJson(cl));
		} else {
			ctx.status(404);
		}

	};

	public Handler addClient = (context) -> {
		Client cl = gson.fromJson(context.body(), Client.class);

		cl = clsv.addClient(cl);
		context.result((cl != null) ? gson.toJson(cl) : "{}");
		context.status(201);
	};
	
	public Handler updateClient = (context) -> {
		
		
		 
		  String input = context.pathParam("id");
			int id;
			try {
				id = Integer.parseInt(input);
			} catch (NumberFormatException e) {
				id = -1;
			}
			Client cl = clsv.getClient(id);

			if (cl != null) {
				   cl = gson.fromJson(context.body(), Client.class);
				  cl.setClient_Id(id);
				  cl = clsv.updateClient(cl); context.result((cl != null) ? gson.toJson(cl) :  "{}"); 
			} else {
				context.status(404);
			}

	};
	
	public Handler deleteClient = (context) -> {
		String input = context.pathParam("id");
		int id;
		try {
			id = Integer.parseInt(input);
		} catch (NumberFormatException e) {
			id = -1;
		}
		
		Client cl = clsv.deleteClient(id);
		
		context.result((cl != null) ? gson.toJson(cl) : "{}");
		if (cl!= null) {
			context.status(205);
		} else {
			context.status(404);
		}
	};
}
