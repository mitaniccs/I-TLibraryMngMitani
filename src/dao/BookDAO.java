package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;


public class BookDAO {
//	資料返却確認画面、資料返却完了画面

	private Connection getConnection() throws DAOException {
		System.out.println("getConnection()メソッド入場");
		Connection conn = null;

		try {
			System.out.println("BookDAOのgetConnection()メソッド入場");
			//JDBCドライバの登録
			Class.forName("com.mysql.cj.jdbc.Driver");
			//URL、ユーザー名、パスワード
			final String url = "jdbc:mysql://localhost:3306/libraryDB";
			final String user ="user";
			final String password = "user";
			conn = DriverManager.getConnection(url, user, password);
			System.out.println(conn);
			System.out.println("BookDAOのgetConnection()メソッド退場");
		} catch (Exception e) {
			throw new DAOException("接続に失敗しました。");
		}
		System.out.println("getConnection()メソッド退場");
		return conn;
	}

	public String findTitle(String detail_Id) throws DAOException{
		System.out.println("fiindTitle()メソッド入場");
		Connection conn = null; //db接続
		PreparedStatement pstmt = null; //sql実行
		ResultSet rs = null; //結果セット
		try {
			conn = getConnection(); //db接続Connectionリターン

//TODO SQL文更新
			String sql ="select title from bookTbl where id = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, detail_Id);
			String title = rs.getString("title");
			System.out.println("FindTitle()メソッド退場");
			return title;

		} catch (Exception e1) {
			e1.printStackTrace();
			throw new DAOException("リストの取得に失敗しました。");
		} finally {
			//			トレースしやすくするため
			try {
				if(rs != null) rs.close();
			} catch (Exception e2) {
				e2.printStackTrace();
				throw new DAOException("ResulutSetオブジェクトの開放に失敗しました。");
			}
			try {
				if(pstmt != null) pstmt.close();
			} catch(Exception e3) {
				e3.printStackTrace();
				throw new DAOException("PreparedStatementオブジェクトの開放に失敗しました。");
			}
			try {
				if(conn != null) conn.close();
			} catch (Exception e4) {
				e4.printStackTrace();
				throw new DAOException("Connectionオブジェクトの開放に失敗しました。");
			}
		}
	}
}