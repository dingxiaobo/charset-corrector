package cn.dxbtech;

import cn.dxbtech.config.RemoteIpAddressArgumentResolver;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import java.util.List;

@SpringBootApplication
public class CharsetCorrectorApplication extends WebMvcConfigurerAdapter {

	public static void main(String[] args) {
		SpringApplication.run(CharsetCorrectorApplication.class, args);
	}


    @Override
    public void addArgumentResolvers(List<HandlerMethodArgumentResolver> argumentResolvers) {
        super.addArgumentResolvers(argumentResolvers);
        argumentResolvers.add(new RemoteIpAddressArgumentResolver());
    }
}
