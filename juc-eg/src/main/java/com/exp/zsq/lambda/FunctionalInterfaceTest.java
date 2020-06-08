package com.exp.zsq.lambda;

import java.io.*;

/**
 * Author: zhaoshengqi
 * Date: 2019/12/12 下午3:48
 */
public class FunctionalInterfaceTest {
    public static void main(String[] args) throws IOException {
        File[] hiddelFiles = new File(".").listFiles(File::isHidden);

        //process 2 line
        String result = processFile((BufferedReader br) -> br.readLine() + br.readLine());
    }

    static String processFile() throws IOException {
        try (BufferedReader br = new BufferedReader(new FileReader("A.text"))) {
            return br.readLine();
        }
    }

    static String processFile(BufferedReaderProcessor processor) throws IOException {
        try (BufferedReader br = new BufferedReader(new FileReader("A.text"))) {
            return processor.process(br);
        }
    }
}
