package utils;

import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.List;

public class FileHelper {

    //read file
    // list of stringgs returns
//    public static List<String> readFile(String path){
//
//        return null;
//    }

    public static List<String> readValidFile(File VALID_USER_FILE) throws IOException {
        return FileUtils.readLines(VALID_USER_FILE, StandardCharsets.UTF_8);
    }
    public static List<String> readInValidFile(File INVALID_USER_FILE) throws IOException {
        return FileUtils.readLines(INVALID_USER_FILE, StandardCharsets.UTF_8);
    }

    public static void writeToFile(List<String> lines, File aFile) throws IOException {
        FileUtils.writeLines(aFile,lines);
    }
}
