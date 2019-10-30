package org.seung.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.seung.dao.BoardDAO;
import org.seung.dao.BoardDAOImpl;
import org.seung.domain.BoardVO;
import org.seung.dto.PagingDto;

import lombok.extern.log4j.Log4j;

/**
 * Servlet implementation class ListController
 */
@Log4j
@WebServlet("/list")
public class ListController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	BoardDAO dao;

    public ListController() {
    	dao = new BoardDAOImpl();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		log.info("list page start");
		
		// 글 목록들 보내야 한다.
		PagingDto dto = new PagingDto();
		
		List<BoardVO> result = dao.selectList(dto);
		
		request.setAttribute("list", result);
		
		// list 목록 페이지 보여준다.
		request.getRequestDispatcher("/WEB-INF/views/board/list.jsp").forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
