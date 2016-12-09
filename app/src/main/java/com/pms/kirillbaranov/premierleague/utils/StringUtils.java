package com.pms.kirillbaranov.premierleague.utils;

/**
 * Created by KirillBaranov on 04.12.16.
 */

public class StringUtils {

    public static final String EMPTY_STRING = "";

    /**
     * @param text
     * @param replacement
     * @return <ul>
     * <li>"" (empty string) - if <u>object</u> is null</li>
     * <li><u>object</u>.toString() - if <u>object</u> isn't null</li>
     * </ul>
     */
    public static String replaceNullAsEmptyStr(Object object) {
        return safeString(object, "");
    }

    /**
     * @param text
     * @param replacement
     * @return <ul>
     * <li>null - if text is null </li>
     * <li><b>replacement</b>, else returns itself. </li>
     * </ul>
     */
    public static String safeString(Object text, String replacement) {
        return text != null ? String.valueOf(text) : replacement;
    }

}
