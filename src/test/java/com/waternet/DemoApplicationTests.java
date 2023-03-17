package com.waternet;

import com.waternet.utils.FileUtil;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class DemoApplicationTests {

    @Test
    void contextLoads() throws Exception {
        String inputPath = "D:\\SoftwareDevelopment\\eml\\Outs\\hello (1).html";
        String outputPath = "D:\\test.xlsx";

        FileUtil.changeEml2Xls(inputPath,outputPath);
    }

}
