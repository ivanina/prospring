package prospring.ch2.applicaion;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import prospring.ch2.render.MessageRender;

public class ApplicationHelloWorldSpringDI {
    public static void main(String[] args){
        ApplicationContext ctx = new ClassPathXmlApplicationContext("ch2.app-context.xml");
        MessageRender render = ctx.getBean("render",MessageRender.class);
        render.render();
    }
}
