package com.vbiso;

import java.time.Instant;
import java.util.Random;
import org.junit.Test;

/**
 * @Author: wenliujie
 * @Description:
 * @Date: Created in 9:33 PM 2018/11/30
 * @Modified By:
 */
public class Digest {

  @Test
  public void printOut() {
    output(1324);
  }

  private void output(int number) {
    if (number >= 10) {
      output(number / 10);
    }
    System.out.print(number % 10);
  }

  private static <T> T any(T t) {
    return t;
  }

  @Test
  public void testGeneric() {
    GenericMemoryCell[] arr1 = new GenericMemoryCell[10];
    GenericMemoryCell<Double> cell = new GenericMemoryCell<>();
    cell.write(4.5);
    Object[] arr2 = arr1;
    arr2[0] = cell;
    GenericMemoryCell<String> genericMemoryCell = (GenericMemoryCell<String>) arr1[0];
    Object read = genericMemoryCell.read();
    System.out.println(read);
  }

  @Test
  public void selectProblem() {

    int[] array = new int[10000];
    for (int i = 0; i < 10000; i++) {
      array[i] = new Random().nextInt(10000);
    }
    Instant now = Instant.now();
    int[] kArr = buildArray(array, 5000);
    int select = select(kArr, array, 5000);
    sort(array);
    System.out.println(select);
    System.out.println(Instant.now().toEpochMilli() - now.toEpochMilli());
  }

  private int select(int[] kArr, int[] array, int k) {
    int[] nextArr = new int[array.length - k];
    System.arraycopy(array, k, nextArr, 0, array.length - k);
    for (int i = 0; i < nextArr.length; i++) {
      if (nextArr[i] > kArr[k - 1]) {
        kArr[k - 1] = nextArr[i];
        sort(kArr);
      }
    }
    return kArr[k - 1];
  }


  private int[] buildArray(int[] array, int k) {
    int[] kArr = new int[k];
    System.arraycopy(array, 0, kArr, 0, k);
    sort(kArr);
    return kArr;
  }

  private void sort(int[] kArr) {
    for (int i = 0; i < kArr.length - 1; i++) {
      for (int j = i + 1; j < kArr.length; j++) {
        if (kArr[j] > kArr[i]) {
          int temp = kArr[i];
          kArr[i] = kArr[j];
          kArr[j] = temp;
        }
      }
    }
  }


  @Test
  public void printDouble() {
    double number = 3.1415926788787676756576774564564654653434236768678686676866767855675656564654;
    preSolve(number, 20);
  }

  private void preSolve(double number, int index) {
    int num = (int) number;
    double doubleVal = number - num;
    if (doubleVal < 0) {
      putChar('-');
      num = -num;
      doubleVal = -doubleVal;
    }
    printOutput(num);
    putChar('.');
    for (int i = 0; i < index; ++i) {
      doubleVal *= 10;
      num = (int) doubleVal;
      doubleVal = doubleVal - num;
      if (i == index - 1) {
        doubleVal = doubleVal * 10;
        int temp = (int) doubleVal;
        if (temp > 4) {
          num++;
        }
      }
      printOutput(num);
    }
  }

  private void printOutput(int num) {
    if (num >= 10) {
      printOutput(num / 10);
    }
    printDigit(num % 10);
  }

  private void printDigit(int number) {
    System.out.print(number);
  }

  public void putChar(char ch) {
    System.out.print(ch);
  }

  @Test
  public void testBinary() {
    System.out.println(Math.pow(2,10000));
    int number = divideBinary((int) Math.pow(2,1000)-1);
    System.out.println(divideBinary(1024));
    System.out.println(number);
  }

  private int divideBinary(int number) {
    if (number == 0) {
      return 0;
    }
    if (number == 1) {
      return 1;
    }
    if (number % 2 == 0) {
      return divideBinary(number / 2);
    } else {
      return divideBinary(number / 2) + 1;
    }
  }

//  @Test
//  public void testPermutation(){
//    String str="abcdefg";
//    permute(str);
//  }

//  private void permute(String str) {
//    permute(str,0,4);
//  }

//  private void permute(String str,int low,int len){
//    if()
//  }
}
