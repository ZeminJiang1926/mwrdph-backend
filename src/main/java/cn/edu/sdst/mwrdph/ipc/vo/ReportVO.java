package cn.edu.sdst.mwrdph.ipc.vo;

import lombok.Data;
import org.springframework.beans.BeanUtils;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Demo class
 *
 * @author ZhangYu
 * @date 2019/2/17
 */
@Data
public class ReportVO<T> {
    private Long pcId;
    private Date timestamp;
    private List<T> items;

    public <T2> List<T2> toDOList(Class<T2> t) {
        List<T2> list = new ArrayList<>(this.items.size());
        items.forEach(item -> {
            try {
                T2 instance = t.newInstance();
                BeanUtils.copyProperties(item, instance);
                list.add(instance);
            } catch (Exception e) {
                throw new RuntimeException("无法创建示例对象 name:" + t.getName());
            }
        });
        return list;
    }
}