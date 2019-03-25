package com.vbiso.kafka;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.stream.Collectors;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.clients.producer.RecordMetadata;
import org.junit.Test;

/**
 * @Author: wenliujie
 * @Description:
 * @Date: Created in 2:40 PM 2019/3/13
 * @Modified By:
 */
public class KafkaTestConnection {


  @Test
  public void testConnection() {
    Properties kafkaPros = new Properties();
    kafkaPros.put("bootstrap.servers", "127.0.0.1:9091,127.0.0.1:9092,127.0.0.1:9093");
    kafkaPros.put("key.serializer", "org.apache.kafka.common.serialization.StringSerializer");
    kafkaPros.put("value.serializer", "org.apache.kafka.common.serialization.StringSerializer");

    KafkaProducer<String, String> producer = new KafkaProducer<>(kafkaPros);

    ProducerRecord<String, String> producerRecord = new ProducerRecord<>("goodJob", "haha",
        "hello! welcome to kafka world!");

    Future<RecordMetadata> send = producer.send(producerRecord);
    try {
      System.out.println(send.get());
    } catch (InterruptedException e) {
      e.printStackTrace();
    } catch (ExecutionException e) {
      e.printStackTrace();
    }
  }

  @Test
  public void testContains() {
    String str = "郑州 上海 武汉 郑州 上海";
    List<String> collect = Arrays.stream(str.split(" ")).collect(Collectors.toList());
    Map<String, Character> keyValue = new HashMap<>();
    char sign = 97;
    for (String ss : collect) {
      if (keyValue.containsKey(ss)) {
      } else {
        keyValue.put(ss, sign);
        sign++;
      }
    }
    List<Character> contains = new ArrayList<>();
    collect.forEach(ss -> contains.add(keyValue.get(ss)));
    contains.forEach(System.out::print);


  }

  @Test
  public void testKMP() {

  }

}
