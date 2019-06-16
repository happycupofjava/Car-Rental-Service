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
public class jdbcconnection {
	public static String url2 = "jdbc:mysql://localhost/project1";
	public static String url3= "root";
	public static String url4="Password";
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// creates three different Connection objects
		
		FileReader fr = null;
		BufferedReader br =null;
		PreparedStatement statement = null;
		
		
		try {
			//String url2 = "jdbc:mysql://localhost/project1";
			//String url3= "root";
			//String url4="Password";
//			conn1 = DriverManager.getConnection(url2, url3, url4);
			Connection conn1 = null;
			conn1 = DriverManager.getConnection(url2, url3, url4);
			
			if (conn1 != null) {
				conn1.setAutoCommit(false);
				System.out.println("Connected to the database test");
				System.out.println("///////////////////////////////////LOADING COUNTRIES////////////////////////////////////////////////////////////////////////");
				/*fr=new FileReader("/Users/mohana/Downloads/Input_Data/Country.csv");
				if(fr!=null) {
					br=new BufferedReader(fr);
					conn1.setAutoCommit(false);
					String sCurrentLine;
					int count =0;
					while ((sCurrentLine = br.readLine()) != null) {
						//System.out.println("Read the current line");
						String col[]=sCurrentLine.split(",");
						for(int i=0;i<col.length;i++) {
							//	System.out.println(col[i]+","+col[i].length());					
						}				
						//statement = conn.prepareStatement("Insert into Country Values("+col[0]+","+col[1]+","+col[2]+","+col[3]+")");
						statement = conn1.prepareStatement("INSERT INTO COUNTRY VALUES(?,?,?,?)");
						statement.setString(1, col[0].replaceAll("'", ""));					
						BigDecimal d = new BigDecimal(col[1]);
						statement.setBigDecimal(2, d);
						statement.setInt(3, Integer.parseInt(col[2]));
						statement.setString(4,col[3].replaceAll("'", ""));
						//System.out.println(statement);
						//int k=statement.executeUpdate();		
						count++;
					}
					conn1.commit();
					System.out.println("Total "+count+" Records  inserted into Country table!");			
				}
				*/
				System.out.println("////////////////////////////////////LOADING PLAYERS////////////////////////////////////////////////////////////////////////");
				fr=new FileReader("/Users/mohana/Downloads/Input_Data/Players.csv");
				if(fr!=null) {
					br=new BufferedReader(fr);
					conn1.setAutoCommit(false);
					String sCurrentLine;
					int count =0;
					while ((sCurrentLine = br.readLine()) != null) {
						//System.out.println("Read the current line");
						String col[]=sCurrentLine.split(",");
						for(int i=0;i<col.length;i++) {
							//	System.out.println(col[i]+","+col[i].length());					
						}				
						//statement = conn.prepareStatement("Insert into Country Values("+col[0]+","+col[1]+","+col[2]+","+col[3]+")");
						statement = conn1.prepareStatement("INSERT INTO PLAYERS VALUES(?,?,?,?,?,?,?,?,?,?,?)");
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
						//System.out.println(statement);
						//int k=statement.executeUpdate();		
						count++;
					}
					conn1.commit();
					System.out.println("Total "+count+" Records  inserted into Players table!");			
				}
				/*System.out.println("////////////////////////////////////LOADING PLAYER CARDS////////////////////////////////////////////////////////////////////////");
				fr=new FileReader("/Users/mohana/Downloads/Input_Data/Player_Cards.csv");
				if(fr!=null) {
					br=new BufferedReader(fr);
					conn1.setAutoCommit(false);
					String sCurrentLine;
					int count =0;
					while ((sCurrentLine = br.readLine()) != null) {
						//System.out.println("Read the current line");
						String col[]=sCurrentLine.split(",");
						for(int i=0;i<col.length;i++) {
							//	System.out.println(col[i]+","+col[i].length());					
						}				
						//statement = conn.prepareStatement("Insert into Country Values("+col[0]+","+col[1]+","+col[2]+","+col[3]+")");
						statement = conn1.prepareStatement("INSERT INTO PLAYER_CARDS VALUES(?,?,?)");
						statement.setInt(1, Integer.parseInt(col[0]));
						statement.setInt(2, Integer.parseInt(col[1]));
						statement.setInt(3, Integer.parseInt(col[2]));				
						//System.out.println(statement);
						//int k=statement.executeUpdate();		
						count++;
					}
					conn1.commit();
					System.out.println("Total "+count+" Records  inserted into PLAYER_CARDS table!");			
				}*/
				/*System.out.println("////////////////////////////////////LOADING PLAYER_ASSIST_GOALS////////////////////////////////////////////////////////////////////////");
				fr=new FileReader("/Users/mohana/Downloads/Input_Data/Player_Assists_Goals.csv");
				if(fr!=null) {
					br=new BufferedReader(fr);
					conn1.setAutoCommit(false);
					String sCurrentLine;
					int count =0;
					while ((sCurrentLine = br.readLine()) != null) {
						//System.out.println("Read the current line");
						String col[]=sCurrentLine.split(",");
						for(int i=0;i<col.length;i++) {
							//	System.out.println(col[i]+","+col[i].length());					
						}				
						//statement = conn.prepareStatement("Insert into Country Values("+col[0]+","+col[1]+","+col[2]+","+col[3]+")");
						statement = conn1.prepareStatement("INSERT INTO PLAYER_ASSISTS_GOALS VALUES(?,?,?,?,?)");
						statement.setInt(1, Integer.parseInt(col[0]));
						statement.setInt(2, Integer.parseInt(col[1]));
						statement.setInt(3, Integer.parseInt(col[2]));	
						statement.setInt(4, Integer.parseInt(col[3]));
						statement.setInt(5, Integer.parseInt(col[4]));
						//System.out.println(statement);
						//int k=statement.executeUpdate();		
						count++;
					}
					conn1.commit();
					System.out.println("Total "+count+" Records  inserted into PLAYER_ASSIST_GOALS table!");			
				}*/
			/*	System.out.println("////////////////////////////////////LOADING MATCH_RESULTS////////////////////////////////////////////////////////////////////////");
				fr=new FileReader("/Users/mohana/Downloads/Input_Data/Match_results.csv");
				if(fr!=null) {
					br=new BufferedReader(fr);
					conn1.setAutoCommit(false);
					String sCurrentLine;
					int count =0;
					while ((sCurrentLine = br.readLine()) != null) {
						//System.out.println("Read the current line");
						String col[]=sCurrentLine.split(",");
						for(int i=0;i<col.length;i++) {
							//	System.out.println(col[i]+","+col[i].length());					
						}				
						//statement = conn.prepareStatement("Insert into Country Values("+col[0]+","+col[1]+","+col[2]+","+col[3]+")");
						statement = conn1.prepareStatement("INSERT INTO MATCH_RESULTS VALUES(?,?,?,?,?,?,?,?,?)");
						statement.setInt(1, Integer.parseInt(col[0]));
						String sDate1=col[1].replaceAll("'", "");					
						Date utilDate = new SimpleDateFormat("yyyy-MM-dd").parse(sDate1);
						java.sql.Date sqlDate = new java.sql.Date(utilDate.getTime()); 
						statement.setDate(2, sqlDate);
						String sDate2=col[2].replaceAll("'", "");					
						statement.setTime(3, java.sql.Time.valueOf(sDate2));
						statement.setString(4, col[3].replaceAll("'", ""));
						statement.setString(5, col[4].replaceAll("'", ""));
						statement.setInt(6, Integer.parseInt(col[5]));	
						statement.setInt(7, Integer.parseInt(col[6]));
						statement.setString(8, col[7].replaceAll("'", ""));
						statement.setString(9, col[8].replaceAll("'", ""));
						//System.out.println(statement);
						//int k=statement.executeUpdate();		
						count++;
					}
					conn1.commit();
					System.out.println("Total "+count+" Records  inserted into MATCH_RESULTS table!");			
				} */conn1.close();
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
