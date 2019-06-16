package com.vbiso.utils;

import java.time.Instant;
import java.util.List;
import java.util.Stack;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicLong;
import org.assertj.core.util.Lists;

/**
 * @Author: wenliujie
 * @Description: 短链生成策略
 * @Date: Created in 21:43 2019-06-16
 * @Modified By:
 */
public class ShortLinkUtils {

  private static final AtomicLong BASE_SHORT_URL_ID = new AtomicLong(946416180L);

  private static final char[] array = "qwertyuiopasdfghjklzxcvbnmQWERTYUIOPASDFGHJKLZXCVBNM0123456789"
      .toCharArray();


  public static synchronized long incrementShortUrlId() {
    return BASE_SHORT_URL_ID.getAndIncrement();
  }


  public static String createShortUrl(long shortUrlId) {
    Stack<Integer> shortUrlStack = new Stack<>();
    StringBuilder builder = new StringBuilder(6);
    while (shortUrlId > 0) {
      shortUrlStack.push((int) (shortUrlId % 62));
      shortUrlId /= 62;
    }
    while (!shortUrlStack.isEmpty()) {
      builder.append(array[shortUrlStack.pop()]);
    }
    return builder.toString();
  }

  public static String autoCreateShortUrl() {
    return createShortUrl(incrementShortUrlId());
  }


  public static void main(String[] args) throws InterruptedException {

    long start = Instant.now().toEpochMilli();

    int threadCount = 10;
    CountDownLatch countDownLatch = new CountDownLatch(threadCount);

    int shorturlCount = 1000;

    List<String> shortUrlList = Lists.newArrayList();


    for (int i = 0; i < threadCount; i++) {
      new Thread(new ShortUrlTask(countDownLatch,shorturlCount,shortUrlList)).start();
    }

    countDownLatch.await();

    for(String shortUrl : shortUrlList){
      System.out.println(shortUrl);
    }

    long end = Instant.now().toEpochMilli();

    System.out.println("total cost time : " + (end -start));


  }


  private static class ShortUrlTask implements Runnable {

    private final CountDownLatch countDownLatch;

    private final int shortUrlCount;

    private final List<String> shortUrlList;

    private static final Object lock = new Object();

    public ShortUrlTask(CountDownLatch countDownLatch,int shortUrlCount,List<String> shortUrlList) {
      this.countDownLatch = countDownLatch;
      this.shortUrlCount = shortUrlCount;
      this.shortUrlList = shortUrlList;
    }

    @Override
    public void run() {
      try {
        long start = Instant.now().toEpochMilli();
        List<String> shortUrlChild = Lists.newArrayList();
        for(int i = 0; i < shortUrlCount; ++i){
          String s = autoCreateShortUrl();
          shortUrlChild.add(s);
        }
        synchronized (lock){
          shortUrlList.addAll(shortUrlChild);
        }
        long end = Instant.now().toEpochMilli();
        System.out.println("时间是:" + (end -start));
      } finally {
        countDownLatch.countDown();
      }
    }
  }
}
