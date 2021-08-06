package com.IvashkinIgor.dialog.find;

import javax.swing.*;
import java.awt.*;

public class FindByParentNameView extends JFrame {

    private JPanel jPanelForFindIndex2;
    private JLabel jLabelMotherForFindIndex2;
    private JLabel jLabelFatherForFindIndex2;
    private JTextField jTextFieldMotherForFindIndex2;
    private JTextField jTextFieldFatherForFindIndex2;
    private JButton jButtonForFindIndex2;
    private JRadioButton jRadioButtonMotherEnable;
    private JRadioButton jRadioButtonFatherEnable;

    private static FindByParentNameView findByParentNameView;

    public static FindByParentNameView getInstance(){
        if (findByParentNameView == null){
            findByParentNameView = new FindByParentNameView();
        }
        return findByParentNameView;
    }


    public  JRadioButton getJRadioButtonFatherEnable() {
        return jRadioButtonFatherEnable;
    }

    public  JRadioButton getJRadioButtonMotherEnable() {
        return jRadioButtonMotherEnable;
    }

    public  JButton getJButtonForFindIndex2() {
        return jButtonForFindIndex2;
    }

    public  JTextField getJTextFieldFatherForFindIndex2() {
        return jTextFieldFatherForFindIndex2;
    }

    public  JTextField getJTextFieldMotherForFindIndex2() {
        return jTextFieldMotherForFindIndex2;
    }

    public  JLabel getJLabelFatherForFindIndex2() {
        return jLabelFatherForFindIndex2;
    }

    public  JLabel getJLabelMotherForFindIndex2() {
        return jLabelMotherForFindIndex2;
    }

    public  JPanel getJPanelForFindIndex2() {
        return jPanelForFindIndex2;
    }

    private FindByParentNameView() {
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
        jPanelForFindIndex2 = new JPanel();
        GridBagLayout gridBagLayout = new GridBagLayout();
        jPanelForFindIndex2.setLayout(gridBagLayout);
        add(jPanelForFindIndex2);

        jLabelMotherForFindIndex2 = new JLabel("Введите ФИО матери");
        jLabelFatherForFindIndex2 = new JLabel("Введите ФИО отца");
        jTextFieldMotherForFindIndex2 = new JTextField();
        jTextFieldFatherForFindIndex2 = new JTextField();
        jButtonForFindIndex2 = new JButton("Find");
        jRadioButtonMotherEnable = new JRadioButton("Ввести ФИО матери");
        jRadioButtonFatherEnable = new JRadioButton("Ввести ФИО отца");


        jPanelForFindIndex2.add(jRadioButtonMotherEnable, FindByParentNameConstraints.getConstraintsForButtonFindJRadioButtonIsMotherEditableForFindIndex2());
        jPanelForFindIndex2.add(jRadioButtonFatherEnable, FindByParentNameConstraints.getConstraintsForButtonFindJRadioButtonIsFatherEditableForFindIndex2());
        jPanelForFindIndex2.add(jLabelMotherForFindIndex2, FindByParentNameConstraints.getConstraintsForButtonFindJLabelMotherForFindIndex2());
        jPanelForFindIndex2.add(jLabelFatherForFindIndex2, FindByParentNameConstraints.getConstraintsForButtonFindJLabelFatherForFindIndex2());
        jPanelForFindIndex2.add(jTextFieldMotherForFindIndex2, FindByParentNameConstraints.getConstraintsForButtonFindJTextFieldMotherForFindIndex2());
        jPanelForFindIndex2.add(jTextFieldFatherForFindIndex2, FindByParentNameConstraints.getConstraintsForButtonFindJTextFieldFatherForFindIndex2());
        jPanelForFindIndex2.add(jButtonForFindIndex2, FindByParentNameConstraints.getConstraintsForButtonFindJButtonForFindIndex2());

        jRadioButtonMotherEnable.setSelected(true);
        jTextFieldFatherForFindIndex2.setText("");
        jTextFieldFatherForFindIndex2.setEditable(false);
        jTextFieldFatherForFindIndex2.setBackground(this.getBackground());

        FindByParentNameController.getInstance();
    }

}
