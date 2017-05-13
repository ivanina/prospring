package prospring.ch2.render;

import prospring.ch2.provider.MessageProvider;

public class StandardOutMessageRender implements MessageRender {
    MessageProvider provider;
    public void render() {
        if(provider == null){
            throw new RuntimeException("you mast set the MessageProvider");
        }
        System.out.println(provider.getMessage());
    }

    public void setMessageProvider(MessageProvider provider) {
        this.provider = provider;
    }

    public MessageProvider getMessageProvider() {
        return this.provider;
    }
}
