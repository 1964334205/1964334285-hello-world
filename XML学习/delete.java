package XML学习;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.xml.sax.SAXException;

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
import java.util.Scanner;

public class delete {
    public void del() throws ParserConfigurationException, IOException, SAXException, TransformerException {
        parameter parameter = new parameter();
        Document student = parameter.document();
        Node node = parameter.node();
        int intjishu = parameter.jishu();
        System.out.print("请输入要删除用户的姓名：");
        Scanner scanner = new Scanner(System.in);
        String operator = scanner.next();
        int name = student.getElementsByTagName("学生姓名").getLength();
        System.out.println("姓名" + name);
        boolean succeed = false;
        Element ELS = null;
        for (int i = 0; i < name; i++) {
            ELS = (Element) student.getElementsByTagName("学生姓名").item(i);
            if (ELS.getTextContent().equals(operator)) {
                print.print(student, i, "删除成功");
                ELS.getParentNode().getParentNode().removeChild(ELS.getParentNode());
                succeed = true;
                break;

            }
        }
        if (succeed) {
            if (true) {
                /*将改变后的内存文件写入到硬盘中*/
                Hard_disk_type.hard(student, "src/XML学习/学生管理系统.xml");
            }
            /*对计数属性进行刷新*/
            Element JISHU = (Element) student.getElementsByTagName("计数").item(0);
            JISHU.getParentNode().removeChild(JISHU);
            JISHU = student.createElement("计数");
            JISHU.setTextContent(String.valueOf((intjishu - 1)));
            node.appendChild(JISHU);
            if (true) {
                /*将改变后的内存文件写入到硬盘中*/
                Hard_disk_type.hard(student, "src/XML学习/学生管理系统.xml");
            }
            return;
        }
        System.out.println("未找到学院，删除失败！");
    }
}
