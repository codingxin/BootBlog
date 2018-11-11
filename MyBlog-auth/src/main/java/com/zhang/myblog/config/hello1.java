package com.zhang.myblog.config;

import java.util.Scanner;

/**
 * @author created by Zhangdazhuang
 * @version v.0.1
 * @date 2018/11/5
 * @备注 测试
 **/




public class hello1 {


    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNextInt()) {//注意while处理多个case
            int a = in.nextInt();
            int b = in.nextInt();
            System.out.println(a + b);
        }
    }
}
