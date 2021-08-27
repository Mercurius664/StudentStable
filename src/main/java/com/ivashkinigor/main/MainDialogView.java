package com.ivashkinigor.main;

import com.ivashkinigor.model.Model;

import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public class MainDialogView extends JFrame {


    private  JPanel jPanel;
    private MainDialogController mainDialogController;

    private  JButton buttonAdd;
    private  JButton buttonFind;
    private  JButton buttonDelete;

    private  JMenuBar jMenuBar;
    private  JMenuItem saveMenu;
    private  JMenuItem loadMenu;

    private  JButton buttonPrevious;
    private  JButton buttonNext;


    private  JButton buttonLastPage;
    private  JButton buttonFirstPage;


    private StudentTable studentTable;

    private  JLabel currentPage;
    private  JTextArea jLabelNumbersOfRecordsOnPage;
    private  JTextArea jLabelNumbersOfRecords;
    private  JTextArea jLabelTotalPages;
    private  JComboBox jComboBoxMainFrame;


    public StudentTable getStudentTable() {
        return studentTable;
    }

    public JLabel getJLabelCurrentPage() {
        return currentPage;
    }

    public JTextArea getJLabelNumbersOfRecordsOnPage() {
        return jLabelNumbersOfRecordsOnPage;
    }

    public JTextArea getJLabelNumbersOfRecords() {
        return jLabelNumbersOfRecords;
    }

    public JTextArea getJLabelTotalPages() {
        return jLabelTotalPages;
    }

    public  JPanel getJPanel() {
        return jPanel;
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





    public MainDialogView(){
        super();
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("Title");
        setLocationRelativeTo(null);
        setSize(750, 300);
        ImageIcon imageIcon = new ImageIcon("C:\\Users\\Igor\\Desktop\\книги\\!!!PROFILI!!!\\картинки\\avesta\\l3r1WDtOWio.jpg");
        setIconImage(imageIcon.getImage());
        initialize();
    }




    private void initialize() {

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

        jLabelNumbersOfRecordsOnPage = new JTextArea("Количество записей на странице:\n\t" + 0); //new JLabel("<html><p align = \"center\">Количество записей на странице:<br />"+ numbersOfRecordsOnPage +"</p></html>");
        jLabelNumbersOfRecordsOnPage.setEditable(false);
        jLabelNumbersOfRecordsOnPage.setFont(jLabelNumbersOfRecordsOnPage.getFont().deriveFont(Font.BOLD, jLabelNumbersOfRecordsOnPage.getFont().getSize()));
        jLabelNumbersOfRecordsOnPage.setBackground(getBackground());


        jLabelNumbersOfRecords = new JTextArea("Количество записей (общее):\n\t" + 0);
        jLabelNumbersOfRecords.setEditable(false);
        jLabelNumbersOfRecords.setFont(jLabelNumbersOfRecords.getFont().deriveFont(Font.BOLD, jLabelNumbersOfRecords.getFont().getSize()));
        jLabelNumbersOfRecords.setBackground(getBackground());//new JLabel("<html><p align = \"center\">Количество записей (общее):<br />"+ numbersOfRecords +"</p></html>");

        jLabelTotalPages = new JTextArea("Количество страниц (общее):\n\t" + 1); //new JLabel("<html><p align = \"center\">Количество страниц (общее):<br />"+ totalPages +"</p></html>");
        jLabelTotalPages.setEditable(false);
        jLabelTotalPages.setFont(jLabelTotalPages.getFont().deriveFont(Font.BOLD, jLabelTotalPages.getFont().getSize()));
        jLabelTotalPages.setBackground(getBackground());

        buttonNext = new JButton("Next");
        buttonPrevious = new JButton("Previous");
        currentPage = new JLabel(String.valueOf(1));

        studentTable = new StudentTable(this);

        jPanel.add(buttonAdd, GridBagConstraintsMainDialog.getConstraintsForButtonAdd());
        jPanel.add(buttonFind, GridBagConstraintsMainDialog.getConstraintsForButtonFind());
        jPanel.add(buttonDelete, GridBagConstraintsMainDialog.getConstraintsForButtonDelete());
        jPanel.add(studentTable.getJScrollPane(), GridBagConstraintsMainDialog.getConstraintsForJTable());
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



        new MainDialogController(this,studentTable);
        listenerInitialize();
        jPanel.revalidate();
    }

    private void listenerInitialize(){
        DocumentListener documentListener = new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                jPanel.revalidate();
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                jPanel.revalidate();
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                jPanel.revalidate();
            }
        };
        currentPage.addPropertyChangeListener(new PropertyChangeListener() {
            @Override
            public void propertyChange(PropertyChangeEvent evt) {
                jPanel.revalidate();
            }
        });
        jLabelNumbersOfRecordsOnPage.getDocument().addDocumentListener(documentListener);
        jLabelNumbersOfRecords.getDocument().addDocumentListener(documentListener);
        jLabelTotalPages.getDocument().addDocumentListener(documentListener);
        jComboBoxMainFrame.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                studentTable.setRowsOnPageCountMax(Integer.parseInt(String.valueOf(jComboBoxMainFrame.getItemAt(jComboBoxMainFrame.getSelectedIndex()))));
                studentTable.updateInformationComponent();
            }
        });

    }

}
