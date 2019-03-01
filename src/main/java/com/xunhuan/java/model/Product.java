package com.xunhuan.java.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.experimental.Accessors;

import java.text.SimpleDateFormat;
import java.time.Duration;
import java.time.Instant;
import java.util.*;

/**
 * @author tianhuan
 * @date 2018-10-15 22:15
 **/
@Data
@Accessors(chain = true)
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Product {
    private Long id;
    private String createTime;
    public static void main(String[] args) {
        List<Product> products = new ArrayList<>();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        for (int i = 0;i <= 3;i++){
            Random random = new Random();
            Date date = randomDate("2018-10-01","2018-10-10");
            Product product = new Product((long) random.nextInt(10),sdf.format(date));
            products.add(product);
        }

        products.forEach(System.out::println);
        Instant start = Instant.now();

        Collections.sort(products,(x,y) -> {
            if(x.getId().equals(y.getId())){
                return x.getCreateTime().compareTo(y.getCreateTime());
            }else{
                return -(x.getId().compareTo(y.getId()));
            }
        });
        Instant end = Instant.now();
        System.out.println("--------------------------------");
        System.out.println("耗費時間: "+ Duration.between(start,end).toMillis());

        products.forEach(System.out::println);

    }

    /**
     * 获取随机日期
     * @param beginDate 起始日期，格式为：yyyy-MM-dd
     * @param endDate 结束日期，格式为：yyyy-MM-dd
     * @return
     */
    private static Date randomDate(String beginDate,String endDate){
        try {
            SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
            Date start = format.parse(beginDate);
            Date end = format.parse(endDate);

            if(start.getTime() >= end.getTime()){
                return null;
            }

            long date = random(start.getTime(),end.getTime());

            return new Date(date);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    private static long random(long begin,long end){
        long rtn = begin + (long)(Math.random() * (end - begin));
        if(rtn == begin || rtn == end){
            return random(begin,end);
        }
        return rtn;
    }

}
