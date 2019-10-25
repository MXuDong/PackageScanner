package io.github.mxudong.ps;

import org.junit.Test;

public class PSScannerTest {

    @Test
    public void test1(){
        FileScanner psScanner = new FileScanner("E:\\Work Space\\Intellij WorkSpace\\PackageScanner\\src\\main\\java\\io\\github\\mxudong\\ps\\FileScanner.java");
        System.out.println(FileScanner.class.getResource("."));
    }

}