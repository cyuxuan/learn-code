/*
 * Copyright ©2023-2023 BeeNest Club. All rights reserved.
 */

package club.beenest.blog.support.common.entity.log;

import java.util.Date;

/**
 * 访问日志
 *
 * @author 陈玉轩
 * @since 1.0
 */
public class VisitLog {
    private Long id;

    /**
     * 访客标识码
     */
    private String uuid;

    /**
     * 请求接口
     */
    private String uri;

    /**
     * 请求方式
     */
    private String method;

    /**
     * 请求参数
     */
    private String param;

    /**
     * 访问行为
     */
    private String behavior;

    /**
     * 访问内容
     */
    private String content;

    /**
     * 备注
     */
    private String remark;

    /**
     * ip
     */
    private String ip;

    /**
     * ip来源
     */
    private String ipSource;

    /**
     * 操作系统
     */
    private String os;

    /**
     * 浏览器
     */
    private String browser;

    /**
     * 请求耗时（毫秒）
     */
    private Integer times;

    /**
     * 访问时间
     */
    private Date createTime;

    /**
     *
     */
    private String userAgent;

    public VisitLog(String uuid, String uri, String method, String behavior, String content, String remark, String ip, Integer times, String userAgent) {
        this.uuid = uuid;
        this.uri = uri;
        this.method = method;
        this.behavior = behavior;
        this.content = content;
        this.remark = remark;
        this.ip = ip;
        this.times = times;
        this.createTime = new Date();
        this.userAgent = userAgent;
    }

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUuid() {
		return uuid;
	}

	public void setUuid(String uuid) {
		this.uuid = uuid;
	}

	public String getUri() {
		return uri;
	}

	public void setUri(String uri) {
		this.uri = uri;
	}

	public String getMethod() {
		return method;
	}

	public void setMethod(String method) {
		this.method = method;
	}

	public String getParam() {
		return param;
	}

	public void setParam(String param) {
		this.param = param;
	}

	public String getBehavior() {
		return behavior;
	}

	public void setBehavior(String behavior) {
		this.behavior = behavior;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public String getIp() {
		return ip;
	}

	public void setIp(String ip) {
		this.ip = ip;
	}

	public String getIpSource() {
		return ipSource;
	}

	public void setIpSource(String ipSource) {
		this.ipSource = ipSource;
	}

	public String getOs() {
		return os;
	}

	public void setOs(String os) {
		this.os = os;
	}

	public String getBrowser() {
		return browser;
	}

	public void setBrowser(String browser) {
		this.browser = browser;
	}

	public Integer getTimes() {
		return times;
	}

	public void setTimes(Integer times) {
		this.times = times;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public String getUserAgent() {
		return userAgent;
	}

	public void setUserAgent(String userAgent) {
		this.userAgent = userAgent;
	}

	@Override
	public String toString() {
		return "VisitLog{" +
				"id=" + id +
				", uuid='" + uuid + '\'' +
				", uri='" + uri + '\'' +
				", method='" + method + '\'' +
				", param='" + param + '\'' +
				", behavior='" + behavior + '\'' +
				", content='" + content + '\'' +
				", remark='" + remark + '\'' +
				", ip='" + ip + '\'' +
				", ipSource='" + ipSource + '\'' +
				", os='" + os + '\'' +
				", browser='" + browser + '\'' +
				", times=" + times +
				", createTime=" + createTime +
				", userAgent='" + userAgent + '\'' +
				'}';
	}
}
