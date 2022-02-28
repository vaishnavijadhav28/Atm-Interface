package com.atm;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import com.atm.dao.AtmDBOpration;

public class login 
{

	
	

	public static void main(String[] args)
	{
		
		System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
		System.out.println("              Welcome To ABC ATM                ");
		System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
	   
		
		boolean status=true;
		
			
			
			try
			{
				Scanner scan=new Scanner(System.in);
				AtmDBOpration ad=new AtmDBOpration();
				
				System.out.println("\t Enter Pin");
				String pin=scan.next();
				
				
				boolean validUser=ad.login(pin);
				
				if(validUser)
				{


					System.out.println("\r\n "
							               + "1.Withdraw cash\r\n"
							               + "2.Deposite cash \r\n"
						            	   + "3.Mini Statement \r\n"
						            	   + "4.Check Balance \r\n"
						            	   + "5. Change Pin \r\n"
						            	   + "6.Exit");
						            	
							  
							           
					int opration=scan.nextInt();
					
					if(opration==1)
					{
						System.out.println("Enter Withdrawal amount:");
						Double WithdrawAmt=scan.nextDouble();
						System.out.println("===================================================");
						ad.withdraw(WithdrawAmt,pin);
						System.out.println("===================================================");
					}
					else if(opration==2)
					{
						System.out.println("Enter Deposite Amount:");
						Double DepositeAmt=scan.nextDouble();
						System.out.println("===================================================");
						ad.deposite(DepositeAmt,pin);
						System.out.println("===================================================");
					}
					else if(opration==3)
					{
					
				
						System.out.println("===========================================================================");
						System.out.println("tid"+"\t"+"pin"+"\t"+"transactiondate"+"\t"+"withdrawAmt"+"\t"+"depositeAmt");
						System.out.println("===========================================================================");
						
	
						ResultSet rs=ad.transaction(pin);
						
						while(rs.next())
						{
							System.out.println(rs.getLong(1)+"\t"+rs.getString(2)+"\t"+rs.getTimestamp(3)+"\t"+rs.getDouble(4)+"\t"+rs.getDouble(5));
						}
					}
					else if(opration==4)
					{
						System.out.println("======================================");
	    	       		ResultSet rs=ad.balancecheck(pin);
	    	       		while(rs.next())
	    	       		{
	    	       			System.out.println("balance:"+rs.getLong(5));
	    	       	     }
	    	       	     System.out.println("======================================");
					}
					
					else if(opration==5)
					{
						System.out.println("Enter usser id:");
	    	    		int uid=scan.nextInt();
	    	    		
						System.out.println("Enter new pin:");
	    	    		String newpin=scan.next();
	    	       		if(ad.changePassword(newpin,uid))
	    	       		{
	    	       			System.out.println("==================================================");
	    	    			System.out.println("Password changed successfully!!");
	    	    	       	System.out.println("==================================================");

	    	       		}
	    	       		else
	    	       		{
	    	       			System.out.println("====================================================");
	    	       		}
					}
					
					
					else if(opration==6)
	    	       	{
	    	       		ad.exit();
	    	       		status=false;
	    	       		System.out.println("=======================================");
	        			System.out.println("!!!!Thank You!!!!");
	        	       	System.out.println("=======================================");

	    	       	}
				}
				
			
			}
			catch(Exception e)
			{
			System.out.println(e.getMessage());	
			}
			
		
		
		}
		
	}


