package com.tz.ssh.action;

import org.springframework.core.io.DefaultResourceLoader;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;

import java.net.URL;

/**
 * Created by hjl on 2015/8/15.
 */
public class MyResourceLoader extends DefaultResourceLoader {
    @Override
    public Resource getResource(String location) {
        //对要加载的文件资源进行自定义的解析，判断下文件路径是否是以“/WEB-INF/”开头，从而进行处理
        if (location != null && (location.startsWith("/WEB-INF/"))) {
            try {
                //由于工程是maven工程，所以路径重定向到web应用的路径下
                URL url = new URL("file:/" + System.getProperty("user.dir")
                        + "/src/main/webapp" + location);
                return new UrlResource(url);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return super.getResource(location);
    }
}
