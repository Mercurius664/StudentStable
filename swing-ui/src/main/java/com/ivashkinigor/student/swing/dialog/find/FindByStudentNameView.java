package com.ivashkinigor.student.swing.dialog.find;

import com.ivashkinigor.student.swing.dialog.main.StudentTable;

import javax.swing.*;
import java.awt.*;

public class FindByStudentNameView extends JFrame{

    private JPanel jPanelForFindIndex1;
    private JLabel jLabelForFindIndex1;
    private JTextField jTextFieldForFindIndex1;
    private JButton jButtonForFindIndex1;
    private StudentTable studentTable;

    public JButton getJButtonForFindIndex1() {
        return jButtonForFindIndex1;
    }

    public JTextField getJTextFieldForFindIndex1() {
        return jTextFieldForFindIndex1;
    }

    public FindByStudentNameView(StudentTable studentTable) {
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
        jPanelForFindIndex1 = new JPanel();
        GridBagLayout gridBagLayout = new GridBagLayout();
        jPanelForFindIndex1.setLayout(gridBagLayout);

        jLabelForFindIndex1 = new JLabel("Введите ФИО студента:");
        jTextFieldForFindIndex1 = new JTextField();
        jButtonForFindIndex1 = new JButton("Find");

        add(jPanelForFindIndex1);
        jPanelForFindIndex1.add(jLabelForFindIndex1, FindByStudentNameConstraints.getConstraintsForButtonFindSearchStudentJLabel());
        jPanelForFindIndex1.add(jTextFieldForFindIndex1, FindByStudentNameConstraints.getConstraintsForButtonFindSearchStudentTextField());
        jPanelForFindIndex1.add(jButtonForFindIndex1, FindByStudentNameConstraints.getConstraintsForButtonFindSearchStudentButton());

        new FindByStudentNameController(this,studentTable);
    }
}
