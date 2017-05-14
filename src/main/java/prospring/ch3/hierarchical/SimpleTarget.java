package prospring.ch3.hierarchical;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SimpleTarget {
    private String val;

    @Override
    public String toString(){
        return getVal();
    }
}
