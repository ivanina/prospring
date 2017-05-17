package prospring.ch4;

import lombok.Getter;
import lombok.Setter;
import org.springframework.context.support.GenericXmlApplicationContext;

import javax.annotation.PostConstruct;
@Getter
@Setter
public class AppLazyInitBeanInitializingAnnotation implements LazyBean {
    final private String DEFAULT_NAME="undefined";
    final private static String[] BEAN_NAMES = {"bean1","bean2","bean3"};
    private String name;
    private Integer age;

    @PostConstruct
    public void initMethod(){
        System.out.println(">> Initialisation bean");
        if(name == null){
            System.out.println("Using default name");
            name = DEFAULT_NAME;
        }
        if(age == null){
            System.out.println("ERROR: Age can't be empty");
        }
    }

    @Override
    public String toString(){
        return "Nme: "+name+", age: "+age;
    }

    public static LazyBean getBean(GenericXmlApplicationContext cntx, String beanName){
        LazyBean bean = cntx.getBean(beanName,LazyBean.class);
        System.out.println(bean);
        return bean;
    }

    public static void main(String[] args) {
        GenericXmlApplicationContext cntx = new GenericXmlApplicationContext();
        cntx.load("classpath:ch4/ch4.app-lazy-init-bean-annotation.xml");
        cntx.refresh();

        for (String beanName:BEAN_NAMES){
            getBean(cntx, beanName);
            try {
                System.out.println("............sleep");
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }
}
