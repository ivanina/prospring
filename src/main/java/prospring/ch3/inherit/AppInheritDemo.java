package prospring.ch3.inherit;

import org.springframework.context.support.GenericXmlApplicationContext;

public class AppInheritDemo {
    public static void main(String[] args) {
        GenericXmlApplicationContext cntx = new GenericXmlApplicationContext();
        cntx.load("classpath:ch3/ch3.app-inherit.xml");
        cntx.refresh();

        SimpleBean parent = cntx.getBean("parentBean", SimpleBean.class);
        SimpleBean child = cntx.getBean("childBean", SimpleBean.class);

        System.out.println(parent);
        System.out.println(child);
    }
}
