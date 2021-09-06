package com.ivashkinigor.student.swing.dialog.delete;

import com.ivashkinigor.student.swing.dialog.main.StudentTable;

import javax.swing.*;

public class DeleteDialogView extends JFrame{

    private  JPanel  jPanelMainForDelete;
    private  JComboBox jComboBoxForDelete;

    private DeleteByParentEarningView deleteByParentEarningView;
    private DeleteByParentNameView deleteByParentNameView;
    private DeleteByStudentNameView deleteByStudentNameView;
    private DeleteByCountOfBrothersAndSistersView deleteByCountOfBrothersAndSistersView;
    private StudentTable studentTable;


    public JComboBox getJComboBoxForDelete() {
        return jComboBoxForDelete;
    }



        public DeleteDialogView(StudentTable studentTable){
            super();
            setVisible(true);
            setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            setTitle("Title");
            setLocationRelativeTo(null);
            ImageIcon imageIcon = new ImageIcon("C:\\Users\\Igor\\Desktop\\книги\\!!!PROFILI!!!\\картинки\\avesta\\l3r1WDtOWio.jpg");
            setIconImage(imageIcon.getImage());
            this.studentTable = studentTable;
            initialize();
        }

        public void initialize(){
            jPanelMainForDelete = new JPanel();
            add(jPanelMainForDelete);
            jComboBoxForDelete = new JComboBox(new String[]{" ","ФИО студента", "ФИО одного из родителей", "по числу братьев или сестер", "по размеру заработка одного из родителей"});
            jPanelMainForDelete.add(jComboBoxForDelete);

            deleteByParentEarningView = new DeleteByParentEarningView(studentTable);
            deleteByParentNameView = new DeleteByParentNameView(studentTable);
            deleteByStudentNameView = new DeleteByStudentNameView(studentTable);
            deleteByCountOfBrothersAndSistersView = new DeleteByCountOfBrothersAndSistersView(studentTable);

            new DeleteDialogController(this,
                    deleteByParentEarningView,
                    deleteByParentNameView,
                    deleteByStudentNameView,
                    deleteByCountOfBrothersAndSistersView);
        }
}
