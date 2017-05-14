package prospring.ch3.method_injection;

import java.util.Date;

public class Helper {
    public void doSomething(){
        System.out.println("Do something helpful ("+ this.hashCode() +")");
    }
}
