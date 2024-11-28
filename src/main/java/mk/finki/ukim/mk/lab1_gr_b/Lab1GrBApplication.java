package mk.finki.ukim.mk.lab1_gr_b;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

@ServletComponentScan
@SpringBootApplication
public class Lab1GrBApplication {

    public static void main(String[] args) {
        SpringApplication.run(Lab1GrBApplication.class, args);
    }

}
