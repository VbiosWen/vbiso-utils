package com.vbiso.concurent.message_queue;

/**
 * @Author: wenliujie
 * @Description:
 * @Date: Created in 10:41 AM 2018/12/19
 * @Modified By:
 */
public class Activity implements Comparable<Activity> {

  private Long startTime;

  private String activityId;

  @Override
  public int compareTo(Activity o) {
    return this.startTime.compareTo(o.startTime) > 0 ? 0 : 1;
  }
}
