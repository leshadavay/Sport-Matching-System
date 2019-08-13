package BoarderModel;

import java.io.PrintWriter;
import java.sql.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class BoarderDao {

	private Connection conn = null;
	private PreparedStatement pst = null;
	private ResultSet rs = null;
	private Statement stmt = null;

	// select - close
	public void Close() throws SQLException {
		if (conn != null)
			conn.close();
		if (pst != null)
			pst.close();
		if (rs != null)
			rs.close();
		if (stmt != null)
			stmt.close();
	}

	// connection
	public BoarderDao() {
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

	public void CreateBoard(BoarderVo vo) {
		String sql = "insert into matchboard(owner,gametype,"
				+ "sportstype,teamtype,userlimit,currentusers,views,description,title) values(?,?,?,?,?,?,?,?,?)";
		try {
			pst = conn.prepareStatement(sql);

			pst.setString(1, vo.getWriter());
			pst.setString(2, vo.getGametype());
			pst.setString(3, vo.getSportstype());
			pst.setString(4, vo.getTeamtype());
			pst.setInt(5, vo.getMaxpeo());
			pst.setInt(6, vo.getNowpeo());
			pst.setInt(7, vo.getViews());
			pst.setString(8, vo.getContent());
			pst.setString(9, vo.getTitle());

			pst.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {

			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}

	}
	
	public void updateIsMatch(String id) {
		try {
			pst = conn.prepareStatement("update matchboard set ismatch = 1 where id= ?");
			pst.setString(1, id);
			pst.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {

			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
	}

	public void updateViewCount(String id) {

		try {
			pst = conn.prepareStatement("update matchboard set views = views + 1 where id= ?");
			pst.setString(1, id);
			pst.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {

			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
	}
	
	public void updateNowCount(String id) {

		try {
			pst = conn.prepareStatement("update matchboard set currentusers = currentusers + 1 where id= ?");
			pst.setString(1, id);
			pst.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {

			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
	}
	
	public void downNowCount(String id) {

		try {
			pst = conn.prepareStatement("update matchboard set currentusers = currentusers - 1 where id= ?");
			pst.setString(1, id);
			pst.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {

			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
	}
	
	public int getMaxPeo(String boardId) {
		String sql = "select userlimit from matchboard where id = ?";
		int max = 0;
		try {
			pst = conn.prepareStatement(sql);
			pst.setString(1, boardId);
			
			rs = pst.executeQuery();
			
			if(rs.next()) {
				max = rs.getInt(1);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return max;
	}

	public BoarderVo getBoard(int boardId) {
		String sql = "select * from matchBoard where id = ?";
		BoarderVo vo = new BoarderVo();
		try {
			pst = conn.prepareStatement(sql);
			pst.setInt(1, boardId);

			rs = pst.executeQuery();

			if (rs.next()) {
				vo.setBoardid(rs.getInt("id"));
				vo.setContent(rs.getString("description"));
				vo.setGametype(rs.getString("gametype"));
				vo.setIsMatch(rs.getInt("ismatch"));
				vo.setMaxpeo(rs.getInt("userlimit"));
				vo.setNowpeo(rs.getInt("currentusers"));
				vo.setSportstype(rs.getString("sportstype"));
				vo.setTeamtype(rs.getString("teamtype"));
				vo.setTitle(rs.getString("title"));
				vo.setUploaddate(rs.getString("createdate"));
				vo.setViews(rs.getInt("views"));
				vo.setWriter(rs.getString("owner"));
				return vo;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return vo;
	}

	// print
	public ArrayList<BoarderVo> printBoard(String singleOrTeam, String sportOrESport, String gameType) {
		ArrayList<BoarderVo> boardVo = new ArrayList<BoarderVo>();
		boardVo = showMostcount(singleOrTeam, sportOrESport, gameType);
		try {
			if (conn == null)
				throw new Exception("데이터베이스에 연결할 수 없습니다.<BR>");
			stmt = conn.createStatement();
			if (singleOrTeam.equals("ALL")) {
				if (sportOrESport.equals("ALL") && gameType.equals("ALL")) {
					rs = stmt.executeQuery("select * from matchboard where ismatch = 0;");
					// rs=stmt.executeQuery("select * from matchboard where gametype='PINGPONG' and
					// sportstype='Sport'");
				} else if (!sportOrESport.equals("ALL") && gameType.equals("ALL")) {

					String temp = null;
					if (sportOrESport.equals("ESPORT"))
						temp = "E-Sport";
					else
						temp = "Sport";
					rs = stmt.executeQuery("select * from matchboard where sportstype='" + temp + "' and ismatch = 0;");

				} else {

					String temp = null;
					if (sportOrESport.equals("ESPORT"))
						temp = "E-Sport";
					else
						temp = "Sport";

					rs = stmt.executeQuery("select * from matchboard where gametype='" + gameType + "'and sportstype='"
							+ temp + "' and ismatch = 0;");
				}

			} else if (!singleOrTeam.equals("ALL")) {

				if (!sportOrESport.equals("ALL") && gameType.equals("ALL")) {
					String temp = null;
					if (sportOrESport.equals("ESPORT"))
						temp = "E-Sport";
					else
						temp = "Sport";
					rs = stmt.executeQuery("select * from matchboard where teamtype='" + singleOrTeam
							+ "' and sportstype='" + temp + "' and ismatch = 0;");
				} else if (!gameType.equals("ALL")) {
					rs = stmt.executeQuery("select * from matchboard where teamtype='" + singleOrTeam
							+ "' and gametype='" + gameType + "' and ismatch = 0;");
				} else
					rs = stmt.executeQuery("select * from matchboard where teamtype='" + singleOrTeam + "' and ismatch = 0;");
			}

			while (rs.next()) {

				int boardid = rs.getInt("id");
				String writer = rs.getString("owner");
				String gametype = rs.getString("gametype");
				String sportstype = rs.getString("sportstype");
				String teamtype = rs.getString("teamtype");
				int nowPeo = rs.getInt("currentusers");
				int maxPeo = rs.getInt("userlimit");
				int views = rs.getInt("views");
				String uploadDate = rs.getString("createdate");
				String content = rs.getString("description");
				String title = rs.getString("title");

				boardVo.add(new BoarderVo(boardid, writer, gametype, sportstype, teamtype, nowPeo, maxPeo, views,
						uploadDate, content, title));

				// out.println("<script>fetchDataFromDB('"+id+"','"+username+"','"+title+"','"+stype+"','"+sportoresport+"','"+singleorteam+"','"+status+"','"+currentusers+"','"+maxusers+"','"+viewcount+"','"+description+"');</script>");
			}
			showMostcount(singleOrTeam, sportOrESport, gameType);
		} catch (Exception e) {
		}
		return boardVo;
	}

	// 조회수 증가

	// 조회수 상단 3개 뿌려주기
	public ArrayList<BoarderVo> showMostcount(String singleOrTeam, String sportOrESport, String gameType) {
		ArrayList<BoarderVo> boardVo = new ArrayList<BoarderVo>();
		int cnt = 0;
		try {
			if (conn == null)
				throw new Exception("데이터베이스에 연결할 수 없습니다.<BR>");
			stmt = conn.createStatement();
			if (singleOrTeam.equals("ALL")) {
				if (sportOrESport.equals("ALL") && gameType.equals("ALL")) {
					rs = stmt.executeQuery("select * from matchboard where isMatch = 0 order by views desc;");

				} else if (!sportOrESport.equals("ALL") && gameType.equals("ALL")) {

					String temp = null;
					if (sportOrESport.equals("ESPORT"))
						temp = "E-Sport";
					else
						temp = "Sport";
					rs = stmt.executeQuery(
							"select * from matchboard where sportstype='" + temp + "' and isMatch = 0 order by views desc;");

				} else {

					String temp = null;
					if (sportOrESport.equals("ESPORT"))
						temp = "E-Sport";
					else
						temp = "Sport";

					rs = stmt.executeQuery("select * from matchboard where gametype='" + gameType + "'and sportstype='"
							+ temp + "' and isMatch = 0 order by views desc ;");
				}

			} else if (!singleOrTeam.equals("ALL")) {

				if (!sportOrESport.equals("ALL") && gameType.equals("ALL")) {
					String temp = null;
					if (sportOrESport.equals("ESPORT"))
						temp = "E-Sport";
					else
						temp = "Sport";
					rs = stmt.executeQuery("select * from matchboard where teamtype='" + singleOrTeam
							+ "' and sportstype='" + temp + "' and isMatch = 0 order by views desc;");
				} else if (!gameType.equals("ALL")) {
					rs = stmt.executeQuery("select * from matchboard where teamtype='" + singleOrTeam
							+ "' and gametype='" + gameType + "' and isMatch = 0 order by views desc;");
				} else
					rs = stmt.executeQuery(
							"select * from matchboard where teamtype='" + singleOrTeam + "' and isMatch = 0 order by views desc;");
			}

			while (rs.next()) {
				cnt++;
				int boardid = rs.getInt("id");
				String writer = rs.getString("owner");
				String gametype = rs.getString("gametype");
				String sportstype = rs.getString("sportstype");
				String teamtype = rs.getString("teamtype");
				int nowPeo = rs.getInt("currentusers");
				int maxPeo = rs.getInt("userlimit");
				int views = rs.getInt("views");
				String uploadDate = rs.getString("createdate");
				String content = rs.getString("description");
				String title = rs.getString("title");

				boardVo.add(new BoarderVo(boardid, writer, gametype, sportstype, teamtype, nowPeo, maxPeo, views,
						uploadDate, content, title));

				if (cnt == 3)
					break;
				// out.println("<script>fetchDataFromDB('"+id+"','"+username+"','"+title+"','"+stype+"','"+sportoresport+"','"+singleorteam+"','"+status+"','"+currentusers+"','"+maxusers+"','"+viewcount+"','"+description+"');</script>");
			}

		} catch (Exception e) {
		}
		return boardVo;
	}

	public String getWriter(String boardId) {

		String writer = "";
		String sql = "select writer from matchboard where id =?";
		try {
			pst = conn.prepareStatement(sql);
			pst.setString(1, boardId);
			rs = pst.executeQuery();

			if (rs.next()) {
				writer = rs.getString("owner");
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {

			} catch (Exception e2) {
				e2.printStackTrace();
			}

		}
		return writer;
	}

	public int getBoardIndex() {
		String sql = "select * from matchboard order by id desc limit 0, 1;";
		int boardId = 0;
		try {
			pst = conn.prepareStatement(sql);
			rs = pst.executeQuery();

			if (rs.next()) {
				boardId = rs.getInt("id");
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {

			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		return boardId;
	}

	// 켈린더 이벤트 추가
	public boolean saveNewEvent(String username, String newevent, String eventdate) {
		String sql = "insert into events(USERNAME,EVENTDATE,DESCRIPTION) values(?,?,?)";
		boolean result = false;
		try {
			pst = conn.prepareStatement(sql);
			pst.setString(1, username);
			pst.setString(2, eventdate);
			pst.setString(3, newevent);
			pst.executeUpdate();
			result = true;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			/*
			 * try { CloseCP(conn, pst);
			 * 
			 * } catch (Exception e2) { e2.printStackTrace(); }
			 */
		}
		return result;

	}

	// 모든 이벤트 가져오기
	public ArrayList<String> fetchAllEvents(String username) {

		ArrayList<String> data = new ArrayList<String>();
		try {

			stmt = conn.createStatement();

			rs = stmt.executeQuery("select * from events where username='" + username + "';");

			while (rs.next()) {

				String createdate = rs.getString("eventdate");
				String description = rs.getString("description");

				data.add(createdate);
				data.add(description);

			}

		} catch (Exception e) {
			data = null;
		}

		return data;
	}

	// 이벤트 삭제
	public boolean removeEvent(String username, String eventdate) {
		boolean result = false;

		try {
			pst = conn.prepareStatement("delete from events where username= ? and eventdate= ? ");
			pst.setString(1, username);
			pst.setString(2, eventdate);
			pst.executeUpdate();
			result = true;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			/*
			 * try { CloseCP(conn, pst); } catch (Exception e2) { e2.printStackTrace(); }
			 */
		}

		return result;

	}

}