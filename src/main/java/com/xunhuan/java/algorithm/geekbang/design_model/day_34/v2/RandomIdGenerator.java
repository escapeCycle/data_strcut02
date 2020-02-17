package com.xunhuan.java.algorithm.geekbang.design_model.day_34.v2;

import com.google.common.annotations.VisibleForTesting;
import lombok.extern.slf4j.Slf4j;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Random;

@Slf4j
public class RandomIdGenerator implements LogTraceIdGenerator {

    @Override
    public String generate() {

        String lastfieldOfHostName = getLastfieldOfHostName();
        long currentTime = System.currentTimeMillis();
        String randomStr = generateRandomAlphameric(8);
        String id;
        id = String.format("%s-%d-%s", lastfieldOfHostName, currentTime, randomStr);
        return id;
    }


    private String getLastfieldOfHostName() {
        String substrOfHostName = null;
        try {
            String hostName = InetAddress.getLocalHost().getHostName();
            substrOfHostName = getLastSubstrSplittedByDot(hostName);
        } catch (UnknownHostException e) {
            log.warn("Failed to get the host name.", e);
        }
        return substrOfHostName;
    }

    @VisibleForTesting
    protected String getLastSubstrSplittedByDot(String hostName) {
        String[] tokens = hostName.split("\\.");
        String token = tokens[tokens.length - 1];
        return token;
    }

    @VisibleForTesting
    protected String generateRandomAlphameric(int length) {

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
