package com.mly.mango.utils;

import java.io.Closeable;
import java.io.IOException;

/**
 * @author wyn
 * @Description IO相关工具类
 * @date 2020-04-05 10:22
 */
public class IOUtils {
    /**
     * 关闭对象，连接
     * @param closeable
     */
    public static void closeQuietly(final Closeable closeable) {
        try {
            if (closeable != null) {
                closeable.close();
            }
        } catch (final IOException ioe) {
            // ignore
        }
    }
}
