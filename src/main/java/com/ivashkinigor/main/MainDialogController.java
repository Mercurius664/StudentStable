package com.ivashkinigor.main;

import com.ivashkinigor.dialog.add.AddDialogView;
import com.ivashkinigor.dialog.delete.DeleteDialogView;
import com.ivashkinigor.dialog.find.FindDialogView;
import com.ivashkinigor.model.Model;
import com.ivashkinigor.parsers.*;
import com.ivashkinigor.utilities.Utilities;
import org.xml.sax.SAXException;

import javax.swing.*;
import javax.xml.parsers.ParserConfigurationException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

public class MainDialogController {

    private AddDialogView addDialogView;
    private DeleteDialogView deleteDialogView;
    private FindDialogView findDialogView;
    private MainDialogView mainDialogView;

    private StudentTable studentTable;





    public MainDialogController(MainDialogView mainDialogView, StudentTable studentTable) {
            this.mainDialogView = mainDialogView;
            this.studentTable = studentTable;
            mainDialogView.getButtonNext().addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                  studentTable.nextTablePage();
                }

            });
            mainDialogView.getButtonPrevious().addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    studentTable.previousPage();
                }
            });
            mainDialogView.getButtonFirstPage().addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    studentTable.firstPage();
                }
            });
            mainDialogView.getButtonDelete().addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    if (deleteDialogView == null){
                        deleteDialogView = new DeleteDialogView(studentTable);
                    }
                    deleteDialogView.setVisible(true);
                }
            });
            mainDialogView.getButtonLastPage().addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    studentTable.lastPage();
                }
            });
        mainDialogView.getButtonAdd().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (addDialogView == null){
                    addDialogView = new AddDialogView(studentTable);
                }
                addDialogView.setVisible(true);

            }

        });
        mainDialogView.getButtonFind().addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    if (findDialogView == null){
                        findDialogView = new FindDialogView(studentTable);
                    }
                    findDialogView.setVisible(true);
                }
            });

        mainDialogView.getSaveMenu().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFileChooser fileChooser = new JFileChooser();
                fileChooser.showSaveDialog(mainDialogView);
                File file = fileChooser.getSelectedFile();
                DOMxmlWriter.write(file,studentTable);

            }
        });
        mainDialogView.getLoadMenu().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFileChooser fileChooser = new JFileChooser();
                fileChooser.showOpenDialog(mainDialogView);
                File file = fileChooser.getSelectedFile();
                try {
                    SAXExample.read(file,studentTable);
                } catch (ParserConfigurationException parserConfigurationException) {
                    parserConfigurationException.printStackTrace();
                } catch (SAXException saxException) {
                    saxException.printStackTrace();
                } catch (IOException ioException) {
                    ioException.printStackTrace();
                }
            }
        });
        }

}
