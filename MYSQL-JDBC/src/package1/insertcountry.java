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

public class insertcountry {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// creates three different Connection objects
		Connection connCOUNTRY = null;
		FileReader fr = null;
		BufferedReader br =null;
		PreparedStatement statement = null;
		try {
			String url2 = "jdbc:mysql://localhost/soccer";
			String url3= "root";
			String url4="Password";
			connCOUNTRY = DriverManager.getConnection(url2, url3, url4);
			if (connCOUNTRY != null) 
			{
				connCOUNTRY.setAutoCommit(false);
				System.out.println("Connected to the database test");
				//CountryTable
				fr=new FileReader("/Users/mohana/Downloads/Input_Data/Country.csv");
				if(fr!=null) {
					br=new BufferedReader(fr);
					connCOUNTRY.setAutoCommit(false);
					String sCurrentLine;
					int count =0;
					while ((sCurrentLine = br.readLine()) != null) 
					{
						//System.out.println("Read the current line");
						String col[]=sCurrentLine.split(",");
						for(int i=0;i<col.length;i++)
						{
							//	System.out.println(col[i]+","+col[i].length());					
						}				
						//statement = conn.prepareStatement("Insert into Country Values("+col[0]+","+col[1]+","+col[2]+","+col[3]+")");
						statement = connCOUNTRY.prepareStatement("INSERT INTO COUNTRY VALUES(?,?,?,?)");
						statement.setString(1, col[0].replaceAll("'", ""));					
						BigDecimal d = new BigDecimal(col[1]);
						statement.setBigDecimal(2, d);
						statement.setInt(3, Integer.parseInt(col[2]));
						statement.setString(4,col[3].replaceAll("'", ""));
						System.out.println(statement);
						//int k=statement.executeUpdate();		
						count++;
						
					}
					connCOUNTRY.commit();
					System.out.println("Total "+count+" Records  inserted into Country table!");			
				}
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

