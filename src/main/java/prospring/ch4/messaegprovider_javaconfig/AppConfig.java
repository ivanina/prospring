package prospring.ch4.messaegprovider_javaconfig;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.*;
import org.springframework.core.env.Environment;

@Configuration
@PropertySource(value = "classpath:ch4/ch4.app-message.properties")
@ComponentScan(basePackages = {"prospring.ch4.messaegprovider_javaconfig"})
public class AppConfig {
    @Autowired
    Environment env;

    @Bean("render")
    @DependsOn(value = "provider")
    @Scope(value = "prototype")
    public MessageRender messageRender(){
        MessageRender render =  new StandardOutMessageRender();
        render.setMessageProvider(messageProvider());
        return render;
    }

    @Bean("provider")
    @Lazy(value = true)
    public MessageProvider messageProvider(){
        //return new ConfigurableMessageProvider("This is another message which configured in pojo");
        return new ConfigurableMessageProvider(env.getProperty("message"));
    }
}
