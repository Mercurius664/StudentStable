package com.IvashkinIgor.dialog.find;

import com.IvashkinIgor.model.Model;
import com.IvashkinIgor.model.Student;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;

public class FindDialogView extends JFrame {

    private JPanel jPanelForFind;
    private JComboBox jComboBoxForButtonFind = new JComboBox(new String[]{" ", "ФИО студента", "ФИО одного из родителей", "по числу братьев или сестер", "по размеру заработка одного из родителей"});

    private JTable jTableForButtonFind;
    private DefaultTableModel defaultTableModelForButtonFind;
    private JScrollPane jScrollPaneForButtonFind;
    private JButton jButtonForButtonFindFirstPage;
    private JButton jButtonForButtonFindPreviousPage;
    private JLabel jLabelCurrentPageForButtonFind;
    private JButton jButtonForButtonFindNextPage;
    private JButton jButtonForButtonFindLastPage;
    private JComboBox jComboBoxForButtonFindRowsOnPage;
    private JTextArea jTextAreaRecordsOnPage;
    private JTextArea jTextAreaRecords;
    private JTextArea jTextAreaTotalPages;
    private int numbersOfRecordsForFind = 0;
    private int totalPagesForFind = 0;
    private int currentPageNumberForFind = 1;
    private int numberOfRowsOnPageForFind;

    private FindByCountOfBrothersAndSistersView findByCountOfBrothersAndSistersView;
    private FindByParentEarningView findByParentEarningView;
    private FindByParentNameView findByParentNameView;
    private FindByStudentNameView findByStudentNameView;




    private static FindDialogView findDialogView;

    public static FindDialogView getInstance() {
        if (findDialogView == null){
            findDialogView = new FindDialogView();
        }
        return findDialogView;
    }



    public void setNumberOfRowsOnPageForFind(int numberOfRowsOnPageForFind) {
        this.numberOfRowsOnPageForFind = numberOfRowsOnPageForFind;
    }

    public int getCurrentPageNumberForFind() {
        return currentPageNumberForFind;
    }

    public int getTotalPagesForFind() {
        return totalPagesForFind;
    }

    public int getNumbersOfRecordsForFind() {
        return numbersOfRecordsForFind;
    }

    public JTextArea getJTextAreaRecords() {
        return jTextAreaRecords;
    }

    public JComboBox getJComboBoxForButtonFindRowsOnPage() {
        return jComboBoxForButtonFindRowsOnPage;
    }

    public JButton getJButtonForButtonFindLastPage() {
        return jButtonForButtonFindLastPage;
    }

    public JButton getJButtonForButtonFindNextPage() {
        return jButtonForButtonFindNextPage;
    }

    public JButton getJButtonForButtonFindPreviousPage() {
        return jButtonForButtonFindPreviousPage;
    }

    public JButton getJButtonForButtonFindFirstPage() {
        return jButtonForButtonFindFirstPage;
    }

    public JScrollPane getJScrollPaneForButtonFind() {
        return jScrollPaneForButtonFind;
    }


    public JComboBox getJComboBoxForButtonFind() {
        return jComboBoxForButtonFind;
    }

    private FindDialogView() {
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
        jPanelForFind = new JPanel();
        add(jPanelForFind);
        GridBagLayout gridBagLayout = new GridBagLayout();
        jPanelForFind.setLayout(gridBagLayout);

        defaultTableModelForButtonFind = new DefaultTableModel();
        Object[] columnsHeader = new String[]{"ФИО студента", "ФИО отца", "Заработок отца", "ФИО матери", "Заработок матери",
                "Число братьев", "Число сестёр"};
        defaultTableModelForButtonFind.setColumnIdentifiers(columnsHeader);
        jTableForButtonFind = new JTable(defaultTableModelForButtonFind) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        jScrollPaneForButtonFind = new JScrollPane(jTableForButtonFind);
        jButtonForButtonFindFirstPage = new JButton("First page");
        jButtonForButtonFindPreviousPage = new JButton("Previous page");
        jLabelCurrentPageForButtonFind = new JLabel("1");
        jButtonForButtonFindNextPage = new JButton("Next");
        jButtonForButtonFindLastPage = new JButton("LastPage");
        jComboBoxForButtonFindRowsOnPage = new JComboBox(new String[]{"0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10"});

        jTextAreaRecordsOnPage = new JTextArea("Количество записей на странице:\n\t" + defaultTableModelForButtonFind.getRowCount());
        jTextAreaRecordsOnPage.setEditable(false);
        jTextAreaRecordsOnPage.setFont(jTextAreaRecordsOnPage.getFont().deriveFont(Font.BOLD, jTextAreaRecordsOnPage.getFont().getSize()));
        jTextAreaRecordsOnPage.setBackground(this.getBackground());

        jTextAreaRecords = new JTextArea("Количество записей (общее):\n\t" + numbersOfRecordsForFind);
        jTextAreaRecords.setEditable(false);
        jTextAreaRecords.setFont(jTextAreaRecords.getFont().deriveFont(Font.BOLD, jTextAreaRecords.getFont().getSize()));
        jTextAreaRecords.setBackground(this.getBackground());

        jTextAreaTotalPages = new JTextArea("Количество страниц (общее):\n\t" + totalPagesForFind);
        jTextAreaTotalPages.setEditable(false);
        jTextAreaTotalPages.setFont(jTextAreaTotalPages.getFont().deriveFont(Font.BOLD, jTextAreaTotalPages.getFont().getSize()));
        jTextAreaTotalPages.setBackground(this.getBackground());

        jPanelForFind.add(jComboBoxForButtonFind, FindDialogViewConstraints.getConstraintsForButtonFindJComboBox());
        jPanelForFind.add(jButtonForButtonFindFirstPage, FindDialogViewConstraints.getConstraintsForButtonFindJButtonFirstPage());
        jPanelForFind.add(jButtonForButtonFindPreviousPage, FindDialogViewConstraints.getConstraintsForButtonFindJButtonPreviousPage());
        jPanelForFind.add(jLabelCurrentPageForButtonFind, FindDialogViewConstraints.getConstraintsForButtonFindJLabelCurrentPage());
        jPanelForFind.add(jButtonForButtonFindNextPage, FindDialogViewConstraints.getConstraintsForButtonFindJButtonNextPage());
        jPanelForFind.add(jButtonForButtonFindLastPage, FindDialogViewConstraints.getConstraintsForButtonFindJButtonLastPage());
        jPanelForFind.add(jScrollPaneForButtonFind, FindDialogViewConstraints.getConstraintsForButtonFindJTable());
        jPanelForFind.add(jComboBoxForButtonFindRowsOnPage, FindDialogViewConstraints.getConstraintsForButtonFindJComboBoxRowsOnPage());
        jPanelForFind.add(jTextAreaRecordsOnPage, FindDialogViewConstraints.getConstraintsForButtonFindJTextAreaRecordsOnPage());
        jPanelForFind.add(jTextAreaRecords, FindDialogViewConstraints.getConstraintsForButtonFindJTextAreaRecords());
        jPanelForFind.add(jTextAreaTotalPages, FindDialogViewConstraints.getConstraintsForButtonFindJTextAreaTotalPages());



        jPanelForFind.revalidate();


        findByCountOfBrothersAndSistersView = FindByCountOfBrothersAndSistersView.getInstance();
        findByCountOfBrothersAndSistersView.initialize();

        findByParentEarningView = FindByParentEarningView.getInstance();
        findByParentEarningView.initialize();

        findByParentNameView = FindByParentNameView.getInstance();
        findByParentNameView.initialize();

        findByStudentNameView = FindByStudentNameView.getInstance();
        findByStudentNameView.initialize();

        closeFindFrame();
        FindDialogController.getInstance();
    }

    public DefaultTableModel getDefaultTableModelForButtonFind() {
        return defaultTableModelForButtonFind;
    }

    public int getNumberOfRowsOnPageForFind() {
        return numberOfRowsOnPageForFind;
    }

    public JPanel getJPanelForFind() {
        return jPanelForFind;
    }

    public JTable getJTableForButtonFind() {
        return jTableForButtonFind;
    }

    public void setNumbersOfRecordsForFind(int numbersOfRecordsForFind) {
        this.numbersOfRecordsForFind = numbersOfRecordsForFind;
    }

    public void setTotalPagesForFind(int totalPagesForFind) {
        this.totalPagesForFind = totalPagesForFind;
    }

    public void setJTextAreaRecordsOnPage() {
        jTextAreaRecordsOnPage.setText("Количество записей на странице:\n\t" + defaultTableModelForButtonFind.getRowCount());
    }

    public void setJTextAreaRecords() {
        jTextAreaRecords.setText("Количество записей (общее):\n\t" + numbersOfRecordsForFind);
    }

    public void setJTextAreaTotalPages() {
        jTextAreaTotalPages.setText("Количество страниц (общее):\n\t" + totalPagesForFind);
    }

    public void setCurrentPageNumberForFind(int currentPageNumberForFind) {
        this.currentPageNumberForFind = currentPageNumberForFind;
        jLabelCurrentPageForButtonFind.setText(String.valueOf(currentPageNumberForFind));
        jPanelForFind.revalidate();
    }

    public void findFrameInformationUpdate() {
        ArrayList<Student> studentArrayList = Model.getInstance().getStudentArrayListForFind();
        setNumbersOfRecordsForFind(studentArrayList.size());
        int a = 0;
        try {
            a = studentArrayList.size() / jComboBoxForButtonFindRowsOnPage.getSelectedIndex();
            if (a * jComboBoxForButtonFindRowsOnPage.getSelectedIndex() < studentArrayList.size()) {
                a++;
            }
        } catch (Exception exception) {
            a = 1;
        }
        if (a <= 0) {
            a = 1;
        }


        setTotalPagesForFind(a);
        setJTextAreaRecordsOnPage();
        setJTextAreaRecords();
        setJTextAreaTotalPages();
    }

    public  void disableAllFindFrames() {
        findByCountOfBrothersAndSistersView.setVisible(false);
        findByParentEarningView.setVisible(false);
        findByParentNameView.setVisible(false);
        findByStudentNameView.setVisible(false);
    }


    private static void numberOfRowsOnPageLogic(DefaultTableModel defaultTableModel, ArrayList<Student> arrayList, int numberOfRows, int currentPage) {

        int rowCount = defaultTableModel.getRowCount();
        for (int i = 0; i < rowCount; i++) {
            defaultTableModel.removeRow(0);
        }
        for (int i = (currentPage * numberOfRows - numberOfRows); i < arrayList.size(); i++) {
            if (defaultTableModel.getRowCount() >= numberOfRows) {
                break;
            }
            Object[] tableContent = new String[]{
                    arrayList.get(i).getStudentName(),
                    arrayList.get(i).getFatherName(),
                    String.valueOf(arrayList.get(i).getFatherEarnings()),
                    arrayList.get(i).getMotherName(),
                    String.valueOf(arrayList.get(i).getMotherEarnings()),
                    String.valueOf(arrayList.get(i).getNumberOfBrothers()),
                    String.valueOf(arrayList.get(i).getNumberOfSisters())
            };
            defaultTableModel.addRow(tableContent);

        }

    }
    public  void updateRowsOnPageFind() {
        ArrayList<Student> studentArrayList = Model.getInstance().getStudentArrayListForFind();
        numberOfRowsOnPageLogic(defaultTableModelForButtonFind, studentArrayList, numberOfRowsOnPageForFind, currentPageNumberForFind);
    }
    public void closeFindFrame() {
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                disableAllFindFrames();
            }
        });
    }

}
