package package1;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class jdbcplayers {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// creates three different Connection objects
		Connection connPLAYERS = null;
		FileReader fr = null;
		BufferedReader br =null;
		PreparedStatement statement = null;
	try {
		String url2 = "jdbc:mysql://localhost/project1";
		String url3= "root";
		String url4="Password";
		connPLAYERS = DriverManager.getConnection(url2, url3, url4);
	//PLAYERS TABLE
	fr=new FileReader("/Users/mohana/Downloads/Input_Data/Players.csv");
	if(fr!=null) {
		br=new BufferedReader(fr);
		connPLAYERS.setAutoCommit(false);
		String sCurrentLine;
		int count =0;
		while ((sCurrentLine = br.readLine()) != null) {
			//System.out.println("Read the current line");
			String col[]=sCurrentLine.split(",");
			for(int i=0;i<col.length;i++) {
				//	System.out.println(col[i]+","+col[i].length());					
			}				
			//statement = conn.prepareStatement("Insert into Country Values("+col[0]+","+col[1]+","+col[2]+","+col[3]+")");
			statement = connPLAYERS.prepareStatement("INSERT INTO PLAYERS VALUES(?,?,?,?,?,?,?,?,?,?,?)");
			statement.setInt(1, Integer.parseInt(col[0]));
			statement.setString(2, col[1].replaceAll("'", ""));
			statement.setString(3, col[2].replaceAll("'", ""));
			statement.setString(4, col[3].replaceAll("'", ""));
			String sDate1=col[4].replaceAll("'", "");					
			Date utilDate = new SimpleDateFormat("yyyy-MM-dd").parse(sDate1);
			java.sql.Date sqlDate = new java.sql.Date(utilDate.getTime()); 
			statement.setDate(5, sqlDate);
			statement.setString(6, col[5].replaceAll("'", ""));
			statement.setInt(7, Integer.parseInt(col[6]));						
			statement.setString(8, col[7].replaceAll("'", ""));						
			statement.setString(9, col[8].replaceAll("'", ""));						
			statement.setInt(10, Integer.parseInt(col[9]));						
			statement.setBoolean(11, Boolean.parseBoolean(col[10]));					
			System.out.println(statement);
			
			
			
			//int k=statement.executeUpdate();		
			
			count++;
		}
		connPLAYERS.commit();
		System.out.println("Total "+count+" Records  inserted into Players table!");			
		}
	
}

	catch (FileNotFoundException ex) {
		System.out.println("An error occurred. Maybe FilePath is invalid or File not exist");
		ex.printStackTrace();
	}
	catch (IOException ex) {
		System.out.println("An error occurred. Problem in Reading the File");
		ex.printStackTrace();
	}
	catch (SQLException ex) {
		System.out.println("An error occurred. SQL EXCEPTION OCCURRED");
		ex.printStackTrace();
	}
	catch (Exception ex) {
		System.out.println("An error occurred.");
		ex.printStackTrace();
	}
 

}
}

