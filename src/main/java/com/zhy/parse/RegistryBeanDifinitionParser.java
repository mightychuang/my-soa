package com.zhy.parse;

import java.util.concurrent.atomic.AtomicInteger;

import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.RootBeanDefinition;
import org.springframework.beans.factory.xml.BeanDefinitionParser;
import org.springframework.beans.factory.xml.ParserContext;
import org.springframework.util.StringUtils;
import org.w3c.dom.Element;

public class RegistryBeanDifinitionParser implements BeanDefinitionParser {
	
	private static AtomicInteger num = new AtomicInteger();
	private Class<?> beanClass;
	
	

	public RegistryBeanDifinitionParser(Class<?> beanClass) {
		this.beanClass = beanClass;
	}



	@Override
	public BeanDefinition parse(Element element, ParserContext parserContext) {
		// TODO Auto-generated method stub
		String protocol = element.getAttribute("protocol");
		String address = element.getAttribute("address");
		
		if(StringUtils.isEmpty(protocol) || StringUtils.isEmpty(address)){
			throw new RuntimeException("registry 标签解析错误");
		}
		RootBeanDefinition beanDefinition = new RootBeanDefinition();
		beanDefinition.setBeanClass(beanClass);
		beanDefinition.setLazyInit(false);
		beanDefinition.getPropertyValues().add("protocol", protocol);
		beanDefinition.getPropertyValues().add("address", address);
		parserContext.getRegistry().registerBeanDefinition("registry"+num.getAndIncrement(), beanDefinition);
		return beanDefinition;
	}

}
