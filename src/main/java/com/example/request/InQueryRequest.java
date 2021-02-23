package com.example.request;

import java.util.List;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class InQueryRequest {
	
	private List<String> firstNames;
	private List<String> lastNames;
	private List<String> emails;
}
