package com.love.test;

import java.math.BigDecimal;
import java.math.RoundingMode;

/**
 * 应用模块名称<p>
 * 代码描述<p>
 * Copyright: Copyright (C) 2018 XXX, Inc. All rights reserved. <p>
 * Company: XX科技有限公司<p>
 *
 * @author user
 * @since 2018/12/14 9:57
 */

public class A {

    private final static int CAPACITY = 100 * 3600;


    public static void main(String[] args) {

        System.out.println("cap_2_521-batGrp-1".indexOf("cap_" + 2));
        System.out.println(divide(1000, CAPACITY));


    }

    private static Double divide(int a, int b) {
        BigDecimal decimal1 = new BigDecimal(a);
        BigDecimal decimal2 = new BigDecimal(b);
        return decimal1.divide(decimal2, 2, RoundingMode.HALF_UP).abs().doubleValue();
    }

}
