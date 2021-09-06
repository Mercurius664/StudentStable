package com.ivashkinigor.student.swing.dialog.delete;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class DeleteDialogController {

    private DeleteByParentEarningView deleteByParentEarningView;
    private DeleteByParentNameView deleteByParentNameView;
    private DeleteByStudentNameView deleteByStudentNameView;
    private DeleteByCountOfBrothersAndSistersView deleteByCountOfBrothersAndSistersView;

    public DeleteDialogController(DeleteDialogView deleteDialogView,
            DeleteByParentEarningView deleteByParentEarningView,
            DeleteByParentNameView deleteByParentNameView,
            DeleteByStudentNameView deleteByStudentNameView,
            DeleteByCountOfBrothersAndSistersView deleteByCountOfBrothersAndSistersView) {


        this.deleteByParentEarningView = deleteByParentEarningView;
        this.deleteByParentNameView = deleteByParentNameView;
        this.deleteByStudentNameView = deleteByStudentNameView;
        this.deleteByCountOfBrothersAndSistersView = deleteByCountOfBrothersAndSistersView;

        deleteDialogView.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                disableAllDeleteFrames();
                deleteDialogView.getJComboBoxForDelete().setSelectedIndex(0);
            }
        });
        deleteDialogView.getJComboBoxForDelete().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                disableAllDeleteFrames();
                int selectedIndex = deleteDialogView.getJComboBoxForDelete().getSelectedIndex();

                switch (selectedIndex){
                    case 1:
                        deleteByStudentNameView.setVisible(true);
                        break;
                    case 2:
                        deleteByParentNameView.setVisible(true);
                        break;
                    case 3:
                        deleteByCountOfBrothersAndSistersView.setVisible(true);
                        break;
                    case 4:
                        deleteByParentEarningView.setVisible(true);
                        break;
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
