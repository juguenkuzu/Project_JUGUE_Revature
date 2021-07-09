package jugue.revature.controllers;

import java.util.List;

import com.google.gson.Gson;


import io.javalin.http.Handler;
import jugue.revature.models.Account;
import jugue.revature.models.TransactionJson;
import jugue.revature.repositories.AccountDaoDbImpl;
import jugue.revature.services.AccountService;

public class AccountController {
	AccountService accsv;

	Gson gson = new Gson();
	AccountDaoDbImpl accdimpl = new AccountDaoDbImpl();

	public AccountController(AccountService accsv) {
		this.accsv = accsv;
	}

	public Handler deleteAccount = (context) -> {
		String inputc = context.pathParam("idc");
		int idc;
		try {
			idc = Integer.parseInt(inputc);
		} catch (NumberFormatException e) {
			idc = -1;
		}

		String inputa = context.pathParam("ida");
		int ida;
		try {
			ida = Integer.parseInt(inputa);
		} catch (NumberFormatException e) {
			ida = -1;
		}

		Account acc = accsv.getAccount(ida);
		if ((accdimpl.countclientid(idc) > 0) & (acc != null)) {

			acc = accsv.deleteAccount(ida, idc);
			context.result((acc != null) ? gson.toJson(acc) : "{}");
			context.status(200);

		} else {
			
			context.status(404);
		}

	};

	// getAllAccountsByClient
	public Handler updateClientAccount = (context) -> {
		String inputc = context.pathParam("idc");
		int idc;
		try {
			idc = Integer.parseInt(inputc);
		} catch (NumberFormatException e) {
			idc = -1;
		}

		String inputa = context.pathParam("ida");
		int ida;
		try {
			ida = Integer.parseInt(inputa);
		} catch (NumberFormatException e) {
			ida = -1;
		}

		Account acc = accsv.getAccount(ida);
		// check if client and account exist
		if ((accdimpl.countclientid(idc) > 0) & (acc != null)) {
			acc = gson.fromJson(context.body(), Account.class);
			acc.setClient_id(idc);
			acc.setAccount_code(ida);
			acc = accsv.updateAccount(acc);
			context.result((acc != null) ? gson.toJson(acc) : "{}");
			context.status(200);

		} else {
			context.status(404);
		}
	};
	public Handler transfertAccount = (context) -> {
		String inputc = context.pathParam("idc");
		int idc;
		try {
			idc = Integer.parseInt(inputc);
		} catch (NumberFormatException e) {
			idc = -1;
		}

		String inputa = context.pathParam("ida");
		int ida;
		try {
			ida = Integer.parseInt(inputa);
		} catch (NumberFormatException e) {
			ida = -1;
		}
		
		String inputt = context.pathParam("idt");
		int idt;
		try {
			idt = Integer.parseInt(inputt);
		} catch (NumberFormatException e) {
			idt = -1;
		}
		
		TransactionJson tj=gson.fromJson(context.body(), TransactionJson.class);
		
		if ((accsv.getAccount(idt)!=null) && (tj.getTransaction().equals("transfer"))) {
			Account acc = accsv.getAccount(ida);
			Account acct = accsv.getAccount(idt);
			
			if ((accdimpl.countclientid(idc) > 0) & (acc != null)) {
				if (acc.getBalance() > tj.getAmount()) {
					
					acct=accsv.transactionAccount(idt, acct.getClient_id(), tj.getAmount(), "deposit");
					
					acc=accsv.transactionAccount(ida, idc, tj.getAmount(), "withdraw");
					context.result((acc != null) ? gson.toJson(acc) : "{}");
					context.status(200);
				} else {
					
					//insufficient funds
					context.status(422);
				}
				
			} else {
				context.status(404);
			}
			
		} else {
			context.status(404);
		}
		
	};
	public Handler transactionAccount= (context) -> {
		String inputc = context.pathParam("idc");
	int idc;
	try {
		idc = Integer.parseInt(inputc);
	} catch (NumberFormatException e) {
		idc = -1;
	}

	String inputa = context.pathParam("ida");
	int ida;
	try {
		ida = Integer.parseInt(inputa);
	} catch (NumberFormatException e) {
		ida = -1;
	}
	
	Account acc = accsv.getAccount(ida);
	// check if client and account exist
	if ((accdimpl.countclientid(idc) > 0) & (acc != null)) {
		
		TransactionJson tj=gson.fromJson(context.body(), TransactionJson.class);
		
		
		
		if (tj.getTransaction().equals("withdraw")) {
			
			if (acc.getBalance() > tj.getAmount()) {
				acc=accsv.transactionAccount(ida, idc, tj.getAmount(), tj.getTransaction());
				context.result((acc != null) ? gson.toJson(acc) : "{}");
				context.status(200);
			} else {
				
				//insufficient funds
				context.status(422);
			}
			
		}
		
		
		if (tj.getTransaction().equals("deposit")) {
			acc=accsv.transactionAccount(ida, idc, tj.getAmount(), tj.getTransaction());
			
			
			context.result((acc != null) ? gson.toJson(acc) : "{}");
			context.status(200);
		}
		

	} else {
		context.status(404);
	}
	
	};

	public Handler getAllAccountsByClientBetween = (context) -> {

		String inputid = context.pathParam("id");
		int id;
		try {
			id = Integer.parseInt(inputid);
		} catch (NumberFormatException e) {
			id = -1;
		}
		
		
		String inputminval = context.pathParam("minval");
		double minval;

		try {
			minval = Double.parseDouble(inputminval);

		} catch (NumberFormatException e) {
			minval = -1;
		}

		String inputmaxval = context.pathParam("maxval");
		double maxval;

		try {
			maxval = Double.parseDouble(inputmaxval);

		} catch (NumberFormatException e) {
			maxval = -1;
		}
		
		
		if (accdimpl.countclientid(id) > 0) {

			List<Account> accounts = accsv.getAllAccountsByClientBetween(id, minval, maxval);
			context.result(gson.toJson(accounts));
			context.status(200);

		} else {
			context.status(404);
		}

	};
	public Handler getAllAccountsByClient = (context) -> {
		String input = context.pathParam("id");
		int id;
		try {
			id = Integer.parseInt(input);
		} catch (NumberFormatException e) {
			id = -1;
		}
		;
		if (accdimpl.countclientid(id) > 0) {

			List<Account> accounts = accsv.getAllAccountsByClient(id);
			context.result(gson.toJson(accounts));
			context.status(200);

		} else {
			context.status(404);
		}
	};

	public Handler addAccount = (context) -> {
		String input = context.pathParam("id");
		int id;
		try {
			id = Integer.parseInt(input);
		} catch (NumberFormatException e) {
			id = -1;
		}
		;
		// if the client exists
		if (accdimpl.countclientid(id) > 0) {
			Account acc = gson.fromJson(context.body(), Account.class);
			acc.setClient_id(id);
			acc = accsv.addAccount(acc);
			context.result((acc != null) ? gson.toJson(acc) : "{}");
			context.status(201);

		} else {
			context.status(404);
		}

	};

	



}
