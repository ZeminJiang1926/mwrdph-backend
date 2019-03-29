package cn.edu.sdst.mwrdph.ipc.api;

import cn.edu.sdst.mwrdph.common.CrudSuccessResultVO;
import cn.edu.sdst.mwrdph.common.ResponseCreater;
import cn.edu.sdst.mwrdph.common.SuccessResultVO;
import cn.edu.sdst.mwrdph.enums.SuccessEnum;
import cn.edu.sdst.mwrdph.ipc.service.IpcStatisticsService;
import cn.edu.sdst.mwrdph.ipc.vo.ReportVO;
import cn.edu.sdst.mwrdph.ipc.vo.TrafficStatisticVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 统计数据上传接口
 *
 * @author ZhangYu
 * @date 2019/2/13
 */
@RestController
@RequestMapping("/v1/ipc_api/statistics")
public class IpcStatisticsController {
    @Autowired
    IpcStatisticsService ipcStatisticsService;

    /**
     * 保存统计数据
     *
     * @return CrudSuccessResultVO json string
     */
    @PostMapping
    public ResponseEntity<SuccessResultVO> insertByList(@RequestBody ReportVO<TrafficStatisticVO> reportVO) {
        int count = 0;
        if (!ObjectUtils.isEmpty(reportVO.getItems())) {
            count = ipcStatisticsService.insertByList(reportVO);
        }
        return ResponseCreater.create(new CrudSuccessResultVO(SuccessEnum.INSERT_SUCCESS, count));
    }
}