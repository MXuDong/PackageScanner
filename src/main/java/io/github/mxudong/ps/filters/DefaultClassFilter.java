package io.github.mxudong.ps.filters;

import java.io.File;

/**
 * The DefaultClassFilter implements FileScannerFilterInterface.
 *
 * The DefaultClassFilter only pass the file end with {@code .class}.
 * And if the file is directory, it also can be passed. And if file
 * is null, it will return false.
 *
 * @author Dong
 * @since 1.0.0
 * @see FileScannerFilterInterface
 */

public class DefaultClassFilter implements NameFilterForScannerInterface{
    @Override
    public boolean canPass(File file) {
        if(file == null){
            return false;
        }

        return file.isDirectory() || ;
    }

    @Override
    public boolean canAccess(String name) {
        return name.endsWith(".class");
    }
}
