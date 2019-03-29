package cn.edu.sdst.mwrdph.typehandler;

import cn.edu.sdst.mwrdph.enums.LaneEnum;
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
 * @date 2019/3/29
 */
public class LaneEnumTypeHandler extends BaseTypeHandler<LaneEnum> {
    @Override
    public void setNonNullParameter(PreparedStatement preparedStatement, int i, LaneEnum laneEnum, JdbcType jdbcType) throws SQLException {
        preparedStatement.setInt(i, laneEnum.getCode());
    }

    @Override
    public LaneEnum getNullableResult(ResultSet resultSet, String s) throws SQLException {
        return LaneEnum.ofCode(resultSet.getShort(s));
    }

    @Override
    public LaneEnum getNullableResult(ResultSet resultSet, int i) throws SQLException {
        return LaneEnum.ofCode(resultSet.getShort(i));
    }

    @Override
    public LaneEnum getNullableResult(CallableStatement callableStatement, int i) throws SQLException {
        return LaneEnum.ofCode(callableStatement.getShort(i));
    }
}
