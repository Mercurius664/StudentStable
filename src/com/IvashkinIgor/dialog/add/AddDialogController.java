package com.IvashkinIgor.dialog.add;

import com.IvashkinIgor.main.MainDialogView;
import com.IvashkinIgor.model.Model;
import com.IvashkinIgor.model.Student;
import com.IvashkinIgor.utilities.Utilities;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AddDialogController {
    private Student student;

    public AddDialogController(AddDialogView addDialogView) {
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
                    student = new Student(studentName, fatherName, fatherEarnings, motherName, motherEarnings,
                            numberOfBrothers, numberOfSisters);

                    Model.getInstance().getStudentArrayList().add(student);
                    MainDialogView.getInstance().updateJLabelNumbersOfRecords();
                    MainDialogView.getInstance().updateJLabelTotalPages();
                    if (MainDialogView.getInstance().getDefaultTableModel().getRowCount() >= MainDialogView.getInstance().getNumbersOfRecordsOnPage()) {
                        return;
                    }

                    Utilities.jTableUpdate(MainDialogView.getInstance().getDefaultTableModel(), MainDialogView.getInstance().getJTable(),
                            MainDialogView.getInstance().getJPanel(),
                            Model.getInstance().getStudentArrayList());
                    MainDialogView.getInstance().updateJLabelNumberOfRecordsOnPage();

                } else {
                    JOptionPane.showMessageDialog(null, errors);
                }
            }
        });
    }
}


