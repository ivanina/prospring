package prospring.ch3.xml;

public class MessageRenderImpl implements MessageRender {

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
