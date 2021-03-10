package com.qing.springboot02.config;

import org.springframework.web.servlet.LocaleResolver;
import org.thymeleaf.util.StringUtils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Locale;

public class MyLocaleResolver implements LocaleResolver {
    @Override
    public Locale resolveLocale(HttpServletRequest request) {
        //获取请求的语言
        String language = request.getParameter("l");

        System.out.println("Debug====" + language);
        Locale locale = Locale.getDefault();  //如果没有就是用默认的


        //如果请求的链接携带了国际化的参数
        if (!StringUtils.isEmpty(language)) {
            String[] split = language.split("_");
            //国家，地区
            locale = new Locale(split[0], split[1]);
        }
        return locale;
    }
        @Override
        public void setLocale (HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Locale
        locale){

        }
    }

