package com.luberis.hbc.util;

import java.util.Collection;
import java.util.function.Supplier;
import java.util.stream.Stream;

public final class NullSafe {

    public static <T> T get(Supplier<T> supplier) {
        try {
            return supplier.get();
        } catch (NullPointerException e) {
            return null;
        }
    }

    public static <T> Stream<T> safeStream(Collection<T> collection) {
        return collection == null ? Stream.empty() : collection.stream();
    }
}
