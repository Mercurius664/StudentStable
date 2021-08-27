package com.ivashkinigor.dialog.delete;

import com.ivashkinigor.main.StudentTable;
import com.ivashkinigor.model.Model;
import com.ivashkinigor.utilities.Utilities;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DeleteByCountOfBrothersAndSistersController {

   private DeleteByCountOfBrothersAndSistersView deleteByCountOfBrothersAndSistersView;
   private final String ERROR_MESSAGE = "input error";

    public DeleteByCountOfBrothersAndSistersController(DeleteByCountOfBrothersAndSistersView deleteByCountOfBrothersAndSistersView,
                                                       StudentTable studentTable) {
        this.deleteByCountOfBrothersAndSistersView = deleteByCountOfBrothersAndSistersView;
        deleteByCountOfBrothersAndSistersView.getJRadioButtonBrother().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                updateJRadioButton();
            }
        });
        deleteByCountOfBrothersAndSistersView.getJRadioButtonSister().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                updateJRadioButton();
            }
        });

        deleteByCountOfBrothersAndSistersView.getJButtonDelete().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Model model = studentTable.getStudentModel();
                int brotherCount;
                int sisterCount;
                boolean hasErrors = false;

                if (deleteByCountOfBrothersAndSistersView.getJRadioButtonBrother().isSelected() &&
                deleteByCountOfBrothersAndSistersView.getJRadioButtonSister().isSelected()){
                    try {
                        brotherCount = Integer.parseInt(deleteByCountOfBrothersAndSistersView.getJTextFieldBrother().getText());
                        sisterCount = Integer.parseInt(deleteByCountOfBrothersAndSistersView.getJTextFieldFSister().getText());
                        model.deleteByBrothersAndSistersCount(brotherCount,sisterCount);
                    }catch (Exception exception){
                        hasErrors=true;
                    }
                }else if (deleteByCountOfBrothersAndSistersView.getJRadioButtonBrother().isSelected()){
                    try {
                        brotherCount = Integer.parseInt(deleteByCountOfBrothersAndSistersView.getJTextFieldBrother().getText());
                        model.deleteByNumberOfBrother(brotherCount);
                    }catch (Exception exception){
                        hasErrors = true;
                    }
                }else if (deleteByCountOfBrothersAndSistersView.getJRadioButtonSister().isSelected()){
                    try {
                        sisterCount = Integer.parseInt(deleteByCountOfBrothersAndSistersView.getJTextFieldFSister().getText());
                        model.deleteByNumberOfSister(sisterCount);
                    }catch (Exception exception){
                        hasErrors=true;
                    }
                }
                if (hasErrors){
                    JOptionPane.showMessageDialog(null,ERROR_MESSAGE);
                }

            }

        });
    }


    private void updateJRadioButton(){
        Utilities.jRadioButtonCheck(deleteByCountOfBrothersAndSistersView.getJRadioButtonSister(), deleteByCountOfBrothersAndSistersView.getJRadioButtonBrother(),
                deleteByCountOfBrothersAndSistersView.getJTextFieldFSister(), deleteByCountOfBrothersAndSistersView.getJTextFieldBrother());
    }
}
