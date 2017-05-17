package prospring.ch4.shutdown_hook;

import org.springframework.context.support.GenericXmlApplicationContext;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

@Service("shutdownHook")
public class AppShutdownHook {
    @PostConstruct
    public void postConstructor(){
        System.out.println("(+) The Bean CREATED");
    }
    @PreDestroy
    public void preDestroy(){
        System.out.println("(-) The Bean has ready to DESTROY");
    }

    public static void main(String[] args) {
        GenericXmlApplicationContext cntx = new GenericXmlApplicationContext();
        cntx.load("classpath:ch4/ch4.app-shutdown-hook.xml");
        cntx.registerShutdownHook();
        cntx.refresh();

        AppShutdownHook bean = cntx.getBean("shutdownHook",AppShutdownHook.class);
        try {
            bean.doSomething();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void doSomething() throws InterruptedException {
        System.out.println("........ TODO:  ");
        for(int i = 0; i<5; i++){
            Thread.sleep(500);
            System.out.print("..");
        }
        System.out.println("........ done!");
    }
}
