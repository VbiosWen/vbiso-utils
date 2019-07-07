package client;

import com.alibaba.fastjson.JSONObject;
import com.vbiso.utils.FileUtil;
import com.vbiso.utils.HttpClientUtils;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Path;
import java.util.List;
import org.assertj.core.util.Lists;
import org.junit.Test;

/**
 * @Author: wenliujie
 * @Description:
 * @Date: Created in 16:59 2019-07-01
 * @Modified By:
 */
public class HttpClientTest {


  @Test
  public void testCreateYpUser() throws IOException {
    List<Long> idList = Lists.newArrayList();
    for(int i = 0 ;i < 100;i++) {
      JSONObject jsonObject = new JSONObject();
      jsonObject.put("marketUser", Boolean.TRUE);
      jsonObject.put("nick", "yp-wlj-test" + i);
      jsonObject.put("parentUserId",890000500020216259L);
      try {
        String post = HttpClientUtils
            .post("http://115.159.115.175:8026/sms-user-service/user-model-sync/createYpSubUser",
                jsonObject.toJSONString());
        JSONObject jsonObject1 = JSONObject.parseObject(post);
        Long userId = jsonObject1.getJSONObject("data").getLong("userId");
        idList.add(userId);
      } catch (IOException e) {
        e.printStackTrace();
      }
    }
    writeFile(idList);
  }

  private void writeFile(List<Long> idList) throws IOException {
    Path localFile = FileUtil.getLocalFile("/Users/vbisowen", "users.txt");
    BufferedWriter writer = new BufferedWriter(new FileWriter(localFile.toFile()));
    for(Long id : idList){
      writer.write(String.valueOf(id));
      writer.newLine();
    }
    writer.flush();
    writer.close();
  }

  @Test
  public void test(){
    byte by = (byte) 129;
    System.out.println(by);
  }


  @Test
  public void testReadFile() throws IOException {
    Path localFile = FileUtil.getLocalFile("/Users/vbisowen/Desktop", "tmp_sms_template.csv");
    BufferedReader bufferedReader = new BufferedReader(new FileReader(localFile.toFile()));
    while (bufferedReader.read() > 0){
      String s = bufferedReader.readLine();
      System.out.println(s);
    }
  }

}
