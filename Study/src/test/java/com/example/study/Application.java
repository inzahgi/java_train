package com.example.study;

import com.example.study.event.CustomizePublisher;
import com.example.study.event.MealEnum;
import com.example.study.event.MealEvent;
import com.example.study.event.TroubleEvent;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;

import java.util.concurrent.TimeUnit;

@SpringBootApplication
@ComponentScan("com.example.study.")
@MapperScan(basePackages ={"com.example.study.mapper"} )
public class Application {

//	@Bean
//    public PageHelper pageHelper() {
//		PageHelper pageHelper = new PageHelper();
//		Properties properties = new Properties();
//		properties.setProperty("offsetAsPageNum", "true");
//		properties.setProperty("rowBoundsWithCount", "true");
//		properties.setProperty("reasonable", "true");
//		properties.setProperty("dialect", "mysql");    //配置mysql数据库的方言
//		pageHelper.setProperties(properties);
//		return pageHelper;
//	}


	public static void main(String[] args) throws Exception{
		ApplicationContext ctx = SpringApplication.run(Application.class, args);
		
		System.out.println("Done!!!!!!!!!!!!");
	}




}
