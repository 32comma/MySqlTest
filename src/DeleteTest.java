import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class DeleteTest {
	public static void main(String[] args) {
		Connection conn = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			String url = "jdbc:mysql://localhost/test";
			conn = DriverManager.getConnection(url, "root", "1234");
			System.out.println("Connected");
			String sql = "DELETE FROM user where id= ?";
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, "1");
			int result = pstmt.executeUpdate();
			System.out.println(result>0?"success":"fail");
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Drive load fail");
		} finally {
			try {
				if (conn != null || !conn.isClosed()) {
					conn.close();
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
}
