import java.awt.event.*;
public class SaisieP implements ActionListener{
    Mairie mairie;
    public SaisieP(Mairie m){
        mairie = m;
    }
    @Override
    public void actionPerformed(ActionEvent e){
        VueSaisie vua = new VueSaisie(mairie);
        vua.show();
        vua.pack();
    }
}