package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import model.User;
import util.JDBCUtil;

public class UserDao {
	Connection conn;
	Statement stmt;
	PreparedStatement pstmt;
	ResultSet rs;

	// 根据用户名密码添加用户，用户类型默认值为1:普通用户（注册用户）
	public int addUser(String uname, String upwd) {
		// 定义SQL语句
		String sql = "insert into tb_user values(default,?,?,default)";
		// 获取数据库连接
		conn = JDBCUtil.getConnection();
		int num = 0;
		try {
			// 创建PreparedStatement对象
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, uname);
			pstmt.setString(2, upwd);
			num = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.close(conn, pstmt, pstmt, rs);
		}
		return num;
	}

	// 根据用户名密码查找用户（用户登录）
	public User selectUserByNamePwd(String uname, String upwd) {
		// 定义SQL语句
		String sql = "select * from tb_user where userName=? and userPwd=?";
		// 获取数据库连接
		conn = JDBCUtil.getConnection();
		User user = null;
		try {
			// 创建PreparedStatement对象
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, uname);
			pstmt.setString(2, upwd);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				user = new User();
				user.setUid(rs.getInt("userId"));
				user.setuName(rs.getString("userName"));
				user.setuPwd(rs.getString("userPwd"));
				user.setuType(rs.getInt("userType"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.close(conn, pstmt, pstmt, rs);
		}
		return user;
	}

	// 查询所有用户信息
	public List<User> selectAllUsers() {
		// 定义sql语句
		String sql = "select * from tb_user";
		// 获取数据库的连接
		conn = JDBCUtil.getConnection();
		List<User> userList = new ArrayList<User>();
		User user = null;
		try {
			// 创建PreparedStatement对象
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				user = new User();
				user.setUid(rs.getInt("userId"));
				user.setuName(rs.getString("userName"));
				user.setuPwd(rs.getString("userPwd"));
				user.setuType(rs.getInt("userType"));
				userList.add(user);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.close(conn, pstmt, pstmt, rs);
		}
		return userList;
	}

	// 修改用户密码
	public int updateUserByName(String userName, String upwd) {
		// 定义sql语句
		String sql = "update tb_user set userPwd=? where userName=?";
		// 获取数据库的连接
		conn = JDBCUtil.getConnection();
		int num = 0;
		try {
			// 创建PreparedStatement对象
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, upwd);
			pstmt.setString(2, userName);
			num = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.close(conn, pstmt, pstmt, rs);
		}
		return num;
	}

	// 删除用户信息
	public int deleteUserByName(String userName) {
		// 定义sql语句
		String sql = "delete from tb_user where userName=?";
		// 获取数据库的连接
		conn = JDBCUtil.getConnection();
		int num = 0;
		try {
			// 创建PreparedStatement对象
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, userName);
			num = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.close(conn, pstmt, pstmt, rs);
		}
		return num;
	}

	// 修改用户权限
	public int updateUserTypeByName(String userName, int utype) {
		// 定义sql语句
		String sql = "update tb_user set userType=? where userName=?";
		// 获取数据库的连接
		conn = JDBCUtil.getConnection();
		int num = 0;
		try {
			// 创建PreparedStatement对象
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, utype);
			pstmt.setString(2, userName);
			num = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.close(conn, pstmt, pstmt, rs);
		}
		return num;
	}
	/*******************************以下为普通用户功能方法*************************************/
	//普通用户修改个人密码
	public int updateMyPwd(User user, String upwd) {
		// 定义sql语句
		String sql = "update tb_user set userPwd=? where userName=?";
		// 获取数据库的连接
		conn = JDBCUtil.getConnection();
		int num = 0;
		try {
			// 创建PreparedStatement对象
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, upwd);
			pstmt.setString(2, user.getuName());
			num = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.close(conn, pstmt, pstmt, rs);
		}
		return num;
	}

	
	
	
}
