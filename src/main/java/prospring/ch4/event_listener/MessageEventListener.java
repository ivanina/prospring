package prospring.ch4.event_listener;

import org.springframework.context.ApplicationListener;

public class MessageEventListener implements ApplicationListener<MessageEvent> {
    public void onApplicationEvent(MessageEvent event) {
        System.out.println("We have new message: "+event.getMessage());
    }
}
