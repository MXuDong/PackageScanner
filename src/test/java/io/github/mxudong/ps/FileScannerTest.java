package io.github.mxudong.ps;

import io.github.mxudong.ps.scanners.FileScanner;
import org.junit.Test;

import java.util.List;

public class FileScannerTest {
    @Test
    public void test1() {
        FileScanner fileScanner = new FileScanner("E:\\Work Space\\Intellij WorkSpace\\PackageScanner\\src\\main\\java\\io\\github\\mxudong\\ps");
        List<String> r = fileScanner.doScan(null);
        for (String s : r) {
            System.out.println(s);
        }

        System.out.println(FileScannerTest.class.getPackage().getName());
        System.out.println(Thread.currentThread().getContextClassLoader().getResource(FileScannerTest.class.getPackage().getName().replace(".", "/")));
    }
}