package prospring.ch4.messaegprovider_javaconfig;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class AppMessageRender {
    public static void main(String[] args) {

        // Configure in XML

        //GenericXmlApplicationContext cntx = new GenericXmlApplicationContext();
        //cntx.load("classpath:ch4/ch4.app-messaegprovider_javaconfig.xml");
        //cntx.refresh();

        // Configure in Java Class

        ApplicationContext cntx = new AnnotationConfigApplicationContext(AppConfig.class);

        MessageRender render = cntx.getBean("render",MessageRender.class);
        render.render();
    }
}
