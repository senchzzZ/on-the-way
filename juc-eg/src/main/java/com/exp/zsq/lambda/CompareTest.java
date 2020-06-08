package com.exp.zsq.lambda;

import com.exp.zsq.domain.CompareBean;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * Created by zhaoshengqi on 2018/3/9.
 */
public class CompareTest {

    public static void main(String[] args) {
        Long a = 20l;
        Long b = 10l;
        List<Long> list = new ArrayList<>(Arrays.asList(a,b));
        list.sort(Comparator.comparingLong(Long::longValue));

        System.out.println(list);

        CompareBean b1 = new CompareBean();
        CompareBean b2 = new CompareBean();
        CompareBean b3 = new CompareBean();

        b1.setBeanV(13l);
        b2.setBeanV(3l);
        b3.setBeanV(25l);

        List<CompareBean> beans = new ArrayList<>(Arrays.asList(b1,b2,b3));

        beans.sort(Comparator.comparingLong(CompareBean::getBeanV).reversed());

        System.out.println(beans);

    }
}
