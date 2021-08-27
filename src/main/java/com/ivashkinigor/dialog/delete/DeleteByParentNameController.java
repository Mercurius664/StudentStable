package com.ivashkinigor.dialog.delete;


import com.ivashkinigor.main.StudentTable;
import com.ivashkinigor.model.Model;
import com.ivashkinigor.utilities.Utilities;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DeleteByParentNameController {
    private DeleteByParentNameView deleteByParentNameView;

    public DeleteByParentNameController(DeleteByParentNameView deleteByParentNameView,
                                        StudentTable studentTable) {
        this.deleteByParentNameView = deleteByParentNameView;
        Model model = studentTable.getStudentModel();

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
                String fatherName = "";
                String motherName = "";
                if (deleteByParentNameView.getJRadioButtonFather().isSelected()&&
                deleteByParentNameView.getJRadioButtonMother().isSelected()){
                    fatherName = deleteByParentNameView.getJTextFieldFather().getText();
                    motherName = deleteByParentNameView.getJTextFieldMother().getText();
                    model.deleteByFatherAndMotherName(fatherName,motherName);
                }else if (deleteByParentNameView.getJRadioButtonFather().isSelected()){
                    fatherName = deleteByParentNameView.getJTextFieldFather().getText();
                    model.deleteByFatherName(fatherName);
                }else {
                    motherName = deleteByParentNameView.getJTextFieldMother().getText();
                    model.deleteByMotherName(motherName);
                }
            }
        });
    }

    private void updateJRadioButton(){
        
        Utilities.jRadioButtonCheck(deleteByParentNameView.getJRadioButtonFather(),
                deleteByParentNameView.getJRadioButtonMother(),
                deleteByParentNameView.getJTextFieldFather(),
                deleteByParentNameView.getJTextFieldMother());
    }

}
