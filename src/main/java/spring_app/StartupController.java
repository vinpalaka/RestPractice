package spring_app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication//This needs to outside so component scan can work
public class StartupController {

    public static void main(String[] args) throws Exception {
        SpringApplication.run(StartupController.class, args);
    }


}
