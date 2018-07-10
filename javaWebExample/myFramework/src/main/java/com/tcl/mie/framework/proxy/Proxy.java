package com.tcl.mie.framework.proxy;

/**
 * 代理类接口
 */
public interface Proxy {
    Object doProxy(ProxyChain proxyChain) throws Throwable;
}
