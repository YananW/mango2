package com.mly.mango.backup.properties;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @author wyn
 * @Description 数据源属性配置类
 * @date 2020-04-06 18:22
 */
@Component
@ConfigurationProperties(prefix = "mango.backup.datasource")
@Data
public class BackupDataSourceProperties {

    private String host;
    private String userName;
    private String password;
    private String database;
}
