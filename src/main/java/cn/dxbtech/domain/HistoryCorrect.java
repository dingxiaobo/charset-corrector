package cn.dxbtech.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Date;

@Entity
public class HistoryCorrect {

    @Id
    @GeneratedValue
    private Long id;
    private Date time = new Date();
    @Column(length = 65532)
    private String origin;
    private String originCharset;
    @Column(length = 65532)
    private String result;
    private String resultCharset;
    private String ip;
    private String ua;

    public HistoryCorrect() {
    }

    public HistoryCorrect(String origin, String originCharset, String result, String resultCharset) {
        this.origin = origin;
        this.originCharset = originCharset;
        this.result = result;
        this.resultCharset = resultCharset;
    }

    public HistoryCorrect(String origin, String originCharset, String result, String resultCharset, String ip, String ua) {
        this.origin = origin;
        this.originCharset = originCharset;
        this.result = result;
        this.resultCharset = resultCharset;
        this.ip = ip;
        this.ua = ua;
    }

    public String getResultCharset() {
        return resultCharset;
    }

    public void setResultCharset(String resultCharset) {
        this.resultCharset = resultCharset;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    public String getOriginCharset() {
        return originCharset;
    }

    public void setOriginCharset(String originCharset) {
        this.originCharset = originCharset;
    }

    public String getOrigin() {
        return origin;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
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
