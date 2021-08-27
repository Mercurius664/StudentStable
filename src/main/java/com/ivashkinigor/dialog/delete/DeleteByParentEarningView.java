package com.ivashkinigor.dialog.delete;

import com.ivashkinigor.main.StudentTable;

import javax.swing.*;
import java.awt.*;

public class DeleteByParentEarningView extends JFrame{

    private  JPanel jPanelForDeleteIndex4;
    private  JLabel jLabelMotherMinForDeleteIndex4;
    private  JLabel jLabelMotherMaxForDeleteIndex4;
    private  JLabel jLabelFatherMinForDeleteIndex4;
    private  JLabel jLabelFatherMaxForDeleteIndex4;
    private  JTextField jTextFieldMotherMinForDeleteIndex4;
    private  JTextField jTextFieldMotherMaxForDeleteIndex4;
    private  JTextField jTextFieldFatherMinForDeleteIndex4;
    private  JTextField jTextFieldFatherMaxForDeleteIndex4;
    private  JButton jButtonForDeleteIndex4;
    private  JRadioButton jRadioButtonMotherMoneyDeleteEnable;
    private  JRadioButton jRadioButtonFatherMoneyDeleteEnable;
    private StudentTable studentTable;


    public DeleteByParentEarningView(StudentTable studentTable) {
        super();
        setVisible(false);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setTitle("Title");
        setLocationRelativeTo(null);
        setSize(655, 270);
        ImageIcon imageIcon = new ImageIcon("C:\\Users\\Igor\\Desktop\\книги\\!!!PROFILI!!!\\картинки\\avesta\\l3r1WDtOWio.jpg");
        setIconImage(imageIcon.getImage());
        this.studentTable = studentTable;
        initialize();
    }

    public  JRadioButton getJRadioButtonFatherMoneyDeleteEnable() {
        return jRadioButtonFatherMoneyDeleteEnable;
    }

    public  JRadioButton getJRadioButtonMotherMoneyDeleteEnable() {
        return jRadioButtonMotherMoneyDeleteEnable;
    }

    public  JButton getJButtonForDeleteIndex4() {
        return jButtonForDeleteIndex4;
    }

    public  JTextField getJTextFieldFatherMaxForDeleteIndex4() {
        return jTextFieldFatherMaxForDeleteIndex4;
    }

    public  JTextField getJTextFieldFatherMinForDeleteIndex4() {
        return jTextFieldFatherMinForDeleteIndex4;
    }

    public  JTextField getJTextFieldMotherMaxForDeleteIndex4() {
        return jTextFieldMotherMaxForDeleteIndex4;
    }

    public  JTextField getJTextFieldMotherMinForDeleteIndex4() {
        return jTextFieldMotherMinForDeleteIndex4;
    }


    public void initialize(){
        jPanelForDeleteIndex4 = new JPanel();
        GridBagLayout gridBagLayout = new GridBagLayout();
        jPanelForDeleteIndex4.setLayout(gridBagLayout);
        add(jPanelForDeleteIndex4);

        jLabelFatherMaxForDeleteIndex4 = new JLabel("Введите зарплату матери до:");
        jLabelFatherMinForDeleteIndex4 = new JLabel("Введите зарплату матери от:");
        jLabelMotherMaxForDeleteIndex4 = new JLabel("Введите зарплату отца до:");
        jLabelMotherMinForDeleteIndex4 = new JLabel("Введите зарплату отца от:");

        jTextFieldFatherMaxForDeleteIndex4 = new JTextField();
        jTextFieldFatherMinForDeleteIndex4 = new JTextField();
        jTextFieldMotherMaxForDeleteIndex4 = new JTextField();
        jTextFieldMotherMinForDeleteIndex4 = new JTextField();

        jButtonForDeleteIndex4= new JButton("Delete");
        jRadioButtonFatherMoneyDeleteEnable = new JRadioButton("Ввести зарплату отца");
        jRadioButtonMotherMoneyDeleteEnable = new JRadioButton("Ввести зарплату матери");




        jPanelForDeleteIndex4.add(jLabelFatherMaxForDeleteIndex4, DeleteByParentEarningConstraints.getConstraintsForButtonFindJLabelFatherMaxForFindIndex4());
        jPanelForDeleteIndex4.add(jLabelFatherMinForDeleteIndex4, DeleteByParentEarningConstraints.getConstraintsForButtonFindJLabelFatherMinForFindIndex4());
        jPanelForDeleteIndex4.add(jLabelMotherMaxForDeleteIndex4, DeleteByParentEarningConstraints.getConstraintsForButtonFindJLabelMotherMaxForFindIndex4());
        jPanelForDeleteIndex4.add(jLabelMotherMinForDeleteIndex4, DeleteByParentEarningConstraints.getConstraintsForButtonFindJLabelMotherMinForFindIndex4());
        jPanelForDeleteIndex4.add(jTextFieldFatherMaxForDeleteIndex4, DeleteByParentEarningConstraints.getConstraintsForButtonFindJTextFieldFatherMaxForFindIndex4());
        jPanelForDeleteIndex4.add(jTextFieldFatherMinForDeleteIndex4, DeleteByParentEarningConstraints.getConstraintsForButtonFindJTextFieldFatherMinForFindIndex4());
        jPanelForDeleteIndex4.add(jTextFieldMotherMaxForDeleteIndex4, DeleteByParentEarningConstraints.getConstraintsForButtonFindJTextFieldMotherMaxForFindIndex4());
        jPanelForDeleteIndex4.add(jTextFieldMotherMinForDeleteIndex4, DeleteByParentEarningConstraints.getConstraintsForButtonFindJTextFieldMotherMinForFindIndex4());
        jPanelForDeleteIndex4.add(jButtonForDeleteIndex4, DeleteByParentEarningConstraints.getConstraintsForButtonFindJButtonForFindIndex4());
        jPanelForDeleteIndex4.add(jRadioButtonFatherMoneyDeleteEnable, DeleteByParentEarningConstraints.getConstraintsForButtonFindJRadioButtonFatherMoneyEnable());
        jPanelForDeleteIndex4.add(jRadioButtonMotherMoneyDeleteEnable, DeleteByParentEarningConstraints.getConstraintsForButtonFindJRadioButtonMotherMoneyEnable());

        jRadioButtonFatherMoneyDeleteEnable.setSelected(true);
        jTextFieldMotherMaxForDeleteIndex4.setEditable(false);
        jTextFieldMotherMaxForDeleteIndex4.setBackground(this.getBackground());

        jTextFieldMotherMinForDeleteIndex4.setEditable(false);
        jTextFieldMotherMinForDeleteIndex4.setBackground(this.getBackground());


        new DeleteByParentEarningController(this,studentTable);
    }

}
