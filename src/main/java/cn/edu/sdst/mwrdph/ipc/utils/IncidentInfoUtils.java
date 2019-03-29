package cn.edu.sdst.mwrdph.ipc.utils;

import cn.edu.sdst.mwrdph.enums.TrafficIncidentEnum;

/**
 * 时间描述信息工具类
 *
 * @author ZhangYu
 * @date 2019/2/26
 */
public class IncidentInfoUtils {

    public static String generateInfo(String pointName, double distance, TrafficIncidentEnum type) {
        System.out.println(distance);
        return String.format("%s %.0fm处发现%s", pointName, distance, type.getAlias());
    }
}
