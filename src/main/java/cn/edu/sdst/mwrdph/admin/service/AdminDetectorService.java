package cn.edu.sdst.mwrdph.admin.service;

import cn.edu.sdst.mwrdph.admin.mapper.AdminDetectorMapper;
import cn.edu.sdst.mwrdph.admin.vo.AdminDetectorVo;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdminDetectorService {
    @Autowired
    private AdminDetectorMapper adminDetectorMapper;

    public List<AdminDetectorVo> queryTopDetector(int pageIndex, int pageSize) {
        PageHelper.startPage(pageIndex, pageSize);
        return adminDetectorMapper.queryTopDetector();
    }

    public List<AdminDetectorVo> queryDetectorByItems(String name) {
        return adminDetectorMapper.queryDetectorByItems(name);
    }

    public void delDetector(Long id) {
        adminDetectorMapper.delDector(id);
    }

    public int updateDetector(AdminDetectorVo detector) {

        return adminDetectorMapper.updateDetector(detector);
    }

    public int addDetector(AdminDetectorVo detector) {
        return adminDetectorMapper.addDetector(detector);
    }

}
