package com.yasinyazici.riot.utilities;

import java.util.List;

/**
 * <p>Provides additional methods for simplifying and sparing redundant code, related to arrays.</p>
 *
 * @author Yasin
 */
public class ArrayUtils {

    public static Object[] transformList(List<?> list, Object[] dataType) {
        return list.toArray(dataType);
    }
}
