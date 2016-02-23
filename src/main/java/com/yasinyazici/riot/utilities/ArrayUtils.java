package com.yasinyazici.riot.utilities;

import java.util.Arrays;
import java.util.List;

/**
 * Created by Yasin on 19/02/2016.
 * <p>Provides additional methods for simplifying and sparing redundant code, related to arrays.</p>
 */
public class ArrayUtils {

    public static String printArrayToString(Object[] array) {
        return Arrays.toString(array);
    }

    public static Object[] transformList(List<?> list, Object[] dataType) {
        return list.toArray(dataType);
    }
}
