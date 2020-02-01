package XML学习;

import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;

public class parameter {
    private static Document student;
    private static Node node;
    private static int jishu;

    public parameter() throws ParserConfigurationException, IOException, SAXException {
        student = DocumentBuilderFactory.newInstance().newDocumentBuilder().parse("src/XML学习/学生管理系统.xml");
        node = student.getElementsByTagName("学生管理").item(0);
        jishu = Integer.parseInt(student.getElementsByTagName("计数").item(0).getTextContent());
    }

    public Document document() throws ParserConfigurationException, IOException, SAXException {
        return student;
    }

    public Node node() throws ParserConfigurationException, IOException, SAXException {
        return node;
    }


    public int jishu() throws ParserConfigurationException, IOException, SAXException {
        return jishu;
    }
}
