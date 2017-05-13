package prospring.ch3.annotation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;


@Service("messageRenderAnnotation")
public class MessageRenderImpl implements MessageRender {

    private MessageProvider provider;

    public void render() {
        if(provider == null){
            throw new RuntimeException("you mast set the MessageProvider");
        }
        System.out.println(provider.getMessage());
    }

    @Resource(name = "messageProviderAnnotation")
    public void setMessageProvider(MessageProvider provider) {
        this.provider = provider;
    }

    public MessageProvider getMessageProvider() {
        return this.provider;
    }
}
