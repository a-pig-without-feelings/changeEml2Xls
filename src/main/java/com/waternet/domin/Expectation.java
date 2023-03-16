package com.waternet.domin;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Expectation {

    /**
     * 期望工作地区：
     */
    private String workPlace;

    /**
     * 期望从事职位：
     */
    private String occupation;

    /**
     * 期望月薪范围
     */
    private String monthlyPay;

    /**
     * 当前求职状态
     */
    private String currentStatue;

    /**
     * 期望工作性质
     */
    private String workNature;

}
