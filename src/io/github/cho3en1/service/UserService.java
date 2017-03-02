package io.github.cho3en1.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import io.github.cho3en1.model.UserTable;
import io.github.cho3en1.conn.Conn;

public class UserService {
	private Connection conn;
	private PreparedStatement pstmt;
	
	public boolean userValidate(UserTable user) throws ClassNotFoundException, SQLException {
		conn = new Conn().getConn();
		pstmt = conn.prepareStatement("select * from usertable where username=? and password=?");
		pstmt.setString(1, user.getUsername());
		pstmt.setString(2, user.getPassword());
		ResultSet rs = pstmt.executeQuery();
		if(rs.next()) {
			return true;
		}else {
			return false;
		}
	}
}
