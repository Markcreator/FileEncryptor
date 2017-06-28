package me.Markcreator.FileEncryptor;

import javax.crypto.Cipher;

public class EncryptorService {

	private static EncryptorService encryptorService = new EncryptorService();
	private static Cipher cipher;
	
	private EncryptorService() {
		try {
			cipher = Cipher.getInstance("AES");
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static String transcode(int mode, String input, AESKey key) {
		try {
			cipher.init(mode, key.getKeySpec());
			return new String(cipher.doFinal(input.getBytes()));
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
}
