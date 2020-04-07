package com.mly.mango.admin.properties;

import lombok.Data;
import lombok.ToString;
import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * @author wyn
 * @Description
 * @date 2020-04-04 16:42
 */
@Data
@ToString
@ConfigurationProperties(prefix = "person")
public class TestProperties {
    private String username;
    private String age;
}
