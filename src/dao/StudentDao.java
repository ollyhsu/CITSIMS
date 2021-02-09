package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import model.Student;
import util.JDBCUtil;

public class StudentDao {
	Connection conn;
	Statement stmt;
	PreparedStatement pstmt;
	ResultSet rs;

	// 查看所有学生
	public List<Student> selectAllStudents() {
		// 定义sql语句
		String sql = "SELECT stuId,stuName,stuSex,stuBirth,tb_depart.departId,departName,tb_spec.specId,specName,tb_class.classId,className\n"
				+ "FROM tb_student,tb_depart,tb_spec,tb_class\n" + "WHERE tb_student.classId=tb_class.classId \n"
				+ "AND tb_class.specId=tb_spec.specId \n" + "AND tb_spec.departId=tb_depart.departId;";
		// 获取数据库的连接
		conn = JDBCUtil.getConnection();
		List<Student> stuList = new ArrayList<Student>();
		Student stu = null;
		try {
			// 创建PreparedStatement对象
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				stu = new Student();
				stu.setStuId(rs.getInt("stuId"));
				stu.setStuName(rs.getString("stuName"));
				stu.setStuSex(rs.getInt("stuSex"));
				stu.setStuBirth(rs.getDate("stuBirth"));
				stu.setDpId(rs.getInt("departId"));
				stu.setDpName(rs.getString("departName"));
				stu.setSpId(rs.getInt("specId"));
				stu.setSpName(rs.getString("specName"));
				stu.setClassId(rs.getInt("classId"));
				stu.setClassName(rs.getString("className"));
				stuList.add(stu);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.close(conn, pstmt, pstmt, rs);
		}
		if (stu != null) {
			System.out.println("学生信息查询成功!");
		} else {
			System.out.println("没有学生信息!");
		}
		return stuList;
	}

	// 按班级查看学生
	public List<Student> selectStuByClassId(int classID) {
		// 定义sql语句
		String sql = "SELECT stuId,stuName,stuSex,stuBirth,tb_depart.departId,departName,tb_spec.specId,specName,tb_class.classId,className\n"
				+ "FROM tb_student,tb_depart,tb_spec,tb_class\n" + "WHERE tb_student.classId=tb_class.classId \n"
				+ "AND tb_class.specId=tb_spec.specId \n" + "AND tb_spec.departId=tb_depart.departId\n"
				+ "AND tb_class.classId=?;";
		// 获取数据库的连接
		conn = JDBCUtil.getConnection();
		List<Student> stuList = new ArrayList<Student>();
		Student stu = null;
		try {
			// 创建PreparedStatement对象
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, classID);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				stu = new Student();
				stu.setStuId(rs.getInt("stuId"));
				stu.setStuName(rs.getString("stuName"));
				stu.setStuSex(rs.getInt("stuSex"));
				stu.setStuBirth(rs.getDate("stuBirth"));
				stu.setDpId(rs.getInt("departId"));
				stu.setDpName(rs.getString("departName"));
				stu.setSpId(rs.getInt("specId"));
				stu.setSpName(rs.getString("specName"));
				stu.setClassId(rs.getInt("classId"));
				stu.setClassName(rs.getString("className"));
				stuList.add(stu);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.close(conn, pstmt, pstmt, rs);
		}
		if (stu != null) {
			System.out.println("该班级下的学生信息查询成功!");
		} else {
			System.out.println("该班级下没有学生信息!\n");
		}
		return stuList;
	}

	// 按专业查看学生
	public List<Student> selectStuBySpecId(int specID) {
		// 定义sql语句
		String sql = "SELECT stuId,stuName,stuSex,stuBirth,tb_depart.departId,departName,tb_spec.specId,specName,tb_class.classId,className\n"
				+ "FROM tb_student,tb_depart,tb_spec,tb_class\n" + "WHERE tb_student.classId=tb_class.classId \n"
				+ "AND tb_class.specId=tb_spec.specId \n" + "AND tb_spec.departId=tb_depart.departId\n"
				+ "AND tb_spec.specId=?;";
		// 获取数据库的连接
		conn = JDBCUtil.getConnection();
		List<Student> stuList = new ArrayList<Student>();
		Student stu = null;
		try {
			// 创建PreparedStatement对象
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, specID);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				stu = new Student();
				stu.setStuId(rs.getInt("stuId"));
				stu.setStuName(rs.getString("stuName"));
				stu.setStuSex(rs.getInt("stuSex"));
				stu.setStuBirth(rs.getDate("stuBirth"));
				stu.setDpId(rs.getInt("departId"));
				stu.setDpName(rs.getString("departName"));
				stu.setSpId(rs.getInt("specId"));
				stu.setSpName(rs.getString("specName"));
				stu.setClassId(rs.getInt("classId"));
				stu.setClassName(rs.getString("className"));
				stuList.add(stu);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.close(conn, pstmt, pstmt, rs);
		}
		if (stu != null) {
			System.out.println("该专业下的学生信息查询成功!");
		} else {
			System.out.println("该专业下没有学生信息!\n");
		}
		return stuList;
	}

	// 按学院查看学生
	public List<Student> selectStuByDepartID(int departID) {
		// 定义sql语句
		String sql = "SELECT stuId,stuName,stuSex,stuBirth,tb_depart.departId,departName,tb_spec.specId,specName,tb_class.classId,className\n"
				+ "FROM tb_student,tb_depart,tb_spec,tb_class\n" + "WHERE tb_student.classId=tb_class.classId \n"
				+ "AND tb_class.specId=tb_spec.specId \n" + "AND tb_spec.departId=tb_depart.departId\n"
				+ "AND tb_depart.departId=?;";
		// 获取数据库的连接
		conn = JDBCUtil.getConnection();
		List<Student> stuList = new ArrayList<Student>();
		Student stu = null;
		try {
			// 创建PreparedStatement对象
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, departID);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				stu = new Student();
				stu.setStuId(rs.getInt("stuId"));
				stu.setStuName(rs.getString("stuName"));
				stu.setStuSex(rs.getInt("stuSex"));
				stu.setStuBirth(rs.getDate("stuBirth"));
				stu.setDpId(rs.getInt("departId"));
				stu.setDpName(rs.getString("departName"));
				stu.setSpId(rs.getInt("specId"));
				stu.setSpName(rs.getString("specName"));
				stu.setClassId(rs.getInt("classId"));
				stu.setClassName(rs.getString("className"));
				stuList.add(stu);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.close(conn, pstmt, pstmt, rs);
		}
		if (stu != null) {
			System.out.println("该学院下的学生信息查询成功!");
		} else {
			System.out.println("该学院下没有学生信息!\n");
		}
		return stuList;
	}

	// 按姓名查看学生
	public List<Student> selectStuByName(String stuName) {
		// 定义sql语句
		String sql = "SELECT stuId,stuName,stuSex,stuBirth,tb_depart.departId,departName,tb_spec.specId,specName,tb_class.classId,className\n"
				+ "FROM tb_student,tb_depart,tb_spec,tb_class\n" + "WHERE tb_student.classId=tb_class.classId \n"
				+ "AND tb_class.specId=tb_spec.specId \n" + "AND tb_spec.departId=tb_depart.departId\n"
				+ "AND stuName=?;";
		// 获取数据库的连接
		conn = JDBCUtil.getConnection();
		List<Student> stuList = new ArrayList<Student>();
		Student stu = null;
		try {
			// 创建PreparedStatement对象
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, stuName);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				stu = new Student();
				stu.setStuId(rs.getInt("stuId"));
				stu.setStuName(rs.getString("stuName"));
				stu.setStuSex(rs.getInt("stuSex"));
				stu.setStuBirth(rs.getDate("stuBirth"));
				stu.setDpId(rs.getInt("departId"));
				stu.setDpName(rs.getString("departName"));
				stu.setSpId(rs.getInt("specId"));
				stu.setSpName(rs.getString("specName"));
				stu.setClassId(rs.getInt("classId"));
				stu.setClassName(rs.getString("className"));
				stuList.add(stu);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.close(conn, pstmt, pstmt, rs);
		}
		if (stu != null) {
			System.out.println("学生信息查询成功!");
		} else {
			System.out.println("没有该姓名对应的学生信息!\n");
		}
		return stuList;
	}

	// 按学生ID查找学生
	public List<Student> selectStuById(int stuId) {
		// 定义sql语句
		String sql = "SELECT stuId,stuName,stuSex,stuBirth,tb_depart.departId,departName,tb_spec.specId,specName,tb_class.classId,className\n"
				+ "FROM tb_student,tb_depart,tb_spec,tb_class\n" + "WHERE tb_student.classId=tb_class.classId \n"
				+ "AND tb_class.specId=tb_spec.specId \n" + "AND tb_spec.departId=tb_depart.departId\n"
				+ "AND stuId=?;";
		// 获取数据库的连接
		conn = JDBCUtil.getConnection();
		List<Student> stuList = new ArrayList<Student>();
		Student stu = null;
		try {
			// 创建PreparedStatement对象
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, stuId);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				stu = new Student();
				stu.setStuId(rs.getInt("stuId"));
				stu.setStuName(rs.getString("stuName"));
				stu.setStuSex(rs.getInt("stuSex"));
				stu.setStuBirth(rs.getDate("stuBirth"));
				stu.setDpId(rs.getInt("departId"));
				stu.setDpName(rs.getString("departName"));
				stu.setSpId(rs.getInt("specId"));
				stu.setSpName(rs.getString("specName"));
				stu.setClassId(rs.getInt("classId"));
				stu.setClassName(rs.getString("className"));
				stuList.add(stu);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.close(conn, pstmt, pstmt, rs);
		}
		if (stu != null) {
			System.out.println("学生信息查询成功!");
		} else {
			System.out.println("没有该学号对应的学生信息!\n");
		}
		return stuList;
	}

	// 添加学生信息
	public int addStudents(String stuName, int stuSex, String stuBirth, int classId) {
		// 定义SQL语句
		String sql = "insert into tb_student values(default,?,?,?,?)";
		// 获取数据库连接
		conn = JDBCUtil.getConnection();
		int num = 0;
		try {
			// 创建PreparedStatement对象
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, stuName);
			pstmt.setInt(2, stuSex);
			pstmt.setString(3, stuBirth);
			pstmt.setInt(4, classId);
			num = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.close(conn, pstmt, pstmt, rs);
		}
		return num;
	}

	// 删除学生信息
	public int deleteStuById(int stuID) {
		// 定义sql语句
		String sql = "delete from tb_student where stuId=?";
		// 获取数据库的连接
		conn = JDBCUtil.getConnection();
		int num = 0;
		try {
			// 创建PreparedStatement对象
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, stuID);
			num = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.close(conn, pstmt, pstmt, rs);
		}
		return num;
	}

	// 仅修改学生姓名
	public int updateStuNameById(String stuName1, int stuId1) {
		// 定义sql语句
		String sql = "update tb_student set stuName=? where stuId=?";
		// 获取数据库的连接
		conn = JDBCUtil.getConnection();
		int num = 0;
		try {
			// 创建PreparedStatement对象
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, stuName1);
			pstmt.setInt(2, stuId1);
			num = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.close(conn, pstmt, pstmt, rs);
		}
		return num;
	}

	// 仅修改学生生日
	public int updateStuBirthById(String stuBirth2, int stuId2) {
		// 定义sql语句
		String sql = "update tb_student set stuBirth=? where stuId=?";
		// 获取数据库的连接
		conn = JDBCUtil.getConnection();
		int num = 0;
		try {
			// 创建PreparedStatement对象
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, stuBirth2);
			pstmt.setInt(2, stuId2);
			num = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.close(conn, pstmt, pstmt, rs);
		}
		return num;
	}

	// 仅修改学生班级
	public int updateStuClassById(int classId3, int stuId3) {
		// 定义sql语句
		String sql = "update tb_student set classId=? where stuId=?";
		// 获取数据库的连接
		conn = JDBCUtil.getConnection();
		int num = 0;
		try {
			// 创建PreparedStatement对象
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, classId3);
			pstmt.setInt(2, stuId3);
			num = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.close(conn, pstmt, pstmt, rs);
		}
		return num;
	}

	// 同时修改学生姓名、生日、班级
	public int updateStuInfoById(String stuName4, String stuBirth4, int classId4, int stuId4) {
		// 定义sql语句
		String sql = "update tb_student set stuName=?,stuBirth=?,classId=? where stuId=?";
		// 获取数据库的连接
		conn = JDBCUtil.getConnection();
		int num = 0;
		try {
			// 创建PreparedStatement对象
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, stuName4);
			pstmt.setString(2, stuBirth4);
			pstmt.setInt(3, classId4);
			pstmt.setInt(4, stuId4);
			num = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.close(conn, pstmt, pstmt, rs);
		}
		return num;
	}

}
