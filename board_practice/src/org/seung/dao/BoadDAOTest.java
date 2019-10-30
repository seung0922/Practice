package org.seung.dao;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.seung.domain.BoardVO;
import org.seung.dto.PagingDto;

class BoadDAOTest {
	
	BoardDAO dao = new BoardDAOImpl();

	@Test
//	void insertTest() {
//		
//		BoardVO vo = new BoardVO();
//		
//		String title = "제목";
//		String con = "내용";
//		String writer = "작성자";
//		
//		vo.setTitle(title);
//		vo.setContent(con);
//		vo.setWriter(writer);
//		
//		assertTrue(dao.insert(vo));
//	}
	
//	void selectTest() {
//		
//		Long bno = 1L;
//		
//		BoardVO result = dao.select(bno);
//		
//		assertNotNull(result);
//		assertTrue(result.getBno() == bno);
//		
//	}
	
	void selectListTest() {
		
		PagingDto dto = new PagingDto();
		
		List<BoardVO> result = dao.selectList(dto);
		
		assertNotNull(result);
		
	}
	

}
