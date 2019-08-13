
import java.io.IOException;
import java.lang.reflect.Array;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import BoarderModel.BoarderDao;
import BoarderModel.BoarderVo;
import MatchModel.MatchDao;
import MatchModel.MatchUserList;
import MessageModel.MessageDao;
import MessageModel.MessageList;
import UserModel.*;

public class MyPageServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");

		HttpSession session = request.getSession();

		MatchUserList list = new MatchUserList();

		String id = "";
		int pageSeq = 0;
		pageSeq = (request.getParameter("PAGE_SEQ") == null) ? 0 : (Integer.parseInt(request.getParameter("PAGE_SEQ")));
		id = (session.getAttribute("ID") != null) ? (String) session.getAttribute("ID") : "";

		list.setPageSeq(pageSeq);
		if (id.equals(""))
			response.sendRedirect("notLoginError.jsp");

		// 여기부터 쪽지 구현해줘.
		MessageDao mdao = new MessageDao();
		MessageList ml = new MessageList();
		ml.setMessageList(mdao.allMessage(id));

		request.setAttribute("MESSAGE", ml);

		// 여기부터 방 정보
		MatchDao dao = new MatchDao();
		UserDao udao = new UserDao();

		list.setBoardId(dao.getBoard(id, pageSeq));

		if (list.getBoardId() < 1) {
			list.setBoardId(-1);
		} else {

			if (dao.isLast(id, list.getPageSeq())) {
				list.setIsLast(1);
			} else {
				list.setIsLast(0);
			}

			list.setUserList(dao.userList(list.getBoardId()));
			BoarderDao bdao = new BoarderDao();
			BoarderVo bvo = bdao.getBoard(list.getBoardId());
			ArrayList<String> kakaoList = new ArrayList<String>();
			for (int i = 0; i < list.getListSize(); i++) {
				kakaoList.add(udao.getKakao(list.getUserList()[i]));
			}
			list.setKakaoList(kakaoList);
			if (bvo.getWriter().equals(id)) {
				list.setIsWriter(1);
			} else {
				list.setIsWriter(0);
			}

		}
		request.setAttribute("USER_LIST", list);
		RequestDispatcher dis = request.getRequestDispatcher("MyPage.jsp");
		dis.forward(request, response);

	}

}