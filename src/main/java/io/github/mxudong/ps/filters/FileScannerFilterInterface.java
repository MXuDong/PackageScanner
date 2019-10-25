package io.github.mxudong.ps.filters;

import java.io.File;

/**
 * @author Dong
 * @since 1.0.0
 */
public interface FileScannerFilterInterface {

    /**
     * The filter shall judge whether it is allowed to pass according
     * to the standard. This part has subclasses to specify specific
     * implementation.
     *
     * For file, it can be directory, so this method can intercept the
     * directory. If not wish intercept the directory, the implement
     * must judge the file type.
     *
     * @param file be judged file.
     * @return can be passed.
     */
    boolean canPass(File file);
}