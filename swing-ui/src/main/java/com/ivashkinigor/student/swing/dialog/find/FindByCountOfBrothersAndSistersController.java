package com.ivashkinigor.student.swing.dialog.find;

import com.ivashkinigor.student.model.Model;
import com.ivashkinigor.student.swing.dialog.main.StudentTable;
import com.ivashkinigor.student.swing.utilities.Utilities;

import com.ivashkinigor.student.model.Student;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class FindByCountOfBrothersAndSistersController {
    private final String ERROR_MESSAGE = "input error in the field: ";
    private Model model;
    private FindByCountOfBrothersAndSistersView findByCountOfBrothersAndSistersView;
    private StudentTable studentTable;

    public FindByCountOfBrothersAndSistersController(FindByCountOfBrothersAndSistersView findByCountOfBrothersAndSistersView,
                                                     Model model) {
        this.findByCountOfBrothersAndSistersView = findByCountOfBrothersAndSistersView;


        findByCountOfBrothersAndSistersView.getJRadioButtonSisterEnable().addActionListener(e -> updateJRadioButton());
        findByCountOfBrothersAndSistersView.getJRadioButtonBrotherEnable().addActionListener(e -> updateJRadioButton());
        findByCountOfBrothersAndSistersView.getJButtonForFindIndex3().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                List<Student> studentList;
                if (findByCountOfBrothersAndSistersView.getJRadioButtonBrotherEnable().isSelected() &&
                findByCountOfBrothersAndSistersView.getJRadioButtonSisterEnable().isSelected()){
                    int brotherCount= brothersCountParse();
                    int sisterCount= sistersCountParse();
                    if (brotherCount == -1 || sisterCount == -1){
                        return;
                    }
                    studentList = model.filterByBrothersAndSistersCount(brotherCount,sisterCount);
                }else if (findByCountOfBrothersAndSistersView.getJRadioButtonBrotherEnable().isSelected()){
                    int brotherCount= brothersCountParse();
                    if (brotherCount == -1){
                        return;
                    }
                    studentList = model.filterByNumberOfBrother(brotherCount);
                }else{
                    int sisterCount= sistersCountParse();
                    if (sisterCount == -1){
                        return;
                    }
                    studentList = model.filterByNumberOfSister(sisterCount);
                }
                studentTable.setWorkList(studentList);
            }



        });
    }

    private int brothersCountParse(){
        int brotherCount = -1;
        try {
            brotherCount = Integer.parseInt(findByCountOfBrothersAndSistersView.getJTextFieldBrotherForFindIndex3().getText());
        }catch (Exception exception){
            JOptionPane.showMessageDialog(null,ERROR_MESSAGE + "enter the number of brothers");
        }
        return brotherCount;
    }

    private int sistersCountParse(){
        int sisterCount = -1;
        try {
            sisterCount = Integer.parseInt(findByCountOfBrothersAndSistersView.getJTextFieldFSisterForFindIndex3().getText());
        }catch (Exception exception){
            JOptionPane.showMessageDialog(null,ERROR_MESSAGE + "enter the number of sisters");
        }
        return sisterCount;
    }

    private void updateJRadioButton(){
        Utilities.jRadioButtonCheck(findByCountOfBrothersAndSistersView.getJRadioButtonSisterEnable(),
                findByCountOfBrothersAndSistersView.getJRadioButtonBrotherEnable(),
                findByCountOfBrothersAndSistersView.getJTextFieldFSisterForFindIndex3(),
                findByCountOfBrothersAndSistersView.getJTextFieldBrotherForFindIndex3());
    }
}
