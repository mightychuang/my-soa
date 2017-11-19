package com.zhy.configBean;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

import com.zhy.registry.RegistryDelegate;

/**
 * 服务方暴露服务标签
 * @author zhy
 *
 */
public class Service extends BaseConfigBean implements InitializingBean, ApplicationContextAware{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private ApplicationContext context;
	
	private String intf;
	private String ref;
	private String protocol;
	public String getIntf() {
		return intf;
	}
	public void setIntf(String intf) {
		this.intf = intf;
	}
	public String getRef() {
		return ref;
	}
	public void setRef(String ref) {
		this.ref = ref;
	}
	public String getProtocol() {
		return protocol;
	}
	public void setProtocol(String protocol) {
		this.protocol = protocol;
	}
	@Override
	public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
		context = applicationContext;
		
	}
	@Override
	public void afterPropertiesSet() throws Exception {
		//向注册中心注册服务
		RegistryDelegate.registry(this.ref, context);
	}
	
	
	
}
