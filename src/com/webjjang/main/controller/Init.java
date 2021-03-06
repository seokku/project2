package com.webjjang.main.controller;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;

import com.webjjang.board.dao.BoardDAO;
import com.webjjang.board.service.BoardDeleteService;
import com.webjjang.board.service.BoardListService;
import com.webjjang.board.service.BoardUpdateService;
import com.webjjang.board.service.BoardViewService;
import com.webjjang.board.service.BoardWriteService;
import com.webjjang.image.dao.ImageDAO;
import com.webjjang.image.service.ImageDeleteService;
import com.webjjang.image.service.ImageListService;
import com.webjjang.image.service.ImageUpdateFileService;
import com.webjjang.image.service.ImageViewService;
import com.webjjang.image.service.ImageWriteService;
import com.webjjang.member.dao.MemberDAO;
import com.webjjang.member.service.MemberGradeModifyService;
import com.webjjang.member.service.MemberListService;
import com.webjjang.member.service.MemberLoginService;
import com.webjjang.member.service.MemberViewService;
import com.webjjang.message.dao.MessageDAO;
import com.webjjang.message.service.MessageDeleteService;
import com.webjjang.message.service.MessageListService;
import com.webjjang.message.service.MessageViewService;
import com.webjjang.message.service.MessageWriteService;
import com.webjjang.notice.dao.NoticeDAO;
import com.webjjang.notice.service.NoticeListService;
import com.webjjang.notice.service.NoticeWriteService;
import com.webjjang.qna.dao.QnaDAO;
import com.webjjang.qna.service.QnaAnswerService;
import com.webjjang.qna.service.QnaDeleteService;
import com.webjjang.qna.service.QnaListService;
import com.webjjang.qna.service.QnaQuestionService;
import com.webjjang.qna.service.QnaViewService;

/**
 * Servlet implementation class Init
 */
@WebServlet(value = "/Init", loadOnStartup = 1)
public class Init extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Init() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
		System.out.println("jspProject2????????? ??????--------->>>");
		System.out.println("????????? ????????? ???????????? ???????????? ??????-----");
		
		// ????????? ????????? ?????? ??? ?????? ====================================
		// dao ?????? ??????
		Beans.putDAO("boardDAO", new BoardDAO());
		
		// service ?????? ??????
		Beans.put("/board/list.jsp", new BoardListService());
		Beans.put("/board/view.jsp", new BoardViewService());
		Beans.put("/board/write.jsp", new BoardWriteService());
		Beans.put("/board/update.jsp", new BoardUpdateService());
		Beans.put("/board/delete.jsp", new BoardDeleteService());
		
		// service??? dao ?????? - ??????
		Beans.get("/board/list.jsp").setDAO(Beans.getDAO("boardDAO"));
		Beans.get("/board/view.jsp").setDAO(Beans.getDAO("boardDAO"));
		Beans.get("/board/write.jsp").setDAO(Beans.getDAO("boardDAO"));
		Beans.get("/board/update.jsp").setDAO(Beans.getDAO("boardDAO"));
		Beans.get("/board/delete.jsp").setDAO(Beans.getDAO("boardDAO"));
		
		
		// ???????????? ????????? ?????? ??? ?????? ====================================
		// dao ?????? ??????
		Beans.putDAO("noticeDAO", new NoticeDAO());
		// service ?????? ??????
		Beans.put("/notice/list.jsp", new NoticeListService());
		Beans.put("/notice/write.jsp", new NoticeWriteService());
		// service??? dao ?????? - ??????
		Beans.get("/notice/list.jsp").setDAO(Beans.getDAO("noticeDAO"));
		Beans.get("/notice/write.jsp").setDAO(Beans.getDAO("noticeDAO"));
		
		// ????????? ????????? ?????? ??? ?????? ====================================
		// dao ?????? ??????
		Beans.putDAO("imageDAO", new ImageDAO());
		// service ?????? ??????
		Beans.put("/image/list.jsp", new ImageListService());
		Beans.put("/image/write.jsp", new ImageWriteService());
		Beans.put("/image/view.jsp", new ImageViewService());
		Beans.put("/image/updateFile.jsp", new ImageUpdateFileService());
		Beans.put("/image/delete.jsp", new ImageDeleteService());
		// service??? dao ?????? - ??????
		Beans.get("/image/list.jsp").setDAO(Beans.getDAO("imageDAO"));
		Beans.get("/image/write.jsp").setDAO(Beans.getDAO("imageDAO"));
		Beans.get("/image/view.jsp").setDAO(Beans.getDAO("imageDAO"));
		Beans.get("/image/updateFile.jsp").setDAO(Beans.getDAO("imageDAO"));
		Beans.get("/image/delete.jsp").setDAO(Beans.getDAO("imageDAO"));
		
		
		// ???????????? ????????? ?????? ??? ?????? ====================================
		// dao ?????? ??????
		Beans.putDAO("qnaDAO", new QnaDAO());
		// service ?????? ??????
		Beans.put("/qna/list.jsp", new QnaListService());
		Beans.put("/qna/question.jsp", new QnaQuestionService());
		Beans.put("/qna/view.jsp", new QnaViewService());
		Beans.put("/qna/answer.jsp", new QnaAnswerService());
		Beans.put("/qna/delete.jsp", new QnaDeleteService());
		// service??? dao ?????? - ??????
		Beans.get("/qna/list.jsp").setDAO(Beans.getDAO("qnaDAO"));
		Beans.get("/qna/question.jsp").setDAO(Beans.getDAO("qnaDAO"));
		Beans.get("/qna/view.jsp").setDAO(Beans.getDAO("qnaDAO"));
		Beans.get("/qna/answer.jsp").setDAO(Beans.getDAO("qnaDAO"));
		Beans.get("/qna/delete.jsp").setDAO(Beans.getDAO("qnaDAO"));
		
		
		// ????????? ????????? ?????? ??? ?????? ====================================
		// dao ?????? ??????
		// 1. MessageDAO??? ???????????? 2. key = "messageDAO"??? Beans??? ????????? ?????????. 
		Beans.putDAO("messageDAO", new MessageDAO());
		// service ?????? ??????
		// Beans?????? key="/message/list.jsp"??? ????????? ???????????? ?????????. --> MessageListService ????????? ?????????.
		Beans.put("/message/list.jsp", new MessageListService());
		// Beans?????? key="/message/write.jsp"??? ????????? ???????????? ?????????. --> MessageWriteService ????????? ?????????.
		Beans.put("/message/write.jsp", new MessageWriteService());
		// Beans?????? key="/message/view.jsp"??? ????????? ???????????? ?????????. --> MessageViewService ????????? ?????????.
		Beans.put("/message/view.jsp", new MessageViewService());
		// Beans?????? key="/message/view.jsp"??? ????????? ???????????? ?????????. --> MessageViewService ????????? ?????????.
		Beans.put("/message/delete.jsp", new MessageDeleteService());
		
		// service??? dao ?????? - ??????
		Beans.get("/message/list.jsp").setDAO(Beans.getDAO("messageDAO"));
		// Beans?????? key="/message/write.jsp"??? ????????? ???????????? ?????????. --> MessageWriteService ????????? ?????????.
		// Beans?????? key="message.DAO"??? ????????? ???????????? ?????????. --> MessageDAO ????????? ?????????.
		// ?????? : key??? ????????? null??? ?????????. -> NullPointException??? ?????????. + ??????????????? ??? ??????????????????.
		Beans.get("/message/write.jsp").setDAO(Beans.getDAO("messageDAO"));
		// Beans?????? key="/message/view.jsp"??? ????????? ???????????? ?????????. --> MessageViewService ????????? ?????????.
		// Beans?????? key="message.DAO"??? ????????? ???????????? ?????????. --> MessageDAO ????????? ?????????.
		// ?????? : key??? ????????? null??? ?????????. -> NullPointException??? ?????????. + ??????????????? ??? ??????????????????.
		Beans.get("/message/view.jsp").setDAO(Beans.getDAO("messageDAO"));
		// Beans?????? key="/message/view.jsp"??? ????????? ???????????? ?????????. --> MessageViewService ????????? ?????????.
		// Beans?????? key="message.DAO"??? ????????? ???????????? ?????????. --> MessageDAO ????????? ?????????.
		// ?????? : key??? ????????? null??? ?????????. -> NullPointException??? ?????????. + ??????????????? ??? ??????????????????.
		Beans.get("/message/delete.jsp").setDAO(Beans.getDAO("messageDAO"));
		
		
		// ?????? ?????? ????????? ?????? ??? ?????? ====================================
		// dao ?????? ??????
		Beans.putDAO("memberDAO", new MemberDAO());
		
		// service ?????? ??????
		Beans.put("/member/login.jsp", new MemberLoginService());
		Beans.put("/member/list.jsp", new MemberListService());
		Beans.put("/member/gradeModify.jsp", new MemberGradeModifyService());
		System.out.println("Init.init().Beans.get(\"/member/gradeModify.jsp\") : " 
		+ Beans.get("/member/gradeModify.jsp"));
		
		Beans.put("/member/view.jsp", new MemberViewService());
		System.out.println("Init.init().Beans.get(\"/member/view.jsp\") : " 
				+ Beans.get("/member/view.jsp"));

		// service??? dao ?????? - ??????
		Beans.get("/member/login.jsp").setDAO(Beans.getDAO("memberDAO"));
		Beans.get("/member/list.jsp").setDAO(Beans.getDAO("memberDAO"));
		System.out.println("Init.init().Beans.get(\"memberDAO\") : " 
				+ Beans.getDAO("memberDAO"));
		Beans.get("/member/gradeModify.jsp").setDAO(Beans.getDAO("memberDAO"));
		
		System.out.println("Init.init().Beans.get(\"memberDAO\") : " 
				+ Beans.getDAO("memberDAO"));
		Beans.get("/member/view.jsp").setDAO(Beans.getDAO("memberDAO"));
		
		// ?????? ????????? ????????? ????????? ??????
		System.out.println(Beans.get("/board/list.jsp"));
		System.out.println(Beans.getDAO("boardDAO"));
		
		// ????????? ??????????????? ????????? ????????? ??????
		try {
			// class ?????? ?????? static ????????? ?????? ?????? static{} ????????? ????????? ?????????.
			Class.forName("com.webjjang.util.db.DBInfo");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new ServletException("???????????? ???????????? ?????? ??? ?????? ??????");
		}
	}

}
