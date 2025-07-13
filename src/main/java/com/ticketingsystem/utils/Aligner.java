package com.ticketingsystem.utils;

import org.apache.commons.lang3.StringUtils;

public class Aligner {
    public static final int SIZE_VIEW = 80;

    public enum Alignment {
        CENTER,
        LEFT,
        RIGHT
    }

    public static String position(String text, Alignment alignment) {
        if(alignment == Alignment.LEFT){
            return StringUtils.rightPad(text, SIZE_VIEW);
        } else if (alignment == Alignment.RIGHT){
            return StringUtils.leftPad(text, SIZE_VIEW);
        } else {
            return StringUtils.center(text, SIZE_VIEW);
        }
    }

    public static String position(String text, Alignment alignment, char separator) {
        if(alignment == Alignment.LEFT){
            return StringUtils.rightPad(text, SIZE_VIEW, separator);
        } else if (alignment == Alignment.RIGHT){
            return StringUtils.leftPad(text, SIZE_VIEW, separator);
        } else {
            return StringUtils.center(text, SIZE_VIEW, separator);
        }
    }

    public static String line() {
        return StringUtils.center("", SIZE_VIEW, "-");
    }

    public static String emptyLine() {
        return StringUtils.center("", SIZE_VIEW);
    }

    public static String alingBlockLeft(String text) {
        return  "| " + (text + " ".repeat(SIZE_VIEW - text.length() - 3)) + "|";
    }

    public static String alignBlockCenter(String text) {
        return "|" + StringUtils.center(text, SIZE_VIEW - 2) + "|";
    }
}
