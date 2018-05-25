package com.yo.news.open.sdk.Signature;

import sun.misc.BASE64Encoder;

import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import javax.xml.bind.DatatypeConverter;
import java.io.UnsupportedEncodingException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

/**
 * Author:JAN
 * Date:14:32 2018-5-15
 * Note:
 **/
public class HmacSHA1Signer extends Signer {


    public HmacSHA1Signer() {
    }

    private static final String ALGORITHM_NAME = "HmacSHA1";
    public static final String ENCODING = "UTF-8";
    final static BASE64Encoder base64Encoder = new BASE64Encoder();

    public String signString(String stringToSign, String accessKeySecret) {
        try {
            Mac mac = Mac.getInstance(ALGORITHM_NAME);
            mac.init(new SecretKeySpec(accessKeySecret.getBytes(ENCODING), ALGORITHM_NAME));
            byte[] signData = mac.doFinal(stringToSign.getBytes(ENCODING));
            return base64Encoder.encode(signData);
//            String e = DatatypeConverter.printBase64Binary(signData);

        } catch (NoSuchAlgorithmException nosuchAlogorithmEx) {
            throw new IllegalArgumentException(nosuchAlogorithmEx.toString());
        } catch (UnsupportedEncodingException unsupportedEncodingEx) {
            throw new IllegalArgumentException(unsupportedEncodingEx.toString());
        } catch (InvalidKeyException invalidKeyExeption) {
            throw new IllegalArgumentException(invalidKeyExeption.toString());
        }
    }


    public String getSignerName() {
        return ALGORITHM_NAME;
    }

    public String getSignerVersion() {
        return "1.0";
    }

    public String getSignerType() {
        return null;
    }
}