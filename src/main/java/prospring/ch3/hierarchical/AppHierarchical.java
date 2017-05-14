package prospring.ch3.hierarchical;

import org.springframework.context.support.GenericXmlApplicationContext;

public class AppHierarchical {
    public static void main(String[] args) {

        GenericXmlApplicationContext parent = new GenericXmlApplicationContext();
        parent.load("classpath:ch3/ch3.app-hierarchical-parent.xml");
        parent.refresh();

        GenericXmlApplicationContext child = new GenericXmlApplicationContext();
        child.load("classpath:ch3/ch3.app-hierarchical-child.xml");
        child.setParent(parent);
        child.refresh();

        SimpleTarget target1 = (SimpleTarget) child.getBean("target1");
        SimpleTarget target2 = (SimpleTarget) child.getBean("target2");
        SimpleTarget target3 = (SimpleTarget) child.getBean("target3");

        System.out.println(target1);
        System.out.println(target2);
        System.out.println(target3);
    }
}
