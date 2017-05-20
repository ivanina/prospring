package prospring.ch4.factory;

import org.springframework.beans.factory.FactoryBean;
import org.springframework.beans.factory.InitializingBean;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class MessageDigestFactoryBean implements FactoryBean<MessageDigest> , InitializingBean {

    private String algorithmName = "MD5";
    private MessageDigest messageDigest;

    public MessageDigest getObject() throws Exception {
        return messageDigest;
    }

    public Class<MessageDigest> getObjectType() {
        return MessageDigest.class;
    }

    public boolean isSingleton() {
        return false;
    }

    public void afterPropertiesSet() throws Exception {
        messageDigest = MessageDigest.getInstance(algorithmName);
    }

    public String getAlgorithmName() {
        return algorithmName;
    }

    public void setAlgorithmName(String algorithmName) {
        this.algorithmName = algorithmName;
    }



}
