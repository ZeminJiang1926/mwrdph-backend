package cn.edu.sdst.mwrdph.front.utils;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * Demo class
 *
 * @author ZhangYu
 * @date 2019/3/13
 */
public class TimeUtils {

    public static Date toNextPoint(Date time) {
        return new Date(time.getTime() + 1);
    }

    /**
     * 该日期所出时间段内的最小值
     */
    public static Date toPeriodMin(Date time, int period) {
        return new Date(time.getTime() - time.getTime() % (period * 1000));
    }

    /**
     * 该日期所出时间段内的最大值
     */
    public static Date toPeriodMax(Date time, int period) {
        return new Date(time.getTime() - time.getTime() % (period * 1000) + period * 1000 - 1);
    }

    /**
     * 前一周期的最大值
     */
    public static Date floorToMax(Date time, int period) {
        return new Date(time.getTime() - time.getTime() % (period * 1000) - 1);
    }

    /**
     * 取下一周期的最小值
     */
    public static Date ceilToMin(Date time, int period) {
        return new Date(time.getTime() - time.getTime() % (period * 1000) + period * 1000);
    }

    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    public static class TimeRange {
        private Date start;
        private Date end;
    }

}