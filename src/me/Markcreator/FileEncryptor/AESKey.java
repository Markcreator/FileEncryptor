package me.Markcreator.FileEncryptor;

import java.security.MessageDigest;
import java.util.Arrays;

import javax.crypto.spec.SecretKeySpec;

public class AESKey {

	private SecretKeySpec keySpec;
	
	public AESKey(String key) {
		byte[] keyBytes = key.getBytes();
		
		// Build AES key
		try {
			//Pad key to right length
			MessageDigest sha = MessageDigest.getInstance("SHA-1");
			keyBytes = sha.digest(keyBytes);
			keyBytes = Arrays.copyOf(keyBytes, 16);
	
			keySpec = new SecretKeySpec(keyBytes, "AES");
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public SecretKeySpec getKeySpec() {
		return keySpec;
	}
}
