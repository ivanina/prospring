package prospring.ch3;

import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.support.GenericXmlApplicationContext;
import org.springframework.stereotype.Service;

@Getter
@Setter
@Service("injectSimple")
public class InjectSimpleAnnotation {
    @Value("Elvis")
    private String name;
    @Value("#{injectSimpleConfig.age+5}")
    private Integer age;
    public static void main(String[] args) {
        GenericXmlApplicationContext cntx = new GenericXmlApplicationContext();
        cntx.load("classpath:ch3.app-inject-simple-annotation.xml");
        cntx.refresh();

        InjectSimpleAnnotation simple = cntx.getBean("injectSimple",InjectSimpleAnnotation.class);
        System.out.println(simple);
    }

    public String toString(){
        return "Name: "+this.getName()+"; Age: "+ getAge();
    }
}
