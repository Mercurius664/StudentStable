import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.ArrayList;

public class View {

    private static  JFrame jFrame = getJFrame();
    private static JPanel jPanel;

    private static  JTable jTable;
    private static JScrollPane jScrollPane;
    private static DefaultTableModel defaultTableModel = new DefaultTableModel();

    private static  JButton buttonAdd;
    private static JButton buttonFind;
    private static JButton buttonDelete;

    private static JMenuBar jMenuBar;
    private static JMenuItem saveMenu;
    private static JMenuItem loadMenu;

    private static JButton buttonPrevious;
    private static JButton buttonNext;
    private static JLabel currentPage ;
    private static int currentPageNumber =1;
    private static JButton buttonLastPage;
    private static JButton buttonFirstPage;
    private static JComboBox jComboBoxMainFrame;
    private static JTextArea jLabelNumbersOfRecordsOnPage;
    private static int numbersOfRecordsOnPage = 0;
    private static JTextArea jLabelNumbersOfRecords;
    private static int numbersOfRecords = 0;
    private static JTextArea jLabelTotalPages;
    private static int totalPages = 1;

    private static JButton buttonSaveForAdd = new JButton("Save");

    private static JFrame jFrameForAdd;
    private static JPanel  jPanelForAdd;

    private static JFrame jFrameForFind;
    private static JPanel  jPanelForFind;
    private static JComboBox jComboBoxForButtonFind = new JComboBox(new String[]{" ","ФИО студента", "ФИО одного из родителей", "по числу братьев или сестер", "по размеру заработка одного из родителей"});;
    private static JTable jTableForButtonFind;
    private static DefaultTableModel defaultTableModelForButtonFind;
    private static JScrollPane jScrollPaneForButtonFind;
    private static JButton jButtonForButtonFindFirstPage;
    private static JButton jButtonForButtonFindPreviousPage;
    private static JLabel jLabelCurrentPageForButtonFind;
    private static JButton jButtonForButtonFindNextPage;
    private static JButton jButtonForButtonFindLastPage;
    private static JComboBox jComboBoxForButtonFindRowsOnPage;
    private static JTextArea jTextAreaRecordsOnPage;
    private static JTextArea jTextAreaRecords;
    private static JTextArea jTextAreaTotalPages;
    private static int numbersOfRecordsForFind =0;
    private static int totalPagesForFind =0;
    private static int currentPageNumberForFind =1;



    private static JFrame jFrameForFindIndex1;
    private static JPanel jPanelForFindIndex1;
    private static JLabel jLabelForFindIndex1;
    private static JTextField jTextFieldForFindIndex1;
    private static JButton jButtonForFindIndex1;

    private static JFrame jFrameForFindIndex2;
    private static JPanel jPanelForFindIndex2;
    private static JLabel jLabelMotherForFindIndex2;
    private static JLabel jLabelFatherForFindIndex2;
    private static JTextField jTextFieldMotherForFindIndex2;
    private static JTextField jTextFieldFatherForFindIndex2;
    private static JButton jButtonForFindIndex2;
    private static JRadioButton jRadioButtonMotherEnable;
    private static JRadioButton jRadioButtonFatherEnable;

    private static JFrame jFrameForFindIndex3;
    private static JPanel jPanelForFindIndex3;
    private static JLabel jLabelBrotherForFindIndex3;
    private static JLabel jLabelSisterForFindIndex3;
    private static JTextField jTextFieldBrotherForFindIndex3;
    private static JTextField jTextFieldFSisterForFindIndex3;
    private static JButton jButtonForFindIndex3;
    private static JRadioButton jRadioButtonBrotherEnable;
    private static JRadioButton jRadioButtonSisterEnable;

    private static JFrame jFrameForFindIndex4;
    private static JPanel jPanelForFindIndex4;
    private static JLabel jLabelMotherMinForFindIndex4;
    private static JLabel jLabelMotherMaxForFindIndex4;
    private static JLabel jLabelFatherMinForFindIndex4;
    private static JLabel jLabelFatherMaxForFindIndex4;
    private static JTextField jTextFieldMotherMinForFindIndex4;
    private static JTextField jTextFieldMotherMaxForFindIndex4;
    private static JTextField jTextFieldFatherMinForFindIndex4;
    private static JTextField jTextFieldFatherMaxForFindIndex4;
    private static JButton jButtonForFindIndex4;
    private static JRadioButton jRadioButtonMotherMoneyEnable;
    private static JRadioButton jRadioButtonFatherMoneyEnable;

    private static JFrame jFrameMainForDelete;
    private static JPanel  jPanelMainForDelete;
    private static JComboBox jComboBoxForDelete;

    private static JFrame jFrameForDeleteIndex1;
    private static JPanel jPanelForDeleteIndex1;
    private static JLabel jLabelForDeleteIndex1;
    private static JTextField jTextFieldForDeleteIndex1;
    private static JButton jButtonForDeleteIndex1;

    private static JFrame jFrameForDeleteIndex2;
    private static JPanel jPanelForDeleteIndex2;
    private static JLabel jLabelMotherForDeleteIndex2;
    private static JLabel jLabelFatherForDeleteIndex2;
    private static JTextField jTextFieldMotherForDeleteIndex2;
    private static JTextField jTextFieldFatherForDeleteIndex2;
    private static JButton jButtonForDeleteIndex2;
    private static JRadioButton jRadioButtonMotherDeleteEnable;
    private static JRadioButton jRadioButtonFatherDeleteEnable;

    private static JFrame jFrameForDeleteIndex3;
    private static JPanel jPanelForDeleteIndex3;
    private static JLabel jLabelBrotherForDeleteIndex3;
    private static JLabel jLabelSisterForDeleteIndex3;
    private static JTextField jTextFieldBrotherForDeleteIndex3;
    private static JTextField jTextFieldFSisterForDeleteIndex3;
    private static JButton jButtonForDeleteIndex3;
    private static JRadioButton jRadioButtonBrotherDeleteEnable;
    private static JRadioButton jRadioButtonSisterDeleteEnable;

    private static JFrame jFrameForDeleteIndex4;
    private static JPanel jPanelForDeleteIndex4;
    private static JLabel jLabelMotherMinForDeleteIndex4;
    private static JLabel jLabelMotherMaxForDeleteIndex4;
    private static JLabel jLabelFatherMinForDeleteIndex4;
    private static JLabel jLabelFatherMaxForDeleteIndex4;
    private static JTextField jTextFieldMotherMinForDeleteIndex4;
    private static JTextField jTextFieldMotherMaxForDeleteIndex4;
    private static JTextField jTextFieldFatherMinForDeleteIndex4;
    private static JTextField jTextFieldFatherMaxForDeleteIndex4;
    private static JButton jButtonForDeleteIndex4;
    private static JRadioButton jRadioButtonMotherMoneyDeleteEnable;
    private static JRadioButton jRadioButtonFatherMoneyDeleteEnable;

    private static ArrayList<JTextField> addJTextFieldArrayList = new ArrayList<>();

    public static JFrame getJFrameMain() {
        return jFrame;
    }
    public static JPanel getJPanel() {
        return jPanel;
    }

    public static JTable getJTable() {
        return jTable;
    }
    public static DefaultTableModel getDefaultTableModel() {
        return defaultTableModel;
    }

    public static JButton getButtonAdd(){
        return buttonAdd;
    }
    public static JButton getButtonFind(){
        return buttonFind;
    }
    public static JButton getButtonDelete(){
        return buttonDelete;
    }

    public static JMenuItem getSaveMenu() {
        return saveMenu;
    }
    public static JMenuItem getLoadMenu() {
        return loadMenu;
    }

    public static JButton getButtonPrevious() {
        return buttonPrevious;
    }
    public static JButton getButtonNext() {
        return buttonNext;
    }
    public static int getCurrentPageNumber() {
        return currentPageNumber;
    }
    public static JButton getButtonLastPage() {
        return buttonLastPage;
    }
    public static JButton getButtonFirstPage() {
        return buttonFirstPage;
    }
    public static JComboBox getJComboBoxMainFrame() {
        return jComboBoxMainFrame;
    }
    public static int getTotalPagesForFind() {
        return totalPagesForFind;
    }

    public static JButton getButtonSaveForAdd() {
        return buttonSaveForAdd;
    }

    public static JFrame getjFrameForFind() {
        return jFrameForFind;
    }
    public static JPanel getJPanelForFind() {
        return jPanelForFind;
    }
    public static JComboBox getJComboBoxForButtonFind() {
        return jComboBoxForButtonFind;
    }
    public static JTable getJTableForButtonFind() {
        return jTableForButtonFind;
    }
    public static DefaultTableModel getDefaultTableModelForButtonFind() {
        return defaultTableModelForButtonFind;
    }
    public static JButton getJButtonForButtonFindFirstPage() {
        return jButtonForButtonFindFirstPage;
    }
    public static JButton getJButtonForButtonFindPreviousPage() {
        return jButtonForButtonFindPreviousPage;
    }
    public static JButton getJButtonForButtonFindNextPage() {
        return jButtonForButtonFindNextPage;
    }
    public static JButton getJButtonForButtonFindLastPage() {
        return jButtonForButtonFindLastPage;
    }
    public static JComboBox getJComboBoxForButtonFindRowsOnPage() {
        return jComboBoxForButtonFindRowsOnPage;
    }
    public static int getCurrentPageNumberForFind() {
        return currentPageNumberForFind;
    }

    public static JTextField getJTextFieldForFindIndex1() {
        return jTextFieldForFindIndex1;
    }
    public static JButton getJButtonForFindIndex1() {
        return jButtonForFindIndex1;
    }
    public static JTextField getJTextFieldMotherForFindIndex2() {
        return jTextFieldMotherForFindIndex2;
    }
    public static JTextField getJTextFieldFatherForFindIndex2() {
        return jTextFieldFatherForFindIndex2;
    }
    public static JButton getJButtonForFindIndex2() {
        return jButtonForFindIndex2;
    }
    public static JRadioButton getJRadioButtonMotherEnable() {
        return jRadioButtonMotherEnable;
    }
    public static JRadioButton getJRadioButtonFatherEnable() {
        return jRadioButtonFatherEnable;
    }
    public static JFrame getJFrameMainForDelete() {
        return jFrameMainForDelete;
    }
    public static JComboBox getJComboBoxForDelete() {
        return jComboBoxForDelete;
    }
    public static JTextField getjTextFieldForDeleteIndex1() {
        return jTextFieldForDeleteIndex1;
    }
    public static JButton getJButtonForDeleteIndex1() {
        return jButtonForDeleteIndex1;
    }
    public static JButton getJButtonForDeleteIndex2() {
        return jButtonForDeleteIndex2;
    }
    public static JRadioButton getJRadioButtonFatherDeleteEnable() {
        return jRadioButtonFatherDeleteEnable;
    }
    public static JRadioButton getJRadioButtonMotherDeleteEnable() {
        return jRadioButtonMotherDeleteEnable;
    }
    public static JTextField getJTextFieldMotherForDeleteIndex2() {
        return jTextFieldMotherForDeleteIndex2;
    }
    public static JTextField getJTextFieldFatherForDeleteIndex2() {
        return jTextFieldFatherForDeleteIndex2;
    }
    public static JButton getjButtonForDeleteIndex3() {
        return jButtonForDeleteIndex3;
    }
    public static JRadioButton getJRadioButtonBrotherDeleteEnable() {
        return jRadioButtonBrotherDeleteEnable;
    }
    public static JRadioButton getJRadioButtonSisterDeleteEnable() {
        return jRadioButtonSisterDeleteEnable;
    }
    public static JTextField getJTextFieldBrotherForDeleteIndex3() {
        return jTextFieldBrotherForDeleteIndex3;
    }
    public static JTextField getJTextFieldFSisterForDeleteIndex3() {
        return jTextFieldFSisterForDeleteIndex3;
    }
    public static JRadioButton getJRadioButtonMotherMoneyDeleteEnable() {
        return jRadioButtonMotherMoneyDeleteEnable;
    }
    public static JRadioButton getJRadioButtonFatherMoneyDeleteEnable() {
        return jRadioButtonFatherMoneyDeleteEnable;
    }
    public static JTextField getJTextFieldMotherMinForDeleteIndex4() {
        return jTextFieldMotherMinForDeleteIndex4;
    }
    public static JTextField getJTextFieldMotherMaxForDeleteIndex4() {
        return jTextFieldMotherMaxForDeleteIndex4;
    }
    public static JTextField getJTextFieldFatherMinForDeleteIndex4() {
        return jTextFieldFatherMinForDeleteIndex4;
    }
    public static JTextField getJTextFieldFatherMaxForDeleteIndex4() {
        return jTextFieldFatherMaxForDeleteIndex4;
    }
    public static JButton getJButtonForDeleteIndex4() {
        return jButtonForDeleteIndex4;
    }
    public static JTextField getJTextFieldMotherMinForFindIndex4() {
        return jTextFieldMotherMinForFindIndex4;
    }
    public static JTextField getJTextFieldMotherMaxForFindIndex4() {
        return jTextFieldMotherMaxForFindIndex4;
    }
    public static JTextField getJTextFieldFatherMinForFindIndex4() {
        return jTextFieldFatherMinForFindIndex4;
    }
    public static JTextField getJTextFieldFatherMaxForFindIndex4() {
        return jTextFieldFatherMaxForFindIndex4;
    }
    public static JRadioButton getJRadioButtonMotherMoneyEnable() {
        return jRadioButtonMotherMoneyEnable;
    }
    public static JRadioButton getJRadioButtonFatherMoneyEnable() {
        return jRadioButtonFatherMoneyEnable;
    }
    public static JButton getJButtonForFindIndex4() {
        return jButtonForFindIndex4;
    }
    public static JButton getJButtonForFindIndex3() {
        return jButtonForFindIndex3;
    }
    public static JRadioButton getJRadioButtonBrotherEnable() {
        return jRadioButtonBrotherEnable;
    }
    public static JRadioButton getJRadioButtonSisterEnable() {
        return jRadioButtonSisterEnable;
    }
    public static JTextField getJTextFieldBrotherForFindIndex3() {
        return jTextFieldBrotherForFindIndex3;
    }
    public static JTextField getJTextFieldFSisterForFindIndex3() {
        return jTextFieldFSisterForFindIndex3;
    }
    public static int getTotalPages() {
        return totalPages;
    }
    public static ArrayList<JTextField> getAddJTextFieldArrayList() {
        return addJTextFieldArrayList;
    }



    public static void setNumbersOfRecordsForFind(int numbersOfRecordsForFind) {
        View.numbersOfRecordsForFind = numbersOfRecordsForFind;
    }

    public static void setTotalPagesForFind(int totalPagesForFind) {
        View.totalPagesForFind = totalPagesForFind;
    }

    public static void setJTextAreaRecordsOnPage() {
        View.jTextAreaRecordsOnPage.setText("Количество записей на странице:\n\t" + defaultTableModelForButtonFind.getRowCount());
    }

    public static void setJTextAreaRecords() {
        View.jTextAreaRecords.setText("Количество записей (общее):\n\t"+ numbersOfRecordsForFind);
    }

    public static void setJTextAreaTotalPages() {
        View.jTextAreaTotalPages.setText("Количество страниц (общее):\n\t" + totalPagesForFind);
    }

    public static void setCurrentPageNumber(int currentPageNumber) {
        View.currentPageNumber = currentPageNumber;
    }

    public static void setCurrentPageNumberForFind(int currentPageNumberForFind) {
        View.currentPageNumberForFind = currentPageNumberForFind;
        jLabelCurrentPageForButtonFind.setText(String.valueOf(View.currentPageNumberForFind));
        jPanel.revalidate();
    }




    public static void drawDeleteFrame(){
        jFrameMainForDelete = getJFrameForAddFindDelete();
        jPanelMainForDelete = new JPanel();
        jFrameMainForDelete.add(jPanelMainForDelete);
        jComboBoxForDelete = new JComboBox(new String[]{" ","ФИО студента", "ФИО одного из родителей", "по числу братьев или сестер", "по размеру заработка одного из родителей"});
        jPanelMainForDelete.add(jComboBoxForDelete);
        Controller.componentAddListenerForDeleteMainFrame();
    }


    public static void drawDeleteFrameForIndex1(){
        if (!((jFrameForDeleteIndex1) == null)){
            jFrameForDeleteIndex1.setVisible(true);
            return;
        }
        jFrameForDeleteIndex1 = getJFrameForAddFindDelete();
        jPanelForDeleteIndex1 = new JPanel();
        GridBagLayout gridBagLayout = new GridBagLayout();
        jPanelForDeleteIndex1.setLayout(gridBagLayout);

        jLabelForDeleteIndex1 = new JLabel("Введите ФИО студента:");
        jTextFieldForDeleteIndex1 = new JTextField();
        jButtonForDeleteIndex1 = new JButton("Delete");

        jFrameForDeleteIndex1.add(jPanelForDeleteIndex1);
        jPanelForDeleteIndex1.add(jLabelForDeleteIndex1,Constraints.getConstraintsForButtonFindSearchStudentJLabel());
        jPanelForDeleteIndex1.add(jTextFieldForDeleteIndex1,Constraints.getConstraintsForButtonFindSearchStudentTextField());
        jPanelForDeleteIndex1.add(jButtonForDeleteIndex1,Constraints.getConstraintsForButtonFindSearchStudentButton());

        Controller.componentAddListenerForDeleteIndex1();
    }
    public static void drawDeleteFrameForIndex2(){
        if (!((jFrameForDeleteIndex2) == null)){
            jFrameForDeleteIndex2.setVisible(true);
            return;
        }
        jFrameForDeleteIndex2 = getJFrameForAddFindDelete();
        jPanelForDeleteIndex2 = new JPanel();
        GridBagLayout gridBagLayout = new GridBagLayout();
        jPanelForDeleteIndex2.setLayout(gridBagLayout);
        jFrameForDeleteIndex2.add(jPanelForDeleteIndex2);

        jLabelMotherForDeleteIndex2 = new JLabel("Введите ФИО матери");
        jLabelFatherForDeleteIndex2 = new JLabel("Введите ФИО отца");
        jTextFieldMotherForDeleteIndex2 = new JTextField();
        jTextFieldFatherForDeleteIndex2 = new JTextField();
        jButtonForDeleteIndex2 = new JButton("Find");
        jRadioButtonMotherDeleteEnable = new JRadioButton("Ввести ФИО матери");
        jRadioButtonFatherDeleteEnable = new JRadioButton("Ввести ФИО отца");


        jPanelForDeleteIndex2.add(jRadioButtonMotherDeleteEnable, Constraints.getConstraintsForButtonFindJRadioButtonIsMotherEditableForFindIndex2());
        jPanelForDeleteIndex2.add(jRadioButtonFatherDeleteEnable, Constraints.getConstraintsForButtonFindJRadioButtonIsFatherEditableForFindIndex2());
        jPanelForDeleteIndex2.add(jLabelMotherForDeleteIndex2,Constraints.getConstraintsForButtonFindJLabelMotherForFindIndex2());
        jPanelForDeleteIndex2.add(jLabelFatherForDeleteIndex2,Constraints.getConstraintsForButtonFindJLabelFatherForFindIndex2());
        jPanelForDeleteIndex2.add(jTextFieldMotherForDeleteIndex2,Constraints.getConstraintsForButtonFindJTextFieldMotherForFindIndex2());
        jPanelForDeleteIndex2.add(jTextFieldFatherForDeleteIndex2,Constraints.getConstraintsForButtonFindJTextFieldFatherForFindIndex2());
        jPanelForDeleteIndex2.add(jButtonForDeleteIndex2,Constraints.getConstraintsForButtonFindJButtonForFindIndex2());

        jRadioButtonMotherDeleteEnable.setSelected(true);
        jTextFieldFatherForDeleteIndex2.setText("");
        jTextFieldFatherForDeleteIndex2.setEditable(false);
        jTextFieldFatherForDeleteIndex2.setBackground(View.getJFrameMainForDelete().getBackground());

        Controller.componentAddListenerForDeleteIndex2();
    }
    public static void drawDeleteFrameForIndex3(){
        if (!((jFrameForDeleteIndex3) == null)){
            jFrameForDeleteIndex3.setVisible(true);
            return;
        }
        jFrameForDeleteIndex3 = getJFrameForAddFindDelete();
        jPanelForDeleteIndex3 = new JPanel();
        GridBagLayout gridBagLayout = new GridBagLayout();
        jPanelForDeleteIndex3.setLayout(gridBagLayout);
        jFrameForDeleteIndex3.add(jPanelForDeleteIndex3);

        jLabelBrotherForDeleteIndex3 = new JLabel("Введите число братьев");
        jLabelSisterForDeleteIndex3 = new JLabel("Введите число сестер");
        jTextFieldBrotherForDeleteIndex3 = new JTextField();
        jTextFieldFSisterForDeleteIndex3 = new JTextField();
        jButtonForDeleteIndex3 = new JButton("Delete");
        jRadioButtonBrotherDeleteEnable = new JRadioButton("Ввести число братьев");
        jRadioButtonSisterDeleteEnable = new JRadioButton("Ввести число сестер");


        jPanelForDeleteIndex3.add(jRadioButtonBrotherDeleteEnable, Constraints.getConstraintsForButtonFindJRadioButtonIsMotherEditableForFindIndex2());
        jPanelForDeleteIndex3.add(jRadioButtonSisterDeleteEnable, Constraints.getConstraintsForButtonFindJRadioButtonIsFatherEditableForFindIndex2());
        jPanelForDeleteIndex3.add(jLabelBrotherForDeleteIndex3,Constraints.getConstraintsForButtonFindJLabelMotherForFindIndex2());
        jPanelForDeleteIndex3.add(jLabelSisterForDeleteIndex3,Constraints.getConstraintsForButtonFindJLabelFatherForFindIndex2());
        jPanelForDeleteIndex3.add(jTextFieldBrotherForDeleteIndex3,Constraints.getConstraintsForButtonFindJTextFieldMotherForFindIndex2());
        jPanelForDeleteIndex3.add(jTextFieldFSisterForDeleteIndex3,Constraints.getConstraintsForButtonFindJTextFieldFatherForFindIndex2());
        jPanelForDeleteIndex3.add(jButtonForDeleteIndex3,Constraints.getConstraintsForButtonFindJButtonForFindIndex2());



        jRadioButtonBrotherDeleteEnable.setSelected(true);
        jTextFieldFSisterForDeleteIndex3.setEditable(false);
        jTextFieldFSisterForDeleteIndex3.setBackground(View.getJFrameMainForDelete().getBackground());

        Controller.componentAddListenerForDeleteIndex3();
    }
    public static void drawDeleteFrameForIndex4(){
        if (!((jFrameForDeleteIndex4) == null)){
            jFrameForDeleteIndex4.setVisible(true);
            return;
        }
        jFrameForDeleteIndex4 = getJFrameForAddFindDelete();
        jPanelForDeleteIndex4 = new JPanel();
        GridBagLayout gridBagLayout = new GridBagLayout();
        jPanelForDeleteIndex4.setLayout(gridBagLayout);
        jFrameForDeleteIndex4.add(jPanelForDeleteIndex4);

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




        jPanelForDeleteIndex4.add(jLabelFatherMaxForDeleteIndex4, Constraints.getConstraintsForButtonFindJLabelFatherMaxForFindIndex4());
        jPanelForDeleteIndex4.add(jLabelFatherMinForDeleteIndex4, Constraints.getConstraintsForButtonFindJLabelFatherMinForFindIndex4());
        jPanelForDeleteIndex4.add(jLabelMotherMaxForDeleteIndex4, Constraints.getConstraintsForButtonFindJLabelMotherMaxForFindIndex4());
        jPanelForDeleteIndex4.add(jLabelMotherMinForDeleteIndex4, Constraints.getConstraintsForButtonFindJLabelMotherMinForFindIndex4());
        jPanelForDeleteIndex4.add(jTextFieldFatherMaxForDeleteIndex4, Constraints.getConstraintsForButtonFindJTextFieldFatherMaxForFindIndex4());
        jPanelForDeleteIndex4.add(jTextFieldFatherMinForDeleteIndex4, Constraints.getConstraintsForButtonFindJTextFieldFatherMinForFindIndex4());
        jPanelForDeleteIndex4.add(jTextFieldMotherMaxForDeleteIndex4, Constraints.getConstraintsForButtonFindJTextFieldMotherMaxForFindIndex4());
        jPanelForDeleteIndex4.add(jTextFieldMotherMinForDeleteIndex4, Constraints.getConstraintsForButtonFindJTextFieldMotherMinForFindIndex4());
        jPanelForDeleteIndex4.add(jButtonForDeleteIndex4, Constraints.getConstraintsForButtonFindJButtonForFindIndex4());
        jPanelForDeleteIndex4.add(jRadioButtonFatherMoneyDeleteEnable, Constraints.getConstraintsForButtonFindJRadioButtonFatherMoneyEnable());
        jPanelForDeleteIndex4.add(jRadioButtonMotherMoneyDeleteEnable, Constraints.getConstraintsForButtonFindJRadioButtonMotherMoneyEnable());

        jRadioButtonFatherMoneyDeleteEnable.setSelected(true);
        jTextFieldMotherMaxForDeleteIndex4.setEditable(false);
        jTextFieldMotherMaxForDeleteIndex4.setBackground(getJFrameMainForDelete().getBackground());

        jTextFieldMotherMinForDeleteIndex4.setEditable(false);
        jTextFieldMotherMinForDeleteIndex4.setBackground(getJFrameMainForDelete().getBackground());


        Controller.componentAddListenerForDeleteIndex4();
    }




    public static void drawUI() {
        Object[] columnsHeader = new String[] {"ФИО студента","ФИО отца","Заработок отца","ФИО матери","Заработок матери",
                "Число братьев","Число сестёр"};
        defaultTableModel.setColumnIdentifiers(columnsHeader);
       jTable = new JTable(defaultTableModel){
           @Override
           public boolean isCellEditable(int row, int column) {
               return false;
           }
       };
       jScrollPane = new JScrollPane(jTable);


        GridBagLayout gridBagLayout = new GridBagLayout();
        jPanel = new JPanel();
        jFrame.add(jPanel);
        jPanel.setLayout(gridBagLayout);

        buttonAdd = new JButton("Add");
        buttonFind = new JButton("Find");
        buttonDelete = new JButton("Delete");

        buttonLastPage = new JButton("Last page");
        buttonFirstPage = new JButton("First page");
        jComboBoxMainFrame = new JComboBox(new String[]{"0","1","2","3","4","5","6","7","8","9","10"});

        jLabelNumbersOfRecordsOnPage = new JTextArea("Количество записей на странице:\n\t" + numbersOfRecordsOnPage); //new JLabel("<html><p align = \"center\">Количество записей на странице:<br />"+ numbersOfRecordsOnPage +"</p></html>");
        jLabelNumbersOfRecordsOnPage.setEditable(false);
        jLabelNumbersOfRecordsOnPage.setFont(jLabelNumbersOfRecordsOnPage.getFont().deriveFont(Font.BOLD, jLabelNumbersOfRecordsOnPage.getFont().getSize()));
        jLabelNumbersOfRecordsOnPage.setBackground(jFrame.getBackground());


        jLabelNumbersOfRecords = new JTextArea("Количество записей (общее):\n\t"+ numbersOfRecords);
        jLabelNumbersOfRecords.setEditable(false);
        jLabelNumbersOfRecords.setFont(jLabelNumbersOfRecords.getFont().deriveFont(Font.BOLD, jLabelNumbersOfRecords.getFont().getSize()));
        jLabelNumbersOfRecords.setBackground(jFrame.getBackground());//new JLabel("<html><p align = \"center\">Количество записей (общее):<br />"+ numbersOfRecords +"</p></html>");

        jLabelTotalPages = new JTextArea("Количество страниц (общее):\n\t" + totalPages); //new JLabel("<html><p align = \"center\">Количество страниц (общее):<br />"+ totalPages +"</p></html>");
        jLabelTotalPages.setEditable(false);
        jLabelTotalPages.setFont(jLabelTotalPages.getFont().deriveFont(Font.BOLD, jLabelTotalPages.getFont().getSize()));
        jLabelTotalPages.setBackground(jFrame.getBackground());

        buttonNext = new JButton("Next");
        buttonPrevious = new JButton("Previous");
        currentPage = new JLabel(String.valueOf(currentPageNumber));

        jPanel.add(buttonAdd,Constraints.getConstraintsForButtonAdd());
        jPanel.add(buttonFind,Constraints.getConstraintsForButtonFind());
        jPanel.add(buttonDelete, Constraints.getConstraintsForButtonDelete());
        jPanel.add(jScrollPane, Constraints.getConstraintsForJTable());
        jPanel.add(buttonPrevious,Constraints.getConstraintsForButtonPrevious());
        jPanel.add(currentPage,Constraints.getConstraintsForLabelCurrent());
        jPanel.add(buttonNext,Constraints.getConstraintsForButtonNext());

        jPanel.add(buttonLastPage,Constraints.getConstraintsForButtonLastPage());
        jPanel.add(buttonFirstPage,Constraints.getConstraintsForButtonFirstPage());
        jPanel.add(jComboBoxMainFrame,Constraints.getConstraintsForJComboBoxMainFrame());
        jPanel.add(jLabelNumbersOfRecordsOnPage,Constraints.getConstraintsForJLabelNumbersOfRecordsOnPage());
        jPanel.add(jLabelNumbersOfRecords, Constraints.getConstraintsForJLabelNumbersOfRecords());
        jPanel.add(jLabelTotalPages,Constraints.getConstraintsForJLabelTotalPages());

        jMenuBar = new JMenuBar();
        JMenu jMenuFile = new JMenu("File");
       saveMenu = new JMenuItem("Save");
        loadMenu = new JMenuItem("Load");
        jMenuFile.add(saveMenu);
        jMenuFile.add(loadMenu);

        jMenuBar.add(jMenuFile);

        jFrame.setJMenuBar(jMenuBar);


        jPanel.revalidate();
    }

    public static void updateCurrentPageNumber(){

        currentPage.setText(String.valueOf(currentPageNumber));
        View.updateJPanel();
    }
    public static void updateJLabelNumbersOfRecords(){

    numbersOfRecords = Model.getStudentArrayList().size();
    jLabelNumbersOfRecords.setText("Количество записей (общее):\n\t"+ numbersOfRecords);
    View.updateJPanel();
    }
    public static void updateJLabelTotalPages(){
        if (Controller.getNumberOfRowsOnPage() == 0){
            jLabelTotalPages.setText("Количество страниц (общее):\n\t" + 1);
            View.updateJPanel();
            return;
        }
        totalPages = Model.getStudentArrayList().size() / Controller.getNumberOfRowsOnPage();
        if(totalPages * Controller.getNumberOfRowsOnPage() < Model.getStudentArrayList().size()){
            totalPages++;
        }
        jLabelTotalPages.setText("Количество страниц (общее):\n\t" + totalPages);
        View.updateJPanel();
    }
    public static void updateJLabelNumberOfRecordsOnPage(){
        numbersOfRecordsOnPage = defaultTableModel.getRowCount();
        jLabelNumbersOfRecordsOnPage.setText("Количество записей на странице:\n\t" + numbersOfRecordsOnPage);
    }
    public static void updateJPanel(){
        jPanel.revalidate();
    }


    
    public static void drawFrameForAdd(){
        if (!(jFrameForAdd ==null)){
            jFrameForAdd.setVisible(true);
            return;
        }
        jFrameForAdd = getJFrameForAddFindDelete();
        jPanelForAdd = new JPanel();
        jFrameForAdd.add(jPanelForAdd);
        GridBagLayout gridBagLayout = new GridBagLayout();
       jPanelForAdd.setLayout(gridBagLayout);


        addJTextFieldArrayList.add(new JTextField());
        addJTextFieldArrayList.add(new JTextField());
        addJTextFieldArrayList.add(new JTextField());
        addJTextFieldArrayList.add(new JTextField());
        addJTextFieldArrayList.add(new JTextField());
        addJTextFieldArrayList.add(new JTextField());
        addJTextFieldArrayList.add(new JTextField());

        JLabel jLabel1 = new JLabel("ФИО студента");
        JLabel jLabel2 = new JLabel("ФИО отца");
        JLabel jLabel3 = new JLabel("Заработок отца");
        JLabel jLabel4 = new JLabel("ФИО матери");
        JLabel jLabel5 = new JLabel("Заработок матери");
        JLabel jLabel6 = new JLabel("Число братьев");
        JLabel jLabel7 = new JLabel("Число сестёр");

        jPanelForAdd.add(addJTextFieldArrayList.get(0),Constraints.getConstraintsForButtonAddForText1());
        jPanelForAdd.add(addJTextFieldArrayList.get(1),Constraints.getConstraintsForButtonAddForText2());
        jPanelForAdd.add(addJTextFieldArrayList.get(2),Constraints.getConstraintsForButtonAddForText3());
        jPanelForAdd.add(addJTextFieldArrayList.get(3),Constraints.getConstraintsForButtonAddForText4());
        jPanelForAdd.add(addJTextFieldArrayList.get(4),Constraints.getConstraintsForButtonAddForText5());
        jPanelForAdd.add(addJTextFieldArrayList.get(5),Constraints.getConstraintsForButtonAddForText6());
        jPanelForAdd.add(addJTextFieldArrayList.get(6),Constraints.getConstraintsForButtonAddForText7());

        jPanelForAdd.add(jLabel1,Constraints.getConstraintsForButtonAddForJLabel1());
        jPanelForAdd.add(jLabel2,Constraints.getConstraintsForButtonAddForJLabel2());
        jPanelForAdd.add(jLabel3,Constraints.getConstraintsForButtonAddForJLabel3());
        jPanelForAdd.add(jLabel4,Constraints.getConstraintsForButtonAddForJLabel4());
        jPanelForAdd.add(jLabel5,Constraints.getConstraintsForButtonAddForJLabel5());
        jPanelForAdd.add(jLabel6,Constraints.getConstraintsForButtonAddForJLabel6());
        jPanelForAdd.add(jLabel7,Constraints.getConstraintsForButtonAddForJLabel7());

        jPanelForAdd.add(buttonSaveForAdd,Constraints.getConstraintsForButtonAddForJButtonSave());

        jFrameForAdd.revalidate();
    }

    public static void drawFrameForFind(){
        if (!(jFrameForFind == null)){
            jFrameForFind.setVisible(true);
            return;
        }
        jFrameForFind = getJFrameForAddFindDelete();
        Controller.closeFindFrame();
        jPanelForFind = new JPanel();
        jFrameForFind.add(jPanelForFind);
        GridBagLayout gridBagLayout = new GridBagLayout();
        jPanelForFind.setLayout(gridBagLayout);

        defaultTableModelForButtonFind = new DefaultTableModel();
        Object[] columnsHeader = new String[] {"ФИО студента","ФИО отца","Заработок отца","ФИО матери","Заработок матери",
                "Число братьев","Число сестёр"};
        defaultTableModelForButtonFind.setColumnIdentifiers(columnsHeader);
        jTableForButtonFind = new JTable(defaultTableModelForButtonFind){
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
        jComboBoxForButtonFindRowsOnPage = new JComboBox(new String[]{"0","1","2","3","4","5","6","7","8","9","10"});

        jTextAreaRecordsOnPage = new JTextArea("Количество записей на странице:\n\t" + defaultTableModelForButtonFind.getRowCount());
        jTextAreaRecordsOnPage.setEditable(false);
        jTextAreaRecordsOnPage.setFont(jTextAreaRecordsOnPage.getFont().deriveFont(Font.BOLD, jTextAreaRecordsOnPage.getFont().getSize()));
        jTextAreaRecordsOnPage.setBackground(jFrameForFind.getBackground());

        jTextAreaRecords = new JTextArea("Количество записей (общее):\n\t"+ numbersOfRecordsForFind);
        jTextAreaRecords.setEditable(false);
        jTextAreaRecords.setFont(jTextAreaRecords.getFont().deriveFont(Font.BOLD, jTextAreaRecords.getFont().getSize()));
        jTextAreaRecords.setBackground(jFrameForFind.getBackground());

        jTextAreaTotalPages = new JTextArea("Количество страниц (общее):\n\t" + totalPagesForFind);
        jTextAreaTotalPages.setEditable(false);
        jTextAreaTotalPages.setFont(jTextAreaTotalPages.getFont().deriveFont(Font.BOLD, jTextAreaTotalPages.getFont().getSize()));
        jTextAreaTotalPages.setBackground(jFrameForFind.getBackground());

        jPanelForFind.add(jComboBoxForButtonFind,Constraints.getConstraintsForButtonFindJComboBox());
        jPanelForFind.add(jButtonForButtonFindFirstPage,Constraints.getConstraintsForButtonFindJButtonFirstPage());
        jPanelForFind.add(jButtonForButtonFindPreviousPage,Constraints.getConstraintsForButtonFindJButtonPreviousPage());
        jPanelForFind.add(jLabelCurrentPageForButtonFind,Constraints.getConstraintsForButtonFindJLabelCurrentPage());
        jPanelForFind.add(jButtonForButtonFindNextPage,Constraints.getConstraintsForButtonFindJButtonNextPage());
        jPanelForFind.add(jButtonForButtonFindLastPage,Constraints.getConstraintsForButtonFindJButtonLastPage());
        jPanelForFind.add(jScrollPaneForButtonFind,Constraints.getConstraintsForButtonFindJTable());
        jPanelForFind.add(jComboBoxForButtonFindRowsOnPage,Constraints.getConstraintsForButtonFindJComboBoxRowsOnPage());
        jPanelForFind.add(jTextAreaRecordsOnPage,Constraints.getConstraintsForButtonFindJTextAreaRecordsOnPage());
        jPanelForFind.add(jTextAreaRecords,Constraints.getConstraintsForButtonFindJTextAreaRecords());
        jPanelForFind.add(jTextAreaTotalPages,Constraints.getConstraintsForButtonFindJTextAreaTotalPages());


        jPanelForFind.revalidate();

        Controller.mainFrameForFind();
    }

    public static void drawFrameForFindIndex1(){
        if (!((jFrameForFindIndex1) == null)){
            jFrameForFindIndex1.setVisible(true);
            return;
        }
        jFrameForFindIndex1 = getJFrameForAddFindDelete();
        jPanelForFindIndex1 = new JPanel();
        GridBagLayout gridBagLayout = new GridBagLayout();
        jPanelForFindIndex1.setLayout(gridBagLayout);

        jLabelForFindIndex1 = new JLabel("Введите ФИО студента:");
        jTextFieldForFindIndex1 = new JTextField();
        jButtonForFindIndex1 = new JButton("Find");

        jFrameForFindIndex1.add(jPanelForFindIndex1);
        jPanelForFindIndex1.add(jLabelForFindIndex1,Constraints.getConstraintsForButtonFindSearchStudentJLabel());
        jPanelForFindIndex1.add(jTextFieldForFindIndex1,Constraints.getConstraintsForButtonFindSearchStudentTextField());
        jPanelForFindIndex1.add(jButtonForFindIndex1,Constraints.getConstraintsForButtonFindSearchStudentButton());

        Controller.componentAddListenerForFindIndex1();
    }
    public static void drawFrameForFindIndex2(){
        if (!((jFrameForFindIndex2) == null)){
            jFrameForFindIndex2.setVisible(true);
            return;
        }
        jFrameForFindIndex2 = getJFrameForAddFindDelete();
        jPanelForFindIndex2 = new JPanel();
        GridBagLayout gridBagLayout = new GridBagLayout();
        jPanelForFindIndex2.setLayout(gridBagLayout);
        jFrameForFindIndex2.add(jPanelForFindIndex2);

        jLabelMotherForFindIndex2 = new JLabel("Введите ФИО матери");
        jLabelFatherForFindIndex2 = new JLabel("Введите ФИО отца");
        jTextFieldMotherForFindIndex2 = new JTextField();
        jTextFieldFatherForFindIndex2 = new JTextField();
        jButtonForFindIndex2 = new JButton("Find");
        jRadioButtonMotherEnable = new JRadioButton("Ввести ФИО матери");
        jRadioButtonFatherEnable = new JRadioButton("Ввести ФИО отца");


        jPanelForFindIndex2.add(jRadioButtonMotherEnable, Constraints.getConstraintsForButtonFindJRadioButtonIsMotherEditableForFindIndex2());
        jPanelForFindIndex2.add(jRadioButtonFatherEnable, Constraints.getConstraintsForButtonFindJRadioButtonIsFatherEditableForFindIndex2());
        jPanelForFindIndex2.add(jLabelMotherForFindIndex2,Constraints.getConstraintsForButtonFindJLabelMotherForFindIndex2());
        jPanelForFindIndex2.add(jLabelFatherForFindIndex2,Constraints.getConstraintsForButtonFindJLabelFatherForFindIndex2());
        jPanelForFindIndex2.add(jTextFieldMotherForFindIndex2,Constraints.getConstraintsForButtonFindJTextFieldMotherForFindIndex2());
        jPanelForFindIndex2.add(jTextFieldFatherForFindIndex2,Constraints.getConstraintsForButtonFindJTextFieldFatherForFindIndex2());
        jPanelForFindIndex2.add(jButtonForFindIndex2,Constraints.getConstraintsForButtonFindJButtonForFindIndex2());

        jRadioButtonMotherEnable.setSelected(true);
        View.getJTextFieldFatherForFindIndex2().setText("");
        View.getJTextFieldFatherForFindIndex2().setEditable(false);
        View.getJTextFieldFatherForFindIndex2().setBackground(View.getjFrameForFind().getBackground());

        Controller.componentAddListenerForFindIndex2();
    }
    public static void drawFrameForFindIndex3(){
        if (!((jFrameForFindIndex3) == null)){
            jFrameForFindIndex3.setVisible(true);
            return;
        }
        jFrameForFindIndex3 = getJFrameForAddFindDelete();
        jPanelForFindIndex3 = new JPanel();
        GridBagLayout gridBagLayout = new GridBagLayout();
        jPanelForFindIndex3.setLayout(gridBagLayout);
        jFrameForFindIndex3.add(jPanelForFindIndex3);

        jLabelBrotherForFindIndex3 = new JLabel("Введите число братьев");
        jLabelSisterForFindIndex3 = new JLabel("Введите число сестер");
        jTextFieldBrotherForFindIndex3 = new JTextField();
        jTextFieldFSisterForFindIndex3 = new JTextField();
        jButtonForFindIndex3 = new JButton("Find");
        jRadioButtonBrotherEnable = new JRadioButton("Ввести число братьев");
        jRadioButtonSisterEnable = new JRadioButton("Ввести число сестер");


        jPanelForFindIndex3.add(jRadioButtonBrotherEnable, Constraints.getConstraintsForButtonFindJRadioButtonIsMotherEditableForFindIndex2());
        jPanelForFindIndex3.add(jRadioButtonSisterEnable, Constraints.getConstraintsForButtonFindJRadioButtonIsFatherEditableForFindIndex2());
        jPanelForFindIndex3.add(jLabelBrotherForFindIndex3,Constraints.getConstraintsForButtonFindJLabelMotherForFindIndex2());
        jPanelForFindIndex3.add(jLabelSisterForFindIndex3,Constraints.getConstraintsForButtonFindJLabelFatherForFindIndex2());
        jPanelForFindIndex3.add(jTextFieldBrotherForFindIndex3,Constraints.getConstraintsForButtonFindJTextFieldMotherForFindIndex2());
        jPanelForFindIndex3.add(jTextFieldFSisterForFindIndex3,Constraints.getConstraintsForButtonFindJTextFieldFatherForFindIndex2());
        jPanelForFindIndex3.add(jButtonForFindIndex3,Constraints.getConstraintsForButtonFindJButtonForFindIndex2());



        jRadioButtonBrotherEnable.setSelected(true);
        View.getJTextFieldFSisterForFindIndex3().setEditable(false);
        View.getJTextFieldFSisterForFindIndex3().setBackground(View.getjFrameForFind().getBackground());

        Controller.componentAddListenerForFindIndex3();
    }
    public static void drawFrameForFindIndex4(){
        if (!((jFrameForFindIndex4) == null)){
            jFrameForFindIndex4.setVisible(true);
            return;
        }
        jFrameForFindIndex4 = getJFrameForAddFindDelete();
        jPanelForFindIndex4 = new JPanel();
        GridBagLayout gridBagLayout = new GridBagLayout();
        jPanelForFindIndex4.setLayout(gridBagLayout);
        jFrameForFindIndex4.add(jPanelForFindIndex4);

        jLabelFatherMaxForFindIndex4 = new JLabel("Введите зарплату матери до:");
        jLabelFatherMinForFindIndex4 = new JLabel("Введите зарплату матери от:");
        jLabelMotherMaxForFindIndex4 = new JLabel("Введите зарплату отца до:");
        jLabelMotherMinForFindIndex4 = new JLabel("Введите зарплату отца от:");

        jTextFieldFatherMaxForFindIndex4 = new JTextField();
        jTextFieldFatherMinForFindIndex4 = new JTextField();
        jTextFieldMotherMaxForFindIndex4 = new JTextField();
        jTextFieldMotherMinForFindIndex4 = new JTextField();

        jButtonForFindIndex4= new JButton("Find");
        jRadioButtonFatherMoneyEnable = new JRadioButton("Ввести зарплату отца");
        jRadioButtonMotherMoneyEnable = new JRadioButton("Ввести зарплату матери");




        jPanelForFindIndex4.add(jLabelFatherMaxForFindIndex4, Constraints.getConstraintsForButtonFindJLabelFatherMaxForFindIndex4());
        jPanelForFindIndex4.add(jLabelFatherMinForFindIndex4, Constraints.getConstraintsForButtonFindJLabelFatherMinForFindIndex4());
        jPanelForFindIndex4.add(jLabelMotherMaxForFindIndex4, Constraints.getConstraintsForButtonFindJLabelMotherMaxForFindIndex4());
        jPanelForFindIndex4.add(jLabelMotherMinForFindIndex4, Constraints.getConstraintsForButtonFindJLabelMotherMinForFindIndex4());
        jPanelForFindIndex4.add(jTextFieldFatherMaxForFindIndex4, Constraints.getConstraintsForButtonFindJTextFieldFatherMaxForFindIndex4());
        jPanelForFindIndex4.add(jTextFieldFatherMinForFindIndex4, Constraints.getConstraintsForButtonFindJTextFieldFatherMinForFindIndex4());
        jPanelForFindIndex4.add(jTextFieldMotherMaxForFindIndex4, Constraints.getConstraintsForButtonFindJTextFieldMotherMaxForFindIndex4());
        jPanelForFindIndex4.add(jTextFieldMotherMinForFindIndex4, Constraints.getConstraintsForButtonFindJTextFieldMotherMinForFindIndex4());
        jPanelForFindIndex4.add(jButtonForFindIndex4, Constraints.getConstraintsForButtonFindJButtonForFindIndex4());
        jPanelForFindIndex4.add(jRadioButtonFatherMoneyEnable, Constraints.getConstraintsForButtonFindJRadioButtonFatherMoneyEnable());
        jPanelForFindIndex4.add(jRadioButtonMotherMoneyEnable, Constraints.getConstraintsForButtonFindJRadioButtonMotherMoneyEnable());

        getJRadioButtonFatherMoneyEnable().setSelected(true);
        getJTextFieldMotherMaxForFindIndex4().setEditable(false);
        getJTextFieldMotherMaxForFindIndex4().setBackground(getjFrameForFind().getBackground());

        getJTextFieldMotherMinForFindIndex4().setEditable(false);
        getJTextFieldMotherMinForFindIndex4().setBackground(getjFrameForFind().getBackground());


        Controller.componentAddListenerForFindIndex4();
    }

    public static void disableAllFindFrames(){
        if (!(jFrameForFindIndex1 == null)){
            jFrameForFindIndex1.setVisible(false);
        }
        if (!(jFrameForFindIndex2 == null)){
            jFrameForFindIndex2.setVisible(false);
        }
        if (!(jFrameForFindIndex3 == null)){
            jFrameForFindIndex3.setVisible(false);
        }
        if (!(jFrameForFindIndex4 == null)){
            jFrameForFindIndex4.setVisible(false);
        }

    }

    public static void removeAllJTableElements(DefaultTableModel defaultTableModel){
        int tableElementsCount = defaultTableModel.getRowCount();
        for (int i=0; i<tableElementsCount; i++){
            defaultTableModel.removeRow(0);
        }

    }

    public static void jTableUpdate(DefaultTableModel defaultTableModel, JTable jTable, JPanel jPanel, ArrayList<Model.Student> studentArrayList){

            defaultTableModel.addRow(new String[]{studentArrayList.get(defaultTableModel.getRowCount()).getStudentName(),
                    studentArrayList.get(defaultTableModel.getRowCount()).getFatherName(),
                    String.valueOf(studentArrayList.get(defaultTableModel.getRowCount()).getFatherEarnings()),
                    studentArrayList.get(jTable.getRowCount()).getMotherName(),
                    String.valueOf(studentArrayList.get(jTable.getRowCount()).getMotherEarnings()),
                    String.valueOf(studentArrayList.get(jTable.getRowCount()).getNumberOfBrothers()),
                    String.valueOf(studentArrayList.get(jTable.getRowCount()).getNumberOfSisters())});

        jPanel.revalidate();
    }

    static JFrame getJFrame() {
        JFrame getJFrame = new JFrame();
        getJFrame.setVisible(true);
        getJFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        getJFrame.setTitle("Title");
        getJFrame.setLocationRelativeTo(null);
        getJFrame.setSize(750, 300);
        ImageIcon imageIcon = new ImageIcon("C:\\Users\\Igor\\Desktop\\книги\\!!!PROFILI!!!\\картинки\\avesta\\l3r1WDtOWio.jpg");
        getJFrame.setIconImage(imageIcon.getImage());
        return getJFrame;
    }

    static JFrame getJFrameForAddFindDelete() {
        JFrame getJFrame = new JFrame();
        getJFrame.setVisible(true);
        getJFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        getJFrame.setTitle("Title");
        getJFrame.setLocationRelativeTo(null);
        getJFrame.setSize(655, 270);
        ImageIcon imageIcon = new ImageIcon("C:\\Users\\Igor\\Desktop\\книги\\!!!PROFILI!!!\\картинки\\avesta\\l3r1WDtOWio.jpg");
        getJFrame.setIconImage(imageIcon.getImage());
        return getJFrame;
    }

    public static void disableAllDeleteFrames(){
        if (!(jFrameForDeleteIndex1 == null)){
            jFrameForDeleteIndex1.setVisible(false);
        }
        if (!(jFrameForDeleteIndex2 == null)){
            jFrameForDeleteIndex2.setVisible(false);
        }
        if (!(jFrameForFindIndex3 == null)){
            jFrameForFindIndex3.setVisible(false);
        }
        if (!(jFrameForFindIndex4 == null)){
            jFrameForFindIndex4.setVisible(false);
        }
    }


    public static class Constraints {

        static GridBagConstraints getConstraintsForButtonFind(){
            GridBagConstraints constraints = new GridBagConstraints();
            constraints.fill = GridBagConstraints.BOTH;
            constraints.weightx = 100.0;
            constraints.weighty = 100.0;

            constraints.insets.bottom =5;
            constraints.insets.left = 5;
            constraints.insets.right =5;
            constraints.insets.top = 5;

            constraints.ipadx = 0;

            constraints.gridx =0;
            constraints.gridy =1;
            constraints.gridheight=1;
            constraints.gridwidth =1;
            return constraints;
        }
        static GridBagConstraints getConstraintsForButtonAdd(){
            GridBagConstraints constraints = new GridBagConstraints();
            constraints.fill = GridBagConstraints.BOTH;
            constraints.weightx = 100.0;
            constraints.weighty = 100.0;

            constraints.insets.bottom =5;
            constraints.insets.left = 5;
            constraints.insets.right =5;
            constraints.insets.top = 5;

            constraints.ipadx = 0;

            constraints.gridx =0;
            constraints.gridy =2;
            constraints.gridheight=1;
            constraints.gridwidth =1;
            return constraints;
        }
        static GridBagConstraints getConstraintsForButtonDelete(){
            GridBagConstraints constraints = new GridBagConstraints();
            constraints.fill = GridBagConstraints.BOTH;
            constraints.weightx = 100.0;
            constraints.weighty = 100.0;

            constraints.insets.bottom =5;
            constraints.insets.left = 5;
            constraints.insets.right =5;
            constraints.insets.top = 5;

            constraints.ipadx = 0;

            constraints.gridx =0;
            constraints.gridy =3;
            constraints.gridheight=1;
            constraints.gridwidth =1;
            return constraints;
        }
        static GridBagConstraints getConstraintsForButtonFirstPage(){
            GridBagConstraints constraints = new GridBagConstraints();
            constraints.fill = GridBagConstraints.NONE;
            constraints.anchor = GridBagConstraints.EAST;
            constraints.weightx = 100.0;
            constraints.weighty = 100.0;

            constraints.insets.bottom =5;
            constraints.insets.left = 5;
            constraints.insets.right =5;
            constraints.insets.top = 5;

            constraints.ipadx = 0;

            constraints.gridx =1;
            constraints.gridy =0;
            constraints.gridheight=1;
            constraints.gridwidth =1;
            return constraints;
        }
        static GridBagConstraints getConstraintsForButtonLastPage(){
            GridBagConstraints constraints = new GridBagConstraints();
            constraints.fill = GridBagConstraints.NONE;
            constraints.anchor = GridBagConstraints.WEST;
            constraints.weightx = 100.0;
            constraints.weighty = 100.0;

            constraints.insets.bottom =5;
            constraints.insets.left = 5;
            constraints.insets.right =5;
            constraints.insets.top = 5;

            constraints.ipadx = 0;

            constraints.gridx =5;
            constraints.gridy =0;
            constraints.gridheight=1;
            constraints.gridwidth =1;
            return constraints;
        }
        static GridBagConstraints getConstraintsForJComboBoxMainFrame(){
            GridBagConstraints constraints = new GridBagConstraints();
            constraints.fill = GridBagConstraints.NONE;
            constraints.weightx = 100.0;
            constraints.weighty = 100.0;

            constraints.insets.bottom =5;
            constraints.insets.left = 5;
            constraints.insets.right =5;
            constraints.insets.top = 5;
            constraints.anchor = GridBagConstraints.CENTER;
            constraints.ipadx = 0;

            constraints.gridx =6;
            constraints.gridy =0;
            constraints.gridheight=1;
            constraints.gridwidth =1;
            return constraints;
        }
        static GridBagConstraints getConstraintsForJLabelNumbersOfRecordsOnPage(){
            GridBagConstraints constraints = new GridBagConstraints();
            constraints.fill = GridBagConstraints.BOTH;
            constraints.weightx = 100.0;
            constraints.weighty = 100.0;

            constraints.insets.bottom =5;
            constraints.insets.left = 5;
            constraints.insets.right =5;
            constraints.insets.top = 5;
            constraints.anchor = GridBagConstraints.CENTER;
            constraints.ipadx = 0;

            constraints.gridx =6;
            constraints.gridy =1;
            constraints.gridheight=1;
            constraints.gridwidth =1;
            return constraints;
        }
        static GridBagConstraints getConstraintsForJLabelNumbersOfRecords(){
            GridBagConstraints constraints = new GridBagConstraints();
            constraints.fill = GridBagConstraints.BOTH;

            constraints.weightx = 100.0;
            constraints.weighty = 100.0;

            constraints.insets.bottom =5;
            constraints.insets.left = 5;
            constraints.insets.right =5;
            constraints.insets.top = 5;
            constraints.anchor = GridBagConstraints.CENTER;
            constraints.ipadx = 0;

            constraints.gridx =6;
            constraints.gridy =2;
            constraints.gridheight=1;
            constraints.gridwidth =1;
            return constraints;
        }
        static GridBagConstraints getConstraintsForJLabelTotalPages(){
            GridBagConstraints constraints = new GridBagConstraints();
            constraints.fill = GridBagConstraints.BOTH;
            constraints.weightx = 100.0;
            constraints.weighty = 100.0;

            constraints.insets.bottom =5;
            constraints.insets.left = 5;
            constraints.insets.right =5;
            constraints.insets.top = 5;
            constraints.anchor = GridBagConstraints.CENTER;
            constraints.ipadx = 0;

            constraints.gridx =6;
            constraints.gridy =3;
            constraints.gridheight=1;
            constraints.gridwidth =1;
            return constraints;
        }


        static GridBagConstraints getConstraintsForButtonAddForText1(){
            GridBagConstraints constraints = new GridBagConstraints();
            constraints.fill = GridBagConstraints.BOTH;
            constraints.weightx = 100.0;
            constraints.weighty = 100.0;

            constraints.insets.bottom =5;
            constraints.insets.left = 5;
            constraints.insets.right =5;
            constraints.insets.top = 5;

            constraints.ipadx = 0;

            constraints.gridx =1;
            constraints.gridy =0;
            constraints.gridheight=1;
            constraints.gridwidth =1;
            return constraints;
        }
        static GridBagConstraints getConstraintsForButtonAddForText2(){
            GridBagConstraints constraints = new GridBagConstraints();
            constraints.fill = GridBagConstraints.BOTH;
            constraints.weightx = 100.0;
            constraints.weighty = 100.0;

            constraints.insets.bottom =5;
            constraints.insets.left = 5;
            constraints.insets.right =5;
            constraints.insets.top = 5;

            constraints.ipadx = 0;

            constraints.gridx =1;
            constraints.gridy =1;
            constraints.gridheight=1;
            constraints.gridwidth =1;
            return constraints;
        }
        static GridBagConstraints getConstraintsForButtonAddForText3(){
            GridBagConstraints constraints = new GridBagConstraints();
            constraints.fill = GridBagConstraints.BOTH;
            constraints.weightx = 100.0;
            constraints.weighty = 100.0;

            constraints.insets.bottom =5;
            constraints.insets.left = 5;
            constraints.insets.right =5;
            constraints.insets.top = 5;

            constraints.ipadx = 0;

            constraints.gridx =1;
            constraints.gridy =2;
            constraints.gridheight=1;
            constraints.gridwidth =1;
            return constraints;
        }
        static GridBagConstraints getConstraintsForButtonAddForText4(){
            GridBagConstraints constraints = new GridBagConstraints();
            constraints.fill = GridBagConstraints.BOTH;
            constraints.weightx = 100.0;
            constraints.weighty = 100.0;

            constraints.insets.bottom =5;
            constraints.insets.left = 5;
            constraints.insets.right =5;
            constraints.insets.top = 5;

            constraints.ipadx = 0;

            constraints.gridx =1;
            constraints.gridy =3;
            constraints.gridheight=1;
            constraints.gridwidth =1;
            return constraints;
        }
        static GridBagConstraints getConstraintsForButtonAddForText5(){
            GridBagConstraints constraints = new GridBagConstraints();
            constraints.fill = GridBagConstraints.BOTH;
            constraints.weightx = 100.0;
            constraints.weighty = 100.0;

            constraints.insets.bottom =5;
            constraints.insets.left = 5;
            constraints.insets.right =5;
            constraints.insets.top = 5;

            constraints.ipadx = 0;

            constraints.gridx =1;
            constraints.gridy =4;
            constraints.gridheight=1;
            constraints.gridwidth =1;
            return constraints;
        }
        static GridBagConstraints getConstraintsForButtonAddForText6(){
            GridBagConstraints constraints = new GridBagConstraints();
            constraints.fill = GridBagConstraints.BOTH;
            constraints.weightx = 100.0;
            constraints.weighty = 100.0;

            constraints.insets.bottom =5;
            constraints.insets.left = 5;
            constraints.insets.right =5;
            constraints.insets.top = 5;

            constraints.ipadx = 0;

            constraints.gridx =1;
            constraints.gridy =5;
            constraints.gridheight=1;
            constraints.gridwidth =1;
            return constraints;
        }
        static GridBagConstraints getConstraintsForButtonAddForText7(){
            GridBagConstraints constraints = new GridBagConstraints();
            constraints.fill = GridBagConstraints.BOTH;
            constraints.weightx = 100.0;
            constraints.weighty = 100.0;

            constraints.insets.bottom =5;
            constraints.insets.left = 5;
            constraints.insets.right =5;
            constraints.insets.top = 5;

            constraints.ipadx = 0;

            constraints.gridx =1;
            constraints.gridy =6;
            constraints.gridheight=1;
            constraints.gridwidth =1;
            return constraints;
        }
        static GridBagConstraints getConstraintsForButtonAddForJLabel1(){
            GridBagConstraints constraints = new GridBagConstraints();
            constraints.fill = GridBagConstraints.BOTH;
            constraints.weightx = 100.0;
            constraints.weighty = 100.0;

            constraints.insets.bottom =5;
            constraints.insets.left = 5;
            constraints.insets.right =5;
            constraints.insets.top = 5;

            constraints.ipadx = 0;

            constraints.gridx =0;
            constraints.gridy =0;
            constraints.gridheight=1;
            constraints.gridwidth =1;
            return constraints;
        }
        static GridBagConstraints getConstraintsForButtonAddForJLabel2(){
            GridBagConstraints constraints = new GridBagConstraints();
            constraints.fill = GridBagConstraints.BOTH;
            constraints.weightx = 100.0;
            constraints.weighty = 100.0;

            constraints.insets.bottom =5;
            constraints.insets.left = 5;
            constraints.insets.right =5;
            constraints.insets.top = 5;

            constraints.ipadx = 0;

            constraints.gridx =0;
            constraints.gridy =1;
            constraints.gridheight=1;
            constraints.gridwidth =1;
            return constraints;
        }
        static GridBagConstraints getConstraintsForButtonAddForJLabel3(){
            GridBagConstraints constraints = new GridBagConstraints();
            constraints.fill = GridBagConstraints.BOTH;
            constraints.weightx = 100.0;
            constraints.weighty = 100.0;

            constraints.insets.bottom =5;
            constraints.insets.left = 5;
            constraints.insets.right =5;
            constraints.insets.top = 5;

            constraints.ipadx = 0;

            constraints.gridx =0;
            constraints.gridy =2;
            constraints.gridheight=1;
            constraints.gridwidth =1;
            return constraints;
        }
        static GridBagConstraints getConstraintsForButtonAddForJLabel4(){
            GridBagConstraints constraints = new GridBagConstraints();
            constraints.fill = GridBagConstraints.BOTH;
            constraints.weightx = 100.0;
            constraints.weighty = 100.0;

            constraints.insets.bottom =5;
            constraints.insets.left = 5;
            constraints.insets.right =5;
            constraints.insets.top = 5;

            constraints.ipadx = 0;

            constraints.gridx =0;
            constraints.gridy =3;
            constraints.gridheight=1;
            constraints.gridwidth =1;
            return constraints;
        }
        static GridBagConstraints getConstraintsForButtonAddForJLabel5(){
            GridBagConstraints constraints = new GridBagConstraints();
            constraints.fill = GridBagConstraints.BOTH;
            constraints.weightx = 100.0;
            constraints.weighty = 100.0;

            constraints.insets.bottom =5;
            constraints.insets.left = 5;
            constraints.insets.right =5;
            constraints.insets.top = 5;

            constraints.ipadx = 0;

            constraints.gridx =0;
            constraints.gridy =4;
            constraints.gridheight=1;
            constraints.gridwidth =1;
            return constraints;
        }
        static GridBagConstraints getConstraintsForButtonAddForJLabel6(){
            GridBagConstraints constraints = new GridBagConstraints();
            constraints.fill = GridBagConstraints.BOTH;
            constraints.weightx = 100.0;
            constraints.weighty = 100.0;

            constraints.insets.bottom =5;
            constraints.insets.left = 5;
            constraints.insets.right =5;
            constraints.insets.top = 5;

            constraints.ipadx = 0;

            constraints.gridx =0;
            constraints.gridy =5;
            constraints.gridheight=1;
            constraints.gridwidth =1;
            return constraints;
        }
        static GridBagConstraints getConstraintsForButtonAddForJLabel7(){
            GridBagConstraints constraints = new GridBagConstraints();
            constraints.fill = GridBagConstraints.BOTH;
            constraints.weightx = 100.0;
            constraints.weighty = 100.0;

            constraints.insets.bottom =5;
            constraints.insets.left = 5;
            constraints.insets.right =5;
            constraints.insets.top = 5;

            constraints.ipadx = 0;

            constraints.gridx =0;
            constraints.gridy =6;
            constraints.gridheight=1;
            constraints.gridwidth =1;
            return constraints;
        }
        static GridBagConstraints getConstraintsForButtonAddForJButtonSave(){
            GridBagConstraints constraints = new GridBagConstraints();
            constraints.fill = GridBagConstraints.BOTH;
            constraints.weightx = 100.0;
            constraints.weighty = 100.0;

            constraints.insets.bottom =5;
            constraints.insets.left = 5;
            constraints.insets.right =5;
            constraints.insets.top = 20;

            constraints.ipadx = 0;

            constraints.gridx =1;
            constraints.gridy =7;
            constraints.gridheight=1;
            constraints.gridwidth =1;
            return constraints;
        }
        static GridBagConstraints getConstraintsForJTable(){
            GridBagConstraints constraints = new GridBagConstraints();
            constraints.fill = GridBagConstraints.BOTH;
            constraints.weightx = 100.0;
            constraints.weighty = 100.0;

            constraints.insets.bottom =5;
            constraints.insets.left = 5;
            constraints.insets.right =5;
            constraints.insets.top = 5;



            constraints.ipadx = 0; //jFrame.getRootPane().getWidth()*2/5;

            constraints.gridx =1;
            constraints.gridy =1;
            constraints.gridheight=3;
            constraints.gridwidth =5;
            return constraints;
        }
        static GridBagConstraints getConstraintsForButtonNext(){
            GridBagConstraints constraints = new GridBagConstraints();
            //constraints.fill = GridBagConstraints.VERTICAL;
            constraints.anchor = GridBagConstraints.WEST;
            constraints.weightx = 100.0;
            constraints.weighty = 100.0;

            constraints.insets.bottom =5;
            constraints.insets.left = 5;
            constraints.insets.right =5;
            constraints.insets.top = 5;



            constraints.ipadx =0; //jFrame.getRootPane().getWidth()*2/5;

            constraints.gridx =4;
            constraints.gridy =0;
            constraints.gridheight=1;
            constraints.gridwidth =1;
            return constraints;
        }
        static GridBagConstraints getConstraintsForButtonPrevious(){
            GridBagConstraints constraints = new GridBagConstraints();
            constraints.fill = GridBagConstraints.NONE;
            constraints.anchor = GridBagConstraints.EAST;
            constraints.weightx = 100.0;
            constraints.weighty = 100.0;

            constraints.insets.bottom =5;
            constraints.insets.left = 5;
            constraints.insets.right =5;
            constraints.insets.top = 5;



            constraints.ipadx =0; //jFrame.getRootPane().getWidth()*2/5;

            constraints.gridx =2;
            constraints.gridy =0;
            constraints.gridheight=1;
            constraints.gridwidth =1;
            return constraints;
        }
        static GridBagConstraints getConstraintsForLabelCurrent(){
            GridBagConstraints constraints = new GridBagConstraints();
            constraints.fill = GridBagConstraints.NONE;
            constraints.weightx = 100.0;
            constraints.weighty = 100.0;

            constraints.insets.bottom =5;
            constraints.insets.left = 5;
            constraints.insets.right =5;
            constraints.insets.top = 5;
            constraints.anchor = GridBagConstraints.CENTER;


            constraints.ipadx =0; //jFrame.getRootPane().getWidth()*2/5;

            constraints.gridx =3;
            constraints.gridy =0;
            constraints.gridheight=1;
            constraints.gridwidth =1;
            return constraints;
        }


        static GridBagConstraints getConstraintsForButtonFindJComboBox(){
            GridBagConstraints constraints = new GridBagConstraints();
            constraints.fill = GridBagConstraints.NONE;
            constraints.weightx = 100.0;
            constraints.weighty = 100.0;

            constraints.insets.bottom =5;
            constraints.insets.left = 5;
            constraints.insets.right =5;
            constraints.insets.top = 5;

            constraints.ipadx = 0;

            constraints.gridx =0;
            constraints.gridy =0;
            constraints.gridheight=1;
            constraints.gridwidth =1;
            return constraints;
        }
        static GridBagConstraints getConstraintsForButtonFindJButtonFirstPage(){
            GridBagConstraints constraints = new GridBagConstraints();
            constraints.fill = GridBagConstraints.NONE;
            constraints.weightx = 100.0;
            constraints.weighty = 100.0;

            constraints.insets.bottom =5;
            constraints.insets.left = 5;
            constraints.insets.right =5;
            constraints.insets.top = 5;

            constraints.ipadx = 0;

            constraints.gridx =1;
            constraints.gridy =0;
            constraints.gridheight=1;
            constraints.gridwidth =1;
            return constraints;
        }
        static GridBagConstraints getConstraintsForButtonFindJButtonPreviousPage(){
            GridBagConstraints constraints = new GridBagConstraints();
            constraints.fill = GridBagConstraints.NONE;
            constraints.weightx = 100.0;
            constraints.weighty = 100.0;

            constraints.insets.bottom =5;
            constraints.insets.left = 5;
            constraints.insets.right =5;
            constraints.insets.top = 5;

            constraints.ipadx = 0;

            constraints.gridx =2;
            constraints.gridy =0;
            constraints.gridheight=1;
            constraints.gridwidth =1;
            return constraints;
        }
        static GridBagConstraints getConstraintsForButtonFindJLabelCurrentPage(){
            GridBagConstraints constraints = new GridBagConstraints();
            constraints.fill = GridBagConstraints.NONE;
            constraints.weightx = 100.0;
            constraints.weighty = 100.0;

            constraints.insets.bottom =5;
            constraints.insets.left = 5;
            constraints.insets.right =5;
            constraints.insets.top = 5;

            constraints.ipadx = 0;

            constraints.gridx =3;
            constraints.gridy =0;
            constraints.gridheight=1;
            constraints.gridwidth =1;
            return constraints;
        }
        static GridBagConstraints getConstraintsForButtonFindJButtonNextPage(){
            GridBagConstraints constraints = new GridBagConstraints();
            constraints.fill = GridBagConstraints.NONE;
            constraints.weightx = 100.0;
            constraints.weighty = 100.0;

            constraints.insets.bottom =5;
            constraints.insets.left = 5;
            constraints.insets.right =5;
            constraints.insets.top = 5;

            constraints.ipadx = 0;

            constraints.gridx =4;
            constraints.gridy =0;
            constraints.gridheight=1;
            constraints.gridwidth =1;
            return constraints;
        }
        static GridBagConstraints getConstraintsForButtonFindJButtonLastPage(){
            GridBagConstraints constraints = new GridBagConstraints();
            constraints.fill = GridBagConstraints.NONE;
            constraints.weightx = 100.0;
            constraints.weighty = 100.0;

            constraints.insets.bottom =5;
            constraints.insets.left = 5;
            constraints.insets.right =5;
            constraints.insets.top = 5;

            constraints.ipadx = 0;

            constraints.gridx =5;
            constraints.gridy =0;
            constraints.gridheight=1;
            constraints.gridwidth =1;
            return constraints;
        }
        static GridBagConstraints getConstraintsForButtonFindJTable(){
            GridBagConstraints constraints = new GridBagConstraints();
            constraints.fill = GridBagConstraints.BOTH;
            constraints.weightx = 100.0;
            constraints.weighty = 100.0;

            constraints.insets.bottom =5;
            constraints.insets.left = 5;
            constraints.insets.right =5;
            constraints.insets.top = 5;

            constraints.ipadx = 0;

            constraints.gridx =0;
            constraints.gridy =1;
            constraints.gridheight=3;
            constraints.gridwidth =6;
            return constraints;
        }
        static GridBagConstraints getConstraintsForButtonFindJComboBoxRowsOnPage(){
            GridBagConstraints constraints = new GridBagConstraints();
            constraints.fill = GridBagConstraints.NONE;
            constraints.weightx = 100.0;
            constraints.weighty = 100.0;

            constraints.insets.bottom =5;
            constraints.insets.left = 5;
            constraints.insets.right =5;
            constraints.insets.top = 5;

            constraints.ipadx = 0;

            constraints.gridx = 6;
            constraints.gridy =0;
            constraints.gridheight=1;
            constraints.gridwidth =1;
            return constraints;
        }
        static GridBagConstraints getConstraintsForButtonFindJTextAreaRecordsOnPage(){
            GridBagConstraints constraints = new GridBagConstraints();
            constraints.fill = GridBagConstraints.BOTH;
            constraints.weightx = 100.0;
            constraints.weighty = 100.0;

            constraints.insets.bottom =5;
            constraints.insets.left = 5;
            constraints.insets.right =5;
            constraints.insets.top = 5;

            constraints.ipadx = 0;

            constraints.gridx = 6;
            constraints.gridy =1;
            constraints.gridheight=1;
            constraints.gridwidth =1;
            return constraints;
        }
        static GridBagConstraints getConstraintsForButtonFindJTextAreaRecords(){
            GridBagConstraints constraints = new GridBagConstraints();
            constraints.fill = GridBagConstraints.BOTH;
            constraints.weightx = 100.0;
            constraints.weighty = 100.0;

            constraints.insets.bottom =5;
            constraints.insets.left = 5;
            constraints.insets.right =5;
            constraints.insets.top = 5;

            constraints.ipadx = 0;

            constraints.gridx = 6;
            constraints.gridy =2;
            constraints.gridheight=1;
            constraints.gridwidth =1;
            return constraints;
        }
        static GridBagConstraints getConstraintsForButtonFindJTextAreaTotalPages(){
            GridBagConstraints constraints = new GridBagConstraints();
            constraints.fill = GridBagConstraints.BOTH;
            constraints.weightx = 100.0;
            constraints.weighty = 100.0;

            constraints.insets.bottom =5;
            constraints.insets.left = 5;
            constraints.insets.right =5;
            constraints.insets.top = 5;

            constraints.ipadx = 0;

            constraints.gridx = 6;
            constraints.gridy =3;
            constraints.gridheight=1;
            constraints.gridwidth =1;
            return constraints;
        }

        static GridBagConstraints getConstraintsForButtonFindSearchStudentJLabel(){
            GridBagConstraints constraints = new GridBagConstraints();
            constraints.fill = GridBagConstraints.BOTH;
            constraints.weightx = 100.0;
            constraints.weighty = 100.0;

            constraints.insets.bottom =5;
            constraints.insets.left = 5;
            constraints.insets.right =5;
            constraints.insets.top = 5;

            constraints.ipadx = 0;

            constraints.gridx = 0;
            constraints.gridy =0;
            constraints.gridheight=1;
            constraints.gridwidth =1;
            return constraints;
        }
        static GridBagConstraints getConstraintsForButtonFindSearchStudentTextField(){
            GridBagConstraints constraints = new GridBagConstraints();
            constraints.fill = GridBagConstraints.BOTH;
            constraints.weightx = 100.0;
            constraints.weighty = 100.0;

            constraints.insets.bottom =5;
            constraints.insets.left = 5;
            constraints.insets.right =5;
            constraints.insets.top = 5;

            constraints.ipadx = 0;

            constraints.gridx = 0;
            constraints.gridy =1;
            constraints.gridheight=1;
            constraints.gridwidth =1;
            return constraints;
        }
        static GridBagConstraints getConstraintsForButtonFindSearchStudentButton(){
            GridBagConstraints constraints = new GridBagConstraints();
            constraints.fill = GridBagConstraints.NONE;
            constraints.weightx = 100.0;
            constraints.weighty = 100.0;

            constraints.insets.bottom =5;
            constraints.insets.left = 5;
            constraints.insets.right =5;
            constraints.insets.top = 5;

            constraints.ipadx = 0;

            constraints.gridx = 0;
            constraints.gridy =2;
            constraints.gridheight=1;
            constraints.gridwidth =1;
            return constraints;
        }

        static GridBagConstraints getConstraintsForButtonFindJRadioButtonIsMotherEditableForFindIndex2(){
            GridBagConstraints constraints = new GridBagConstraints();
            constraints.fill = GridBagConstraints.NONE;
            constraints.weightx = 100.0;
            constraints.weighty = 100.0;

            constraints.insets.bottom =5;
            constraints.insets.left = 5;
            constraints.insets.right =5;
            constraints.insets.top = 5;

            constraints.ipadx = 0;

            constraints.gridx = 0;
            constraints.gridy =0;
            constraints.gridheight=1;
            constraints.gridwidth =1;
            return constraints;
        }
        static GridBagConstraints getConstraintsForButtonFindJRadioButtonIsFatherEditableForFindIndex2(){
            GridBagConstraints constraints = new GridBagConstraints();
            constraints.fill = GridBagConstraints.NONE;
            constraints.weightx = 100.0;
            constraints.weighty = 100.0;

            constraints.insets.bottom =5;
            constraints.insets.left = 5;
            constraints.insets.right =5;
            constraints.insets.top = 5;

            constraints.ipadx = 0;

            constraints.gridx = 1;
            constraints.gridy =0;
            constraints.gridheight=1;
            constraints.gridwidth =1;
            return constraints;
        }
        static GridBagConstraints getConstraintsForButtonFindJLabelMotherForFindIndex2(){
            GridBagConstraints constraints = new GridBagConstraints();
            constraints.fill = GridBagConstraints.NONE;
            constraints.weightx = 100.0;
            constraints.weighty = 100.0;

            constraints.insets.bottom =5;
            constraints.insets.left = 5;
            constraints.insets.right =5;
            constraints.insets.top = 5;

            constraints.ipadx = 0;

            constraints.gridx = 0;
            constraints.gridy =1;
            constraints.gridheight=1;
            constraints.gridwidth =1;
            return constraints;
        }
        static GridBagConstraints getConstraintsForButtonFindJLabelFatherForFindIndex2(){
            GridBagConstraints constraints = new GridBagConstraints();
            constraints.fill = GridBagConstraints.NONE;
            constraints.weightx = 100.0;
            constraints.weighty = 100.0;

            constraints.insets.bottom =5;
            constraints.insets.left = 5;
            constraints.insets.right =5;
            constraints.insets.top = 5;

            constraints.ipadx = 0;

            constraints.gridx = 0;
            constraints.gridy =2;
            constraints.gridheight=1;
            constraints.gridwidth =1;
            return constraints;
        }
        static GridBagConstraints getConstraintsForButtonFindJTextFieldMotherForFindIndex2(){
            GridBagConstraints constraints = new GridBagConstraints();
            constraints.fill = GridBagConstraints.HORIZONTAL;
            constraints.weightx = 100.0;
            constraints.weighty = 100.0;

            constraints.insets.bottom =5;
            constraints.insets.left = 5;
            constraints.insets.right =5;
            constraints.insets.top = 5;

            constraints.ipadx = 0;

            constraints.gridx = 1;
            constraints.gridy =1;
            constraints.gridheight=1;
            constraints.gridwidth =1;
            return constraints;
        }
        static GridBagConstraints getConstraintsForButtonFindJTextFieldFatherForFindIndex2(){
            GridBagConstraints constraints = new GridBagConstraints();
            constraints.fill = GridBagConstraints.HORIZONTAL;
            constraints.weightx = 100.0;
            constraints.weighty = 100.0;

            constraints.insets.bottom =5;
            constraints.insets.left = 5;
            constraints.insets.right =5;
            constraints.insets.top = 5;

            constraints.ipadx = 0;

            constraints.gridx = 1;
            constraints.gridy =2;
            constraints.gridheight=1;
            constraints.gridwidth =1;
            return constraints;
        }
        static GridBagConstraints getConstraintsForButtonFindJButtonForFindIndex2(){
            GridBagConstraints constraints = new GridBagConstraints();
            constraints.fill = GridBagConstraints.NONE;
            constraints.weightx = 100.0;
            constraints.weighty = 100.0;

            constraints.insets.bottom =5;
            constraints.insets.left = 5;
            constraints.insets.right =5;
            constraints.insets.top = 20;

            constraints.ipadx = 0;

            constraints.gridx = 1;
            constraints.gridy =3;
            constraints.gridheight=1;
            constraints.gridwidth =1;
            return constraints;
        }

        static GridBagConstraints getConstraintsForButtonFindJRadioButtonFatherMoneyEnable(){
            GridBagConstraints constraints = new GridBagConstraints();
            constraints.fill = GridBagConstraints.NONE;
            constraints.weightx = 100.0;
            constraints.weighty = 100.0;

            constraints.insets.bottom =5;
            constraints.insets.left = 5;
            constraints.insets.right =5;
            constraints.insets.top = 20;

            constraints.ipadx = 0;

            constraints.gridx = 0;
            constraints.gridy =0;
            constraints.gridheight=1;
            constraints.gridwidth =1;
            return constraints;
        }
        static GridBagConstraints getConstraintsForButtonFindJRadioButtonMotherMoneyEnable(){
            GridBagConstraints constraints = new GridBagConstraints();
            constraints.fill = GridBagConstraints.NONE;
            constraints.weightx = 100.0;
            constraints.weighty = 100.0;

            constraints.insets.bottom =5;
            constraints.insets.left = 5;
            constraints.insets.right =5;
            constraints.insets.top = 5;

            constraints.ipadx = 0;

            constraints.gridx = 1;
            constraints.gridy =0;
            constraints.gridheight=1;
            constraints.gridwidth =1;
            return constraints;
        }
        static GridBagConstraints getConstraintsForButtonFindJLabelFatherMaxForFindIndex4(){
            GridBagConstraints constraints = new GridBagConstraints();
            constraints.fill = GridBagConstraints.NONE;
            constraints.weightx = 100.0;
            constraints.weighty = 100.0;

            constraints.insets.bottom =5;
            constraints.insets.left = 5;
            constraints.insets.right =5;
            constraints.insets.top = 5;

            constraints.ipadx = 0;

            constraints.gridx = 0;
            constraints.gridy =3;
            constraints.gridheight=1;
            constraints.gridwidth =1;
            return constraints;
        }
        static GridBagConstraints getConstraintsForButtonFindJLabelFatherMinForFindIndex4(){
            GridBagConstraints constraints = new GridBagConstraints();
            constraints.fill = GridBagConstraints.NONE;
            constraints.weightx = 100.0;
            constraints.weighty = 100.0;

            constraints.insets.bottom =5;
            constraints.insets.left = 5;
            constraints.insets.right =5;
            constraints.insets.top = 5;

            constraints.ipadx = 0;

            constraints.gridx = 0;
            constraints.gridy =4;
            constraints.gridheight=1;
            constraints.gridwidth =1;
            return constraints;
        }
        static GridBagConstraints getConstraintsForButtonFindJLabelMotherMaxForFindIndex4(){
            GridBagConstraints constraints = new GridBagConstraints();
            constraints.fill = GridBagConstraints.NONE;
            constraints.weightx = 100.0;
            constraints.weighty = 100.0;

            constraints.insets.bottom =5;
            constraints.insets.left = 5;
            constraints.insets.right =5;
            constraints.insets.top = 5;

            constraints.ipadx = 0;

            constraints.gridx = 0;
            constraints.gridy =1;
            constraints.gridheight=1;
            constraints.gridwidth =1;
            return constraints;
        }
        static GridBagConstraints getConstraintsForButtonFindJLabelMotherMinForFindIndex4(){
            GridBagConstraints constraints = new GridBagConstraints();
            constraints.fill = GridBagConstraints.NONE;
            constraints.weightx = 100.0;
            constraints.weighty = 100.0;

            constraints.insets.bottom =5;
            constraints.insets.left = 5;
            constraints.insets.right =5;
            constraints.insets.top = 5;

            constraints.ipadx = 0;

            constraints.gridx = 0;
            constraints.gridy =2;
            constraints.gridheight=1;
            constraints.gridwidth =1;
            return constraints;
        }
        static GridBagConstraints getConstraintsForButtonFindJTextFieldFatherMaxForFindIndex4(){
            GridBagConstraints constraints = new GridBagConstraints();
            constraints.fill = GridBagConstraints.HORIZONTAL;
            constraints.weightx = 100.0;
            constraints.weighty = 100.0;

            constraints.insets.bottom =5;
            constraints.insets.left = 5;
            constraints.insets.right =5;
            constraints.insets.top = 5;

            constraints.ipadx = 0;

            constraints.gridx = 1;
            constraints.gridy =1;
            constraints.gridheight=1;
            constraints.gridwidth =1;
            return constraints;
        }
        static GridBagConstraints getConstraintsForButtonFindJTextFieldFatherMinForFindIndex4(){
            GridBagConstraints constraints = new GridBagConstraints();
            constraints.fill = GridBagConstraints.HORIZONTAL;
            constraints.weightx = 100.0;
            constraints.weighty = 100.0;

            constraints.insets.bottom =5;
            constraints.insets.left = 5;
            constraints.insets.right =5;
            constraints.insets.top = 5;

            constraints.ipadx = 0;

            constraints.gridx = 1;
            constraints.gridy =2;
            constraints.gridheight=1;
            constraints.gridwidth =1;
            return constraints;
        }
        static GridBagConstraints getConstraintsForButtonFindJTextFieldMotherMaxForFindIndex4(){
            GridBagConstraints constraints = new GridBagConstraints();
            constraints.fill = GridBagConstraints.HORIZONTAL;
            constraints.weightx = 100.0;
            constraints.weighty = 100.0;

            constraints.insets.bottom =5;
            constraints.insets.left = 5;
            constraints.insets.right =5;
            constraints.insets.top = 5;

            constraints.ipadx = 0;

            constraints.gridx = 1;
            constraints.gridy =3;
            constraints.gridheight=1;
            constraints.gridwidth =1;
            return constraints;
        }
        static GridBagConstraints getConstraintsForButtonFindJTextFieldMotherMinForFindIndex4(){
            GridBagConstraints constraints = new GridBagConstraints();
            constraints.fill = GridBagConstraints.HORIZONTAL;
            constraints.weightx = 100.0;
            constraints.weighty = 100.0;

            constraints.insets.bottom =5;
            constraints.insets.left = 5;
            constraints.insets.right =5;
            constraints.insets.top = 5;

            constraints.ipadx = 0;

            constraints.gridx = 1;
            constraints.gridy =4;
            constraints.gridheight=1;
            constraints.gridwidth =1;
            return constraints;
        }
        static GridBagConstraints getConstraintsForButtonFindJButtonForFindIndex4(){
            GridBagConstraints constraints = new GridBagConstraints();
            constraints.fill = GridBagConstraints.NONE;
            constraints.weightx = 100.0;
            constraints.weighty = 100.0;

            constraints.insets.bottom =5;
            constraints.insets.left = 5;
            constraints.insets.right =5;
            constraints.insets.top = 20;

            constraints.ipadx = 0;

            constraints.gridx = 1;
            constraints.gridy =5;
            constraints.gridheight=1;
            constraints.gridwidth =1;
            return constraints;
        }


    }
}
