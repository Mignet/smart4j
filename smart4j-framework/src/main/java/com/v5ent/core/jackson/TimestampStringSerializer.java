package com.v5ent.core.jackson;

import java.io.IOException;
import java.text.SimpleDateFormat;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

public class TimestampStringSerializer extends JsonSerializer<String> {

	@Override
	public void serialize(String value, JsonGenerator gen,SerializerProvider serializers) throws IOException,JsonProcessingException {
		// TODO Auto-generated method stub
		SimpleDateFormat format =  new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Long time=new Long(value);
		gen.writeString(format.format(time));
	}
}
