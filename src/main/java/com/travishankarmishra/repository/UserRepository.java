package com.travishankarmishra.repository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import com.travishankarmishra.model.User;
import com.travishankarmishra.query.CustomQuery;
import com.travishankarmishra.service.UserService;

public class UserRepository extends CustomQuery implements UserService {
	Connection conn;
	Statement stm;
	PreparedStatement pstm;

	public UserRepository() {

		try {
			conn = DriverManager.getConnection(db_url, user_name, password);
			stm = conn.createStatement();
			stm.execute(user_create_query);
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

	@Override
	public boolean Insert(User u) {
		try {
			pstm = conn.prepareStatement("insert into admin(name,email,password,mobile,image) values (?,?,?,?,?)");
			pstm.setString(1, u.getName());
			pstm.setString(2, u.getEmail());
			pstm.setString(3, u.getPassword());
			pstm.setString(4, u.getMobile());
			pstm.setString(5, u.getImage());
			pstm.executeUpdate();
			return true;
		} catch (Exception e) {
			System.out.println(e);
		}
		return false;
	}

	@Override
	public String fetch(User u) {
		try {
			pstm = conn.prepareStatement("select name from admin where email=? and password=?");
			pstm.setString(1, u.getEmail());
			pstm.setString(2, u.getPassword());
			ResultSet set = pstm.executeQuery();
			if (set.next()) {
				return set.getString(1);
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return null;
	}

}
