package com.ivashkinigor.dialog.delete;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class DeleteDialogController {
    private DeleteDialogView deleteDialogView;
    private DeleteByParentEarningView deleteByParentEarningView;
    private DeleteByParentNameView deleteByParentNameView;
    private DeleteByStudentNameView deleteByStudentNameView;
    private DeleteByCountOfBrothersAndSistersView deleteByCountOfBrothersAndSistersView;

    public DeleteDialogController(DeleteDialogView deleteDialogView,
            DeleteByParentEarningView deleteByParentEarningView,
            DeleteByParentNameView deleteByParentNameView,
            DeleteByStudentNameView deleteByStudentNameView,
            DeleteByCountOfBrothersAndSistersView deleteByCountOfBrothersAndSistersView) {


        this.deleteDialogView = deleteDialogView;
        this.deleteByParentEarningView = deleteByParentEarningView;
        this.deleteByParentNameView = deleteByParentNameView;
        this.deleteByStudentNameView = deleteByStudentNameView;
        this.deleteByCountOfBrothersAndSistersView = deleteByCountOfBrothersAndSistersView;

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
                    deleteByStudentNameView.setVisible(true);
                } else if (selectedIndex == 2) {
                    deleteByParentNameView.setVisible(true);
                } else if (selectedIndex == 3) {
                    deleteByCountOfBrothersAndSistersView.setVisible(true);
                } else if (selectedIndex == 4) {
                    deleteByParentEarningView.setVisible(true);
                }

            }
        });
    }


    private void disableAllDeleteFrames(){
        deleteByParentEarningView.setVisible(false);
        deleteByParentNameView.setVisible(false);
        deleteByStudentNameView.setVisible(false);
        deleteByCountOfBrothersAndSistersView.setVisible(false);
    }
}
