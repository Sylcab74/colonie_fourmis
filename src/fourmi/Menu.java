package fourmi;

import javax.swing.*;
import java.awt.event.*;

public class Menu extends JDialog {
    private JPanel contentPane;
    private JButton submit;
    private JTextField nb_fourmi;
    private JTextField nb_nourriture;
    private JTextField vitesse_evaporation;

    public int getNb_fourmi() {
        return Integer.parseInt(nb_fourmi.getText());
    }

    public int getNb_nourriture() {
        return Integer.parseInt(nb_nourriture.getText());
    }

    public int getVitesse_evaporation() {
        return Integer.parseInt(vitesse_evaporation.getText());
    }

    public Menu() {

        setContentPane(contentPane);
        setModal(true);
        getRootPane().setDefaultButton(submit);

        submit.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onOK();
            }
        });


        // call onCancel() when cross is clicked
        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        submit.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onOK();
            }
        });

        // call onCancel() on ESCAPE
    }

    private void onOK() {
        if (nb_fourmi.getText().equals("") || nb_nourriture.getText().equals("") || vitesse_evaporation.getText().equals("") ) {
            JOptionPane.showMessageDialog(null, "Veuillez remplir tous les champs", "Erreur",
                    JOptionPane.ERROR_MESSAGE);

        } else if(!isInteger(nb_fourmi.getText()) || !isInteger(nb_nourriture.getText()) || !isInteger(vitesse_evaporation.getText())) {
            JOptionPane.showMessageDialog(null, "Chiffres uniquement", "Erreur",
                    JOptionPane.ERROR_MESSAGE);
        }
        else {
            setVisible(false);
            dispose();
        }
        dispose();
    }


    public static void main(String[] args) {
        Menu dialog = new Menu();
        dialog.pack();
        dialog.setVisible(true);
        System.exit(0);
    }



    public static boolean isInteger(String s) {
        try {
            Integer.parseInt(s);
        } catch(NumberFormatException e) {
            return false;
        } catch(NullPointerException e) {
            return false;
        }
        // only got here if we didn't return false
        return true;
    }

    public MenuInfo getValue() {
        MenuInfo menuInfo = new MenuInfo(getNb_fourmi(), getNb_nourriture(), getVitesse_evaporation());
        return menuInfo;
    }

}
