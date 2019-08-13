
import MessageModel.*;
import BoarderModel.*;
import MatchModel.*;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class PartInServlet extends HttpServlet {
   private static final long serialVersionUID = 1L;

/*
   protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      // TODO Auto-generated method stub
      
   
      request.setCharacterEncoding("UTF-8");
      response.setContentType("text/html; charset=UTF-8");
      
      MessageDao M_dao = new MessageDao();
      BoarderDao B_dao = new BoarderDao();
      
      String boardId =request.getParameter("boardID");
      //int board =Integer.parseInt(boardId);
      System.out.println(boardId);
      HttpSession session = request.getSession();
      
      String id = (String)session.getAttribute("ID");
      String writer = "writer";
      String content;
      
      /*
      if(id.equals(writer)) {
         content = "李멸��떊泥��씠 �솕�뒿�땲�떎.";
         M_dao.sendMessage(id,board,content);
      }
      else {
         content = "李멸��뻽�뒿�땲�떎.";
         M_dao.sendMessage(id,board,content);
      }
      
      
      
      
   }*/

   protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      
      //테스트 성공~
         //PrintWriter out=response.getWriter();
         String boardId =request.getParameter("boardID");
         //out.println(boardId);

         request.setCharacterEncoding("UTF-8");
         response.setContentType("text/html; charset=UTF-8");
         
         MessageDao mdao = new MessageDao();
         BoarderDao bdao = new BoarderDao();
         MatchDao matchDao = new MatchDao();
         
         
         HttpSession session = request.getSession();
         
         String id = (String)session.getAttribute("ID");
         String writer = bdao.getWriter(boardId);
         //System.out.println(writer);
         int board = Integer.parseInt(boardId);
         String content;
         
         int check_overlap;
         
         check_overlap=matchDao.checkOverlap(board,id);
         
         if(check_overlap == 0) {
        /////쪽지 구현
            content = "참가 신청했습니다.";
            mdao.sendMessage(id,board,content);
            content = "참가 신청이 왔습니다.";
            mdao.sendMessage(writer,board,content);
         
      ////실제 방 참가
            matchDao.insertMatch(board, id);
            bdao.updateNowCount(boardId);
            
         }
         else {
            System.out.println("ok");
            response.sendRedirect("matching.jsp");
         }
   }
}