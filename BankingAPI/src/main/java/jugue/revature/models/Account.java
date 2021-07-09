package jugue.revature.models;

public class Account {
private int account_code ;
private double balance;
private long date_opened;
private int account_categorie_code;
private int client_id;

public Account() {
	super();
	
}

public Account(int account_code, double balance, long date_opened, int account_categorie_code, int client_id) {
	super();
	this.account_code = account_code;
	this.balance = balance;
	this.date_opened = date_opened;
	this.account_categorie_code = account_categorie_code;
	this.client_id = client_id;
}

public int getAccount_code() {
	return account_code;
}

public void setAccount_code(int account_code) {
	this.account_code = account_code;
}

public double getBalance() {
	return balance;
}

public void setBalance(double balance) {
	this.balance = balance;
}

public long getDate_opened() {
	return date_opened;
}

public void setDate_opened(long date_opened) {
	this.date_opened = date_opened;
}

public int getAccount_categorie_code() {
	return account_categorie_code;
}

public void setAccount_categorie_code(int account_categorie_code) {
	this.account_categorie_code = account_categorie_code;
}

public int getClient_id() {
	return client_id;
}

public void setClient_id(int client_id) {
	this.client_id = client_id;
}

@Override
public String toString() {
	return "Account [account_code=" + account_code + ", balance=" + balance + ", date_opened=" + date_opened
			+ ", account_categorie_code=" + account_categorie_code + ", client_id=" + client_id + "]";
}






 




}
