package prospring.ch3.method_injection;

import org.springframework.context.support.GenericXmlApplicationContext;

public class AppDemo {
    public static void main(String[] args) {
        GenericXmlApplicationContext cntx = new GenericXmlApplicationContext();
        cntx.load("classpath:ch3/ch3.app-method-injection.xml");
        cntx.refresh();

        DemoBean standardLookupBean = cntx.getBean("standardLookupDemoBean",DemoBean.class);
        DemoBean abstractLookupBean = cntx.getBean("abstractLookupDemoBean", DemoBean.class);

        standardLookupBean.someOperation();
        standardLookupBean.someOperation();

        abstractLookupBean.someOperation();
        abstractLookupBean.someOperation();
    }
}
