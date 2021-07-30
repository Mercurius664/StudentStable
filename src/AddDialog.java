import javax.swing.*;
import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.PlainDocument;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AddDialog extends JFrame {
    private static JPanel jPanelForAdd;
    private static JButton buttonSaveForAdd;
    private JTextField jTextFieldStudentName;
    private JTextField jTextFieldFatherName;
    private JTextField jTextFieldFatherEarning;
    private JTextField jTextFieldMotherName;
    private JTextField jTextFieldMotherEarning;
    private JTextField jTextFieldNumberOfBrothers;
    private JTextField jTextFieldNumberOfSisters;
    private Student student;

    AddDialog() {
        super();
        setVisible(true);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setTitle("Title");
        setLocationRelativeTo(null);
        setSize(655, 270);
        ImageIcon imageIcon = new ImageIcon("C:\\Users\\Igor\\Desktop\\книги\\!!!PROFILI!!!\\картинки\\avesta\\l3r1WDtOWio.jpg");
        setIconImage(imageIcon.getImage());
        initialize();

    }

    public Student getStudent() {
        return student;
    }

    private void initialize() {
        jPanelForAdd = new JPanel();
        add(jPanelForAdd);
        GridBagLayout gridBagLayout = new GridBagLayout();
        jPanelForAdd.setLayout(gridBagLayout);
        buttonSaveForAdd = new JButton("Save");

        jTextFieldStudentName = new JTextField();
        jTextFieldStudentName.setDocument(new JTextFieldFilter());

        jTextFieldFatherName = new JTextField();
        jTextFieldFatherName.setDocument(new JTextFieldFilter());

        jTextFieldFatherEarning = new JTextField();
        jTextFieldFatherEarning.setDocument(new JTextFieldFilterNumber());

        jTextFieldMotherName = new JTextField();
        jTextFieldMotherName.setDocument(new JTextFieldFilter());

        jTextFieldMotherEarning = new JTextField();
        jTextFieldMotherEarning.setDocument(new JTextFieldFilterNumber());

        jTextFieldNumberOfBrothers = new JTextField();
        jTextFieldNumberOfBrothers.setDocument(new JTextFieldFilterNumber());

        jTextFieldNumberOfSisters = new JTextField();
        jTextFieldNumberOfSisters.setDocument(new JTextFieldFilterNumber());


        JLabel jLabel1 = new JLabel("ФИО студента");
        JLabel jLabel2 = new JLabel("ФИО отца");
        JLabel jLabel3 = new JLabel("Заработок отца");
        JLabel jLabel4 = new JLabel("ФИО матери");
        JLabel jLabel5 = new JLabel("Заработок матери");
        JLabel jLabel6 = new JLabel("Число братьев");
        JLabel jLabel7 = new JLabel("Число сестёр");

        jPanelForAdd.add(jTextFieldStudentName, Constraints.getConstraintsForButtonAddForText1());
        jPanelForAdd.add(jTextFieldFatherName, Constraints.getConstraintsForButtonAddForText2());
        jPanelForAdd.add(jTextFieldFatherEarning, Constraints.getConstraintsForButtonAddForText3());
        jPanelForAdd.add(jTextFieldMotherName, Constraints.getConstraintsForButtonAddForText4());
        jPanelForAdd.add(jTextFieldMotherEarning, Constraints.getConstraintsForButtonAddForText5());
        jPanelForAdd.add(jTextFieldNumberOfBrothers, Constraints.getConstraintsForButtonAddForText6());
        jPanelForAdd.add(jTextFieldNumberOfSisters, Constraints.getConstraintsForButtonAddForText7());

        jPanelForAdd.add(jLabel1, Constraints.getConstraintsForButtonAddForJLabel1());
        jPanelForAdd.add(jLabel2, Constraints.getConstraintsForButtonAddForJLabel2());
        jPanelForAdd.add(jLabel3, Constraints.getConstraintsForButtonAddForJLabel3());
        jPanelForAdd.add(jLabel4, Constraints.getConstraintsForButtonAddForJLabel4());
        jPanelForAdd.add(jLabel5, Constraints.getConstraintsForButtonAddForJLabel5());
        jPanelForAdd.add(jLabel6, Constraints.getConstraintsForButtonAddForJLabel6());
        jPanelForAdd.add(jLabel7, Constraints.getConstraintsForButtonAddForJLabel7());

        jPanelForAdd.add(buttonSaveForAdd, Constraints.getConstraintsForButtonAddForJButtonSave());

        revalidate();

        buttonSaveForAdd.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String studentName;
                String fatherName;
                int fatherEarnings = 0;
                String motherName;
                int motherEarnings = 0;
                int numberOfBrothers = 0;
                int numberOfSisters = 0;
                boolean hasErrors = false;
                String errors = "";

                studentName = jTextFieldStudentName.getText().trim();
                if (studentName.isEmpty()) {
                    errors += "Неправильно введено поле: " + "ФИО студента" + "\n";
                    hasErrors = true;
                }
                fatherName = jTextFieldFatherName.getText().trim();
                if (fatherName.isEmpty()) {
                    errors += "Неправильно введено поле: " + "ФИО отца" + "\n";
                    hasErrors = true;
                }
                try {
                    fatherEarnings = Integer.parseInt(jTextFieldFatherEarning.getText());
                } catch (Exception exception) {
                    errors += "Неправильно введено поле: " + "Заработок отца" + "\n";
                    hasErrors = true;
                }
                motherName = jTextFieldMotherName.getText();
                if (motherName.isEmpty()) {
                    errors += "Неправильно введено поле: " + "ФИО матери" + "\n";
                    hasErrors = true;
                }
                try {
                    motherEarnings = Integer.parseInt(jTextFieldMotherEarning.getText());
                } catch (Exception exception) {
                    errors += "Неправильно введено поле: " + "Заработок матери" + "\n";
                    hasErrors = true;
                }
                try {
                    numberOfBrothers = Integer.parseInt(jTextFieldNumberOfBrothers.getText());
                } catch (Exception exception) {
                    errors += "Неправильно введено поле: " + "Число братьев" + "\n";
                    hasErrors = true;
                }
                try {
                    numberOfSisters = Integer.parseInt(jTextFieldNumberOfSisters.getText());
                } catch (Exception exception) {
                    errors += "Неправильно введено поле: " + "Число сестёр" + "\n";
                    hasErrors = true;
                }


                if (!hasErrors) {
                    student = new Student(studentName, fatherName, fatherEarnings, motherName, motherEarnings,
                            numberOfBrothers, numberOfSisters);
                    /////////////////////////////////////////
                    Model.getStudentArrayList().add(student);
                    View.updateJLabelNumbersOfRecords();
                    /////////////////////////////////////////
                } else {
                    JOptionPane.showMessageDialog(null, errors);
                }

            }


        });

    }

    static class JTextFieldFilter extends PlainDocument {
        @Override
        public void insertString(int offs, String str, AttributeSet a) throws BadLocationException {
            if (str == null) {
                return;
            }
            if (!str.matches("(.*)[a-zA-Zа-яА-Я](.*)") && !str.matches("\\s") ||
                    str.equals("")) {
                return;
            }
            if (str.matches("\\s") && this.getText(offs - 1, 1).matches("\\s")) {
                return;
            }
            super.insertString(offs, str, a);
        }
    }

    static class JTextFieldFilterNumber extends PlainDocument {
        @Override
        public void insertString(int offs, String str, AttributeSet a) throws BadLocationException {
            if (str == null) {
                return;
            }
            if (str.matches("(.*)[^0-9](.*)") || str.equals("")) {
                return;
            }
            super.insertString(offs, str, a);
        }
    }

}
