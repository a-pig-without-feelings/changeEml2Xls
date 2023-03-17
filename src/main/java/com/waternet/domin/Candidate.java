package com.waternet.domin;

import com.waternet.annotation.ExcelTitle;
import com.waternet.annotation.Order;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Candidate {

    /**
     * id序号
     */
    @ExcelTitle("序号")
    @Order(1)
    private Integer id;


    /**
     * 姓名
     */
    @ExcelTitle("姓名")
    @Order(2)
    private String name;

    /**
     * 联系电话
     */
    @ExcelTitle("联系电话")
    @Order(3)
    private String contactTel;

    /**
     * 联系邮箱
     */
    @ExcelTitle("联系邮箱")
    @Order(4)
    private String contactEmail;

    /**
     * 性别
     */
    @ExcelTitle("性别")
    @Order(5)
    private String gender;

    /**
     * 年龄
     */
    @ExcelTitle("年龄")
    @Order(6)
    private String age;

    /**
     * 民族
     */
    @ExcelTitle("民族")
    @Order(7)
    private String nation;

    /**
     * 工作年限
     */
    @ExcelTitle("工作年限")
    @Order(8)
    private String workYear;

    /**
     * 户籍
     */
    @ExcelTitle("户籍")
    @Order(9)
    private String censusRegister;

    /**
     * 现居地
     */
    @ExcelTitle("现居地")
    @Order(10)
    private String currentResidence;

    /**
     * 求职意向
     */
    @ExcelTitle("求职意向")
    @Order(11)
    private String expectation;

    /**
     * 工作经历
     */
    @ExcelTitle("工作经历")
    @Order(12)
    private String workExperience;

    /**
     * 培训经历
     */
    @ExcelTitle("培训经历")
    @Order(13)
    private String trainingExperience;

    /**
     * 教育经历
     */
    @ExcelTitle("教育经历")
    @Order(14)
    private String educationBackground;

    /**
     * 技能证书
     */
    @ExcelTitle("技能证书")
    @Order(15)
    private String skillsCertificate;

}
