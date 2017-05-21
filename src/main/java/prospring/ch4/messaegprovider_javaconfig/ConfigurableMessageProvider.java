package prospring.ch4.messaegprovider_javaconfig;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ConfigurableMessageProvider implements MessageProvider {
    private String message;
}
