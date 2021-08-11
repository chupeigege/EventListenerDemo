package vip.aquan.eventlistenerdemo;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("vip.aquan.eventlistenerdemo.dao")
public class EventListenerDemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(EventListenerDemoApplication.class, args);
    }

}
