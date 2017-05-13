package prospring.ch2.render;

import prospring.ch2.provider.MessageProvider;

public interface MessageRender {
    void render();
    void setMessageProvider(MessageProvider provider);
    MessageProvider getMessageProvider();
}
