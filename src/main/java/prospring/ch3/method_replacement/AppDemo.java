package prospring.ch3.method_replacement;

import org.springframework.context.support.GenericXmlApplicationContext;

public class AppDemo {
    public static void main(String[] args) {
        GenericXmlApplicationContext cntx = new GenericXmlApplicationContext();
        cntx.load("classpath:ch3/ch3.app-method-replacement.xml");
        cntx.refresh();

        FormatterMessage replaceFormatter = cntx.getBean("formatter",FormatterMessage.class);
        FormatterMessage standardFormatter = cntx.getBean("normalFormatter",FormatterMessage.class);

        System.out.println(replaceFormatter.formatMessage("Happy!"));
        System.out.println(standardFormatter.formatMessage("Happy!"));
    }
}
