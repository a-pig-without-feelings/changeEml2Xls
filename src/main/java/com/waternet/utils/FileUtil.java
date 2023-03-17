package com.waternet.utils;

import com.waternet.domin.Candidate;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import java.io.*;
import java.util.Calendar;

/**
 * 通过文件方式提取解析html文件
 */
public class FileUtil {
    public static void main(String[] args) throws IOException {
        Candidate candidate = new Candidate();

        //01 创建文件对象，指定解析文件路径
        File file = new File("D:\\SoftwareDevelopment\\eml\\Outs\\应聘_投资管理岗_经理助理_运营管培生_成都人才网简历\\body_0(0).html");
        Document parsedDoc = Jsoup.parse(file, "GBK");

        //02 读取EML简历各个字段，存储至对象中
        /*------------------------------------------------------------------------------------------------------------*/
        Elements name = parsedDoc.select("#Form1 > .JlDiv >.JlJbxxDiv >.JlLxdiv >.Name");
        System.out.println(":::姓名：" + name.text());

        Elements phone = parsedDoc.select("#Form1 > .JlDiv >.JlJbxxDiv >.JlLxdiv >.Contact >ul >li.First");
        System.out.println(":::电话：" + phone.text().substring(phone.text().indexOf("电话：") + "电话：".length()));

        Elements email = parsedDoc.select("#Form1 > .JlDiv >.JlJbxxDiv >.JlLxdiv >.Contact >ul >li");
        System.out.println(":::邮箱：" + email.text().substring(email.text().indexOf("邮箱：") + "邮箱：".length()));

        Elements gender = parsedDoc.select("#Form1 > .JlDiv >.JlJbxxDiv >.JlJbxx >ul#jbxxUl >li.First");
        System.out.println(":::性别：" + gender.text());

        Elements age = parsedDoc.select("#Form1 > .JlDiv >.JlJbxxDiv >.JlJbxx >ul#jbxxUl >li");
        System.out.println(":::年龄：" + age.text().substring(2, 4));
        System.out.println(":::民族：" + age.text().substring(6, 8));

        Elements workYear = parsedDoc.select("#Form1 > .JlDiv >.JlJbxxDiv >.JlJbxx >ul#jbxxUl >li.Jl_Fwb");
        System.out.println(":::工作年限：" + workYear.text());

        Elements censusRegister = parsedDoc.select("#Form1 > .JlDiv >.JlJbxxDiv > #adddiv.JlJbxx >ul");
        System.out.println(":::户口：" + censusRegister.text().substring("户口所在地：".length(), censusRegister.text().indexOf("现居住地：")));

        Elements currentResidence = parsedDoc.select("#Form1 > .JlDiv >.JlJbxxDiv > #adddiv.JlJbxx >ul");
        System.out.println(":::现居住地：" + currentResidence.text().substring(currentResidence.text().indexOf("现居住地：") + "现居住地：".length()));
        /*------------------------------------------------------------------------------------------------------------*/

        Elements expectation = parsedDoc.select("#Form1 > .JlDiv >.JlXmDiv > #jobintentiondiv.JlXmxqDiv >ul >li");
        System.out.println(":::期望工作地区：" + getSubString(expectation.text(), "期望工作地区", "期望从事职位"));
        System.out.println(":::期望从事职位：" + getSubString(expectation.text(), "期望从事职位", "期望月薪范围"));
        System.out.println(":::期望月薪范围：" + getSubString(expectation.text(), "期望月薪范围", "当前求职状态"));
        System.out.println(":::当前求职状态：" + getSubString(expectation.text(), "当前求职状态", "期望工作性质"));
        System.out.println(":::期望工作性质：" + getLastStr(expectation.text(), "期望工作性质："));

        /*------------------------------------------------------------------------------------------------------------*/

        Elements workExperience = parsedDoc.select("#Form1 > .JlDiv >#wodiv.JlXmDiv");
        System.out.println(":::工作/实习经历：" + workExperience.text());

        /*------------------------------------------------------------------------------------------------------------*/

        Elements educationBackground = parsedDoc.select("#Form1 > .JlDiv >#edudiv.JlXmDiv");
        System.out.println(":::教育经历：" + educationBackground.text());

        /*------------------------------------------------------------------------------------------------------------*/

        Elements trainingExperience = parsedDoc.select("#Form1 > .JlDiv >#traindiv.JlXmDiv");
        System.out.println(":::培训经历：" + trainingExperience.text());

        /*------------------------------------------------------------------------------------------------------------*/

        Elements skillsCertificate = parsedDoc.select("#Form1 > .JlDiv >#cerdiv.JlXmDiv");
        System.out.println(":::技能证书：" + skillsCertificate.text());

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
