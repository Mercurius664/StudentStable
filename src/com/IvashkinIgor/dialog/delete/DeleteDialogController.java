package com.IvashkinIgor.dialog.delete;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class DeleteDialogController {
    private static DeleteDialogController deleteDialogController;

    public static DeleteDialogController getInstance() {
        if (deleteDialogController == null){
            deleteDialogController = new DeleteDialogController();
        }
        return deleteDialogController;
    }

    private DeleteDialogController() {
        DeleteDialogView deleteDialogView = DeleteDialogView.getInstance();
        deleteDialogView.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                disableAllDeleteFrames();
            }
        });
        deleteDialogView.getJComboBoxForDelete().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                disableAllDeleteFrames();
                int selectedIndex = deleteDialogView.getJComboBoxForDelete().getSelectedIndex();

                if (selectedIndex == 1) {
                    DeleteByStudentNameView.getInstance().setVisible(true);
                } else if (selectedIndex == 2) {
                    DeleteByParentNameView.getInstance().setVisible(true);
                } else if (selectedIndex == 3) {
                    DeleteByCountOfBrothersAndSistersView.getInstance().setVisible(true);
                } else if (selectedIndex == 4) {
                    DeleteByParentEarningView.getInstance().setVisible(true);
                }

            }
        });
    }


    private void disableAllDeleteFrames(){
        DeleteByParentEarningView.getInstance().setVisible(false);
        DeleteByParentNameView.getInstance().setVisible(false);
        DeleteByStudentNameView.getInstance().setVisible(false);
        DeleteByCountOfBrothersAndSistersView.getInstance().setVisible(false);
    }
}
