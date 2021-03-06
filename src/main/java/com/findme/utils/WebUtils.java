package com.findme.utils;

import java.net.MalformedURLException;
import java.net.URL;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Collection;

import javax.servlet.http.HttpServletRequest;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

@Component
public final class WebUtils {

	public static final String SUCCESS_MESSAGE = "successMessage";
	public static final String ERROR_MESSAGE = "errorMessage";

	private static final String HTTP = "http";
    private static final String HTTPs = "https";

	/**
     * convert plain text into MD5 string
     * 
     * @param plain
     * @return return plain text back if MD5 is not available
     */
    public static String md5(String plain) {
        byte[] defaultBytes = plain.getBytes();
        try {
            MessageDigest algorithm = MessageDigest.getInstance("MD5");
            algorithm.reset();
            algorithm.update(defaultBytes);
            byte[] messageDigest = algorithm.digest();

            StringBuffer hexString = new StringBuffer();
            for (int i = 0; i < messageDigest.length; i++) {
                hexString.append(Integer.toHexString(0xFF & messageDigest[i]));
            }
            return hexString.toString();
        } catch (NoSuchAlgorithmException nsae) {
            return plain;
        }

    }
    
    public static URL getServerUrl(HttpServletRequest request) throws MalformedURLException {
        int port = request.getServerPort();
        if (HTTP.equals(request.getScheme()) && port == 80) {
            port = -1;
        } else if (HTTPs.equals(request.getScheme()) && port == 443) {
            port = -1;
        }
        return new URL(request.getScheme(), request.getServerName(), port, "");
    }
    
    /**
     * Get current username that already loged in, otherwise it will reutrn null
     * 
     * @return
     */
    public static String getCurrentUserName() {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		if(auth.getPrincipal() instanceof User ) {
			return ((User)auth.getPrincipal()).getUsername();
		}
		
		return null;
	}
    
}
