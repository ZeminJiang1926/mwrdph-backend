package cn.edu.sdst.mwrdph.entity;

import lombok.Data;

import javax.persistence.Table;

@Data
@Table(name = "mwr_pc")
public class PcPO {
    private Long id;
    private Double lng;
    private Double lat;
    private String userName;
    private String userPassword;
}
