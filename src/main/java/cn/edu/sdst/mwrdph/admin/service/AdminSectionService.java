package cn.edu.sdst.mwrdph.admin.service;

import cn.edu.sdst.mwrdph.admin.mapper.AdminSectionMapper;
import cn.edu.sdst.mwrdph.entity.SectionPO;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdminSectionService {
    @Autowired
    private AdminSectionMapper sectionMapper;

    /**
     * @return List<SectionPO>
     */
    public List<SectionPO> queryTopSections(int pageIndex,int pageSize) {
        PageHelper.startPage(pageIndex,pageSize);
        return sectionMapper.queryTopSections();
    }

    public List<SectionPO> querySectionByItems(String name) {
        return sectionMapper.querySectionByItems(name);
    }

    /**
     * 根据ID删除路段配置信息
     *
     * @param id
     */
    public void delSection(Integer id) {
        sectionMapper.delSection(id);
    }

    /**
     * 更新路段配置信息
     *
     * @param section
     */
    public void updateSection(SectionPO section) {
        sectionMapper.updateSection(section);
    }

    public void addSection(SectionPO section) {
        sectionMapper.addSection(section);
    }
}
