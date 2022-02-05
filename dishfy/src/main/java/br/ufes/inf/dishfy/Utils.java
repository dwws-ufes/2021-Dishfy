package br.ufes.inf.dishfy;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;

public class Utils {

    // Utilitário como feito em https://github.com/dwws-ufes/jbutler/blob/main/jbutler-wp/src/br/ufes/inf/nemo/jbutler/TextUtils.java
    public static String produceBase64EncodedMd5Hash(String str) throws NoSuchAlgorithmException, UnsupportedEncodingException {
		if (str == null) return null;
        
		MessageDigest md = MessageDigest.getInstance("MD5");
		byte[] bytes = str.getBytes("UTF-8");
		byte[] digest = md.digest(bytes);

		String s = Base64.getEncoder().encodeToString(digest);

		return s;
	}
}
