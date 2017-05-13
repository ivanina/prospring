package prospring.ch3;


import lombok.Getter;
import lombok.Setter;
import org.springframework.context.support.GenericXmlApplicationContext;

@Getter
@Setter
public class InjectSimpleXml {
    private String name;
    private Integer age;
    public static void main(String[] args) {
        GenericXmlApplicationContext cntx = new GenericXmlApplicationContext();
        cntx.load("classpath:ch3.app-inject-simple-sml.xml");
        cntx.refresh();

        InjectSimpleXml simple = cntx.getBean("injectSimple", InjectSimpleXml.class);
        System.out.println(simple);
    }

    public String toString(){
        return "Name: "+this.getName()+"; Age: "+ getAge();
    }
}
