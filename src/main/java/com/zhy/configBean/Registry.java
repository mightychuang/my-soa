package com.zhy.configBean;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

import com.zhy.registry.BaseRegistry;
import com.zhy.registry.RedisRegistry;


/**
 * 服务方注册服务时会用到
 * 
 * @author zhy
 *
 */
public class Registry extends BaseConfigBean implements ApplicationContextAware {

	public ApplicationContext application;

	private static Map<String, BaseRegistry> registryMap = new HashMap<String, BaseRegistry>();
	
	static{
		registryMap.put("redis", new RedisRegistry());
	}

	private static final long serialVersionUID = 1L;

	private String protocol; // 注册协议
	private String address;// 注册地址（包含IP和PORT）

	public String getProtocol() {
		return protocol;
	}

	public void setProtocol(String protocol) {
		this.protocol = protocol;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	@Override
	public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
		this.application = applicationContext;
	}
	
	public static BaseRegistry getRegistryByProtocol(String protocol){
		return registryMap.get(protocol);
	}
	
	public BaseRegistry getRegistryByProtocol(){
		return registryMap.get(protocol);
	}
}
