
import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import MatchModel.*;
import MessageModel.*;
import BoarderModel.*;

public class CheckMatchServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public CheckMatchServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");

		MessageDao mdao = new MessageDao();
		BoarderDao bdao = new BoarderDao();
		MatchDao matchDao = new MatchDao();

		String boardId = request.getParameter("boardCount");
		HttpSession session = request.getSession();

		String id = (String) session.getAttribute("ID");
		String[] user = request.getParameterValues("user");
		int board = Integer.parseInt(boardId);
		ArrayList<String>allUser = matchDao.userList(board);
		String content = null;
		String state = request.getParameter("state");
		int stateMode = Integer.parseInt(state);
		String writer = bdao.getWriter(boardId);
		int maxPeo = bdao.getMaxPeo(boardId);
		
		if(user == null && stateMode != 2) {
			response.sendRedirect("MatchResult.jsp?RESULT=NO_PEO");
		}
		
		// 매치 확정
		else if (stateMode == 1) {
			if (maxPeo >= user.length) {
				content = "매칭이 확정되었습니다";
				mdao.sendMessage(id, board, content);
				for (int i = 0; i < user.length; i++) {
					//탈락자 검거
					for(int j = 0; j < allUser.size(); j++) {
						if(allUser.get(j).equals(user[i])) {
							allUser.remove(j);
						}
					}
					
					mdao.sendMessage(user[i], board, content);
					matchDao.outMatch(board, user[i]);
				}
				for(int i = 1; i < allUser.size(); i++) {
					String canceled = allUser.get(i);
					content = "매칭이 되지 않았습니다.";
					mdao.sendMessage(allUser.get(i), board, content);
					matchDao.outMatch(board, allUser.get(i));
				}
				matchDao.outMatch(board, id);
				bdao.updateIsMatch(boardId);
				response.sendRedirect("MyPage");
			}
			
			else {
				response.sendRedirect("MatchResult.jsp?RESULT=TOO_MANY");
			}
		}

		else if (stateMode == 2) {
			content = "참가 취소했습니다.";
			mdao.sendMessage(id, board, content);
			content = "참가 취소 인원이 있습니다.";
			mdao.sendMessage(writer, board, content);

			// 방 삭제
			matchDao.outMatch(board, id);
			bdao.downNowCount(boardId);
			response.sendRedirect("MyPage");
		}
	}

}