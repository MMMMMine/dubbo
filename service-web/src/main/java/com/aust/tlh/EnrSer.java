package com.aust.tlh;

import java.io.ByteArrayOutputStream;
import java.security.Security;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

/**
 * 类描述:
 * Created by tanglinhui on 2017/1/6.
 * Version 1.0
 */
public class EnrSer {
    private static SignService signService = null;

    private SignService() {
    }

    public static SignService getInstance() {
        if(null == signService) {
            signService = new SignService();
        }

        return signService;
    }

    private byte[] sign(String cert, String password, byte[] data, boolean isDetach) {
        byte[] signedData = (byte[])null;

        try {
            CertDTO e = CertUtil.getCertInfo(password, cert);
            X509Certificate cerx509 = e.getCert()[0];
            ArrayList certList = new ArrayList();
            CMSProcessableByteArray msg = new CMSProcessableByteArray(data);
            certList.add(cerx509);
            JcaCertStore certs = new JcaCertStore(certList);
            CMSSignedDataGenerator gen = new CMSSignedDataGenerator();
            ContentSigner sha1Signer = (new JcaContentSignerBuilder("SHA1withRSA")).setProvider("BC").build(e.getPriKey());
            gen.addSignerInfoGenerator((new JcaSignerInfoGeneratorBuilder((new JcaDigestCalculatorProviderBuilder()).setProvider("BC").build())).build(sha1Signer, cerx509));
            gen.addCertificates(certs);
            CMSSignedData sigData = gen.generate(msg, isDetach);
            signedData = sigData.getEncoded();
        } catch (Exception var14) {
            var14.printStackTrace();
        }

        return signedData;
    }

    public byte[] detachSign(String cert, String password, byte[] data) {
        return this.sign(cert, password, data, false);
    }

    public int verifyDetachSign(byte[] data, byte[] signData) {
        try {
            CMSProcessableByteArray e = new CMSProcessableByteArray(data);
            CMSSignedData s = new CMSSignedData(e, signData);
            Store certStore = s.getCertificates();
            SignerInformationStore signers = s.getSignerInfos();
            Collection c = signers.getSigners();
            Iterator it = c.iterator();
            int verified = 0;
            int size = 0;

            while(it.hasNext()) {
                ++size;
                SignerInformation signer = (SignerInformation)it.next();
                Collection certCollection = certStore.getMatches(signer.getSID());
                Iterator certIt = certCollection.iterator();
                X509CertificateHolder cert = (X509CertificateHolder)certIt.next();
                if(signer.verify((new JcaSimpleSignerInfoVerifierBuilder()).setProvider("BC").build(cert))) {
                    ++verified;
                }
            }

            if(size == verified) {
                return 1;
            } else {
                return 0;
            }
        } catch (Exception var15) {
            return 0;
        }
    }

    public byte[] attachSign(String cert, String password, byte[] data) {
        return this.sign(cert, password, data, true);
    }

    public byte[] verifyAttachSign(byte[] signData) {
        try {
            byte[] e = null;
            CMSSignedData s = new CMSSignedData(signData);
            Store certStore = s.getCertificates();
            SignerInformationStore signers = s.getSignerInfos();
            Collection c = signers.getSigners();
            Iterator it = c.iterator();
            int verified = 0;
            int size = 0;

            while(it.hasNext()) {
                ++size;
                SignerInformation signer = (SignerInformation)it.next();
                Collection certCollection = certStore.getMatches(signer.getSID());
                Iterator certIt = certCollection.iterator();
                X509CertificateHolder cert = (X509CertificateHolder)certIt.next();
                if(signer.verify((new JcaSimpleSignerInfoVerifierBuilder()).setProvider("BC").build(cert))) {
                    ++verified;
                    CMSTypedData cmsData = s.getSignedContent();
                    e = (byte[])((byte[])cmsData.getContent());
                }
            }

            if(size == verified) {
                return e;
            } else {
                return null;
            }
        } catch (Exception var15) {
            return null;
        }
    }

    public byte[] decryptEnvelop(String cert, String password, byte[] bEnvelop) {
        byte[] sign = null;

        try {
            CMSEnvelopedData e = new CMSEnvelopedData(bEnvelop);
            RecipientInformationStore ris = e.getRecipientInfos();
            CertDTO certDto = CertUtil.getCertInfo(password, cert);
            if(ris == null) {
                sign = null;
            }

            Collection c = ris.getRecipients();

            RecipientInformation recipient;
            for(Iterator it = c.iterator(); it.hasNext(); sign = recipient.getContent((new JceKeyTransEnvelopedRecipient(certDto.getPriKey())).setProvider("BC"))) {
                recipient = (RecipientInformation)it.next();
            }
        } catch (Exception var11) {
            var11.printStackTrace();
        }

        return sign;
    }

    public byte[] encryptEnvelop(String cert, byte[] bOrgData) {
        byte[] envelopData = null;
        X509Certificate x509 = CertUtil.getPublicCert(cert);
        CMSEnvelopedDataGenerator gen = new CMSEnvelopedDataGenerator();

        try {
            CMSProcessableByteArray e = new CMSProcessableByteArray(bOrgData);
            gen.addRecipientInfoGenerator((new JceKeyTransRecipientInfoGenerator(x509)).setProvider("BC"));
            CMSEnvelopedData enveloped = gen.generate(e, (new JceCMSContentEncryptorBuilder(CMSAlgorithm.DES_EDE3_CBC)).setProvider("BC").build());
            ContentInfo a = enveloped.toASN1Structure();
            ByteArrayOutputStream bOut = new ByteArrayOutputStream();
            DEROutputStream dOut = new DEROutputStream(bOut);
            dOut.writeObject(a);
            envelopData = bOut.toByteArray();
        } catch (Exception var11) {
            var11.printStackTrace();
        }

        return envelopData;
    }

    static {
        BouncyCastleProvider provider = new BouncyCastleProvider();
        Security.addProvider(provider);
    }
}
