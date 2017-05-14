package prospring.ch3.inject_collection;

import org.springframework.stereotype.Service;

@Service("oracle")
public class HappyOracle implements Oracle {
    public String broadcast() {
        return "Everyone should be happy";
    }

    @Override
    public String toString(){
        return "Oracle said: " + broadcast();
    }
}
