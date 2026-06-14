import javax.swing.*;
import java.awt.*;
public class VueListe extends JFrame{
    Mairie mairie;
    JTextArea zoneTexte = new JTextArea();
    public VueListe(Mairie m){
        mairie = m;
        setTitle("Liste des citoyens");
        zoneTexte.setEditable(false);
        String texte = "";
        for (int i = 0; i < mairie.getCitoyens().size(); i++) {
            texte = texte + mairie.getCitoyens().get(i).toString() + "\n";
        }
        zoneTexte.setText(texte);
        setLayout(new BorderLayout());
        add(zoneTexte, BorderLayout.CENTER);
    }
}
