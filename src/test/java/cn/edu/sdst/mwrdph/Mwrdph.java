package cn.edu.sdst.mwrdph;

import cn.edu.sdst.mwrdph.entity.IncidentPO;
import cn.edu.sdst.mwrdph.enums.TrafficIncidentEnum;
import cn.edu.sdst.mwrdph.ipc.mapper.IpcIncidentMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Demo class
 *
 * @author ZhangYu
 * @date 2019/3/29
 */
@SpringBootTest
@RunWith(SpringRunner.class)
public class Mwrdph {

    @Autowired
    IpcIncidentMapper incidentMapper;

    @Test
    public void test() {
        IncidentPO build = IncidentPO.builder().sectionId(1L).detectorId(1L).type(TrafficIncidentEnum.LANE_CHANGE).speed(1.1).distance(1.1)
                .timestamp(new Date()).build();
        System.out.println(incidentMapper.insertByList(new ArrayList<IncidentPO>() {{
            add(build);
        }}));
    }
}
