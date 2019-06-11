package com.vbiso.concurent.nlp.baidu;

import com.baidu.aip.nlp.AipNlp;
import org.json.JSONObject;

/**
 * @Author: wenliujie
 * @Description:
 * @Date: Created in 2:55 PM 2019/4/10
 * @Modified By:
 */
public class Client {

  private static final String APP_ID="15982513";

  private static final String APP_KEY="lPnt4nwHkgNldHeG7bL5bDMX";

  private static final String SECRET_KEY="fkNWvMa7Eym7VOu2tLzFZU1bV8fiBCeG";



  public static void main(String[] args){
    AipNlp client = new AipNlp(APP_ID,APP_KEY,SECRET_KEY);
    client.setConnectionTimeoutInMillis(2000);
    client.setSocketTimeoutInMillis(60000);
    String text = "维客智能客服,我们拥有最全面,最完善的自然语言处理能力";
    JSONObject lexer = client.lexer(text, null);
    System.out.println(lexer.toString(2));
  }
}
