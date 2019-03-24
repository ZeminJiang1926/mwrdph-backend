package cn.edu.sdst.mwrdph.entity;

import lombok.Data;
import tk.mybatis.mapper.annotation.KeySql;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

/**
 * 路段表
 *
 * @author ZhangYu
 * @date 2019/2/16
 */
@Data
@Table(name = "mwr_section")
public class SectionPO {
    @Id
    @KeySql(useGeneratedKeys = true)
    private Long id;
    private String name;
    private Double lng;
    private Double lat;
    private Integer radarCount;
    private Integer cameraCount;
    @Column(name = "is_deleted")
    private Boolean deleted;
    private Date createdTime;
    private Date updateTime;
}
