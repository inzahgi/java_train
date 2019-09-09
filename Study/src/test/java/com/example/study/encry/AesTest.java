package com.example.study.encry;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.spec.IvParameterSpec;
import java.security.SecureRandom;

public class AesTest {


    public static void main(String[] args) throws Exception{
        //随机生成iv
        SecureRandom srandom = new SecureRandom();
        byte[] iv = new byte[128/8];
        srandom.nextBytes(iv);
        IvParameterSpec ivspec = new IvParameterSpec(iv);

        //随机生成 aes密钥
        KeyGenerator kgen = KeyGenerator.getInstance("AES");
        SecretKey skey = kgen.generateKey();


        //生成加密模式的 密码器
        Cipher ci = Cipher.getInstance("AES/CBC/PKCS5Padding");
        ci.init(Cipher.ENCRYPT_MODE, skey, ivspec);

        //做加密
        String plainText = "abcd";
        byte[] input = plainText.getBytes("UTF-8");
        byte[] encoded = ci.doFinal(input);
        System.out.println(encoded);

        //生成解密模式的 密码器
        Cipher ci2 = Cipher.getInstance("AES/CBC/PKCS5Padding");
        ci2.init(Cipher.DECRYPT_MODE, skey, ivspec);

        //解密
        byte[] encoded2 = encoded;
        String plainText2 = new String(ci2.doFinal(encoded2), "UTF-8");
        System.out.println(plainText2);

    }
}
