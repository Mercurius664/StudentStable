package com.IvashkinIgor.dialog.add;

import javax.swing.*;
import java.awt.*;

public class AddDialogView extends JFrame {
    private  JPanel jPanelForAdd;
    private  JButton buttonSaveForAdd;
    private JTextField jTextFieldStudentName;
    private JTextField jTextFieldFatherName;
    private JTextField jTextFieldFatherEarning;
    private JTextField jTextFieldMotherName;
    private JTextField jTextFieldMotherEarning;
    private JTextField jTextFieldNumberOfBrothers;
    private JTextField jTextFieldNumberOfSisters;

    private static AddDialogView addDialogView;

    public static AddDialogView getInstance() {
        if (addDialogView == null){
            addDialogView = new AddDialogView();
        }
        return addDialogView;
    }


    public  JButton getButtonSaveForAdd() {
        return buttonSaveForAdd;
    }

    public JTextField getJTextFieldNumberOfSisters() {
        return jTextFieldNumberOfSisters;
    }

    public JTextField getJTextFieldNumberOfBrothers() {
        return jTextFieldNumberOfBrothers;
    }

    public JTextField getJTextFieldMotherEarning() {
        return jTextFieldMotherEarning;
    }

    public JTextField getJTextFieldMotherName() {
        return jTextFieldMotherName;
    }

    public JTextField getJTextFieldFatherEarning() {
        return jTextFieldFatherEarning;
    }

    public JTextField getJTextFieldFatherName() {
        return jTextFieldFatherName;
    }

    public JTextField getJTextFieldStudentName() {
        return jTextFieldStudentName;
    }

    private AddDialogView() {
        super();
        setVisible(true);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setTitle("Title");
        setLocationRelativeTo(null);
        setSize(655, 270);
        ImageIcon imageIcon = new ImageIcon("C:\\Users\\Igor\\Desktop\\книги\\!!!PROFILI!!!\\картинки\\avesta\\l3r1WDtOWio.jpg");
        setIconImage(imageIcon.getImage());

    }


    public void initialize() {
        jPanelForAdd = new JPanel();
        add(jPanelForAdd);
        GridBagLayout gridBagLayout = new GridBagLayout();
        jPanelForAdd.setLayout(gridBagLayout);
        buttonSaveForAdd = new JButton("Save");

        jTextFieldStudentName = new JTextField();
        jTextFieldStudentName.setDocument(new JTextFieldFilter());

        jTextFieldFatherName = new JTextField();
        jTextFieldFatherName.setDocument(new JTextFieldFilter());

        jTextFieldFatherEarning = new JTextField();
        jTextFieldFatherEarning.setDocument(new JTextFieldFilterNumber());

        jTextFieldMotherName = new JTextField();
        jTextFieldMotherName.setDocument(new JTextFieldFilter());

        jTextFieldMotherEarning = new JTextField();
        jTextFieldMotherEarning.setDocument(new JTextFieldFilterNumber());

        jTextFieldNumberOfBrothers = new JTextField();
        jTextFieldNumberOfBrothers.setDocument(new JTextFieldFilterNumber());

        jTextFieldNumberOfSisters = new JTextField();
        jTextFieldNumberOfSisters.setDocument(new JTextFieldFilterNumber());


        JLabel jLabel1 = new JLabel("ФИО студента");
        JLabel jLabel2 = new JLabel("ФИО отца");
        JLabel jLabel3 = new JLabel("Заработок отца");
        JLabel jLabel4 = new JLabel("ФИО матери");
        JLabel jLabel5 = new JLabel("Заработок матери");
        JLabel jLabel6 = new JLabel("Число братьев");
        JLabel jLabel7 = new JLabel("Число сестёр");

        jPanelForAdd.add(jTextFieldStudentName, GridBagConstraints.getConstraintsForButtonAddForText1());
        jPanelForAdd.add(jTextFieldFatherName, GridBagConstraints.getConstraintsForButtonAddForText2());
        jPanelForAdd.add(jTextFieldFatherEarning, GridBagConstraints.getConstraintsForButtonAddForText3());
        jPanelForAdd.add(jTextFieldMotherName, GridBagConstraints.getConstraintsForButtonAddForText4());
        jPanelForAdd.add(jTextFieldMotherEarning, GridBagConstraints.getConstraintsForButtonAddForText5());
        jPanelForAdd.add(jTextFieldNumberOfBrothers, GridBagConstraints.getConstraintsForButtonAddForText6());
        jPanelForAdd.add(jTextFieldNumberOfSisters, GridBagConstraints.getConstraintsForButtonAddForText7());

        jPanelForAdd.add(jLabel1, GridBagConstraints.getConstraintsForButtonAddForJLabel1());
        jPanelForAdd.add(jLabel2, GridBagConstraints.getConstraintsForButtonAddForJLabel2());
        jPanelForAdd.add(jLabel3, GridBagConstraints.getConstraintsForButtonAddForJLabel3());
        jPanelForAdd.add(jLabel4, GridBagConstraints.getConstraintsForButtonAddForJLabel4());
        jPanelForAdd.add(jLabel5, GridBagConstraints.getConstraintsForButtonAddForJLabel5());
        jPanelForAdd.add(jLabel6, GridBagConstraints.getConstraintsForButtonAddForJLabel6());
        jPanelForAdd.add(jLabel7, GridBagConstraints.getConstraintsForButtonAddForJLabel7());

        jPanelForAdd.add(buttonSaveForAdd, GridBagConstraints.getConstraintsForButtonAddForJButtonSave());

        new AddDialogController(this);

        revalidate();
    }
}
