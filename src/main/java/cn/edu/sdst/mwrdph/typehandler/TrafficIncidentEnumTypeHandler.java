package cn.edu.sdst.mwrdph.typehandler;

import cn.edu.sdst.mwrdph.enums.TrafficIncidentEnum;
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
public class TrafficIncidentEnumTypeHandler extends BaseTypeHandler<TrafficIncidentEnum> {
    @Override
    public void setNonNullParameter(PreparedStatement preparedStatement, int i, TrafficIncidentEnum trafficIncidentEnum, JdbcType jdbcType) throws SQLException {
        preparedStatement.setInt(i, trafficIncidentEnum.getCode());
    }

    @Override
    public TrafficIncidentEnum getNullableResult(ResultSet resultSet, String s) throws SQLException {
        return TrafficIncidentEnum.ofCode(resultSet.getShort(s));
    }

    @Override
    public TrafficIncidentEnum getNullableResult(ResultSet resultSet, int i) throws SQLException {
        return TrafficIncidentEnum.ofCode(resultSet.getShort(i));
    }

    @Override
    public TrafficIncidentEnum getNullableResult(CallableStatement callableStatement, int i) throws SQLException {
        return TrafficIncidentEnum.ofCode(callableStatement.getShort(i));
    }
}
