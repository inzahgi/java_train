package com.inzahgi.rpc.framework.spring;

import org.springframework.beans.factory.xml.NamespaceHandlerSupport;

public class RpcReferenceNamespaceHandler extends NamespaceHandlerSupport {
    @Override
    public void init() {
        registerBeanDefinitionParser("reference", new RevokerFactoryBeanDefinitionParser());
    }
}
