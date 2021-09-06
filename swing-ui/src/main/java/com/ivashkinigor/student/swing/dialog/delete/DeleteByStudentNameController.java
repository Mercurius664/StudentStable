package com.ivashkinigor.student.swing.dialog.delete;

import com.ivashkinigor.student.model.Model;
import com.ivashkinigor.student.swing.dialog.main.StudentTable;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DeleteByStudentNameController {

    public DeleteByStudentNameController(DeleteByStudentNameView studentNameView,
                                         Model model) {
        studentNameView.getJButtonForDeleteIndex1().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                model.deleteByStudentName(studentNameView.getJTextFieldForDeleteIndex1().getText());
            }
        });
    }
}
