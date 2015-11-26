/*******************************************************************************
 * Copyright (c) 2005, 2014 springside.github.io
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 *******************************************************************************/
package com.my.quickstart.util;

import java.security.SecureRandom;
import java.util.UUID;

import org.apache.commons.lang3.Validate;
import org.springframework.security.crypto.keygen.KeyGenerators;

/**
 * 返回ByteSource，可进一步被编码为Hex, Base64或UrlSafeBase64
 */
public class Digests {
	private static SecureRandom random = new SecureRandom();
	
	/**
	 * 生成UUID作为salt
	 * @return
	 */
	public static String generateUUIDSalt(){
		byte [] b=KeyGenerators.secureRandom(16).generateKey();
		String salt=UUID.nameUUIDFromBytes(b).toString();
		return salt;
	}

	/**
	 * 生成随机的Byte[]作为salt.
	 * 
	 * @param numBytes byte数组的大小
	 */
	public static byte[] generateSalt(int numBytes) {
		Validate.isTrue(numBytes > 0, "numBytes argument must be a positive integer (1 or larger)", numBytes);

		byte[] bytes = new byte[numBytes];
		random.nextBytes(bytes);
		return bytes;
	}
}
