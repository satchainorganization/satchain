package com.satchain.commons.constants;

/**
 * @author
 * // TODO: 2019/5/19 dsf
 * @date 2019/5/19
 */
public interface Constants {

    String SESSION_TOKEN_KEY = "SESSION_TOKEN";
    String SESSION_USERNAME_KEY = "SESSION_USERNAME";
    String ADD_USER_URL = "/addUsers";

    // TODO: 2019/5/19 数据存储根目录
    String DATA_BASE_PATH = "/data/";
    String TELE_DATA_BASE_PATH = "/teledata/";

    String JDBC_HOST = "127.0.0.1";
    String JDBC_USER ="root";
    String JDBC_PASSWORD = "";
    String JDBC_EXPORTDATABASENAME = "satchain";
    Integer JDBC_PORT = 3306;
    String JDBC_EXPORTPATH = "e\\:\\mysql\\edu.sql";
}
