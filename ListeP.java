import java.awt.event.*;
public class ListeP implements ActionListener{
    Mairie mairie;
    public ListeP(Mairie m){
        mairie = m;
    }
    @Override
    public void actionPerformed(ActionEvent e){
        VueListe vua = new VueListe(mairie);
        vua.show();
        vua.pack();
    }
}