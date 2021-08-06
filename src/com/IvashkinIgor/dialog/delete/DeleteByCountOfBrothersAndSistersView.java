package com.IvashkinIgor.dialog.delete;

import javax.swing.*;
import java.awt.*;

public class DeleteByCountOfBrothersAndSistersView extends JFrame {

    private  JPanel jPanelDelete;
    private  JLabel jLabelBrother;
    private  JLabel jLabelSister;
    private  JTextField jTextFieldBrother;
    private  JTextField jTextFieldFSister;
    private  JButton jButtonDelete;
    private  JRadioButton jRadioButtonBrother;
    private  JRadioButton jRadioButtonSister;

    private static DeleteByCountOfBrothersAndSistersView deleteByCountOfBrothersAndSistersView;

    public static DeleteByCountOfBrothersAndSistersView getInstance(){
        if (deleteByCountOfBrothersAndSistersView == null){
            deleteByCountOfBrothersAndSistersView = new DeleteByCountOfBrothersAndSistersView();
        }
        return deleteByCountOfBrothersAndSistersView;
    }

    private DeleteByCountOfBrothersAndSistersView() {
        super();
        setVisible(false);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setTitle("Title");
        setLocationRelativeTo(null);
        setSize(655, 270);
        ImageIcon imageIcon = new ImageIcon("C:\\Users\\Igor\\Desktop\\книги\\!!!PROFILI!!!\\картинки\\avesta\\l3r1WDtOWio.jpg");
        setIconImage(imageIcon.getImage());
    }


    public JPanel getJPanelDelete() {
        return jPanelDelete;
    }

    public JLabel getJLabelBrother() {
        return jLabelBrother;
    }

    public static DeleteByCountOfBrothersAndSistersView getDeleteByCountOfBrothersAndSistersView() {
        return deleteByCountOfBrothersAndSistersView;
    }

    public JRadioButton getJRadioButtonSister() {
        return jRadioButtonSister;
    }

    public JRadioButton getJRadioButtonBrother() {
        return jRadioButtonBrother;
    }

    public JButton getJButtonDelete() {
        return jButtonDelete;
    }

    public JTextField getJTextFieldFSister() {
        return jTextFieldFSister;
    }

    public JTextField getJTextFieldBrother() {
        return jTextFieldBrother;
    }

    public JLabel getJLabelSister() {
        return jLabelSister;
    }

    public void initialize(){
        jPanelDelete = new JPanel();
        GridBagLayout gridBagLayout = new GridBagLayout();
        jPanelDelete.setLayout(gridBagLayout);
        add(jPanelDelete);

        jLabelBrother = new JLabel("Введите число братьев");
        jLabelSister = new JLabel("Введите число сестер");
        jTextFieldBrother = new JTextField();
        jTextFieldFSister = new JTextField();
        jButtonDelete = new JButton("Delete");
        jRadioButtonBrother = new JRadioButton("Ввести число братьев");
        jRadioButtonSister = new JRadioButton("Ввести число сестер");


        jPanelDelete.add(jRadioButtonBrother, DeleteByCountOfBrothersAndSistersConstraints.getConstraintsForButtonFindJRadioButtonIsMotherEditableForFindIndex2());
        jPanelDelete.add(jRadioButtonSister, DeleteByCountOfBrothersAndSistersConstraints.getConstraintsForButtonFindJRadioButtonIsFatherEditableForFindIndex2());
        jPanelDelete.add(jLabelBrother, DeleteByCountOfBrothersAndSistersConstraints.getConstraintsForButtonFindJLabelMotherForFindIndex2());
        jPanelDelete.add(jLabelSister, DeleteByCountOfBrothersAndSistersConstraints.getConstraintsForButtonFindJLabelFatherForFindIndex2());
        jPanelDelete.add(jTextFieldBrother, DeleteByCountOfBrothersAndSistersConstraints.getConstraintsForButtonFindJTextFieldMotherForFindIndex2());
        jPanelDelete.add(jTextFieldFSister, DeleteByCountOfBrothersAndSistersConstraints.getConstraintsForButtonFindJTextFieldFatherForFindIndex2());
        jPanelDelete.add(jButtonDelete, DeleteByCountOfBrothersAndSistersConstraints.getConstraintsForButtonFindJButtonForFindIndex2());



        jRadioButtonBrother.setSelected(true);
        jTextFieldFSister.setEditable(false);
        jTextFieldFSister.setBackground(this.getBackground());

        DeleteByCountOfBrothersAndSistersController.getInstance();
    }


}
