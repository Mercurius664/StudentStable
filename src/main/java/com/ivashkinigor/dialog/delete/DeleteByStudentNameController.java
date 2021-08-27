package com.ivashkinigor.dialog.delete;

import com.ivashkinigor.main.StudentTable;
import com.ivashkinigor.model.Model;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DeleteByStudentNameController {

    public DeleteByStudentNameController(DeleteByStudentNameView studentNameView,
                                         StudentTable studentTable) {
        studentNameView.getJButtonForDeleteIndex1().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Model model = studentTable.getStudentModel();
                model.deleteByStudentName(studentNameView.getJTextFieldForDeleteIndex1().getText());
            }
        });
    }
}
