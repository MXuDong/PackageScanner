package io.github.mxudong.ps.filters;

/**
 * The Filters root interface int the PackageScanner framework. All
 * filter must implements of this filter interface.
 *
 * @author Dong
 */
public interface FilterInterface {


    /**
     * Is the object will be filter. For method which required this
     * interface, if the target object for every {@code FilterInterface.canBeFilter}
     * are return false, the target object will not access.
     *
     * @param o the target object
     * @return can be judge by canAccess
     * @see #canAccess(Object)
     */
    boolean canBeFilter(Object o);

    /**
     * The filter shall judge weather it is allowed to pass according
     * to the standard. This par has subclasses to specify specific
     * implements.
     *
     * @param o target object
     * @return if the object can be access
     */
    boolean canAccess(Object o);
}
