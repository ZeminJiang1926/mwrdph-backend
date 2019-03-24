package cn.edu.sdst.mwrdph.ipc.web;

import cn.edu.sdst.mwrdph.common.CrudSuccessResultVO;
import cn.edu.sdst.mwrdph.common.ResponseCreater;
import cn.edu.sdst.mwrdph.common.SuccessResultVO;
import cn.edu.sdst.mwrdph.enums.SuccessEnum;
import cn.edu.sdst.mwrdph.ipc.service.IpcDetectorService;
import cn.edu.sdst.mwrdph.ipc.vo.DetectorStatusVO;
import cn.edu.sdst.mwrdph.ipc.vo.ReportVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 雷达状态相关接口
 *
 * @author ZhangYu
 * @date 2019/2/13
 */
@RestController
@RequestMapping("/v1/ipc_api/detectors")
public class IpcDetectorController {
    @Autowired
    IpcDetectorService ipcDetectorService;

    /**
     * 批量更新检测器状态
     *
     * @return CrudSuccessResultVO json string
     */
    @PostMapping("/status")
    public ResponseEntity<SuccessResultVO> updateStatusByList(@RequestBody ReportVO<DetectorStatusVO> reportVO) {
        int count = 0;
        if (!ObjectUtils.isEmpty(reportVO.getItems())) {
            count = ipcDetectorService.updateStatusByList(reportVO);
        }
        return ResponseCreater.create(new CrudSuccessResultVO(SuccessEnum.UPDATE_SUCCESS, count));
    }

}
