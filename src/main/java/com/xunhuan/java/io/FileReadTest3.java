package com.xunhuan.java.io;

import com.alibaba.fastjson.JSON;
import com.google.common.collect.Lists;
import com.xunhuan.java.io.model.Policy;
import com.xunhuan.java.io.model.PolicyModel;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

/**
 * @author tianh
 * @description:
 * @date 2022/2/9 2:08 下午
 */
public class FileReadTest3 {

    public static void main(String[] args) {
        try {

            FileReader fr = new FileReader("src/main/resources/policyText");
            BufferedReader bf = new BufferedReader(fr);
            String str;
            PolicyModel policyModel = new PolicyModel();
            List<Policy> policyList = Lists.newArrayList();
            // 按行读取字符串
            while ((str = bf.readLine()) != null) {
                String[] splitText = str.split(",");
                Policy policy = new Policy();
                //for (int i = 0; i < splitText.length; i++) {
                //    if(){
                //    }
                //
                //}
                if("策略集".equals(splitText[0])){
                    policy.setType("RULE");
                }else if("决策流".equals(splitText[0])){
                    policy.setType("D_FLOW");
                }else {
                    throw new RuntimeException("类型异常");
                }
                policy.setArtifactId(splitText[1]);
                policy.setGroupId(splitText[2]);
                policy.setVersion(splitText[3]);
                policyList.add(policy);
            }
            policyModel.setMigrationMiniRequestList(policyList);
            System.out.println(JSON.toJSON(policyModel));
            bf.close();
            fr.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
