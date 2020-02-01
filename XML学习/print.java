package XML学习;

import org.w3c.dom.Document;

public class print {
    public static void print(Document student, int i, String s) {
        System.out.println(s);
        System.out.println("学生姓名" + ":" + student.getElementsByTagName("学生姓名").item(i).getTextContent());
        System.out.println("学生准考证号" + ":" + student.getElementsByTagName("学生准考证号").item(i).getTextContent());
        System.out.println("学生身份证号" + ":" + student.getElementsByTagName("学生身份证号").item(i).getTextContent());
        System.out.println("学生所在地" + ":" + student.getElementsByTagName("学生所在地").item(i).getTextContent());
        System.out.println("学生成绩" + ":" + student.getElementsByTagName("学生成绩").item(i).getTextContent());


    }
}
