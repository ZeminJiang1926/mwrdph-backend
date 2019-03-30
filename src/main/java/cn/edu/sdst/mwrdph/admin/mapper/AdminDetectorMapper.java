package cn.edu.sdst.mwrdph.admin.mapper;

import cn.edu.sdst.mwrdph.admin.vo.AdminDetectorVo;
import cn.edu.sdst.mwrdph.entity.DetectorPO;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;


@Mapper
public interface AdminDetectorMapper extends tk.mybatis.mapper.common.Mapper<AdminDetectorVo> {

    /**
     * 查询前50条传感器数据
     *
     * @return List<DetectorPO>
     */
    List<AdminDetectorVo> queryTopDetector();

    /**
     * 根据监测点名称和路段ID查询传感器
     *
     * @param name
     * @return List<DetectorPO>
     */
    List<AdminDetectorVo> queryDetectorByItems(@Param("name") String name);

    /**
     * 根据ID 删除传感器配置
     *
     * @param id
     */
    void delDector(@Param("id") Long id);

    /**
     * 更新传感器配置
     *
     * @param detector
     * @return
     */
    int updateDetector(@Param("detector") AdminDetectorVo detector);

    /***
     * 增加传感器
     * @param detector
     * @return
     */
    int addDetector(@Param("item") AdminDetectorVo detector);
}
