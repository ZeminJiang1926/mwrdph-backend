package cn.edu.sdst.mwrdph.entity;

import lombok.Data;
import tk.mybatis.mapper.annotation.KeySql;

import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Data
@Table(name = "mwr_act")
public class ActPO {
    @Id
    @KeySql(useGeneratedKeys = true)
    private Long id;
    private Long userCheckId;
    private Long userCheckType;
    private Long eventId;
    private Date actTime;
}
