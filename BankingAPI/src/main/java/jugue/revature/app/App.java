package jugue.revature.app;

import java.util.List;

import io.javalin.Javalin;
import jugue.revature.controllers.AccountController;
import jugue.revature.controllers.ClientController;
import jugue.revature.models.Account;
import jugue.revature.repositories.AccountDao;
import jugue.revature.repositories.AccountDaoDbImpl;
import jugue.revature.repositories.ClientDaoDbImpl;
import jugue.revature.repositories.Clientdao;
import jugue.revature.repositories.ClientdaoImpl;
import jugue.revature.services.AccountService;
import jugue.revature.services.AccountServiceImpl;
import jugue.revature.services.ClientService;
import jugue.revature.services.ClientServiceImpl;

public class App {

	public static void main(String[] args) {

		Javalin app = Javalin.create();

		establishRoutes(app);

		app.start(7000);

	}

	private static void establishRoutes(Javalin app) {
		
		//Clientdao cldao = new ClientdaoImpl();
		Clientdao cldao =new ClientDaoDbImpl();
		ClientService clsv = new ClientServiceImpl(cldao);
		ClientController clc = new ClientController(clsv);
		app.get("/", (ctx) -> ctx.result("This is Our Banking App Home Page!"));
		app.get("/hello", (ctx) -> ctx.result("Hello World!"));
		app.get("/clients", clc.getAllClients);
		app.get("/clients/:id", clc.getClientById);
		app.post("/clients", clc.addClient);
		app.put("/clients/:id", clc.updateClient);
		app.delete("/clients/:id", clc.deleteClient);
		
		
		// Account
	AccountDao accdao=new AccountDaoDbImpl();
	AccountService accsv=new AccountServiceImpl(accdao);
	AccountController accctl=new AccountController(accsv);
	app.post("/clients/:id/accounts", accctl.addAccount);
	app.get("/clients/:id/accounts", accctl.getAllAccountsByClient);
	app.put("/clients/:idc/accounts/:ida",accctl.updateClientAccount );
	app.delete("/clients/:idc/accounts/:ida",accctl.deleteAccount );
	app.get("/clients/:id/accounts/:minval/:maxval", accctl.getAllAccountsByClientBetween);
	app.patch("/clients/:idc/accounts/:ida", accctl.transactionAccount);
	app.patch("/clients/:idc/accounts/:ida/transfer/:idt", accctl.transfertAccount);
	
	}

}
