package com.xunhuan.java.algorithm.lru;

import java.util.HashMap;
import java.util.Map;

/**
 * 数组实现lru
 *
 * @author tianhuan
 * @date 2019-03-30 19:10
 **/
public class LruBaseArray<T> {

    public static final int BASE_CAPACITY = (1 << 3);

    private int capacity;

    private int count;

    private T[] value;

    private Map<T, Integer> holder;

    public LruBaseArray() {
        this(BASE_CAPACITY);
    }

    public LruBaseArray(int capacity) {
        this.capacity = capacity;
        this.count = 0;
        this.value = (T[]) new Object[capacity];
        this.holder = new HashMap<>(capacity);
    }

    /**
     * 访问数组中某个值,如果有则取到值,并更新此值到数组首部
     * 如果没有取到值,则缓存此值到数组中
     */
    public void offer(T t) {
        if (t == null) {
            throw new IllegalArgumentException("不支持null类型");
        }
        Integer index = holder.get(t);
        if (index == null) {
            if (isFull()) {
                removeAndCache(t);
            } else {
                cache(t, count);
            }
        } else {
            update(index);
        }
    }

    /**
     * 缓存中有指定值,更新位置
     *
     * @param index
     */
    public void update(int index) {
        T target = value[index];
        /**
         * index前的整体右移,覆盖掉index
         */
        rightMove(index);
        value[0] = target;
        holder.put(target, 0);
    }

    /**
     * 缓存满的情况,踢出后,再缓存到数组头部
     *
     * @param t
     */
    public void removeAndCache(T t) {
        /**
         * 最后一位
         */
        T key = value[--count];
        holder.remove(key);
        cache(t, count);
    }

    /**
     * 缓存数据到头部
     *
     * @param t
     */
    public void cache(T t, int index) {
        rightMove(index);
        value[0] = t;
        holder.put(t, 0);
        count++;
    }

    /**
     * end 左边的数统一右移一位
     *
     * @param end
     */
    public void rightMove(int end) {
        for (int i = end - 1; i >= 0; --i) {
            value[i + 1] = value[i];
            holder.put(value[i], i + 1);
        }
    }

    public boolean isContain(T t) {
        return holder.containsKey(t);
    }

    public boolean isEmpty() {
        return count == 0;
    }

    public boolean isFull() {
        return count == capacity;
    }
}
