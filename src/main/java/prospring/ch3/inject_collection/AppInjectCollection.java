package prospring.ch3.inject_collection;

import org.springframework.context.support.GenericXmlApplicationContext;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Map;
import java.util.Set;

@Service("injectCollection")
public class AppInjectCollection {

    @Resource(name = "testMap")
    private Map<String,Object> map;

    @Resource(name = "testSet")
    private Set<Object> set;

    public static void main(String[] args) {
        GenericXmlApplicationContext cntx = new GenericXmlApplicationContext();
        cntx.load("classpath:ch3/ch3.app-inject-collection.xml");
        cntx.refresh();

        AppInjectCollection instance = cntx.getBean("injectCollection",AppInjectCollection.class);
        instance.displayData();

    }

    private void displayData(){
        System.out.println("Map:");
        for(Map.Entry<String , Object> entry : map.entrySet()){
            System.out.println("   Key: "+ entry.getKey() + "\n   Val: " + entry.getValue());
        }
        System.out.println("Set:");
        for (Object o : set){
            System.out.println("   Val: "+ o);
        }
    }
}
