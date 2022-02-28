package com.atm.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Savepoint;
import java.sql.Timestamp;
import java.util.Date;
import java.util.Random;

public class AtmDBOpration {
  
	
	DBConnection ob=new DBConnection();
	Connection conn=ob.connection();
	

	 synchronized public boolean login(String pin) throws SQLException
	{
		PreparedStatement stmt =conn.prepareStatement("select * from atmuser where pin=?");
		stmt.setString(1,pin);
		
		ResultSet result=stmt.executeQuery();
		if(result.next())
		{
			return true;
		}
		else
		{
			return false;	
		}
		
		
		
	}
	 synchronized public void withdraw(Double withdrawAmt,String pin)
	{
		try
		{
			PreparedStatement stmt=conn.prepareStatement("select * from atmuser where pin=?");
			stmt.setString(1, pin);
			ResultSet result=stmt.executeQuery();
			Double balance=0.0;
			while(result.next())
				{
				    balance=result.getDouble(5);
			     }
			if(withdrawAmt<=balance)
			{
				balance=balance-withdrawAmt;
				PreparedStatement stmt1=conn.prepareStatement("update atmuser set balance=?where pin=?");
				stmt1.setDouble(1,balance);
			    stmt1.setString(2, pin);
			    
				int affectedRows=stmt1.executeUpdate();
               stmt1=conn.prepareStatement("insert into transa values(?,?,?,?,?)");
				
				Random r=new Random();
				long tid=r.nextInt(9999);
				
				Date d=new Date();//java.util
				Timestamp transactiondate=new Timestamp(d.getTime());
				
			
				stmt1.setLong(1, tid);
				stmt1.setString(2, pin);
				stmt1.setTimestamp(3, transactiondate);
				
				stmt1.setDouble(4, withdrawAmt);
				double depositeAmt = 0;
				stmt1.setDouble(5, depositeAmt);
				
				if(affectedRows>0) 
				{
					System.out.println("Withdraw Successfully!!!");
					System.out.println("Remaining Balance:"+balance);
				}
				else
				{
					System.out.println("Problem in withdrawal Opration");
				}
			}
			else
			{
				System.out.println("Sufficient balance not available");
			}
			
		}
		catch(Exception e)
		{
			System.out.println("Something wents wrong!!!!");
		}
		
	}
	 synchronized public void deposite(Double depositeAmt,String pin) {

		
		try
		{
			PreparedStatement stmt=conn.prepareStatement("select * from atmuser where pin=?");
			stmt.setString(1, pin);
			ResultSet result=stmt.executeQuery();
			Double balance=0.0;
			while(result.next())
				{
				    balance=result.getDouble(5);
			     }
			
				balance=balance+depositeAmt;
				PreparedStatement stmt1=conn.prepareStatement("update atmuser set balance=?where pin=?");
				
				stmt1.setDouble(1,balance);
				stmt1.setString(2, pin);
				
                 
				int affectedRows=stmt1.executeUpdate();
				stmt1=conn.prepareStatement("insert into transa values(?,?,?,?,?)");
				
				Random r=new Random();
				long tid=r.nextInt(9999);
				
				Date d=new Date();//java.util
				Timestamp transactiondate=new Timestamp(d.getTime());
				
			
				stmt1.setLong(1, tid);
				stmt1.setString(2, pin);
				stmt1.setTimestamp(3, transactiondate);
				double withdrawAmt = 0;
				stmt1.setDouble(4, withdrawAmt);
				stmt1.setDouble(5, depositeAmt);
				
			
			
				if(affectedRows>0) 
				{
					System.out.println("Deposited Successfully!!!");
					System.out.println("Remaining Balance:"+balance);
				}
				else
				{
					System.out.println("Problem in Deposite Opration");
				}
			
		}
		catch(Exception e)
		{
			System.out.println("Something wents wrong!!!!");
		}
		
	}
	 synchronized public ResultSet balancecheck(String pin) {

		ResultSet rs=null;
	try {
		PreparedStatement pr= conn.prepareStatement("select * from atmuser where pin=?");
		pr.setString(1,pin);
		
		
		 rs=pr.executeQuery();
	}
		catch(Exception e)
	{
	     System.out.println("Invalid Pin..!!!!");		
	}
		return rs;
	}
	public void exit() throws SQLException {
		conn.close();
		
	}
	synchronized public ResultSet transaction(String pin) throws SQLException {
		
		ResultSet rs=null;
		try
		{
			PreparedStatement pr=conn.prepareStatement("select * from transa where pin=?");
			pr.setString(1, pin);
			rs=pr.executeQuery();
			
		
		
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
		
			System.out.println("Something went wrong");
	}
		return rs;
	}
	public boolean changePassword(String newpin, int uid) throws SQLException {
		{
			PreparedStatement stmt= conn.prepareStatement("update  atmuser set pin=? where uId=?");
			stmt.setString(1, newpin);
			stmt.setInt(2,uid);
			
			int affectedRows=stmt.executeUpdate();
			if(affectedRows>0)
			{
				return true;
			}
			else
				return false;
			
		
	}


	}	
	}


