package com.exp.zsq.lambda;

import java.io.BufferedReader;
import java.io.IOException;

/**
 * Author: zhaoshengqi
 * Date: 2019/12/12 下午5:30
 */
@FunctionalInterface
public interface BufferedReaderProcessor {
    String process(BufferedReader br) throws IOException;
}
