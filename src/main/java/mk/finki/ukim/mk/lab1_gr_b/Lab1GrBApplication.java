package mk.finki.ukim.mk.lab1_gr_b;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;


@ServletComponentScan
@SpringBootApplication
public class Lab1GrBApplication {

    public static void main(String[] args) {
        SpringApplication.run(Lab1GrBApplication.class, args);
    }
}
