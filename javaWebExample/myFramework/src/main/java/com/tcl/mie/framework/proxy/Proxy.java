package com.tcl.mie.framework.proxy;

public interface Proxy {
    Object doProxy(ProxyChain proxyChain) throws Throwable;
}
