package XML学习;

import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerException;
import java.io.IOException;
import java.util.Scanner;
import java.util.stream.Stream;

public class li {
    public static void main(String[] args) throws IOException, SAXException, ParserConfigurationException, TransformerException {
        String operator = null;
        System.out.println("添加用户:（A||a）  删除用户:（B||b）  查询成绩:（C||c）");
        //noinspection InfiniteLoopStatement
        while (true) {
            System.out.print("请输入操作类型：");
            Scanner scanner = new Scanner(System.in);
            operator = scanner.next();
            if (operator.equals("A") || operator.equals("a")) {
                zeng zeng = new zeng();
                zeng.increase();
            } else if (operator.equals("B") || operator.equals("b")) {
                delete delete = new delete();
                delete.del();
            } else if (operator.equals("C") || operator.equals("c")) {
                inquire inquire = new inquire();
                inquire.inq();
            } else {
                System.out.println("输入错误，请重新输入");
            }
        }
    }

}
