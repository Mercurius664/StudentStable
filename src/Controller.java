import org.xml.sax.SAXException;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.xml.parsers.ParserConfigurationException;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class Controller {
    private static int numberOfRowsOnPage;
    private static int numberOfRowsOnPageForFind;


    public static int getNumberOfRowsOnPage() {
        return numberOfRowsOnPage;
    }

    public static void main(String[] args) {
        View.drawUI();
        View.getButtonAdd().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                AddDialog addDialogFrame = new AddDialog();

              /*  Model.getStudentArrayList().add(addDialogFrame.getStudent());*/
                View.updateJLabelNumbersOfRecords();

                View.updateJLabelTotalPages();
                if (View.getDefaultTableModel().getRowCount() >= numberOfRowsOnPage) {
                    return;
                }


                View.jTableUpdate(View.getDefaultTableModel(), View.getJTable(), View.getJPanel(), Model.getStudentArrayList());
                View.updateJLabelNumberOfRecordsOnPage();


            }

        });

        View.getButtonNext().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (numberOfRowsOnPage == 0) {
                    return;
                }
                if (View.getCurrentPageNumber() * numberOfRowsOnPage >= Model.getStudentArrayList().size()) {
                    return;
                }
                View.setCurrentPageNumber(View.getCurrentPageNumber() + 1);
                View.updateCurrentPageNumber();
                Controller.numberOfRowsOnPageLogic(View.getDefaultTableModel(), Model.getStudentArrayList(), numberOfRowsOnPage, View.getCurrentPageNumber());
                View.updateJLabelNumbersOfRecords();
                View.updateJLabelTotalPages();
                View.updateJLabelNumberOfRecordsOnPage();
            }
        });
        View.getButtonPrevious().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (numberOfRowsOnPage == 0) {
                    return;
                }
                if (View.getCurrentPageNumber() <= 1) {
                    return;
                }
                View.setCurrentPageNumber(View.getCurrentPageNumber() - 1);
                View.updateCurrentPageNumber();
                Controller.numberOfRowsOnPageLogic(View.getDefaultTableModel(), Model.getStudentArrayList(), numberOfRowsOnPage, View.getCurrentPageNumber());
                View.updateJLabelNumbersOfRecords();
                View.updateJLabelTotalPages();
                View.updateJLabelNumberOfRecordsOnPage();
            }
        });
        View.getButtonFirstPage().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (numberOfRowsOnPage == 0) {
                    return;
                }
                View.setCurrentPageNumber(1);
                View.updateCurrentPageNumber();
                Controller.numberOfRowsOnPageLogic(View.getDefaultTableModel(), Model.getStudentArrayList(), numberOfRowsOnPage, View.getCurrentPageNumber());
                View.updateJLabelNumbersOfRecords();
                View.updateJLabelTotalPages();
                View.updateJLabelNumberOfRecordsOnPage();
            }
        });
        View.getButtonDelete().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                View.drawDeleteFrame();
            }
        });
        View.getButtonLastPage().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (numberOfRowsOnPage == 0) {
                    return;
                }
                if (Model.getStudentArrayList().size() == 0) {
                    return;
                }
                View.setCurrentPageNumber(View.getTotalPages());
                View.updateCurrentPageNumber();

                View.updateJLabelNumbersOfRecords();
                View.updateJLabelTotalPages();
                View.updateJLabelNumberOfRecordsOnPage();
                Controller.numberOfRowsOnPageLogic(View.getDefaultTableModel(), Model.getStudentArrayList(), numberOfRowsOnPage, View.getCurrentPageNumber());

            }
        });
        View.getButtonFind().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                View.drawFrameForFind();

            }
        });
        View.getJComboBoxMainFrame().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                numberOfRowsOnPage = View.getJComboBoxMainFrame().getSelectedIndex();
                View.setCurrentPageNumber(1);
                Controller.numberOfRowsOnPageLogic(View.getDefaultTableModel(), Model.getStudentArrayList(), numberOfRowsOnPage, View.getCurrentPageNumber());
                View.updateCurrentPageNumber();
                View.updateJLabelTotalPages();
                View.updateJLabelNumberOfRecordsOnPage();
            }
        });

        View.getSaveMenu().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFileChooser fileChooser = new JFileChooser();
                fileChooser.showSaveDialog(View.getJFrameMain());
                File file = fileChooser.getSelectedFile();
                DOMxmlWriter.write(file);

            }
        });
        View.getLoadMenu().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFileChooser fileChooser = new JFileChooser();
                fileChooser.showOpenDialog(View.getJFrameMain());
                File file = fileChooser.getSelectedFile();
                try {
                    SAXExample.read(file);
                } catch (ParserConfigurationException parserConfigurationException) {
                    parserConfigurationException.printStackTrace();
                } catch (SAXException saxException) {
                    saxException.printStackTrace();
                } catch (IOException ioException) {
                    ioException.printStackTrace();
                }
                View.setCurrentPageNumber(1);
                View.updateCurrentPageNumber();
                Controller.numberOfRowsOnPageLogic(View.getDefaultTableModel(), Model.getStudentArrayList(), numberOfRowsOnPage, View.getCurrentPageNumber());
                View.updateJLabelNumbersOfRecords();
                View.updateJLabelTotalPages();
                View.updateJLabelNumberOfRecordsOnPage();
            }
        });


    }

    public static void closeFindFrame() {
        View.getjFrameForFind().addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                View.disableAllFindFrames();
            }
        });
    }

    public static void componentAddListenerForFindIndex1() {
        View.getJButtonForFindIndex1().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                View.setCurrentPageNumberForFind(1);
                View.removeAllJTableElements(View.getDefaultTableModelForButtonFind());
                int studentArrayListForFindSize = Model.getStudentArrayListForFind().size();
                for (int i = 0; i < studentArrayListForFindSize; i++) {
                    Model.getStudentArrayListForFind().remove(0);
                }

                String jTextFiendContent = View.getJTextFieldForFindIndex1().getText();
                for (int i = 0; i < Model.getStudentArrayList().size(); i++) {
                    if (Model.getStudentArrayList().get(i).getStudentName().contains(jTextFiendContent)) {
                        Model.getStudentArrayListForFind().add(Model.getStudentArrayList().get(i));
                        findFrameInformationUpdate();
                        if (numberOfRowsOnPageForFind <= i) {
                            continue;
                        }
                        View.jTableUpdate(View.getDefaultTableModelForButtonFind(), View.getJTableForButtonFind(), View.getJPanelForFind(), Model.getStudentArrayListForFind());
                    }
                }

                findFrameInformationUpdate();
            }
        });
    }

    public static void componentAddListenerForFindIndex2() {
        View.getJRadioButtonFatherEnable().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {


                jRadioButtonCheck(View.getJRadioButtonFatherEnable(), View.getJRadioButtonMotherEnable(), View.getJTextFieldFatherForFindIndex2(), View.getJTextFieldMotherForFindIndex2());

            }
        });
        View.getJRadioButtonMotherEnable().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                jRadioButtonCheck(View.getJRadioButtonFatherEnable(), View.getJRadioButtonMotherEnable(), View.getJTextFieldFatherForFindIndex2(), View.getJTextFieldMotherForFindIndex2());
            }
        });
        View.getJButtonForFindIndex2().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                View.setCurrentPageNumberForFind(1);
                View.removeAllJTableElements(View.getDefaultTableModelForButtonFind());
                int studentArrayListForFindSize = Model.getStudentArrayListForFind().size();
                for (int i = 0; i < studentArrayListForFindSize; i++) {
                    Model.getStudentArrayListForFind().remove(0);
                }


                if (!View.getJRadioButtonMotherEnable().isSelected() && !View.getJRadioButtonFatherEnable().isSelected()) {
                    return;
                } else if (View.getJRadioButtonMotherEnable().isSelected() && View.getJRadioButtonFatherEnable().isSelected()) {
                    String jTextFiendContent1 = View.getJTextFieldMotherForFindIndex2().getText();
                    String jTextFiendContent2 = View.getJTextFieldFatherForFindIndex2().getText();
                    if (jTextFiendContent1.equals("") || jTextFiendContent2.equals("")) {
                        return;
                    }
                    for (int i = 0; i < Model.getStudentArrayList().size(); i++) {

                        if (Model.getStudentArrayList().get(i).getMotherName().contains(jTextFiendContent1) && Model.getStudentArrayList().get(i).getFatherName().contains(jTextFiendContent2)) {
                            Model.getStudentArrayListForFind().add(Model.getStudentArrayList().get(i));
                            findFrameInformationUpdate();
                            if (numberOfRowsOnPageForFind <= i) {
                                continue;
                            }
                            View.jTableUpdate(View.getDefaultTableModelForButtonFind(), View.getJTableForButtonFind(), View.getJPanelForFind(), Model.getStudentArrayListForFind());
                        }
                    }
                } else if (View.getJRadioButtonMotherEnable().isSelected()) {
                    String jTextFiendContent = View.getJTextFieldMotherForFindIndex2().getText();
                    for (int i = 0; i < Model.getStudentArrayList().size(); i++) {
                        if (Model.getStudentArrayList().get(i).getMotherName().contains(jTextFiendContent)) {
                            Model.getStudentArrayListForFind().add(Model.getStudentArrayList().get(i));
                            findFrameInformationUpdate();
                            if (numberOfRowsOnPageForFind <= i) {
                                continue;
                            }
                            View.jTableUpdate(View.getDefaultTableModelForButtonFind(), View.getJTableForButtonFind(), View.getJPanelForFind(), Model.getStudentArrayListForFind());
                        }
                    }
                } else if (View.getJRadioButtonFatherEnable().isSelected()) {
                    String jTextFiendContent = View.getJTextFieldFatherForFindIndex2().getText();
                    for (int i = 0; i < Model.getStudentArrayList().size(); i++) {
                        if (Model.getStudentArrayList().get(i).getFatherName().contains(jTextFiendContent)) {
                            Model.getStudentArrayListForFind().add(Model.getStudentArrayList().get(i));
                            findFrameInformationUpdate();
                            if (numberOfRowsOnPageForFind <= i) {
                                continue;
                            }
                            View.jTableUpdate(View.getDefaultTableModelForButtonFind(), View.getJTableForButtonFind(), View.getJPanelForFind(), Model.getStudentArrayListForFind());
                        }
                    }
                }
                findFrameInformationUpdate();
            }
        });
    }

    public static void componentAddListenerForFindIndex3() {
        View.getJRadioButtonSisterEnable().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                jRadioButtonCheck(View.getJRadioButtonSisterEnable(), View.getJRadioButtonBrotherEnable(), View.getJTextFieldFSisterForFindIndex3(), View.getJTextFieldBrotherForFindIndex3());
            }
        });
        View.getJRadioButtonBrotherEnable().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                jRadioButtonCheck(View.getJRadioButtonSisterEnable(), View.getJRadioButtonBrotherEnable(), View.getJTextFieldFSisterForFindIndex3(), View.getJTextFieldBrotherForFindIndex3());
            }
        });

        View.getJButtonForFindIndex3().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                View.setCurrentPageNumberForFind(1);
                View.removeAllJTableElements(View.getDefaultTableModelForButtonFind());
                int studentArrayListForFindSize = Model.getStudentArrayListForFind().size();
                for (int i = 0; i < studentArrayListForFindSize; i++) {
                    Model.getStudentArrayListForFind().remove(0);
                }


                if (!View.getJRadioButtonBrotherEnable().isSelected() && !View.getJRadioButtonSisterEnable().isSelected()) {
                    return;
                } else if (View.getJRadioButtonBrotherEnable().isSelected() && View.getJRadioButtonSisterEnable().isSelected()) {
                    int numberOfBrothers = 0;
                    try {
                        numberOfBrothers = Integer.parseInt(View.getJTextFieldBrotherForFindIndex3().getText());
                    } catch (Exception exception) {
                        JOptionPane.showMessageDialog(null, "Ошибка ввода поля кол-во братьев");
                        return;
                    }
                    int numberOfSisters = 0;
                    try {
                        numberOfSisters = Integer.parseInt(View.getJTextFieldFSisterForFindIndex3().getText());
                    } catch (Exception exception) {
                        JOptionPane.showMessageDialog(null, "Ошибка ввода поля кол-во сестёр");
                        return;
                    }

                    for (int i = 0; i < Model.getStudentArrayList().size(); i++) {
                        if (Model.getStudentArrayList().get(i).getNumberOfBrothers() == numberOfBrothers &&
                                Model.getStudentArrayList().get(i).getNumberOfSisters() == numberOfSisters) {
                            Model.getStudentArrayListForFind().add(Model.getStudentArrayList().get(i));
                            findFrameInformationUpdate();
                            if (numberOfRowsOnPageForFind <= i) {
                                continue;
                            }
                            View.jTableUpdate(View.getDefaultTableModelForButtonFind(), View.getJTableForButtonFind(), View.getJPanelForFind(), Model.getStudentArrayListForFind());
                        }

                    }
                } else if (View.getJRadioButtonBrotherEnable().isSelected()) {
                    int numberOfBrothers = 0;
                    try {
                        numberOfBrothers = Integer.parseInt(View.getJTextFieldBrotherForFindIndex3().getText());
                    } catch (Exception exception) {
                        JOptionPane.showMessageDialog(null, "Ошибка ввода поля кол-во братьев");
                        return;
                    }
                    for (int i = 0; i < Model.getStudentArrayList().size(); i++) {
                        if (Model.getStudentArrayList().get(i).getNumberOfBrothers() == numberOfBrothers) {
                            Model.getStudentArrayListForFind().add(Model.getStudentArrayList().get(i));
                            findFrameInformationUpdate();
                            if (numberOfRowsOnPageForFind <= i) {
                                continue;
                            }
                            View.jTableUpdate(View.getDefaultTableModelForButtonFind(), View.getJTableForButtonFind(), View.getJPanelForFind(), Model.getStudentArrayListForFind());
                        }

                    }
                } else if (View.getJRadioButtonSisterEnable().isSelected()) {
                    int numberOfSisters = 0;
                    try {
                        numberOfSisters = Integer.parseInt(View.getJTextFieldFSisterForFindIndex3().getText());
                    } catch (Exception exception) {
                        JOptionPane.showMessageDialog(null, "Ошибка ввода поля кол-во сестёр");
                        return;
                    }
                    for (int i = 0; i < Model.getStudentArrayList().size(); i++) {
                        if (Model.getStudentArrayList().get(i).getNumberOfSisters() == numberOfSisters) {
                            Model.getStudentArrayListForFind().add(Model.getStudentArrayList().get(i));
                            findFrameInformationUpdate();
                            if (numberOfRowsOnPageForFind <= i) {
                                continue;
                            }
                            View.jTableUpdate(View.getDefaultTableModelForButtonFind(), View.getJTableForButtonFind(), View.getJPanelForFind(), Model.getStudentArrayListForFind());
                        }

                    }
                }
                findFrameInformationUpdate();
            }
        });

    }

    public static void componentAddListenerForFindIndex4() {
        View.getJRadioButtonFatherMoneyEnable().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                jRadioButtonCheck(View.getJRadioButtonFatherMoneyEnable(), View.getJRadioButtonMotherMoneyEnable(),
                        View.getJTextFieldFatherMinForFindIndex4(), View.getJTextFieldFatherMaxForFindIndex4(),
                        View.getJTextFieldMotherMinForFindIndex4(), View.getJTextFieldMotherMaxForFindIndex4());

            }
        });
        View.getJRadioButtonMotherMoneyEnable().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                jRadioButtonCheck(View.getJRadioButtonFatherMoneyEnable(), View.getJRadioButtonMotherMoneyEnable(),
                        View.getJTextFieldFatherMinForFindIndex4(), View.getJTextFieldFatherMaxForFindIndex4(),
                        View.getJTextFieldMotherMinForFindIndex4(), View.getJTextFieldMotherMaxForFindIndex4());
            }
        });

        View.getJButtonForFindIndex4().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                View.removeAllJTableElements(View.getDefaultTableModelForButtonFind());
                View.setCurrentPageNumberForFind(1);
                int studentArrayListForFindSize = Model.getStudentArrayListForFind().size();
                for (int i = 0; i < studentArrayListForFindSize; i++) {
                    Model.getStudentArrayListForFind().remove(0);
                }

                if (!View.getJRadioButtonFatherMoneyEnable().isSelected() && !View.getJRadioButtonMotherMoneyEnable().isSelected()) {
                    return;
                } else if (View.getJRadioButtonFatherMoneyEnable().isSelected() && View.getJRadioButtonMotherMoneyEnable().isSelected()) {
                    ArrayList<Student> fatherArrayList = new ArrayList<>();
                    ArrayList<Student> motherArrayList = new ArrayList<>();
                    String errorsFather = "";
                    boolean hasFatherErrorsMax = false;
                    boolean hasFatherErrorsMin = false;
                    int fatherMax = 0;
                    int fatherMin = 0;
                    try {
                        fatherMax = Integer.parseInt(View.getJTextFieldFatherMaxForFindIndex4().getText());
                    } catch (Exception exception) {
                        hasFatherErrorsMax = true;
                        errorsFather += "Неправильно введено поле: Введите зарплату отца до \n";
                    }
                    try {
                        fatherMin = Integer.parseInt(View.getJTextFieldFatherMinForFindIndex4().getText());
                    } catch (Exception exception) {
                        hasFatherErrorsMin = true;
                        errorsFather += "Неправильно введено поле: Введите зарплату отца от";
                    }
                    if (hasFatherErrorsMin && hasFatherErrorsMax) {
                        JOptionPane.showMessageDialog(null, errorsFather);
                        return;
                    }

                    String errorsMother = "";
                    boolean hasMotherErrorsMax = false;
                    boolean hasMotherErrorsMin = false;
                    int motherMax = 0;
                    int motherMin = 0;
                    try {
                        motherMax = Integer.parseInt(View.getJTextFieldMotherMaxForFindIndex4().getText());
                    } catch (Exception exception) {
                        hasMotherErrorsMax = true;
                        errorsMother += "Неправильно введено поле: Введите зарплату матери до \n";
                    }
                    try {
                        motherMin = Integer.parseInt(View.getJTextFieldMotherMinForFindIndex4().getText());
                    } catch (Exception exception) {
                        hasMotherErrorsMin = true;
                        errorsMother += "Неправильно введено поле: Введите зарплату матери от";
                    }
                    if (hasMotherErrorsMin && hasMotherErrorsMax) {
                        JOptionPane.showMessageDialog(null, errorsMother);
                        return;
                    }

                    if (!(hasFatherErrorsMin || hasFatherErrorsMax)) {
                        for (int i = 0; i < Model.getStudentArrayList().size(); i++) {
                            if (Model.getStudentArrayList().get(i).getFatherEarnings() >= fatherMin && Model.getStudentArrayList().get(i).getFatherEarnings() <= fatherMax) {
                                fatherArrayList.add(Model.getStudentArrayList().get(i));
                            }
                        }
                    } else if (!hasFatherErrorsMin) {
                        for (int i = 0; i < Model.getStudentArrayList().size(); i++) {
                            if (Model.getStudentArrayList().get(i).getFatherEarnings() >= fatherMin) {
                                fatherArrayList.add(Model.getStudentArrayList().get(i));
                            }
                        }
                    } else {
                        for (int i = 0; i < Model.getStudentArrayList().size(); i++) {
                            if (Model.getStudentArrayList().get(i).getFatherEarnings() <= fatherMax) {
                                fatherArrayList.add(Model.getStudentArrayList().get(i));
                            }
                        }
                    }

                    if (!(hasMotherErrorsMin || hasMotherErrorsMax)) {
                        for (int i = 0; i < Model.getStudentArrayList().size(); i++) {
                            if (Model.getStudentArrayList().get(i).getMotherEarnings() >= motherMin && Model.getStudentArrayList().get(i).getMotherEarnings() <= motherMax) {
                                motherArrayList.add(Model.getStudentArrayList().get(i));
                            }
                        }
                    } else if (!hasMotherErrorsMin) {
                        for (int i = 0; i < Model.getStudentArrayList().size(); i++) {
                            if (Model.getStudentArrayList().get(i).getMotherEarnings() >= motherMin) {
                                motherArrayList.add(Model.getStudentArrayList().get(i));
                            }
                        }
                    } else {
                        for (int i = 0; i < Model.getStudentArrayList().size(); i++) {
                            if (Model.getStudentArrayList().get(i).getMotherEarnings() <= motherMax) {
                                motherArrayList.add(Model.getStudentArrayList().get(i));
                            }
                        }
                    }


                    ArrayList<Integer> motherCheck = new ArrayList<>();
                    ArrayList<Integer> fatherCheck = new ArrayList<>();


                    for (int i = 0; i < fatherArrayList.size(); i++) {
                        for (int j = 0; j < motherArrayList.size(); j++) {
                            if (fatherArrayList.get(i).equals(motherArrayList.get(j))) {
                                if (motherCheck.contains(j) || fatherCheck.contains(i)) {
                                    continue;
                                }
                                motherCheck.add(j);
                                fatherCheck.add(i);
                                Model.getStudentArrayListForFind().add(fatherArrayList.get(i));
                                findFrameInformationUpdate();
                                if (numberOfRowsOnPageForFind < Model.getStudentArrayListForFind().size()) {
                                    continue;
                                }
                                View.jTableUpdate(View.getDefaultTableModelForButtonFind(), View.getJTableForButtonFind(), View.getJPanelForFind(), Model.getStudentArrayListForFind());
                            }
                        }
                    }


                } else if (View.getJRadioButtonFatherMoneyEnable().isSelected()) {
                    String errors = "";
                    boolean hasErrorsMax = false;
                    boolean hasErrorsMin = false;
                    int fatherMax = 0;
                    int fatherMin = 0;
                    try {
                        fatherMax = Integer.parseInt(View.getJTextFieldFatherMaxForFindIndex4().getText());
                    } catch (Exception exception) {
                        hasErrorsMax = true;
                        errors += "Неправильно введено поле: Введите зарплату отца до \n";
                    }
                    try {
                        fatherMin = Integer.parseInt(View.getJTextFieldFatherMinForFindIndex4().getText());
                    } catch (Exception exception) {
                        hasErrorsMin = true;
                        errors += "Неправильно введено поле: Введите зарплату отца от";
                    }
                    if (hasErrorsMin && hasErrorsMax) {
                        JOptionPane.showMessageDialog(null, errors);
                        return;
                    }

                    if (!(hasErrorsMin || hasErrorsMax)) {
                        for (int i = 0; i < Model.getStudentArrayList().size(); i++) {
                            if (Model.getStudentArrayList().get(i).getFatherEarnings() >= fatherMin && Model.getStudentArrayList().get(i).getFatherEarnings() <= fatherMax) {
                                Model.getStudentArrayListForFind().add(Model.getStudentArrayList().get(i));
                                findFrameInformationUpdate();
                                if (numberOfRowsOnPageForFind <= i) {
                                    continue;
                                }
                                View.jTableUpdate(View.getDefaultTableModelForButtonFind(), View.getJTableForButtonFind(), View.getJPanelForFind(), Model.getStudentArrayListForFind());
                            }
                        }
                    } else if (!hasErrorsMin) {
                        for (int i = 0; i < Model.getStudentArrayList().size(); i++) {
                            if (Model.getStudentArrayList().get(i).getFatherEarnings() >= fatherMin) {
                                Model.getStudentArrayListForFind().add(Model.getStudentArrayList().get(i));
                                findFrameInformationUpdate();
                                if (numberOfRowsOnPageForFind <= i) {
                                    continue;
                                }
                                View.jTableUpdate(View.getDefaultTableModelForButtonFind(), View.getJTableForButtonFind(), View.getJPanelForFind(), Model.getStudentArrayListForFind());
                            }
                        }
                    } else {
                        for (int i = 0; i < Model.getStudentArrayList().size(); i++) {
                            if (Model.getStudentArrayList().get(i).getFatherEarnings() <= fatherMax) {
                                Model.getStudentArrayListForFind().add(Model.getStudentArrayList().get(i));
                                findFrameInformationUpdate();
                                if (numberOfRowsOnPageForFind <= i) {
                                    continue;
                                }
                                View.jTableUpdate(View.getDefaultTableModelForButtonFind(), View.getJTableForButtonFind(), View.getJPanelForFind(), Model.getStudentArrayListForFind());
                            }
                        }
                    }


                } else if (View.getJRadioButtonMotherMoneyEnable().isSelected()) {
                    String errors = "";
                    boolean hasErrorsMax = false;
                    boolean hasErrorsMin = false;
                    int motherMax = 0;
                    int motherMin = 0;
                    try {
                        motherMax = Integer.parseInt(View.getJTextFieldMotherMaxForFindIndex4().getText());
                    } catch (Exception exception) {
                        hasErrorsMax = true;
                        errors += "Неправильно введено поле: Введите зарплату матери до \n";
                    }
                    try {
                        motherMin = Integer.parseInt(View.getJTextFieldMotherMinForFindIndex4().getText());
                    } catch (Exception exception) {
                        hasErrorsMin = true;
                        errors += "Неправильно введено поле: Введите зарплату матери от";
                    }
                    if (hasErrorsMin && hasErrorsMax) {
                        JOptionPane.showMessageDialog(null, errors);
                        return;
                    }

                    if (!(hasErrorsMin || hasErrorsMax)) {
                        for (int i = 0; i < Model.getStudentArrayList().size(); i++) {
                            if (Model.getStudentArrayList().get(i).getMotherEarnings() >= motherMin && Model.getStudentArrayList().get(i).getMotherEarnings() <= motherMax) {
                                Model.getStudentArrayListForFind().add(Model.getStudentArrayList().get(i));
                                findFrameInformationUpdate();
                                if (numberOfRowsOnPageForFind <= i) {
                                    continue;
                                }
                                View.jTableUpdate(View.getDefaultTableModelForButtonFind(), View.getJTableForButtonFind(), View.getJPanelForFind(), Model.getStudentArrayListForFind());
                            }
                        }
                    } else if (!hasErrorsMin) {
                        for (int i = 0; i < Model.getStudentArrayList().size(); i++) {
                            if (Model.getStudentArrayList().get(i).getMotherEarnings() >= motherMin) {
                                Model.getStudentArrayListForFind().add(Model.getStudentArrayList().get(i));
                                findFrameInformationUpdate();
                                if (numberOfRowsOnPageForFind <= i) {
                                    continue;
                                }
                                View.jTableUpdate(View.getDefaultTableModelForButtonFind(), View.getJTableForButtonFind(), View.getJPanelForFind(), Model.getStudentArrayListForFind());
                            }
                        }
                    } else {
                        for (int i = 0; i < Model.getStudentArrayList().size(); i++) {
                            if (Model.getStudentArrayList().get(i).getMotherEarnings() <= motherMax) {
                                Model.getStudentArrayListForFind().add(Model.getStudentArrayList().get(i));
                                findFrameInformationUpdate();
                                if (numberOfRowsOnPageForFind <= i) {
                                    continue;
                                }
                                View.jTableUpdate(View.getDefaultTableModelForButtonFind(), View.getJTableForButtonFind(), View.getJPanelForFind(), Model.getStudentArrayListForFind());
                            }
                        }
                    }


                }
                findFrameInformationUpdate();
            }
        });
    }


    public static void componentAddListenerForDeleteMainFrame() {
        View.getJComboBoxForDelete().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                View.disableAllDeleteFrames();
                int selectedIndex = View.getJComboBoxForDelete().getSelectedIndex();

                if (selectedIndex == 1) {
                    View.drawDeleteFrameForIndex1();
                } else if (selectedIndex == 2) {
                    View.drawDeleteFrameForIndex2();
                } else if (selectedIndex == 3) {
                    View.drawDeleteFrameForIndex3();
                } else if (selectedIndex == 4) {
                    View.drawDeleteFrameForIndex4();
                }

            }
        });
    }

    public static void componentAddListenerForDeleteIndex1() {
        View.getJButtonForDeleteIndex1().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ArrayList<Student> arrayListDelete = new ArrayList<>();
                String jTextFiendContent = View.getjTextFieldForDeleteIndex1().getText();
                if (jTextFiendContent.equals("")) {
                    return;
                }
                for (int i = 0; i < Model.getStudentArrayList().size(); i++) {
                    if (Model.getStudentArrayList().get(i).getStudentName().contains(jTextFiendContent)) {
                        arrayListDelete.add(Model.getStudentArrayList().get(i));
                    }
                }
                for (int i = 0; i < arrayListDelete.size(); i++) {
                    Model.getStudentArrayList().remove(arrayListDelete.get(i));
                }
                JOptionPane.showMessageDialog(null, "Удалено " + arrayListDelete.size() + " записей");
                View.setCurrentPageNumber(1);
                View.updateCurrentPageNumber();
                Controller.numberOfRowsOnPageLogic(View.getDefaultTableModel(), Model.getStudentArrayList(), numberOfRowsOnPage, View.getCurrentPageNumber());
                View.updateJLabelNumbersOfRecords();
                View.updateJLabelTotalPages();
                View.updateJLabelNumberOfRecordsOnPage();
            }
        });
    }

    public static void componentAddListenerForDeleteIndex2() {
        View.getJRadioButtonFatherDeleteEnable().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                jRadioButtonCheck(View.getJRadioButtonFatherDeleteEnable(), View.getJRadioButtonMotherDeleteEnable(),
                        View.getJTextFieldFatherForDeleteIndex2(), View.getJTextFieldMotherForDeleteIndex2());
            }
        });
        View.getJRadioButtonMotherDeleteEnable().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                jRadioButtonCheck(View.getJRadioButtonFatherDeleteEnable(), View.getJRadioButtonMotherDeleteEnable(),
                        View.getJTextFieldFatherForDeleteIndex2(), View.getJTextFieldMotherForDeleteIndex2());
            }
        });

        View.getJButtonForDeleteIndex2().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                if (!View.getJRadioButtonMotherDeleteEnable().isSelected() && !View.getJRadioButtonFatherDeleteEnable().isSelected()) {
                    return;
                } else if (View.getJRadioButtonMotherDeleteEnable().isSelected() && View.getJRadioButtonFatherDeleteEnable().isSelected()) {
                    ArrayList<Student> arrayListDelete = new ArrayList<>();
                    String jTextFiendContent1 = View.getJTextFieldMotherForDeleteIndex2().getText();
                    String jTextFiendContent2 = View.getJTextFieldFatherForDeleteIndex2().getText();
                    if (jTextFiendContent1.equals("") || jTextFiendContent2.equals("")) {
                        return;
                    }
                    for (int i = 0; i < Model.getStudentArrayList().size(); i++) {

                        if (Model.getStudentArrayList().get(i).getMotherName().contains(jTextFiendContent1) && Model.getStudentArrayList().get(i).getFatherName().contains(jTextFiendContent2)) {
                            arrayListDelete.add(Model.getStudentArrayList().get(i));
                        }
                    }
                    for (int i = 0; i < arrayListDelete.size(); i++) {
                        Model.getStudentArrayList().remove(arrayListDelete.get(i));
                    }
                    JOptionPane.showMessageDialog(null, "Удалено " + arrayListDelete.size() + " записей");
                    View.setCurrentPageNumber(1);
                    View.updateCurrentPageNumber();
                    Controller.numberOfRowsOnPageLogic(View.getDefaultTableModel(), Model.getStudentArrayList(), numberOfRowsOnPage, View.getCurrentPageNumber());
                    View.updateJLabelNumbersOfRecords();
                    View.updateJLabelTotalPages();
                    View.updateJLabelNumberOfRecordsOnPage();
                } else if (View.getJRadioButtonMotherDeleteEnable().isSelected()) {
                    ArrayList<Student> arrayListDelete = new ArrayList<>();
                    String jTextFiendContent = View.getJTextFieldMotherForDeleteIndex2().getText();
                    for (int i = 0; i < Model.getStudentArrayList().size(); i++) {
                        if (Model.getStudentArrayList().get(i).getMotherName().contains(jTextFiendContent)) {
                            arrayListDelete.add(Model.getStudentArrayList().get(i));

                        }
                    }
                    for (int i = 0; i < arrayListDelete.size(); i++) {
                        Model.getStudentArrayList().remove(arrayListDelete.get(i));
                    }
                    JOptionPane.showMessageDialog(null, "Удалено " + arrayListDelete.size() + " записей");
                    View.setCurrentPageNumber(1);
                    View.updateCurrentPageNumber();
                    Controller.numberOfRowsOnPageLogic(View.getDefaultTableModel(), Model.getStudentArrayList(), numberOfRowsOnPage, View.getCurrentPageNumber());
                    View.updateJLabelNumbersOfRecords();
                    View.updateJLabelTotalPages();
                    View.updateJLabelNumberOfRecordsOnPage();
                } else if (View.getJRadioButtonFatherDeleteEnable().isSelected()) {
                    ArrayList<Student> arrayListDelete = new ArrayList<>();
                    String jTextFiendContent = View.getJTextFieldFatherForDeleteIndex2().getText();
                    for (int i = 0; i < Model.getStudentArrayList().size(); i++) {
                        if (Model.getStudentArrayList().get(i).getFatherName().contains(jTextFiendContent)) {
                            arrayListDelete.add(Model.getStudentArrayList().get(i));

                        }
                    }
                    for (int i = 0; i < arrayListDelete.size(); i++) {
                        Model.getStudentArrayList().remove(arrayListDelete.get(i));
                    }
                    JOptionPane.showMessageDialog(null, "Удалено " + arrayListDelete.size() + " записей");
                    View.setCurrentPageNumber(1);
                    View.updateCurrentPageNumber();
                    Controller.numberOfRowsOnPageLogic(View.getDefaultTableModel(), Model.getStudentArrayList(), numberOfRowsOnPage, View.getCurrentPageNumber());
                    View.updateJLabelNumbersOfRecords();
                    View.updateJLabelTotalPages();
                    View.updateJLabelNumberOfRecordsOnPage();
                }

            }
        });
    }

    public static void componentAddListenerForDeleteIndex3() {
        View.getJRadioButtonBrotherDeleteEnable().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                jRadioButtonCheck(View.getJRadioButtonSisterDeleteEnable(), View.getJRadioButtonBrotherDeleteEnable(), View.getJTextFieldFSisterForDeleteIndex3(), View.getJTextFieldBrotherForDeleteIndex3());
            }
        });
        View.getJRadioButtonSisterDeleteEnable().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                jRadioButtonCheck(View.getJRadioButtonSisterDeleteEnable(), View.getJRadioButtonBrotherDeleteEnable(), View.getJTextFieldFSisterForDeleteIndex3(), View.getJTextFieldBrotherForDeleteIndex3());
            }
        });

        View.getjButtonForDeleteIndex3().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                if (!View.getJRadioButtonBrotherDeleteEnable().isSelected() && !View.getJRadioButtonSisterDeleteEnable().isSelected()) {
                    return;
                } else if (View.getJRadioButtonBrotherDeleteEnable().isSelected() && View.getJRadioButtonSisterDeleteEnable().isSelected()) {
                    int numberOfBrothers = 0;
                    try {
                        numberOfBrothers = Integer.parseInt(View.getJTextFieldBrotherForDeleteIndex3().getText());
                    } catch (Exception exception) {
                        JOptionPane.showMessageDialog(null, "Ошибка ввода поля кол-во братьев");
                        return;
                    }
                    int numberOfSisters = 0;
                    try {
                        numberOfSisters = Integer.parseInt(View.getJTextFieldFSisterForDeleteIndex3().getText());
                    } catch (Exception exception) {
                        JOptionPane.showMessageDialog(null, "Ошибка ввода поля кол-во сестёр");
                        return;
                    }
                    ArrayList<Student> arrayListDelete = new ArrayList<>();
                    for (int i = 0; i < Model.getStudentArrayList().size(); i++) {
                        if (Model.getStudentArrayList().get(i).getNumberOfBrothers() == numberOfBrothers &&
                                Model.getStudentArrayList().get(i).getNumberOfSisters() == numberOfSisters) {
                            arrayListDelete.add(Model.getStudentArrayList().get(i));

                        }

                    }
                    for (int i = 0; i < arrayListDelete.size(); i++) {
                        Model.getStudentArrayList().remove(arrayListDelete.get(i));
                    }
                    JOptionPane.showMessageDialog(null, "Удалено " + arrayListDelete.size() + " записей");
                    View.setCurrentPageNumber(1);
                    View.updateCurrentPageNumber();
                    Controller.numberOfRowsOnPageLogic(View.getDefaultTableModel(), Model.getStudentArrayList(), numberOfRowsOnPage, View.getCurrentPageNumber());
                    View.updateJLabelNumbersOfRecords();
                    View.updateJLabelTotalPages();
                    View.updateJLabelNumberOfRecordsOnPage();

                } else if (View.getJRadioButtonBrotherDeleteEnable().isSelected()) {
                    int numberOfBrothers = 0;
                    try {
                        numberOfBrothers = Integer.parseInt(View.getJTextFieldBrotherForDeleteIndex3().getText());
                    } catch (Exception exception) {
                        JOptionPane.showMessageDialog(null, "Ошибка ввода поля кол-во братьев");
                        return;
                    }
                    ArrayList<Student> arrayListDelete = new ArrayList<>();
                    for (int i = 0; i < Model.getStudentArrayList().size(); i++) {
                        if (Model.getStudentArrayList().get(i).getNumberOfBrothers() == numberOfBrothers) {
                            arrayListDelete.add(Model.getStudentArrayList().get(i));
                        }

                    }
                    for (int i = 0; i < arrayListDelete.size(); i++) {
                        Model.getStudentArrayList().remove(arrayListDelete.get(i));
                    }
                    JOptionPane.showMessageDialog(null, "Удалено " + arrayListDelete.size() + " записей");
                    View.setCurrentPageNumber(1);
                    View.updateCurrentPageNumber();
                    Controller.numberOfRowsOnPageLogic(View.getDefaultTableModel(), Model.getStudentArrayList(), numberOfRowsOnPage, View.getCurrentPageNumber());
                    View.updateJLabelNumbersOfRecords();
                    View.updateJLabelTotalPages();
                    View.updateJLabelNumberOfRecordsOnPage();

                } else if (View.getJRadioButtonSisterDeleteEnable().isSelected()) {
                    int numberOfSisters = 0;
                    try {
                        numberOfSisters = Integer.parseInt(View.getJTextFieldFSisterForDeleteIndex3().getText());
                    } catch (Exception exception) {
                        JOptionPane.showMessageDialog(null, "Ошибка ввода поля кол-во сестёр");
                        return;
                    }
                    ArrayList<Student> arrayListDelete = new ArrayList<>();
                    for (int i = 0; i < Model.getStudentArrayList().size(); i++) {
                        if (Model.getStudentArrayList().get(i).getNumberOfSisters() == numberOfSisters) {
                            arrayListDelete.add(Model.getStudentArrayList().get(i));

                        }

                    }
                    for (int i = 0; i < arrayListDelete.size(); i++) {
                        Model.getStudentArrayList().remove(arrayListDelete.get(i));
                    }
                    JOptionPane.showMessageDialog(null, "Удалено " + arrayListDelete.size() + " записей");
                    View.setCurrentPageNumber(1);
                    View.updateCurrentPageNumber();
                    Controller.numberOfRowsOnPageLogic(View.getDefaultTableModel(), Model.getStudentArrayList(), numberOfRowsOnPage, View.getCurrentPageNumber());
                    View.updateJLabelNumbersOfRecords();
                    View.updateJLabelTotalPages();
                    View.updateJLabelNumberOfRecordsOnPage();

                }

            }
        });

    }

    public static void componentAddListenerForDeleteIndex4() {
        View.getJRadioButtonFatherMoneyDeleteEnable().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                jRadioButtonCheck(View.getJRadioButtonFatherMoneyDeleteEnable(), View.getJRadioButtonMotherMoneyDeleteEnable(),
                        View.getJTextFieldFatherMinForDeleteIndex4(), View.getJTextFieldFatherMaxForDeleteIndex4(),
                        View.getJTextFieldMotherMinForDeleteIndex4(), View.getJTextFieldMotherMaxForDeleteIndex4());
            }
        });
        View.getJRadioButtonMotherMoneyDeleteEnable().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                jRadioButtonCheck(View.getJRadioButtonFatherMoneyDeleteEnable(), View.getJRadioButtonMotherMoneyDeleteEnable(),
                        View.getJTextFieldFatherMinForDeleteIndex4(), View.getJTextFieldFatherMaxForDeleteIndex4(),
                        View.getJTextFieldMotherMinForDeleteIndex4(), View.getJTextFieldMotherMaxForDeleteIndex4());
            }
        });

        View.getJButtonForDeleteIndex4().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                if (!View.getJRadioButtonFatherMoneyDeleteEnable().isSelected() && !View.getJRadioButtonMotherMoneyDeleteEnable().isSelected()) {
                    return;
                } else if (View.getJRadioButtonFatherMoneyDeleteEnable().isSelected() && View.getJRadioButtonMotherMoneyDeleteEnable().isSelected()) {
                    ArrayList<Student> fatherArrayList = new ArrayList<>();
                    ArrayList<Student> motherArrayList = new ArrayList<>();
                    String errorsFather = "";
                    boolean hasFatherErrorsMax = false;
                    boolean hasFatherErrorsMin = false;
                    int fatherMax = 0;
                    int fatherMin = 0;
                    try {
                        fatherMax = Integer.parseInt(View.getJTextFieldFatherMaxForDeleteIndex4().getText());
                    } catch (Exception exception) {
                        hasFatherErrorsMax = true;
                        errorsFather += "Неправильно введено поле: Введите зарплату отца до \n";
                    }
                    try {
                        fatherMin = Integer.parseInt(View.getJTextFieldFatherMinForDeleteIndex4().getText());
                    } catch (Exception exception) {
                        hasFatherErrorsMin = true;
                        errorsFather += "Неправильно введено поле: Введите зарплату отца от";
                    }
                    if (hasFatherErrorsMin && hasFatherErrorsMax) {
                        JOptionPane.showMessageDialog(null, errorsFather);
                        return;
                    }

                    String errorsMother = "";
                    boolean hasMotherErrorsMax = false;
                    boolean hasMotherErrorsMin = false;
                    int motherMax = 0;
                    int motherMin = 0;
                    try {
                        motherMax = Integer.parseInt(View.getJTextFieldMotherMaxForDeleteIndex4().getText());
                    } catch (Exception exception) {
                        hasMotherErrorsMax = true;
                        errorsMother += "Неправильно введено поле: Введите зарплату матери до \n";
                    }
                    try {
                        motherMin = Integer.parseInt(View.getJTextFieldMotherMinForDeleteIndex4().getText());
                    } catch (Exception exception) {
                        hasMotherErrorsMin = true;
                        errorsMother += "Неправильно введено поле: Введите зарплату матери от";
                    }
                    if (hasMotherErrorsMin && hasMotherErrorsMax) {
                        JOptionPane.showMessageDialog(null, errorsMother);
                        return;
                    }

                    if (!(hasFatherErrorsMin || hasFatherErrorsMax)) {
                        for (int i = 0; i < Model.getStudentArrayList().size(); i++) {
                            if (Model.getStudentArrayList().get(i).getFatherEarnings() >= fatherMin && Model.getStudentArrayList().get(i).getFatherEarnings() <= fatherMax) {
                                fatherArrayList.add(Model.getStudentArrayList().get(i));
                            }
                        }
                    } else if (!hasFatherErrorsMin) {
                        for (int i = 0; i < Model.getStudentArrayList().size(); i++) {
                            if (Model.getStudentArrayList().get(i).getFatherEarnings() >= fatherMin) {
                                fatherArrayList.add(Model.getStudentArrayList().get(i));
                            }
                        }
                    } else {
                        for (int i = 0; i < Model.getStudentArrayList().size(); i++) {
                            if (Model.getStudentArrayList().get(i).getFatherEarnings() <= fatherMax) {
                                fatherArrayList.add(Model.getStudentArrayList().get(i));
                            }
                        }
                    }

                    if (!(hasMotherErrorsMin || hasMotherErrorsMax)) {
                        for (int i = 0; i < Model.getStudentArrayList().size(); i++) {
                            if (Model.getStudentArrayList().get(i).getMotherEarnings() >= motherMin && Model.getStudentArrayList().get(i).getMotherEarnings() <= motherMax) {
                                motherArrayList.add(Model.getStudentArrayList().get(i));
                            }
                        }
                    } else if (!hasMotherErrorsMin) {
                        for (int i = 0; i < Model.getStudentArrayList().size(); i++) {
                            if (Model.getStudentArrayList().get(i).getMotherEarnings() >= motherMin) {
                                motherArrayList.add(Model.getStudentArrayList().get(i));
                            }
                        }
                    } else {
                        for (int i = 0; i < Model.getStudentArrayList().size(); i++) {
                            if (Model.getStudentArrayList().get(i).getMotherEarnings() <= motherMax) {
                                motherArrayList.add(Model.getStudentArrayList().get(i));
                            }
                        }
                    }


                    ArrayList<Integer> motherCheck = new ArrayList<>();
                    ArrayList<Integer> fatherCheck = new ArrayList<>();


                    ArrayList<Student> arrayListDelete = new ArrayList<>();
                    for (int i = 0; i < fatherArrayList.size(); i++) {
                        for (int j = 0; j < motherArrayList.size(); j++) {
                            if (fatherArrayList.get(i).equals(motherArrayList.get(j))) {
                                if (motherCheck.contains(j) || fatherCheck.contains(i)) {
                                    continue;
                                }
                                motherCheck.add(j);
                                fatherCheck.add(i);
                                arrayListDelete.add(fatherArrayList.get(i));


                            }
                        }
                    }
                    for (int i = 0; i < arrayListDelete.size(); i++) {
                        Model.getStudentArrayList().remove(arrayListDelete.get(i));
                    }
                    JOptionPane.showMessageDialog(null, "Удалено " + arrayListDelete.size() + " записей");
                    View.setCurrentPageNumber(1);
                    View.updateCurrentPageNumber();
                    Controller.numberOfRowsOnPageLogic(View.getDefaultTableModel(), Model.getStudentArrayList(), numberOfRowsOnPage, View.getCurrentPageNumber());
                    View.updateJLabelNumbersOfRecords();
                    View.updateJLabelTotalPages();
                    View.updateJLabelNumberOfRecordsOnPage();

                } else if (View.getJRadioButtonFatherMoneyDeleteEnable().isSelected()) {
                    String errors = "";
                    boolean hasErrorsMax = false;
                    boolean hasErrorsMin = false;
                    int fatherMax = 0;
                    int fatherMin = 0;
                    try {
                        fatherMax = Integer.parseInt(View.getJTextFieldFatherMaxForDeleteIndex4().getText());
                    } catch (Exception exception) {
                        hasErrorsMax = true;
                        errors += "Неправильно введено поле: Введите зарплату отца до \n";
                    }
                    try {
                        fatherMin = Integer.parseInt(View.getJTextFieldFatherMinForDeleteIndex4().getText());
                    } catch (Exception exception) {
                        hasErrorsMin = true;
                        errors += "Неправильно введено поле: Введите зарплату отца от";
                    }
                    if (hasErrorsMin && hasErrorsMax) {
                        JOptionPane.showMessageDialog(null, errors);
                        return;
                    }

                    if (!(hasErrorsMin || hasErrorsMax)) {
                        ArrayList<Student> arrayListDelete = new ArrayList<>();
                        for (int i = 0; i < Model.getStudentArrayList().size(); i++) {
                            if (Model.getStudentArrayList().get(i).getFatherEarnings() >= fatherMin && Model.getStudentArrayList().get(i).getFatherEarnings() <= fatherMax) {
                                arrayListDelete.add(Model.getStudentArrayList().get(i));

                            }
                        }
                        for (int i = 0; i < arrayListDelete.size(); i++) {
                            Model.getStudentArrayList().remove(arrayListDelete.get(i));
                        }
                        JOptionPane.showMessageDialog(null, "Удалено " + arrayListDelete.size() + " записей");
                        View.setCurrentPageNumber(1);
                        View.updateCurrentPageNumber();
                        Controller.numberOfRowsOnPageLogic(View.getDefaultTableModel(), Model.getStudentArrayList(), numberOfRowsOnPage, View.getCurrentPageNumber());
                        View.updateJLabelNumbersOfRecords();
                        View.updateJLabelTotalPages();
                        View.updateJLabelNumberOfRecordsOnPage();
                    } else if (!hasErrorsMin) {
                        ArrayList<Student> arrayListDelete = new ArrayList<>();
                        for (int i = 0; i < Model.getStudentArrayList().size(); i++) {
                            if (Model.getStudentArrayList().get(i).getFatherEarnings() >= fatherMin) {
                                arrayListDelete.add(Model.getStudentArrayList().get(i));
                            }
                        }
                        for (int i = 0; i < arrayListDelete.size(); i++) {
                            Model.getStudentArrayList().remove(arrayListDelete.get(i));
                        }
                        JOptionPane.showMessageDialog(null, "Удалено " + arrayListDelete.size() + " записей");
                        View.setCurrentPageNumber(1);
                        View.updateCurrentPageNumber();
                        Controller.numberOfRowsOnPageLogic(View.getDefaultTableModel(), Model.getStudentArrayList(), numberOfRowsOnPage, View.getCurrentPageNumber());
                        View.updateJLabelNumbersOfRecords();
                        View.updateJLabelTotalPages();
                        View.updateJLabelNumberOfRecordsOnPage();
                    } else {
                        ArrayList<Student> arrayListDelete = new ArrayList<>();
                        for (int i = 0; i < Model.getStudentArrayList().size(); i++) {
                            if (Model.getStudentArrayList().get(i).getFatherEarnings() <= fatherMax) {
                                arrayListDelete.add(Model.getStudentArrayList().get(i));

                            }
                        }
                        for (int i = 0; i < arrayListDelete.size(); i++) {
                            Model.getStudentArrayList().remove(arrayListDelete.get(i));
                        }
                        JOptionPane.showMessageDialog(null, "Удалено " + arrayListDelete.size() + " записей");
                        View.setCurrentPageNumber(1);
                        View.updateCurrentPageNumber();
                        Controller.numberOfRowsOnPageLogic(View.getDefaultTableModel(), Model.getStudentArrayList(), numberOfRowsOnPage, View.getCurrentPageNumber());
                        View.updateJLabelNumbersOfRecords();
                        View.updateJLabelTotalPages();
                        View.updateJLabelNumberOfRecordsOnPage();
                    }


                } else if (View.getJRadioButtonMotherMoneyDeleteEnable().isSelected()) {
                    String errors = "";
                    boolean hasErrorsMax = false;
                    boolean hasErrorsMin = false;
                    int motherMax = 0;
                    int motherMin = 0;
                    try {
                        motherMax = Integer.parseInt(View.getJTextFieldMotherMaxForDeleteIndex4().getText());
                    } catch (Exception exception) {
                        hasErrorsMax = true;
                        errors += "Неправильно введено поле: Введите зарплату матери до \n";
                    }
                    try {
                        motherMin = Integer.parseInt(View.getJTextFieldMotherMinForDeleteIndex4().getText());
                    } catch (Exception exception) {
                        hasErrorsMin = true;
                        errors += "Неправильно введено поле: Введите зарплату матери от";
                    }
                    if (hasErrorsMin && hasErrorsMax) {
                        JOptionPane.showMessageDialog(null, errors);
                        return;
                    }

                    if (!(hasErrorsMin || hasErrorsMax)) {
                        ArrayList<Student> arrayListDelete = new ArrayList<>();
                        for (int i = 0; i < Model.getStudentArrayList().size(); i++) {
                            if (Model.getStudentArrayList().get(i).getMotherEarnings() >= motherMin && Model.getStudentArrayList().get(i).getMotherEarnings() <= motherMax) {
                                arrayListDelete.add(Model.getStudentArrayList().get(i));

                            }
                        }
                        for (int i = 0; i < arrayListDelete.size(); i++) {
                            Model.getStudentArrayList().remove(arrayListDelete.get(i));
                        }
                        JOptionPane.showMessageDialog(null, "Удалено " + arrayListDelete.size() + " записей");
                        View.setCurrentPageNumber(1);
                        View.updateCurrentPageNumber();
                        Controller.numberOfRowsOnPageLogic(View.getDefaultTableModel(), Model.getStudentArrayList(), numberOfRowsOnPage, View.getCurrentPageNumber());
                        View.updateJLabelNumbersOfRecords();
                        View.updateJLabelTotalPages();
                        View.updateJLabelNumberOfRecordsOnPage();
                    } else if (!hasErrorsMin) {
                        ArrayList<Student> arrayListDelete = new ArrayList<>();
                        for (int i = 0; i < Model.getStudentArrayList().size(); i++) {
                            if (Model.getStudentArrayList().get(i).getMotherEarnings() >= motherMin) {
                                arrayListDelete.add(Model.getStudentArrayList().get(i));

                            }

                        }
                        for (int i = 0; i < arrayListDelete.size(); i++) {
                            Model.getStudentArrayList().remove(arrayListDelete.get(i));
                        }
                        JOptionPane.showMessageDialog(null, "Удалено " + arrayListDelete.size() + " записей");
                        View.setCurrentPageNumber(1);
                        View.updateCurrentPageNumber();
                        Controller.numberOfRowsOnPageLogic(View.getDefaultTableModel(), Model.getStudentArrayList(), numberOfRowsOnPage, View.getCurrentPageNumber());
                        View.updateJLabelNumbersOfRecords();
                        View.updateJLabelTotalPages();
                        View.updateJLabelNumberOfRecordsOnPage();
                    } else {
                        ArrayList<Student> arrayListDelete = new ArrayList<>();
                        for (int i = 0; i < Model.getStudentArrayList().size(); i++) {
                            if (Model.getStudentArrayList().get(i).getMotherEarnings() <= motherMax) {
                                arrayListDelete.add(Model.getStudentArrayList().get(i));

                            }
                        }
                        for (int i = 0; i < arrayListDelete.size(); i++) {
                            Model.getStudentArrayList().remove(arrayListDelete.get(i));
                        }
                        JOptionPane.showMessageDialog(null, "Удалено " + arrayListDelete.size() + " записей");
                        View.setCurrentPageNumber(1);
                        View.updateCurrentPageNumber();
                        Controller.numberOfRowsOnPageLogic(View.getDefaultTableModel(), Model.getStudentArrayList(), numberOfRowsOnPage, View.getCurrentPageNumber());
                        View.updateJLabelNumbersOfRecords();
                        View.updateJLabelTotalPages();
                        View.updateJLabelNumberOfRecordsOnPage();
                    }


                }
            }
        });
    }

    public static void jRadioButtonCheck(JRadioButton jRadioButton1, JRadioButton jRadioButton2, JTextField jTextField1, JTextField jTextField2) {
        if (jRadioButton1.isSelected() && jRadioButton2.isSelected()) {
            jTextField1.setEditable(true);
            jTextField1.setBackground(Color.WHITE);
            jTextField2.setEditable(true);
            jTextField2.setBackground(Color.WHITE);
        } else if (!jRadioButton1.isSelected() && !jRadioButton2.isSelected()) {
            jTextField1.setEditable(false);
            jTextField1.setBackground(View.getJFrameMain().getBackground());
            jTextField1.setText("");
            jTextField2.setEditable(false);
            jTextField2.setBackground(View.getJFrameMain().getBackground());
            jTextField2.setText("");
        } else if (jRadioButton1.isSelected()) {
            jTextField1.setEditable(true);
            jTextField1.setBackground(Color.WHITE);

            jTextField2.setEditable(false);
            jTextField2.setBackground(View.getJFrameMain().getBackground());
            jTextField2.setText("");
        } else {
            jTextField2.setEditable(true);
            jTextField2.setBackground(Color.WHITE);

            jTextField1.setEditable(false);
            jTextField1.setBackground(View.getJFrameMain().getBackground());
            jTextField1.setText("");
        }

    }

    public static void jRadioButtonCheck(JRadioButton jRadioButton1, JRadioButton jRadioButton2, JTextField jTextField1min, JTextField jTextField1max, JTextField jTextField2min, JTextField jTextField2max) {
        if (jRadioButton1.isSelected() && jRadioButton2.isSelected()) {
            jTextField1min.setEditable(true);
            jTextField1min.setBackground(Color.WHITE);
            jTextField1max.setEditable(true);
            jTextField1max.setBackground(Color.WHITE);
            jTextField2min.setEditable(true);
            jTextField2min.setBackground(Color.WHITE);
            jTextField2max.setEditable(true);
            jTextField2max.setBackground(Color.WHITE);
        } else if (!jRadioButton1.isSelected() && !jRadioButton2.isSelected()) {
            jTextField1min.setEditable(false);
            jTextField1min.setBackground(View.getJFrameMain().getBackground());
            jTextField1min.setText("");

            jTextField1max.setEditable(false);
            jTextField1max.setBackground(View.getJFrameMain().getBackground());
            jTextField1max.setText("");

            jTextField2min.setEditable(false);
            jTextField2min.setBackground(View.getJFrameMain().getBackground());
            jTextField2min.setText("");

            jTextField2max.setEditable(false);
            jTextField2max.setBackground(View.getJFrameMain().getBackground());
            jTextField2max.setText("");
        } else if (jRadioButton1.isSelected()) {
            jTextField1min.setEditable(true);
            jTextField1min.setBackground(Color.WHITE);

            jTextField1max.setEditable(true);
            jTextField1max.setBackground(Color.WHITE);

            jTextField2min.setEditable(false);
            jTextField2min.setBackground(View.getJFrameMain().getBackground());
            jTextField2min.setText("");

            jTextField2max.setEditable(false);
            jTextField2max.setBackground(View.getJFrameMain().getBackground());
            jTextField2max.setText("");
        } else {
            jTextField2min.setEditable(true);
            jTextField2min.setBackground(Color.WHITE);

            jTextField2max.setEditable(true);
            jTextField2max.setBackground(Color.WHITE);

            jTextField1min.setEditable(false);
            jTextField1min.setBackground(View.getJFrameMain().getBackground());
            jTextField1min.setText("");


            jTextField1max.setEditable(false);
            jTextField1max.setBackground(View.getJFrameMain().getBackground());
            jTextField1max.setText("");
        }

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

    public static void mainFrameForFind() {
        numberOfRowsOnPageForFind = 0;
        View.getJComboBoxForButtonFind().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int selectedIndex = View.getJComboBoxForButtonFind().getSelectedIndex();

                View.disableAllFindFrames();
                if (selectedIndex == 1) {
                    View.drawFrameForFindIndex1();
                } else if (selectedIndex == 2) {
                    View.drawFrameForFindIndex2();
                } else if (selectedIndex == 3) {
                    View.drawFrameForFindIndex3();
                } else if (selectedIndex == 4) {
                    View.drawFrameForFindIndex4();
                }
                findFrameInformationUpdate();
            }
        });
        View.getJComboBoxForButtonFindRowsOnPage().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                numberOfRowsOnPageForFind = View.getJComboBoxForButtonFindRowsOnPage().getSelectedIndex();
                View.setCurrentPageNumberForFind(1);
                numberOfRowsOnPageLogic(View.getDefaultTableModelForButtonFind(), Model.getStudentArrayListForFind(), numberOfRowsOnPageForFind, View.getCurrentPageNumberForFind());
                findFrameInformationUpdate();
            }
        });
        View.getJButtonForButtonFindNextPage().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (numberOfRowsOnPageForFind * View.getCurrentPageNumberForFind() >= Model.getStudentArrayListForFind().size()) {
                    return;
                }
                View.setCurrentPageNumberForFind(View.getCurrentPageNumberForFind() + 1);
                numberOfRowsOnPageLogic(View.getDefaultTableModelForButtonFind(), Model.getStudentArrayListForFind(), numberOfRowsOnPageForFind, View.getCurrentPageNumberForFind());
                findFrameInformationUpdate();
            }
        });
        View.getJButtonForButtonFindPreviousPage().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (View.getCurrentPageNumberForFind() <= 1) {
                    return;
                }
                View.setCurrentPageNumberForFind(View.getCurrentPageNumberForFind() - 1);
                numberOfRowsOnPageLogic(View.getDefaultTableModelForButtonFind(), Model.getStudentArrayListForFind(), numberOfRowsOnPageForFind, View.getCurrentPageNumberForFind());
                findFrameInformationUpdate();
            }
        });
        View.getJButtonForButtonFindFirstPage().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                View.setCurrentPageNumberForFind(1);
                numberOfRowsOnPageLogic(View.getDefaultTableModelForButtonFind(), Model.getStudentArrayListForFind(), numberOfRowsOnPageForFind, View.getCurrentPageNumberForFind());
                findFrameInformationUpdate();
            }
        });
        View.getJButtonForButtonFindLastPage().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                View.setCurrentPageNumberForFind(View.getTotalPagesForFind());
                numberOfRowsOnPageLogic(View.getDefaultTableModelForButtonFind(), Model.getStudentArrayListForFind(), numberOfRowsOnPageForFind, View.getCurrentPageNumberForFind());
                findFrameInformationUpdate();
            }
        });


    }

    public static void findFrameInformationUpdate() {
        View.setNumbersOfRecordsForFind(Model.getStudentArrayListForFind().size());
        int a = 0;
        try {
            a = Model.getStudentArrayListForFind().size() / View.getJComboBoxForButtonFindRowsOnPage().getSelectedIndex();
            if (a * View.getJComboBoxForButtonFindRowsOnPage().getSelectedIndex() < Model.getStudentArrayListForFind().size()) {
                a++;
            }
        } catch (Exception exception) {
            a = 1;
        }
        if (a <= 0) {
            a = 1;
        }


        View.setTotalPagesForFind(a);
        View.setJTextAreaRecordsOnPage();
        View.setJTextAreaRecords();
        View.setJTextAreaTotalPages();
    }

}
