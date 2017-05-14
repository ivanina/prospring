package prospring.ch3.inherit;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SimpleBean {
    String name;
    Integer age;

    @Override
    public String toString(){
        return "Name: "+name+"\nAge: "+age;
    }
}
