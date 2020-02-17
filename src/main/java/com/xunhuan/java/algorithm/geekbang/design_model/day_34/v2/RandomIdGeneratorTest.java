package com.xunhuan.java.algorithm.geekbang.design_model.day_34.v2;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

public class RandomIdGeneratorTest {

    @Test
    public void testGetLastSubstrSplittedByDot() {

        RandomIdGenerator randomIdGenerator = new RandomIdGenerator();
        String actualStr = randomIdGenerator.getLastSubstrSplittedByDot("field1.field2.field3");
        Assert.assertEquals("field3", actualStr);


        actualStr = randomIdGenerator.getLastSubstrSplittedByDot("field1");
        Assert.assertEquals("field1", actualStr);

        actualStr = randomIdGenerator.getLastSubstrSplittedByDot("field&field,field");
        Assert.assertEquals("field&field,field", actualStr);

    }

    @Test
    public void testGetLastSubstrSplittedByDot_null() {

        RandomIdGenerator randomIdGenerator = new RandomIdGenerator();
        String actualStr = randomIdGenerator.getLastSubstrSplittedByDot(null);
        Assert.assertNull(actualStr);

        actualStr = randomIdGenerator.getLastSubstrSplittedByDot("");
        Assert.assertEquals("", actualStr);
    }


    @Test
    public void testGenerateRandomAlphameric() {
        RandomIdGenerator randomIdGenerator = new RandomIdGenerator();
        String randomStr = randomIdGenerator.generateRandomAlphameric(8);
        Assert.assertEquals(8, randomStr.length());

        Assert.assertNotNull(randomStr);

        char[] chars = randomStr.toCharArray();

        for (char ch : chars) {
            Assert.assertTrue((ch >= 0 && ch <= 9) || (ch >= 'a' && ch <= 'z') || (ch >= 'A' && ch <= 'Z'));
        }

    }
}