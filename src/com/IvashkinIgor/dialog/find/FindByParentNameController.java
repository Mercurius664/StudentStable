package com.IvashkinIgor.dialog.find;

import com.IvashkinIgor.model.Model;
import com.IvashkinIgor.model.Student;
import com.IvashkinIgor.utilities.Utilities;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class FindByParentNameController {
    private static FindByParentNameController findByParentNameController;



    public static FindByParentNameController getInstance() {
        if (findByParentNameController == null){
            findByParentNameController = new FindByParentNameController();
        }
        return findByParentNameController;
    }

    private FindByParentNameController() {
        FindByParentNameView findByParentNameView = FindByParentNameView.getInstance();
        FindDialogView findDialogView = FindDialogView.getInstance();
        ArrayList<Student> findStudentArrayList = Model.getInstance().getStudentArrayListForFind();
        ArrayList<Student> studentArrayList = Model.getInstance().getStudentArrayList();
        
        findByParentNameView.getJRadioButtonFatherEnable().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                jRadioButtonUpdate();
            }
        });
        findByParentNameView.getJRadioButtonMotherEnable().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                jRadioButtonUpdate();
            }
        });
        findByParentNameView.getJButtonForFindIndex2().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                findDialogView.setCurrentPageNumberForFind(1);
                Utilities.removeAllJTableElements(findDialogView.getDefaultTableModelForButtonFind());
                int studentArrayListForFindSize = findStudentArrayList.size();
                for (int i = 0; i < studentArrayListForFindSize; i++) {
                    findStudentArrayList.remove(0);
                }


                if (!findByParentNameView.getJRadioButtonMotherEnable().isSelected() &&
                        !findByParentNameView.getJRadioButtonFatherEnable().isSelected()) {
                    return;
                } else if (findByParentNameView.getJRadioButtonMotherEnable().isSelected() &&
                        findByParentNameView.getJRadioButtonFatherEnable().isSelected()) {
                    String jTextFiendContent1 = findByParentNameView.getJTextFieldMotherForFindIndex2().getText();
                    String jTextFiendContent2 = findByParentNameView.getJTextFieldFatherForFindIndex2().getText();
                    if (jTextFiendContent1.equals("") || jTextFiendContent2.equals("")) {
                        return;
                    }
                    for (int i = 0; i < studentArrayList.size(); i++) {

                        if (studentArrayList.get(i).getMotherName().contains(jTextFiendContent1) && studentArrayList.get(i).getFatherName().contains(jTextFiendContent2)) {
                            findStudentArrayList.add(studentArrayList.get(i));
                            findDialogView.findFrameInformationUpdate();
                            if (findDialogView.getNumberOfRowsOnPageForFind()<= i) {
                                continue;
                            }
                            Utilities.jTableUpdate(findDialogView.getDefaultTableModelForButtonFind(), findDialogView.getJTableForButtonFind(), findDialogView.getJPanelForFind(), findStudentArrayList);
                        }
                    }
                } else if (findByParentNameView.getJRadioButtonMotherEnable().isSelected()) {
                    String jTextFiendContent = findByParentNameView.getJTextFieldMotherForFindIndex2().getText();
                    for (int i = 0; i < studentArrayList.size(); i++) {
                        if (studentArrayList.get(i).getMotherName().contains(jTextFiendContent)) {
                            findStudentArrayList.add(studentArrayList.get(i));
                            findDialogView.findFrameInformationUpdate();
                            if (findDialogView.getNumberOfRowsOnPageForFind()<= i) {
                                continue;
                            }
                            Utilities.jTableUpdate(findDialogView.getDefaultTableModelForButtonFind(), findDialogView.getJTableForButtonFind(), findDialogView.getJPanelForFind(), findStudentArrayList);
                        }
                    }
                } else if (findByParentNameView.getJRadioButtonFatherEnable().isSelected()) {
                    String jTextFiendContent = findByParentNameView.getJTextFieldFatherForFindIndex2().getText();
                    for (int i = 0; i < studentArrayList.size(); i++) {
                        if (studentArrayList.get(i).getFatherName().contains(jTextFiendContent)) {
                            findStudentArrayList.add(studentArrayList.get(i));
                            findDialogView.findFrameInformationUpdate();
                            if (findDialogView.getNumberOfRowsOnPageForFind()<= i) {
                                continue;
                            }
                            Utilities.jTableUpdate(findDialogView.getDefaultTableModelForButtonFind(), findDialogView.getJTableForButtonFind(), findDialogView.getJPanelForFind(), findStudentArrayList);
                        }
                    }
                }
                findDialogView.findFrameInformationUpdate();
            }
        });
    }

    private void jRadioButtonUpdate(){
        FindByParentNameView findByParentNameView = FindByParentNameView.getInstance();
        Utilities.jRadioButtonCheck(findByParentNameView.getJRadioButtonFatherEnable(), findByParentNameView.getJRadioButtonMotherEnable(),
                findByParentNameView.getJTextFieldFatherForFindIndex2(), findByParentNameView.getJTextFieldMotherForFindIndex2());
    }

}
