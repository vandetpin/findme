package com.findme.utils;

import java.text.SimpleDateFormat;

import org.springframework.stereotype.Component;

@Component
public class Formatter {
	public static final SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
}
