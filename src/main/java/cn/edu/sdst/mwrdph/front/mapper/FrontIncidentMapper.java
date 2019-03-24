package cn.edu.sdst.mwrdph.front.mapper;

import cn.edu.sdst.mwrdph.entity.IncidentPO;
import cn.edu.sdst.mwrdph.front.vo.RankItemOfIncidentsVO;
import org.apache.ibatis.annotations.Param;
import tk.mybatis.mapper.common.Mapper;

import java.util.Date;
import java.util.List;

/**
 * FrontIncidentMapper
 *
 * @author ZhangYu
 * @date 2019/2/24
 */
@org.apache.ibatis.annotations.Mapper
public interface FrontIncidentMapper extends Mapper<IncidentPO> {
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
     * @param detectorId 监测器id(optional)
     * @param start      开始时间
     * @param end        结束时间
     * @return List<IncidentPO>
     */
    List<IncidentPO> getIncidents(@Param("detectorId") Long detectorId, @Param("start") Date start, @Param("end") Date end);

    /**
     * 获取时间数量最多的前limit条监测器信息
     *
     * @param start 开始时间
     * @param end   结束时间
     * @param limit 条数
     * @return List<RankItemOfIncidentsVO>
     */
    List<RankItemOfIncidentsVO> getTopNDetectorByIncidents(@Param("start") Date start, @Param("end") Date end, @Param("limit") Integer limit);

    /**
     * 获得指定时间范围内的事件总数
     *
     * @param detectorId 检测器Id (optional)
     * @param start      开始时间
     * @param end        结束时间
     * @return 事件总数
     */
    Long getTotalIncident(Long detectorId, Date start, Date end);

}
