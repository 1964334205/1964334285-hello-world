package XML学习;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.util.Scanner;

public class inquire {
    public void inq() throws ParserConfigurationException, IOException, SAXException {
        parameter parameter = new parameter();
        Document student = parameter.document();
        System.out.print("请输入要查询的用户准考证号：");
        Scanner scanner = new Scanner(System.in);
        String operator = scanner.next();
        int shenfz = student.getElementsByTagName("学生准考证号").getLength();
        Element ELS = null;
        for (int i = 0; i < shenfz; i++) {
            ELS = (Element) student.getElementsByTagName("学生准考证号").item(i);
            System.out.println(ELS.getTextContent());
            if (ELS.getTextContent().equals(operator)) {
                print.print(student, i, "查询成功");
                return;
            }

        }
        System.out.println("未找到学生，查询失败！");
    }
}
