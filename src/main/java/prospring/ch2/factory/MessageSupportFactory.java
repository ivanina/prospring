package prospring.ch2.factory;

import prospring.ch2.provider.MessageProvider;
import prospring.ch2.render.MessageRender;

import java.util.Properties;

public class MessageSupportFactory {
    private static MessageSupportFactory instance;

    private MessageRender render;
    private MessageProvider provider;

    private Properties props;

    static {
        instance = new MessageSupportFactory();
    }

    public static MessageSupportFactory getInstance(){
        return instance;
    }

    private MessageSupportFactory(){
        props = new Properties();
        try {
            props.load(
                    this.getClass()
                            .getClassLoader()
                            .getResourceAsStream("ch2.msf.properties")
            );
            render = (MessageRender) Class.forName( props.getProperty("render.class") ).newInstance();
            provider = (MessageProvider) Class.forName( props.getProperty("provider.class") ).newInstance();
        } catch (Exception  e) {
            e.printStackTrace();
        }
    }

    public MessageRender getRender() {
        return render;
    }

    public MessageProvider getProvider() {
        return provider;
    }
}
