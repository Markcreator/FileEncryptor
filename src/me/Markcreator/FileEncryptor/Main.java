package me.Markcreator.FileEncryptor;

import javax.crypto.Cipher;

public class Main {

	public static void main(String[] args) {
		try {
			// Info
			String input = "test";
			String output = null;
			String decrypted = null;
			
			// Build AES key
			AESKey key = new AESKey("key");
			
			// Encrypt
			output = EncryptorService.transcode(Cipher.ENCRYPT_MODE, input, key);

			// Decrypt
			decrypted = EncryptorService.transcode(Cipher.DECRYPT_MODE, output, key);

			System.out.println("Original: " + new String(input));
			System.out.println("Encrypted: " + new String(output));
			System.out.println("Decrypted: " + new String(decrypted));

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
