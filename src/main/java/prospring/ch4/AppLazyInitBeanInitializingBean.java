package prospring.ch4;

import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.support.GenericXmlApplicationContext;

@Getter
@Setter
public class AppLazyInitBeanInitializingBean implements InitializingBean {
    final private String DEFAULT_NAME="undefined";
    final private static String[] BEAN_NAMES = {"bean1","bean2","bean3"};
    private String name;
    private Integer age;


    public void afterPropertiesSet() throws Exception {
        System.out.println(">> Initialisation bean");
        if(name == null){
            System.out.println("Using default name");
            name = DEFAULT_NAME;
        }
        if(age == null){
            //throw new IllegalArgumentException("Age can't be empty");
            System.out.println("ERROR: Age can't be empty");
        }
    }


    @Override
    public String toString(){
        return "Nme: "+name+", age: "+age;
    }

    public static AppLazyInitBeanInitializingBean getBean(GenericXmlApplicationContext cntx, String beanName){
        AppLazyInitBeanInitializingBean bean = cntx.getBean(beanName,AppLazyInitBeanInitializingBean.class);
        System.out.println(bean);
        return bean;
    }

    public static void main(String[] args) {
        GenericXmlApplicationContext cntx = new GenericXmlApplicationContext();
        cntx.load("classpath:ch4/ch4.app-lazy-init-bean-InitializingBean.xml");
        cntx.refresh();

        for (String beanName:BEAN_NAMES){
            getBean(cntx, beanName);
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }
}
