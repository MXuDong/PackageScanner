package io.github.mxudong.ps.scanners;

import io.github.mxudong.ps.filters.FilterInterface;

import java.util.List;

/**
 * The PackageScanner framework's root class. All the scanner must implements
 * this class, and for every implementations should create the filter to
 * implements FilterInterface in same time, although it is non essential.
 *
 * @author Dong
 */

public interface ScannerInterface {

    /**
     * Do scan operation, and the filter will intercept some file
     * or something if they are not be want. The result is the list,
     * about the infos from the class files.
     *
     * @param fi the filter
     * @return scan result
     */
    List doScan(FilterInterface fi);
}
