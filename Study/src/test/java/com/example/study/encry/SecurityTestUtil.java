package com.example.study.encry;

import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import java.security.Key;
import java.security.SecureRandom;

public class SecurityTestUtil {




    // optional value AES/DES/DESede
    public static String DES = "AES";
    // optional value AES/DES/DESede
    public static String CIPHER_ALGORITHM = "AES";

    public static Key getKey(byte[] sKey) {
        try {
            if (sKey == null || sKey.length == 0) {
                throw new Exception();
            }
            KeyGenerator _generator = KeyGenerator.getInstance("AES");
            SecureRandom secureRandom = SecureRandom.getInstance("SHA1PRNG");
            secureRandom.setSeed(sKey);
            _generator.init(128, secureRandom);
            return _generator.generateKey();
        } catch (Exception e) {
            throw new RuntimeException(" 密钥出现异常 ");
        }
    }

    public static byte[] encrypt(byte[] data, byte[] key) throws Exception {
        SecureRandom sr = new SecureRandom();
        Key secureKey = getKey(key);
        Cipher cipher = Cipher.getInstance(CIPHER_ALGORITHM);
        cipher.init(Cipher.ENCRYPT_MODE, secureKey, sr);
        byte[] bt = cipher.doFinal(data);
        //String strS = new BASE64Encoder().encode(bt);
        return bt;
    }


    public static byte[] decrypt(byte[] data, byte[] key) throws Exception {
        SecureRandom sr = new SecureRandom();
        Cipher cipher = Cipher.getInstance(CIPHER_ALGORITHM);
        Key secureKey = getKey(key);
        cipher.init(Cipher.DECRYPT_MODE, secureKey, sr);
        byte[] res = cipher.doFinal(data);
        return res;
    }

    public static void main(String[] args) throws Exception {
        String message = "123456";
        String key = "key_123456";
        byte[] encryptMsgArray = encrypt(message.getBytes(), key.getBytes());
        System.out.println("加密信息");
        System.out.println(new String(encryptMsgArray));

        byte[] decryptedMsgArray = decrypt(encryptMsgArray, key.getBytes());
        System.out.println("解密信息");
        System.out.println(new String(decryptedMsgArray));
    }


}
