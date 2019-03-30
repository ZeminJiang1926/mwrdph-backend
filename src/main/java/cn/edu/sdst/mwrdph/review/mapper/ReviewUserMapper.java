package cn.edu.sdst.mwrdph.review.mapper;

import cn.edu.sdst.mwrdph.review.vo.UserVO;
import org.apache.ibatis.annotations.Mapper;

/**
 * Demo class
 *
 * @author ZhangYu
 * @date 2019/3/30
 */
@Mapper
public interface ReviewUserMapper {
    UserVO getUserInfo(Long userId);
}
