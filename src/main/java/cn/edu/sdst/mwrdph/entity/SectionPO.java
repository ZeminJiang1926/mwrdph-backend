package cn.edu.sdst.mwrdph.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
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
@Builder
@NoArgsConstructor
@AllArgsConstructor
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
    private Boolean deleted;
    private Date createTime;
    private Date updateTime;
}
