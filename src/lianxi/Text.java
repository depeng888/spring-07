package lianxi;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Text {

	public static void main(String[] args)  {
		// TODO Auto-generated method stub
		//格式jdbc：mysql：//主机IP：端口号/数据库名
		String url="jdbc:mysql://192.168.202.131:3306/db2";
		String user="root";
		String password="123456";
		Connection con=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
        try {
        	//选择要操作的数据库种类---加载驱动(反射)
			Class.forName("com.mysql.jdbc.Driver");
			//创建链接 主机ip 端口号 用户名 密码 //选择要操作的数据库
			DriverManager.getConnection(url,user,password);
			//创建命令窗口(写sql语句)			
			con.prepareStatement("select*from student");			
			//运行sql语句并查看结果 如果是增删改则返回受影响的行数，如果是查询返回查询结果
			//运行时注意 如果是怎删改调用executeUpdate返回int 如果查询则调用executeQuery 返回ResultSet
			pstmt.executeQuery();
			//查看结果集
			//rs.next();
			//System.out.println(rs.getInt("id")+" "+rs.getString("name"));
			while(rs.next()) {
				System.out.println(rs.getInt("id")+" "+rs.getString("name"));				
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				if(rs!=null) {
				rs.close();
				}
				if(pstmt!=null) {
					pstmt.close();
					}
				if(con!=null) {
					con.close();
					}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

}
