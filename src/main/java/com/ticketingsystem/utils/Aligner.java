package com.ticketingsystem.utils;

import org.apache.commons.lang3.StringUtils;

public class Aligner {
    public static final int SIZE_VIEW = 60;

    public enum Alignment {
        CENTER,
        LEFT,
        RIGHT
    }

    public static String centralize(String text) {
        return StringUtils.center(text, SIZE_VIEW);
    }

    public static String centralize(String text, char separator) {
        return StringUtils.center(text, SIZE_VIEW, separator);
    }

    public static String left(String text) {
        return StringUtils.rightPad(text, SIZE_VIEW);
    }

    public static String left(String text, char separator) {
        return StringUtils.rightPad(text, SIZE_VIEW, separator);
    }

    public static String right(String text) {
        return StringUtils.leftPad(text, SIZE_VIEW);
    }

    public static String right(String text, char separator) {
        return StringUtils.leftPad(text, SIZE_VIEW, separator);
    }

    public static String line() {
        return StringUtils.center("", SIZE_VIEW, "-");
    }

    public static String emptyLine() {
        return StringUtils.center("", SIZE_VIEW);
    }
}
