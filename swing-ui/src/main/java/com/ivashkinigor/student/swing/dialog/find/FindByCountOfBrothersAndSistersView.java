package com.ivashkinigor.student.swing.dialog.find;

import com.ivashkinigor.student.swing.dialog.main.StudentTable;

import javax.swing.*;
import java.awt.*;

public class FindByCountOfBrothersAndSistersView extends JFrame{

    private JPanel jPanelForFindIndex3;
    private JLabel jLabelBrotherForFindIndex3;
    private JLabel jLabelSisterForFindIndex3;
    private JTextField jTextFieldBrotherForFindIndex3;
    private JTextField jTextFieldFSisterForFindIndex3;
    private JButton jButtonForFindIndex3;
    private JRadioButton jRadioButtonBrotherEnable;
    private JRadioButton jRadioButtonSisterEnable;
    private StudentTable studentTable;

    public  JRadioButton getJRadioButtonSisterEnable() {
        return jRadioButtonSisterEnable;
    }

    public  JRadioButton getJRadioButtonBrotherEnable() {
        return jRadioButtonBrotherEnable;
    }

    public  JButton getJButtonForFindIndex3() {
        return jButtonForFindIndex3;
    }

    public  JTextField getJTextFieldFSisterForFindIndex3() {
        return jTextFieldFSisterForFindIndex3;
    }

    public  JTextField getJTextFieldBrotherForFindIndex3() {
        return jTextFieldBrotherForFindIndex3;
    }



    public FindByCountOfBrothersAndSistersView(StudentTable studentTable) {
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
        jPanelForFindIndex3 = new JPanel();
        GridBagLayout gridBagLayout = new GridBagLayout();
        jPanelForFindIndex3.setLayout(gridBagLayout);
        add(jPanelForFindIndex3);

        jLabelBrotherForFindIndex3 = new JLabel("Введите число братьев");
        jLabelSisterForFindIndex3 = new JLabel("Введите число сестер");
        jTextFieldBrotherForFindIndex3 = new JTextField();
        jTextFieldFSisterForFindIndex3 = new JTextField();
        jButtonForFindIndex3 = new JButton("Find");
        jRadioButtonBrotherEnable = new JRadioButton("Ввести число братьев");
        jRadioButtonSisterEnable = new JRadioButton("Ввести число сестер");


        jPanelForFindIndex3.add(jRadioButtonBrotherEnable, FindByCountOfBrothersAndSistersConstraints.getConstraintsForButtonFindJRadioButtonIsMotherEditableForFindIndex2());
        jPanelForFindIndex3.add(jRadioButtonSisterEnable, FindByCountOfBrothersAndSistersConstraints.getConstraintsForButtonFindJRadioButtonIsFatherEditableForFindIndex2());
        jPanelForFindIndex3.add(jLabelBrotherForFindIndex3, FindByCountOfBrothersAndSistersConstraints.getConstraintsForButtonFindJLabelMotherForFindIndex2());
        jPanelForFindIndex3.add(jLabelSisterForFindIndex3, FindByCountOfBrothersAndSistersConstraints.getConstraintsForButtonFindJLabelFatherForFindIndex2());
        jPanelForFindIndex3.add(jTextFieldBrotherForFindIndex3, FindByCountOfBrothersAndSistersConstraints.getConstraintsForButtonFindJTextFieldMotherForFindIndex2());
        jPanelForFindIndex3.add(jTextFieldFSisterForFindIndex3, FindByCountOfBrothersAndSistersConstraints.getConstraintsForButtonFindJTextFieldFatherForFindIndex2());
        jPanelForFindIndex3.add(jButtonForFindIndex3, FindByCountOfBrothersAndSistersConstraints.getConstraintsForButtonFindJButtonForFindIndex2());



        jRadioButtonBrotherEnable.setSelected(true);
        jTextFieldFSisterForFindIndex3.setEditable(false);
        jTextFieldFSisterForFindIndex3.setBackground(this.getBackground());

        new FindByCountOfBrothersAndSistersController(this,studentTable.getStudentModel());
    }

}
