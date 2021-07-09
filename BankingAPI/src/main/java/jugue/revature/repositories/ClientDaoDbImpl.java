package jugue.revature.repositories;

import java.util.List;



import jugue.revature.db.JDBCCon;
import jugue.revature.models.Client;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ClientDaoDbImpl implements Clientdao {

	public static Connection con =JDBCCon.getConnection();
	
	private Client buildClient(ResultSet rs) throws SQLException {
		Client cl = new Client();
		cl.setClient_Id(rs.getInt("client_Id"));
		cl.setFirstname(rs.getString("firstname"));
		cl.setLastname(rs.getString("lastname"));
		cl.setMiddlename(rs.getString("middlename"));
		cl.setPhone(rs.getString("phone"));
		cl.setEmail(rs.getString("email"));
		cl.setDateofbirth(rs.getLong("dateofbirth"));
		cl.setAddress(rs.getString("address"));
	
		return cl;
	}
	
	@Override
	public Client getClient(int client_id) {
String sql = "select * from client where client_id = ?";
		
		try {
			
			//Set up PreparedStatement
			PreparedStatement ps = con.prepareStatement(sql);
			//Set values for Placeholders
			ps.setInt(1, client_id);
			
			//Execute query, store the results.
			ResultSet rs = ps.executeQuery();
			
			//Extract results out of ResultSet
			if(rs.next()) {
				return buildClient(rs);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return null;
	}

	@Override
	public List<Client> getAllClients() {
		
		String sql = "select * from client";
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			
			ResultSet rs = ps.executeQuery();
			
			List<Client> clients = new ArrayList<Client>();
			while(rs.next()) {
				
				clients.add(buildClient(rs));
			}
			
			return clients;
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return null;
	}

	@Override
	public Client addClient(Client cl) {
String sql = "INSERT INTO client VALUES(default,?,?,?,?,?,?,?) returning *";
		
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			
			
			ps.setString(1,cl.getFirstname() );
			ps.setString(2,cl.getLastname() );
			ps.setString(3,cl.getMiddlename() );
			ps.setString(4,cl.getPhone() );
			ps.setString(5,cl.getEmail());
			ps.setLong(6, cl.getDateofbirth());
			ps.setString(7,cl.getAddress() );
			
			ResultSet rs = ps.executeQuery();
			
			if(rs.next()) {
				return buildClient(rs);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return null;
	}

	@Override
	public Client updateClient(Client cl) {
String sql = "UPDATE client SET firstname=?, lastname=?, middlename=?, phone=?, email=?, dateofbirth=?, address=? where client_id=? returning *";
		
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			
			
			ps.setString(1,cl.getFirstname() );
			ps.setString(2,cl.getLastname() );
			ps.setString(3,cl.getMiddlename() );
			ps.setString(4,cl.getPhone() );
			ps.setString(5,cl.getEmail());
			ps.setLong(6, cl.getDateofbirth());
			ps.setString(7,cl.getAddress() );
			ps.setInt(8, cl.getClient_Id());
			ResultSet rs = ps.executeQuery();
			
			if(rs.next()) {
				return buildClient(rs);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return null;
	}

	@Override
	public Client deleteClient(int client_id) {
String sql = "delete from client where client_id =? returning * ";
		
		try {
			
			//Set up PreparedStatement
			PreparedStatement ps = con.prepareStatement(sql);
			//Set values for Placeholders
			ps.setInt(1, client_id);
			
			//Execute query, store the results.
			ResultSet rs = ps.executeQuery();
			
			//Extract results out of ResultSet
			if(rs.next()) {
				return buildClient(rs);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

}
