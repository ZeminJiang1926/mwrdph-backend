package cn.edu.sdst.mwrdph.ipc.mapper;

import cn.edu.sdst.mwrdph.entity.StatisticsPO;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

/**
 * Demo class
 *
 * @author ZhangYu
 * @date 2019/2/17
 */
@org.apache.ibatis.annotations.Mapper
public interface IpcStatisticsMapper extends Mapper<StatisticsPO> {
    int insertByList(List<StatisticsPO> list);
}
