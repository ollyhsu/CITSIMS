package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import model.Score;
import util.JDBCUtil;

public class ScoreDao {
	Connection conn;
	Statement stmt;
	PreparedStatement pstmt;
	ResultSet rs;

	// 查看所有成绩
	public List<Score> selectAllScores() {
		// 定义sql语句
		String sql = "SELECT scoreId,departName,specName,className,tb_student.stuId,stuName,stuSex,courseName,score\n"
				+ "FROM tb_score,tb_student,tb_course,tb_class,tb_spec,tb_depart\n"
				+ "WHERE tb_score.stuId=tb_student.stuId\n" + "AND tb_score.courseId=tb_course.courseId \n"
				+ "AND tb_student.classId=tb_class.classId\n" + "AND tb_class.specId=tb_spec.specId \n"
				+ "AND tb_spec.departId=tb_depart.departId;";
		// 获取数据库的连接
		conn = JDBCUtil.getConnection();
		List<Score> scoList = new ArrayList<Score>();
		Score sco = null;
		try {
			// 创建PreparedStatement对象
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				sco = new Score();
				sco.setScoreId(rs.getInt("scoreId"));
				sco.setDepartName(rs.getString("departName"));
				sco.setSpecName(rs.getString("specName"));
				sco.setClassName(rs.getString("className"));
				sco.setStuId(rs.getInt("stuId"));
				sco.setStuName(rs.getString("stuName"));
				sco.setStuSex(rs.getInt("stuSex"));
				sco.setCourseName(rs.getString("courseName"));
				sco.setScore(rs.getDouble("score"));
				scoList.add(sco);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.close(conn, pstmt, pstmt, rs);
		}
		if (sco != null) {
			System.out.println("学生成绩查询成功!");
		} else {
			System.out.println("没有学生成绩信息!");
		}
		return scoList;
	}

	// 按姓名查找成绩
	public List<Score> selectScoresByName(String stuName) {
		// 定义sql语句
		String sql = "SELECT scoreId,departName,specName,className,tb_student.stuId,stuName,stuSex,courseName,score\n"
				+ "FROM tb_score,tb_student,tb_course,tb_class,tb_spec,tb_depart\n"
				+ "WHERE tb_score.stuId=tb_student.stuId\n" + "AND tb_score.courseId=tb_course.courseId \n"
				+ "AND tb_student.classId=tb_class.classId\n" + "AND tb_class.specId=tb_spec.specId \n"
				+ "AND tb_spec.departId=tb_depart.departId\n" + "AND tb_student.stuName=?";
		// 获取数据库的连接
		conn = JDBCUtil.getConnection();
		List<Score> scoList = new ArrayList<Score>();
		Score sco = null;
		try {
			// 创建PreparedStatement对象
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, stuName);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				sco = new Score();
				sco.setScoreId(rs.getInt("scoreId"));
				sco.setDepartName(rs.getString("departName"));
				sco.setSpecName(rs.getString("specName"));
				sco.setClassName(rs.getString("className"));
				sco.setStuId(rs.getInt("stuId"));
				sco.setStuName(rs.getString("stuName"));
				sco.setStuSex(rs.getInt("stuSex"));
				sco.setCourseName(rs.getString("courseName"));
				sco.setScore(rs.getDouble("score"));
				scoList.add(sco);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.close(conn, pstmt, pstmt, rs);
		}
		if (sco != null) {
			System.out.println("学生成绩查询成功!");
		} else {
			System.out.println("没有该姓名对应的学生成绩信息!\n");
		}
		return scoList;
	}

	// 降序输出课程成绩
	public List<Score> selectScoresByCourseDesc(int courseID) {
		// 定义sql语句
		String sql = "SELECT scoreId,departName,specName,className,tb_student.stuId,stuName,stuSex,courseName,score\n"
				+ "FROM tb_score,tb_student,tb_course,tb_class,tb_spec,tb_depart\n"
				+ "WHERE tb_score.stuId=tb_student.stuId\n" + "AND tb_score.courseId=tb_course.courseId \n"
				+ "AND tb_student.classId=tb_class.classId\n" + "AND tb_class.specId=tb_spec.specId \n"
				+ "AND tb_spec.departId=tb_depart.departId\n" + "AND tb_score.courseId=? \n" + "ORDER BY score DESC;";
		// 获取数据库的连接
		conn = JDBCUtil.getConnection();
		List<Score> scoList = new ArrayList<Score>();
		Score sco = null;
		try {
			// 创建PreparedStatement对象
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, courseID);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				sco = new Score();
				sco.setScoreId(rs.getInt("scoreId"));
				sco.setDepartName(rs.getString("departName"));
				sco.setSpecName(rs.getString("specName"));
				sco.setClassName(rs.getString("className"));
				sco.setStuId(rs.getInt("stuId"));
				sco.setStuName(rs.getString("stuName"));
				sco.setStuSex(rs.getInt("stuSex"));
				sco.setCourseName(rs.getString("courseName"));
				sco.setScore(rs.getDouble("score"));
				scoList.add(sco);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.close(conn, pstmt, pstmt, rs);
		}
		if (sco != null) {
			System.out.println("课程成绩查询成功!");
		} else {
			System.out.println("该课程没有学生成绩信息!\n");
		}
		return scoList;
	}

	// 升序输出课程成绩
	public List<Score> selectScoresByCourseAsc(int courseID) {
		// 定义sql语句
		String sql = "SELECT scoreId,departName,specName,className,tb_student.stuId,stuName,stuSex,courseName,score\n"
				+ "FROM tb_score,tb_student,tb_course,tb_class,tb_spec,tb_depart\n"
				+ "WHERE tb_score.stuId=tb_student.stuId\n" + "AND tb_score.courseId=tb_course.courseId \n"
				+ "AND tb_student.classId=tb_class.classId\n" + "AND tb_class.specId=tb_spec.specId \n"
				+ "AND tb_spec.departId=tb_depart.departId\n" + "AND tb_score.courseId=? \n" + "ORDER BY score ASC;";
		// 获取数据库的连接
		conn = JDBCUtil.getConnection();
		List<Score> scoList = new ArrayList<Score>();
		Score sco = null;
		try {
			// 创建PreparedStatement对象
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, courseID);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				sco = new Score();
				sco.setScoreId(rs.getInt("scoreId"));
				sco.setDepartName(rs.getString("departName"));
				sco.setSpecName(rs.getString("specName"));
				sco.setClassName(rs.getString("className"));
				sco.setStuId(rs.getInt("stuId"));
				sco.setStuName(rs.getString("stuName"));
				sco.setStuSex(rs.getInt("stuSex"));
				sco.setCourseName(rs.getString("courseName"));
				sco.setScore(rs.getDouble("score"));
				scoList.add(sco);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.close(conn, pstmt, pstmt, rs);
		}
		if (sco != null) {
			System.out.println("课程成绩查询成功!");
		} else {
			System.out.println("该课程没有学生成绩信息!\n");
		}
		return scoList;
	}

	// 降序输出班级成绩
	public List<Score> selectScoresByClassDesc(int classID) {
		// 定义sql语句
		String sql = "SELECT scoreId,departName,specName,className,tb_student.stuId,stuName,stuSex,courseName,score\n"
				+ "FROM tb_score,tb_student,tb_course,tb_class,tb_spec,tb_depart\n"
				+ "WHERE tb_score.stuId=tb_student.stuId\n" + "AND tb_score.courseId=tb_course.courseId \n"
				+ "AND tb_student.classId=tb_class.classId\n" + "AND tb_class.specId=tb_spec.specId \n"
				+ "AND tb_spec.departId=tb_depart.departId\n" + "AND tb_class.classId=?\n" + "ORDER BY score DESC;";
		// 获取数据库的连接
		conn = JDBCUtil.getConnection();
		List<Score> scoList = new ArrayList<Score>();
		Score sco = null;
		try {
			// 创建PreparedStatement对象
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, classID);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				sco = new Score();
				sco.setScoreId(rs.getInt("scoreId"));
				sco.setDepartName(rs.getString("departName"));
				sco.setSpecName(rs.getString("specName"));
				sco.setClassName(rs.getString("className"));
				sco.setStuId(rs.getInt("stuId"));
				sco.setStuName(rs.getString("stuName"));
				sco.setStuSex(rs.getInt("stuSex"));
				sco.setCourseName(rs.getString("courseName"));
				sco.setScore(rs.getDouble("score"));
				scoList.add(sco);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.close(conn, pstmt, pstmt, rs);
		}
		if (sco != null) {
			System.out.println("课程成绩查询成功!");
		} else {
			System.out.println("该课程没有学生成绩信息!\n");
		}
		return scoList;
	}

	// 升序输出班级成绩
	public List<Score> selectScoresByClassAsc(int classID) {
		// 定义sql语句
		String sql = "SELECT scoreId,departName,specName,className,tb_student.stuId,stuName,stuSex,courseName,score\n"
				+ "FROM tb_score,tb_student,tb_course,tb_class,tb_spec,tb_depart\n"
				+ "WHERE tb_score.stuId=tb_student.stuId\n" + "AND tb_score.courseId=tb_course.courseId \n"
				+ "AND tb_student.classId=tb_class.classId\n" + "AND tb_class.specId=tb_spec.specId \n"
				+ "AND tb_spec.departId=tb_depart.departId\n" + "AND tb_class.classId=?\n" + "ORDER BY score ASC;";
		// 获取数据库的连接
		conn = JDBCUtil.getConnection();
		List<Score> scoList = new ArrayList<Score>();
		Score sco = null;
		try {
			// 创建PreparedStatement对象
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, classID);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				sco = new Score();
				sco.setScoreId(rs.getInt("scoreId"));
				sco.setDepartName(rs.getString("departName"));
				sco.setSpecName(rs.getString("specName"));
				sco.setClassName(rs.getString("className"));
				sco.setStuId(rs.getInt("stuId"));
				sco.setStuName(rs.getString("stuName"));
				sco.setStuSex(rs.getInt("stuSex"));
				sco.setCourseName(rs.getString("courseName"));
				sco.setScore(rs.getDouble("score"));
				scoList.add(sco);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.close(conn, pstmt, pstmt, rs);
		}
		if (sco != null) {
			System.out.println("班级成绩查询成功!");
		} else {
			System.out.println("该班级没有学生成绩信息!\n");
		}
		return scoList;
	}

	// 降序输出专业成绩
	public List<Score> selectScoresBySpecDesc(int specID) {
		// 定义sql语句
		String sql = "SELECT scoreId,departName,specName,className,tb_student.stuId,stuName,stuSex,courseName,score\n"
				+ "FROM tb_score,tb_student,tb_course,tb_class,tb_spec,tb_depart\n"
				+ "WHERE tb_score.stuId=tb_student.stuId\n" + "AND tb_score.courseId=tb_course.courseId \n"
				+ "AND tb_student.classId=tb_class.classId\n" + "AND tb_class.specId=tb_spec.specId \n"
				+ "AND tb_spec.departId=tb_depart.departId\n" + "AND tb_spec.specId=?\n"
				+ "ORDER BY tb_course.courseId,score DESC;";
		// 获取数据库的连接
		conn = JDBCUtil.getConnection();
		List<Score> scoList = new ArrayList<Score>();
		Score sco = null;
		try {
			// 创建PreparedStatement对象
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, specID);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				sco = new Score();
				sco.setScoreId(rs.getInt("scoreId"));
				sco.setDepartName(rs.getString("departName"));
				sco.setSpecName(rs.getString("specName"));
				sco.setClassName(rs.getString("className"));
				sco.setStuId(rs.getInt("stuId"));
				sco.setStuName(rs.getString("stuName"));
				sco.setStuSex(rs.getInt("stuSex"));
				sco.setCourseName(rs.getString("courseName"));
				sco.setScore(rs.getDouble("score"));
				scoList.add(sco);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.close(conn, pstmt, pstmt, rs);
		}
		if (sco != null) {
			System.out.println("专业成绩查询成功!");
		} else {
			System.out.println("该专业没有学生成绩信息!\n");
		}
		return scoList;
	}

	// 升序输出专业成绩
	public List<Score> selectScoresBySpecAsc(int specID) {
		// 定义sql语句
		String sql = "SELECT scoreId,departName,specName,className,tb_student.stuId,stuName,stuSex,courseName,score\n"
				+ "FROM tb_score,tb_student,tb_course,tb_class,tb_spec,tb_depart\n"
				+ "WHERE tb_score.stuId=tb_student.stuId\n" + "AND tb_score.courseId=tb_course.courseId \n"
				+ "AND tb_student.classId=tb_class.classId\n" + "AND tb_class.specId=tb_spec.specId \n"
				+ "AND tb_spec.departId=tb_depart.departId\n" + "AND tb_spec.specId=?\n"
				+ "ORDER BY tb_course.courseId,score ASC;";
		// 获取数据库的连接
		conn = JDBCUtil.getConnection();
		List<Score> scoList = new ArrayList<Score>();
		Score sco = null;
		try {
			// 创建PreparedStatement对象
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, specID);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				sco = new Score();
				sco.setScoreId(rs.getInt("scoreId"));
				sco.setDepartName(rs.getString("departName"));
				sco.setSpecName(rs.getString("specName"));
				sco.setClassName(rs.getString("className"));
				sco.setStuId(rs.getInt("stuId"));
				sco.setStuName(rs.getString("stuName"));
				sco.setStuSex(rs.getInt("stuSex"));
				sco.setCourseName(rs.getString("courseName"));
				sco.setScore(rs.getDouble("score"));
				scoList.add(sco);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.close(conn, pstmt, pstmt, rs);
		}
		if (sco != null) {
			System.out.println("专业成绩查询成功!");
		} else {
			System.out.println("该专业没有学生成绩信息!\n");
		}
		return scoList;
	}

	// 统计不及格学生
	public List<Score> selectStuWhoFailed() {
		// 定义sql语句
		String sql = "SELECT scoreId,departName,specName,className,tb_student.stuId,stuName,stuSex,courseName,score\n"
				+ "FROM tb_score,tb_student,tb_course,tb_class,tb_spec,tb_depart\n"
				+ "WHERE tb_score.stuId=tb_student.stuId\n" + "AND tb_score.courseId=tb_course.courseId \n"
				+ "AND tb_student.classId=tb_class.classId\n" + "AND tb_class.specId=tb_spec.specId \n"
				+ "AND tb_spec.departId=tb_depart.departId\n" + "AND score<60\n" + "ORDER BY score ASC ;";
		// 获取数据库的连接
		conn = JDBCUtil.getConnection();
		List<Score> scoList = new ArrayList<Score>();
		Score sco = null;
		try {
			// 创建PreparedStatement对象
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				sco = new Score();
				sco.setScoreId(rs.getInt("scoreId"));
				sco.setDepartName(rs.getString("departName"));
				sco.setSpecName(rs.getString("specName"));
				sco.setClassName(rs.getString("className"));
				sco.setStuId(rs.getInt("stuId"));
				sco.setStuName(rs.getString("stuName"));
				sco.setStuSex(rs.getInt("stuSex"));
				sco.setCourseName(rs.getString("courseName"));
				sco.setScore(rs.getDouble("score"));
				scoList.add(sco);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.close(conn, pstmt, pstmt, rs);
		}
		if (sco != null) {
			System.out.println("学生成绩查询成功!");
		} else {
			System.out.println("没有学生成绩信息!");
		}
		return scoList;
	}

	// 录入成绩信息
	public int addScores(int courseId, int stuId, double score) {
		// 定义SQL语句
		String sql = "insert into tb_score values(default,?,?,?)";
		// 获取数据库连接
		conn = JDBCUtil.getConnection();
		int num = 0;
		try {
			// 创建PreparedStatement对象
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, courseId);
			pstmt.setInt(2, stuId);
			pstmt.setDouble(3, score);
			num = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.close(conn, pstmt, pstmt, rs);
		}
		return num;
	}
	// 删除成绩信息
	public int deleteScoreById(int scoreID) {
		// 定义sql语句
		String sql = "delete from tb_score where scoreId=?";
		// 获取数据库的连接
		conn = JDBCUtil.getConnection();
		int num = 0;
		try {
			// 创建PreparedStatement对象
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, scoreID);
			num = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.close(conn, pstmt, pstmt, rs);
		}
		return num;
	}
	// 修改成绩信息
	public int updateScoreById(Double score, int scoreId) {
		// 定义sql语句
		String sql = "update tb_score set score=? where scoreId=?";
		// 获取数据库的连接
		conn = JDBCUtil.getConnection();
		int num = 0;
		try {
			// 创建PreparedStatement对象
			pstmt = conn.prepareStatement(sql);
			pstmt.setDouble(1, score);
			pstmt.setInt(2, scoreId);
			num = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.close(conn, pstmt, pstmt, rs);
		}
		return num;
	}
	
	
}
