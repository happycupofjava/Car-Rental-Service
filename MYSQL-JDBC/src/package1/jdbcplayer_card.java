package package1;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import java.text.SimpleDateFormat;
import java.util.Date;
public class jdbcplayer_card {

	
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// creates three different Connection objects
		Connection connPLAYER_CARD = null;
		FileReader fr = null;
		BufferedReader br =null;
		PreparedStatement statement = null;
		try {
			String url2 = "jdbc:mysql://localhost/project1";
			String url3= "root";
			String url4="Password";
			connPLAYER_CARD = DriverManager.getConnection(url2, url3, url4);
			fr=new FileReader("/Users/mohana/Downloads/Input_Data/Player_Cards.csv");
			if(fr!=null) {
				br=new BufferedReader(fr);
				connPLAYER_CARD.setAutoCommit(false);
				String sCurrentLine;
				int count =0;
				while ((sCurrentLine = br.readLine()) != null) {
					//System.out.println("Read the current line");
					String col[]=sCurrentLine.split(",");
					for(int i=0;i<col.length;i++) {
						//	System.out.println(col[i]+","+col[i].length());					
					}				
					//statement = conn.prepareStatement("Insert into Country Values("+col[0]+","+col[1]+","+col[2]+","+col[3]+")");
					statement = connPLAYER_CARD.prepareStatement("INSERT INTO PLAYER_CARD VALUES(?,?,?)");
					statement.setInt(1, Integer.parseInt(col[0]));
					statement.setInt(2, Integer.parseInt(col[1]));
					statement.setInt(3, Integer.parseInt(col[2]));				
					System.out.println(statement);
					//int k=statement.executeUpdate();		
					count++;
				}
				connPLAYER_CARD.commit();
				System.out.println("Total "+count+" Records  inserted into PLAYER_CARDS table!");			
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
