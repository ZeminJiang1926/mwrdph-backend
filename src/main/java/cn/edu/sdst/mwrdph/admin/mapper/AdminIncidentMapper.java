package cn.edu.sdst.mwrdph.admin.mapper;

import org.apache.ibatis.annotations.Param;
import tk.mybatis.mapper.common.Mapper;
import cn.edu.sdst.mwrdph.admin.vo.AdminIncidentVo;

import java.util.Date;
import java.util.List;

@org.apache.ibatis.annotations.Mapper
public interface AdminIncidentMapper extends Mapper<AdminIncidentVo> {
    /**
     * 查询n条数据
     *
     * @return List<IncidentPO>
     */
    List<AdminIncidentVo> getLatest();


    /**
     * 获取指定时间范围、指定路段内的事件
     *
     * @param \sectionId 路段id(optional)
     * @param start      开始时间
     * @param end        结束时间
     * @return List<IncidentPO>
     */
    List<AdminIncidentVo> getIncidents(@Param("sectionId") Long sectionId, @Param("start") Date start, @Param("end") Date end, @Param("checkList") List<Integer> checkList);

    /**
     * @param item
     * @return
     */
    int updateReview(@Param("item") AdminIncidentVo item);


}
