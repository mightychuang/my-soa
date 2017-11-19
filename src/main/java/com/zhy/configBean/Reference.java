package com.zhy.configBean;

/**
 * 消费方引用服务的标签
 * 
 * @author zhy
 *
 */
public class Reference extends BaseConfigBean {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String intf;//需要被代理接口，同时也是服务方提供服务接口

	private String loadbalance;//负载均衡策略

	private String protocol;//通讯协议

	private String cluster;//集群容错策略

	private String retries;//重试次数

	public String getIntf() {
		return intf;
	}

	public void setIntf(String intf) {
		this.intf = intf;
	}

	public String getLoadbalance() {
		return loadbalance;
	}

	public void setLoadbalance(String loadbalance) {
		this.loadbalance = loadbalance;
	}

	public String getProtocol() {
		return protocol;
	}

	public void setProtocol(String protocol) {
		this.protocol = protocol;
	}

	public String getCluster() {
		return cluster;
	}

	public void setCluster(String cluster) {
		this.cluster = cluster;
	}

	public String getRetries() {
		return retries;
	}

	public void setRetries(String retries) {
		this.retries = retries;
	}
	
	
	

}
