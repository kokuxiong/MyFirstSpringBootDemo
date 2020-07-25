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

import com.koku.pojo.Student;

@Repository
public class StudentDaoImpl implements StudentDao {

	@Override
	public List<Student> findAllStudent() {
		List<Student> studens = new ArrayList<>();
		// use jdbc to connect mysql(kokudb)
		String url = "jdbc:mysql://localhost/kokudb";
		String user = "root";
		String password = "123456";
		Connection conn = null;
		Statement statement = null;
		ResultSet rs = null;
		try {
			// get drivermanager
			Class.forName("com.mysql.cj.jdbc.Driver");
			// get connectiong
			conn = DriverManager.getConnection(url, user, password);
			// get statement
			statement = conn.createStatement();
			// sql to get all of student
			String studentAllSql = "select * from student";
			// get resultset
			rs = statement.executeQuery(studentAllSql);
			// loop fo resultset to get all of student
			while (rs.next()) {
				Student tempStu = new Student();
				// get id of student
				tempStu.setStu_id(rs.getInt("stu_id"));
				// get name of student
				tempStu.setStu_name(rs.getString("stu_name"));
				// get sex of student
				tempStu.setStu_sex(rs.getString("stu_sex"));
				// get birthday of student
				tempStu.setStu_birth(rs.getString("stu_birth"));
				// get teacherId of student
				tempStu.setTeacher_id(rs.getInt("teacher_id"));
				// add the student to the list for response
				studens.add(tempStu);
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			// do not forget to close the resultset,statement,connection
			try {
				rs.close();
				statement.close();
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		// return the list of the student
		return studens;
	}

	@Override
	public List<Student> findStudentsByTeacherId(int tid) {
		List<Student> studens = new ArrayList<>();
		// use jdbc to connect mysql(kokudb)
		String url = "jdbc:mysql://localhost/kokudb";
		String user = "root";
		String password = "123456";
		Connection conn = null;
		PreparedStatement statement = null;
		ResultSet rs = null;
		try {
			// get drivermanager
			Class.forName("com.mysql.cj.jdbc.Driver");
			// get connectiong
			conn = DriverManager.getConnection(url, user, password);
			// sql to get all of student by teacher id
			String studentAllSql = "select * from student where teacher_id = ?";
			statement = conn.prepareStatement(studentAllSql);
			statement.setInt(1, tid);
			// get resultset
			rs = statement.executeQuery();
			// loop fo resultset to get all of student
			while (rs.next()) {
				Student tempStu = new Student();
				// get id of student
				tempStu.setStu_id(rs.getInt("stu_id"));
				// get name of student
				tempStu.setStu_name(rs.getString("stu_name"));
				// get sex of student
				tempStu.setStu_sex(rs.getString("stu_sex"));
				// get birthday of student
				tempStu.setStu_birth(rs.getString("stu_birth"));
				// get teacherId of student
				tempStu.setTeacher_id(rs.getInt("teacher_id"));
				// add the student to the list for response
				studens.add(tempStu);
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			// do not forget to close the resultset,statement,connection
			try {
				rs.close();
				statement.close();
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		// return the list of the student
		return studens;
	}

	@Override
	public Student findStudentById(int id) {
		
		Student stu = new Student();
		String url="jdbc:mysql://localhost/kokudb";
		String user="root";
		String password="123456";
		Connection conn=null;
		PreparedStatement preStat=null;
		ResultSet rs = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = DriverManager.getConnection(url, user, password);
			String findStudentByIdSql="select * from student where stu_id = ? limit 1";
			preStat = conn.prepareStatement(findStudentByIdSql);
			preStat.setInt(1, id);
			rs=preStat.executeQuery();
			while (rs.next()) {
				stu.setStu_id(rs.getInt("stu_id"));
				stu.setStu_name(rs.getString("stu_name"));
				stu.setStu_sex(rs.getString("stu_sex"));
				stu.setStu_birth(rs.getString("stu_birth"));
				stu.setTeacher_id(rs.getInt("teacher_id"));
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//return the student that found by id
		return stu;
	}

	@Override
	public int addNewStudent(Student stu) {
		int rs = 0;
		String url = "jdbc:mysql://localhost/kokudb";
		String user = "root";
		String password = "123456";
		Connection conn = null;
		PreparedStatement preStat = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = DriverManager.getConnection(url, user, password);
			String sql = "insert into student(stu_name,stu_sex,stu_birth,teacher_id) values(?,?,?,?);";
			preStat = conn.prepareStatement(sql);
			preStat.setString(1, stu.getStu_name());
			preStat.setString(2, stu.getStu_sex());
			preStat.setString(3, stu.getStu_birth());
			preStat.setInt(4, stu.getTeacher_id());
			rs = preStat.executeUpdate();

		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
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
	public int updateStudent(Student stu) {
		
		int rs = 0;
		String url="jdbc:mysql://localhost/kokudb";
		String user="root";
		String password="123456";
		Connection conn = null;
		PreparedStatement preStat = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn=DriverManager.getConnection(url, user, password);
			String updateStudentSql="update student set stu_name = ?,stu_sex = ?,stu_birth = ?,teacher_id = ? where stu_id = ?";
			preStat = conn.prepareStatement(updateStudentSql);
			preStat.setString(1, stu.getStu_name());
			preStat.setString(2, stu.getStu_sex());
			preStat.setString(3, stu.getStu_birth());
			preStat.setInt(4, stu.getTeacher_id());
			preStat.setInt(5, stu.getStu_id());
			rs = preStat.executeUpdate();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return rs;
	}

	@Override
	public int deleteStudent(int id) {
		int rs = 0;
		Connection conn = null;
		PreparedStatement preStat = null;
		String url = "jdbc:mysql://localhost/kokudb";
		String user = "root";
		String password = "123456";
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = DriverManager.getConnection(url, user, password);
			String deleteStudentSql = "delete from student where stu_id = ?";
			preStat = conn.prepareStatement(deleteStudentSql);
			preStat.setInt(1, id);
			rs = preStat.executeUpdate();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return rs;
	}

}
