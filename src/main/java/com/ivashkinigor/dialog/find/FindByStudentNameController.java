package com.ivashkinigor.dialog.find;

import com.ivashkinigor.main.StudentTable;
import com.ivashkinigor.model.Model;
import com.ivashkinigor.utilities.Utilities;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FindByStudentNameController {

    public FindByStudentNameController(FindByStudentNameView findByStudentNameView,
                                       StudentTable studentTable) {
        Model model = studentTable.getStudentModel();
        
        findByStudentNameView.getJButtonForFindIndex1().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                studentTable.setWorkList(model.filterByStudentName(findByStudentNameView.getJTextFieldForFindIndex1().getText()));
            }
        });
    }
}
