package com.IvashkinIgor.dialog.find;

import com.IvashkinIgor.model.Model;
import com.IvashkinIgor.model.Student;
import com.IvashkinIgor.utilities.Utilities;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class FindByStudentNameController {
    private static FindByStudentNameController findByStudentNameController;

    public static FindByStudentNameController getInstance() {
        if (findByStudentNameController == null){
            findByStudentNameController = new FindByStudentNameController();
        }
        return findByStudentNameController;
    }
    private FindByStudentNameController() {
        FindByStudentNameView findByStudentNameView = FindByStudentNameView.getInstance();
        FindDialogView findDialogView = FindDialogView.getInstance();
        ArrayList<Student> studentArrayList = Model.getInstance().getStudentArrayList();
        ArrayList<Student> findStudentArrayList = Model.getInstance().getStudentArrayListForFind();
        
        findByStudentNameView.getJButtonForFindIndex1().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                findDialogView.setCurrentPageNumberForFind(1);
                Utilities.removeAllJTableElements(findDialogView.getDefaultTableModelForButtonFind());

                String jTextFiendContent = findByStudentNameView.getJTextFieldForFindIndex1().getText();
                for (int i = 0; i < studentArrayList.size(); i++) {
                    if (studentArrayList.get(i).getStudentName().contains(jTextFiendContent)) {
                        findStudentArrayList.add(studentArrayList.get(i));
                        findDialogView.findFrameInformationUpdate();
                        if (findDialogView.getNumberOfRowsOnPageForFind()<= i) {
                            continue;
                        }
                        Utilities.jTableUpdate(findDialogView.getDefaultTableModelForButtonFind(), findDialogView.getJTableForButtonFind(),
                                findDialogView.getJPanelForFind(), findStudentArrayList);
                    }
                }

                findDialogView.findFrameInformationUpdate();
            }
        });
    }
}
