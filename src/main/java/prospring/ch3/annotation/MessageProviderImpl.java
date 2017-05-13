package prospring.ch3.annotation;

import org.springframework.stereotype.Service;

@Service("messageProviderAnnotation")
public class MessageProviderImpl implements MessageProvider {
    public String getMessage() {
        return "I am fine! And you?";
    }
}
