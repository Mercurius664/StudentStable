package com.ivashkinigor.student.swing.dialog.delete;

import com.ivashkinigor.student.swing.dialog.main.StudentTable;

import javax.swing.*;
import java.awt.*;

public class DeleteByParentNameView extends JFrame {

    private  JPanel jPanelDelete;
    private  JLabel jLabelMother;
    private  JLabel jLabelFather;
    private  JTextField jTextFieldMother;
    private  JTextField jTextFieldFather;
    private  JButton jButtonDelete;
    private  JRadioButton jRadioButtonMother;
    private  JRadioButton jRadioButtonFather;
    private StudentTable studentTable;


    public DeleteByParentNameView(StudentTable studentTable) {
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



    public  JRadioButton getJRadioButtonFather() {
        return jRadioButtonFather;
    }

    public  JRadioButton getJRadioButtonMother() {
        return jRadioButtonMother;
    }

    public  JButton getJButtonDelete() {
        return jButtonDelete;
    }

    public  JTextField getJTextFieldFather() {
        return jTextFieldFather;
    }

    public  JTextField getJTextFieldMother() {
        return jTextFieldMother;
    }

    public void initialize(){
        jPanelDelete = new JPanel();
        GridBagLayout gridBagLayout = new GridBagLayout();
        jPanelDelete.setLayout(gridBagLayout);
        add(jPanelDelete);

        jLabelMother = new JLabel("Введите ФИО матери");
        jLabelFather = new JLabel("Введите ФИО отца");
        jTextFieldMother = new JTextField();
        jTextFieldFather = new JTextField();
        jButtonDelete = new JButton("Find");
        jRadioButtonMother = new JRadioButton("Ввести ФИО матери");
        jRadioButtonFather = new JRadioButton("Ввести ФИО отца");


        jPanelDelete.add(jRadioButtonMother, DeleteByParentNameConstraints.getConstraintsForButtonFindJRadioButtonIsMotherEditableForFindIndex2());
        jPanelDelete.add(jRadioButtonFather, DeleteByParentNameConstraints.getConstraintsForButtonFindJRadioButtonIsFatherEditableForFindIndex2());
        jPanelDelete.add(jLabelMother, DeleteByParentNameConstraints.getConstraintsForButtonFindJLabelMotherForFindIndex2());
        jPanelDelete.add(jLabelFather, DeleteByParentNameConstraints.getConstraintsForButtonFindJLabelFatherForFindIndex2());
        jPanelDelete.add(jTextFieldMother, DeleteByParentNameConstraints.getConstraintsForButtonFindJTextFieldMotherForFindIndex2());
        jPanelDelete.add(jTextFieldFather, DeleteByParentNameConstraints.getConstraintsForButtonFindJTextFieldFatherForFindIndex2());
        jPanelDelete.add(jButtonDelete, DeleteByParentNameConstraints.getConstraintsForButtonFindJButtonForFindIndex2());

        jRadioButtonMother.setSelected(true);
        jTextFieldFather.setText("");
        jTextFieldFather.setEditable(false);
        jTextFieldFather.setBackground(this.getBackground());

        new DeleteByParentNameController(this,studentTable.getStudentModel());
    }

}
