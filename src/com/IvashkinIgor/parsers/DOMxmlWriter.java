package com.IvashkinIgor.parsers;

import com.IvashkinIgor.model.Model;
import com.IvashkinIgor.model.Student;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.File;

public class DOMxmlWriter {
    public static void write(File path) {
        Model model = Model.getInstance();
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder;
        try {
            builder = factory.newDocumentBuilder();

            Document doc = builder.newDocument();
            Element rootElement =
                    doc.createElementNS(String.valueOf(path), "com.IvashkinIgor.model.Student");
            doc.appendChild(rootElement);



            for (int i = 0; i< model.getStudentArrayList().size(); i++){
                rootElement.appendChild(appendStudent(doc, model.getStudentArrayList().get(i)));
            }

            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();
            transformer.setOutputProperty(OutputKeys.INDENT, "yes");
            DOMSource source = new DOMSource(doc);


            StreamResult file = new StreamResult(new File(String.valueOf(path)));


            transformer.transform(source, file);


        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    private static Node appendStudent(Document doc, Student studentData) {
        Element student = doc.createElement("com.IvashkinIgor.model.Student");

        student.appendChild(studentElements(doc, student, "FIOStudent", studentData.getStudentName()));
        student.appendChild(studentElements(doc, student, "FIOFather", studentData.getFatherName()));
        student.appendChild(studentElements(doc, student, "fatherEarning", String.valueOf(studentData.getFatherEarnings())));
        student.appendChild(studentElements(doc, student, "FIOMother", studentData.getMotherName()));
        student.appendChild(studentElements(doc, student, "motherEarning", String.valueOf(studentData.getMotherEarnings())));
        student.appendChild(studentElements(doc, student, "numberOfBrothers", String.valueOf(studentData.getNumberOfBrothers())));
        student.appendChild(studentElements(doc, student, "numberOfSisters", String.valueOf(studentData.getNumberOfSisters())));


        return student;
    }


    private static Node studentElements(Document doc, Element element, String name, String value) {
        Element node = doc.createElement(name);
        node.appendChild(doc.createTextNode(value));
        return node;
    }
}
