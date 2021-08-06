package com.IvashkinIgor.dialog.find;

import javax.swing.*;
import java.awt.*;

public class FindByParentEarningView extends JFrame{

    private JPanel jPanelForFindIndex4;
    private JLabel jLabelMotherMinForFindIndex4;
    private JLabel jLabelMotherMaxForFindIndex4;
    private JLabel jLabelFatherMinForFindIndex4;
    private JLabel jLabelFatherMaxForFindIndex4;
    private JTextField jTextFieldMotherMinForFindIndex4;
    private JTextField jTextFieldMotherMaxForFindIndex4;
    private JTextField jTextFieldFatherMinForFindIndex4;
    private JTextField jTextFieldFatherMaxForFindIndex4;
    private JButton jButtonForFindIndex4;
    private JRadioButton jRadioButtonMotherMoneyEnable;
    private JRadioButton jRadioButtonFatherMoneyEnable;

    private static FindByParentEarningView findByParentEarningView;


    public static FindByParentEarningView getFindByParentEarningView() {
        return findByParentEarningView;
    }

    public JRadioButton getJRadioButtonFatherMoneyEnable() {
        return jRadioButtonFatherMoneyEnable;
    }

    public JRadioButton getJRadioButtonMotherMoneyEnable() {
        return jRadioButtonMotherMoneyEnable;
    }

    public JButton getJButtonForFindIndex4() {
        return jButtonForFindIndex4;
    }

    public JTextField getJTextFieldFatherMaxForFindIndex4() {
        return jTextFieldFatherMaxForFindIndex4;
    }

    public JTextField getJTextFieldFatherMinForFindIndex4() {
        return jTextFieldFatherMinForFindIndex4;
    }

    public JTextField getJTextFieldMotherMaxForFindIndex4() {
        return jTextFieldMotherMaxForFindIndex4;
    }

    public JTextField getJTextFieldMotherMinForFindIndex4() {
        return jTextFieldMotherMinForFindIndex4;
    }

    public JLabel getJLabelFatherMaxForFindIndex4() {
        return jLabelFatherMaxForFindIndex4;
    }

    public JLabel getJLabelFatherMinForFindIndex4() {
        return jLabelFatherMinForFindIndex4;
    }

    public JLabel getJLabelMotherMaxForFindIndex4() {
        return jLabelMotherMaxForFindIndex4;
    }

    public JLabel getJLabelMotherMinForFindIndex4() {
        return jLabelMotherMinForFindIndex4;
    }

    public JPanel getJPanelForFindIndex4() {
        return jPanelForFindIndex4;
    }

    public static FindByParentEarningView getInstance() {
        if (findByParentEarningView == null){
            findByParentEarningView = new FindByParentEarningView();
        }
        return findByParentEarningView;
    }

    private FindByParentEarningView() {
        super();
        setVisible(false);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setTitle("Title");
        setLocationRelativeTo(null);
        setSize(655, 270);
        ImageIcon imageIcon = new ImageIcon("C:\\Users\\Igor\\Desktop\\книги\\!!!PROFILI!!!\\картинки\\avesta\\l3r1WDtOWio.jpg");
        setIconImage(imageIcon.getImage());
    }
    public void initialize(){
        jPanelForFindIndex4 = new JPanel();
        GridBagLayout gridBagLayout = new GridBagLayout();
        jPanelForFindIndex4.setLayout(gridBagLayout);
        add(jPanelForFindIndex4);

        jLabelFatherMaxForFindIndex4 = new JLabel("Введите зарплату матери до:");
        jLabelFatherMinForFindIndex4 = new JLabel("Введите зарплату матери от:");
        jLabelMotherMaxForFindIndex4 = new JLabel("Введите зарплату отца до:");
        jLabelMotherMinForFindIndex4 = new JLabel("Введите зарплату отца от:");

        jTextFieldFatherMaxForFindIndex4 = new JTextField();
        jTextFieldFatherMinForFindIndex4 = new JTextField();
        jTextFieldMotherMaxForFindIndex4 = new JTextField();
        jTextFieldMotherMinForFindIndex4 = new JTextField();

        jButtonForFindIndex4= new JButton("Find");
        jRadioButtonFatherMoneyEnable = new JRadioButton("Ввести зарплату отца");
        jRadioButtonMotherMoneyEnable = new JRadioButton("Ввести зарплату матери");




        jPanelForFindIndex4.add(jLabelFatherMaxForFindIndex4, FindByParentEarningConstraints.getConstraintsForButtonFindJLabelFatherMaxForFindIndex4());
        jPanelForFindIndex4.add(jLabelFatherMinForFindIndex4, FindByParentEarningConstraints.getConstraintsForButtonFindJLabelFatherMinForFindIndex4());
        jPanelForFindIndex4.add(jLabelMotherMaxForFindIndex4, FindByParentEarningConstraints.getConstraintsForButtonFindJLabelMotherMaxForFindIndex4());
        jPanelForFindIndex4.add(jLabelMotherMinForFindIndex4, FindByParentEarningConstraints.getConstraintsForButtonFindJLabelMotherMinForFindIndex4());
        jPanelForFindIndex4.add(jTextFieldFatherMaxForFindIndex4, FindByParentEarningConstraints.getConstraintsForButtonFindJTextFieldFatherMaxForFindIndex4());
        jPanelForFindIndex4.add(jTextFieldFatherMinForFindIndex4, FindByParentEarningConstraints.getConstraintsForButtonFindJTextFieldFatherMinForFindIndex4());
        jPanelForFindIndex4.add(jTextFieldMotherMaxForFindIndex4, FindByParentEarningConstraints.getConstraintsForButtonFindJTextFieldMotherMaxForFindIndex4());
        jPanelForFindIndex4.add(jTextFieldMotherMinForFindIndex4, FindByParentEarningConstraints.getConstraintsForButtonFindJTextFieldMotherMinForFindIndex4());
        jPanelForFindIndex4.add(jButtonForFindIndex4, FindByParentEarningConstraints.getConstraintsForButtonFindJButtonForFindIndex4());
        jPanelForFindIndex4.add(jRadioButtonFatherMoneyEnable, FindByParentEarningConstraints.getConstraintsForButtonFindJRadioButtonFatherMoneyEnable());
        jPanelForFindIndex4.add(jRadioButtonMotherMoneyEnable, FindByParentEarningConstraints.getConstraintsForButtonFindJRadioButtonMotherMoneyEnable());

        jRadioButtonFatherMoneyEnable.setSelected(true);
        jTextFieldMotherMaxForFindIndex4.setEditable(false);
        jTextFieldMotherMaxForFindIndex4.setBackground(this.getBackground());

        jTextFieldMotherMinForFindIndex4.setEditable(false);
        jTextFieldMotherMinForFindIndex4.setBackground(this.getBackground());


        FindByParentEarningController.getInstance();
    }

}
