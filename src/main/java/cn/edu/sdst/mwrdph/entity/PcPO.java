package cn.edu.sdst.mwrdph.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import tk.mybatis.mapper.annotation.KeySql;

import javax.persistence.Id;
import javax.persistence.Table;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "mwr_pc")
public class PcPO {
    @Id
    @KeySql(useGeneratedKeys = true)
    private Long id;
    private Double lng;
    private Double lat;
    private String userName;
    private String userPassword;
}
