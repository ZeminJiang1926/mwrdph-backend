package cn.edu.sdst.mwrdph.typehandler;

import cn.edu.sdst.mwrdph.enums.UserRoleEnum;
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
 * @date 2019/3/30
 */
public class UserRoleEnumTypeHandler extends BaseTypeHandler<UserRoleEnum> {
    @Override
    public void setNonNullParameter(PreparedStatement preparedStatement, int i, UserRoleEnum userRoleEnum, JdbcType jdbcType) throws SQLException {
            preparedStatement.setInt(i, userRoleEnum.getCode());
    }

    @Override
    public UserRoleEnum getNullableResult(ResultSet resultSet, String s) throws SQLException {
        return UserRoleEnum.ofCode(resultSet.getInt(s));
    }

    @Override
    public UserRoleEnum getNullableResult(ResultSet resultSet, int i) throws SQLException {
        return UserRoleEnum.ofCode(resultSet.getInt(i));
    }

    @Override
    public UserRoleEnum getNullableResult(CallableStatement callableStatement, int i) throws SQLException {
        return UserRoleEnum.ofCode(callableStatement.getInt(i));
    }
}
