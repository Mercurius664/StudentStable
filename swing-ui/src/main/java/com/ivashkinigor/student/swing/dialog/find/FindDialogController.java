package com.ivashkinigor.student.swing.dialog.find;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class FindDialogController {

    private FindByCountOfBrothersAndSistersView findByCountOfBrothersAndSistersView;
    private FindByParentEarningView findByParentEarningView;
    private FindByParentNameView findByParentNameView;
    private FindByStudentNameView findByStudentNameView;


        public FindDialogController(FindDialogView findDialogView,
                                FindByCountOfBrothersAndSistersView findByCountOfBrothersAndSistersView,
                                FindByParentEarningView findByParentEarningView,
                                FindByParentNameView findByParentNameView,
                                FindByStudentNameView findByStudentNameView) {


        this.findByCountOfBrothersAndSistersView = findByCountOfBrothersAndSistersView;
        this.findByParentEarningView = findByParentEarningView;
        this.findByParentNameView = findByParentNameView;
        this.findByStudentNameView = findByStudentNameView;




        findDialogView.getJComboBoxForButtonFind().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int selectedIndex = findDialogView.getJComboBoxForButtonFind().getSelectedIndex();
                disableAllFindFrames();
                switch (selectedIndex){
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
                disableAllFindFrames();
                findDialogView.getJComboBoxForButtonFind().setSelectedIndex(0);
            }
        });

    }

    public void disableAllFindFrames() {
        findByCountOfBrothersAndSistersView.setVisible(false);
        findByParentEarningView.setVisible(false);
        findByParentNameView.setVisible(false);
        findByStudentNameView.setVisible(false);
    }


}
