package com.findme.bootstrap;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

import org.springframework.stereotype.Component;

import com.fasterxml.jackson.annotation.JsonInclude;

@Component
public class SkipNullObjectMapper extends ObjectMapper {

    @SuppressWarnings("deprecation")
	public void init() {
        setSerializationInclusion(JsonInclude.Include.NON_NULL);
        //ignore unknown properties
	    disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);
    }
}