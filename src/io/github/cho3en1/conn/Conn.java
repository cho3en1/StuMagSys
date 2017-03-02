package io.github.cho3en1.conn;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conn {
	public Connection getConn() throws ClassNotFoundException, SQLException {
		Class.forName("com.mysql.jdbc.Driver");
		String url = "jdbc:mysql://localhost/stumagsys?useUnicode=true&characterEncoding=utf-8";
		String user = "root";
		String password = "";
		Connection conn = DriverManager.getConnection(url, user, password);
		System.out.println(conn.getMetaData().getURL());
		return conn;
	}
}
