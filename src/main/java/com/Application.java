package com;

import com.bocs.core.util.SpringContextUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * @author songqi
 * @date
 */
@EnableTransactionManagement()
@SpringBootApplication
public class Application {

	private final static Logger logger = LoggerFactory.getLogger(Application.class);

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}


	/**
	 * 配置springContextUtil，以方便获取applicationContext
	 * @return
	 */
	@Bean
	public SpringContextUtil springContextUtil(){
		return new SpringContextUtil();
	}

}
