package com.example.study.xxx;

import com.google.common.collect.Lists;

import java.util.List;

public class InnerClassTest {

    public static class A{
        public String str;

        public A(String str) {
            this.str = str;
        }

        public String getStr() {
            return str;
        }

        public void setStr(String str) {
            this.str = str;
        }

        @Override
        public String toString() {
            return "A{" +
                    "str='" + str + '\'' +
                    '}';
        }
    }

    public static void main(String[] args) {
        List<A> list = Lists.newArrayList();
        list.add(new InnerClassTest.A("1"));
        list.add(new InnerClassTest.A("2"));
        list.add(new InnerClassTest.A("3"));

        System.out.println(list);
    }
}
