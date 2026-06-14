import java.awt.event.*;
public class EtatP implements ActionListener{
    Mairie mairie;
    public EtatP(Mairie m){
        mairie = m;
    }
    @Override
    public void actionPerformed(ActionEvent e){
        VueEtat vua = new VueEtat(mairie);
        vua.show();
        vua.pack();
    }
}