package com.ivashkinigor.dialog.find;

import com.ivashkinigor.main.StudentTable;
import com.ivashkinigor.model.Model;
import com.ivashkinigor.model.Student;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;

public class FindDialogController {
    private FindDialogView findDialogView;
    private FindByCountOfBrothersAndSistersView findByCountOfBrothersAndSistersView;
    private FindByParentEarningView findByParentEarningView;
    private FindByParentNameView findByParentNameView;
    private FindByStudentNameView findByStudentNameView;
    private StudentTable studentTable;

    public FindDialogController(FindDialogView findDialogView,
                                FindByCountOfBrothersAndSistersView findByCountOfBrothersAndSistersView,
                                FindByParentEarningView findByParentEarningView,
                                FindByParentNameView findByParentNameView,
                                FindByStudentNameView findByStudentNameView,
                                StudentTable studentTable) {

        this.findDialogView = findDialogView;
        this.findByCountOfBrothersAndSistersView = findByCountOfBrothersAndSistersView;
        this.findByParentEarningView = findByParentEarningView;
        this.findByParentNameView = findByParentNameView;
        this.findByStudentNameView = findByStudentNameView;
        this.studentTable = studentTable;

        findDialogView.getJComboBoxForButtonFind().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int selectedIndex = findDialogView.getJComboBoxForButtonFind().getSelectedIndex();
                disableAllFrames();
                switch (selectedIndex){
                    case 0:
                        break;
                    case 1:
                        findByStudentNameView.setVisible(true);
                        break;
                    case 2:
                        findByParentNameView.setVisible(true);
                        break;
                    case 3:
                        findByCountOfBrothersAndSistersView.setVisible(true);
                        break;
                    case 4:
                        findByParentEarningView.setVisible(true);

                }

            }
        });
        findDialogView.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                disableAllFrames();
                findDialogView.setVisible(false);
            }
        });

    }

    private void disableAllFrames(){
        findByCountOfBrothersAndSistersView.setVisible(false);
        findByParentEarningView.setVisible(false);
        findByParentNameView.setVisible(false);
        findByStudentNameView.setVisible(false);
    }
}
