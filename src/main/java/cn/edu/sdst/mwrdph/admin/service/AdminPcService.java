package cn.edu.sdst.mwrdph.admin.service;

import cn.edu.sdst.mwrdph.admin.mapper.AdminPcMapper;
import cn.edu.sdst.mwrdph.entity.PcPO;
import com.github.pagehelper.PageHelper;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class AdminPcService {
    @Autowired
    private AdminPcMapper pcMapper;

    /**
     * @return
     */
    public List<PcPO> queryTopPc(int pageIndex,int pageSize) {
        PageHelper.startPage(pageIndex,pageSize);
        return pcMapper.queryTopPc();

    }

    /**
     * @param
     * @param userName
     * @return
     */
    public List<PcPO> getPcsByItems(String userName) {
        return pcMapper.getPcsByItems(userName);
    }

    /**
     * @param id
     */
    public void delPc(Integer id) {
        pcMapper.delPc(id);
    }

    /**
     * @param pc
     */
    public int updatePc(PcPO pc) {

        return pcMapper.updatePc(pc);
    }

    public int addPc(PcPO pc) {
        return pcMapper.addPc(pc);
    }
}
