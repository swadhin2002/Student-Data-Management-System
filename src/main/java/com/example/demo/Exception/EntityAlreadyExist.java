package com.example.demo.Exception;

public class EntityAlreadyExist extends RuntimeException
{
	public EntityAlreadyExist(String msg)
	{
		super(msg);
	}
}
