package prospring.ch4.factory;

import lombok.Setter;

import java.security.MessageDigest;
import java.util.Arrays;

@Setter
public class MessageDigester {
    private MessageDigest digest1;
    private MessageDigest digest2;

    public void digest(String msg){
        System.out.println("* Using digest-1 *");
        digest(msg,digest1);
        System.out.println("* Using digest-2 *");
        digest(msg,digest2);
    }

    private void digest(String msg, MessageDigest md){
        System.out.println("Using algorithm: "+ md.getAlgorithm());
        md.reset();
        System.out.println( Arrays.toString(md.digest( msg.getBytes() ) ) );
    }
}
