package cn.edu.sdst.mwrdph;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * 毫米波雷达高速公路监测平台
 *
 * @author Zhang Yu
 * @date 2018/02/12
 */
@SpringBootApplication
public class MwrdphApplication {

    public static void main(String[] args) {
        SpringApplication.run(MwrdphApplication.class, args);
    }

}

