package cn.edu.sdst.mwrdph.front.api;

import cn.edu.sdst.mwrdph.front.service.FrontStatisticService;
import cn.edu.sdst.mwrdph.front.vo.RankItemOfVolumeAndSpeedVO;
import cn.edu.sdst.mwrdph.front.vo.VolumeAndSpeedVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

/**
 * 流量速度统计相关接口
 *
 * @author ZhangYu
 * @date 2019/3/6
 */
@RestController
@RequestMapping("/v1/front_api/statistic")
public class FrontStatisticController {

    @Autowired
    private FrontStatisticService statisticService;

    /**
     * 获取指定id 指定时间 前n分钟内的平均车速和累计流量
     */
    @GetMapping("/volume_speed/{detector_id}")
    public ResponseEntity<VolumeAndSpeedVO> getStatisticVolumeAndSpeed(
            @PathVariable("detector_id") Long detectorId,
            @RequestParam("date") @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss") Date date,
            @RequestParam("period") Integer period) {
        VolumeAndSpeedVO statisticVolumeAndSpeed = statisticService.getStatisticVolumeAndSpeed(detectorId, date, period);
        System.out.println("statisticVolumeAndSpeed = " + statisticVolumeAndSpeed);
        return ResponseEntity.ok(statisticVolumeAndSpeed);
    }

    /**
     * 获取指定时间范围内的流量和速度数据，并按period行重采样
     */
    @GetMapping("/volume_speed/range/{detector_id}")
    public ResponseEntity<List<VolumeAndSpeedVO>> getVolumeAndSpeedList(
            @PathVariable("detector_id") Long detectorId,
            @RequestParam("start") @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss") Date start,
            @RequestParam("end") @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss") Date end,
            @RequestParam("period") Integer period) {
        return ResponseEntity.ok(statisticService.getVolumeAndSpeedList(detectorId, start, end, period));
    }

    /**
     * 指定日期范围内 按指定字段排序后的前limit个信息
     */
    @GetMapping("/top")
    public ResponseEntity<List<RankItemOfVolumeAndSpeedVO>> getTopDetectorBy(
            @RequestParam("start") @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss") Date start,
            @RequestParam("end") @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss") Date end,
            @RequestParam("limit") Integer limit,
            @RequestParam("by") String by) {
        return ResponseEntity.ok(statisticService.getTopDetectorBy(start, end, limit, by));
    }

    @GetMapping("/volume/{detector_id}")
    public ResponseEntity<List<VolumeAndSpeedVO>> getRealTimeVolume(
            @PathVariable("detector_id") Long detectorId,
            @RequestParam("start") @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss") Date start,
            @RequestParam("end") @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss") Date end,
            @RequestParam("period") Integer period) {
        return ResponseEntity.ok(statisticService.getRealTimeVolume(detectorId, start, end, period));
    }

    @GetMapping("/speed/{detector_id}")
    public ResponseEntity<List<VolumeAndSpeedVO>> getRealTimeSpeed(
            @PathVariable("detector_id") Long detectorId,
            @RequestParam("start") @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss") Date start,
            @RequestParam("end") @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss") Date end,
            @RequestParam("period") Integer period) {
        return ResponseEntity.ok(statisticService.getRealTimeSpeed(detectorId, start, end, period));
    }

    @GetMapping({"/volume/total", "/volume/total/{detector_id}"})
    public ResponseEntity<Long> getTotalVolume(
            @PathVariable(value = "detector_id", required = false) Long detectorId,
            @RequestParam("start") @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss") Date start,
            @RequestParam("end") @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss") Date end) {
        return ResponseEntity.ok(statisticService.getTotalVolume(detectorId, start, end));
    }
}