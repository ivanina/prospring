package prospring.ch2.applicaion;

import prospring.ch2.provider.MessageProvider;
import prospring.ch2.render.MessageRender;
import prospring.ch2.factory.MessageSupportFactory;

public class ApplicationHelloWorldSupportFactory {
    public static void main(String[] args){
        MessageRender mr = MessageSupportFactory.getInstance().getRender();
        MessageProvider mp = MessageSupportFactory.getInstance().getProvider();
        mr.setMessageProvider(mp);
        mr.render();
    }
}
