package com.koku.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.koku.pojo.Teacher;

@Repository
public class TeacherDaoImpl implements TeacherDao {

	@Override
	public List<Teacher> findAllTeacher() {
		
		List<Teacher> teachers = new ArrayList<>();
		Connection conn = null;
		Statement stat = null;
		ResultSet rs = null;
		String url = "jdbc:mysql://localhost/kokudb";
		String user = "root";
		String password = "123456";
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = DriverManager.getConnection(url, user, password);
			stat = conn.createStatement();
			String allTeacherSql = "select * from teacher";
			rs = stat.executeQuery(allTeacherSql);
			while(rs.next()) {
				Teacher tea = new Teacher();
				tea.setTea_id(rs.getInt("tea_id"));
				tea.setTea_name(rs.getString("tea_name"));
				tea.setTea_sex(rs.getString("tea_sex"));
				tea.setTea_lesson(rs.getString("tea_lesson"));
				tea.setTea_birth(rs.getString("tea_birth"));
				tea.setTea_comment(rs.getString("tea_comment"));
				teachers.add(tea);
			}
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				rs.close();
				stat.close();
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return teachers;
	}

	@Override
	public Teacher findTeacherById(int id) {
		Teacher tea = new Teacher();
		String url = "jdbc:mysql://localhost/kokudb";
		String user = "root";
		String password = "123456";
		Connection conn = null;
		PreparedStatement preStat = null;
		ResultSet rs = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = DriverManager.getConnection(url,user,password);
			String findTeacherByIdSql = "select * from teacher where tea_id = ? limit 1";
			preStat = conn.prepareStatement(findTeacherByIdSql);
			preStat.setInt(1, id);
			rs = preStat.executeQuery();
			while(rs.next()) {
				tea.setTea_id(rs.getInt("tea_id"));
				tea.setTea_name(rs.getString("tea_name"));
				tea.setTea_sex(rs.getString("tea_sex"));
				tea.setTea_lesson(rs.getString("tea_lesson"));
				tea.setTea_birth(rs.getString("tea_birth"));
				tea.setTea_comment(rs.getString("tea_comment"));
			}
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				rs.close();
				preStat.close();
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
		return tea;
	}

	@Override
	public int addTeacher(Teacher tea) {
		int rs = 0;
		String url = "jdbc:mysql://localhost/kokudb";
		String user = "root";
		String password = "123456";
		Connection conn = null;
		PreparedStatement preStat = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = DriverManager.getConnection(url, user, password);
			String addTeacherSql = "insert into teacher(tea_name,tea_sex,tea_lesson,tea_birth,tea_comment) values(?,?,?,?,?)";
			preStat = conn.prepareStatement(addTeacherSql);
			preStat.setString(1, tea.getTea_name());
			preStat.setString(2, tea.getTea_sex());
			preStat.setString(3, tea.getTea_lesson());
			preStat.setString(4, tea.getTea_birth());
			preStat.setString(5, tea.getTea_comment());
			rs = preStat.executeUpdate();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				preStat.close();
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return rs;
	}

	@Override
	public int updateTeacher(Teacher tea) {
		int rs = 0;
		String url = "jdbc:mysql://localhost/kokudb";
		String user = "root";
		String password = "123456";
		Connection conn = null;
		PreparedStatement preStat = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = DriverManager.getConnection(url, user, password);
			String addTeacherSql = "update teacher set tea_name = ?,tea_sex = ?,tea_lesson = ?,tea_birth = ?,tea_comment = ? where tea_id = ?";
			preStat = conn.prepareStatement(addTeacherSql);
			preStat.setString(1, tea.getTea_name());
			preStat.setString(2, tea.getTea_sex());
			preStat.setString(3, tea.getTea_lesson());
			preStat.setString(4, tea.getTea_birth());
			preStat.setString(5, tea.getTea_comment());
			preStat.setInt(6, tea.getTea_id());
			rs = preStat.executeUpdate();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				preStat.close();
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return rs;
	}

	@Override
	public int deleteTeacher(int id) {
		int rs = 0;
		String url = "jdbc:mysql://localhost/kokudb";
		String user = "root";
		String password = "123456";
		Connection conn = null;
		PreparedStatement preStat = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = DriverManager.getConnection(url, user, password);
			String addTeacherSql = "delete from teacher where tea_id = ?";
			preStat = conn.prepareStatement(addTeacherSql);
			preStat.setInt(1, id);
			rs = preStat.executeUpdate();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				preStat.close();
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return rs;
	}

}
