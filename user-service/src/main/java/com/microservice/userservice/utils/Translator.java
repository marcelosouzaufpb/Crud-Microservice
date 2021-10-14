package com.microservice.userservice.utils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.stereotype.Component;

import java.util.Locale;

@Component
public class Translator {

    private static ResourceBundleMessageSource staticMessageSource;

    @Autowired
    private ResourceBundleMessageSource messageSource;

    @Autowired
    Translator(ResourceBundleMessageSource staticMessageSource) {
        Translator.staticMessageSource = staticMessageSource;
    }

    public String toLocale(String messageCode) {
        Locale locale = LocaleContextHolder.getLocale();
        return messageSource.getMessage(messageCode, null, locale);
    }

    public static String staticToLocale(String messageCode) {
        Locale locale = LocaleContextHolder.getLocale();
        if (staticMessageSource != null) {
            return staticMessageSource.getMessage(messageCode, null, locale);
        } else {
            return messageCode;
        }
    }
}
