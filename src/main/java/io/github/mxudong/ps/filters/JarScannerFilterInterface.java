package io.github.mxudong.ps.filters;

import java.util.jar.JarEntry;

/**
 * The jar entity for JarScanner.
 *
 * @author Dong
 * @see io.github.mxudong.ps.JarScanner
 * @since 1.0.0
 */

public interface JarScannerFilterInterface {

    /**
     * The filter shall judge weather it is allowed to pass according
     * to the standard. This par has subclasses to specify specific
     * implements.
     * <p>
     * For jar fill, it will intercept all jar file.
     *
     * @param jarEntry be judged jar file entity.
     * @return can be passed.
     */
    boolean canAccess(JarEntry jarEntry);
}
