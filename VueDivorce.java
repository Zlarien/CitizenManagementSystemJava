import javax.swing.*;
import java.awt.*;
public class VueDivorce extends JFrame{
    Mairie mairie;
    JLabel labelId1 = new JLabel("ID Epoux 1");
    JLabel labelId2 = new JLabel("ID Epoux 2");
    JLabel message = new JLabel(" ");
    JTextField champId1 = new JTextField();
    JTextField champId2 = new JTextField();
    JButton boutonValider = new JButton("Valider");

    public VueDivorce(Mairie m){
        mairie = m;
        setTitle("Vue Divorce");
        GridLayout layoutFenetre = new GridLayout(4, 2);
        setLayout(layoutFenetre);
        add(labelId1);
        add(champId1);
        add(labelId2);
        add(champId2);
        add(message);
        add(boutonValider);
        add(new JLabel(""));
        add(new JLabel(""));
        ContDivorce ct = new ContDivorce(mairie, champId1, champId2, message);
        boutonValider.addActionListener(ct);
    }
}
