package io.github.mxudong.ps.caches;

/**
 * This class manage the caches like ClassCache. For some time, it
 * will be set singleton pattern.
 *
 * @author Dong
 * @see ClassCache
 * @since 1.0.0
 */

public class CacheManager {

    private CacheManager(){}

    private static final CacheManager CACHE_MANAGER = new CacheManager();

    public static CacheManager getCacheManager() {
        return CACHE_MANAGER;
    }
}
