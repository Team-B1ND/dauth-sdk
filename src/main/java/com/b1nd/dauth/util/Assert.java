package com.b1nd.dauth.util;

public abstract class Assert {

    private static final String nullMessage = " must not be null";
    private static final String blankMessage = " must not be blank";
    private static final String oddMessage = " must not be odd";

    public static void notBlank(final String object, final String name) {
        notNull(object, name);
        if("".equals(object.trim())) {
            throw new IllegalArgumentException(name + blankMessage);
        }
    }

    public static void notNull(final Object object, final String name) {
        if (object == null) {
            throw new IllegalArgumentException(name + nullMessage);
        }
    }

    public static void notOdd(final int number, final String name) {
        if(number%2 != 0) {
            throw new IllegalArgumentException(name + oddMessage);
        }
    }

}
