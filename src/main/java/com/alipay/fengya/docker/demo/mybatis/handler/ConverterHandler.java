package com.alipay.fengya.docker.demo.mybatis.handler;

import org.apache.ibatis.type.BaseTypeHandler;
import org.apache.ibatis.type.JdbcType;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
//convert boolean->0,1
public class ConverterHandler extends BaseTypeHandler<Boolean> {

    @Override
    public void setNonNullParameter(PreparedStatement ps, int i, Boolean aBoolean, JdbcType jdbcType) throws
            SQLException {
        if (aBoolean){
            ps.setInt(i,1);
        }else {
            ps.setInt(i,0);
        }
    }

    @Override
    public Boolean getNullableResult(ResultSet resultSet, String s) throws SQLException {
        return resultSet.getInt(s)==0?false:true;
    }

    @Override
    public Boolean getNullableResult(ResultSet resultSet, int i) throws SQLException {
        return resultSet.getInt(i)==0?false:true;
    }

    @Override
    public Boolean getNullableResult(CallableStatement callableStatement, int i) throws SQLException {
        return callableStatement.getInt(i)==0?false:true;
    }
}
