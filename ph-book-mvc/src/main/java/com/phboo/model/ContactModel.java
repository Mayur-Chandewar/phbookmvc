package com.phboo.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.phbook.dto.Contact;
import com.phbook.util.DbConnectionUtil;

public class ContactModel {

	//save contact to Database
		public boolean SaveContact(Contact contact ) {
			boolean result = false;
			
			try {
				Connection c = DbConnectionUtil.getConnection();
			
				PreparedStatement stmt = c.prepareStatement("insert phbook values(0,?,?,?)");
				stmt.setString(1, contact.getFname());
				stmt.setString(2, contact.getLname());
				stmt.setString(3, contact.getContact());
				
				int count = stmt.executeUpdate();
				
				DbConnectionUtil.closeConnection(c);
				
				if(count >0) {
					return true;
				}
		
			} catch (Exception e) {
			
				e.printStackTrace();
			}
			
			
			return result; 
		}
		
		
		
		//get all contact from DataBase
		public List<Contact> getAll() 
		{
			List<Contact> list=new ArrayList<Contact>();
			try {
				Connection cg = DbConnectionUtil.getConnection();
				
				PreparedStatement stmtg= cg.prepareStatement("select * from phbook");
				
				ResultSet rs = stmtg.executeQuery();
				while(rs.next()) {
					Contact contactg=new Contact();
					contactg.setId(rs.getInt("id"));
					contactg.setFname(rs.getString("fname"));	
					contactg.setLname(rs.getString("lname"));
					contactg.setContact(rs.getString("contact"));
					list.add(contactg);
				}
				
				
				DbConnectionUtil.closeConnection(cg);
			}catch (Exception e) {
				e.printStackTrace();
			}
			
			
			return 	list;
		}
		
		//delete Contact (From View->1delete)
		public boolean deleteContact( int id) {
			boolean result = false;
			try {
				Connection cd= DbConnectionUtil.getConnection();
				PreparedStatement stmtd = cd.prepareStatement("delete from phbook where id=?");
				stmtd.setInt(1, id);
				int count = stmtd.executeUpdate();
				DbConnectionUtil.closeConnection(cd);
				if(count>=1) {
					result = true;
				}
			}catch(Exception e) {
				e.printStackTrace();
			}
			return result;
		}



		public Contact searchByName(String fname) {
			Contact contact = new Contact();
			try {
				Connection con = DbConnectionUtil.getConnection();
				PreparedStatement ps= con.prepareStatement("select * from phbook where fname=?");
				ps.setString(1, fname);
				
				ResultSet rs= ps.executeQuery();
				
				if(rs.next()) {
					
					contact.setFname(rs.getString("fname"));
					contact.setLname(rs.getString("lname"));
					contact.setContact(rs.getString("contact"));
				}
				DbConnectionUtil.closeConnection(con);
			} catch (Exception e) {
				e.printStackTrace();
			}
		
			
			
			return contact;
		}



		public Contact getById(int id) {
			Contact contact = new Contact();
			try {
				Connection con = DbConnectionUtil.getConnection();
				PreparedStatement ps= con.prepareStatement("select * from phbook where id=?");
				ps.setInt(1, id);
				
				ResultSet rs= ps.executeQuery();
				
				if(rs.next()) {
					contact.setId(rs.getInt("id"));
					contact.setFname(rs.getString("fname"));
					contact.setLname(rs.getString("lname"));
					contact.setContact(rs.getString("contact"));
				}
				
				DbConnectionUtil.closeConnection(con);
			} catch (Exception e) {
				e.printStackTrace();
			}
		
			
			
			return contact;

		}



		public boolean update(Contact ct) {
			boolean result=false;
			
			try {
				Connection con = DbConnectionUtil.getConnection();
				
				PreparedStatement pu = con.prepareStatement("update phbook set fname=?,lname=?,contact=? where id=? ");
				pu.setString(1, ct.getFname());
				pu.setString(2, ct.getLname());
				pu.setString(3, ct.getContact());
				pu.setInt(4,ct.getId());
				
				int count = pu.executeUpdate();
				
				if(count>0) {
					result=true;
				}
				
				DbConnectionUtil.closeConnection(con);
			} catch (Exception e) {
				e.printStackTrace();
			}
			
			return result;
		}
		
		
}
