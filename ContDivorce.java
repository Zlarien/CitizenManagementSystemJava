import java.awt.event.*;
import javax.swing.*;
public class ContDivorce implements ActionListener{
    Mairie mairie;
    JTextField champId1;
    JTextField champId2;
    JLabel message;
    public ContDivorce(Mairie m, JTextField id1, JTextField id2, JLabel msg){
        mairie = m;
        champId1 = id1;
        champId2 = id2;
        message = msg;
    }
    @Override
    public void actionPerformed(ActionEvent e){
        int id1 = Integer.parseInt(champId1.getText());
        int id2 = Integer.parseInt(champId2.getText());
        Mariage mariageTrouve = null;
        for (int i = 0; i < mairie.getMariages().size(); i++){
            Mariage mariage = mairie.getMariages().get(i);
            if (!mariage.isDivorce()) {
                if (mariage.getEpoux1().getIdentifiant() == id1 && mariage.getEpoux2().getIdentifiant() == id2 || mariage.getEpoux1().getIdentifiant() == id2 && mariage.getEpoux2().getIdentifiant() == id1) {
                    mariageTrouve = mariage;
                    break;
                }
            }
        }
        if (mariageTrouve == null){
            message.setText("Aucun mariage actif trouve");
        }
        else{
            mariageTrouve.setDivorce(true);
            message.setText("Divorce enregistre");
        }
    }
}