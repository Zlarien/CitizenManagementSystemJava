import java.awt.event.*;
public class DivorceP implements ActionListener{
    Mairie mairie;
    public DivorceP(Mairie m){
        mairie = m;
    }
    @Override
    public void actionPerformed(ActionEvent e){
        VueDivorce vua = new VueDivorce(mairie);
        vua.show();
        vua.pack();
    }
}