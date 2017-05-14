package prospring.ch3;

import org.springframework.context.support.GenericXmlApplicationContext;

/**
 * change import 1 nd 2 for xml and annotation - coliseum by name
 */
//1
import prospring.ch3.annotation.MessageRender;
//2
//import prospring.ch3.xml.MessageRender;

public class AppSetterAndConstructorDITest {
    public static void main(String[] args){
        GenericXmlApplicationContext cntx = new GenericXmlApplicationContext();
        //1
        //cntx.load("classpath:ch3/ch3.app-xml-setterDI.xml");
        //2
        cntx.load("ch3/ch3.app-annotation-setterDI.xml");
        cntx.refresh();
        MessageRender render = cntx.getBean("messageRenderAnnotation", MessageRender.class);
        render.render();
    }
}
