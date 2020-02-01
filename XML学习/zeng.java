package XML学习;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.xml.sax.SAXException;

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
import java.util.Scanner;

public class zeng {

    public void increase() throws ParserConfigurationException, IOException, SAXException, TransformerException {
        String[] storage = new String[5];
        Element[] elements = new Element[5];
        String[] xigap = {"请输入学生姓名", "请输入学生准考证号", "请输入学生身份证号", "请输入学生所在地", "请输入学生成绩"};
        String[] xigap2 = {"学生姓名", "学生准考证号", "学生身份证号", "学生所在地", "学生成绩"};
        parameter parameter = new parameter();
        Document student = parameter.document();
        int intjishu = parameter.jishu();
        /*对用户输入数据进行保存*/
        /*瞎搞测试*/
        for (int i = 0; i < storage.length; i++) {
            System.out.print(xigap[i] + "：");
            Scanner scanner = new Scanner(System.in);
            storage[i] = scanner.next();
        }
        /*瞎搞测试*//*瞎搞测试*//*瞎搞测试*//*瞎搞测试*/
        /*使用户数据创建新节点，并初始化*/
        for (int i = 0; i < storage.length; i++) {
            elements[i] = student.createElement(xigap2[i]);
            elements[i].setTextContent(storage[i]);
        }
        Node node = parameter.node();
        Element guzai = student.createElement("学生");
        node.appendChild(guzai);
        /*先进创建并写入学生节点*/
        if (true) {
            /*挂载节点*/
            node.appendChild(guzai);
            /*瞎搞测试*//*瞎搞测试*//*瞎搞测试*//*瞎搞测试*/
            /*将改变后的内存文件写入到硬盘中*/
            Hard_disk_type.hard(student, "src/XML学习/学生管理系统.xml");
        }
        /*将创建的新节点进行添加写入学生信息节点*/
        Element tianjia = (Element) student.getElementsByTagName("学生").item(intjishu);

        if (true) {
            /*挂载节点*/
            for (int i = 0; i < storage.length; i++) {
                tianjia.appendChild(elements[i]);
            }
            /*将改变后的内存文件写入到硬盘中*/
            Hard_disk_type.hard(student, "src/XML学习/学生管理系统.xml");
        }
        /*瞎搞测试*//*瞎搞测试*//*瞎搞测试*//*瞎搞测试*/
        /*对计数属性进行刷新*/
        Element JISHU = (Element) student.getElementsByTagName("计数").item(0);
        JISHU.getParentNode().removeChild(JISHU);
        JISHU = student.createElement("计数");
        JISHU.setTextContent(String.valueOf((intjishu + 1)));
        node.appendChild(JISHU);
        if (true) {
            /*将改变后的内存文件写入到硬盘中*/
            Hard_disk_type.hard(student, "src/XML学习/学生管理系统.xml");
        }
        /*瞎搞测试*//*瞎搞测试*//*瞎搞测试*//*瞎搞测试*/
        print.print(student, intjishu, "写入成功");
        /*瞎搞测试*//*瞎搞测试*//*瞎搞测试*//*瞎搞测试*/
    }
}
