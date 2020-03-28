package nl.kolkos.crypto.telegram.bot.backend;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

import javax.annotation.PostConstruct;
import java.util.Date;
import java.util.TimeZone;

@SpringBootApplication
@EnableScheduling
public class Application {
    @PostConstruct
    public void init(){
        TimeZone.setDefault(TimeZone.getTimeZone("Europe/Amsterdam"));   // It will set UTC timezone
        System.out.println("Spring boot application running in UTC timezone :"+new Date());   // It will print UTC timezone
    }

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}
