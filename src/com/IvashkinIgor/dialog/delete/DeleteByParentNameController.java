package com.IvashkinIgor.dialog.delete;


import com.IvashkinIgor.main.MainDialogController;
import com.IvashkinIgor.model.Model;
import com.IvashkinIgor.model.Student;
import com.IvashkinIgor.utilities.Utilities;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class DeleteByParentNameController {
    private static DeleteByParentNameController deleteByParentNameController;


    public static DeleteByParentNameController getInstance(){
        if (deleteByParentNameController == null){
            deleteByParentNameController = new DeleteByParentNameController();
        }
        return deleteByParentNameController;
    }


    private DeleteByParentNameController() {
        DeleteByParentNameView deleteByParentNameView = DeleteByParentNameView.getInstance();
        ArrayList<Student> studentArrayList = Model.getInstance().getStudentArrayList();
        
        deleteByParentNameView.getJRadioButtonFather().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                updateJRadioButton();
            }
        });
        deleteByParentNameView.getJRadioButtonMother().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                updateJRadioButton();
            }
        });

        deleteByParentNameView.getJButtonDelete().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                if (!deleteByParentNameView.getJRadioButtonMother().isSelected() && 
                        !deleteByParentNameView.getJRadioButtonFather().isSelected()) {
                    return;
                } else if (deleteByParentNameView.getJRadioButtonMother().isSelected() &&
                        deleteByParentNameView.getJRadioButtonFather().isSelected()) {
                    ArrayList<Student> arrayListDelete = new ArrayList<>();
                    String jTextFiendContent1 = deleteByParentNameView.getJTextFieldMother().getText();
                    String jTextFiendContent2 = deleteByParentNameView.getJTextFieldFather().getText();
                    if (jTextFiendContent1.equals("") || jTextFiendContent2.equals("")) {
                        return;
                    }
                    for (int i = 0; i < studentArrayList.size(); i++) {

                        if (studentArrayList.get(i).getMotherName().contains(jTextFiendContent1) && studentArrayList.get(i).getFatherName().contains(jTextFiendContent2)) {
                            arrayListDelete.add(studentArrayList.get(i));
                        }
                    }
                    for (int i = 0; i < arrayListDelete.size(); i++) {
                        studentArrayList.remove(arrayListDelete.get(i));
                    }
                    JOptionPane.showMessageDialog(null, "Удалено " + arrayListDelete.size() + " записей");
                } else if (deleteByParentNameView.getJRadioButtonMother().isSelected()) {
                    ArrayList<Student> arrayListDelete = new ArrayList<>();
                    String jTextFiendContent = deleteByParentNameView.getJTextFieldMother().getText();
                    for (int i = 0; i < studentArrayList.size(); i++) {
                        if (studentArrayList.get(i).getMotherName().contains(jTextFiendContent)) {
                            arrayListDelete.add(studentArrayList.get(i));

                        }
                    }
                    for (int i = 0; i < arrayListDelete.size(); i++) {
                        studentArrayList.remove(arrayListDelete.get(i));
                    }
                    JOptionPane.showMessageDialog(null, "Удалено " + arrayListDelete.size() + " записей");
                } else if (deleteByParentNameView.getJRadioButtonFather().isSelected()) {
                    ArrayList<Student> arrayListDelete = new ArrayList<>();
                    String jTextFiendContent = deleteByParentNameView.getJTextFieldFather().getText();
                    for (int i = 0; i < studentArrayList.size(); i++) {
                        if (studentArrayList.get(i).getFatherName().contains(jTextFiendContent)) {
                            arrayListDelete.add(studentArrayList.get(i));

                        }
                    }
                    for (int i = 0; i < arrayListDelete.size(); i++) {
                        studentArrayList.remove(arrayListDelete.get(i));
                    }
                    JOptionPane.showMessageDialog(null, "Удалено " + arrayListDelete.size() + " записей");

                }
                MainDialogController.getInstance().updateNumberInformation();
            }
        });
    }
    
    private void updateJRadioButton(){
        DeleteByParentNameView valueVariables = DeleteByParentNameView.getInstance();
        
        Utilities.jRadioButtonCheck(valueVariables.getJRadioButtonFather(),
                valueVariables.getJRadioButtonMother(),
                valueVariables.getJTextFieldFather(),
                valueVariables.getJTextFieldMother());
    }

}
