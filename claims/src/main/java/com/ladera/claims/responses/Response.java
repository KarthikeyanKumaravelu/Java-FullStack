package com.ladera.claims.responses;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class Response<T> {

	private String message;
	
	private T data;
	
	
}
