package jugue.revature.app;

import jugue.revature.models.Account;
import jugue.revature.repositories.AccountDao;
import jugue.revature.repositories.AccountDaoDbImpl;
import jugue.revature.repositories.ClientDaoDbImpl;
import jugue.revature.repositories.Clientdao;

public class DBtest {

	public static void main(String[] args) {
		//Clientdao cldao=new ClientDaoDbImpl();
		//System.out.println(cldao.getClient(1));
		
		//System.out.println(cldao.getAllClients());
		//cldao.getAllClients();
		
		//Account acc=new Account(8, 100, 20210707, 1, 4);
		AccountDao accdao =new AccountDaoDbImpl();
		//accdao.updateAccount(acc);
		//System.out.println(accdao.updateAccount(acc));
		
		
		System.out.println(accdao.transactionAccount(1, 1, 500, "withdraw"));
		

	}

}
