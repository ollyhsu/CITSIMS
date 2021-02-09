package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import model.Spec;
import util.JDBCUtil;

public class SpecDao {
	Connection conn;
	Statement stmt;
	PreparedStatement pstmt;
	ResultSet rs;
	// 查看专业信息
	public List<Spec> selectAllSpecs() {
		// 定义sql语句
		String sql = "SELECT tb_depart.departId,departName,specId,specName FROM tb_spec,tb_depart WHERE tb_spec.departId=tb_depart.departId ORDER BY departId;";
		// 获取数据库的连接
		conn = JDBCUtil.getConnection();
		List<Spec> specList = new ArrayList<Spec>();
		Spec spec = null;
		try {
			// 创建PreparedStatement对象
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				spec = new Spec();
				spec.setDpId(rs.getInt("departId"));
				spec.setDpName(rs.getString("departName"));
				spec.setSpId(rs.getInt("specId"));
				spec.setSpName(rs.getString("specName"));
				specList.add(spec);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.close(conn, pstmt, pstmt, rs);
		}
		if (spec != null) {
			System.out.println("专业信息查询成功!");
		} else {
			System.out.println("没有专业信息!");
		}
		return specList;
	}
	// 添加专业信息
	public int addSpec(String specName, int departId) {
		// 定义SQL语句
		String sql = "insert into tb_spec values(default,?,?)";
		// 获取数据库连接
		conn = JDBCUtil.getConnection();
		int num = 0;
		try {
			// 创建PreparedStatement对象
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, specName);
			pstmt.setInt(2, departId);
			num = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.close(conn, pstmt, pstmt, rs);
		}
		return num;
	}
	// 删除专业信息
	public int deleteSpecById(int specID) {
		// 定义sql语句
		String sql = "delete from tb_spec where specId=?";
		// 获取数据库的连接
		conn = JDBCUtil.getConnection();
		int num = 0;
		try {
			// 创建PreparedStatement对象
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, specID);
			num = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.close(conn, pstmt, pstmt, rs);
		}
		return num;
	}
	//修改专业名称
	public int updateSpecNameById(String specName, int specId) {
		// 定义sql语句
		String sql = "update tb_spec set specName=? where specId=?";
		// 获取数据库的连接
		conn = JDBCUtil.getConnection();
		int num = 0;
		try {
			// 创建PreparedStatement对象
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, specName);
			pstmt.setInt(2, specId);
			num = pstmt.executeUpdate();
		} catch (SQLException e) {

			e.printStackTrace();
		} finally {
			JDBCUtil.close(conn, pstmt, pstmt, rs);
		}
		return num;
	}
}
