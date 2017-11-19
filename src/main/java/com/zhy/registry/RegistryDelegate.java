package com.zhy.registry;

import java.util.List;

import org.springframework.context.ApplicationContext;

import com.zhy.configBean.Registry;

/**
 * 注册服务的委托类<BR>
 * 
 *  委托模式  不直接调用具体业务类，使得调用者与具体业务实现类解耦
 * @author zhy
 *
 */
public class RegistryDelegate {
	/**
	 * 先从上下文里拿到注册类<BR>
	 * 根据注册类的协议拿到对应的注册实现类
	 * 调用注册实现类向注册中心注册服务类
	 * @param ref
	 * @param application
	 * @return
	 */
	public static boolean registry(String ref, ApplicationContext application){
		Registry protocol = application.getBean(Registry.class);
		BaseRegistry registry = protocol.getRegistryByProtocol();
		return registry.registry(ref, application);
	}
	
	/**
	 * 先从上下文里拿到注册类<BR>
	 * 根据注册类的协议拿到对应的注册实现类
	 * 调用注册实现类向注册中心获取对应服务
	 * @param id
	 * @param application
	 * @return
	 */
	public static List<String> getRegistryInfos(String id,
            ApplicationContext application){
		Registry protocol = application.getBean(Registry.class);
		BaseRegistry registry = protocol.getRegistryByProtocol();
		return registry.getRegistryInfo(id, application);
	}
}
