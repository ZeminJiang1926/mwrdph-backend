package cn.edu.sdst.mwrdph.typehandler;

import cn.edu.sdst.mwrdph.enums.CarTypeEnum;
import org.apache.ibatis.type.BaseTypeHandler;
import org.apache.ibatis.type.JdbcType;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Demo class
 *
 * @author ZhangYu
 * @date 2019/3/28
 */
public class CarTypeEnumTypeHandler extends BaseTypeHandler<CarTypeEnum> {
    @Override
    public void setNonNullParameter(PreparedStatement preparedStatement, int i, CarTypeEnum carTypeEnum, JdbcType jdbcType) throws SQLException {
        preparedStatement.setInt(i, carTypeEnum.getCode());
    }

    @Override
    public CarTypeEnum getNullableResult(ResultSet resultSet, String s) throws SQLException {
        return CarTypeEnum.ofCode(resultSet.getShort(s));
    }

    @Override
    public CarTypeEnum getNullableResult(ResultSet resultSet, int i) throws SQLException {
        return CarTypeEnum.ofCode(resultSet.getShort(i));
    }

    @Override
    public CarTypeEnum getNullableResult(CallableStatement callableStatement, int i) throws SQLException {
        return CarTypeEnum.ofCode(callableStatement.getShort(i));
    }
}
