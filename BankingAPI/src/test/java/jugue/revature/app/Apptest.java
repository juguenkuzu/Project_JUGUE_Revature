package jugue.revature.app;

import static org.junit.Assert.*;

import org.junit.Test;

import jugue.revature.models.Client;
import jugue.revature.repositories.*;

public class Apptest {

	@Test
	public void getClientById () {
		//fail("Not yet implemented");
		Client cl1=new Client(3,"Cathy", "Divita","Matondo","90789987644","cds@gmail.com",19880914L,"78 borrow st apt3");
		Clientdao cldao=new ClientDaoDbImpl();
		//assertEquals("the same ", cl1.getFirstname(), cldao.getClient(3).getFirstname());
		
		assertEquals("the same ", "Jugue", cldao.getClient(1).getFirstname());
				
	}
	
	
	@Test
	public void insufficientfunds () {
		AccountDao accdao =new AccountDaoDbImpl();
		accdao.getAccount(1).getBalance();
		assertTrue("insufficient funds", accdao.getAccount(1).getBalance()<50000);
		
		
	}
	
	@Test
	public void withdraw () {
		AccountDao accdao =new AccountDaoDbImpl();
		accdao.getAccount(1).getBalance();
		assertTrue("withdraw", accdao.getAccount(1).getBalance()>500);
		
		
	}


}
