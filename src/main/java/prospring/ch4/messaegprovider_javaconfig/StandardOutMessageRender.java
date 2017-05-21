package prospring.ch4.messaegprovider_javaconfig;


public class StandardOutMessageRender implements MessageRender {
    private MessageProvider provider;
    public void render() {
        if(provider == null) throw new RuntimeException("Message provider is empty. You mast set the property");
        System.out.println("***  "+provider.getMessage()+ "  ***");
    }

    public void setMessageProvider(MessageProvider provider) {
        this.provider = provider;
    }

    public MessageProvider getMessageProvider() {
        return provider;
    }


}
