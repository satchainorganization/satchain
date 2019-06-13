package com.satchain.dao;

import org.apache.ibatis.annotations.Param;

public interface TeleDataMapper {
    void dropTable(@Param("tableName") String tableName);
}
