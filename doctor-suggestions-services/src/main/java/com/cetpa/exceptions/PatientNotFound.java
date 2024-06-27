package com.cetpa.exceptions;

public class PatientNotFound extends RuntimeException
{
      public PatientNotFound(String msg)
      {
    	  super(msg);
      }
}
