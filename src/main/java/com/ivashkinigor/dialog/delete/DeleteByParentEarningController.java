package com.ivashkinigor.dialog.delete;

import com.ivashkinigor.main.StudentTable;
import com.ivashkinigor.model.Model;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static com.ivashkinigor.utilities.Utilities.jRadioButtonCheck;

public class DeleteByParentEarningController {
    private DeleteByParentEarningView deleteByParentEarningView;
    private final String ERROR_MESSAGE = "input error in the field:\n";


    public DeleteByParentEarningController(DeleteByParentEarningView deleteByParentEarningView,
                                           StudentTable studentTable) {
        this.deleteByParentEarningView = deleteByParentEarningView;
        Model model = studentTable.getStudentModel();
        deleteByParentEarningView.getJRadioButtonFatherMoneyDeleteEnable().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                updateJRadioButton();
            }
        });
        deleteByParentEarningView.getJRadioButtonMotherMoneyDeleteEnable().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                updateJRadioButton();
            }
        });

        deleteByParentEarningView.getJButtonForDeleteIndex4().addActionListener(new ActionListener() {
            private boolean errors = false;
            private String errorsText="";
            @Override
            public void actionPerformed(ActionEvent e) {
                int fatherEarningFrom;
                int fatherEarningTo;
                int motherEarningFrom;
                int motherEarningTo;
                errors = false;
                errorsText="";


                if (deleteByParentEarningView.getJRadioButtonFatherMoneyDeleteEnable().isSelected()){
                    fatherEarningFrom = fatherEarningFromParse();
                    fatherEarningTo = fatherEarningToParse();
                    model.deleteByFatherEarning(fatherEarningFrom,fatherEarningTo);
                }
                if (deleteByParentEarningView.getJRadioButtonMotherMoneyDeleteEnable().isSelected()){
                    motherEarningFrom = motherEarningFromParse();
                    motherEarningTo = motherEarningToParse();
                    model.deleteByMotherEarning(motherEarningFrom,motherEarningTo);
                }
                if (errors){
                    JOptionPane.showMessageDialog(null,errorsText);
                }

            }

            private int fatherEarningFromParse(){
                int earning = 0;
                try {
                    earning = Integer.parseInt(deleteByParentEarningView.getJTextFieldFatherMinForDeleteIndex4().getText());
                }catch (Exception exception){
                    if (!deleteByParentEarningView.getJTextFieldFatherMinForDeleteIndex4().getText().equals("")){
                        errors = true;
                        errorsText += ERROR_MESSAGE + "enter the father earning from\n";
                    }
                }
                return earning;
            }
            private int fatherEarningToParse(){
                int earning = Integer.MAX_VALUE;
                try {
                    earning = Integer.parseInt(deleteByParentEarningView.getJTextFieldFatherMaxForDeleteIndex4().getText());
                }catch (Exception exception){
                    if (deleteByParentEarningView.getJTextFieldFatherMaxForDeleteIndex4().getText().equals("")) {
                        errors = true;
                        errorsText += ERROR_MESSAGE + "enter the father earning to\n";
                    }
                }
                return earning;
            }
            private int motherEarningFromParse(){
                int earning = 0;
                try {
                    earning = Integer.parseInt(deleteByParentEarningView.getJTextFieldMotherMinForDeleteIndex4().getText());
                }catch (Exception exception){
                    if (deleteByParentEarningView.getJTextFieldMotherMinForDeleteIndex4().getText().equals("")) {
                        errors = true;
                        errorsText += ERROR_MESSAGE + "enter the mother earning from\n";
                    }
                }
                return earning;
            }
            private int motherEarningToParse(){
                int earning = Integer.MAX_VALUE;
                try {
                    earning = Integer.parseInt(deleteByParentEarningView.getJTextFieldMotherMaxForDeleteIndex4().getText());
                }catch (Exception exception){
                    if (deleteByParentEarningView.getJTextFieldMotherMaxForDeleteIndex4().getText().equals("")) {
                        errors = true;
                        errorsText += ERROR_MESSAGE + "enter the mother earning to\n";
                    }
                }
                return earning;
            }
        });
    }


    private void updateJRadioButton(){
        jRadioButtonCheck(deleteByParentEarningView.getJRadioButtonFatherMoneyDeleteEnable(),
                deleteByParentEarningView.getJRadioButtonMotherMoneyDeleteEnable(),
                deleteByParentEarningView.getJTextFieldFatherMinForDeleteIndex4(),
                deleteByParentEarningView.getJTextFieldFatherMaxForDeleteIndex4(),
                deleteByParentEarningView.getJTextFieldMotherMinForDeleteIndex4(),
                deleteByParentEarningView.getJTextFieldMotherMaxForDeleteIndex4());
    }


}
