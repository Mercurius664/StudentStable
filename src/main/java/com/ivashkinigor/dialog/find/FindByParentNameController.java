package com.ivashkinigor.dialog.find;

import com.ivashkinigor.main.StudentTable;
import com.ivashkinigor.model.Model;
import com.ivashkinigor.model.Student;
import com.ivashkinigor.utilities.Utilities;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class FindByParentNameController {

    private FindByParentNameView findByParentNameView;

    public FindByParentNameController(FindByParentNameView findByParentNameView,
                                      StudentTable studentTable) {
        this.findByParentNameView = findByParentNameView;
        Model model = studentTable.getStudentModel();
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
                List<Student> fatherNameList = null;
                List<Student> motherNameList = null;
                if (findByParentNameView.getJRadioButtonFatherEnable().isSelected()){
                    fatherNameList = model.filterByFatherName(findByParentNameView.getJTextFieldFatherForFindIndex2().getText());
                }
                if (findByParentNameView.getJRadioButtonMotherEnable().isSelected()){
                    motherNameList = model.filterByMotherName(findByParentNameView.getJTextFieldMotherForFindIndex2().getText());
                }
                if (fatherNameList != null && motherNameList != null){
                    fatherNameList.addAll(motherNameList);
                    studentTable.setWorkList(fatherNameList);
                }else if (fatherNameList!=null){
                    studentTable.setWorkList(fatherNameList);
                }else if (motherNameList!=null){
                    studentTable.setWorkList(motherNameList);
                }
            }
        });
    }

    private void jRadioButtonUpdate(){
        Utilities.jRadioButtonCheck(findByParentNameView.getJRadioButtonFatherEnable(), findByParentNameView.getJRadioButtonMotherEnable(),
                findByParentNameView.getJTextFieldFatherForFindIndex2(), findByParentNameView.getJTextFieldMotherForFindIndex2());
    }

}
