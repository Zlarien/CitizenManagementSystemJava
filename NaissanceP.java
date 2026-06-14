import java.awt.event.*;
public class NaissanceP implements ActionListener{
    Mairie mairie;
    public NaissanceP(Mairie m) {
        mairie = m;
    }
    @Override
    public void actionPerformed(ActionEvent e){
        VueNaissance vua = new VueNaissance(mairie);
        vua.show();
        vua.pack();
    }
}