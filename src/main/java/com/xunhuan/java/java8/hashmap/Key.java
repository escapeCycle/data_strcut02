package com.xunhuan.java.java8.hashmap;

/**
 * @author tianhuan
 * @date 2019-02-19 19:01
 **/
public class Key {
    private final int value;
    Key(int value) {
        this.value = value;
    }

    @Override
    public int hashCode() {
        return 0;
    }

//    @Override
//    public boolean equals(Object o) {
//        if (this == o) return true;
//        if (o == null || getClass() != o.getClass())
//            return false;
//        Key key = (Key) o;
//        return value == key.value;
//    }
}
