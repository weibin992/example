package cn.weibin.springboot.util;

import java.io.UnsupportedEncodingException;
import java.security.KeyFactory;
import java.security.MessageDigest;
import java.security.PublicKey;
import java.security.interfaces.RSAPublicKey;
import java.security.spec.X509EncodedKeySpec;
import java.util.Base64;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 加密解密工具类
 * 
 * @author weibin
 */
public abstract class EncryptUtil {

    private static final Logger logger = LoggerFactory.getLogger(EncryptUtil.class);

    private static final String UTF_8 = "UTF-8";

    /**
     * 使用Base64加密
     *
     * @param inputText
     * @return
     */
    public static String base64Encode(String inputText) {
        Base64.Encoder encoder = Base64.getEncoder();
        String value = null;
        try {
            byte[] bytes = inputText.getBytes(UTF_8);
            value = encoder.encodeToString(bytes);
        } catch (UnsupportedEncodingException e) {
            logger.error(e.getMessage(), e);
        }
        return value;
    }

    /**
     * 使用Base64加密
     * 
     * @param bytes
     * @return
     */
    public static String base64EncodeString(byte[] bytes) {
        Base64.Encoder encoder = Base64.getEncoder();
        byte[] byteValues = encoder.encode(bytes);
        String value = null;
        try {
            value = new String(byteValues, UTF_8);
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
        }
        return value;
    }

    /**
     * Base64解密
     * 
     * @param inputText
     * @return
     */
    public static byte[] base64Decode(String inputText) {
        Base64.Decoder decoder = Base64.getDecoder();
        byte[] bytes = null;
        try {
            bytes = decoder.decode(inputText.getBytes(UTF_8));
        } catch (Exception e) {
            logger.error("Base64解密异常", e);
        }
        return bytes;
    }

    /**
     * Base64解密
     * 
     * @param bytes
     * @return
     */
    public static byte[] base64Decode(byte[] bytes) {
        Base64.Decoder decoder = Base64.getDecoder();
        return decoder.decode(bytes);
    }

    /**
     * md5加密
     * 
     * @param inputText
     * @return
     */
    public static String md5(String inputText) {
        return encrypt(inputText, "md5");
    }

    /**
     * sha1加密
     * 
     * @param inputText
     * @return
     */
    public static String sha1(String inputText) {
        return encrypt(inputText, "SHA-1");
    }

    /**
     * md5或者sha-1加密
     * 
     * @param inputText     要加密的内容
     * @param algorithmName 加密算法名称：md5或者sha-1，不区分大小写
     * @return
     */
    private static String encrypt(String inputText, String algorithmName) {
        if (inputText == null || "".equals(inputText.trim())) {
            throw new IllegalArgumentException("请输入要加密的内容");
        }
        if (algorithmName == null || "".equals(algorithmName.trim())) {
            algorithmName = "md5";
        }
        String encryptText = null;
        try {
            MessageDigest m = MessageDigest.getInstance(algorithmName);
            m.update(inputText.getBytes("UTF8"));
            byte s[] = m.digest();
            return byte2Hex(s);
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
        }
        return encryptText;
    }

    /**
     * 返回十六进制字符串
     *
     * @param arr
     * @return
     */
    public static String byte2Hex(byte[] arr) {
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < arr.length; ++i) {
            sb.append(Integer.toHexString((arr[i] & 0xFF) | 0x100).substring(1, 3));
        }
        return sb.toString();
    }

    /**
     * AES加密
     * 
     * @param key
     * @param value
     * @param isBase64
     * @return
     * @throws Exception
     */
    public static String encryptAES(String key, String value, boolean isBase64) throws Exception {
        SecretKeySpec keySpec = new SecretKeySpec(key.getBytes(), "AES");
        Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
        cipher.init(Cipher.ENCRYPT_MODE, keySpec);
        byte[] aesBody = cipher.doFinal(value.getBytes());
        if (isBase64) {
            return base64EncodeString(aesBody);
        } else {
            return byte2Hex(aesBody);
        }
    }

    /**
     * AES解密
     *
     * @param base64Data
     * @return
     * @throws Exception
     */
    public static String decryptAES(String key, String base64Data) throws Exception {
        SecretKeySpec keySpec = new SecretKeySpec(key.getBytes(), "AES");
        Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
        cipher.init(Cipher.DECRYPT_MODE, keySpec);
        return new String(cipher.doFinal(base64Decode(base64Data.getBytes(UTF_8))));
    }

    /**
     * 将公钥字符串转码为PublicKey
     * 
     * @param publickeyStr
     * @return
     */
    public static RSAPublicKey str2Public(String publickeyStr) throws Exception {
        PublicKey publicKey = null;
        byte[] keyBytes;
        keyBytes = base64Decode(publickeyStr.getBytes());
        X509EncodedKeySpec keySpec = new X509EncodedKeySpec(keyBytes);
        KeyFactory keyFactory = KeyFactory.getInstance("RSA");
        publicKey = keyFactory.generatePublic(keySpec);
        return (RSAPublicKey) publicKey;
    }

}
