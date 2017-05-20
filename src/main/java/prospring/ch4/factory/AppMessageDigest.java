package prospring.ch4.factory;

import org.springframework.context.support.GenericXmlApplicationContext;

import java.security.MessageDigest;

public class AppMessageDigest {
    public static void main(String[] args) {
        GenericXmlApplicationContext cntx = new GenericXmlApplicationContext();
        cntx.load("classpath:ch4/ch4.app-factory-message-digest.xml");
        cntx.refresh();

        MessageDigester digester = cntx.getBean("digester",MessageDigester.class);
        System.out.println("\n** Using standard bean factory");
        digester.digest("Hello, space!");

        // direct access to factory and run digest method manually
        MessageDigestFactoryBean directDigest = cntx.getBean("&shaDigest",MessageDigestFactoryBean.class);
        try {
            MessageDigest shaDigest = directDigest.getObject();
            System.out.println("\n** Direct digest from '&shaDigest'");
            System.out.println(shaDigest.digest("This is not good".getBytes()));
        } catch (Exception e) {
            e.printStackTrace();
        }

        // using factory-bean and factory-method
        MessageDigester digester2 = cntx.getBean("digester2",MessageDigester.class);
        System.out.println("\n** Using factory-bean and factory-method");
        digester2.digest("O-la-la-ha!");
    }
}
