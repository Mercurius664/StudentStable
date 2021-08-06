package com.IvashkinIgor.parsers;

import com.IvashkinIgor.model.Model;
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
                rootElement.appendChild(getStudent(doc, model.getStudentArrayList().get(i).getStudentName(), model.getStudentArrayList().get(i).getFatherName(),
                        model.getStudentArrayList().get(i).getFatherEarnings(), model.getStudentArrayList().get(i).getMotherName(), model.getStudentArrayList().get(i).getMotherEarnings(),
                        model.getStudentArrayList().get(i).getNumberOfBrothers(), model.getStudentArrayList().get(i).getNumberOfSisters()));
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


    private static Node getStudent(Document doc, String FIOStudent, String FIOFather,
                                   int fatherEarning, String FIOMother, int motherEarning,
                                   int numberOfBrothers, int numberOfSisters) {
        Element student = doc.createElement("com.IvashkinIgor.model.Student");


        student.appendChild(getStudentElements(doc, student, "FIOStudent", FIOStudent));
        student.appendChild(getStudentElements(doc, student, "FIOFather", FIOFather));
        student.appendChild(getStudentElements(doc, student, "fatherEarning", String.valueOf(fatherEarning)));
        student.appendChild(getStudentElements(doc, student, "FIOMother", FIOMother));
        student.appendChild(getStudentElements(doc, student, "motherEarning", String.valueOf(motherEarning)));
        student.appendChild(getStudentElements(doc, student, "numberOfBrothers", String.valueOf(numberOfBrothers)));
        student.appendChild(getStudentElements(doc, student, "numberOfSisters", String.valueOf(numberOfSisters)));


        return student;
    }


    private static Node getStudentElements(Document doc, Element element, String name, String value) {
        Element node = doc.createElement(name);
        node.appendChild(doc.createTextNode(value));
        return node;
    }
}
