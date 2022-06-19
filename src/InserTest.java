import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.UUID;

public class InserTest {
	public static void main(String[] args) {
		Connection conn = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			String url = "jdbc:mysql://localhost/test";
			conn = DriverManager.getConnection(url, "root", "1234");
			System.out.println("Connected");
			String sql = "INSERT INTO user(id,name,password,phone) VALUES (?, ?, ?, ?)";
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, "id"+UUID.randomUUID());
			pstmt.setString(2, "name"+UUID.randomUUID());
			pstmt.setString(3, "password"+UUID.randomUUID());
			pstmt.setString(4, "phone"+UUID.randomUUID());
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
