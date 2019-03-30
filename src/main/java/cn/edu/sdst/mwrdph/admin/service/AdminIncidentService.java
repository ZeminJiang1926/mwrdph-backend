package cn.edu.sdst.mwrdph.admin.service;

import cn.edu.sdst.mwrdph.admin.mapper.AdminIncidentMapper;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import cn.edu.sdst.mwrdph.admin.vo.AdminIncidentVo;

import java.util.Date;
import java.util.List;

/**
 * 管理界面前端交通事件展示服务
 *
 * @author wzh
 * @date 2019/3/30
 */
@Service
public class AdminIncidentService {
    @Autowired
    private AdminIncidentMapper incidentMapper;

    /**
     * 获得最新事件
     *
     * @return List<TrafficIncidentVO>
     */
    public List<AdminIncidentVo> getLatestIncidents(int current, int size) {

        PageHelper.startPage(current, size);
        List<AdminIncidentVo> latest = incidentMapper.getLatest();
        return latest;
    }

    /**
     * 获取指定时间范围、指定路段的事件
     *
     * @param sectionId 路段id
     * @param start     开始时间
     * @param end       结束时间
     * @return List<IncidentPO>
     */
    public List<AdminIncidentVo> getIncidents(Long sectionId, Date start, Date end, List<Integer> checkList, int pageIndex, int pageSize) {
        PageHelper.startPage(pageIndex, pageSize);
        List<AdminIncidentVo> incidents = incidentMapper.getIncidents(sectionId, start, end, checkList);
        return incidents;
    }

    /***
     *
     * @param reviewItem
     * @return
     */
    public int updateReview(AdminIncidentVo reviewItem) {
        return incidentMapper.updateReview(reviewItem);

    }

}
