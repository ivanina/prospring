package prospring.ch4;

import lombok.Getter;
import lombok.Setter;
import org.springframework.context.support.GenericXmlApplicationContext;

@Getter
@Setter
public class AppLazyInitBean {
    final private String DEFAULT_NAME="undefined";
    private String name;
    private Integer age;

    public void init(){
        System.out.println(">> Initialisation bean");
        if(name == null){
            System.out.println("Using default name");
            name = DEFAULT_NAME;
        }
        if(age == null){
            throw new IllegalArgumentException("Age can't be empty");
        }
    }

    @Override
    public String toString(){
        return "Nme: "+name+", age: "+age;
    }

    public static AppLazyInitBean getBean(GenericXmlApplicationContext cntx, String beanName){
        AppLazyInitBean bean = cntx.getBean(beanName,AppLazyInitBean.class);
        System.out.println(bean);
        return bean;
    }

    public static void main(String[] args) {
        GenericXmlApplicationContext cntx = new GenericXmlApplicationContext();
        cntx.load("classpath:ch4/ch4.app-lazy-init-bean.xml");
        cntx.refresh();

        getBean(cntx, "lazyInitBean1");
        getBean(cntx, "lazyInitBean2");
        getBean(cntx, "lazyInitBean3");
    }
}
