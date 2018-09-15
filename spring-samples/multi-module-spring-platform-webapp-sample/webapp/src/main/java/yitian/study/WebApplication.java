package yitian.study;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import yitian.study.booklist.IBookList;
import yitian.study.booklist.MyBookList;

@SpringBootApplication
public class WebApplication {
    public static void main(String[] args) {
        SpringApplication.run(WebApplication.class, args);
    }

    @Bean
    public IBookList myBookList() {
        return new MyBookList();
    }
}
