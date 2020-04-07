package com.mly.mango.backup.service;

/**
 * @author wyn
 * @Description Mysql 命令备份恢复服务接口
 * @date 2020-04-06 18:24
 */

public interface MySqlBackupService {

    /**
     * 备份数据库
     * @param host 地址，可以是本机也可以是远程
     * @param userName 数据库的用户名
     * @param password 数据库的密码
     * @param backupFolderPath 备份的路径
     * @param fileName 备份的文件名
     * @param database 需要备份的数据库的名称
     * @return
     * @throws Exception
     */
    boolean backup(String host,String userName,String password,
                   String backupFolderPath,String fileName,String database) throws Exception;


    /**
     * 恢复数据库
     * @param restoreFilePath 数据库备份的脚本路径
     * @param host IP地址
     * @param userName 数据库名称
     * @param password 数据库密码
     * @param database
     * @return
     * @throws Exception
     */
    boolean restore(String restoreFilePath,String host,String userName,String password
    ,String database) throws Exception;
}
