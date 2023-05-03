package com.atmosferpoc.shared.encryption;

import com.atmosferpoc.shared.constant.ApplicationConstants;
import lombok.experimental.UtilityClass;
import lombok.extern.slf4j.Slf4j;

import javax.crypto.Cipher;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.GCMParameterSpec;
import javax.crypto.spec.PBEKeySpec;
import javax.crypto.spec.SecretKeySpec;
import javax.xml.bind.DatatypeConverter;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.KeySpec;
import java.text.ParseException;
import java.util.Objects;

@Slf4j
@UtilityClass
public class Encryption {
    private static final int SALT_LENGTH_BYTE = 16;
    private static final int IV_LENGTH_BYTE = 12;


    public static void main(String[] args) throws  IOException, ParseException, InterruptedException, NoSuchAlgorithmException {
        /*
        String encText = encryptPassword("Bilal.12", "8CA2ED7FE393CE9CA2BBABA446449C62C0CCCC0401C6DADA8F5D7E4199BF851E");

        String decText = decryptPassword("A98226737905BD346E9E75809CEBE2BD70994A7467479F06DE049F573AED357ACEB3F7B1CD957BF5596288A64FC52C4FD3F505A3", "8CA2ED7FE393CE9CA2BBABA446449C62C0CCCC0401C6DADA8F5D7E4199BF851E");
         */
    }

    public static String encryptPassword(String password, String encKey) {
        byte[] iv = getRandomNonce(IV_LENGTH_BYTE);
        byte[] salt = getRandomNonce(SALT_LENGTH_BYTE);

        byte[] encryptedText = doEncryption(Cipher.ENCRYPT_MODE, password.getBytes(), iv, salt, encKey);
        byte[] encryptedTextWithIv = ByteBuffer.allocate(iv.length + salt.length + encryptedText.length).put(iv).put(salt).put(encryptedText).array();

        return DatatypeConverter.printHexBinary(encryptedTextWithIv);
    }


    public static String decryptPassword(String encPassword, String encKey) {
        byte[] encryptedTextWithIv = DatatypeConverter.parseHexBinary(encPassword);
        var bb = ByteBuffer.wrap(encryptedTextWithIv);
        var iv = new byte[IV_LENGTH_BYTE];
        bb.get(iv);

        var salt = new byte[SALT_LENGTH_BYTE];
        bb.get(salt);

        var encryptedText = new byte[bb.remaining()];
        bb.get(encryptedText);

        return new String(Objects.requireNonNull(doEncryption(Cipher.DECRYPT_MODE, encryptedText, iv, salt, encKey)));
    }

    public static byte[] getRandomNonce(int numBytes) {
        var nonce = new byte[numBytes];
        new SecureRandom().nextBytes(nonce);

        return nonce;
    }

    private static byte[] doEncryption(int mode, byte[] input, byte[] iv, byte[] salt, String encKey) {
        try {
            var cipher = initCipher(mode, iv, salt, encKey);

            return cipher.doFinal(input);

        } catch (Exception e) {
            log.error(String.format(ApplicationConstants.ERROR_LOG_PATTERN, "Encryption", "doEncryption", e.getMessage(), ""));
            return null;
        }
    }

    private static Cipher initCipher(int mode, byte[] iv, byte[] salt, String encKey) throws NoSuchAlgorithmException, InvalidKeySpecException, NoSuchPaddingException, InvalidAlgorithmParameterException, InvalidKeyException {
        var cipher = Cipher.getInstance("AES/GCM/NoPadding");
        var factory = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA256");

        KeySpec spec = new PBEKeySpec(encKey.toCharArray(), salt, 65536, 256);
        SecretKey secretKey = new SecretKeySpec(factory.generateSecret(spec).getEncoded(), "AES");

        var paramSpec = new GCMParameterSpec(128, iv);

        cipher.init(mode, secretKey, paramSpec);

        return cipher;
    }
}