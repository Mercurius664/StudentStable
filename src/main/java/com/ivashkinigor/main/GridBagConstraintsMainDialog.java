package com.ivashkinigor.main;

import java.awt.*;

public class GridBagConstraintsMainDialog {
    static GridBagConstraints getConstraintsForButtonFind() {
        GridBagConstraints constraints = new GridBagConstraints();
        constraints.fill = GridBagConstraints.BOTH;
        constraints.weightx = 100.0;
        constraints.weighty = 100.0;

        constraints.insets.bottom = 5;
        constraints.insets.left = 5;
        constraints.insets.right = 5;
        constraints.insets.top = 5;

        constraints.ipadx = 0;

        constraints.gridx = 0;
        constraints.gridy = 1;
        constraints.gridheight = 1;
        constraints.gridwidth = 1;
        return constraints;
    }

    static GridBagConstraints getConstraintsForButtonAdd() {
        GridBagConstraints constraints = new GridBagConstraints();
        constraints.fill = GridBagConstraints.BOTH;
        constraints.weightx = 100.0;
        constraints.weighty = 100.0;

        constraints.insets.bottom = 5;
        constraints.insets.left = 5;
        constraints.insets.right = 5;
        constraints.insets.top = 5;

        constraints.ipadx = 0;

        constraints.gridx = 0;
        constraints.gridy = 2;
        constraints.gridheight = 1;
        constraints.gridwidth = 1;
        return constraints;
    }

    static GridBagConstraints getConstraintsForButtonDelete() {
        GridBagConstraints constraints = new GridBagConstraints();
        constraints.fill = GridBagConstraints.BOTH;
        constraints.weightx = 100.0;
        constraints.weighty = 100.0;

        constraints.insets.bottom = 5;
        constraints.insets.left = 5;
        constraints.insets.right = 5;
        constraints.insets.top = 5;

        constraints.ipadx = 0;

        constraints.gridx = 0;
        constraints.gridy = 3;
        constraints.gridheight = 1;
        constraints.gridwidth = 1;
        return constraints;
    }

    static GridBagConstraints getConstraintsForButtonFirstPage() {
        GridBagConstraints constraints = new GridBagConstraints();
        constraints.fill = GridBagConstraints.NONE;
        constraints.anchor = GridBagConstraints.EAST;
        constraints.weightx = 100.0;
        constraints.weighty = 100.0;

        constraints.insets.bottom = 5;
        constraints.insets.left = 5;
        constraints.insets.right = 5;
        constraints.insets.top = 5;

        constraints.ipadx = 0;

        constraints.gridx = 1;
        constraints.gridy = 0;
        constraints.gridheight = 1;
        constraints.gridwidth = 1;
        return constraints;
    }

    static GridBagConstraints getConstraintsForButtonLastPage() {
        GridBagConstraints constraints = new GridBagConstraints();
        constraints.fill = GridBagConstraints.NONE;
        constraints.anchor = GridBagConstraints.WEST;
        constraints.weightx = 100.0;
        constraints.weighty = 100.0;

        constraints.insets.bottom = 5;
        constraints.insets.left = 5;
        constraints.insets.right = 5;
        constraints.insets.top = 5;

        constraints.ipadx = 0;

        constraints.gridx = 5;
        constraints.gridy = 0;
        constraints.gridheight = 1;
        constraints.gridwidth = 1;
        return constraints;
    }

    static GridBagConstraints getConstraintsForJComboBoxMainFrame() {
        GridBagConstraints constraints = new GridBagConstraints();
        constraints.fill = GridBagConstraints.NONE;
        constraints.weightx = 100.0;
        constraints.weighty = 100.0;

        constraints.insets.bottom = 5;
        constraints.insets.left = 5;
        constraints.insets.right = 5;
        constraints.insets.top = 5;
        constraints.anchor = GridBagConstraints.CENTER;
        constraints.ipadx = 0;

        constraints.gridx = 6;
        constraints.gridy = 0;
        constraints.gridheight = 1;
        constraints.gridwidth = 1;
        return constraints;
    }

    static GridBagConstraints getConstraintsForJLabelNumbersOfRecordsOnPage() {
        GridBagConstraints constraints = new GridBagConstraints();
        constraints.fill = GridBagConstraints.BOTH;
        constraints.weightx = 100.0;
        constraints.weighty = 100.0;

        constraints.insets.bottom = 5;
        constraints.insets.left = 5;
        constraints.insets.right = 5;
        constraints.insets.top = 5;
        constraints.anchor = GridBagConstraints.CENTER;
        constraints.ipadx = 0;

        constraints.gridx = 6;
        constraints.gridy = 1;
        constraints.gridheight = 1;
        constraints.gridwidth = 1;
        return constraints;
    }

    static GridBagConstraints getConstraintsForJLabelNumbersOfRecords() {
        GridBagConstraints constraints = new GridBagConstraints();
        constraints.fill = GridBagConstraints.BOTH;

        constraints.weightx = 100.0;
        constraints.weighty = 100.0;

        constraints.insets.bottom = 5;
        constraints.insets.left = 5;
        constraints.insets.right = 5;
        constraints.insets.top = 5;
        constraints.anchor = GridBagConstraints.CENTER;
        constraints.ipadx = 0;

        constraints.gridx = 6;
        constraints.gridy = 2;
        constraints.gridheight = 1;
        constraints.gridwidth = 1;
        return constraints;
    }

    static GridBagConstraints getConstraintsForJLabelTotalPages() {
        GridBagConstraints constraints = new GridBagConstraints();
        constraints.fill = GridBagConstraints.BOTH;
        constraints.weightx = 100.0;
        constraints.weighty = 100.0;

        constraints.insets.bottom = 5;
        constraints.insets.left = 5;
        constraints.insets.right = 5;
        constraints.insets.top = 5;
        constraints.anchor = GridBagConstraints.CENTER;
        constraints.ipadx = 0;

        constraints.gridx = 6;
        constraints.gridy = 3;
        constraints.gridheight = 1;
        constraints.gridwidth = 1;
        return constraints;
    }




    static GridBagConstraints getConstraintsForJTable() {
        GridBagConstraints constraints = new GridBagConstraints();
        constraints.fill = GridBagConstraints.BOTH;
        constraints.weightx = 100.0;
        constraints.weighty = 100.0;

        constraints.insets.bottom = 5;
        constraints.insets.left = 5;
        constraints.insets.right = 5;
        constraints.insets.top = 5;


        constraints.ipadx = 0; //jFrame.getRootPane().getWidth()*2/5;

        constraints.gridx = 1;
        constraints.gridy = 1;
        constraints.gridheight = 3;
        constraints.gridwidth = 5;
        return constraints;
    }

    static GridBagConstraints getConstraintsForButtonNext() {
        GridBagConstraints constraints = new GridBagConstraints();
        //constraints.fill = GridBagConstraints.VERTICAL;
        constraints.anchor = GridBagConstraints.WEST;
        constraints.weightx = 100.0;
        constraints.weighty = 100.0;

        constraints.insets.bottom = 5;
        constraints.insets.left = 5;
        constraints.insets.right = 5;
        constraints.insets.top = 5;


        constraints.ipadx = 0; //jFrame.getRootPane().getWidth()*2/5;

        constraints.gridx = 4;
        constraints.gridy = 0;
        constraints.gridheight = 1;
        constraints.gridwidth = 1;
        return constraints;
    }

    static GridBagConstraints getConstraintsForButtonPrevious() {
        GridBagConstraints constraints = new GridBagConstraints();
        constraints.fill = GridBagConstraints.NONE;
        constraints.anchor = GridBagConstraints.EAST;
        constraints.weightx = 100.0;
        constraints.weighty = 100.0;

        constraints.insets.bottom = 5;
        constraints.insets.left = 5;
        constraints.insets.right = 5;
        constraints.insets.top = 5;


        constraints.ipadx = 0; //jFrame.getRootPane().getWidth()*2/5;

        constraints.gridx = 2;
        constraints.gridy = 0;
        constraints.gridheight = 1;
        constraints.gridwidth = 1;
        return constraints;
    }

    static GridBagConstraints getConstraintsForLabelCurrent() {
        GridBagConstraints constraints = new GridBagConstraints();
        constraints.fill = GridBagConstraints.NONE;
        constraints.weightx = 100.0;
        constraints.weighty = 100.0;

        constraints.insets.bottom = 5;
        constraints.insets.left = 5;
        constraints.insets.right = 5;
        constraints.insets.top = 5;
        constraints.anchor = GridBagConstraints.CENTER;


        constraints.ipadx = 0; //jFrame.getRootPane().getWidth()*2/5;

        constraints.gridx = 3;
        constraints.gridy = 0;
        constraints.gridheight = 1;
        constraints.gridwidth = 1;
        return constraints;
    }

}
