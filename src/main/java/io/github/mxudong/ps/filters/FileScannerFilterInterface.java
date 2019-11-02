package io.github.mxudong.ps.filters;

import io.github.mxudong.ps.scanners.FileScanner;

import java.io.File;

/**
 * The file filter for FileScanner.
 *
 * @author Dong
 * @since 1.0.0
 * @see FileScanner
 */
public interface FileScannerFilterInterface extends FilterInterface{

    /**
     * For file, it can be directory, so this method can intercept the
     * directory. If not wish intercept the directory, the implement
     * must judge the file type.
     *
     * @param file be judged file.
     * @return can be passed.
     */
    boolean canPass(File file);
}