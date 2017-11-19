package com.zhy.parse;

import java.util.concurrent.atomic.AtomicInteger;

import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.RootBeanDefinition;
import org.springframework.beans.factory.xml.BeanDefinitionParser;
import org.springframework.beans.factory.xml.ParserContext;
import org.springframework.util.StringUtils;
import org.w3c.dom.Element;

public class ReferenceBeandefinitionParser implements BeanDefinitionParser {
	private static AtomicInteger num = new AtomicInteger();
	private static final Integer default_retries = 3;
	
	private Class<?> beanClass;
	
	

	public ReferenceBeandefinitionParser(Class<?> beanClass) {
		this.beanClass = beanClass;
	}



	@Override
	public BeanDefinition parse(Element element, ParserContext parserContext) {
		
		String id = element.getAttribute("id");
        String intf = element.getAttribute("interface");
        String protocol = element.getAttribute("protocol");
        String loadbalance = element.getAttribute("loadbalance");
        String cluster = element.getAttribute("cluster");
        String retries = element.getAttribute("retries");
        
        if (StringUtils.isEmpty(id)) {
            throw new RuntimeException("Reference id 不能为空！");
        }
        if (StringUtils.isEmpty(intf)) {
            throw new RuntimeException("Reference interface 不能为空！");
        }
        if (StringUtils.isEmpty(protocol)) {
            throw new RuntimeException("Reference protocol 不能为空！");
        }
        if (StringUtils.isEmpty(loadbalance)) {
            throw new RuntimeException("Reference loadbalance 不能为空！");
        }
        RootBeanDefinition beanDefinition = new RootBeanDefinition();
        beanDefinition.setBeanClass(beanClass);
        beanDefinition.setLazyInit(false);
        beanDefinition.getPropertyValues().addPropertyValue("id", id);
        beanDefinition.getPropertyValues().addPropertyValue("intf", intf);
        beanDefinition.getPropertyValues().addPropertyValue("protocol",
                protocol);
        beanDefinition.getPropertyValues().addPropertyValue("loadbalance",
                loadbalance);
        beanDefinition.getPropertyValues().addPropertyValue("retries", retries);
        beanDefinition.getPropertyValues().addPropertyValue("cluster", cluster);
        parserContext.getRegistry().registerBeanDefinition("Reference"+num.getAndIncrement(),
                beanDefinition);
		return beanDefinition;
	}

}
