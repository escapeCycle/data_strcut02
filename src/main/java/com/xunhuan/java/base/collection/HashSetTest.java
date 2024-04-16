package com.xunhuan.java.base.collection;

import java.util.HashSet;

/**
 * @author tianh
 * @description:
 * @date 2021-03-24 23:39
 */
public class HashSetTest {
    public static void main(String[] args) {
        // 新建Person对象，
        Person p1 = new Person("eee", 100);
        Person p2 = new Person("eee", 100);
        Person p3 = new Person("aaa", 200);

        // 新建HashSet对象
        HashSet set = new HashSet();
        set.add(p1);
        set.add(p2);
        set.add(p3);

        // 比较p1 和 p2， 并打印它们的hashCode()
        System.out.printf("p1.equals(p2) : %s;p1==p2 : %s; p1(%d) p2(%d)\n", p1.equals(p2), p1 == p2, p1.hashCode(), p2.hashCode());
        // 打印set
        System.out.printf("set:%s\n", set);
    }

    private static class Person {
        int age;
        String name;

        public Person(String name, int age) {
            this.name = name;
            this.age = age;
        }

        public String toString() {
            return "(" + name + ", " + age + ")";
        }

        /**
         * @desc 覆盖equals方法
         */
        @Override
        public boolean equals(Object obj) {
            if (obj == null) {
                return false;
            }
            if (this == obj) {
                return true;
            }
            if (this.getClass() != obj.getClass()) {
                return false;
            }

            Person person = (Person) obj;
            return name.equals(person.name) && age == person.age;
        }
    }
}
