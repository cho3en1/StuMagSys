package io.github.cho3en1.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import io.github.cho3en1.model.StuInfo;
import io.github.cho3en1.conn.Conn;

public class StuService {
	private Connection conn;
	private PreparedStatement pstmt;
	
	public boolean addStuInofo(StuInfo stu) throws ClassNotFoundException, SQLException {
		conn = new Conn().getConn();
		String sql = "insert into studentinfo (name, sex, birthday, major, course, hobby) values (?,?,?,?,?,?)";
		pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, stu.getName());
		pstmt.setByte(2, stu.getSex());
		pstmt.setString(3, stu.getBirthday());
		pstmt.setString(4, stu.getMajor());
		pstmt.setString(5, stu.getCourses());
		pstmt.setString(6, stu.getHobbys());
		pstmt.executeUpdate();
		return true;
	}
	
	public List queryAllStu() throws ClassNotFoundException, SQLException {
		List stus = new ArrayList();
		conn = new Conn().getConn();
		pstmt = conn.prepareStatement("select * from studentinfo");
		ResultSet rs = pstmt.executeQuery();
		while(rs.next()) {
			StuInfo stu = new StuInfo();
			stu.setId(rs.getInt(1));
			stu.setName(rs.getString(2));
			stu.setSex(rs.getByte(3));
			if(rs.getDate(4)!=null) {
				stu.setBirthday(rs.getDate(4).toString());
			}
			stu.setMajor(rs.getString(5));
			if(rs.getString(6)!=null) {
				stu.setCourse(rs.getString(6).split("&"));
			}
			if(rs.getString(7)!=null) {
				stu.setHobby(rs.getString(7).split("&"));
			}
			stus.add(stu);
		}
		return stus;
	}
	
	public StuInfo queryStuById(int id) throws ClassNotFoundException, SQLException {
		conn = new Conn().getConn();
		pstmt = conn.prepareStatement("select * from studentinfo where id=?");
		pstmt.setInt(1, id);
		ResultSet rs = pstmt.executeQuery();
		if(rs.next()) {
			StuInfo stu = new StuInfo();
			stu.setId(rs.getInt(1));
			stu.setName(rs.getString(2));
			stu.setSex(rs.getByte(3));
			if(rs.getDate(4)!=null) {
				stu.setBirthday(rs.getDate(4).toString());
			}
			stu.setMajor(rs.getString(5));
			if(rs.getString(6)!=null) {
				stu.setCourse(rs.getString(6).split("&"));
			}
			if(rs.getString(7)!=null) {
				stu.setHobby(rs.getString(7).split("&"));
			}
			return stu;
		}
		return null;
	}
	
	public boolean updateStuInofo(StuInfo stu) throws ClassNotFoundException, SQLException {
		conn = new Conn().getConn();
		String sql = "update studentinfo set name=?, sex=?, birthday=?, major=?, course=?, hobby=? where id=?";
		pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, stu.getName());
		pstmt.setByte(2, stu.getSex());
		pstmt.setString(3, stu.getBirthday());
		pstmt.setString(4, stu.getMajor());
		pstmt.setString(5, stu.getCourses());
		pstmt.setString(6, stu.getHobbys());
		pstmt.setInt(7, stu.getId());
		pstmt.executeUpdate();
		return true;
	}
	
	public boolean deleteStuInofo(int id) throws ClassNotFoundException, SQLException {
		conn = new Conn().getConn();
		String sql = "delete from studentinfo where id=?";
		pstmt = conn.prepareStatement(sql);
		pstmt.setInt(1, id);
		pstmt.executeUpdate();
		return true;
	}
}
