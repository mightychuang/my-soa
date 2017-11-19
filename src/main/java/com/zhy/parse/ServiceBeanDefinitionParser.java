package com.zhy.parse;

import java.util.concurrent.atomic.AtomicInteger;

import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.RootBeanDefinition;
import org.springframework.beans.factory.xml.BeanDefinitionParser;
import org.springframework.beans.factory.xml.ParserContext;
import org.springframework.util.StringUtils;
import org.w3c.dom.Element;

public class ServiceBeanDefinitionParser implements BeanDefinitionParser {
	private static AtomicInteger times = new AtomicInteger();
	
	private Class<?> beanClass;

	public ServiceBeanDefinitionParser(Class<?> beanClass) {
		this.beanClass = beanClass;
	}

	@Override
	public BeanDefinition parse(Element element, ParserContext parserContext) {
		String intf = element.getAttribute("interface");
		String ref = element.getAttribute("ref");
		String protocol = element.getAttribute("protocol");
		if(StringUtils.isEmpty(protocol) || StringUtils.isEmpty(ref) || StringUtils.isEmpty(intf)){
			throw new RuntimeException("各属性不能为空");
		}
		RootBeanDefinition rootBeanDefinition  = new RootBeanDefinition();
		rootBeanDefinition.setLazyInit(false);
		rootBeanDefinition.setBeanClass(beanClass);
		rootBeanDefinition.getPropertyValues().add("intf", intf);
		rootBeanDefinition.getPropertyValues().add("ref", ref);
		rootBeanDefinition.getPropertyValues().add("protocol", protocol);
		parserContext.getRegistry().registerBeanDefinition("service"+times.getAndIncrement(), rootBeanDefinition);
		return rootBeanDefinition;
	}

}
