package com.ivashkinigor.main;

import com.ivashkinigor.model.Model;
import com.ivashkinigor.model.Student;

import javax.swing.*;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.table.DefaultTableModel;
import java.util.List;


public class StudentTable extends JTable {
    private JScrollPane jScrollPane;
    private MainDialogView mainDialogView;
    private Model model;
    private DefaultTableModel defaultTableModel;
    private final Object[] COLUMN_HEADER = new String[]{"ФИО студента", "ФИО отца", "Заработок отца", "ФИО матери", "Заработок матери",
            "Число братьев", "Число сестёр"};

    private int rowsOnPageCountCurrent;
    private int rowsOnPageCountMax;
    private int totalRecordsCount;
    private int pagesCount;
    private int currentPage=1;
    private List<Student> workList;

    public StudentTable(MainDialogView mainDialogView){
        super(new DefaultTableModel(){
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        });
        defaultTableModel = (DefaultTableModel) this.getModel();
        defaultTableModel.setColumnIdentifiers(COLUMN_HEADER);
        this.mainDialogView = mainDialogView;
        this.model = new Model();
        jScrollPane= new JScrollPane(this);
        workList = model.getStudents();
        listenerInitialize();
    }


    public JScrollPane getJScrollPane() {
        return jScrollPane;
    }


    public Model getStudentModel() {
        return model;
    }

    public void setRowsOnPageCountMax(int rowsOnPageCountMax) {
        this.rowsOnPageCountMax = rowsOnPageCountMax;
    }

    public void setWorkList(List<Student> workList) {
        this.workList = workList;
        removeAllTableElements();
        showPage(1);
        rowsOnPageCountCurrent = defaultTableModel.getRowCount();
        totalRecordsCount = workList.size();
        pagesCount = pageCountCalculate();

        updateInformationComponent();
    }

    public void nextTablePage(){
        if (!(currentPage >= pagesCount)) {
            showPage(++currentPage);
        }
    }
    public void previousPage(){
        if (!(currentPage<= 1)){
            showPage(--currentPage);
        }
    }
    public void firstPage(){
        showPage(1);
    }
    public void lastPage(){
        showPage(pagesCount);
    }





    private void showPage(int index){
        removeAllTableElements();
        currentPage = index;
        mainDialogView.getJLabelCurrentPage().setText(String.valueOf(currentPage));
        for (int i=currentPage*rowsOnPageCountMax-rowsOnPageCountMax; i<currentPage*rowsOnPageCountMax;i++){
            try {
                defaultTableModel.addRow(splitStudent(workList.get(i)));
            }catch (Exception exception){
                return;
            }

        }
    }

    public void addRow(Student student){
        model.getStudents().add(student);
        totalRecordsCount = model.getStudents().size();
        pagesCount = pageCountCalculate();
        if (!(defaultTableModel.getRowCount()>= rowsOnPageCountMax)){
            defaultTableModel.addRow(splitStudent(student));
        }
        rowsOnPageCountCurrent = defaultTableModel.getRowCount();
        updateInformationComponent();
    }

    private void listenerInitialize(){


        defaultTableModel.addTableModelListener(new TableModelListener() {
            @Override
            public void tableChanged(TableModelEvent e) {
                rowsOnPageCountCurrent = defaultTableModel.getRowCount();
                totalRecordsCount = workList.size();
                pagesCount = pageCountCalculate();
                mainDialogView.getJLabelTotalPages().setText("Total pages\n\t" + pagesCount);

                mainDialogView.getJPanel().revalidate();
            }
        });
    }





    private int pageCountCalculate(){
        double pageCount = (double) model.getStudents().size() / rowsOnPageCountMax;
        if (pageCount == Double.POSITIVE_INFINITY){
            return 1;
        }
        if (pageCount %1 == 0){
            return (int) pageCount;
        }
        return (int) pageCount+1;
    }

    public void updateInformationComponent(){
        mainDialogView.getJLabelTotalPages().setText("Total pages\n\t" + pagesCount);
        mainDialogView.getJLabelNumbersOfRecords().setText("Numbers of records\n\t" + totalRecordsCount);
        mainDialogView.getJLabelNumbersOfRecordsOnPage().setText("Numbers of records on page\n\t" + rowsOnPageCountCurrent);
        mainDialogView.getJLabelCurrentPage().setText(String.valueOf(currentPage));
    }

    private void removeAllTableElements(){
        int rowCount = defaultTableModel.getRowCount();
        for (int i=0;i<rowCount;i++){
            defaultTableModel.removeRow(0);
        }
    }


    private String[] splitStudent(Student student){
        return new String[]{
                student.getName(),
                student.getFather().getName(),
                String.valueOf(student.getFather().getEarnings()),
                student.getMother().getName(),
                String.valueOf(student.getMother().getEarnings()),
                String.valueOf(student.getNumberOfBrothers()),
                String.valueOf(student.getNumberOfSisters())
        };
    }
}


