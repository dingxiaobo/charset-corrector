package cn.dxbtech.dto;

public class CorrectDto {
    private String origin;
    private String originCharset;
    private String result;
    private String resultCharset;

    public CorrectDto(String origin, String originCharset, String result, String resultCharset) {
        this.origin = origin;
        this.originCharset = originCharset;
        this.result = result;
        this.resultCharset = resultCharset;
    }

    public String getOrigin() {
        return origin;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }

    public String getOriginCharset() {
        return originCharset;
    }

    public void setOriginCharset(String originCharset) {
        this.originCharset = originCharset;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public String getResultCharset() {
        return resultCharset;
    }

    public void setResultCharset(String resultCharset) {
        this.resultCharset = resultCharset;
    }
}
