package jugue.revature.repositories;

import java.util.List;

import jugue.revature.models.Account;

public interface AccountDao {

	public Account addAccount(Account acc);

	public List<Account> getAllAccounts();

	public Account updateAccount(Account acc);

	public Account deleteAccount(int account_code,int client_id);

	public Account getAccount(int account_code);
	
	
	public List<Account> getAllAccountsByClient(int client_id);
	
	public List<Account> getAllAccountsByClientBetween(int client_id,double minval,double maxval);
	
	public Account transactionAccount(int account_code,int client_id,double val,String trans );
	

}
