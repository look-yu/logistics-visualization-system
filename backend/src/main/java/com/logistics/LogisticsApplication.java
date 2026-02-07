package com.logistics;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.CrossOrigin;

/**
 * 后端启动类
 */
@SpringBootApplication
@MapperScan("com.logistics.mapper") // 扫描MyBatis Mapper接口
@CrossOrigin(origins = "*", maxAge = 3600) // 跨域配置
public class LogisticsApplication {
    public static void main(String[] args) {
        SpringApplication.run(LogisticsApplication.class, args);
        System.out.println("===== 物流可视化系统后端启动成功（端口：8080） =====");
    }
}