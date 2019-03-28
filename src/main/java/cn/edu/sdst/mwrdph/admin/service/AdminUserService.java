package cn.edu.sdst.mwrdph.admin.service;

import cn.edu.sdst.mwrdph.admin.mapper.AdminUserMapper;
import cn.edu.sdst.mwrdph.entity.UserPO;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdminUserService {
    @Autowired
    private AdminUserMapper adminUserMapper;

    /**
     * @return
     */
    public List<UserPO> queryTopUser(int pageIndex,int pageSize) {
        PageHelper.startPage(pageIndex,pageSize);
        return adminUserMapper.queryTopUser();
    }

    /**
     * @param name
     * @param id
     * @return
     */
    public List<UserPO> queryUserByItems(String name, Integer id) {
        return adminUserMapper.queryUserByItems(name, id);
    }

    /**
     * @param id
     */
    public void delUser(Integer id) {
        adminUserMapper.delUser(id);
    }

    public void updateUser(UserPO user) {
        adminUserMapper.updateUser(user);
    }

    public void addUser(UserPO user) {
        adminUserMapper.addUser(user);
    }

}
