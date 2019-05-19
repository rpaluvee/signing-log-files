package com.guardtime.signer;

import com.guardtime.ksi.SignerBuilder;
import com.guardtime.ksi.exceptions.KSIException;
import com.guardtime.ksi.unisignature.KSISignature;
import com.guardtime.ksi.Signer;

public class KsiSigner {

    public static KSISignature signHash(String hash) throws KSIException {
        Signer signer = new SignerBuilder().build();
        return signer.sign(hash.getBytes());
    }

}
