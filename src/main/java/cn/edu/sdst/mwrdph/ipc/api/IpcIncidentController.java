package cn.edu.sdst.mwrdph.ipc.api;

import cn.edu.sdst.mwrdph.common.CrudSuccessResultVO;
import cn.edu.sdst.mwrdph.common.ResponseCreater;
import cn.edu.sdst.mwrdph.common.SuccessResultVO;
import cn.edu.sdst.mwrdph.enums.SuccessEnum;
import cn.edu.sdst.mwrdph.ipc.service.IpcIncidentService;
import cn.edu.sdst.mwrdph.ipc.vo.ReportVO;
import cn.edu.sdst.mwrdph.ipc.vo.TrafficIncidentVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 交通事件相关接口
 *
 * @author ZhangYu
 * @date 2019/2/12
 */
@RestController
@RequestMapping("/v1/ipc_api/traffic_incidents")
public class IpcIncidentController {
    @Autowired
    IpcIncidentService ipcIncidentService;

    /**
     * 保存交通事件
     *
     * @return CrudSuccessResultVO json string
     */
    @PostMapping
    public ResponseEntity<SuccessResultVO> insertByList(@RequestBody ReportVO<TrafficIncidentVO> reportVO) {
        int count = 0;
        if (!ObjectUtils.isEmpty(reportVO.getItems())) {
            count = ipcIncidentService.insertByList(reportVO);
        }
        return ResponseCreater.create(new CrudSuccessResultVO(SuccessEnum.INSERT_SUCCESS, count));
    }


}
