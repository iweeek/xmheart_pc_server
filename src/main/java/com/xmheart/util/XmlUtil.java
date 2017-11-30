package com.xmheart.util;


import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.IOException;
import java.io.Reader;
import java.io.StringReader;

public class XmlUtil {

    public static Object xmlToObject(String xml,Class<?> load){
        Object xmlObject = null;
        Reader reader = null;
        try {
            JAXBContext context = JAXBContext.newInstance(load);
            Unmarshaller unmarshaller = context.createUnmarshaller();
            reader = new StringReader(xml);
            xmlObject = unmarshaller.unmarshal(reader);
        } catch (JAXBException e) {
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
}
