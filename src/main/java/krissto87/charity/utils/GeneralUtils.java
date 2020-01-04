package krissto87.charity.utils;

import org.springframework.security.core.context.SecurityContextHolder;

import java.time.format.DateTimeFormatter;

public class GeneralUtils {

    public static String getUsername() {
        return SecurityContextHolder.getContext().getAuthentication().getName();
    }

    public static DateTimeFormatter dateTimeFormatter(){
        return DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
    }
}
