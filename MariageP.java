import java.awt.event.*;
public class MariageP implements ActionListener{
    Mairie mairie;
    public MariageP(Mairie m){
        mairie = m;
    }
    @Override
    public void actionPerformed(ActionEvent e){
        VueMariage vua = new VueMariage(mairie);
        vua.show();
        vua.pack();
    }
}