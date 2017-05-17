package prospring.ch4;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.support.GenericXmlApplicationContext;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

public class InitializingBeanMixt implements InitializingBean, DisposableBean {
    public void afterPropertiesSet() throws Exception {
        System.out.println("+ Interface implementation init method: afterPropertiesSet");
    }
    public void initXmlConfigMethod(){
        System.out.println("+ XMl configuration init method: initXmlConfigMethod");
    }
    @PostConstruct
    public void initAnnotationMethod(){
        System.out.println("+ Annotation configuration init method: initAnnotationMethod");
    }

    public static void main(String[] args) {
        GenericXmlApplicationContext cntx = new GenericXmlApplicationContext();
        cntx.load("classpath:ch4/ch4.app-initializing-bean-mixt.xml");
        cntx.refresh();

        InitializingBeanMixt beanMixt = cntx.getBean("beanMixt", InitializingBeanMixt.class);

        try {
            System.out.println("\n............sleep\n");
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        cntx.destroy();
    }

    public void destroyXmlConfigMethod(){
        System.out.println("- Destroy XMl configuration destroy method: destroyXmlConfigMethod");
    }

    @PreDestroy
    public void destroyAnnotationMethod(){
        System.out.println("- Destroy annotation configuration destroy method: destroyAnnotationMethod");
    }

    public void destroy(){
        System.out.println("- Destroy Interface implementation DisposableBean: destroy");
    }
}
