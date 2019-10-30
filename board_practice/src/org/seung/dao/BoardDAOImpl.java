package org.seung.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.seung.domain.BoardVO;
import org.seung.dto.PagingDto;
import org.seung.util.MybatisLoader;

import lombok.extern.log4j.Log4j;

@Log4j
public class BoardDAOImpl implements BoardDAO { // DAO는 기능 담당

	// 일단 db랑 연결 - mybatis에서는 con, pstmt, rs 하는 걸 sqlSession 으로 대체하는듯?
	SqlSessionFactory factory = MybatisLoader.INSTANE.getFactory();

	// 글 목록 가져오기
	@Override
	public List<BoardVO> selectList(PagingDto dto) {
		List<BoardVO> result = null;

		try {

			// sqlSession을 Mapper와 연결하여 결과를 얻는다.
			SqlSession session = factory.openSession();
			
			result = session.selectList("org.seung.dao.BoardMapper.selectList", dto);
			
			log.info(result);

		} catch (Exception e) {
			e.printStackTrace();
		}

		return result;
	}
	
	// 글 쓰기
	@Override
	public boolean insert(BoardVO vo) {
		boolean result = false;

		try {

			// sqlSession을 Mapper와 연결하여 결과를 얻는다.
			SqlSession session = factory.openSession();
			
			int tmp = session.insert("org.seung.dao.BoardMapper.insert", vo);

			// 매퍼연결하여 얻은 결과가 1이면 잘 들어간 것
			result = tmp == 1 ? true : false;

			log.info("insert result: " + result);

			session.commit();

		} catch (Exception e) {
			e.printStackTrace();
		}

		return result;
	}

	// 글 조회
	@Override
	public BoardVO select(Long bno) {
		BoardVO result = null;

		try {

			// sqlSession을 Mapper와 연결하여 결과를 얻는다.
			SqlSession session = factory.openSession();
			
			log.info("select result before: " + result);
			
			// bno 를 넣어서 글 찾아옴
			result = session.selectOne("org.seung.dao.BoardMapper.select", bno);
			
			log.info("select result after: " + result);

		} catch (Exception e) {
			e.printStackTrace();
		}

		return result;
	}

	// 글 수정
	@Override
	public boolean update(BoardVO vo) {
		// TODO Auto-generated method stub
		return false;
	}

	// 글 삭제
	@Override
	public boolean delete(Long key) {
		// TODO Auto-generated method stub
		return false;
	}



}
