package prospring.ch3.method_injection;

public class StandardLookupDemoBean implements DemoBean {
    Helper helper;

    public void setHelper(Helper helper){
        this.helper = helper;
    }

    public Helper getHelper() {
        return this.helper;
    }

    public void someOperation() {
        helper.doSomething();
    }
}
