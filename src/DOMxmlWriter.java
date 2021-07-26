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
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder;
        try {
            builder = factory.newDocumentBuilder();

            Document doc = builder.newDocument();
            Element rootElement =
                    doc.createElementNS(String.valueOf(path), "Student");
            doc.appendChild(rootElement);



            for (int i=0; i<Model.getStudentArrayList().size(); i++){
                rootElement.appendChild(getStudent(doc,Model.getStudentArrayList().get(i).getStudentName(),Model.getStudentArrayList().get(i).getFatherName(),
                        Model.getStudentArrayList().get(i).getFatherEarnings(),Model.getStudentArrayList().get(i).getMotherName(),Model.getStudentArrayList().get(i).getMotherEarnings(),
                        Model.getStudentArrayList().get(i).getNumberOfBrothers(),Model.getStudentArrayList().get(i).getNumberOfSisters()));
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
        Element student = doc.createElement("Student");


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
