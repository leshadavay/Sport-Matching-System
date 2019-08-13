package UserModel;

import java.sql.*;

public class UserDao {

	private Connection conn = null;
	private PreparedStatement pst = null;
	private ResultSet rs = null;

	// select - close
	public void Close() throws SQLException {
		if (conn != null)
			conn.close();
		if (pst != null)
			pst.close();
		if (rs != null)
			rs.close();
	}

	public UserDao() {
		try {
			String url = "jdbc:mysql://localhost:3306/matchdbjsp?serverTimezone=UTC";
			String uid = "root";
			String upw = "";

			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection(url, uid, upw);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// 占싸깍옙占쏙옙 占시듸옙
	public int loginTry(String id, String pw) {
		int regNum = 0; // 占싸깍옙占쏙옙 占실븝옙

		String sql = "select userPassword from userInfo where userId=?";

		try {
			pst = conn.prepareStatement(sql);
			pst.setString(1, id);

			rs = pst.executeQuery();

			if (rs.next()) {
				String dbPw = rs.getString("userPassword");
				if (dbPw.equals(pw)) {
					regNum = 1; // 占싸깍옙占쏙옙 占쏙옙占쏙옙
				} else {
					regNum = 3; // 占쏙옙占� 占쏙옙占쏙옙
				}
			} else {
				regNum = 2; // 占쏙옙占싱듸옙 占쏙옙占쏙옙
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {

			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}

		return regNum;
	}

	public UserVO getUserInfo(String id) {
		String sql = "select * from userInfo where userId=?";
		try {
			pst = conn.prepareStatement(sql);
			pst.setString(1, id);

			rs = pst.executeQuery();

			if (rs.next()) {
				UserVO vo = new UserVO();
				vo.setUserId(rs.getString("userId"));
				vo.setUserPassword(rs.getString("userPassword"));
				vo.setKakao(rs.getString("kakao"));

				return vo;
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {

			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		return null;
	}

	public String getKakao(String userid) {
		String kakaoId = "";
		String sql = "select kakao from userinfo where userid = ?";
		try {
			pst = conn.prepareStatement(sql);
			pst.setString(1, userid);

			rs = pst.executeQuery();
			if (rs.next()) {
				kakaoId = rs.getString("kakao");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return kakaoId;
	}

}