package io.github.mxudong.ps.utils;

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
     * @param file be judged file.
     * @return can be passed.
     */
    boolean canPass(File file);
}
