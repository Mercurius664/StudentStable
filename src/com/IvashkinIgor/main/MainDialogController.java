package com.IvashkinIgor.main;

import com.IvashkinIgor.dialog.add.AddDialogView;
import com.IvashkinIgor.dialog.delete.DeleteDialogView;
import com.IvashkinIgor.dialog.find.FindDialogView;
import com.IvashkinIgor.model.Model;
import com.IvashkinIgor.model.Student;
import com.IvashkinIgor.main.*;
import com.IvashkinIgor.parsers.*;
import com.IvashkinIgor.utilities.Utilities;
import org.xml.sax.SAXException;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.xml.parsers.ParserConfigurationException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class MainDialogController {
    private  int numberOfRowsOnPage;
    private static MainDialogController mainDialogController;

    public int getNumberOfRowsOnPage() {
        return numberOfRowsOnPage;
    }

    public static MainDialogController getInstance(){
        if (mainDialogController == null){
            mainDialogController = new MainDialogController();
        }
        return mainDialogController;
    }



    private MainDialogController() {
            MainDialogView mainDialogView = MainDialogView.getInstance();
            Model model = Model.getInstance();
            mainDialogView.getButtonNext().addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    if (numberOfRowsOnPage == 0) {
                        return;
                    }
                    if (mainDialogView.getCurrentPageNumber() * numberOfRowsOnPage >= model.getStudentArrayList().size()) {
                        return;
                    }
                    mainDialogView.setCurrentPageNumber(mainDialogView.getCurrentPageNumber() + 1);
                    mainDialogView.updateCurrentPageNumber();
                    numberOfRowsOnPageLogic(model.getStudentArrayList(), numberOfRowsOnPage, mainDialogView.getCurrentPageNumber());
                    mainDialogView.updateJLabelNumbersOfRecords();
                    mainDialogView.updateJLabelTotalPages();
                    mainDialogView.updateJLabelNumberOfRecordsOnPage();
                }

            });
            mainDialogView.getButtonPrevious().addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    if (numberOfRowsOnPage == 0) {
                        return;
                    }
                    if (mainDialogView.getCurrentPageNumber() <= 1) {
                        return;
                    }
                    mainDialogView.setCurrentPageNumber(mainDialogView.getCurrentPageNumber() - 1);
                    mainDialogView.updateCurrentPageNumber();
                    numberOfRowsOnPageLogic(model.getStudentArrayList(), numberOfRowsOnPage, mainDialogView.getCurrentPageNumber());
                    mainDialogView.updateJLabelNumbersOfRecords();
                    mainDialogView.updateJLabelTotalPages();
                    mainDialogView.updateJLabelNumberOfRecordsOnPage();
                }
            });
            mainDialogView.getButtonFirstPage().addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    if (numberOfRowsOnPage == 0) {
                        return;
                    }
                    mainDialogView.setCurrentPageNumber(1);
                    mainDialogView.updateCurrentPageNumber();
                    numberOfRowsOnPageLogic(model.getStudentArrayList(), numberOfRowsOnPage, mainDialogView.getCurrentPageNumber());
                    mainDialogView.updateJLabelNumbersOfRecords();
                    mainDialogView.updateJLabelTotalPages();
                    mainDialogView.updateJLabelNumberOfRecordsOnPage();
                }
            });
            mainDialogView.getButtonDelete().addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    DeleteDialogView.getInstance().initialize();
                }
            });
            mainDialogView.getButtonLastPage().addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    if (numberOfRowsOnPage == 0) {
                        return;
                    }
                    if (model.getStudentArrayList().size() == 0) {
                        return;
                    }
                    mainDialogView.setCurrentPageNumber(mainDialogView.getTotalPages());
                    mainDialogView.updateCurrentPageNumber();

                    mainDialogView.updateJLabelNumbersOfRecords();
                    mainDialogView.updateJLabelTotalPages();
                    mainDialogView.updateJLabelNumberOfRecordsOnPage();
                    numberOfRowsOnPageLogic(model.getStudentArrayList(), numberOfRowsOnPage, mainDialogView.getCurrentPageNumber());

                }
            });
        mainDialogView.getButtonAdd().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                AddDialogView.getInstance().initialize();
            }

        });
        mainDialogView.getButtonFind().addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    FindDialogView.getInstance().initialize();
                }
            });
        mainDialogView.getJComboBoxMainFrame().addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    numberOfRowsOnPage = mainDialogView.getJComboBoxMainFrame().getSelectedIndex();
                    mainDialogView.setCurrentPageNumber(1);
                    numberOfRowsOnPageLogic(model.getStudentArrayList(), numberOfRowsOnPage, mainDialogView.getCurrentPageNumber());
                    mainDialogView.updateCurrentPageNumber();
                    mainDialogView.updateJLabelTotalPages();
                    mainDialogView.updateJLabelNumberOfRecordsOnPage();
                    mainDialogView.updateJLabelNumbersOfRecords();
                }
            });
            mainDialogView.getSaveMenu().addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    JFileChooser fileChooser = new JFileChooser();
                    fileChooser.showSaveDialog(mainDialogView);
                    File file = fileChooser.getSelectedFile();
                    DOMxmlWriter.write(file);

                }
            });
            mainDialogView.getLoadMenu().addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    JFileChooser fileChooser = new JFileChooser();
                    fileChooser.showOpenDialog(mainDialogView);
                    File file = fileChooser.getSelectedFile();
                    try {
                        SAXExample.read(file);
                    } catch (ParserConfigurationException parserConfigurationException) {
                        parserConfigurationException.printStackTrace();
                    } catch (SAXException saxException) {
                        saxException.printStackTrace();
                    } catch (IOException ioException) {
                        ioException.printStackTrace();
                    }
                    mainDialogView.setCurrentPageNumber(1);
                    mainDialogView.updateCurrentPageNumber();
                    numberOfRowsOnPageLogic(model.getStudentArrayList(), numberOfRowsOnPage, mainDialogView.getCurrentPageNumber());
                    mainDialogView.updateJLabelNumbersOfRecords();
                    mainDialogView.updateJLabelTotalPages();
                    mainDialogView.updateJLabelNumberOfRecordsOnPage();
                }
            });
        }

    private void numberOfRowsOnPageLogic(ArrayList<Student> arrayList, int numberOfRows, int currentPage) {
        DefaultTableModel defaultTableModel = MainDialogView.getInstance().getDefaultTableModel();
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

    public void updateNumberInformation(){
        MainDialogView mainDialogView = MainDialogView.getInstance();
        mainDialogView.setCurrentPageNumber(1);
        mainDialogView.updateCurrentPageNumber();
        updateRowsOnPage();
        mainDialogView.updateJLabelNumbersOfRecords();
        mainDialogView.updateJLabelTotalPages();
        mainDialogView.updateJLabelNumberOfRecordsOnPage();

    }

    public void updateRowsOnPage() {
        MainDialogView mainDialogView = MainDialogView.getInstance();
        MainDialogController mainDialogController = MainDialogController.getInstance();
        numberOfRowsOnPageLogic(Model.getInstance().getStudentArrayList(),
                mainDialogController.getNumberOfRowsOnPage(), mainDialogView.getCurrentPageNumber());
    }



}
