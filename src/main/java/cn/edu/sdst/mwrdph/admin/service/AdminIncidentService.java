package cn.edu.sdst.mwrdph.admin.service;

import cn.edu.sdst.mwrdph.admin.mapper.AdminIncidentMapper;
import cn.edu.sdst.mwrdph.entity.IncidentPO;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * 交通事件服务
 *
 * @author ZhangYu
 * @date 2019/2/27
 */
@Service
public class AdminIncidentService {
    @Autowired
    private AdminIncidentMapper incidentMapper;

    /**
     * 获得最新事件
     *
     *
     * @return List<TrafficIncidentVO>
     */
    public List<IncidentPO> getLatestIncidents(int current,int size) {

        PageHelper.startPage(current,size);
        List<IncidentPO> latest = incidentMapper.getLatest();
        return latest;
    }

    /**
     * 获得指定监测器的最新事件
     *
     * @param detectorId 监测器id
     * @param limit      个数
     * @return List<TrafficIncidentVO>
     */
    public List<IncidentPO> getLatestIncidents(Long detectorId, Integer limit) {
        List<IncidentPO> latest = incidentMapper.getLatest();
        return latest;
    }

    /**
     * 获取指定时间范围内的事件
     *
     * @param sectionId 路段id
     * @param start     开始时间
     * @param end       结束时间
     * @return List<IncidentPO>
     */
    public List<IncidentPO> getIncidents(Long sectionId, Date start, Date end, List<Integer> checkList,int pageIndex,int pageSize) {
        PageHelper.startPage(pageIndex,pageSize);
        List<IncidentPO> incidents = incidentMapper.getIncidents(sectionId, start, end, checkList);
        return incidents;
    }

    /**
     * @param
     * @return
     */
    public List<IncidentPO> getIncidentsUnChecked(int current,int size) {
        PageHelper.startPage(current,size);
        List<IncidentPO> incidents = incidentMapper.getIncidentsUnChecked();
        return incidents;
    }

}
