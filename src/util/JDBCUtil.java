package util;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/*
 * 这是数据库连接类
 * 
 * 
 */
public class JDBCUtil {
	//8版本的驱动加载及URL
	private final static String DRIVER = "com.mysql.cj.jdbc.Driver";
	private final static String URL = "jdbc:mysql://localhost:3306/db_citsims?useUnicode=true&characterEncoding=utf8&useSSL=true&serverTimezone=Asia/Shanghai";
	private final static String USERNAME = "root";
	private final static String PASSWORD = "root";

	/** 
	* 这是数据库连接的方法，声明静态方法，获得数据库连接 
	* @return
	*/
	public static Connection getConnection() {
		Connection con = null;
		try {
			//加载驱动
			Class.forName(DRIVER);
			//连接地址、用户名、密码
			con = DriverManager.getConnection(URL, USERNAME, PASSWORD); 
			//System.out.println("Connection sucess~");
		} catch (ClassNotFoundException e) {
		            e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
			return con; 
	}    
    
   /**
    * 这是关闭数据库连接的方法，声明静态方法，关闭数据库连接 
    * 
    * @param con
    * @param pstmt
    * @param stmt
    * @param rs
    */
   public static void close(Connection con, PreparedStatement pstmt, Statement stmt, ResultSet rs) {
       try {
           if (con != null) {
               con.close();
           }
           if (pstmt != null) {
               pstmt.close();
           }
           if (stmt != null) {
               stmt.close();
           }
           if (rs != null) {
               rs.close();
           }
       } catch (SQLException e) {
           e.printStackTrace();
           
       }
   }
   
   //测试数据库链接
   public static void main(String[] args) {
       JDBCUtil.getConnection();
   }
   
}
