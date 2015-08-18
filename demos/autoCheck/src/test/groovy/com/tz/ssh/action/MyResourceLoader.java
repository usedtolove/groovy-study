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
        //��Ҫ���ص��ļ���Դ�����Զ���Ľ������ж����ļ�·���Ƿ����ԡ�/WEB-INF/����ͷ���Ӷ���д���
        if (location != null && (location.startsWith("/WEB-INF/")
//                || location.startsWith("WEB-INF/")
        )) {
            try {
                // ���ڹ�����maven���̣�����·���ض���webӦ�õ�·����
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
