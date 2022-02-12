package br.ufes.inf.dishfy;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;

import br.ufes.inf.dishfy.domain.ImageDishfy;

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

	// https://stackoverflow.com/questions/26311470/what-is-the-equivalent-of-javascript-settimeout-in-java
	public static void setTimeout(Runnable runnable, int delay){
		final ImageDishfy image;
		new Thread(() -> {
			try {
				Thread.sleep(delay);
				runnable.run();
			}
			catch (Exception e){
				System.err.println(e);
			}
		}).start();
	}
}
