package controller;

import javax.swing.JLabel;
import javax.swing.JRadioButton;

public class ClienteController {
    
    public void verificarSexo(JRadioButton btnA, JRadioButton btnB){
        if(btnA.isSelected()){
            btnB.setSelected(false);
        }
    }
    
    public void desabilitarErros(JLabel labelA, JLabel labelB, JLabel labelC , JLabel labelD){
        labelA.setVisible(false);
        labelB.setVisible(false);
        labelC.setVisible(false);
        labelD.setVisible(false);
    }
    
    public void habilitarErro(JLabel labelA, JLabel labelPrincipal){
        labelA.setVisible(true);
        labelPrincipal.setVisible(true);
    }
    
}
