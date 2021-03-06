package com.example.study;

import com.example.study.event.CustomizePublisher;
import com.example.study.event.MealEnum;
import com.example.study.event.MealEvent;
import com.example.study.event.TroubleEvent;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.mongodb.MongoDbFactory;
import org.springframework.data.mongodb.core.convert.CustomConversions;
import org.springframework.data.mongodb.core.convert.DbRefResolver;
import org.springframework.data.mongodb.core.convert.DefaultDbRefResolver;
import org.springframework.data.mongodb.core.convert.MappingMongoConverter;
import org.springframework.data.mongodb.core.mapping.MongoMappingContext;

import java.util.Properties;
import java.util.concurrent.TimeUnit;

@SpringBootApplication
@ComponentScan("com.example.study.*")
@MapperScan(basePackages ="com.example.study.mapper" )
public class MyBatisApplication {

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

//	@Bean
//	public MappingMongoConverter mappingMongoConverter(MongoDbFactory factory,
//													   MongoMappingContext context, BeanFactory beanFactory, CustomConversions conversions) {
//		DbRefResolver dbRefResolver = new DefaultDbRefResolver(factory);
//		MappingMongoConverter mappingConverter = new MappingMongoConverter(dbRefResolver, context);
//		// remove _class field
////    mappingConverter.setTypeMapper(new DefaultMongoTypeMapper(null));
//		mappingConverter.setCustomConversions(conversions);
//		return mappingConverter;
//	}

	public static void main(String[] args) throws Exception{
		ApplicationContext ctx = SpringApplication.run(MyBatisApplication.class, args);

		System.out.println("==============bean====start=================");
		String[] beanNames =  ctx.getBeanDefinitionNames();
		System.out.println("beanNames个数："+beanNames.length);
		for(String bn:beanNames){
			System.out.println(bn);
		}
		System.out.println("=====================end=================");

		final CustomizePublisher customizePublisher = ctx.getBean(CustomizePublisher.class);


		Thread thread = new Thread(new Runnable() {
			@Override
			public void run() {
				try {
					System.out.println("开始吃饭：");

					MealEvent lunchEvent = new MealEvent("A吃午饭了", MealEnum.lunch);
					MealEvent breakfastEvent = new MealEvent("B吃早饭了", MealEnum.breakfast);
					MealEvent dinnerEvent = new MealEvent("C吃晚饭了", MealEnum.dinner);
					customizePublisher.publish(lunchEvent);
					TimeUnit.SECONDS.sleep(1l);
					customizePublisher.publish(breakfastEvent);
					TimeUnit.SECONDS.sleep(1l);
					customizePublisher.publish(dinnerEvent);
					TimeUnit.SECONDS.sleep(1l);

					customizePublisher.publish(new TroubleEvent("troblue!!"));
					System.out.println("他们吃完了！");
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		});
		thread.setName("meal-thread");
		thread.start();

		System.out.println(Thread.currentThread().getName() + " is waiting for ....");
		thread.join();
		System.out.println("Done!!!!!!!!!!!!");
	}




}
