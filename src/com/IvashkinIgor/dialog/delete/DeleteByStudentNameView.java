package com.IvashkinIgor.dialog.delete;

import javax.swing.*;
import java.awt.*;

public class DeleteByStudentNameView extends JFrame {
    private JPanel jPanelForDeleteIndex1;
    private JLabel jLabelForDeleteIndex1;
    private JTextField jTextFieldForDeleteIndex1;
    private JButton jButtonForDeleteIndex1;

    private static DeleteByStudentNameView deleteByStudentNameView;

    public  JButton getJButtonForDeleteIndex1() {
        return jButtonForDeleteIndex1;
    }

    public  JTextField getJTextFieldForDeleteIndex1() {
        return jTextFieldForDeleteIndex1;
    }


    public static DeleteByStudentNameView getInstance() {
        if (deleteByStudentNameView == null){
            deleteByStudentNameView = new DeleteByStudentNameView();
        }
        return deleteByStudentNameView;
    }

    private DeleteByStudentNameView() {
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
        jPanelForDeleteIndex1 = new JPanel();
        GridBagLayout gridBagLayout = new GridBagLayout();
        jPanelForDeleteIndex1.setLayout(gridBagLayout);

        jLabelForDeleteIndex1 = new JLabel("Введите ФИО студента:");
        jTextFieldForDeleteIndex1 = new JTextField();
        jButtonForDeleteIndex1 = new JButton("Delete");

        add(jPanelForDeleteIndex1);
        jPanelForDeleteIndex1.add(jLabelForDeleteIndex1, DeleteByStudentNameConstraints.getConstraintsForButtonFindSearchStudentJLabel());
        jPanelForDeleteIndex1.add(jTextFieldForDeleteIndex1, DeleteByStudentNameConstraints.getConstraintsForButtonFindSearchStudentTextField());
        jPanelForDeleteIndex1.add(jButtonForDeleteIndex1, DeleteByStudentNameConstraints.getConstraintsForButtonFindSearchStudentButton());

        DeleteByStudentNameController.getInstance();
    }
}
