package com.teckstudy.book.core.lib.common.util;


import java.util.Random;
import java.util.stream.Collectors;

public class RandomUtils {

    public static String verify(int length) {
        return new Random().ints(6, 0, 10)
                .limit(6)
                .mapToObj(String::valueOf)
                .collect(Collectors.joining(""));
    }
}
