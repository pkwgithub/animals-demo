package com.animals.animalsdemo.unit;

import java.util.UUID;

/**
 * @author pankewei
 * @date 2021/10/9
 */
public class UUIDUtil {
    /**
     * 带-的UUID
     *
     * @return 36位的字符串
     */
    public static String getUUID() {
        return UUID.randomUUID().toString();
    }

    /**
     * 去掉-的UUID
     *
     * @return 32位的字符串
     */
    public static String getUUID2() {
        return UUID.randomUUID().toString().replace("-", "");
    }
}
