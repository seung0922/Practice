package org.seung.domain;

import java.sql.Date;

import lombok.Data;

@Data
public class BoardVO {	// 컬럼
	
	private Long bno;			// 글 번호
	private String title;		// 제목
	private String content;		// 내용
	private String writer;		// 작성자
	private Date regdate;		// 올린 날짜
	private Date updatedate;	// 수정날짜

}
