package com.luberis.hbc.util;

import java.util.stream.Stream;

public final class Enums {

    public static <T extends Enum<T>> T toEnum(String value, Class<T> enumClass, T defaultValue) {
        try {
            return value != null ? Enum.valueOf(enumClass, value.toUpperCase()) : defaultValue;
        } catch (IllegalArgumentException e) {
            return defaultValue;
        }
    }

    public static <T extends Enum<T> & EnumCode<U>, U> T toEnumCode(U value, Class<T> enumClass, T defaultValue) {
        return value == null ? defaultValue :
                Stream.of(enumClass.getEnumConstants())
                        .filter(e -> e.getCode().equals(value))
                        .findFirst()
                        .orElse(defaultValue);
    }
}
