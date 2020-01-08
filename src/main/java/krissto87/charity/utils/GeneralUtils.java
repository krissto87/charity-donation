package krissto87.charity.utils;

import org.springframework.security.core.context.SecurityContextHolder;


public class GeneralUtils {

    public static String getUsername() {
        return SecurityContextHolder.getContext().getAuthentication().getName();
    }

}
