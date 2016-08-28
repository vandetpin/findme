package com.findme.utils;

import java.text.SimpleDateFormat;

import org.springframework.stereotype.Component;

@Component
public class Formatter {
	public static final SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
	public static final SimpleDateFormat dateTimeFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
}
