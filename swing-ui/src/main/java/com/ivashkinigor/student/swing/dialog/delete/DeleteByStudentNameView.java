package com.ivashkinigor.student.swing.dialog.delete;

import com.ivashkinigor.student.swing.dialog.main.StudentTable;

import javax.swing.*;
import java.awt.*;

public class DeleteByStudentNameView extends JFrame {
    private JPanel jPanelForDeleteIndex1;
    private JLabel jLabelForDeleteIndex1;
    private JTextField jTextFieldForDeleteIndex1;
    private JButton jButtonForDeleteIndex1;
    private StudentTable studentTable;

    public  JButton getJButtonForDeleteIndex1() {
        return jButtonForDeleteIndex1;
    }

    public  JTextField getJTextFieldForDeleteIndex1() {
        return jTextFieldForDeleteIndex1;
    }

    public DeleteByStudentNameView(StudentTable studentTable) {
        super();
        setVisible(false);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setTitle("Title");
        setLocationRelativeTo(null);
        setSize(655, 270);
        ImageIcon imageIcon = new ImageIcon("C:\\Users\\Igor\\Desktop\\книги\\!!!PROFILI!!!\\картинки\\avesta\\l3r1WDtOWio.jpg");
        setIconImage(imageIcon.getImage());
        this.studentTable = studentTable;
        initialize();
    }

    public void initialize(){
        jPanelForDeleteIndex1 = new JPanel();
        GridBagLayout gridBagLayout = new GridBagLayout();
        jPanelForDeleteIndex1.setLayout(gridBagLayout);

        jLabelForDeleteIndex1 = new JLabel("Введите ФИО студента:");
        jTextFieldForDeleteIndex1 = new JTextField();
        jButtonForDeleteIndex1 = new JButton("Delete");

        add(jPanelForDeleteIndex1);
        jPanelForDeleteIndex1.add(jLabelForDeleteIndex1, DeleteByStudentNameConstraints.getConstraintsForButtonFindSearchStudentJLabel());
        jPanelForDeleteIndex1.add(jTextFieldForDeleteIndex1, DeleteByStudentNameConstraints.getConstraintsForButtonFindSearchStudentTextField());
        jPanelForDeleteIndex1.add(jButtonForDeleteIndex1, DeleteByStudentNameConstraints.getConstraintsForButtonFindSearchStudentButton());

        new DeleteByStudentNameController(this,studentTable.getStudentModel());
    }
}
