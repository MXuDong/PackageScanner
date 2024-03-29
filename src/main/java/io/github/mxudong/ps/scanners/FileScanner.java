package io.github.mxudong.ps.scanners;

import io.github.mxudong.ps.filters.FileScannerFilterInterface;

import java.io.File;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * The scanner of the package.
 * <p>
 * Use this class to check the files from the target path. This class
 * receive the type of File, Class and String. The Scanner will scan
 * from the target file from receive param.
 * <p>
 * Different construction will invoke different method to scan.
 *
 * @author Dong
 * @since 1.0.0
 */

public class FileScanner {
    private File targetFile;

    /**
     * Default construction. Receive the type of File. And if file is
     * directory will scan the file from this path. If the file is not
     * a directory, it will scan from target file's parent file directory.
     * <p>
     * If the file not exists, it will be set null pointer. And inner method
     * will do nothing, such as doScan.
     *
     * @param targetDirectory the file path of scanner start.
     */
    public FileScanner(File targetDirectory) {
        // the targetFile is not null and the file is exists
        if (targetDirectory != null && targetDirectory.exists()) {
            // different type in directory and file.
            this.targetFile = targetDirectory.isDirectory() ? targetDirectory : targetDirectory.getParentFile();
        } else {
            this.targetFile = null;
        }
    }

    /**
     * The FileScanner construction, if the target path is null or length == 0, the
     * inner method will do nothing, such as doScan.
     * <p>
     * If the file is not directory, it will set the target file's parent file
     * directory. For this part like {@code public FileScanner(FIle TargetPackage)}.
     *
     * @param targetPath target package or file path.
     */
    public FileScanner(String targetPath) {
        if (null == targetPath || targetPath.length() == 0) {
            this.targetFile = null;
        } else {
            File targetFile = new File(targetPath);
            if (targetFile.exists()) {
                this.targetFile = targetFile.isDirectory() ? targetFile : targetFile.getParentFile();
            }
        }
    }

    /**
     * scan the target file from the construction. The filters will block all types
     * of files, such as directories and files.
     * <p>
     * For all filter in filters, the logical operation is {@code OR}, so if at least
     * one filter can access the file, the file will be access. If the program need
     * the logical operation is {@code AND}, it need create the new filer from the
     * FileScannerFilterInterface to make all filter check the file for result by
     * {@code AND}
     *
     * @param filters the filters to block files.
     * @return the target file's all son files.
     */
    public List<String> doScan(FileScannerFilterInterface... filters) {
        List<String> r = new ArrayList<>();
        if (targetFile == null) {
            return r;
        }

        if (filters == null || filters.length == 0) {
            filters = new FileScannerFilterInterface[1];
            filters[0] = (file) -> true;
        }

        LinkedList<File> files = new LinkedList<>();
        files.addLast(targetFile);
        while (!files.isEmpty()) {
            File dir = files.poll();
            File[] sons = dir.listFiles();
            if (sons == null) {
                continue;
            }
            for (File file : sons) {
                for (FileScannerFilterInterface fsfi : filters) {
                    if (fsfi.canAccess(file)) {
                        if (file.isDirectory()) {
                            files.addLast(file);
                        } else {
                            r.add(file.getAbsolutePath());
                        }

                        break;
                    }
                }
            }
        }
        return r;
    }
}
