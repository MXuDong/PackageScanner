package io.github.mxudong.ps.filters;

import io.github.mxudong.ps.scanners.JarScanner;

import java.util.jar.JarEntry;

/**
 * The jar entity for JarScanner.
 *
 * @author Dong
 * @see JarScanner
 * @since 1.0.0
 */

public interface JarScannerFilterInterface extends FilterInterface{

    /**
     * For jar fill, it will intercept all jar file.
     *
     * @param jarEntry be judged jar file entity.
     * @return can be passed.
     */
    boolean canAccess(JarEntry jarEntry);
}
