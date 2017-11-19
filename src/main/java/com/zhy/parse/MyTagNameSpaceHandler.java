package com.zhy.parse;

import org.springframework.beans.factory.xml.NamespaceHandlerSupport;

import com.zhy.configBean.Protocol;
import com.zhy.configBean.Reference;
import com.zhy.configBean.Registry;
import com.zhy.configBean.Service;

public class MyTagNameSpaceHandler extends NamespaceHandlerSupport {

	@Override
	public void init() {
		registerBeanDefinitionParser("registry", new RegistryBeanDifinitionParser(Registry.class));
		registerBeanDefinitionParser("reference", new ReferenceBeandefinitionParser(Reference.class));
		registerBeanDefinitionParser("protocol", new ProtocolBeandefinition(Protocol.class));
		registerBeanDefinitionParser("service", new ServiceBeanDefinitionParser(Service.class));
	}

}
