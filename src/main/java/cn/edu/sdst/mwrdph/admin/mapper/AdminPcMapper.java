package cn.edu.sdst.mwrdph.admin.mapper;

import cn.edu.sdst.mwrdph.entity.PcPO;
import org.apache.ibatis.annotations.Param;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

@org.apache.ibatis.annotations.Mapper
public interface AdminPcMapper extends Mapper<PcPO> {
    /**
     * 查询前50条数据
     *
     * @return List<PcPO>
     */
    List<PcPO> queryTopPc();

    /**
     * 根据关键词模糊查询工控机
     *
     * @return List<PcPO>
     */
    List<PcPO> getPcsByItems(@Param("userName") String userName);

    /**
     * 根据ID删除工控机
     *
     * @param id
     */
    void delPc(@Param("id") Integer id);

    /**
     * 更新工控机配置信息
     *
     * @param pc
     */
    int updatePc(@Param("pc") PcPO pc);

    /**
     * 增加工控机
     *
     * @param pc
     * @return
     */
    int addPc(@Param("pc") PcPO pc);

}
