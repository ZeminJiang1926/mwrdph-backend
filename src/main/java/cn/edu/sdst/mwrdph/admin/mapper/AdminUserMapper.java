package cn.edu.sdst.mwrdph.admin.mapper;

import cn.edu.sdst.mwrdph.entity.UserPO;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@org.apache.ibatis.annotations.Mapper
public interface AdminUserMapper extends tk.mybatis.mapper.common.Mapper<UserPO> {

    /**
     * 查询前50条用户信息
     *
     * @return
     */
    List<UserPO> queryTopUser();

    /**
     * 根据工号和姓名模糊查询用户信息
     *
     * @param name
     * @param id
     * @return
     */
    List<UserPO> queryUserByItems(@Param("name") String name, @Param("id") Integer id);

    /**
     * 根据工号删除用户信息
     *
     * @param id
     */
    void delUser(@Param("id") Integer id);

    /**
     * 根据工号更新用户信息
     *
     * @param user
     */
    void updateUser(@Param("user") UserPO user);

    /**
     * 添加用户
     *
     * @param user
     */
    void addUser(@Param("user") UserPO user);

}
