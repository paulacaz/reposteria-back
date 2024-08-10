package com.proyecto.reposteria.util;

import java.util.Locale;

public class LocaleUtil {

    public static boolean checkDefaultLocale(Locale locale){
        return locale.getLanguage().equals("es");
    }
}
