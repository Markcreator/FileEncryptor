package me.Markcreator.FileEncryptor;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import javax.crypto.Cipher;

public class AESEncryptorService {

	private static AESEncryptorService encryptorService = new AESEncryptorService();
	private Cipher cipher;

	private AESEncryptorService() {
		try {
			cipher = Cipher.getInstance("AES");

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static AESEncryptorService getInstance() {
		return encryptorService;
	}
	
	public byte[] transcode(int mode, AESKey key, byte[] input) {
		try {
			cipher.init(mode, key.getKeySpec());

			return cipher.doFinal(input);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public void transcode(int mode, AESKey key, File input, File output) {
		try {
			FileInputStream inputStream = new FileInputStream(input);
			byte[] inputBytes = new byte[(int) input.length()];
			inputStream.read(inputBytes);

			byte[] outputBytes = transcode(mode, key, inputBytes);

			FileOutputStream outputStream = new FileOutputStream(output);
			outputStream.write(outputBytes);

			inputStream.close();
			outputStream.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
