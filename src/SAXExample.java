import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class SAXExample {
    private static ArrayList<Student> students = new ArrayList<>();

    public static void read(File path) throws ParserConfigurationException, SAXException, IOException {
        SAXParserFactory factory = SAXParserFactory.newInstance();
        SAXParser parser = factory.newSAXParser();

        AdvancedXMLHandler handler = new AdvancedXMLHandler();
        parser.parse(path, handler);


        Model.getStudentArrayList().clear();
        Model.getStudentArrayList().addAll(students);

    }

    private static class AdvancedXMLHandler extends DefaultHandler {
        private String FIOStudent;
        private String FIOFather;
        private String fatherEarning;
        private String FIOMother;
        private String motherEarning;
        private String numberOfBrothers;
        private String numberOfSisters;
        private String lastElementName;

        @Override
        public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
            lastElementName = qName;
        }

        @Override
        public void characters(char[] ch, int start, int length) throws SAXException {
            String information = new String(ch, start, length);

            information = information.replace("\n", "").trim();

            if (!information.isEmpty()) {
                if (lastElementName.equals("FIOStudent"))
                    FIOStudent = information;
                if (lastElementName.equals("FIOFather"))
                    FIOFather = information;
                if (lastElementName.equals("fatherEarning"))
                    fatherEarning = information;
                if (lastElementName.equals("FIOMother"))
                    FIOMother = information;
                if (lastElementName.equals("motherEarning"))
                    motherEarning = information;
                if (lastElementName.equals("numberOfBrothers"))
                    numberOfBrothers = information;
                if (lastElementName.equals("numberOfSisters"))
                    numberOfSisters = information;

            }
        }

        @Override
        public void endElement(String uri, String localName, String qName) throws SAXException {
            if ( (FIOStudent != null && !FIOStudent.isEmpty()) &&
                    (FIOFather != null && !FIOFather.isEmpty()) &&
                    (fatherEarning != null && !fatherEarning.isEmpty()) &&
                    (FIOMother != null && !FIOMother.isEmpty())&&
                    (motherEarning != null && !motherEarning.isEmpty()) &&
                    (numberOfBrothers != null && !numberOfBrothers.isEmpty())&&
                    (numberOfSisters != null && !numberOfSisters.isEmpty())) {
                students.add(new Student(FIOStudent,FIOFather,Integer.parseInt(fatherEarning),FIOMother,Integer.parseInt(motherEarning),
                        Integer.parseInt(numberOfBrothers),Integer.parseInt(numberOfBrothers)));
                FIOStudent = null;
                FIOFather = null;
                fatherEarning = null;
                FIOMother = null;
                motherEarning = null;
                numberOfBrothers = null;
                numberOfSisters = null;
            }
        }
    }
}
