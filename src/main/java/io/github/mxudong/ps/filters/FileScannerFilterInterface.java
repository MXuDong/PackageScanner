package io.github.mxudong.ps.filters;

import io.github.mxudong.ps.scanners.FileScanner;

import java.io.File;

/**
 * The file filter for FileScanner.
 *
 * @author Dong
 * @see FileScanner
 * @since 1.0.0
 */
public interface FileScannerFilterInterface extends FilterInterface {

    /**
     * {@inheritDoc}
     *
     * @param o the target object
     * @return is file can be access
     */
    @Override
    default boolean canAccess(Object o) {
        return canBeFilter(o) && canAccessFile((File) o);
    }


    /**
     * {@inheritDoc}
     *
     * @param o the target object
     * @return is object will be filter
     */
    @Override
    default boolean canBeFilter(Object o) {
        return o instanceof File;
    }

    /**
     * For file, it can be directory, so this method can intercept the
     * directory. If not wish intercept the directory, the implement
     * must judge the file type.
     *
     * @param file be judged file.
     * @return can be passed.
     */
    boolean canAccessFile(File file);
}