package prospring.ch3.method_injection;

public abstract class AbstractLookupDemoBean implements DemoBean {
    public abstract Helper getHelper();

    public void someOperation() {
        getHelper().doSomething();
    }
}
