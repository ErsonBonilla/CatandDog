package com.ut.catanddog.catanddog;
import com.ut.catanddog.catanddog.GUI.Principal;
import javax.swing.SwingUtilities;


public class CatandDog {

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            Principal princ = new Principal();
            princ.setVisible(true);
            princ.setLocationRelativeTo(null);
        });
    }
}
