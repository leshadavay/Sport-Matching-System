
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import BoarderModel.BoarderDao;
import BoarderModel.BoarderVo;
import MatchModel.*;

public class CreateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");

		BoarderVo vo = new BoarderVo();
		BoarderDao dao = new BoarderDao();

		Date date = new Date();
		// String dateFormat = new SimpleDateFormat("yyyy-MM-dd HH-mm-ss",
		// Locale.ENGLISH).format(date);

		String dateFormat = new SimpleDateFormat("yyMMddHHmmss", Locale.ENGLISH).format(date);

		PrintWriter out = response.getWriter();

		HttpSession session = request.getSession();
		vo.setUploaddate(dateFormat);/// 1
		String username = (String) session.getAttribute("ID");
		vo.setWriter(username);//// 2

		String title = request.getParameter("title");
		vo.setTitle(title);//// 3
		System.out.println(title);
		System.out.println(vo.getTitle());
		String gametype = request.getParameter("game-type");
		vo.setGametype(gametype);//// 4

		String sportstype = request.getParameter("sport-type");
		vo.setSportstype(sportstype);//// 5

		String teamtype = request.getParameter("singleOrTeam");
		vo.setTeamtype(teamtype);///// 6

		vo.setNowpeo(0);///// 7

		int maxpeo = 0;
		maxpeo = (request.getParameter("userLimit") == null || request.getParameter("userLimit").equals(""))? 1 : Integer.parseInt(request.getParameter("userLimit"));
		vo.setMaxpeo(maxpeo);///// 8

		vo.setViews(0);///// 9

		String content = request.getParameter("description").toString();
		vo.setContent(content);////// 10

		dao.CreateBoard(vo);
		int boardId = dao.getBoardIndex();
		MatchDao mdao = new MatchDao();
		mdao.insertMatch(boardId, username);
		response.sendRedirect("showboard");
		
		/*
		 * Connection conn = null; Statement stmt = null;
		 */
		/*
		 * try { Class.forName("com.mysql.jdbc.Driver"); conn =
		 * DriverManager.getConnection(
		 * "jdbc:mysql://localhost:3306/sportmatching?serverTimezone=UTC", "root",
		 * "student"); if (conn == null) throw new
		 * Exception("�뜝�룞�삕�뜝�룞�삕�뜝�떢釉앹삕�뜝�떛�룞�삕�뜝�룞�삕 �뜝�룞�삕�뜝�룞�삕�뜝�룞�삕 �뜝�룞�삕 �뜝�룞�삕�뜝�룞�삕�뜝�떦�뙋�삕."
		 * ); stmt = conn.createStatement(); String command =
		 * String.format("insert into board " +
		 * "(id,username,title,stype,sportoresport,singleorteam,status,currentusers,maxusers,viewcount,description) values ('%s', '%s', '%s','%s', '%s', '%s','%s', '%s', '%s','%s', '%s');"
		 * , dateFormat, "User1",
		 * title,stype,soption,singleOrTeam,"�뜝�룞�삕�뜝�룞�삕","0",userLimit,"0",description
		 * ); int rowNum = stmt.executeUpdate(command); if (rowNum < 1) throw new
		 * Exception("�뜝�룞�삕�뜝�룞�삕�뜝�떢紐뚯삕 DB�뜝�룞�삕 �뜝�뙃琉꾩삕�뜝�룞�삕 �뜝�룞�삕 �뜝�룞�삕�뜝�룞�삕�뜝�떦�뙋�삕."
		 * ); else{ out.println("<script>alert('data successfully saved');" +
		 * "location.href='matching.jsp?option=ALL&sType=ALL&sName=ALL';</script>"); } }
		 * catch(Exception ignored){} finally { try { stmt.close(); } catch (Exception
		 * ignored) { } try { conn.close(); } catch (Exception ignored) { } }
		 */

		/*
		 * RequestDispatcher rd = request.getRequestDispatcher("NewFile.jsp");
		 * request.setAttribute("title",title); request.setAttribute("soption",soption);
		 * request.setAttribute("stype",stype);
		 * request.setAttribute("singleOrTeam",singleOrTeam);
		 * request.setAttribute("userLimit",userLimit);
		 * request.setAttribute("description",description);
		 * 
		 * 
		 * rd.forward(request, response);
		 */

	}
}

/*
 * Connection con = DatabaseConnection.initializeDatabase();
 * 
 * // Create a SQL query to insert data into demo table // demo table consists
 * of two columns, so two '?' is used PreparedStatement st = con
 * .prepareStatement("insert into board values(?,?,?,?,?,?,?,?,?,?,?)");
 * 
 * // For the first parameter, // get the data using request object // sets the
 * data to st pointer int id=1000,current=0,view=0; st.setInt(1, id);
 * st.setString(2, "User1"); st.setString(3, title); st.setString(4, stype);
 * st.setString(5, soption); st.setString(6, singleOrTeam); st.setString(7,
 * "OK"); st.setInt(8, current); st.setInt(9, Integer.valueOf(userLimit));
 * st.setInt(10, view); st.setString(11, description);
 * 
 * // Execute the insert command using executeUpdate() // to make changes in
 * database st.executeUpdate();
 * 
 * // Close all the connections st.close(); con.close();
 * 
 * // Get a writer pointer // to display the succesful result
 * 
 * //out.println("<html><body><b>Successfully Inserted"+"</b></body></html>"); }
 * catch (Exception e) { e.printStackTrace(); }
 */

// response.sendRedirect("matching.jsp?option=SINGLE&sType=ALL&sName=ALL");

// out.println("<script>alert('haha');</script>");

/*

 
*/

/*
 * public void readDB() throws ServletException { Connection conn = null;
 * Statement stmt = null; try { Class.forName( "com.mysql.jdbc.Driver"); conn =
 * DriverManager.getConnection(
 * "jdbc:mysql://localhost:3306/sportmatching?serverTimezone=UTC", "root",
 * "student""); if (conn == null) throw new Exception(
 * "�뜝�룞�삕�뜝�룞�삕�뜝�떢釉앹삕�뜝�떛�룞�삕�뜝�룞�삕 �뜝�룞�삕�뜝�룞�삕�뜝�룞�삕 �뜝�룞�삕 �뜝�룞�삕�뜝�룞�삕�뜝�떦�뙋�삕. "
 * ); stmt = conn.createStatement(); ResultSet rs = stmt.executeQuery( "select *
 * from bbs where seqNo = �뜝�룞�삕�뜝�룞�삕 + seqNo + �뜝�룞�삕�뜝�룞�삕; �뜝�룞�삕); if
 * (rs.next()) { title = rs.getString( �뜝�룞�삕title �뜝�룞�삕); // �뜝�룞�삕�뜝�룞�삕
 * content = rs.getString( �뜝�룞�삕content �뜝�룞�삕); // �뜝�룞�삕�뜝�룞�삕 writer =
 * rs.getString( �뜝�룞�삕writer �뜝�룞�삕); // �뜝�뙗�눦�삕�뜝�룞�삕 date = rs.getDate(
 * �뜝�룞�삕wdate �뜝�룞�삕); // �뜝�룞�삕�뜝�룞�삕�뜝�룞�삕�뜝�룞�삕 time = rs.getTime(
 * �뜝�룞�삕wtime �뜝�룞�삕); // �뜝�룞�삕�뜝�룞�삕梨ⓨ뜝占� } } catch (Exception e) { throw new
 * ServletException(e); } finally { try { stmt.close(); } catch (Exception
 * ignored) { }
 */
