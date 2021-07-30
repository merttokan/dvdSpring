package com.example.dvd.core.utilities.results;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class DataResult<T> extends Result{
	private T data;
	public DataResult(T data, boolean success, String message) {
		super(success, message);
		this.data = data;
	}
	public DataResult(T data, boolean success) {
		super(success);
		this.data = data;
	}
	
	
	
	
	
	
}
