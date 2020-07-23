//package com.baeldung.bootcustomfilters.model;
//import javax.validation.constraints.Pattern;
//import javax.validation.constraints.NotNull;
//
//public class HeaderModel {
//
//    @NotNull(message="app-name can not be null")
//    @Pattern(regexp = "(?:^|\\W)fast-r(?:$|\\W)", message="incorrect app-name")
//    private String app_name;
//
//    @NotNull(message="auth-key can not be null")
//    @Pattern(regexp = "(?:^|\\W)abc123(?:$|\\W)", message="incorrect auth-key")
//    private String auth_key;
//
//    public String getApp_name() {
//        return app_name;
//    }
//
//    public void setApp_name(String app_name) {
//        this.app_name = app_name;
//    }
//
//    public String getAuth_key() {
//        return auth_key;
//    }
//
//    public void setAuth_key(String auth_key) {
//        this.auth_key = auth_key;
//    }
//}
