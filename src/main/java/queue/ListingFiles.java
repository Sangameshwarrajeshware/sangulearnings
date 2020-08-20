package queue;

import java.io.File;

public class ListingFiles {
  private Queue<String> filesQueue;

  public ListingFiles() {
    filesQueue = new Queue<>();
  }

  private void listFiles(File file, int depth) {
    if (!file.exists()) {
      return;
    }

    addFileToQueue(file, depth);
    File[] files = file.listFiles();
    if (files != null) {
      for (File fileItem : files) {
        if (fileItem.isFile()) {
          addFileToQueue(fileItem, depth);
        } else if (fileItem.isDirectory()) {
          listFiles(fileItem, depth);
        }
      }
    }
  }

  private void addFileToQueue(File file, int depth) {
    StringBuilder stringBuilder = new StringBuilder();
    for (int i = 0; i < depth; i++) {
      stringBuilder.append("    ");
    }
    stringBuilder.append(file.getName());
    filesQueue.enqueue(stringBuilder.toString());
  }

  public static void main(String[] args) {
    File folder = new File("/Users/sangameshwarr/Documents/MYDOCS");

    ListingFiles listFiles = new ListingFiles();
    listFiles.listFiles(folder, 0);

    for (String fileName : listFiles.filesQueue) {
      System.out.println(fileName);
    }
  }
}
