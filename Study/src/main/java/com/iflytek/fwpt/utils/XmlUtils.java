package com.iflytek.fwpt.utils;

import java.io.ByteArrayOutputStream;
import java.io.StringReader;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import javax.xml.stream.XMLOutputFactory;
import javax.xml.stream.XMLStreamWriter;


public class XmlUtils
{

    /** 
    * 将对象转换为xml 
    * @param obj
    * @param model
    * @throws Exception    
    * @return String    返回类型
    * @author jgwang2 
    * @throws 
    */
    public static String beanToXml(Object obj, Class<?> model)
        throws Exception
    {
        XMLOutputFactory xmlOutputFactory = XMLOutputFactory.newFactory();;
        JAXBContext jaxbContext = JAXBContext.newInstance(model);
        Marshaller marshaller = jaxbContext.createMarshaller();
        // marshaller.setProperty(Marshaller.JAXB_ENCODING, "gbk");
        marshaller.setProperty(Marshaller.JAXB_FRAGMENT, true);
        marshaller.setListener(new MarshallerListener());
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        XMLStreamWriter xmlStreamWriter = xmlOutputFactory.createXMLStreamWriter(baos,
            (String)marshaller.getProperty(Marshaller.JAXB_ENCODING));
        // xmlStreamWriter.writeStartDocument(
        // (String)marshaller.getProperty(Marshaller.JAXB_ENCODING), "1.0");
        marshaller.marshal(obj, xmlStreamWriter);
        xmlStreamWriter.writeEndDocument();
        xmlStreamWriter.close();
        return new String(baos.toByteArray());
    }

    // /**
    // * 将xml文件转化为对象
    // * @param xmlPath
    // * @param load
    // * @throws JAXBException
    // * @throws IOException
    // * @return Object 返回类型
    // * @author jgwang2
    // * @throws
    // */
    // public static Object xmlToBean(String xmlPath, Class<?> load)
    // throws JAXBException, IOException
    // {
    // JAXBContext context = JAXBContext.newInstance(load);
    // Unmarshaller unmarshaller = context.createUnmarshaller();
    // Object object = unmarshaller.unmarshal(new File(xmlPath));
    // return object;
    // }

    /**  
     * 将String类型的xml转换成对象  
     */
    public static Object xmlToBean(String xmlStr, Class clazz)
    {
        Object xmlObject = null;
        try
        {
            JAXBContext context = JAXBContext.newInstance(clazz);
            // 进行将Xml转成对象的核心接口
            Unmarshaller unmarshaller = context.createUnmarshaller();
            StringReader sr = new StringReader(xmlStr);
            xmlObject = unmarshaller.unmarshal(sr);
        }
        catch (JAXBException e)
        {
            e.printStackTrace();
        }
        return xmlObject;
    }

    // public static String convertToXml(Object obj)
    // {
    // String result = null;
    // try
    // {
    // JAXBContext context = JAXBContext.newInstance(obj.getClass());
    // Marshaller marshaller = context.createMarshaller();
    // marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
    // // marshaller.setProperty(Marshaller.JAXB_ENCODING, encoding);
    // StringWriter writer = new StringWriter();
    // marshaller.marshal(obj, writer);
    //
    // result = writer.toString();
    // }
    // catch (Exception e)
    // {
    // e.printStackTrace();
    // }
    //
    // return result;
    // }
}
