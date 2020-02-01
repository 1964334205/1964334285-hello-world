package XML学习;

import org.w3c.dom.*;
import org.xml.sax.SAXException;

import javax.imageio.metadata.IIOMetadataNode;
import javax.xml.namespace.QName;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.FileOutputStream;
import java.io.IOException;

public class demo1 {
    public static void main(String[] args) throws IOException, SAXException, ParserConfigurationException, TransformerException {
        read6();
    }

    /*获取节点内容*/
    public static void read() throws ParserConfigurationException, IOException, SAXException {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        org.w3c.dom.Document document = builder.parse("src/XML学习/book.xml");
        /*简写形式*/
        Document document1 = DocumentBuilderFactory.newInstance().newDocumentBuilder().parse("src/XML学习/name.xml");
        NodeList nodeList = document1.getElementsByTagName("书名");
        Node node = nodeList.item(0);
        String s = node.getTextContent();
        System.out.println(s);
    }

    /*获取节点下的所有子节点*/
    public static void read2() throws ParserConfigurationException, IOException, SAXException {
        /*简写形式*/
        Document document1 = DocumentBuilderFactory.newInstance().newDocumentBuilder().parse("src/XML学习/name.xml");
        Node node = document1.getElementsByTagName("书架").item(0);
        list(node);
    }

    /*添加节点*/
    public static void read3() throws ParserConfigurationException, IOException, SAXException, TransformerException {
        Document document1 = DocumentBuilderFactory.newInstance().newDocumentBuilder().parse("src/XML学习/book.xml");
        /*创建节点*/
        Element element = document1.createElement("售价");
        element.setTextContent("80.0￥");
        /*挂载节点*/
        Element book = (Element) document1.getElementsByTagName("书").item(0);
        System.out.println(book.getNodeName() + "----" + book.getTextContent());
        book.appendChild(element);

        /*将改变后的内存文件写入到硬盘中*/
        /*绑定内存文件*/
        DOMSource domSource = new DOMSource(document1);
        /*绑定硬盘文件*/
        StreamResult streamResult = new StreamResult(new FileOutputStream("src/XML学习/book.xml"));
        /*利用此类进行写入*/
        TransformerFactory transformerFactory = TransformerFactory.newDefaultInstance();
        Transformer transformer = transformerFactory.newTransformer();
        transformer.transform(domSource, streamResult);


    }

    /*指定位置添加节点*/
    public static void read4() throws ParserConfigurationException, IOException, SAXException, TransformerException {
        Document document1 = DocumentBuilderFactory.newInstance().newDocumentBuilder().parse("src/XML学习/book.xml");
        /*创建节点*/
        Element element = document1.createElement("售价");
        element.setTextContent("90.0￥");

        /*获取参考节点：在指定位置添加节点需要一个参考节点*/
        Element reference = (Element) document1.getElementsByTagName("作者").item(1);
        System.out.println(reference.getTextContent());
        /*挂载节点*/
        Element book = (Element) document1.getElementsByTagName("书").item(1);
        System.out.println(book.getNodeName() + "----" + book.getTextContent());
        /*进行插入*/
        book.insertBefore(element, reference);

        /*将改变后的内存文件写入到硬盘中*/
        /*绑定内存文件*/
        DOMSource domSource = new DOMSource(document1);
        /*绑定硬盘文件*/
        StreamResult streamResult = new StreamResult(new FileOutputStream("src/XML学习/book.xml"));
        /*利用此类进行写入*/
        TransformerFactory transformerFactory = TransformerFactory.newDefaultInstance();
        Transformer transformer = transformerFactory.newTransformer();
        transformer.transform(domSource, streamResult);


    }

    /*对一个节点添加属性*/
    public static void read5() throws ParserConfigurationException, IOException, SAXException, TransformerException {
        Document document1 = DocumentBuilderFactory.newInstance().newDocumentBuilder().parse("src/XML学习/book.xml");

        /*挂载节点*/
        Element book = (Element) document1.getElementsByTagName("书").item(1);
        /*添加属性*/
        book.setAttribute("name", "book");

        System.out.println(book.getNodeName() + "----" + book.getTextContent());

        /*进行插入*/


        /*将改变后的内存文件写入到硬盘中*/
        /*绑定内存文件*/
        DOMSource domSource = new DOMSource(document1);
        /*绑定硬盘文件*/
        StreamResult streamResult = new StreamResult(new FileOutputStream("src/XML学习/book.xml"));
        /*利用此类进行写入*/
        TransformerFactory transformerFactory = TransformerFactory.newDefaultInstance();
        Transformer transformer = transformerFactory.newTransformer();
        transformer.transform(domSource, streamResult);


    }

    /*删除一个节点*/
    public static void read6() throws ParserConfigurationException, IOException, SAXException, TransformerException {
        Document document1 = DocumentBuilderFactory.newInstance().newDocumentBuilder().parse("src/XML学习/book.xml");
        /**
         //要删除的节点
         Element selling_price = (Element) document1.getElementsByTagName("售价").item(6);
         System.out.println(selling_price.getTextContent());
         //要删除节点的父节点：父节点才有权利进行删除
         Element father = (Element) document1.getElementsByTagName("书").item(1);
         //对节点进删除
         father.removeChild(selling_price);
         System.out.println(father.getNodeName()+"----"+father.getTextContent());*/
        /*简写方式*/
        Element selling_price = (Element) document1.getElementsByTagName("售价").item(6);
        /*通过子节点的getParentNode()方法获取父节点，进行删除比上面方式简便一些*/
        selling_price.getParentNode().getParentNode().removeChild(selling_price.getParentNode());
        System.out.println(selling_price.getTextContent());


        /*将改变后的内存文件写入到硬盘中*/
        /*绑定内存文件*/
        DOMSource domSource = new DOMSource(document1);
        /*绑定硬盘文件*/
        StreamResult streamResult = new StreamResult(new FileOutputStream("src/XML学习/book.xml"));
        /*利用此类进行写入*/
        TransformerFactory transformerFactory = TransformerFactory.newDefaultInstance();
        Transformer transformer = transformerFactory.newTransformer();
        transformer.transform(domSource, streamResult);


    }

    /*对接点进行便利，并输出内容*/
    public static void list(Node root) throws ParserConfigurationException, IOException, SAXException {
        if (root instanceof Element) {
            if (root.getNodeName() == "书名" || root.getNodeName() == "作者" || root.getNodeName() == "售价") {
                System.out.println(root.getNodeName() + "----" + root.getTextContent());
            } else {
                System.out.println(root.getNodeName());
            }

        }
        NodeList list = root.getChildNodes();
        for (int i = 0; i < list.getLength(); i++) {
            Node child = list.item(i);
            list(child);
        }


    }
}
