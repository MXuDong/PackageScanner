package io.github.mxudong.ps;

import java.io.File;
import java.util.ArrayList;
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
    private File targetPackage;

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
        // the targetPackage is not null and the file is exists
        if (targetDirectory != null && targetDirectory.exists()) {
            // different type in directory and file.
            this.targetPackage = targetDirectory.isDirectory() ? targetDirectory : targetDirectory.getParentFile();
        } else {
            this.targetPackage = null;
        }
    }

    /**
     * The FileScanner construction, if the target path is null or length == 0, the
     * inner method will do nothing, such as doScan.
     *
     * If the file is not directory, it will set the target file's parent file
     * directory. For this part like {@code public FileScanner(FIle TargetPackage)}.
     *
     * @param targetPath target package or file path.
     */
    public FileScanner(String targetPath) {
        if (null == targetPath || targetPath.length() == 0) {
            this.targetPackage = null;
        } else {
            File targetFile = new File(targetPath);
            if(targetFile.exists()){
                this.targetPackage = targetFile.isDirectory() ? targetFile : targetFile.getParentFile();
            }
        }
    }
}
