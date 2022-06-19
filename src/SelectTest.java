import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class SelectTest {
	public static void main(String[] args) {
		Connection conn = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			String url = "jdbc:mysql://localhost/test";
			conn = DriverManager.getConnection(url, "root", "1234");
			System.out.println("Connected");
			String sql = "select * from user";
			PreparedStatement pstmt = conn.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()) {
				String name = rs.getString("name");
				String id = rs.getString("id");
				String phone =rs.getString("phone");
				System.out.printf("%s %s %s\n",  id,name, phone);
			}
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
