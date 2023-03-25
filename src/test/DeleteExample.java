package test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DeleteExample {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		
		Class.forName("com.mysql.cj.jdbc.Driver");

		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/ecommerce", "root", "root");

		Statement stmt = con.createStatement();
		
		stmt.executeUpdate(" delete from eproduct where name='Tablet';");
		
		//stmt.executeUpdate("insert into eproduct (name, price, date_added) values ('Mobile', 5000.00, now())");
		
		System.out.println(" The row is updated ");
		ResultSet result = stmt.executeQuery("select * from eproduct");

		while (result.next()) {

			System.out.println("Product Id " + result.getInt("ID"));
			System.out.println("Product name " + result.getString("name"));
			System.out.println("Price " + result.getDouble("Price"));
		}
		
		con.close();
	}

}
