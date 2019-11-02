package io.github.mxudong.ps.utils;

import org.junit.Test;
import org.junit.internal.ArrayComparisonFailure;

import static org.junit.Assert.*;

public class PathUtilsTest {

    @Test
    public void test1(){
        System.out.println(PathUtils.isInJar(PathUtilsTest.class));
        System.out.println(PathUtils.isInJar(ArrayComparisonFailure.class));
    }
}