package prospring.ch4.informing_by_platform;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanNameAware;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

public class ItselfBeanNameAndContext implements BeanNameAware, DoSomething, ApplicationContextAware {
    private String beanName;
    private String tempDir;

    private ApplicationContext context;

    @Autowired
    HelperToDo helper;

    public void setBeanName(String name) {
        this.beanName = name;
    }

    public void todo() {
        System.out.println("ItselfBean ["+beanName+"]");
        System.out.println("Application name: "+context.getApplicationName());
        DoSomething bean = context.getBean("mainBean",DoSomething.class);
        helper.printDo();
        System.out.println("We are in 'ItselfBean'. Now to-do by 'mainBean'");
        bean.todo();
    }

    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.context = applicationContext;
    }
}
