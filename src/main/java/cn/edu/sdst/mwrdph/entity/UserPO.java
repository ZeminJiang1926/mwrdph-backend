package cn.edu.sdst.mwrdph.entity;

import lombok.Data;
import tk.mybatis.mapper.annotation.KeySql;

import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Data
@Table(name = "mwr_user")
public class UserPO {
    @Id
    @KeySql(useGeneratedKeys = true)
    private Long id;
    private String name;
    private String password;
    private Integer role;
    private Double tel;
    private Integer age;
    private String photoUrl;
    private Date lastLoginTime;
}
