package cn.edu.sdst.mwrdph.ipc.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.text.SimpleDateFormat;
import java.util.Date;


/**
 * 远程调用视频服务器进行取证视频的截取
 *
 * @author ZhangYu
 * @date 2019/3/26
 */
@Service
@Slf4j
public class RemoteIncidentVideoService {

    @Value("${video.server.path}")
    private String BASE_URL;

    public void record(Long detectorId, Long incidentId, Date start) {
        RestTemplate restTemplate = new RestTemplate();
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        try {
            restTemplate.put(BASE_URL + "/video/evidence/{detector_id}/{incident_id}?occur_time={occur_time}",
                    null, detectorId, incidentId, format.format(start));
        } catch (Exception e) {
            log.error("PUT "+BASE_URL+"/video/evidence/"+detectorId+"/"+incidentId+"?occur_time="+format.format(start), e);
        }
    }
}
