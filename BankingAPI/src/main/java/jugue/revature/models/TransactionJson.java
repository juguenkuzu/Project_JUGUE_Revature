package jugue.revature.models;

public class TransactionJson {

	private String transaction;
	
	private double amount;

	public TransactionJson() {
		super();
		
	}

	public TransactionJson(String transaction, double amount) {
		super();
		this.transaction = transaction;
		this.amount = amount;
	}

	public String getTransaction() {
		return transaction;
	}

	public void setTransaction(String transaction) {
		this.transaction = transaction;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	@Override
	public String toString() {
		return "TransactionJson [transaction=" + transaction + ", amount=" + amount + "]";
	}
	
	
	
}
