package io.github.mxudong.ps;

import io.github.mxudong.ps.filters.DefaultClassFilter;
import org.junit.Test;

import static org.junit.Assert.*;

public class JarScannerTest {
    @Test
    public void test1(){
        JarScanner jarScanner = new JarScanner("E:\\Work Space\\Intellij WorkSpace\\PackageScanner\\target\\PackageScanner-1.0-SNAPSHOT.jar");
        System.out.println(jarScanner.doScan(new DefaultClassFilter()));
    }
}