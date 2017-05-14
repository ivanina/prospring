package prospring.ch3.method_replacement;

import org.springframework.beans.factory.support.MethodReplacer;

import java.lang.reflect.Method;

public class FormatMessageReplacer implements MethodReplacer {
    public Object reimplement(Object obj, Method method, Object[] args) throws Throwable {
        if(checkMethod(method)){
            return "<h2>"+args[0]+"</h2>";
        }else {
            throw new IllegalArgumentException("Unable to replace method");
        }
    }

    private boolean checkMethod(Method method){
        if(!"formatMessage".equals(method.getName())) return false;
        if(method.getReturnType() != String.class) return false;
        if(method.getParameterTypes()[0] != String.class) return false;
        return true;
    }
}
