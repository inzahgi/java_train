package com.inzahgi.rpc.framework.spring;

import org.springframework.beans.factory.xml.NamespaceHandlerSupport;

public class RpcServiceNamespaceHandler extends NamespaceHandlerSupport {
    @Override
    public void init() {
        registerBeanDefinitionParser("service", new ProviderFactoryBeanDefinitionParser());
    }
}
