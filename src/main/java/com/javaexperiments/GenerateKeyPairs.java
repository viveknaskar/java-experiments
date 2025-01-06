package com.javaexperiments;

/**
 * This code demonstrates generating a public-private key pair using the Curve25519 algorithm,
 * implemented via the XDH (Diffie-Hellman over elliptic curves) standard.
 * NamedParameterSpec is used to specify the exact curve (X25519).
 * The public and private keys are encoded and can be saved for future use.
 */

import java.security.*;
import java.security.spec.NamedParameterSpec;

public class GenerateKeyPairs {

    public static void main(String[] args) {
        try {
            // Initialize KeyPairGenerator with the XDH algorithm
            KeyPairGenerator keyPairGenerator = KeyPairGenerator.getInstance("XDH");

            // Specify the curve parameters (X25519 for key agreement)
            NamedParameterSpec paramSpec = new NamedParameterSpec("X25519");
            keyPairGenerator.initialize(paramSpec);

            // Generate the key pair
            KeyPair keyPair = keyPairGenerator.generateKeyPair();

            // Extract and display public key details
            PublicKey publicKey = keyPair.getPublic();
            System.out.println("--- Public Key ---");
            System.out.println("Algorithm: " + publicKey.getAlgorithm());
            System.out.println("Format: " + publicKey.getFormat());
            byte[] pubKeyEncoded = publicKey.getEncoded(); // Public key byte array
            System.out.println("Encoded Key: " + bytesToHex(pubKeyEncoded));

            // Extract and display private key details
            PrivateKey privateKey = keyPair.getPrivate();
            System.out.println("--- Private Key ---");
            System.out.println("Algorithm: " + privateKey.getAlgorithm());
            System.out.println("Format: " + privateKey.getFormat());
            byte[] priKeyEncoded = privateKey.getEncoded(); // Private key byte array
            System.out.println("Encoded Key: " + bytesToHex(priKeyEncoded));

        } catch (NoSuchAlgorithmException | InvalidAlgorithmParameterException e) {
            System.err.println("Error occurred while generating key pair: " + e.getMessage());
        }
    }

    /**
     * Converts a byte array to a hexadecimal string representation.
     *
     * @param bytes the byte array to convert.
     * @return the hexadecimal string.
     */
    private static String bytesToHex(byte[] bytes) {
        StringBuilder hexString = new StringBuilder();
        for (byte b : bytes) {
            String hex = Integer.toHexString(0xFF & b);
            if (hex.length() == 1) {
                hexString.append('0');
            }
            hexString.append(hex);
        }
        return hexString.toString();
    }
}
