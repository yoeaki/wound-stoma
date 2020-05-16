package com.linkgoo.framework.utils.generation.utils;

import java.io.File;
import java.io.IOException;

public class FileUtil {
    public static File getFile(String path) {
        File file = new File(path);
        if (file.exists()) {
            if (file.isDirectory()) {
                System.out.println("File '" + file + "' exists but is a directory");
            }

            if (!file.canWrite()) {
                System.out.println("File '" + file + "' cannot be written to");
            }
        } else {
            File parent = file.getParentFile();
            if (parent != null && !parent.mkdirs() && !parent.isDirectory()) {
                System.out.println("Directory '" + parent + "' could not be created");
            }
        }
        if (!file.exists()) {
            try {
                file.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return file;
    }

    public static boolean fileExists(String path) {
        File file = new File(path);
        return file.exists()&&file.isFile();
    }
}
