package com.xmheart.util;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Set;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

import com.xmheart.zy.Report;
import com.xmheart.zy.LisList;



public class XmlToBean {
	
	 /**
     * xml文件配置转换为对象
     * @param xmlPath  xml文件路径
     * @param load    java对象.Class
     * @return    java对象
     * @throws JAXBException    
     * @throws IOException
     */
    public static Object xmlToBean(String xmlPath,Class<?> load) throws JAXBException, IOException{
        JAXBContext context = JAXBContext.newInstance(load);  
        Unmarshaller unmarshaller = context.createUnmarshaller(); 
        Object object = unmarshaller.unmarshal(new File(xmlPath));
        return object;
    }
    
    public static void main(String[] args) throws IOException, JAXBException {
        String xmlPath =  "/Users/nijun/Desktop/w.xml";
        Object object = XmlToBean.xmlToBean(xmlPath,LisList.class);
        LisList students = (LisList)object;
        List<Report> reports = students.getReports();
        
        for(int i=0;i< reports.size();i++){
            for(Report report : reports){
                System.out.print(report.toString()+" \n");
            }
            System.out.println("-------------");
        }
    }
}
