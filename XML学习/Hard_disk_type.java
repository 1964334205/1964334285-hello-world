package XML学习;

import org.w3c.dom.Document;

import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

public class Hard_disk_type {
    public static void hard(Document student, String file) throws FileNotFoundException, TransformerException {
        /*将改变后的内存文件写入到硬盘中*/
        /*绑定内存文件*/
        DOMSource domSource = new DOMSource(student);
        /*绑定硬盘文件*/
        StreamResult streamResult = new StreamResult(new FileOutputStream("src/XML学习/学生管理系统.xml"));
        /*利用此类进行写入*/
        Transformer transformer = TransformerFactory.newDefaultInstance().newTransformer();
        transformer.transform(domSource, streamResult);
    }
}
