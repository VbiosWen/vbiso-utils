package com.vbiso;

import com.vbiso.utils.FileUtil;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import org.junit.Test;

/**
 * @Author: wenliujie
 * @Description:
 * @Date: Created in 2:30 PM 2018/12/13
 * @Modified By:
 */
public class FileTest {

  private static final String file_name="/Users/vbisowen/Desktop/test.txt";

  @Test
  public void testFileReader() throws IOException {
    Path path = Paths.get(file_name);
    FileInputStream fileInputStream = new FileInputStream(path.toFile());
    List<String> fileStringLines = FileUtil.getFileStringLines(fileInputStream);
  }

  @Test
  public void testFile(){
    String property = System.getProperty("java.io.tmpdir");
    System.out.println(StandardCharsets.UTF_8.name());
    System.out.println(property);
  }

  @Test
  public void testDouble(){
    System.out.println(Math.ceil(5/2.0));
  }

}
