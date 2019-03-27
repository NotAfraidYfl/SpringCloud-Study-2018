package com.atguigu.springcloud.cfgbeans;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import com.netflix.loadbalancer.RetryRule;

@Configuration
public class ConfigBean {

	@Bean
	@LoadBalanced // Spring Cloud Ribbon是基于Netflix Ribbon实现的一套客户端 负载均衡的工具。
	public RestTemplate getRestTemplate() {

		return new RestTemplate();
	}

	@Bean
	public IRule myRule() {
		// 配置自定以的负载均衡算法
		//return new RandomRule(); //负载均衡随机访问
		return new RetryRule();
	}

}
