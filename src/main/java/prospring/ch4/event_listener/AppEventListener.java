package prospring.ch4.event_listener;

import org.springframework.context.support.GenericXmlApplicationContext;

public class AppEventListener {
    public static void main(String[] args) {
        GenericXmlApplicationContext cntx = new GenericXmlApplicationContext();
        cntx.load("classpath:ch4/ch4.app-event-listener.xml");
        cntx.refresh();

        Publisher publisher = cntx.getBean("publisher", Publisher.class);
        publisher.publish("Ola-ha-la!");
    }
}
