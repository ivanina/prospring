package prospring.ch4.informing_by_platform;

import org.springframework.stereotype.Service;

@Service("HelperToDo")
public class HelperToDo {
    public void printDo(){
        System.out.println("........ TODO:  ");
        try {
            for (int i = 0; i < 5; i++) {
                Thread.sleep(500);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.print("..");
        System.out.println("........ done!");
    }
}
