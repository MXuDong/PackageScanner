package io.github.mxudong.ps;

import io.github.mxudong.ps.filters.DefaultClassFilter;
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

    }
}