package com.tcl.mie;

import com.tcl.mie.filter.PreRequestLongFilter;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@EnableZuulProxy
public class ZuulApplication {

    @Bean
    public PreRequestLongFilter preRequestLogFilter(){
        return new PreRequestLongFilter();
    }
    public static void main(String[] args) {
        SpringApplication.run(ZuulApplication.class, args);
    }
}
