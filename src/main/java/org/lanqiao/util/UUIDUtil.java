package org.lanqiao.util;

import java.util.UUID;

public class UUIDUtil {
    public static String get32UUID() {
        String uuid = UUID.randomUUID().toString().trim().replaceAll("-", "");
        return uuid;
    }
}
