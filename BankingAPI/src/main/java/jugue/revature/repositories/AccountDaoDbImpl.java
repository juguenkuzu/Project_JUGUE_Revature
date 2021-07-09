package jugue.revature.repositories;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import jugue.revature.db.JDBCCon;
import jugue.revature.models.Account;

public class AccountDaoDbImpl implements AccountDao {
	public static Connection con = JDBCCon.getConnection();

	private Account buildAccount(ResultSet rs) throws SQLException {

		Account acc = new Account();
		acc.setAccount_code(rs.getInt("account_code"));
		acc.setBalance(rs.getDouble("balance"));
		acc.setDate_opened(rs.getLong("date_opened"));
		acc.setAccount_categorie_code(rs.getInt("account_categorie_code"));
		acc.setClient_id(rs.getInt("client_id"));

		return acc;

	}

	public int countclientid(int id) {
		String sql = "select count(client_id) as num from client where client_id =?";
		try {
			PreparedStatement ps = con.prepareStatement(sql);

			ps.setInt(1, id);

			ResultSet rs = ps.executeQuery();

			if (rs.next()) {
				return rs.getInt("num");
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}

	@Override
	public Account addAccount(Account acc) {
		String sql = "insert into account values(default,?,?,?,?) returning *";

		try {
			PreparedStatement ps = con.prepareStatement(sql);

			ps.setDouble(1, acc.getBalance());
			ps.setLong(2, acc.getDate_opened());
			ps.setInt(3, acc.getAccount_categorie_code());
			ps.setInt(4, acc.getClient_id());

			ResultSet rs = ps.executeQuery();

			if (rs.next()) {
				return buildAccount(rs);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List<Account> getAllAccountsByClientBetween(int client_id, double minval, double maxval) {

		String sql = "select * from account where client_id =? and balance between ? and ?";
		try {
			PreparedStatement ps = con.prepareStatement(sql);

			ps.setInt(1, client_id);
			ps.setDouble(2, minval);
			ps.setDouble(3, maxval);

			ResultSet rs = ps.executeQuery();

			List<Account> accounts = new ArrayList<Account>();

			while (rs.next()) {
				accounts.add(buildAccount(rs));

			}
			return accounts;
		}

		catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List<Account> getAllAccountsByClient(int client_id) {
		String sql = "select * from account where client_id=?";
		try {
			PreparedStatement ps = con.prepareStatement(sql);

			ps.setInt(1, client_id);

			ResultSet rs = ps.executeQuery();

			List<Account> accounts = new ArrayList<Account>();

			while (rs.next()) {
				accounts.add(buildAccount(rs));

			}
			return accounts;
		}

		catch (SQLException e) {
			e.printStackTrace();
		}

		return null;

	}

	@Override
	public List<Account> getAllAccounts() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Account updateAccount(Account acc) {
		String sql = "update account set balance=?,date_opened=?,account_categorie_code=? where account_code=? and client_id=? returning *";

		try {
			PreparedStatement ps = con.prepareStatement(sql);

			ps.setDouble(1, acc.getBalance());
			ps.setLong(2, acc.getDate_opened());
			ps.setInt(3, acc.getAccount_categorie_code());
			ps.setInt(4, acc.getAccount_code());
			ps.setInt(5, acc.getClient_id());

			ResultSet rs = ps.executeQuery();

			if (rs.next()) {
				return buildAccount(rs);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return null;
	}

	@Override
	public Account transactionAccount(int account_code, int client_id, double val, String trans) {
		
		String sql="";
		if (trans.equals("deposit")) {
			 sql = "update account set balance =balance + ? where account_code =? and client_id =? returning * ";
		} 
		if (trans.equals("withdraw")) {
			 sql = "update account set balance =balance - ? where account_code =? and client_id =? returning * ";
		} 
		

		try {

			PreparedStatement ps = con.prepareStatement(sql);
			ps.setDouble(1, val);
			ps.setInt(2, account_code);
			ps.setInt(3, client_id);

			ResultSet rs = ps.executeQuery();

			if (rs.next()) {
				return buildAccount(rs);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public Account deleteAccount(int account_code, int client_id) {
		String sql = "delete from account where account_code=? and client_id=? returning * ";

		try {

			PreparedStatement ps = con.prepareStatement(sql);

			ps.setInt(1, account_code);
			ps.setInt(2, client_id);

			ResultSet rs = ps.executeQuery();

			if (rs.next()) {
				return buildAccount(rs);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public Account getAccount(int account_code) {
		String sql = "select * from account where account_code=?";

		try {

			PreparedStatement ps = con.prepareStatement(sql);

			ps.setInt(1, account_code);

			ResultSet rs = ps.executeQuery();

			if (rs.next()) {
				return buildAccount(rs);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

}
