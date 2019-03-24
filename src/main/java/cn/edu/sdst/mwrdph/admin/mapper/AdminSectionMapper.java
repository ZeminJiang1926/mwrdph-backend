package cn.edu.sdst.mwrdph.admin.mapper;

import cn.edu.sdst.mwrdph.entity.SectionPO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface AdminSectionMapper extends tk.mybatis.mapper.common.Mapper<SectionPO> {

    /**
     * 查询前50条数据
     *
     * @return List<SectionPO>
     */
    List<SectionPO> queryTopSections();

    /**
     * 根据路段名称进行模糊查询
     *
     * @param name
     * @return List<SectionPO>
     */
    List<SectionPO> querySectionByItems(@Param("name") String name);

    /**
     * 根据ID删除路段配置信息
     *
     * @param id
     */
    void delSection(@Param("id") Integer id);

    /**
     * 更新路段配置信息
     *
     * @param section
     */
    void updateSection(@Param("section") SectionPO section);

    void addSection(@Param("section") SectionPO section);

}
