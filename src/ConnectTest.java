import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectTest {
	public static void main(String[] args) {
		Connection conn = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			String url = "jdbc:mysql://localhost/test";
			conn = DriverManager.getConnection(url, "root", "1234");
			System.out.println("연결성공");
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("드라이버 로딩 실패");
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