package cn.edu.sdst.mwrdph.ipc.mapper;

import cn.edu.sdst.mwrdph.entity.IncidentPO;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

/**
 * Demo class
 *
 * @author ZhangYu
 * @date 2019/2/12
 */
@org.apache.ibatis.annotations.Mapper
public interface IpcIncidentMapper extends Mapper<IncidentPO> {
    /**
     * 插入多个对象
     *
     * @param list IncidentPO items
     * @return 插入条数
     */
    int insertByList(List<IncidentPO> list);
}
