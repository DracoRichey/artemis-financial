package com.snhu.sslserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;

/**
 * Artemis Financial Secure Server Application
 *
 * Implements AES encryption and SHA-256 checksum verification
 * to protect sensitive financial data in transit.
 *
 * Security features:
 * - AES-128 symmetric encryption for data confidentiality
 * - SHA-256 hashing for data integrity verification
 * - HTTPS enforced via SSL certificate (see application.properties)
 */
@SpringBootApplication
@RestController
public class SslServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(SslServerApplication.class, args);
    }

    /**
     * Endpoint that returns a SHA-256 checksum of a sample data string.
     * Demonstrates data integrity verification for Artemis Financial.
     */
    @GetMapping("/hash")
    public String getChecksum() throws NoSuchAlgorithmException {
        String data = "Artemis Financial Customer Data - Confidential";
        String hash = generateSHA256Checksum(data);
        return "<p>Data: " + data + "</p>"
             + "<p>SHA-256 Checksum: " + hash + "</p>";
    }

    /**
     * Endpoint that encrypts a sample string using AES and returns
     * both the encrypted value and its SHA-256 checksum.
     */
    @GetMapping("/encrypt")
    public String encryptData() throws Exception {
        String data = "Artemis Financial - Sensitive Account Data";

        String encrypted = encryptAES(data);
        String checksum = generateSHA256Checksum(encrypted);

        return "<p>Original: " + data + "</p>"
             + "<p>AES Encrypted: " + encrypted + "</p>"
             + "<p>SHA-256 Checksum: " + checksum + "</p>";
    }

    /**
     * Encrypts a string using AES-128 symmetric encryption.
     *
     * @param data plaintext string to encrypt
     * @return Base64-encoded ciphertext
     */
    public static String encryptAES(String data) throws Exception {
        KeyGenerator keyGen = KeyGenerator.getInstance("AES");
        keyGen.init(128);
        SecretKey secretKey = keyGen.generateKey();

        Cipher cipher = Cipher.getInstance("AES");
        cipher.init(Cipher.ENCRYPT_MODE, secretKey);

        byte[] encryptedBytes = cipher.doFinal(data.getBytes());
        return Base64.getEncoder().encodeToString(encryptedBytes);
    }

    /**
     * Generates a SHA-256 hash of the input string for integrity verification.
     *
     * @param data input string to hash
     * @return hex-encoded SHA-256 hash
     */
    public static String generateSHA256Checksum(String data) throws NoSuchAlgorithmException {
        MessageDigest digest = MessageDigest.getInstance("SHA-256");
        byte[] hashBytes = digest.digest(data.getBytes());

        StringBuilder hexString = new StringBuilder();
        for (byte b : hashBytes) {
            hexString.append(String.format("%02x", b));
        }
        return hexString.toString();
    }
}
