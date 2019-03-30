package cn.edu.sdst.mwrdph.review.vo;

import cn.edu.sdst.mwrdph.enums.UserRoleEnum;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Demo class
 *
 * @author ZhangYu
 * @date 2019/3/30
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserVO {
    private Long id;
    private String name;
    private UserRoleEnum role;
    private String tel;
    private Integer age;
    private String photoUrl;
}
