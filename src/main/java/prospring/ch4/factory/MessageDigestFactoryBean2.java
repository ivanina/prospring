package prospring.ch4.factory;

import lombok.Getter;
import lombok.Setter;

import java.security.MessageDigest;

@Getter
@Setter
public class MessageDigestFactoryBean2 {
    private String algorithmName = "MD5";
    public MessageDigest createInstance() throws Exception {
        return MessageDigest.getInstance(algorithmName);
    }
}
