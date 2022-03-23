//JDBC CRUD Operation Project

import java.sql.*;
import java.util.Scanner;
import java.io.*;

class CRUD
{
	public static void main(String[] args) 
	{
		int userChoice = 0;
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		try{	

			// Load Driver
			Class.forName("com.mysql.cj.jdbc.Driver");

			// Enter username and passqord to Connection with mySQL
			String url = "jdbc:mysql://127.0.0.1:3306/student?useSSL=false";

			System.out.print("Enter Database Username : ");
			Scanner sc = new Scanner(System.in);
			String username = sc.nextLine();

			System.out.print("Enter Database password : ");
			String password = sc.nextLine();

			Connection con = DriverManager.getConnection(url,username,password);

			if (con.isClosed()) {
				System.out.println("Connection Closed");
			}else{
				System.out.println("mySQL Connection Connected...");
				System.out.println();
				while(true){
				try{
					System.out.println("Welcome To CRUD JDBC operation : ");			

					System.out.println("Enter 1 for insert value in table : ");
					System.out.println("Enter 2 for update table : ");
					System.out.println("Enter 3 for Show Table Values : ");
					System.out.println("Enter 4 for delete table : ");
					System.out.println("Enter 5 for exit :");
					System.out.print("Enter Your Choice : ");

					userChoice= sc.nextInt();

					if(userChoice == 5){

						System.out.println("\nThank You for Using please follow me on git ''baru-7031''");
						break;
					}


				}catch(Exception e){
					System.out.println("Sorry Please Enter integer Number : :)");
				}
				switch(userChoice)
				{
				case 1:
					{
						//--------------------------------------Insert value--------------------------------------------
						try{
							// value insert
							System.out.println();
							System.out.print("Enter Student Name : ");
							String studentName = br.readLine();
							System.out.print("Enter Student City : ");
							String studentCity = br.readLine();

							// Query Create
							String queryInsert = "insert into students(studentName, studentCity) values (?,?)";

							// Create PreparedStatement object
							PreparedStatement pstmt = con.prepareStatement(queryInsert);

							// value will be pass in database
							pstmt.setString(1, studentName);
							pstmt.setString(2, studentCity);

							// update value
							pstmt.executeUpdate();

							System.out.println("\nInserted.....\n");

						}catch(Exception e){
							System.out.println(e);
						}
						break;
					}
				case 2:
					{
						//--------------------------------update value-------------------------------------

						try{
							System.out.println("\n\nThis is the Student table values : \n");
							String query = "select * from students";

							Statement stmt = con.createStatement();

							ResultSet set = stmt.executeQuery(query);
							System.out.println("\nstudentId : studentName : studentCity");
							while(set.next())
							{
								int id = set.getInt(1);
								String name = set.getString(2);
								String city = set.getString(3);

								System.out.println(id + " : " + name + " : " + city);
							}
							System.out.println("\nWhich value you want to chance it please fillup the Form : \n");
							System.out.print("Enter Student ID : ");
							int studentID = sc.nextInt();

							System.out.print("\nEnter column name : ");
							String columnName = br.readLine();
							System.out.print("\nEnter column value to update table : ");
							String columnValue = br.readLine();

							// Query Created 
							String queryUpdate = "update students set "+ columnName +" =? where studentId =?";

							PreparedStatement pstmt = con.prepareStatement(queryUpdate);

							pstmt.setString(1, columnValue);
							pstmt.setInt(2, studentID);

							pstmt.executeUpdate();

							System.out.println("\nUpdated....\n");


							}catch(Exception e){
								e.printStackTrace();
							}
						break;
					}
				case 3:
					{
						//-----------------------------------------Show value-----------------------------------------
						try{
							System.out.println("\n\nThis is the Student table values : \n");
							String query = "select * from students";

							Statement stmt = con.createStatement();

							ResultSet set = stmt.executeQuery(query);
							System.out.println("\nstudentId : studentName : studentCity");
							while(set.next())
							{
								int id = set.getInt(1);
								String name = set.getString(2);
								String city = set.getString(3);

								System.out.println(id + " : " + name + " : " + city);
							}
							System.out.println();

						}catch(Exception e){
							e.printStackTrace();
						}
						break;
					}
				case 4:
					{
						//--------------------------------------Delete Table values-----------------------------------
						try{
							int deleteType=0;
							try{
								System.out.println("Delete have 2 Types delete Row or Total table data : ");
								System.out.println("\nEnter 1 for Delete Any Row : ");
								System.out.println("Enter 2 for Delete Full table Data : ");
								deleteType = sc.nextInt();

							}catch(Exception e){
								System.out.println("Please Enter Integer Value ");
							}
							System.out.println("\n\nThis is the Student table values : \n");
							String query = "select * from students";

							Statement stmt = con.createStatement();

							ResultSet set = stmt.executeQuery(query);
							System.out.println("\nstudentId : studentName : studentCity");
							while(set.next())
							{
								int id = set.getInt(1);
								String name = set.getString(2);
								String city = set.getString(3);

								System.out.println(id + " : " + name + " : " + city);
							}
							switch(deleteType)
							{
							case 1:
								{
									try{
										System.out.print("\n\nEnter student id : ");
										int studentID = sc.nextInt();

										String queryDelete = "delete from students where studentId = ?";
										PreparedStatement pstmt = con.prepareStatement(queryDelete);

										pstmt.setInt(1,studentID);

										pstmt.executeUpdate();

										System.out.println("\nDeleted....\n");

									}catch(Exception e){
										e.printStackTrace();
									}
									break;
								}
							case 2:
								{
									try{
										System.out.print("would you like to Delete All datas ? (YES/NO) : ");
										String deleteALL = br.readLine();
										switch(deleteALL){
											case "YES":{
												String queryDelete = "truncate table students";

												stmt.executeUpdate(queryDelete);

												System.out.println("All Data Deleted....");
												break;
											}
											case "NO":{
												System.out.println("\nOK\n");
												break;
											}
											default:{
												System.out.println("\nWrong Choice\n");
											}
										}

									}catch(Exception e){
										e.printStackTrace();
									}
									break;
								}
							default:
								{
									System.out.println("\nSorry Wrong Selection : " + deleteType + "\n");
								}
							}

						}catch(Exception e){
							e.printStackTrace();
						}
						break;
					}
				default:
					System.out.println("\nSorry wrong Selection : " + userChoice + "\n");
				}

			}
			}

			con.close();
		}catch(Exception e){
			System.out.println(e);
		}

	}
}