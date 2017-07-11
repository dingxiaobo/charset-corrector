package cn.dxbtech.config;

import org.springframework.core.MethodParameter;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.support.WebDataBinderFactory;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.method.support.ModelAndViewContainer;

import javax.servlet.http.HttpServletRequest;

public class RemoteIpAddressArgumentResolver implements HandlerMethodArgumentResolver {
    @Override
    public boolean supportsParameter(MethodParameter parameter) {
        return parameter.hasParameterAnnotation(RemoteIpAddress.class);
    }

    @Override
    public Object resolveArgument(MethodParameter parameter, ModelAndViewContainer mavContainer, NativeWebRequest webRequest, WebDataBinderFactory binderFactory) throws Exception {
        HttpServletRequest request = (HttpServletRequest) webRequest.getNativeRequest();

        String remoteAddr = request.getRemoteAddr();
        if (!StringUtils.isEmpty(remoteAddr)) {
            if ("127.0.0.1".equals(remoteAddr) ||
                    "0:0:0:0:0:0:0:1".equals(remoteAddr)) {
                String nginxIp = request.getHeader("X-real-ip");
                if (!StringUtils.isEmpty(nginxIp)) {
                    remoteAddr = nginxIp;
                }
            }
        }
        return remoteAddr;
    }
}
