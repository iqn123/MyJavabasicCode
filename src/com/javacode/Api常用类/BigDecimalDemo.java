package com.javacode.Api常用类;

import java.math.BigDecimal;
import java.math.RoundingMode;

/**
 * float与double 在运算的时候，很容易丢失精度，所以提供了BigDecimal
 */
public class BigDecimalDemo {
    // 推送git
    private String test;

    public static void main(String[] args) {

        // 精度丢失的例子
        System.out.println(0.2 + 0.1);
        System.out.println(0.3 - 0.1);
        System.out.println(0.2 * 0.1);
        System.out.println(0.3 / 0.1);
        // 原因：计算机是二进制 没办法精确表示浮点数 所以需要使用BigDecimal

        // 一些常用的方法,它有自己的构造方法
        BigDecimal bigDecimal =  new BigDecimal(2);
        BigDecimal bDouble =  new BigDecimal(2.3);
        BigDecimal bString =  new BigDecimal("2.3"); //  建议使用String 构造方法
        System.out.println("bigDecimal=" + bigDecimal);
        System.out.println("bDouble=" + bDouble);
        System.out.println("bString=" + bString);

        // 必须传入Double作为构造方法的解决方法
        BigDecimal bDouble1 =  BigDecimal.valueOf(2.3);
        BigDecimal bDouble2 =  new BigDecimal(Double.toString(2.3));
        System.out.println("bDouble1="+bDouble1);
        System.out.println("bDouble2="+bDouble2);

        // BigDecimal 的加减乘除
        BigDecimal a = new BigDecimal("4.5");
        BigDecimal b = new BigDecimal("1.5");

        System.out.println("a + b ="+a.add(b));
        System.out.println("a - b ="+a.subtract(b));
        System.out.println("a * b ="+a.multiply(b));
        System.out.println("a / b ="+a.divide(b));

        // 除法不能整除的情况下会报错,这时需要进行除法的构造传入
        BigDecimal c = new BigDecimal("1.3");
//        System.out.println("a / c ="+a.divide(c));
        System.out.println("舍入之后的a / c ="+a.divide(c,3,RoundingMode.HALF_UP));
        /**
         * 构造除法的一些选择
         * public BigDecimal divide(BigDecimal divisor, int scale, int roundingMode) 参数依次为除数，精度，舍入模式
         *
         * 舍入模式如下：
         * ROUND_CEILING    //向正无穷方向舍入
         *
         * ROUND_DOWN    //向零方向舍入
         *
         * ROUND_FLOOR    //向负无穷方向舍入
         *
         * ROUND_HALF_DOWN    //向（距离）最近的一边舍入，除非两边（的距离）是相等,如果是这样，向下舍入, 例如1.55 保留一位小数结果为1.5
         *
         * ROUND_HALF_EVEN    //向（距离）最近的一边舍入，除非两边（的距离）是相等,如果是这样，如果保留位数是奇数，使用ROUND_HALF_UP，如果是偶数，使用ROUND_HALF_DOWN
         *
         * ROUND_HALF_UP    //向（距离）最近的一边舍入，除非两边（的距离）是相等,如果是这样，向上舍入, 1.55保留一位小数结果为1.6
         *
         * ROUND_UNNECESSARY    //计算结果是精确的，不需要舍入模式
         *
         * ROUND_UP    //向远离0的方向舍入
         */
        BigDecimal f = new BigDecimal("4.5635");
        f = f.setScale(3, RoundingMode.HALF_UP);
        System.out.println("f ="+f);

        // 在进行的每步操作当中，都是会产生新的对象，所以原来的值并不会受到操作而改变
        a.add(b);
        System.out.println("a并没有被改变"+a);

        /**
         * 总结
         * 1)商业计算使用BigDecimal。
         *
         * (2)尽量使用参数类型为String的构造函数。
         *
         * (3) BigDecimal都是不可变的（immutable）的，在进行每一步运算时，都会产生一个新的对象，所以在做加减乘除运算时千万要保存操作后的值。
         *
         * (4)我们往往容易忽略JDK底层的一些实现细节，导致出现错误，需要多加注意。
         */
    }
}
