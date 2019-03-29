package cn.edu.sdst.mwrdph.front.vo;

import cn.edu.sdst.mwrdph.entity.IncidentPO;
import cn.edu.sdst.mwrdph.enums.TrafficIncidentEnum;
import lombok.Data;
import org.springframework.beans.BeanUtils;

import java.util.Date;

/**
 * 交通事件
 *
 * @author ZhangYu
 * @date 2019/2/26
 */
@Data
public class TrafficIncidentVO {
    private Long id;
    private Long sectionId;
    private Long detectorId;
    private Integer type;
    private String typeName;
    private Double distance;
    private Double speed;
    private String info;
    private Boolean checked;
    private Date createTime;
    private Date updateTime;
    private Date timestamp;

    public TrafficIncidentVO(IncidentPO incidentPO) {
        BeanUtils.copyProperties(incidentPO, this);
        this.typeName =  incidentPO.getType().getAlias();
    }

}
