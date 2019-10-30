package org.seung.dao;

import java.util.List;

import org.seung.domain.BoardVO;
import org.seung.dto.PagingDto;

public interface BoardDAO extends CrudDAO<BoardVO, Long> {
	
	public List<BoardVO> selectList(PagingDto dto);
	
}
