package org.seung.dto;

import lombok.Data;

@Data
public class PagingDto {
	
	private int page;
	private int amount;
	
	// 아무것도 안넣었을 때 page는 1, amount는 10 으로 한다.
	public PagingDto() {
		this.page = 1;
		this.amount = 10;
	}

}
