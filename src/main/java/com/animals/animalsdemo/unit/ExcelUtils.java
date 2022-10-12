package com.animals.animalsdemo.unit;

import com.alibaba.excel.EasyExcel;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;


public class ExcelUtils {
    public void  importExcel(MultipartFile file)  {
        String fileName = "/Users/pankewei/Desktop/user.xlsx";
//        EasyExcel.read(fileName, new EasyExcelDataListener()).sheet().doRead();
    }

}
