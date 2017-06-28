package me.Markcreator.FileEncryptor;

import java.security.MessageDigest;
import java.util.Arrays;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;

public class Main {

	public static void main(String[] args) {
		try {
			// Info
			byte[] key = "key".getBytes(); 
			byte[] input = "test".getBytes();
			byte[] output = null;
			byte[] decrypted = null;
			
			// Build AES key
			MessageDigest sha = MessageDigest.getInstance("SHA-1");
			key = sha.digest(key);
			key = Arrays.copyOf(key, 16);
			
			SecretKeySpec keySpec = null;
			keySpec = new SecretKeySpec(key, "AES");
			
			// Encrypt
			Cipher cipher = Cipher.getInstance("AES");
			cipher.init(Cipher.ENCRYPT_MODE, keySpec);
			output = cipher.doFinal(input);
			
			// Decrypt
			cipher.init(Cipher.DECRYPT_MODE, keySpec);
		    decrypted = cipher.doFinal(output);
		    
		    System.out.println("Original: " + new String(input));
			System.out.println("Encrypted: " + new String(output));
		    System.out.println("Decrypted: " + new String(decrypted));
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
