package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import model.Course;
import util.JDBCUtil;

public class CourseDao {
	Connection conn;
	Statement stmt;
	PreparedStatement pstmt;
	ResultSet rs;
	// 查看课程信息
	public List<Course> selectAllCourses() {
		// 定义sql语句
		String sql = "select * from tb_course";
		// 获取数据库的连接
		conn = JDBCUtil.getConnection();
		List<Course> courseList = new ArrayList<Course>();
		Course course = null;
		try {
			// 创建PreparedStatement对象
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				course = new Course();
				course.setCourseId(rs.getInt("courseId"));
				course.setCourseName(rs.getString("courseName"));
				course.setCourseScore(rs.getDouble("courseScore"));
				courseList.add(course);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.close(conn, pstmt, pstmt, rs);
		}
		if (course != null) {
			System.out.println("课程信息查询成功!");
		} else {
			System.out.println("没有课程信息!");
		}
		return courseList;
	}
	// 添加课程信息
	public int addCourse(String courseName, double courseScore) {
		// 定义SQL语句
		String sql = "insert into tb_course values(default,?,?)";
		// 获取数据库连接
		conn = JDBCUtil.getConnection();
		int num = 0;
		try {
			// 创建PreparedStatement对象
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, courseName);
			pstmt.setDouble(2, courseScore);
			num = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.close(conn, pstmt, pstmt, rs);
		}
		return num;
	}
	// 删除课程信息
	public int deleteCourseById(int courseID) {
		// 定义sql语句
		String sql = "delete from tb_course where courseId=?";
		// 获取数据库的连接
		conn = JDBCUtil.getConnection();
		int num = 0;
		try {
			// 创建PreparedStatement对象
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, courseID);
			num = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.close(conn, pstmt, pstmt, rs);
		}
		return num;
	}
	//仅修改课程名
	public int updateCoNameById(String coName1, int coId1) {
		// 定义sql语句
		String sql = "update tb_course set courseName=? where courseId=?";
		// 获取数据库的连接
		conn = JDBCUtil.getConnection();
		int num = 0;
		try {
			// 创建PreparedStatement对象
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, coName1);
			pstmt.setInt(2, coId1);
			num = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.close(conn, pstmt, pstmt, rs);
		}
		return num;
	}
	//仅修改课程学分
	public int updateCoScoreById(double coScore2, int coId2) {
		// 定义sql语句
		String sql = "update tb_course set courseScore=? where courseId=?";
		// 获取数据库的连接
		conn = JDBCUtil.getConnection();
		int num = 0;
		try {
			// 创建PreparedStatement对象
			pstmt = conn.prepareStatement(sql);
			pstmt.setDouble(1, coScore2);
			pstmt.setInt(2, coId2);
			num = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.close(conn, pstmt, pstmt, rs);
		}
		return num;
	}
	//同时修改课程名、课程学
	public int updateCoInfoById(String coName3, double coScore3, int coId3) {
		// 定义sql语句
		String sql = "update tb_course set courseName=?,courseScore=? where courseId=?";
		// 获取数据库的连接
		conn = JDBCUtil.getConnection();
		int num = 0;
		try {
			// 创建PreparedStatement对象
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, coName3);
			pstmt.setDouble(2, coScore3);
			pstmt.setInt(3, coId3);
			num = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.close(conn, pstmt, pstmt, rs);
		}
		return num;
	}
	

}
