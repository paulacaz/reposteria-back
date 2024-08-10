package com.proyecto.reposteria.util;

import lombok.RequiredArgsConstructor;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Component;

import java.util.Locale;

@RequiredArgsConstructor
@Component
public class MessagesUtil {

    private final MessageSource messageSource;

    public String getMessage(String path, Locale locale){
        return this.messageSource.getMessage(path, null, locale);
    }
}
