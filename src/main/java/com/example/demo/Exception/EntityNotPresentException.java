package com.example.demo.Exception;

public class EntityNotPresentException extends RuntimeException
{
	public EntityNotPresentException(String s)
	{
		super(s);
	}
}
