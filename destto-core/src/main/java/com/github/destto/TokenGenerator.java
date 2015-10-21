package com.github.destto;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Random;

import org.apache.commons.codec.binary.Base64;

/**
 * Generate token.
 * @author casterrow@163.com, Stephen Lau
 * @since Oct 21, 2015
 * @version 1.0
 */
public final class TokenGenerator {

	/**
	 * 构造函数私有化
	 */
	private TokenGenerator() {}
	
	private static class TokenHolder {
		static final TokenGenerator INSTANCE = new TokenGenerator();
	}
	
	/**
	 * 
	 * @author casterrow@163.com, Stephen Lau
	 * @since Oct 22, 2015
	 * @version 1.0
	 * @return
	 */
	public static TokenGenerator getInstance() {
		return TokenHolder.INSTANCE;
	}
	
	/**
	 * Use Base64 to encode bytes to transfer via network.
	 * @author casterrow@163.com, Stephen Lau
	 * @since Oct 22, 2015
	 * @version 1.0
	 * @return
	 */
	public String generateToken() {
		
		String token = System.currentTimeMillis() + new Random().nextInt() + "";
		
		try {
			MessageDigest digest = MessageDigest.getInstance("md5");
			byte[] md5 = digest.digest(token.getBytes());
			Base64 base64 = new Base64();
			return base64.encodeAsString(md5);
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
		
		return null;
	}
}
