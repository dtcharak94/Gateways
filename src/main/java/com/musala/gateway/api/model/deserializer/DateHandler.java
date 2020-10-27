package com.musala.gateway.api.model.deserializer;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;

import java.util.Date;
import java.text.SimpleDateFormat;

public class DateHandler extends StdDeserializer<Date> {

	  public DateHandler() {
	    this(null);
	  }

	  public DateHandler(Class<?> clazz) {
	    super(clazz);
	  }

	  @Override
	  public Date deserialize(JsonParser jsonparser, DeserializationContext context)
	  {
		  
		 try    
		 {
			 String date = jsonparser.getText();
	    
			 SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
	    	
			 return sdf.parse(date);
			 
	    } catch (Exception e) {
	      return null;
	    }
		 
	  }
	  

	}
