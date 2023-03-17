package com.waternet.utils;

import com.waternet.domin.Candidate;
import com.waternet.domin.Expectation;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import java.io.*;
import java.util.ArrayList;
import java.util.Calendar;

/**
 * 通过文件方式提取解析html文件
 */
public class FileUtil {
    public static void main(String[] args) throws IOException {
        ArrayList<Candidate> candidates = new ArrayList<>();

        Candidate candidate = new Candidate();

        //01 创建文件对象，指定解析文件路径
        File file = new File("D:\\SoftwareDevelopment\\eml\\Outs\\应聘_投资管理岗_经理助理_运营管培生_成都人才网简历\\body_0(0).html");
        Document parsedDoc = Jsoup.parse(file, "GBK");

        //02 读取EML简历各个字段，存储至对象中
        /*------------------------------------------------------------------------------------------------------------*/
        Elements name = parsedDoc.select("#Form1 > .JlDiv >.JlJbxxDiv >.JlLxdiv >.Name");
        System.out.println(":::姓名：" + name.text());
        candidate.setName(name.text());

        Elements phone = parsedDoc.select("#Form1 > .JlDiv >.JlJbxxDiv >.JlLxdiv >.Contact >ul >li.First");
        System.out.println(":::电话：" + phone.text().substring(phone.text().indexOf("电话：") + "电话：".length()));
        candidate.setContactTel(phone.text().substring(phone.text().indexOf("电话：") + "电话：".length()));

        Elements email = parsedDoc.select("#Form1 > .JlDiv >.JlJbxxDiv >.JlLxdiv >.Contact >ul >li");
        System.out.println(":::邮箱：" + email.text().substring(email.text().indexOf("邮箱：") + "邮箱：".length()));
        candidate.setContactEmail(email.text().substring(email.text().indexOf("邮箱：") + "邮箱：".length()));

        Elements gender = parsedDoc.select("#Form1 > .JlDiv >.JlJbxxDiv >.JlJbxx >ul#jbxxUl >li.First");
        System.out.println(":::性别：" + gender.text());
        candidate.setGender(gender.text());

        Elements age = parsedDoc.select("#Form1 > .JlDiv >.JlJbxxDiv >.JlJbxx >ul#jbxxUl >li");
        System.out.println(":::年龄：" + age.text().substring(2, 4));
        candidate.setAge(age.text().substring(2, 4));
        System.out.println(":::民族：" + age.text().substring(6, 8));
        candidate.setNation(age.text().substring(6, 8));

        Elements workYear = parsedDoc.select("#Form1 > .JlDiv >.JlJbxxDiv >.JlJbxx >ul#jbxxUl >li.Jl_Fwb");
        System.out.println(":::工作年限：" + workYear.text());
        candidate.setWorkYear(workYear.text());

        Elements censusRegister = parsedDoc.select("#Form1 > .JlDiv >.JlJbxxDiv > #adddiv.JlJbxx >ul");
        System.out.println(":::户口：" + censusRegister.text().substring("户口所在地：".length(), censusRegister.text().indexOf("现居住地：")));
        candidate.setCensusRegister(censusRegister.text().substring("户口所在地：".length(), censusRegister.text().indexOf("现居住地：")));

        Elements currentResidence = parsedDoc.select("#Form1 > .JlDiv >.JlJbxxDiv > #adddiv.JlJbxx >ul");
        System.out.println(":::现居住地：" + currentResidence.text().substring(currentResidence.text().indexOf("现居住地：") + "现居住地：".length()));
        candidate.setCurrentResidence(currentResidence.text().substring(currentResidence.text().indexOf("现居住地：") + "现居住地：".length()));
        /*------------------------------------------------------------------------------------------------------------*/

        Elements expectation = parsedDoc.select("#Form1 > .JlDiv >.JlXmDiv > #jobintentiondiv.JlXmxqDiv >ul >li");
        System.out.println(":::期望工作地区：" + getSubString(expectation.text(), "期望工作地区", "期望从事职位"));
        candidate.getExpectation().setWorkPlace(getSubString(expectation.text(), "期望工作地区", "期望从事职位"));

        System.out.println(":::期望从事职位：" + getSubString(expectation.text(), "期望从事职位", "期望月薪范围"));
        candidate.getExpectation().setOccupation(getSubString(expectation.text(), "期望从事职位", "期望月薪范围"));

        System.out.println(":::期望月薪范围：" + getSubString(expectation.text(), "期望月薪范围", "当前求职状态"));
        candidate.getExpectation().setMonthlyPay(getSubString(expectation.text(), "期望月薪范围", "当前求职状态"));

        System.out.println(":::当前求职状态：" + getSubString(expectation.text(), "当前求职状态", "期望工作性质"));
        candidate.getExpectation().setCurrentStatue(getSubString(expectation.text(), "当前求职状态", "期望工作性质"));

        System.out.println(":::期望工作性质：" + getLastStr(expectation.text(), "期望工作性质："));
        candidate.getExpectation().setWorkNature(getLastStr(expectation.text(), "期望工作性质："));

        /*------------------------------------------------------------------------------------------------------------*/

        Elements workExperience = parsedDoc.select("#Form1 > .JlDiv >#wodiv.JlXmDiv");
        System.out.println(":::工作/实习经历：" + workExperience.text());
        candidate.setWorkExperience(workExperience.text());

        /*------------------------------------------------------------------------------------------------------------*/

        Elements educationBackground = parsedDoc.select("#Form1 > .JlDiv >#edudiv.JlXmDiv");
        System.out.println(":::教育经历：" + educationBackground.text());
        candidate.setEducationBackground(educationBackground.text());

        /*------------------------------------------------------------------------------------------------------------*/

        Elements trainingExperience = parsedDoc.select("#Form1 > .JlDiv >#traindiv.JlXmDiv");
        System.out.println(":::培训经历：" + trainingExperience.text());
        candidate.setTrainingExperience(trainingExperience.text());

        /*------------------------------------------------------------------------------------------------------------*/

        Elements skillsCertificate = parsedDoc.select("#Form1 > .JlDiv >#cerdiv.JlXmDiv");
        System.out.println(":::技能证书：" + skillsCertificate.text());
        candidate.setSkillsCertificate(skillsCertificate.text());

        candidates.add(candidate);
    }

    /**
     * @param str    原字符串（待截取原串）
     * @param posStr 指定字符串
     * @return 截取截取指定字符串之之间的数据
     */
    public static String getSubString(String str, String posStr, String lastStr) {
        return str.substring(str.indexOf(posStr), str.indexOf(lastStr));
    }

    /**
     * @param str    原字符串（待截取原串）
     * @param posStr 指定字符串
     * @return 截取截取指定字符串之后的数据
     */
    public static String getLastStr(String str, String posStr) {
        return str.substring(str.indexOf(posStr) + posStr.length());
    }
}

/* 解析示例
:::姓名：熊利
:::电话：15583702451
:::邮箱：2763015449@qq.com
:::性别：女
:::年龄：23
:::民族：汉族
:::工作年限：3个月工作经验
:::户口：四川省广安市
:::现居住地：成都市简阳市
:::期望工作地区：期望工作地区：四川省成都市
:::期望从事职位：期望从事职位：经理助理/秘书/文秘
:::期望月薪范围：期望月薪范围：4001-5000元
:::当前求职状态：当前求职状态：目前正在找工作，可立即上岗
:::期望工作性质：实习
:::工作/实习经历：工作/实习经历 2021-06至2021-09车公馆前台 单位规模：1-49人 工作描述：1.建立与客户的良好沟通，按照厂家及工作流程要求，完成对来店维修车辆的问诊、估价、结算工作； 2.保证客户满意度、积极开发维修资源，增加管理内用户，提高售后维修收入； 3.跟进车辆维修进度，与车间技师沟通，确认车辆维修进度及完工时间； 4.跟进回访，提醒保养维修关怀。 2020-06至2020-11江苏京东信息技术有限公司成都分公司客服 单位规模：1000人以上 工作描述：1.负责京东在线客服上客户咨询，解答客户提问，促成销售，及时提醒顾客并备注其特殊要求； 2.做好客户的回访工作，收集并整理客户意见和建议，做好反馈工作； 3.工作业绩考核通过，认证“储备干部”，带领小组成员奋战双十一。
:::教育经历：教育经历 2021-09至2023-06吉利学院本科市场营销
:::培训经历：培训经历 2018-10至2018-11SYB创业培训 培训描述： SYB的全称是“START YOUR BUSINESS”，意为“创办你的企业”，它是“创办和改善你的企业”（SIYB）系列培训教程的一个重要组成部分，由联合国国际劳工组织开发，为有愿望开办自己中小企业的朋友量身定制的培训项目。创业培训是国际劳工组织针对培养微小型企业经营者而开发的培训项目。经国家劳动和社会保障部引入我国后，部分省市进行试点运行，取得了良好的效果。创业培训不仅使学员的就业观念发生转变，更激发了他们的创业意识，掌握创业技能，增强微小企业抗风险能力，使学员在短时间内成为微型企业的老板。为微小企业设计的一门课程。主要教如何创业，如何创办自己的企业，如何计划资金预算。
:::技能证书：技能证书 2021-04取得网店运营推广职业技能证书 2020-01取得中国市场营销策划师资格证书 2020-01取得中国市场营销经理助理资格证书
 */
