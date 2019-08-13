

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import UserModel.UserDao;

/**
 * Servlet implementation class LoginServlet
 */
public class LoginServlet extends HttpServlet {
   protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      
      UserDao udo = new UserDao();
      PrintWriter out = response.getWriter();
      int check = 0;
      
      request.setCharacterEncoding("UTF-8");

      String id = request.getParameter("username");
      String pw = request.getParameter("password");
      String url = request.getParameter("CURRENT_URL");
      
      if(id == null || pw == null) {
         response.sendRedirect("Main.jsp");
      }
      
      response.setContentType("text/html; charset=utf-8");
      response.setCharacterEncoding("utf-8");
      
      check = udo.loginTry(id, pw);
      if(check == 1) {
         //濡쒓렇�씤 �꽦怨�
         HttpSession session = request.getSession();
         session.setAttribute("ID", id);
         response.sendRedirect("loginResult.jsp?LOGIN=SUCCESS");

      }
      else {
         //�떎�뙣 �삤瑜�
         response.sendRedirect("loginResult.jsp?LOGIN=FALSE");
      }
   }

}