package io.github.mxudong.ps.utils;

/**
 * This is a util class for path string, this class provide
 * many method to convert path or solve the problem which
 * about the path.
 *
 * @author Dong
 * @since 1.0.0
 */

public class PathUtils {

    /**
     * Judge if the class in the jar file.
     * @param klass
     * @return
     */
    public static boolean isInJar(Class klass){
        System.out.println(klass.getResource("."));
        return klass.getResource(".") == null;
    }

}