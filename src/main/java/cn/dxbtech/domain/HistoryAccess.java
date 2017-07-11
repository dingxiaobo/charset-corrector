package cn.dxbtech.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Date;

@Entity
public class HistoryAccess {
    @Id
    @GeneratedValue
    private Long id;
    private String uri;
    private String ip;
    private String ua;
    private Date time = new Date();

    public HistoryAccess() {
    }

    public HistoryAccess(String uri, String ip, String ua) {
        this.uri = uri;
        this.ip = ip;
        this.ua = ua;
    }

    @Override
    public String toString() {
        return "HistoryAccess{" +
                "uri='" + uri + '\'' +
                ", ip='" + ip + '\'' +
                ", ua='" + ua + '\'' +
                ", time=" + time +
                '}';
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUri() {
        return uri;
    }

    public void setUri(String uri) {
        this.uri = uri;

    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public String getUa() {
        return ua;
    }

    public void setUa(String ua) {
        this.ua = ua;
    }
}
