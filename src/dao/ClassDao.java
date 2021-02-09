package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import model.Classes;
import util.JDBCUtil;

public class ClassDao {
	Connection conn;
	Statement stmt;
	PreparedStatement pstmt;
	ResultSet rs;

	// 查看所有班级
	public List<Classes> selectAllClasses() {
		// 定义sql语句
		String sql = "SELECT tb_depart.*,tb_spec.specId,specName,tb_class.classId,className\n"
				+ "FROM tb_depart,tb_spec,tb_class\n"
				+ "WHERE tb_class.specId=tb_spec.specId AND tb_spec.departId=tb_depart.departId;";
		// 获取数据库的连接
		conn = JDBCUtil.getConnection();
		List<Classes> classesList = new ArrayList<Classes>();
		Classes classes = null;
		try {
			// 创建PreparedStatement对象
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				classes = new Classes();
				classes.setDepartId(rs.getInt("departId"));
				classes.setDepartName(rs.getString("departName"));
				classes.setSpecId(rs.getInt("specId"));
				classes.setSpecName(rs.getString("specName"));
				classes.setClassId(rs.getInt("classId"));
				classes.setClassName(rs.getString("className"));
				classesList.add(classes);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.close(conn, pstmt, pstmt, rs);
		}
		if (classes != null) {
			System.out.println("班级信息查询成功!");
		} else {
			System.out.println("没有班级信息!");
		}
		return classesList;
	}
	// 按专业查看班级
	public List<Classes> selectClassesBySpecID(int specID) {
		// 定义sql语句
		String sql = "SELECT tb_depart.*,tb_spec.specId,specName,tb_class.classId,className\n"
				+ "FROM tb_depart,tb_spec,tb_class\n"
				+ "WHERE tb_class.specId=tb_spec.specId AND tb_spec.departId=tb_depart.departId "
				+ "AND tb_spec.specId=?";
		// 获取数据库的连接
		conn = JDBCUtil.getConnection();
		List<Classes> classesList = new ArrayList<Classes>();
		Classes classes = null;
		try {
			// 创建PreparedStatement对象
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, specID);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				classes = new Classes();
				classes.setDepartId(rs.getInt("departId"));
				classes.setDepartName(rs.getString("departName"));
				classes.setSpecId(rs.getInt("specId"));
				classes.setSpecName(rs.getString("specName"));
				classes.setClassId(rs.getInt("classId"));
				classes.setClassName(rs.getString("className"));
				classesList.add(classes);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.close(conn, pstmt, pstmt, rs);
		}
		if (classes != null) {
			System.out.println("该专业下的班级信息查询成功!");
		} else {
			System.out.println("该专业下没有班级信息!\n");
		}
		return classesList;
	}
	// 按院系查看班级
	public List<Classes> selectClassesByDepartID(int departID) {
		// 定义sql语句
		String sql = "SELECT tb_depart.*,tb_spec.specId,specName,tb_class.classId,className\n"
				+ "FROM tb_depart,tb_spec,tb_class\n"
				+ "WHERE tb_class.specId=tb_spec.specId AND tb_spec.departId=tb_depart.departId "
				+ "AND tb_depart.departId=?";
		// 获取数据库的连接
		conn = JDBCUtil.getConnection();
		List<Classes> classesList = new ArrayList<Classes>();
		Classes classes = null;
		try {
			// 创建PreparedStatement对象
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, departID);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				classes = new Classes();
				classes.setDepartId(rs.getInt("departId"));
				classes.setDepartName(rs.getString("departName"));
				classes.setSpecId(rs.getInt("specId"));
				classes.setSpecName(rs.getString("specName"));
				classes.setClassId(rs.getInt("classId"));
				classes.setClassName(rs.getString("className"));
				classesList.add(classes);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.close(conn, pstmt, pstmt, rs);
		}
		if (classes != null) {
			System.out.println("该学院下的班级信息查询成功!");
		} else {
			System.out.println("该学院下没有班级信息!");
		}
		return classesList;
	}

	// 添加班级信息
	public int addClasses(String className, int spceId) {
		// 定义SQL语句
		String sql = "insert into tb_class values(default,?,?)";
		// 获取数据库连接
		conn = JDBCUtil.getConnection();
		int num = 0;
		try {
			// 创建PreparedStatement对象
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, className);
			pstmt.setInt(2, spceId);
			num = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.close(conn, pstmt, pstmt, rs);
		}
		return num;
	}

	// 删除班级信息
	public int deleteClassById(int classID) {
		// 定义sql语句
		String sql = "delete from tb_class where classId=?";
		// 获取数据库的连接
		conn = JDBCUtil.getConnection();
		int num = 0;
		try {
			// 创建PreparedStatement对象
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, classID);
			num = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.close(conn, pstmt, pstmt, rs);
		}
		return num;
	}

	// 修改班级名称
	public int updateClassNameById(String className, int classId) {
		// 定义sql语句
		String sql = "update tb_class set className=? where classId=?";
		// 获取数据库的连接
		conn = JDBCUtil.getConnection();
		int num = 0;
		try {
			// 创建PreparedStatement对象
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, className);
			pstmt.setInt(2, classId);
			num = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.close(conn, pstmt, pstmt, rs);
		}
		return num;
	}
	
}
