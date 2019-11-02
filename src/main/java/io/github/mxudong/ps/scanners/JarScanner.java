package io.github.mxudong.ps.scanners;

import io.github.mxudong.ps.filters.JarScannerFilterInterface;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;
import java.util.jar.JarEntry;
import java.util.jar.JarFile;

/**
 * The jar scanner provide method for JAR scanner operation.
 *
 * @author Dong
 * @since 1.0.0
 */

public class JarScanner {
    /**
     * the jar file's end string
     */
    public static final String JAR_FILE_SUFFIX = ".jar";


    private JarFile targetJarFile;

    /**
     * The default construction, if the jarFile is null, the
     * targetJarFile will be set null.
     *
     * @param jarFile target jar file
     */
    public JarScanner(JarFile jarFile) {
        if (jarFile == null) {
            this.targetJarFile = null;
        } else {
            this.targetJarFile = jarFile;
        }
    }


    /**
     * The construction, if the target path is not exists, the
     * jar file will be set null.
     *
     * @param jarPath target file path
     */
    public JarScanner(String jarPath) {
        if (jarPath.endsWith(JarScanner.JAR_FILE_SUFFIX)) {
            if (new File(jarPath).exists()) {
                try {
                    this.targetJarFile = new JarFile(jarPath);
                } catch (IOException e) {
                    this.targetJarFile = null;
                }
            } else {
                this.targetJarFile = null;
            }
        }
    }

    /**
     * scan the target jar file from the construction. The filters
     * will block all types of files, such as directories and files.
     * <p>
     * For all filter in filters, the logical operation is {@code OR},
     * so if at least one filter can access the jar entry, the jar
     * entry will be access. If the program need the logical operation
     * is {@code AND}, it need create the new filer from the
     * JarScannerFilterInterface to make all filter check the file for
     * result by {@code AND}
     *
     * @param filters the filters to block files.
     * @return the jar file
     * @see JarScannerFilterInterface
     */
    public List<JarEntry> doScan(JarScannerFilterInterface... filters) {
        List<JarEntry> r = new ArrayList<>();
        Enumeration<JarEntry> enumeration = this.targetJarFile.entries();

        if (filters == null) {
            filters = new JarScannerFilterInterface[1];
            filters[0] = (o) -> true;
        }

        while (enumeration.hasMoreElements()) {
            JarEntry jarEntry = enumeration.nextElement();
            for (JarScannerFilterInterface jsfi : filters) {
                if (jsfi.canAccess(jarEntry)) {
                    r.add(jarEntry);
                }
            }
        }

        return r;
    }

}
