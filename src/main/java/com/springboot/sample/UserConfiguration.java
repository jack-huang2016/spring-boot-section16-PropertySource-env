package com.springboot.sample;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import com.springboot.sample.entity.MgrParamScope;

/**
 * 读取多个properties配置文件,读取单个配置文件也是一样的，
 * 改成@PropertySource(value = "classpath:user.properties")即可
 * @author huang.yj
 *
 */
@Configuration
@PropertySource(value = {"classpath:user.properties","classpath:user2.properties"},ignoreResourceNotFound = false, encoding = "UTF-8")
public class UserConfiguration {

	@Autowired 
	Environment environment; 
	
	@Bean(name="mgrParamScope")
	public MgrParamScope getMgrParamScope(){
		 String token = this.environment.getProperty("token");
		 String username = this.environment.getProperty("test.username");
	     System.out.println(token);
	     System.out.println(username);
	     return new MgrParamScope();
	}
	
}
