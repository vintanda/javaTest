/**
 * @author LZD
 * @date 2017/11/29 - 2017/12/01
 */
/*
 * 商品业务逻辑类
 */
package DAO;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.mysql.jdbc.PreparedStatement;

import entity.items;
import util.DBHelper;

public class itemsDao {

	// 获取所有商品信息
	public ArrayList<items> getAllItems() {

		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;

		// 定义存储商品信息的集合
		ArrayList<items> list = new ArrayList<items>();

		try {
			// 获得连接对象
			conn = DBHelper.getConnection();
			// 写SQL语句
			String sql = "select * from items;";
			// 创建连接对象
			stmt = (PreparedStatement) conn.prepareStatement(sql);
			// 获得一个数据集
			rs = stmt.executeQuery();

			while (rs.next()) {
				items item = new items();
				item.setId(rs.getInt("id"));
				item.setName(rs.getString("name"));
				item.setCity(rs.getString("city"));
				item.setPrice(rs.getInt("price"));
				item.setNumber(rs.getInt("number"));
				item.setPicture(rs.getString("picture"));

				// 将获取的信息添加到list中
				list.add(item);
				System.out.println("当前商品信息：" + item.getName() + "   " + item.getPicture());
			}
			return list;

		} catch (Exception e) {
			e.printStackTrace();
			return null;
		} finally {
			// 释放资源
			if (rs != null) {
				try {
					rs.close();
					rs = null;
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}

			if (stmt != null) {
				try {
					stmt.close();
					stmt = null;
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}

	// 获取详细信息，用于details页面数据获取
	public items getItemById(int id) {

		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;

		try {
			// 连接数据库
			conn = DBHelper.getConnection();
			String sql = "select * from items where id = ?";

			/*
			 * PreparedStatement prepareStatement(String sql) throws SQLException：
			 * 返回预编译的Statement对象，即将SQL语句提交到数据库进行预编译
			 */
			stmt = (PreparedStatement) conn.prepareStatement(sql);
			/*
			 * void setXxx(int preparedStatement, Xxx value): 该方法根据传入参数值的类型不同，需要使用不同的方法，
			 * 传入的值根据索引传给SQL语句中的指定位置的参数 此处是给sql字符串(SQL语句)的第1个?赋值为id
			 */
			stmt.setInt(1, id);
			// rs初始值是第一行的前面
			rs = stmt.executeQuery();
			if (rs.next()) {
				items item = new items();

				item.setId(rs.getInt("id"));
				item.setName(rs.getString("name"));
				item.setCity(rs.getString("city"));
				item.setPrice(rs.getInt("price"));
				item.setNumber(rs.getInt("number"));
				item.setPicture(rs.getString("picture"));

				System.out.println("id:" + item.getId());
				System.out.println("name:" + item.getName());
				System.out.println("city:" + item.getCity());
				System.out.println("price:" + item.getPrice());
				System.out.println("number:" + item.getNumber());
				System.out.println("picture:" + item.getPicture());
				return item;
			} else {
				return null;
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		} finally {
			System.out.println("释放资源");
			// 释放数据集对象
			if (rs != null) {
				try {
					rs.close();
					rs = null;
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			// 释放语句对象
			if (stmt != null) {
				try {
					stmt.close();
					stmt = null;
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}

	}

	// 获取最近浏览的五条记录
	public ArrayList<items> getViewList(String list) {

		System.out.println("list:" + list);

		ArrayList<items> itemsList = new ArrayList<>();
		int iCount = 5;

		if (list != null && list.length() > 0) {
			String[] items = list.split("#");
			System.out.println(items.length);
			// 记录大于五条
			if (items.length > 5) {
				for (int i = items.length - 1; i > items.length - iCount - 1; i--) {
					// 通过获取详细信息的方法getItemById(int id)获取信息
					itemsList.add(getItemById(Integer.parseInt(items[i])));
				}
			} else {
				// 记录小于五条
				for (int i = items.length - 1; i > 0; i--) {
					itemsList.add(getItemById(Integer.parseInt(items[i])));
				}
			}
			return itemsList;
		} else {
			return null;
		}

	}

}
