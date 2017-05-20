package prospring.ch4.informing_by_platform;

import org.springframework.beans.factory.BeanNameAware;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.GenericXmlApplicationContext;
import org.springframework.stereotype.Service;

@Service("mainBean")
public class AppItselfAware implements DoSomething, BeanNameAware {
    private String beanName;
    @Autowired
    HelperToDo helper;

    public static void main(String[] args) {
        GenericXmlApplicationContext cntx = new GenericXmlApplicationContext();
        cntx.load("classpath:ch4/ch4.app-itself-aware.xml");
        cntx.refresh();

        DoSomething bean1 = cntx.getBean("itselfContextBean",DoSomething.class);
        bean1.todo();
    }

    public void todo() {
        System.out.println("Main class ["+beanName+"]");
        helper.printDo();
    }


    public void setBeanName(String name) {
        this.beanName = name;
    }
}
