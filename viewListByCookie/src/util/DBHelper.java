/**
 * @author LZD
 * @date 2017/11/29
 */
package util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBHelper {

	//数据库驱动
	private static final String driver = "com.mysql.jdbc.Driver";
	//链接数据库的url地址
	private static final String url = "jdbc:mysql://localhost:3306/shopping?useUnicode=true&characterEncoding=UTF-8";
	//登录的用户名及密码
	private static final String username = "root";
	private static final String password = "1219";
	
	//创建一个连接对象
	private static Connection conn = null;
	
	//该静态代码块负责加载驱动
	static {
		try {
			Class.forName(driver);
			System.out.println("已成功加载驱动");
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	//单例模式返回数据库链接对象(单例模式：在整个服务当中，这个连接对象只有一份拷贝)
	public static Connection getConnection() {
		if(conn == null) {
			try {
				conn = DriverManager.getConnection(url, username, password);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return conn;
		}
		return conn;
	}
	
	public static void main(String[] args) {
		
		Connection conn = DBHelper.getConnection();
		if(conn!=null) {
			System.out.println("数据库链接正常");
		}else {
			System.out.println("数据库链接异常");
		}
	}
	
}
