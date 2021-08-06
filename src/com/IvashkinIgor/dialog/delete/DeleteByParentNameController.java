package com.IvashkinIgor.dialog.delete;


import com.IvashkinIgor.main.MainDialogController;
import com.IvashkinIgor.model.Model;
import com.IvashkinIgor.model.Student;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class DeleteByParentNameController {
    private static DeleteByParentNameController deleteByParentNameController;


    public static DeleteByParentNameController getInstance(){
        if (deleteByParentNameController == null){
            deleteByParentNameController = new DeleteByParentNameController();
        }
        return deleteByParentNameController;
    }


    private DeleteByParentNameController() {
        DeleteByParentNameView deleteByParentNameView = DeleteByParentNameView.getInstance();
        ArrayList<Student> studentArrayList = Model.getInstance().getStudentArrayList();
        
        deleteByParentNameView.getJRadioButtonFather().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                updateJRadioButton();
            }
        });
        deleteByParentNameView.getJRadioButtonMother().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                updateJRadioButton();
            }
        });

        deleteByParentNameView.getJButtonDelete().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                if (!deleteByParentNameView.getJRadioButtonMother().isSelected() && 
                        !deleteByParentNameView.getJRadioButtonFather().isSelected()) {
                    return;
                } else if (deleteByParentNameView.getJRadioButtonMother().isSelected() &&
                        deleteByParentNameView.getJRadioButtonFather().isSelected()) {
                    ArrayList<Student> arrayListDelete = new ArrayList<>();
                    String jTextFiendContent1 = deleteByParentNameView.getJTextFieldMother().getText();
                    String jTextFiendContent2 = deleteByParentNameView.getJTextFieldFather().getText();
                    if (jTextFiendContent1.equals("") || jTextFiendContent2.equals("")) {
                        return;
                    }
                    for (int i = 0; i < studentArrayList.size(); i++) {

                        if (studentArrayList.get(i).getMotherName().contains(jTextFiendContent1) && studentArrayList.get(i).getFatherName().contains(jTextFiendContent2)) {
                            arrayListDelete.add(studentArrayList.get(i));
                        }
                    }
                    for (int i = 0; i < arrayListDelete.size(); i++) {
                        studentArrayList.remove(arrayListDelete.get(i));
                    }
                    JOptionPane.showMessageDialog(null, "Удалено " + arrayListDelete.size() + " записей");
                } else if (deleteByParentNameView.getJRadioButtonMother().isSelected()) {
                    ArrayList<Student> arrayListDelete = new ArrayList<>();
                    String jTextFiendContent = deleteByParentNameView.getJTextFieldMother().getText();
                    for (int i = 0; i < studentArrayList.size(); i++) {
                        if (studentArrayList.get(i).getMotherName().contains(jTextFiendContent)) {
                            arrayListDelete.add(studentArrayList.get(i));

                        }
                    }
                    for (int i = 0; i < arrayListDelete.size(); i++) {
                        studentArrayList.remove(arrayListDelete.get(i));
                    }
                    JOptionPane.showMessageDialog(null, "Удалено " + arrayListDelete.size() + " записей");
                } else if (deleteByParentNameView.getJRadioButtonFather().isSelected()) {
                    ArrayList<Student> arrayListDelete = new ArrayList<>();
                    String jTextFiendContent = deleteByParentNameView.getJTextFieldFather().getText();
                    for (int i = 0; i < studentArrayList.size(); i++) {
                        if (studentArrayList.get(i).getFatherName().contains(jTextFiendContent)) {
                            arrayListDelete.add(studentArrayList.get(i));

                        }
                    }
                    for (int i = 0; i < arrayListDelete.size(); i++) {
                        studentArrayList.remove(arrayListDelete.get(i));
                    }
                    JOptionPane.showMessageDialog(null, "Удалено " + arrayListDelete.size() + " записей");

                }
                MainDialogController.getInstance().updateNumberInformation();
            }
        });
    }


    /*private void updateNumberInformation(){
        MainDialogView mainDialogView = MainDialogView.getInstance();
        mainDialogView.setCurrentPageNumber(1);
        mainDialogView.updateCurrentPageNumber();
        updateRowsOnPage();
        mainDialogView.updateJLabelNumbersOfRecords();
        mainDialogView.updateJLabelTotalPages();
        mainDialogView.updateJLabelNumberOfRecordsOnPage();

    }

    private void updateRowsOnPage() {
        MainDialogView mainDialogView = MainDialogView.getInstance();
        MainDialogController mainDialogController = MainDialogController.getInstance();
        numberOfRowsOnPageLogic(mainDialogView.getDefaultTableModel(), Model.getInstance().getStudentArrayList(),
                mainDialogController.getNumberOfRowsOnPage(), mainDialogView.getCurrentPageNumber());
    }

    private static void numberOfRowsOnPageLogic(DefaultTableModel defaultTableModel, ArrayList<Student> arrayList, int numberOfRows, int currentPage) {

        int rowCount = defaultTableModel.getRowCount();
        for (int i = 0; i < rowCount; i++) {
            defaultTableModel.removeRow(0);
        }
        for (int i = (currentPage * numberOfRows - numberOfRows); i < arrayList.size(); i++) {
            if (defaultTableModel.getRowCount() >= numberOfRows) {
                break;
            }
            Object[] tableContent = new String[]{
                    arrayList.get(i).getStudentName(),
                    arrayList.get(i).getFatherName(),
                    String.valueOf(arrayList.get(i).getFatherEarnings()),
                    arrayList.get(i).getMotherName(),
                    String.valueOf(arrayList.get(i).getMotherEarnings()),
                    String.valueOf(arrayList.get(i).getNumberOfBrothers()),
                    String.valueOf(arrayList.get(i).getNumberOfSisters())
            };
            defaultTableModel.addRow(tableContent);

        }

    }
    */
    
    private void updateJRadioButton(){
        DeleteByParentNameView valueVariables = DeleteByParentNameView.getInstance();
        
        jRadioButtonCheck(valueVariables.getJRadioButtonFather(),
                valueVariables.getJRadioButtonMother(),
                valueVariables.getJTextFieldFather(),
                valueVariables.getJTextFieldMother());
    }

    private static void jRadioButtonCheck(JRadioButton jRadioButton1, JRadioButton jRadioButton2,
                                          JTextField jTextField1, JTextField jTextField2) {
        DeleteByCountOfBrothersAndSistersView values = DeleteByCountOfBrothersAndSistersView.getInstance();
        if (jRadioButton1.isSelected() && jRadioButton2.isSelected()) {
            jTextField1.setEditable(true);
            jTextField1.setBackground(Color.WHITE);
            jTextField2.setEditable(true);
            jTextField2.setBackground(Color.WHITE);
        } else if (!jRadioButton1.isSelected() && !jRadioButton2.isSelected()) {
            jTextField1.setEditable(false);
            jTextField1.setBackground(values.getBackground());
            jTextField1.setText("");
            jTextField2.setEditable(false);
            jTextField2.setBackground(values.getBackground());
            jTextField2.setText("");
        } else if (jRadioButton1.isSelected()) {
            jTextField1.setEditable(true);
            jTextField1.setBackground(Color.WHITE);

            jTextField2.setEditable(false);
            jTextField2.setBackground(values.getBackground());
            jTextField2.setText("");
        } else {
            jTextField2.setEditable(true);
            jTextField2.setBackground(Color.WHITE);

            jTextField1.setEditable(false);
            jTextField1.setBackground(values.getBackground());
            jTextField1.setText("");
        }

    }

}
