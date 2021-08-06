package com.IvashkinIgor.dialog.delete;

import javax.swing.*;

public class DeleteDialogView extends JFrame{

    private  JPanel  jPanelMainForDelete;
    private  JComboBox jComboBoxForDelete;


    private static DeleteDialogView deleteDialogView;


    public JPanel getJPanelMainForDelete() {
        return jPanelMainForDelete;
    }

    public static DeleteDialogView getDeleteDialogView() {
        return deleteDialogView;
    }



    public JComboBox getJComboBoxForDelete() {
        return jComboBoxForDelete;
    }

    public static DeleteDialogView getInstance(){
            if (deleteDialogView == null){
                deleteDialogView = new DeleteDialogView();
            }
            return deleteDialogView;
    }



        private DeleteDialogView(){
            super();
            setVisible(true);
            setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            setTitle("Title");
            setLocationRelativeTo(null);
            setSize(655, 270);
            ImageIcon imageIcon = new ImageIcon("C:\\Users\\Igor\\Desktop\\книги\\!!!PROFILI!!!\\картинки\\avesta\\l3r1WDtOWio.jpg");
            setIconImage(imageIcon.getImage());
        }

        public void initialize(){
            jPanelMainForDelete = new JPanel();
            add(jPanelMainForDelete);
            jComboBoxForDelete = new JComboBox(new String[]{" ","ФИО студента", "ФИО одного из родителей", "по числу братьев или сестер", "по размеру заработка одного из родителей"});
            jPanelMainForDelete.add(jComboBoxForDelete);

            DeleteByParentEarningView.getInstance().initialize();
            DeleteByParentNameView.getInstance().initialize();
            DeleteByStudentNameView.getInstance().initialize();
            DeleteByCountOfBrothersAndSistersView.getInstance().initialize();

            DeleteDialogController.getInstance();
        }
}
