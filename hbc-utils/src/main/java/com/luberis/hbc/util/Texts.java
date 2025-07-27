package com.luberis.hbc.util;

import java.util.Objects;
import java.util.Optional;
import java.util.function.Consumer;

public final class Texts {

    /**
     * Checks if a given String is either null or effectively empty after removing leading or trailing whitespace.
     *
     * @param str The String to check
     * @return false if the string is non-null an contains at least one non-whitespace character else true
     */
    public static boolean isBlank(final String str) {
        return str == null || str.trim().isEmpty();
    }

    /**
     * Checks if a given String is either not null or not effectively empty after removing leading or trailing whitespace.
     *
     * @param str The String to check
     * @return true if the string is not null or not contains only whitespace
     */
    public static boolean isNotBlank(String str) {
        return !isBlank(str);
    }

    /**
     * Performs the action on the given item if it is not null.
     *
     * @param item     The item to check for null and consume.
     * @param consumer The function to apply if the items is not null.
     * @param <T>      The type of the item.
     */
    public static <T> void consumeIfNotNull(T item, Consumer<T> consumer) {
        if (Objects.nonNull(item)) {
            consumer.accept(item);
        }
    }

    /**
     * Performs the action on the given item if it is not null.
     *
     * @param item     The item to check for null and consume.
     * @param consumer The function to apply if the items is not null.
     * @param <T>      The type of the item.
     */
    public static <T> void consumeWithOptional(T item, Consumer<T> consumer) {
        Objects.requireNonNull(consumer);
        Optional.ofNullable(item).ifPresent(consumer);
    }
}
