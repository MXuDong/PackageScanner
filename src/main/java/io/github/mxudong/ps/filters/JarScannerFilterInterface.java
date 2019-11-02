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

public interface JarScannerFilterInterface extends FilterInterface {

    /**
     * {@inheritDoc}
     *
     * @param o the target object
     * @return is the object will be filter
     */
    @Override
    default boolean canBeFilter(Object o) {
        return o instanceof JarEntry;
    }

    /**
     * {@inheritDoc}
     *
     * @param o target object
     * @return is the object can be acces
     */
    @Override
    default boolean canAccess(Object o) {
        return canBeFilter(o) && canAccessJar((JarEntry) o);
    }

    /**
     * For jar fill, it will intercept all jar file.
     *
     * @param jarEntry be judged jar file entity.
     * @return can be passed.
     */
    boolean canAccessJar(JarEntry jarEntry);
}
