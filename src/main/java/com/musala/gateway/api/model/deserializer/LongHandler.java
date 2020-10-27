package com.musala.gateway.api.model.deserializer;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.deser.std.*;
import com.fasterxml.jackson.databind.DeserializationContext;

public class LongHandler extends StdDeserializer<Long> {

		public LongHandler() {
			this(null);
		}
		
		public LongHandler (Class<?> clazz)
		{
			super(clazz);
		}
		
		public Long deserialize(JsonParser jsonparser, DeserializationContext context) {
			try {
				
			String amt = jsonparser.getText();
			
			return Long.parseLong(amt);
			
			} catch(Exception e) {
				return null;
			}
		}
	}

