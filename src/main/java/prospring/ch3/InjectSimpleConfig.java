package prospring.ch3;

import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Service;

@Getter
@Setter
@Service("injectSimpleConfig")
public class InjectSimpleConfig {
    private String name = "Chris Ri";
    private Integer age = 70;
}
