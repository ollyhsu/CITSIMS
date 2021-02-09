package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import model.Depart;
import util.JDBCUtil;

public class DepartDao {
	Connection conn;
	Statement stmt;
	PreparedStatement pstmt;
	ResultSet rs;
	//查看院系信息
	public List<Depart> selectAllDeparts() {
		// 定义sql语句
		String sql = "select * from tb_depart";
		// 获取数据库的连接
		conn = JDBCUtil.getConnection();
		List<Depart> departList = new ArrayList<Depart>();
		Depart depart = null;
		try {
			// 创建PreparedStatement对象
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				depart = new Depart();
				depart.setDpId(rs.getInt("departId"));
				depart.setDpName(rs.getString("departName"));
				departList.add(depart);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.close(conn, pstmt, pstmt, rs);
		}
		if (depart != null) {
			System.out.println("院系信息查询成功!");
		} else {
			System.out.println("没有院系信息!");
		}
		return departList;
	}
	//删除院系信息
	public int deleteDepartById(int departID) {
		// 定义sql语句
		String sql = "delete from tb_depart where departId=?";
		// 获取数据库的连接
		conn = JDBCUtil.getConnection();
		int num = 0;
		try {
			// 创建PreparedStatement对象
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, departID);
			num = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.close(conn, pstmt, pstmt, rs);
		}
		return num;
	}
	//添加院系信息
	public int addDepart(String departName) {
		// 定义SQL语句
		String sql = "insert into tb_depart values(default,?)";
		// 获取数据库连接
		conn = JDBCUtil.getConnection();
		int num = 0;
		try {
			// 创建PreparedStatement对象
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, departName);
			num = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.close(conn, pstmt, pstmt, rs);
		}
		return num;
	}
	//修改院系名称
	public int updateDepartNameById(String departName, int departId) {
		// 定义sql语句
		String sql = "update tb_depart set departName=? where departId=?";
		// 获取数据库的连接
		conn = JDBCUtil.getConnection();
		int num = 0;
		try {
			// 创建PreparedStatement对象
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, departName);
			pstmt.setInt(2, departId);
			num = pstmt.executeUpdate();
		} catch (SQLException e) {

			e.printStackTrace();
		} finally {
			JDBCUtil.close(conn, pstmt, pstmt, rs);
		}
		return num;
	}
}
