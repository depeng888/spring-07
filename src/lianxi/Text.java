package lianxi;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Text {

	public static void main(String[] args)  {
		// TODO Auto-generated method stub
		//��ʽjdbc��mysql��//����IP���˿ں�/���ݿ���
		String url="jdbc:mysql://192.168.202.131:3306/db2";
		String user="root";
		String password="123456";
		Connection con=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
        try {
        	//ѡ��Ҫ���������ݿ�����---��������(����)
			Class.forName("com.mysql.jdbc.Driver");
			//�������� ����ip �˿ں� �û��� ���� //ѡ��Ҫ���������ݿ�
			DriverManager.getConnection(url,user,password);
			//���������(дsql���)			
			con.prepareStatement("select*from student");			
			//����sql��䲢�鿴��� �������ɾ���򷵻���Ӱ�������������ǲ�ѯ���ز�ѯ���
			//����ʱע�� �������ɾ�ĵ���executeUpdate����int �����ѯ�����executeQuery ����ResultSet
			pstmt.executeQuery();
			//�鿴�����
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
