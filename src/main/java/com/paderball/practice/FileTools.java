package com.paderball.practice;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class FileTools {

  public static List<File> listAllFiles(File file) {
    if (file == null || !file.exists()) {
      return null;
    }

    List<File> allFiles = new ArrayList<>();
    allFiles.add(file);

    if (file.isDirectory()) {
      listAllFilesHelper(file, allFiles);
    }

    return allFiles;
  }

  private static void listAllFilesHelper(File directory, List<File> allFiles) {
    File[] dirFiles = directory.listFiles();

    for (File file : dirFiles) {
      allFiles.add(file);

      if (file.isDirectory()) {
        listAllFilesHelper(file, allFiles);
      }
    }
  }

  public static void main(String [] args) {
    for (String path : args) {
      var allFiles = listAllFiles(new File(path));

      for (File file : allFiles) {
        if (file.isDirectory()) {
          System.out.println("\n====================================================================================");
          System.out.println(file.getAbsolutePath());
          System.out.println("====================================================================================");

        } else {
          System.out.println(file.getAbsolutePath());
        }

      }
    }
  }
}