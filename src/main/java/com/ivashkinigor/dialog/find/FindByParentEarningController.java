package com.ivashkinigor.dialog.find;

import com.ivashkinigor.main.StudentTable;
import com.ivashkinigor.model.Model;
import com.ivashkinigor.model.Student;
import com.ivashkinigor.utilities.Utilities;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class FindByParentEarningController {
    private final String ERROR_MESSAGE = "input error in the field:\n";

    private FindByParentEarningView findByParentEarningView;


    public FindByParentEarningController(FindByParentEarningView findByParentEarningView,
                                         StudentTable studentTable) {
        this.findByParentEarningView = findByParentEarningView;
        Model model = studentTable.getStudentModel();

        findByParentEarningView.getJRadioButtonFatherMoneyEnable().addActionListener(e -> jRadioButtonUpdate());
        findByParentEarningView.getJRadioButtonMotherMoneyEnable().addActionListener(e -> jRadioButtonUpdate());
        findByParentEarningView.getJButtonForFindIndex4().addActionListener(new ActionListener() {
            private boolean errors = false;
            private String errorsText="";
            @Override
            public void actionPerformed(ActionEvent e) {
                int fatherEarningFrom;
                int fatherEarningTo;
                int motherEarningFrom;
                int motherEarningTo;
                List<Student> fatherList = null;
                List<Student> motherList = null;
                errors = false;
                errorsText="";


                if (findByParentEarningView.getJRadioButtonFatherMoneyEnable().isSelected()){
                    fatherEarningFrom = fatherEarningFromParse();
                    fatherEarningTo = fatherEarningToParse();
                    fatherList = model.filterByFatherEarning(fatherEarningFrom,fatherEarningTo);
                }
                if (findByParentEarningView.getJRadioButtonMotherMoneyEnable().isSelected()){
                    motherEarningFrom = motherEarningFromParse();
                    motherEarningTo = motherEarningToParse();
                    motherList = model.filterByMotherEarning(motherEarningFrom,motherEarningTo);
                }
                if (errors){
                    JOptionPane.showMessageDialog(null,errorsText);
                    return;
                }
                if (fatherList!=null && motherList !=null){
                    studentTable.setWorkList(model.filterByParentEarning(fatherList,motherList));
                }else if (fatherList !=null){
                    studentTable.setWorkList(fatherList);
                }else if (motherList !=null){
                    studentTable.setWorkList(motherList);
                }

            }

            private int fatherEarningFromParse(){
                int earning = 0;
                try {
                    earning = Integer.parseInt(findByParentEarningView.getJTextFieldFatherMinForFindIndex4().getText());
                }catch (Exception exception){
                    if (!findByParentEarningView.getJTextFieldFatherMinForFindIndex4().getText().equals("")){
                        errors = true;
                        errorsText += ERROR_MESSAGE + "enter the father earning from\n";
                    }
                }
                return earning;
            }
            private int fatherEarningToParse(){
                int earning = Integer.MAX_VALUE;
                try {
                    earning = Integer.parseInt(findByParentEarningView.getJTextFieldFatherMaxForFindIndex4().getText());
                }catch (Exception exception){
                    if (findByParentEarningView.getJTextFieldFatherMaxForFindIndex4().getText().equals("")) {
                        errors = true;
                        errorsText += ERROR_MESSAGE + "enter the father earning to\n";
                    }
                }
                return earning;
            }
            private int motherEarningFromParse(){
                int earning = 0;
                try {
                    earning = Integer.parseInt(findByParentEarningView.getJTextFieldMotherMinForFindIndex4().getText());
                }catch (Exception exception){
                    if (findByParentEarningView.getJTextFieldMotherMinForFindIndex4().getText().equals("")) {
                        errors = true;
                        errorsText += ERROR_MESSAGE + "enter the mother earning from\n";
                    }
                }
                return earning;
            }
            private int motherEarningToParse(){
                int earning = Integer.MAX_VALUE;
                try {
                    earning = Integer.parseInt(findByParentEarningView.getJTextFieldMotherMaxForFindIndex4().getText());
                }catch (Exception exception){
                    if (findByParentEarningView.getJTextFieldMotherMaxForFindIndex4().getText().equals("")) {
                        errors = true;
                        errorsText += ERROR_MESSAGE + "enter the mother earning to\n";
                    }
                }
                return earning;
            }
        });

    }

    
    private void jRadioButtonUpdate(){
        Utilities.jRadioButtonCheck(findByParentEarningView.getJRadioButtonFatherMoneyEnable(), findByParentEarningView.getJRadioButtonMotherMoneyEnable(),
                findByParentEarningView.getJTextFieldFatherMinForFindIndex4(), findByParentEarningView.getJTextFieldFatherMaxForFindIndex4(),
                findByParentEarningView.getJTextFieldMotherMinForFindIndex4(), findByParentEarningView.getJTextFieldMotherMaxForFindIndex4());
    }
}
