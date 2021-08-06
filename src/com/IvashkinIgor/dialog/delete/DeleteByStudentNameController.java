package com.IvashkinIgor.dialog.delete;

import com.IvashkinIgor.main.MainDialogController;
import com.IvashkinIgor.model.Model;
import com.IvashkinIgor.model.Student;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class DeleteByStudentNameController {
    private static DeleteByStudentNameController deleteByStudentNameController;

    public static DeleteByStudentNameController getInstance() {
        if (deleteByStudentNameController == null){
            deleteByStudentNameController = new DeleteByStudentNameController();
        }
        return deleteByStudentNameController;
    }
    
    private DeleteByStudentNameController() {
        DeleteByStudentNameView deleteByStudentNameView = DeleteByStudentNameView.getInstance();
        ArrayList<Student> studentArrayList = Model.getInstance().getStudentArrayList();
        deleteByStudentNameView.getJButtonForDeleteIndex1().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ArrayList<Student> arrayListDelete = new ArrayList<>();
                String jTextFiendContent = deleteByStudentNameView.getJTextFieldForDeleteIndex1().getText();
                if (jTextFiendContent.equals("")) {
                    return;
                }
                for (int i = 0; i < studentArrayList.size(); i++) {
                    if (studentArrayList.get(i).getStudentName().contains(jTextFiendContent)) {
                        arrayListDelete.add(studentArrayList.get(i));
                    }
                }
                for (int i = 0; i < arrayListDelete.size(); i++) {
                    studentArrayList.remove(arrayListDelete.get(i));
                }
                JOptionPane.showMessageDialog(null, "Удалено " + arrayListDelete.size() + " записей");
                MainDialogController.getInstance().updateNumberInformation();
            }
        });
    }
}
