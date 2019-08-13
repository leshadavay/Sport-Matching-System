

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import BoarderModel.BoarderDao;
import BoarderModel.BoarderVo;

public class ShowBoardServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8"); 
		
		String option=request.getParameter("option");
		String sType=request.getParameter("sType");
		String sName=request.getParameter("sName");
		
		if(option==null) option="ALL";
		if(sType==null) sType="ALL";
		if(sName==null) sName="ALL";
		
		BoarderDao dao = new BoarderDao();
		ArrayList<BoarderVo> vo=null;
		vo=dao.printBoard(option,sType,sName);
		
		//PrintWriter out=response.getWriter();
		//out.println(vo.get(0).getWriter());
		request.setAttribute("vo", vo);
		RequestDispatcher rd = request.getRequestDispatcher("matching.jsp?option="+option+"&sType="+sType+"&sName="+sName);
		rd.forward(request, response);
		
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}
}
