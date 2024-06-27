package com.cetpa.exceptions;

public class DoctorNotFound extends RuntimeException
{
      public DoctorNotFound(String msg)
      {
    	  super(msg);
      }
}
