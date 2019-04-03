package com.vbiso.hanlp;

import com.hankcs.hanlp.seg.NShort.NShortSegment;
import com.hankcs.hanlp.seg.Segment;

/**
 * @Author: wenliujie
 * @Description:
 * @Date: Created in 4:08 PM 2019/3/25
 * @Modified By:
 */
public class ICTCLASSegTest {

  public static void main(String[] args) {
    Segment nShortSegment = new NShortSegment().enableCustomDictionary(false)
        .enablePlaceRecognize(true).enableOrganizationRecognize(true);

    String[] testCase = new String[]{"张强在铁岭对王晓红说的确实在理."};

    System.out.println("N-最短分词:" + nShortSegment.seg(testCase[0]));
  }

}
