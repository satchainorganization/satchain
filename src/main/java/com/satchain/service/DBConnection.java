package com.satchain.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

//import org.apache.commons.dbcp.BasicDataSource;
import org.springframework.web.context.ContextLoader;
import org.springframework.web.context.WebApplicationContext;

public class DBConnection {
    private Connection connection = null;
    private static DBConnection instance = new DBConnection();

    private DBConnection() {
    }

    /**
     * 单实例
     */
    public static DBConnection getInstance() {
        return instance;
    }

    /**
     * 获得数据库链接
     */
    public Connection getConnection(String dataSource) throws Exception {
        if (this.connection == null || this.connection.isClosed()) {

            /*WebApplicationContext ct = ContextLoader.getCurrentWebApplicationContext();
            BasicDataSource datasource = (BasicDataSource) ct.getBean(dataSource);
            this.connection = datasource.getConnection();*/
        }
        return this.connection;
    }


    /**
     * 关闭数据库连接
     */
    public static void closeConnection(Connection conn) {
        try {
            if (conn != null && !conn.isClosed()) {
                conn.close();
                conn = null;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 释放资源
     **/
    private void closeAll(ResultSet rs, PreparedStatement st) {
        try {
            if (rs != null) {
                rs.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            if (st != null) {
                st.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
