import java.awt.*;

public class Constraints {

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


    static GridBagConstraints getConstraintsForButtonAddForText1() {
        GridBagConstraints constraints = new GridBagConstraints();
        constraints.fill = GridBagConstraints.BOTH;
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

    static GridBagConstraints getConstraintsForButtonAddForText2() {
        GridBagConstraints constraints = new GridBagConstraints();
        constraints.fill = GridBagConstraints.BOTH;
        constraints.weightx = 100.0;
        constraints.weighty = 100.0;

        constraints.insets.bottom = 5;
        constraints.insets.left = 5;
        constraints.insets.right = 5;
        constraints.insets.top = 5;

        constraints.ipadx = 0;

        constraints.gridx = 1;
        constraints.gridy = 1;
        constraints.gridheight = 1;
        constraints.gridwidth = 1;
        return constraints;
    }

    static GridBagConstraints getConstraintsForButtonAddForText3() {
        GridBagConstraints constraints = new GridBagConstraints();
        constraints.fill = GridBagConstraints.BOTH;
        constraints.weightx = 100.0;
        constraints.weighty = 100.0;

        constraints.insets.bottom = 5;
        constraints.insets.left = 5;
        constraints.insets.right = 5;
        constraints.insets.top = 5;

        constraints.ipadx = 0;

        constraints.gridx = 1;
        constraints.gridy = 2;
        constraints.gridheight = 1;
        constraints.gridwidth = 1;
        return constraints;
    }

    static GridBagConstraints getConstraintsForButtonAddForText4() {
        GridBagConstraints constraints = new GridBagConstraints();
        constraints.fill = GridBagConstraints.BOTH;
        constraints.weightx = 100.0;
        constraints.weighty = 100.0;

        constraints.insets.bottom = 5;
        constraints.insets.left = 5;
        constraints.insets.right = 5;
        constraints.insets.top = 5;

        constraints.ipadx = 0;

        constraints.gridx = 1;
        constraints.gridy = 3;
        constraints.gridheight = 1;
        constraints.gridwidth = 1;
        return constraints;
    }

    static GridBagConstraints getConstraintsForButtonAddForText5() {
        GridBagConstraints constraints = new GridBagConstraints();
        constraints.fill = GridBagConstraints.BOTH;
        constraints.weightx = 100.0;
        constraints.weighty = 100.0;

        constraints.insets.bottom = 5;
        constraints.insets.left = 5;
        constraints.insets.right = 5;
        constraints.insets.top = 5;

        constraints.ipadx = 0;

        constraints.gridx = 1;
        constraints.gridy = 4;
        constraints.gridheight = 1;
        constraints.gridwidth = 1;
        return constraints;
    }

    static GridBagConstraints getConstraintsForButtonAddForText6() {
        GridBagConstraints constraints = new GridBagConstraints();
        constraints.fill = GridBagConstraints.BOTH;
        constraints.weightx = 100.0;
        constraints.weighty = 100.0;

        constraints.insets.bottom = 5;
        constraints.insets.left = 5;
        constraints.insets.right = 5;
        constraints.insets.top = 5;

        constraints.ipadx = 0;

        constraints.gridx = 1;
        constraints.gridy = 5;
        constraints.gridheight = 1;
        constraints.gridwidth = 1;
        return constraints;
    }

    static GridBagConstraints getConstraintsForButtonAddForText7() {
        GridBagConstraints constraints = new GridBagConstraints();
        constraints.fill = GridBagConstraints.BOTH;
        constraints.weightx = 100.0;
        constraints.weighty = 100.0;

        constraints.insets.bottom = 5;
        constraints.insets.left = 5;
        constraints.insets.right = 5;
        constraints.insets.top = 5;

        constraints.ipadx = 0;

        constraints.gridx = 1;
        constraints.gridy = 6;
        constraints.gridheight = 1;
        constraints.gridwidth = 1;
        return constraints;
    }

    static GridBagConstraints getConstraintsForButtonAddForJLabel1() {
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
        constraints.gridy = 0;
        constraints.gridheight = 1;
        constraints.gridwidth = 1;
        return constraints;
    }

    static GridBagConstraints getConstraintsForButtonAddForJLabel2() {
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

    static GridBagConstraints getConstraintsForButtonAddForJLabel3() {
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

    static GridBagConstraints getConstraintsForButtonAddForJLabel4() {
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

    static GridBagConstraints getConstraintsForButtonAddForJLabel5() {
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
        constraints.gridy = 4;
        constraints.gridheight = 1;
        constraints.gridwidth = 1;
        return constraints;
    }

    static GridBagConstraints getConstraintsForButtonAddForJLabel6() {
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
        constraints.gridy = 5;
        constraints.gridheight = 1;
        constraints.gridwidth = 1;
        return constraints;
    }

    static GridBagConstraints getConstraintsForButtonAddForJLabel7() {
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
        constraints.gridy = 6;
        constraints.gridheight = 1;
        constraints.gridwidth = 1;
        return constraints;
    }

    static GridBagConstraints getConstraintsForButtonAddForJButtonSave() {
        GridBagConstraints constraints = new GridBagConstraints();
        constraints.fill = GridBagConstraints.BOTH;
        constraints.weightx = 100.0;
        constraints.weighty = 100.0;

        constraints.insets.bottom = 5;
        constraints.insets.left = 5;
        constraints.insets.right = 5;
        constraints.insets.top = 20;

        constraints.ipadx = 0;

        constraints.gridx = 1;
        constraints.gridy = 7;
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


    static GridBagConstraints getConstraintsForButtonFindJComboBox() {
        GridBagConstraints constraints = new GridBagConstraints();
        constraints.fill = GridBagConstraints.NONE;
        constraints.weightx = 100.0;
        constraints.weighty = 100.0;

        constraints.insets.bottom = 5;
        constraints.insets.left = 5;
        constraints.insets.right = 5;
        constraints.insets.top = 5;

        constraints.ipadx = 0;

        constraints.gridx = 0;
        constraints.gridy = 0;
        constraints.gridheight = 1;
        constraints.gridwidth = 1;
        return constraints;
    }

    static GridBagConstraints getConstraintsForButtonFindJButtonFirstPage() {
        GridBagConstraints constraints = new GridBagConstraints();
        constraints.fill = GridBagConstraints.NONE;
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

    static GridBagConstraints getConstraintsForButtonFindJButtonPreviousPage() {
        GridBagConstraints constraints = new GridBagConstraints();
        constraints.fill = GridBagConstraints.NONE;
        constraints.weightx = 100.0;
        constraints.weighty = 100.0;

        constraints.insets.bottom = 5;
        constraints.insets.left = 5;
        constraints.insets.right = 5;
        constraints.insets.top = 5;

        constraints.ipadx = 0;

        constraints.gridx = 2;
        constraints.gridy = 0;
        constraints.gridheight = 1;
        constraints.gridwidth = 1;
        return constraints;
    }

    static GridBagConstraints getConstraintsForButtonFindJLabelCurrentPage() {
        GridBagConstraints constraints = new GridBagConstraints();
        constraints.fill = GridBagConstraints.NONE;
        constraints.weightx = 100.0;
        constraints.weighty = 100.0;

        constraints.insets.bottom = 5;
        constraints.insets.left = 5;
        constraints.insets.right = 5;
        constraints.insets.top = 5;

        constraints.ipadx = 0;

        constraints.gridx = 3;
        constraints.gridy = 0;
        constraints.gridheight = 1;
        constraints.gridwidth = 1;
        return constraints;
    }

    static GridBagConstraints getConstraintsForButtonFindJButtonNextPage() {
        GridBagConstraints constraints = new GridBagConstraints();
        constraints.fill = GridBagConstraints.NONE;
        constraints.weightx = 100.0;
        constraints.weighty = 100.0;

        constraints.insets.bottom = 5;
        constraints.insets.left = 5;
        constraints.insets.right = 5;
        constraints.insets.top = 5;

        constraints.ipadx = 0;

        constraints.gridx = 4;
        constraints.gridy = 0;
        constraints.gridheight = 1;
        constraints.gridwidth = 1;
        return constraints;
    }

    static GridBagConstraints getConstraintsForButtonFindJButtonLastPage() {
        GridBagConstraints constraints = new GridBagConstraints();
        constraints.fill = GridBagConstraints.NONE;
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

    static GridBagConstraints getConstraintsForButtonFindJTable() {
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
        constraints.gridheight = 3;
        constraints.gridwidth = 6;
        return constraints;
    }

    static GridBagConstraints getConstraintsForButtonFindJComboBoxRowsOnPage() {
        GridBagConstraints constraints = new GridBagConstraints();
        constraints.fill = GridBagConstraints.NONE;
        constraints.weightx = 100.0;
        constraints.weighty = 100.0;

        constraints.insets.bottom = 5;
        constraints.insets.left = 5;
        constraints.insets.right = 5;
        constraints.insets.top = 5;

        constraints.ipadx = 0;

        constraints.gridx = 6;
        constraints.gridy = 0;
        constraints.gridheight = 1;
        constraints.gridwidth = 1;
        return constraints;
    }

    static GridBagConstraints getConstraintsForButtonFindJTextAreaRecordsOnPage() {
        GridBagConstraints constraints = new GridBagConstraints();
        constraints.fill = GridBagConstraints.BOTH;
        constraints.weightx = 100.0;
        constraints.weighty = 100.0;

        constraints.insets.bottom = 5;
        constraints.insets.left = 5;
        constraints.insets.right = 5;
        constraints.insets.top = 5;

        constraints.ipadx = 0;

        constraints.gridx = 6;
        constraints.gridy = 1;
        constraints.gridheight = 1;
        constraints.gridwidth = 1;
        return constraints;
    }

    static GridBagConstraints getConstraintsForButtonFindJTextAreaRecords() {
        GridBagConstraints constraints = new GridBagConstraints();
        constraints.fill = GridBagConstraints.BOTH;
        constraints.weightx = 100.0;
        constraints.weighty = 100.0;

        constraints.insets.bottom = 5;
        constraints.insets.left = 5;
        constraints.insets.right = 5;
        constraints.insets.top = 5;

        constraints.ipadx = 0;

        constraints.gridx = 6;
        constraints.gridy = 2;
        constraints.gridheight = 1;
        constraints.gridwidth = 1;
        return constraints;
    }

    static GridBagConstraints getConstraintsForButtonFindJTextAreaTotalPages() {
        GridBagConstraints constraints = new GridBagConstraints();
        constraints.fill = GridBagConstraints.BOTH;
        constraints.weightx = 100.0;
        constraints.weighty = 100.0;

        constraints.insets.bottom = 5;
        constraints.insets.left = 5;
        constraints.insets.right = 5;
        constraints.insets.top = 5;

        constraints.ipadx = 0;

        constraints.gridx = 6;
        constraints.gridy = 3;
        constraints.gridheight = 1;
        constraints.gridwidth = 1;
        return constraints;
    }

    static GridBagConstraints getConstraintsForButtonFindSearchStudentJLabel() {
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
        constraints.gridy = 0;
        constraints.gridheight = 1;
        constraints.gridwidth = 1;
        return constraints;
    }

    static GridBagConstraints getConstraintsForButtonFindSearchStudentTextField() {
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

    static GridBagConstraints getConstraintsForButtonFindSearchStudentButton() {
        GridBagConstraints constraints = new GridBagConstraints();
        constraints.fill = GridBagConstraints.NONE;
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

    static GridBagConstraints getConstraintsForButtonFindJRadioButtonIsMotherEditableForFindIndex2() {
        GridBagConstraints constraints = new GridBagConstraints();
        constraints.fill = GridBagConstraints.NONE;
        constraints.weightx = 100.0;
        constraints.weighty = 100.0;

        constraints.insets.bottom = 5;
        constraints.insets.left = 5;
        constraints.insets.right = 5;
        constraints.insets.top = 5;

        constraints.ipadx = 0;

        constraints.gridx = 0;
        constraints.gridy = 0;
        constraints.gridheight = 1;
        constraints.gridwidth = 1;
        return constraints;
    }

    static GridBagConstraints getConstraintsForButtonFindJRadioButtonIsFatherEditableForFindIndex2() {
        GridBagConstraints constraints = new GridBagConstraints();
        constraints.fill = GridBagConstraints.NONE;
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

    static GridBagConstraints getConstraintsForButtonFindJLabelMotherForFindIndex2() {
        GridBagConstraints constraints = new GridBagConstraints();
        constraints.fill = GridBagConstraints.NONE;
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

    static GridBagConstraints getConstraintsForButtonFindJLabelFatherForFindIndex2() {
        GridBagConstraints constraints = new GridBagConstraints();
        constraints.fill = GridBagConstraints.NONE;
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

    static GridBagConstraints getConstraintsForButtonFindJTextFieldMotherForFindIndex2() {
        GridBagConstraints constraints = new GridBagConstraints();
        constraints.fill = GridBagConstraints.HORIZONTAL;
        constraints.weightx = 100.0;
        constraints.weighty = 100.0;

        constraints.insets.bottom = 5;
        constraints.insets.left = 5;
        constraints.insets.right = 5;
        constraints.insets.top = 5;

        constraints.ipadx = 0;

        constraints.gridx = 1;
        constraints.gridy = 1;
        constraints.gridheight = 1;
        constraints.gridwidth = 1;
        return constraints;
    }

    static GridBagConstraints getConstraintsForButtonFindJTextFieldFatherForFindIndex2() {
        GridBagConstraints constraints = new GridBagConstraints();
        constraints.fill = GridBagConstraints.HORIZONTAL;
        constraints.weightx = 100.0;
        constraints.weighty = 100.0;

        constraints.insets.bottom = 5;
        constraints.insets.left = 5;
        constraints.insets.right = 5;
        constraints.insets.top = 5;

        constraints.ipadx = 0;

        constraints.gridx = 1;
        constraints.gridy = 2;
        constraints.gridheight = 1;
        constraints.gridwidth = 1;
        return constraints;
    }

    static GridBagConstraints getConstraintsForButtonFindJButtonForFindIndex2() {
        GridBagConstraints constraints = new GridBagConstraints();
        constraints.fill = GridBagConstraints.NONE;
        constraints.weightx = 100.0;
        constraints.weighty = 100.0;

        constraints.insets.bottom = 5;
        constraints.insets.left = 5;
        constraints.insets.right = 5;
        constraints.insets.top = 20;

        constraints.ipadx = 0;

        constraints.gridx = 1;
        constraints.gridy = 3;
        constraints.gridheight = 1;
        constraints.gridwidth = 1;
        return constraints;
    }

    static GridBagConstraints getConstraintsForButtonFindJRadioButtonFatherMoneyEnable() {
        GridBagConstraints constraints = new GridBagConstraints();
        constraints.fill = GridBagConstraints.NONE;
        constraints.weightx = 100.0;
        constraints.weighty = 100.0;

        constraints.insets.bottom = 5;
        constraints.insets.left = 5;
        constraints.insets.right = 5;
        constraints.insets.top = 20;

        constraints.ipadx = 0;

        constraints.gridx = 0;
        constraints.gridy = 0;
        constraints.gridheight = 1;
        constraints.gridwidth = 1;
        return constraints;
    }

    static GridBagConstraints getConstraintsForButtonFindJRadioButtonMotherMoneyEnable() {
        GridBagConstraints constraints = new GridBagConstraints();
        constraints.fill = GridBagConstraints.NONE;
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

    static GridBagConstraints getConstraintsForButtonFindJLabelFatherMaxForFindIndex4() {
        GridBagConstraints constraints = new GridBagConstraints();
        constraints.fill = GridBagConstraints.NONE;
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

    static GridBagConstraints getConstraintsForButtonFindJLabelFatherMinForFindIndex4() {
        GridBagConstraints constraints = new GridBagConstraints();
        constraints.fill = GridBagConstraints.NONE;
        constraints.weightx = 100.0;
        constraints.weighty = 100.0;

        constraints.insets.bottom = 5;
        constraints.insets.left = 5;
        constraints.insets.right = 5;
        constraints.insets.top = 5;

        constraints.ipadx = 0;

        constraints.gridx = 0;
        constraints.gridy = 4;
        constraints.gridheight = 1;
        constraints.gridwidth = 1;
        return constraints;
    }

    static GridBagConstraints getConstraintsForButtonFindJLabelMotherMaxForFindIndex4() {
        GridBagConstraints constraints = new GridBagConstraints();
        constraints.fill = GridBagConstraints.NONE;
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

    static GridBagConstraints getConstraintsForButtonFindJLabelMotherMinForFindIndex4() {
        GridBagConstraints constraints = new GridBagConstraints();
        constraints.fill = GridBagConstraints.NONE;
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

    static GridBagConstraints getConstraintsForButtonFindJTextFieldFatherMaxForFindIndex4() {
        GridBagConstraints constraints = new GridBagConstraints();
        constraints.fill = GridBagConstraints.HORIZONTAL;
        constraints.weightx = 100.0;
        constraints.weighty = 100.0;

        constraints.insets.bottom = 5;
        constraints.insets.left = 5;
        constraints.insets.right = 5;
        constraints.insets.top = 5;

        constraints.ipadx = 0;

        constraints.gridx = 1;
        constraints.gridy = 1;
        constraints.gridheight = 1;
        constraints.gridwidth = 1;
        return constraints;
    }

    static GridBagConstraints getConstraintsForButtonFindJTextFieldFatherMinForFindIndex4() {
        GridBagConstraints constraints = new GridBagConstraints();
        constraints.fill = GridBagConstraints.HORIZONTAL;
        constraints.weightx = 100.0;
        constraints.weighty = 100.0;

        constraints.insets.bottom = 5;
        constraints.insets.left = 5;
        constraints.insets.right = 5;
        constraints.insets.top = 5;

        constraints.ipadx = 0;

        constraints.gridx = 1;
        constraints.gridy = 2;
        constraints.gridheight = 1;
        constraints.gridwidth = 1;
        return constraints;
    }

    static GridBagConstraints getConstraintsForButtonFindJTextFieldMotherMaxForFindIndex4() {
        GridBagConstraints constraints = new GridBagConstraints();
        constraints.fill = GridBagConstraints.HORIZONTAL;
        constraints.weightx = 100.0;
        constraints.weighty = 100.0;

        constraints.insets.bottom = 5;
        constraints.insets.left = 5;
        constraints.insets.right = 5;
        constraints.insets.top = 5;

        constraints.ipadx = 0;

        constraints.gridx = 1;
        constraints.gridy = 3;
        constraints.gridheight = 1;
        constraints.gridwidth = 1;
        return constraints;
    }

    static GridBagConstraints getConstraintsForButtonFindJTextFieldMotherMinForFindIndex4() {
        GridBagConstraints constraints = new GridBagConstraints();
        constraints.fill = GridBagConstraints.HORIZONTAL;
        constraints.weightx = 100.0;
        constraints.weighty = 100.0;

        constraints.insets.bottom = 5;
        constraints.insets.left = 5;
        constraints.insets.right = 5;
        constraints.insets.top = 5;

        constraints.ipadx = 0;

        constraints.gridx = 1;
        constraints.gridy = 4;
        constraints.gridheight = 1;
        constraints.gridwidth = 1;
        return constraints;
    }

    static GridBagConstraints getConstraintsForButtonFindJButtonForFindIndex4() {
        GridBagConstraints constraints = new GridBagConstraints();
        constraints.fill = GridBagConstraints.NONE;
        constraints.weightx = 100.0;
        constraints.weighty = 100.0;

        constraints.insets.bottom = 5;
        constraints.insets.left = 5;
        constraints.insets.right = 5;
        constraints.insets.top = 20;

        constraints.ipadx = 0;

        constraints.gridx = 1;
        constraints.gridy = 5;
        constraints.gridheight = 1;
        constraints.gridwidth = 1;
        return constraints;
    }


}
