package com.vbiso.utils;

import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.OffsetDateTime;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;

/**
 * @Author: wenliujie
 * @Description:
 * @Date: Created in 上午12:14 2018/10/15
 * @Modified By:
 */
public class DateUtil {

  private static final ZoneOffset zoneOffset=ZoneOffset.of("+8");


  public static String format(long timestamp, String pattern) {
    return format(Instant.ofEpochMilli(timestamp), pattern);
  }

  public static String format(Instant instant, String pattern) {
    DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern(pattern);
    return LocalDateTime.ofInstant(instant, ZoneId.systemDefault()).format(dateTimeFormatter);
  }

  public static long getDateStartTime(LocalDate localDate){
    LocalDateTime localDateTime = LocalDateTime.of(localDate, LocalTime.MIN);
    return localDateTime.toInstant(zoneOffset).toEpochMilli();
  }

  public static long getDateEndTime(LocalDate localDate){
    LocalDateTime localDateTime=LocalDateTime.of(localDate,LocalTime.MAX);
    return localDateTime.toInstant(zoneOffset).toEpochMilli();
  }

  public static long getDateStartTime(){
   return getDateStartTime(LocalDate.now());
  }


  public static void main(String[] args){
    System.out.println(LocalDateTime.MIN);
    long dateStartTime = getDateStartTime();
    System.out.println(LocalDateTime.ofInstant(Instant.ofEpochMilli(dateStartTime),ZoneId.systemDefault()));
    System.out.println(LocalDateTime.ofInstant(Instant.ofEpochMilli(getDateEndTime(LocalDate.now())),ZoneId.systemDefault()));
  }

}
