package com.findme.service;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.multipart.MultipartFile;

import com.findme.exception.BusinessException;


public interface UploadService {
	String writeFile(HttpServletRequest request, MultipartFile file) throws BusinessException;
	String writeFile(HttpServletRequest reques, String fileName, byte[] fileAsBytes) throws BusinessException;
}
