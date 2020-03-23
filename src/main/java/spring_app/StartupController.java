package spring_app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import spring_app.dao.CustomRepositoryImpl;

@SpringBootApplication//This needs to outside so component scan can work
@EnableJpaRepositories(repositoryBaseClass = CustomRepositoryImpl.class)
public class StartupController {

    public static void main(String[] args) throws Exception {
        SpringApplication.run(StartupController.class, args);
    }

}
