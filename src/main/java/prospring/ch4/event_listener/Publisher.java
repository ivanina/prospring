package prospring.ch4.event_listener;

import lombok.Setter;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;


public class Publisher implements ApplicationContextAware {
    private ApplicationContext context;
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.context = applicationContext;
    }

    public void publish(String message){
        context.publishEvent(new MessageEvent(this, message));
    }
}
