package com.IvashkinIgor.main;

import com.IvashkinIgor.model.Model;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

public class MainDialogView extends JFrame {
    private  static MainDialogView mainDialogView;


    private  JPanel jPanel;

    private  JTable jTable;
    private  JScrollPane jScrollPane;
    private DefaultTableModel defaultTableModel = new DefaultTableModel();

    private  JButton buttonAdd;
    private  JButton buttonFind;
    private  JButton buttonDelete;

    private  JMenuBar jMenuBar;
    private  JMenuItem saveMenu;
    private  JMenuItem loadMenu;

    private  JButton buttonPrevious;
    private  JButton buttonNext;
    private  JLabel currentPage;
    private  int currentPageNumber = 1;
    private  JButton buttonLastPage;
    private  JButton buttonFirstPage;
    private  JComboBox jComboBoxMainFrame;
    private  JTextArea jLabelNumbersOfRecordsOnPage;
    private  int numbersOfRecordsOnPage = 0;
    private  JTextArea jLabelNumbersOfRecords;
    private  int numbersOfRecords = 0;
    private  JTextArea jLabelTotalPages;
    private  int totalPages = 1;


    public void setCurrentPageNumber(int currentPageNumber) {
        this.currentPageNumber = currentPageNumber;
    }

    public  JPanel getJPanel() {
        return jPanel;
    }



    public int getTotalPages() {
        return totalPages;
    }

    public JTextArea getJLabelTotalPages() {
        return jLabelTotalPages;
    }

    public int getNumbersOfRecords() {
        return numbersOfRecords;
    }

    public int getNumbersOfRecordsOnPage() {
        return numbersOfRecordsOnPage;
    }

    public JComboBox getJComboBoxMainFrame() {
        return jComboBoxMainFrame;
    }

    public JButton getButtonFirstPage() {
        return buttonFirstPage;
    }

    public JButton getButtonLastPage() {
        return buttonLastPage;
    }

    public int getCurrentPageNumber() {
        return currentPageNumber;
    }

    public JButton getButtonNext() {
        return buttonNext;
    }

    public JButton getButtonPrevious() {
        return buttonPrevious;
    }

    public JMenuItem getLoadMenu() {
        return loadMenu;
    }

    public JMenuItem getSaveMenu() {
        return saveMenu;
    }

    public JMenuBar getJMenuBar() {
        return jMenuBar;
    }

    public JButton getButtonDelete() {
        return buttonDelete;
    }

    public JButton getButtonFind() {
        return buttonFind;
    }

    public JButton getButtonAdd() {
        return buttonAdd;
    }

    public DefaultTableModel getDefaultTableModel() {
        return defaultTableModel;
    }

    public JTable getJTable() {
        return jTable;
    }

    public static MainDialogView getInstance() {
        if (mainDialogView == null){
            mainDialogView = new MainDialogView();
        }
        return mainDialogView;
    }

    private MainDialogView(){
        super();
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("Title");
        setLocationRelativeTo(null);
        setSize(750, 300);
        ImageIcon imageIcon = new ImageIcon("C:\\Users\\Igor\\Desktop\\книги\\!!!PROFILI!!!\\картинки\\avesta\\l3r1WDtOWio.jpg");
        setIconImage(imageIcon.getImage());
    }

    public void initialize() {
        Object[] columnsHeader = new String[]{"ФИО студента", "ФИО отца", "Заработок отца", "ФИО матери", "Заработок матери",
                "Число братьев", "Число сестёр"};
        defaultTableModel.setColumnIdentifiers(columnsHeader);
        jTable = new JTable(defaultTableModel) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        jScrollPane = new JScrollPane(jTable);


        GridBagLayout gridBagLayout = new GridBagLayout();
        jPanel = new JPanel();
        add(jPanel);
        jPanel.setLayout(gridBagLayout);

        buttonAdd = new JButton("Add");
        buttonFind = new JButton("Find");
        buttonDelete = new JButton("Delete");

        buttonLastPage = new JButton("Last page");
        buttonFirstPage = new JButton("First page");
        jComboBoxMainFrame = new JComboBox(new String[]{"0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10"});

        jLabelNumbersOfRecordsOnPage = new JTextArea("Количество записей на странице:\n\t" + numbersOfRecordsOnPage); //new JLabel("<html><p align = \"center\">Количество записей на странице:<br />"+ numbersOfRecordsOnPage +"</p></html>");
        jLabelNumbersOfRecordsOnPage.setEditable(false);
        jLabelNumbersOfRecordsOnPage.setFont(jLabelNumbersOfRecordsOnPage.getFont().deriveFont(Font.BOLD, jLabelNumbersOfRecordsOnPage.getFont().getSize()));
        jLabelNumbersOfRecordsOnPage.setBackground(getBackground());


        jLabelNumbersOfRecords = new JTextArea("Количество записей (общее):\n\t" + numbersOfRecords);
        jLabelNumbersOfRecords.setEditable(false);
        jLabelNumbersOfRecords.setFont(jLabelNumbersOfRecords.getFont().deriveFont(Font.BOLD, jLabelNumbersOfRecords.getFont().getSize()));
        jLabelNumbersOfRecords.setBackground(getBackground());//new JLabel("<html><p align = \"center\">Количество записей (общее):<br />"+ numbersOfRecords +"</p></html>");

        jLabelTotalPages = new JTextArea("Количество страниц (общее):\n\t" + totalPages); //new JLabel("<html><p align = \"center\">Количество страниц (общее):<br />"+ totalPages +"</p></html>");
        jLabelTotalPages.setEditable(false);
        jLabelTotalPages.setFont(jLabelTotalPages.getFont().deriveFont(Font.BOLD, jLabelTotalPages.getFont().getSize()));
        jLabelTotalPages.setBackground(getBackground());

        buttonNext = new JButton("Next");
        buttonPrevious = new JButton("Previous");
        currentPage = new JLabel(String.valueOf(currentPageNumber));

        jPanel.add(buttonAdd, GridBagConstraintsMainDialog.getConstraintsForButtonAdd());
        jPanel.add(buttonFind, GridBagConstraintsMainDialog.getConstraintsForButtonFind());
        jPanel.add(buttonDelete, GridBagConstraintsMainDialog.getConstraintsForButtonDelete());
        jPanel.add(jScrollPane, GridBagConstraintsMainDialog.getConstraintsForJTable());
        jPanel.add(buttonPrevious, GridBagConstraintsMainDialog.getConstraintsForButtonPrevious());
        jPanel.add(currentPage, GridBagConstraintsMainDialog.getConstraintsForLabelCurrent());
        jPanel.add(buttonNext, GridBagConstraintsMainDialog.getConstraintsForButtonNext());

        jPanel.add(buttonLastPage, GridBagConstraintsMainDialog.getConstraintsForButtonLastPage());
        jPanel.add(buttonFirstPage, GridBagConstraintsMainDialog.getConstraintsForButtonFirstPage());
        jPanel.add(jComboBoxMainFrame, GridBagConstraintsMainDialog.getConstraintsForJComboBoxMainFrame());
        jPanel.add(jLabelNumbersOfRecordsOnPage, GridBagConstraintsMainDialog.getConstraintsForJLabelNumbersOfRecordsOnPage());
        jPanel.add(jLabelNumbersOfRecords, GridBagConstraintsMainDialog.getConstraintsForJLabelNumbersOfRecords());
        jPanel.add(jLabelTotalPages, GridBagConstraintsMainDialog.getConstraintsForJLabelTotalPages());

        jMenuBar = new JMenuBar();
        JMenu jMenuFile = new JMenu("File");
        saveMenu = new JMenuItem("Save");
        loadMenu = new JMenuItem("Load");
        jMenuFile.add(saveMenu);
        jMenuFile.add(loadMenu);

        jMenuBar.add(jMenuFile);

        setJMenuBar(jMenuBar);



        MainDialogController.getInstance();

        jPanel.revalidate();
    }

    public void updateCurrentPageNumber() {

        currentPage.setText(String.valueOf(currentPageNumber));
        updateJPanel();
    }
    public  void updateJPanel() {
        jPanel.revalidate();
    }
    public  void updateJLabelNumbersOfRecords() {

        numbersOfRecords = Model.getInstance().getStudentArrayList().size();
        jLabelNumbersOfRecords.setText("Количество записей (общее):\n\t" + numbersOfRecords);
        updateJPanel();
    }
    public  void updateJLabelTotalPages() {
        MainDialogController mainDialogController = MainDialogController.getInstance();
        if (mainDialogController.getNumberOfRowsOnPage() == 0) {
            jLabelTotalPages.setText("Количество страниц (общее):\n\t" + 1);
            updateJPanel();
            return;
        }
        totalPages = Model.getInstance().getStudentArrayList().size() / mainDialogController.getNumberOfRowsOnPage();
        if (totalPages * mainDialogController.getNumberOfRowsOnPage() < Model.getInstance().getStudentArrayList().size()) {
            totalPages++;
        }
        jLabelTotalPages.setText("Количество страниц (общее):\n\t" + totalPages);
        updateJPanel();
    }
    public  void updateJLabelNumberOfRecordsOnPage() {
        numbersOfRecordsOnPage = defaultTableModel.getRowCount();
        jLabelNumbersOfRecordsOnPage.setText("Количество записей на странице:\n\t" + numbersOfRecordsOnPage);
    }
}
