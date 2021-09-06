package com.ivashkinigor.dialog.find;

import com.ivashkinigor.main.StudentTable;
import com.ivashkinigor.model.Model;
import com.ivashkinigor.model.Student;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;

public class FindDialogView extends JFrame {

    private JPanel jPanelForFind;
    private JComboBox jComboBoxForButtonFind = new JComboBox(new String[]{" ", "ФИО студента", "ФИО одного из родителей", "по числу братьев или сестер", "по размеру заработка одного из родителей"});


    private JComboBox jComboBoxForButtonFindRowsOnPage;

    private FindByCountOfBrothersAndSistersView findByCountOfBrothersAndSistersView;
    private FindByParentEarningView findByParentEarningView;
    private FindByParentNameView findByParentNameView;
    private FindByStudentNameView findByStudentNameView;
    private StudentTable studentTable;


    public JComboBox getJComboBoxForButtonFind() {
        return jComboBoxForButtonFind;
    }

    public FindDialogView(StudentTable studentTable) {
        super();
        setVisible(true);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setTitle("Title");
        setLocationRelativeTo(null);
        ImageIcon imageIcon = new ImageIcon("C:\\Users\\Igor\\Desktop\\книги\\!!!PROFILI!!!\\картинки\\avesta\\l3r1WDtOWio.jpg");
        setIconImage(imageIcon.getImage());
        this.studentTable = studentTable;
        initialize();
    }

    private void initialize(){
        jPanelForFind = new JPanel();
        add(jPanelForFind);
        jComboBoxForButtonFindRowsOnPage = new JComboBox(new String[]{"0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10"});
        jPanelForFind.add(jComboBoxForButtonFind);
        jPanelForFind.revalidate();

        findByCountOfBrothersAndSistersView = new FindByCountOfBrothersAndSistersView(studentTable);
        findByParentEarningView = new FindByParentEarningView(studentTable);
        findByParentNameView = new FindByParentNameView(studentTable);
        findByStudentNameView = new FindByStudentNameView(studentTable);


        new FindDialogController(this,
                findByCountOfBrothersAndSistersView,
                findByParentEarningView,
                findByParentNameView,
                findByStudentNameView);
    }

}
