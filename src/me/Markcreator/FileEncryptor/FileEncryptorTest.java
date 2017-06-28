package me.Markcreator.FileEncryptor;

import javax.crypto.Cipher;

public class FileEncryptorTest {

	public static void test(String text, String keyStr) {
		try {
			// String info
			byte[] input = text.getBytes();
			byte[] output = null;
			byte[] decrypted = null;
			
			// Build AES key
			AESKey key = new AESKey(keyStr);
			
			// Encrypt
			output = AESEncryptorService.getInstance().transcode(Cipher.ENCRYPT_MODE, key, input);

			// Decrypt
			decrypted = AESEncryptorService.getInstance().transcode(Cipher.DECRYPT_MODE, key, output);

			System.out.println("Original string: " + new String(input));
			System.out.println("Encrypted string: " + new String(output));
			System.out.println("Decrypted string: " + new String(decrypted));
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
