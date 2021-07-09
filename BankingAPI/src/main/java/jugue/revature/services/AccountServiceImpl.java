package jugue.revature.services;

import java.util.List;

import jugue.revature.models.Account;
import jugue.revature.repositories.AccountDao;


public class AccountServiceImpl implements AccountService {

	public AccountDao accdao;

	public AccountServiceImpl(AccountDao accdao) {
		this.accdao = accdao;
	}

	
	@Override
	public Account addAccount(Account acc) {
		
		return accdao.addAccount(acc);
	}
	
	@Override
	public List<Account> getAllAccountsByClient(int client_id){
		
		return accdao.getAllAccountsByClient(client_id);
		
	}
	@Override
	public List<Account> getAllAccounts() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Account updateAccount(Account acc) {
		
		return accdao.updateAccount(acc);
	}

	@Override
	public Account deleteAccount(int account_code,int client_id) {
		
		return accdao.deleteAccount(account_code, client_id);
	}

	@Override
	public Account getAccount(int account_code) {
	
		return accdao.getAccount(account_code);
	}


	@Override
	public List<Account> getAllAccountsByClientBetween(int client_id, double minval, double maxval) {
		
		return accdao.getAllAccountsByClientBetween(client_id, minval, maxval);
	}


	@Override
	public Account transactionAccount(int account_code, int client_id, double val, String trans) {
		
		return accdao.transactionAccount(account_code, client_id, val, trans);
	}

}
