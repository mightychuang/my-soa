package com.zhy.registry;

import java.util.List;

import org.springframework.context.ApplicationContext;

/**
 * 注册服务与获取服务接口
 * @author zhy
 *
 */
public interface BaseRegistry {
	
	/**
	 * 向服务注册中心注册服务
	 * @param param
	 * @param application
	 * @return
	 */
	boolean registry(String param, ApplicationContext application);
	
	
	/**
	 * 根据参数注册中心拉取服务列表
	 * @param id
	 * @param application
	 * @return
	 */
	List<String> getRegistryInfo(String id, ApplicationContext application);
}
