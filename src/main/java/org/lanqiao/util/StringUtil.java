package org.lanqiao.util;

import java.util.Random;

public class StringUtil {
    //生成一个6位随机数
    public static String getVerifyCode() {
        Random random = new Random();
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < 6; i++) {
            stringBuilder.append(String.valueOf(random.nextInt(9)+1));
        }
        return stringBuilder.toString();
    }
}
