package cn.edu.sdst.mwrdph.ipc.mapper;


import cn.edu.sdst.mwrdph.entity.DetectorPO;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

/**
 * Demo class
 *
 * @author ZhangYu
 * @date 2019/2/13
 */
@org.apache.ibatis.annotations.Mapper
public interface IpcDetectorMapper extends Mapper<DetectorPO> {
    /**
     * 批量更新检测器状态
     *
     * @param list DetectorDO items
     * @return 更新行数
     */
    int updateStatusByList(List<DetectorPO> list);
}
