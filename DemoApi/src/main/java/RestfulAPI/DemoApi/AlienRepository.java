package RestfulAPI.DemoApi;


import java.sql.*;
import java.util.ArrayList;
import java.util.List;





public class AlienRepository {
	
	
	Connection con= null;
	
	public AlienRepository() {
		System.out.println("ekhane");
		String url= "jdbc:mysql://localhost:3306/mysql";
		String username="root";
		String password="0";
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con= DriverManager.getConnection(url,username,password);
			if (con != null) {
		        System.out.println("Successfully connected to MySQL database test");
		      }
			else 
				System.out.print("notConected");
			
		}
		catch(Exception e) {
			System.out.print("ekhane"+e);
		}
		
		
	}
	
	
	public List<Alien> getAliens(){
		List<Alien> aliens= new ArrayList<>();
		String sql= "Select * from alien";
		try{
			Statement st=con.createStatement();
			ResultSet rs= st.executeQuery(sql);
			
			while(rs.next()) {
				Alien a= new Alien();
				a.setId(rs.getInt(1));
				a.setName(rs.getString(2));
				a.setScore(rs.getInt(3));
				
				aliens.add(a);
				
			}
			
		}
		catch(Exception e) {
			System.out.println(e);
		}
		
		return aliens;
	}
	
	public Alien getAlien(int id) {
		Alien a= new Alien();		
		String sql= "Select * from alien where id="+id;
		try{
			Statement st=con.createStatement();
			ResultSet rs= st.executeQuery(sql);
			
			if(rs.next()) {
				
				a.setId(rs.getInt(1));
				a.setName(rs.getString(2));
				a.setScore(rs.getInt(3));
			}
			
		}
		catch(Exception e) {
			System.out.println(e);
		}
		return a;
	}
	
	public void create(Alien a1) {
		String sql= "Insert into alien values(?,?,?)";
		
		try{
			PreparedStatement st=con.prepareStatement(sql);
			st.setInt(1,a1.getId());
			st.setString(2,a1.getName());
			st.setInt(3,a1.getScore());
			st.executeUpdate();
			
		}
		catch(Exception e) {
			System.out.println(e);
		}
	
	}
	
	public void update(Alien a1) {
		try{
		
		
			String sql= "Update alien set name=?, score=? where id=?";
			PreparedStatement st=con.prepareStatement(sql);
			st.setInt(3,a1.getId());
			st.setString(1,a1.getName());
			st.setInt(2,a1.getScore());
			st.executeUpdate();
			
		
					
		}
		catch(Exception e) {
			System.out.println(e);
		}
	
	}

}
