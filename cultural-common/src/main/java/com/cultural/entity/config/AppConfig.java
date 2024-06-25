package com.cultural.entity.config;

import com.cultural.utils.StringTools;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component("appConfig")
public class AppConfig {

    /**
     * 资源文件目录
     */
    @Value("${project.folder:}")
    private String projectFolder;

    @Value("${image.ffmpegCompress:false}")
    private Boolean ffmpegCompress;

    @Value("${inner.api.appKey:''}")
    private String innerApiAppKey;

    @Value("${inner.api.appSecret:''}")
    private String innerApiAppSecret;

    @Value("${isDev:false}")
    private Boolean isDev;

    @Value("${super.admin.phones:}")
    private String superAdminPhones;

    @Value("${jwt.common.secret:}")
    private String jwtCommonSecret;

    public String getSuperAdminPhones() {
        return superAdminPhones;
    }

    public String getJwtCommonSecret() {
        return jwtCommonSecret;
    }

    public void setJwtCommonSecret(String jwtCommonSecret) {
        this.jwtCommonSecret = jwtCommonSecret;
    }

    public String getProjectFolder() {
        if (!StringTools.isEmpty(projectFolder) && !projectFolder.endsWith("/")) {
            projectFolder = projectFolder + "/";
        }
        return projectFolder;
    }

    public Boolean getFfmpegCompress() {
        return ffmpegCompress;
    }

    public String getInnerApiAppKey() {
        return innerApiAppKey;
    }

    public String getInnerApiAppSecret() {
        return innerApiAppSecret;
    }

    public Boolean getDev() {
        return isDev;
    }
}
