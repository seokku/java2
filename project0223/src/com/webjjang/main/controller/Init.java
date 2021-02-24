package com.webjjang.main.controller;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;

import com.webjjang.notice1.dao.Notice1DAO;
import com.webjjang.notice1.service.NoticeListService;
import com.webjjang.notice1.service.NoticeViewService;
import com.webjjang.notice1.service.NoticeWriteService;

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
		
		System.out.println("Project0223 실행 test -----------------------------------");
		
		System.out.println("서버 구동");
		
		// -------------------------------- BoardDAO ---------------------------------------------------------
		//Beans.putDAO("boardDAO", new BoardDAO);		// 게시판 DAO 객체를 저장 (BoardDAO 만드신 후에 Import 하시면 됩니다.)
		
		// -------------------------------- BoardDAO[Service 생성후 저장] ----------------------------------------
		// ------- 패키지 이름에 따라 board1, board2, board3으로 바꿔주시면 됩니다.
		//Beans.put("/board/list.jsp", new BoardListService);		// 게시판 서비스를 만드신 후 Import 해주시면 됩니다.
		//Beans.put("/board/view.jsp", new BoardViewService);
		
		
		
		 //-------------------------------- NoticeDAO --------------------------------------------------------
		 Beans.putDAO("notice1DAO", new Notice1DAO());	// 공지사항 DAO 객체를 저장 (NoticeDAO 만드신 후에 Import 하시면 됩니다.)
		
		// -------------------------------- NoticeDAO[Service 생성후 저장] ----------------------------------------
		// ------- 패키지 이름에 따라 notice1, notice2, notice3으로 바꿔주시면 됩니다.
		Beans.put("/notice1/list.jsp", new NoticeListService());	// 공지사항 서비스를 만드신 후 Import 해주시면 됩니다.
		Beans.put("/notice1/view.jsp", new NoticeViewService());
		Beans.put("/notice1/wirte.jsp", new NoticeWriteService());
		
		Beans.get("/notice1/list.jsp").setDAO(Beans.getDAO("Notice1DAO"));
		Beans.get("/notice1/view.jsp").setDAO(Beans.getDAO("Notice1DAO"));
		Beans.get("/notice1/write.jsp").setDAO(Beans.getDAO("Notice1DAO"));
		try {
			
			Class.forName("com.webjjang.util.db.DBInfo");
			
		} catch (Exception e) {
	
			e.printStackTrace();
			
			throw new ServletException("드라이버를 확인하는 도중 오류가 발생하였습니다.");
			
		}
		
		
	}

}
