package com.xunhuan.java.algorithm.geekbang.design_model.day_34.v2;

import com.google.common.annotations.VisibleForTesting;
import com.xunhuan.java.algorithm.geekbang.design_model.day_34.v2.exception.IdGenerationFailureException;
import lombok.extern.slf4j.Slf4j;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Random;

@Slf4j
public class RandomIdGenerator implements LogTraceIdGenerator {

    @Override
    public String generate() throws IdGenerationFailureException {
        String lastfieldOfHostName = null;
        try {
            getLastfieldOfHostName();
        } catch (UnknownHostException e) {
            throw new IdGenerationFailureException("hostName is Empty");
        }
//        if(lastfieldOfHostName == null || lastfieldOfHostName.isEmpty()){
//            throw new IdGenerationFailureException("hostName is Empty");
//        }
        long currentTime = System.currentTimeMillis();
        String randomStr = generateRandomAlphameric(8);
        String id;
        id = String.format("%s-%d-%s", lastfieldOfHostName, currentTime, randomStr);
        return id;
    }


    private String getLastfieldOfHostName() throws UnknownHostException {
        String substrOfHostName = null;
//        try {
        String hostName = InetAddress.getLocalHost().getHostName();
        if (hostName == null || hostName.isEmpty()) {
            throw new UnknownHostException("hostName is empty");
        }
        substrOfHostName = getLastSubstrSplittedByDot(hostName);
//        } catch (UnknownHostException e) {
//            log.warn("Failed to get the host name.", e);
//        }
        return substrOfHostName;
    }

    @VisibleForTesting
    protected String getLastSubstrSplittedByDot(String hostName) {
        if (hostName == null || hostName.isEmpty()) {
            throw new IllegalArgumentException("param is empty exception");
        }
        String[] tokens = hostName.split("\\.");
        String token = tokens[tokens.length - 1];
        return token;
    }

    @VisibleForTesting
    protected String generateRandomAlphameric(int length) {
        if(length <= 0){
            throw new IllegalArgumentException("length can't <= 0 ");
        }
        char[] randoms = new char[length];
        int count = 0;
        Random random = new Random();
        while (count < length) {
            int maxAscii = 'z';

            int randomAscii = random.nextInt(maxAscii);

            boolean isDigit = randomAscii >= 0 && randomAscii <= 9;
            boolean isUppercase = randomAscii >= 'A' && randomAscii <= 'Z';
            boolean isLowercase = randomAscii >= 'a' && randomAscii <= 'z';

            if (isDigit || isUppercase || isLowercase) {
                randoms[count] = (char) randomAscii;
                ++count;
            }
        }
        return new String(randoms);
    }

}
