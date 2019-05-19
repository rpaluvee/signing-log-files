package com.guardtime.util;

import org.apache.commons.codec.digest.DigestUtils;

/**
 * The SHA (Secure Hash Algorithm) is one of a number of cryptographic hash functions.
 * A cryptographic hash is like a signature for a text or a data file.
 * SHA-256 algorithm generates an almost-unique, fixed size 256-bit (32-byte) hash.
 * Hash is a one way function – it cannot be decrypted back.
 */
public class Sha256 {

    public static String hash(String originalString) {
        return DigestUtils.sha256Hex(originalString);
    }

}
