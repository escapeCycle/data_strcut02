package com.xunhuan.java.delayqueue.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class WithholdContent {

    private long withholdDetailId; // 代扣记录详情id
    private String preProcessReqNo; //预处理流水号
}
