package com.ivashkinigor.dialog.add;

import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.PlainDocument;

class JTextFieldFilter extends PlainDocument {
    @Override
    public void insertString(int offs, String str, AttributeSet a) throws BadLocationException {
        if (str == null) {
            return;
        }
        if (!str.matches("(.*)[a-zA-Zа-яА-Я](.*)") && !str.matches("\\s") ||
                str.equals("")) {
            return;
        }
        if (str.matches("\\s") && this.getText(offs - 1, 1).matches("\\s")) {
            return;
        }
        super.insertString(offs, str, a);
    }
}
