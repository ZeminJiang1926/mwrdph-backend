package cn.edu.sdst.mwrdph.admin.mapper;

import cn.edu.sdst.mwrdph.entity.IncidentPO;
import org.apache.ibatis.annotations.Param;
import tk.mybatis.mapper.common.Mapper;

import java.util.Date;
import java.util.List;

@org.apache.ibatis.annotations.Mapper
public interface AdminIncidentMapper extends Mapper<IncidentPO> {
    /**
     * 查询n条数据
     *
     * @param detectorId detectorId(optional)
     * @param limit      最近n条数据
     * @return List<IncidentPO>
     */
    List<IncidentPO> getLatest(@Param("detectorId") Long detectorId, @Param("limit") Integer limit);


    /**
     * 获取指定时间范围内的事件
     *
     * @param \sectionId 路段id(optional)
     * @param start      开始时间
     * @param end        结束时间
     * @return List<IncidentPO>
     */
    List<IncidentPO> getIncidents(@Param("sectionId") Long sectionId, @Param("start") Date start, @Param("end") Date end, @Param("checkList") List<Integer> checkList);

    /**
     * 获取最新尚未检查的事件
     *
     * @param
     * @return List<IncidentPO>
     */
    List<IncidentPO> getIncidentsUnChecked();

    /**
     筛选指定类型的事件
     */
    /**
     * 筛选指定路段的
     */

}
