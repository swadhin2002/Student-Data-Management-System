package com.example.demo.utility;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ResponceStructure <T> 
{
	private int statuscode;
	private String message;
	private T data;
	private LocalDateTime time;
	 
}
