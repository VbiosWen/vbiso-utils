package com.vbiso.utils;

import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

/**
 * @Author: wenliujie
 * @Description:
 * @Date: Created in 上午11:54 2018/10/25
 * @Modified By:
 */
public class FileUtil {


  public static byte[] readByteInputStream(InputStream inputStream) throws IOException {
    ByteArrayOutputStream baos = new ByteArrayOutputStream();
    byte[] bytes = new byte[1024];
    int len = 0;
    while ((len = inputStream.read(bytes)) != -1) {
      baos.write(bytes, 0, len);
    }
    return baos.toByteArray();
  }

  public static void writeByteToFile(byte[] bytes, Path path) throws IOException {
    FileOutputStream fileOutputStream = new FileOutputStream(path.toFile());
    fileOutputStream.write(bytes);
  }

  public static void readAndWriteToFile(InputStream inputStream, Path path)
      throws IOException {
    writeByteToFile(readByteInputStream(inputStream), path);
  }

  public static Path getLocalFile(String localPath, String fileName) {
    return Paths.get(localPath, fileName);
  }

  public static List<String> getFileStringLines(InputStream inputStream) throws IOException {
    BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream,
        StandardCharsets.UTF_8));
    List<String> list = new ArrayList<>(1000000);
    String line = null;
    for (line = reader.readLine(); line != null; ) {
      list.add(line);
    }
    return list;
  }

}
