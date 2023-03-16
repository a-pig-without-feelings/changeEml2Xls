package com.waternet.domin;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Candidate {
    /**
     * 姓名
     */
    private String name;

    /**
     * 联系电话
     */
    private String contactTel;

    /**
     * 联系邮箱
     */
    private String contactEmail;

    /**
     * 简历照片
     */
    private Integer photo;

    /**
     * 性别
     */
    private String gender;

    /**
     * 年龄
     */
    private String age;

    /**
     * 民族
     */
    private String nation;

    /**
     * 工作年限
     */
    private String workYear;

    /**
     * 户籍
     */
    private String censusRegister;

    /**
     * 现居地
     */
    private String currentResidence;

    /**
     * 学历
     */
    private String qualification;

    /**
     * 毕业院校
     */
    private String graduateSchool;

    /**
     * 专业
     */
    private String profession;

    /**
     * 求职意向
     */
    private Expectation expectation;

    /**
     * 工作经历
     */
    private String workExperience;

    /**
     * 培训经历
     */
    private String trainingExperience;

    /**
     * 教育经历
     */
    private String educationBackground;

    /**
     * 技能证书
     */
    private String skillsCertificate;

}
