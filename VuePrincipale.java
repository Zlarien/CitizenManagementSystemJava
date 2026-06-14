import javax.swing.*;
import java.awt.*;
public class VuePrincipale extends JFrame{
    Mairie mairie;
    JButton boutonMariage = new JButton("Declarer Mariage");
    JButton boutonDivorce = new JButton("Declarer Divorce");
    JButton boutonNaissance = new JButton("Declarer Naissance");
    JButton boutonEtat = new JButton("Etat d'une personne");
    JButton boutonListe = new JButton("Affichage de la liste des personnes");
    JButton boutonSaisie = new JButton("Saisie des personnes");
    JButton boutonQuitter = new JButton("Quitter le programme");
    public VuePrincipale(Mairie m){
        mairie = m;
        setTitle(mairie.getNom());
        JPanel panneauBoutons = new JPanel();
        panneauBoutons.setLayout(new GridLayout(4, 2));
        panneauBoutons.add(boutonMariage);
        panneauBoutons.add(boutonDivorce);
        panneauBoutons.add(boutonNaissance);
        panneauBoutons.add(boutonEtat);
        panneauBoutons.add(boutonListe);
        panneauBoutons.add(boutonSaisie);
        panneauBoutons.add(boutonQuitter);
        add(panneauBoutons);
        MariageP ctMariage = new MariageP(mairie);
        DivorceP ctDivorce = new DivorceP(mairie);
        NaissanceP ctNaissance = new NaissanceP(mairie);
        EtatP ctEtat = new EtatP(mairie);
        ListeP ctListe = new ListeP(mairie);
        SaisieP ctSaisie = new SaisieP(mairie);
        QuitterP ctQuitter = new QuitterP();
        boutonMariage.addActionListener(ctMariage);
        boutonDivorce.addActionListener(ctDivorce);
        boutonNaissance.addActionListener(ctNaissance);
        boutonEtat.addActionListener(ctEtat);
        boutonListe.addActionListener(ctListe);
        boutonSaisie.addActionListener(ctSaisie);
        boutonQuitter.addActionListener(ctQuitter);
    }
}