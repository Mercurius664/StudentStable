package com.IvashkinIgor.dialog.add;

import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.PlainDocument;

class JTextFieldFilterNumber extends PlainDocument {
    @Override
    public void insertString(int offs, String str, AttributeSet a) throws BadLocationException {
        if (str == null) {
            return;
        }
        if (str.matches("(.*)[^0-9](.*)") || str.equals("")) {
            return;
        }
        super.insertString(offs, str, a);
    }
}
