package com.ivashkinigor.student.swing.dialog.add;

import com.ivashkinigor.student.swing.dialog.main.StudentTable;

import com.ivashkinigor.student.model.Student;
import com.ivashkinigor.student.model.Parent;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AddDialogController {
    private Student student;
    private final AddDialogView addDialogView;
    private StudentTable studentTable;

    public AddDialogController(AddDialogView addDialogView, StudentTable studentTable) {
        this.addDialogView = addDialogView;
        this.studentTable = studentTable;
        initialize();
    }

    private void initialize() {
        addDialogView.getButtonSaveForAdd().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String studentName;
                String fatherName;
                int fatherEarnings = 0;
                String motherName;
                int motherEarnings = 0;
                int numberOfBrothers = 0;
                int numberOfSisters = 0;
                boolean hasErrors = false;
                String errors = "";

                studentName = addDialogView.getJTextFieldStudentName().getText().trim();
                if (studentName.isEmpty()) {
                    errors += "Неправильно введено поле: " + "ФИО студента" + "\n";
                    hasErrors = true;
                }
                fatherName = addDialogView.getJTextFieldFatherName().getText().trim();
                if (fatherName.isEmpty()) {
                    errors += "Неправильно введено поле: " + "ФИО отца" + "\n";
                    hasErrors = true;
                }
                try {
                    fatherEarnings = Integer.parseInt(addDialogView.getJTextFieldFatherEarning().getText());
                } catch (Exception exception) {
                    errors += "Неправильно введено поле: " + "Заработок отца" + "\n";
                    hasErrors = true;
                }
                motherName = addDialogView.getJTextFieldMotherName().getText();
                if (motherName.isEmpty()) {
                    errors += "Неправильно введено поле: " + "ФИО матери" + "\n";
                    hasErrors = true;
                }
                try {
                    motherEarnings = Integer.parseInt(addDialogView.getJTextFieldMotherEarning().getText());
                } catch (Exception exception) {
                    errors += "Неправильно введено поле: " + "Заработок матери" + "\n";
                    hasErrors = true;
                }
                try {
                    numberOfBrothers = Integer.parseInt(addDialogView.getJTextFieldNumberOfBrothers().getText());
                } catch (Exception exception) {
                    errors += "Неправильно введено поле: " + "Число братьев" + "\n";
                    hasErrors = true;
                }
                try {
                    numberOfSisters = Integer.parseInt(addDialogView.getJTextFieldNumberOfSisters().getText());
                } catch (Exception exception) {
                    errors += "Неправильно введено поле: " + "Число сестёр" + "\n";
                    hasErrors = true;
                }


                if (!hasErrors) {
                    Parent father = new Parent(fatherName,fatherEarnings);
                    Parent mother = new Parent(motherName,motherEarnings);
                    student = new Student(studentName, father, mother,
                            numberOfBrothers, numberOfSisters);

                    studentTable.addRow(student);

                } else {
                    JOptionPane.showMessageDialog(null, errors);
                }
            }
        });
    }
}


