package com.IvashkinIgor.dialog.find;

import com.IvashkinIgor.model.Model;
import com.IvashkinIgor.model.Student;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class FindDialogController {
    private static FindDialogController findDialogController;

    private FindByCountOfBrothersAndSistersView findByCountOfBrothersAndSistersView;
    private FindByParentEarningView findByParentEarningView;
    private FindByParentNameView findByParentNameView;
    private FindByStudentNameView findByStudentNameView;

    public static FindDialogController getInstance(){
        if (findDialogController == null){
            findDialogController = new FindDialogController();
        }
        return findDialogController;
    }
    public FindDialogController() {
        FindDialogView findDialogView = FindDialogView.getInstance();
        ArrayList<Student> findStudentArrayList = Model.getInstance().getStudentArrayListForFind();

        findByCountOfBrothersAndSistersView = FindByCountOfBrothersAndSistersView.getInstance();
        findByParentEarningView = FindByParentEarningView.getInstance();
        findByParentNameView = FindByParentNameView.getInstance();
        findByStudentNameView = FindByStudentNameView.getInstance();


        findDialogView.setNumberOfRowsOnPageForFind(0);
        findDialogView.getJComboBoxForButtonFind().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int selectedIndex = findDialogView.getJComboBoxForButtonFind().getSelectedIndex();

                findDialogView.disableAllFindFrames();
                if (selectedIndex == 1) {
                    findByStudentNameView.setVisible(true);
                } else if (selectedIndex == 2) {
                    findByParentNameView.setVisible(true);
                } else if (selectedIndex == 3) {
                    findByCountOfBrothersAndSistersView.setVisible(true);
                } else if (selectedIndex == 4) {
                    findByParentEarningView.setVisible(true);
                }
                findDialogView.findFrameInformationUpdate();
            }
        });
        findDialogView.getJComboBoxForButtonFindRowsOnPage().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                findDialogView.setNumberOfRowsOnPageForFind(findDialogView.getJComboBoxForButtonFindRowsOnPage().getSelectedIndex());
                findDialogView.setCurrentPageNumberForFind(1);
                findDialogView.updateRowsOnPageFind();
                findDialogView.findFrameInformationUpdate();
            }
        });
        findDialogView.getJButtonForButtonFindNextPage().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (findDialogView.getNumberOfRowsOnPageForFind() * findDialogView.getCurrentPageNumberForFind() >= findStudentArrayList.size()) {
                    return;
                }
                findDialogView.setCurrentPageNumberForFind(findDialogView.getCurrentPageNumberForFind() + 1);
                findDialogView.updateRowsOnPageFind();
                findDialogView.findFrameInformationUpdate();
            }
        });
        findDialogView.getJButtonForButtonFindPreviousPage().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (findDialogView.getCurrentPageNumberForFind() <= 1) {
                    return;
                }
                findDialogView.setCurrentPageNumberForFind(findDialogView.getCurrentPageNumberForFind() - 1);
                findDialogView.updateRowsOnPageFind();
                findDialogView.findFrameInformationUpdate();
            }
        });
        findDialogView.getJButtonForButtonFindFirstPage().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                findDialogView.setCurrentPageNumberForFind(1);
                findDialogView.updateRowsOnPageFind();
                findDialogView.findFrameInformationUpdate();
            }
        });
        findDialogView.getJButtonForButtonFindLastPage().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                findDialogView.setCurrentPageNumberForFind(findDialogView.getTotalPagesForFind());
                findDialogView.updateRowsOnPageFind();
                findDialogView.findFrameInformationUpdate();
            }
        });

    }
}
