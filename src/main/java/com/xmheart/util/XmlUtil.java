package com.xmheart.util;

import java.io.IOException;
import java.io.Reader;
import java.io.StringReader;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Unmarshaller;

public class XmlUtil {

    public static Object xmlToObject(String xml, Class<?> load) {
        Object xmlObject = null;
        Reader reader = null;
        try {
            JAXBContext context = JAXBContext.newInstance(load);
            // 解析了XML文档
            Unmarshaller unmarshaller = context.createUnmarshaller();
            reader = new StringReader(xml);
            xmlObject = unmarshaller.unmarshal(reader);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (null != reader) {
                try {
                    reader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return xmlObject;
    }

//    public static void main(String[] args) {
//        JAXBContext context;
//        try {
//            context = JAXBContext.newInstance(Doctors.class);
//
//            Marshaller marshaller = context.createMarshaller();
//            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
//            StringWriter writer = new StringWriter();
////            Doctors d = new Doctors("1", "2", "3", null);
//            Doctors d = new Doctors();
//            d.setRespMessage("成功");
//            d.setTransactionCode("2000");
//
//            
//            JAXB.marshal(d, writer);
//            
//            System.out.println(writer.toString());
//        } catch (JAXBException e) {
//            // TODO Auto-generated catch block
//            e.printStackTrace();
//        }
//    }
}
