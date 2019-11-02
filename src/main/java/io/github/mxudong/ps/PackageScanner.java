package io.github.mxudong.ps;

import io.github.mxudong.ps.filters.FileScannerFilterInterface;
import io.github.mxudong.ps.filters.JarScannerFilterInterface;
import io.github.mxudong.ps.scanners.FileScanner;

/**
 * This class provide some method for package scan in JAVA. Use this
 * class, the program can quick get target class which want.
 * <p>
 * It start with the target path in file or JarFile. And scan the path
 * for all classes or other type file. The scan result is a list for
 * files or classes cache and also can be the path value, but for path
 * value, if the target class is in JarFile, the string is null. So the
 * result of string is can't use by JarFile. But common file can.
 * <p>
 * The scan behavior can be ctrl by program who use it. It contain many
 * filter and method to limit the result.
 *
 * @author Dong
 * @since 1.0.0
 */

public class PackageScanner {

    /**
     * The construction of PackageScanner. It receive the classes, and
     * convert to path string for used.
     * <p>
     * If the target class in the Jar file. That jar file will be named
     * target jar. The packageScanner will scan all file which in the
     * target jar.
     * <p>
     * This construction has no filter, because it use default filter,
     * and other construction can receive the filter.
     *
     * @param targetClasses The target classes
     */
    public PackageScanner(Class... targetClasses) {

    }

    public PackageScanner(JarScannerFilterInterface jsfi,
                          FileScannerFilterInterface fsfi,
                          Class... targetClasses) {


    }

    public PackageScanner(String ... FilesPath){

    }

    public PackageScanner(FileScannerFilterInterface fsfi, String... FilesPath){

    }


}

/**
 * The inner class for PackageScanner scan the files.
 */
class JarScanner {

}