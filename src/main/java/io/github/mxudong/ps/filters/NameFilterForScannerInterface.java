package io.github.mxudong.ps.filters;

import java.io.File;
import java.util.jar.JarEntry;

/**
 * @author Dong
 */
public interface NameFilterForScannerInterface extends JarScannerFilterInterface, FileScannerFilterInterface {

    @Override
    default boolean canPass(File file) {
        return canAccess(file.getName());
    }

    @Override
    default boolean canAccess(JarEntry jarEntry) {
        return canAccess(jarEntry.getName());
    }


    boolean canAccess(String name);
}
