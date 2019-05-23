package com.alexis.funchat.util;

import java.util.Collection;
import java.util.List;
import java.util.Map;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

/**
 * Class description:
 *
 * @author Alexis
 * @date 2019/5/16  8:22
 */
public class CollectionsUtils {

    private CollectionsUtils() {
        throw new UnsupportedOperationException();
    }

    public static <E> int sizeOf(@Nullable Collection<E> collection) {
        return Validator.isEmpty(collection) ? 0 : collection.size();
    }

    public static <K, V> int sizeOf(@Nullable Map<K, V> map) {
        return Validator.isEmpty(map) ? 0 : map.size();
    }

    public static <E> int sizeOf(@Nullable E[] e) {
        return Validator.isEmpty(e) ? 0 : e.length;
    }

    public static <E> E get(@NonNull List<E> collection, int index) {
        return sizeOf(collection) == 0 ? null : collection.get(index);
    }
}
