package com.guardtime.signer;

import com.guardtime.ksi.SignerBuilder;
import com.guardtime.ksi.exceptions.KSIException;
import com.guardtime.ksi.service.KSISigningClientServiceAdapter;
import com.guardtime.ksi.service.client.KSIServiceCredentials;
import com.guardtime.ksi.service.client.KSISigningClient;
import com.guardtime.ksi.service.client.ServiceCredentials;
import com.guardtime.ksi.service.client.http.CredentialsAwareHttpSettings;
import com.guardtime.ksi.service.http.simple.SimpleHttpSigningClient;
import com.guardtime.ksi.unisignature.KSISignature;
import com.guardtime.ksi.Signer;

public class KsiSigner {

    public static KSISignature signHash(String hash) throws KSIException {
        String loginId = "joe";
        String loginKey = "secret test";
        String aggregatorUrl = "http://host.net:8080/gt-signingservice";

        ServiceCredentials credentials = new KSIServiceCredentials(loginId, loginKey);
        CredentialsAwareHttpSettings credentialsSettings = new CredentialsAwareHttpSettings(aggregatorUrl, credentials);
        KSISigningClient ksiSigningClient = new SimpleHttpSigningClient(credentialsSettings);
        Signer signer = new SignerBuilder().setSigningService(new KSISigningClientServiceAdapter(ksiSigningClient)).build();

        return signer.sign(hash.getBytes());
    }

}
