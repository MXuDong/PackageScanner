package io.github.mxudong.ps.filters;

/**
 * The all filer's must implements this interface in the PackageScanner
 * framework. The programmer can implement this class to provide other
 * features.
 * <p>
 * If some class implements from the ScannerInterface, it batter to
 * create the class to implements from this interface. But, the
 * programmer can haven't to do it.
 *
 * @author Dong
 * @see io.github.mxudong.ps.scanners.ScannerInterface
 * @since 1.0.0
 */
public interface FilterInterface {

    /**
     * The filter shall judge whether it is allowed to pass according
     * to the standard. This part has subclasses to specify specific
     * implementation.
     *
     * @param o target object
     * @return if can pass return true, else return false
     */
    boolean canPass(Object o);
}
