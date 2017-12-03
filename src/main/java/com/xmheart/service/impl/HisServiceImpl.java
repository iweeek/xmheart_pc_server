package com.xmheart.service.impl;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xmheart.his.Response.Doctor;
import com.xmheart.his.Response.Doctors;
import com.xmheart.model.XPWDoctor;
import com.xmheart.service.DoctorAndDeptService;
import com.xmheart.service.HisService;
import com.xmheart.util.HisUtil;
import com.xmheart.util.XmlUtil;

@Service
public class HisServiceImpl implements HisService{

    @Autowired
    private DoctorAndDeptService doctorAndDeptService;
    
    @Override
    public  void doctors(Doctors d) {
//        char[] chars = new char[1024];
//        int len = 0;
//        StringBuilder builder = new StringBuilder(); 
//        Reader reader = null;
//        String fileName = "/Users/nimon/AndroidStudioProjects/BB/xmheart_pc_server/WebContent/input.txt";
//        try {
//            System.out.println("以字符为单位读取文件内容，一次读多个字节：");
//            // 一次读多个字符
//            char[] tempchars = new char[1024];
//            int charread = 0;
//            reader = new InputStreamReader(new FileInputStream(fileName));
//            // 读入多个字符到字符数组中，charread为一次读取字符数
//            while ((charread = reader.read(tempchars)) != -1) {
//                // 同样屏蔽掉\r不显示
//                if ((charread == tempchars.length)
//                        && (tempchars[tempchars.length - 1] != '\r')) {
//                    System.out.print(tempchars);
//                    builder.append(tempchars);
//                } else {
//                    for (int i = 0; i < charread; i++) {
//                        if (tempchars[i] == '\r') {
//                            continue;
//                        } else {
////                            System.out.print(tempchars[i]);
//                            builder.append(tempchars[i]);
//                        }
//                    }
//                }
//            }
//        } catch (Exception e1) {
//            e1.printStackTrace();
//        } finally {
//            if (reader != null) {
//                try {
//                    reader.close();
//                } catch (IOException e1) {
//                }
//            }
//        }
        
        
        
//        HisUtil.doctors(type, deptCode, DeptName, workDateStart, workDateEnd);
//        System.out.println(builder.toString());
//        System.out.println("4.3 Doctors \n" + builder.toString());
//        Doctors d = (Doctors) XmlUtil.xmlToObject(HisUtil.handleResp(builder.toString()), Doctors.class);
        List<XPWDoctor> allDoctors = doctorAndDeptService.getAllDoctors();
        XPWDoctor dt = null;
        for (Doctor doc : d.getDoctor()) {
            for (XPWDoctor xDoc : allDoctors) {
                if (xDoc.getName().equals(doc.getDocName())) {
                    dt = xDoc;
                    System.out.println("xDoc.getName()" + xDoc.getName());
                    System.out.println("doc.getDocCode()" + doc.getDocCode());
//                    allDoctors.remove(xDoc);
                    dt.setHisId(Integer.valueOf(doc.getDocCode()));
                    doctorAndDeptService.updateDoctor(dt);
                    
                }
            }
        }
    }
    
}
