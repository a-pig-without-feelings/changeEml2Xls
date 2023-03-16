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
        Elements select1 = parsedDoc.select("#Form1 > .JlDiv >.JlJbxxDiv >.JlLxdiv >.Name");
        System.out.println("-----------------姓名--------------------");
        candidate.setName(select1.text());
        Elements select2 = parsedDoc.select("#Form1 > .JlDiv >.JlJbxxDiv >.JlLxdiv >.Contact >ul >li");
        System.out.println("------------------电话邮箱-------------------");
        String[] s1 = select2.text().split(" ");
        System.out.println(s1[0]);
        System.out.println(s1[1]);
        System.out.println("-------------------------------------------------------------------------------");
        Elements select3 = parsedDoc.select("#Form1 > .JlDiv >.JlJbxxDiv >.JlJbxx >ul#jbxxUl >li");
        String[] s = select3.text().split(" ");
        candidate.setGender(s[0]);
        candidate.setAge(s[1]);
        candidate.setNation(s[2]);
        candidate.setWorkYear(s[3]);
        System.out.println("-------------------------------------------------------------------------------");
        Elements select4 = parsedDoc.select("#Form1 > .JlDiv >.JlJbxxDiv > #adddiv.JlJbxx >ul");

        System.out.println(select4.text());
        System.out.println("-------------------------------------------------------------------------------");
        Elements select5 = parsedDoc.select("#Form1 > .JlDiv >.JlJbxxDiv > #lastedudiv.JlJbxx >ul >li");
        System.out.println(select5.text());//可以不要，后面还有
        System.out.println("-------------------------------------------------------------------------------");
        Elements select6 = parsedDoc.select("#Form1 > .JlDiv >.JlJbxxDiv > #lastedudiv.JlJbxx >ul >li");

        /*求职意向*/
        System.out.println("-------------------------------------------------------------------------------");
        Elements select7 = parsedDoc.select("#Form1 > .JlDiv >.JlXmDiv > #jobintentiondiv.JlXmxqDiv >ul >li");
        System.out.println(select7.text());
        System.out.println("-------------------------------------------------------------------------------");

        /*工作/实习经历*/
        Elements select8 = parsedDoc.select("#Form1 > .JlDiv >#wodiv.JlXmDiv");
        System.out.println(select8.text());
        System.out.println("-------------------------------------------------------------------------------");

        /*教育经历*/
        Elements select9 = parsedDoc.select("#Form1 > .JlDiv >#edudiv.JlXmDiv");
        System.out.println(select9.text());

        System.out.println("-------------------------------------------------------------------------------");
        /*培训经历*/
        Elements select10 = parsedDoc.select("#Form1 > .JlDiv >#edudiv.JlXmDiv");
        System.out.println(select9.text());

        System.out.println("-------------------------------------------------------------------------------");



    }
}
