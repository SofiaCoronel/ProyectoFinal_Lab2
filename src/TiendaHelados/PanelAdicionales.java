package TiendaHelados;

import javax.swing.*;

public class PanelAdicionales extends JPanel {

    private static final long serialVersionUID = 1L;

    private JLabel miEtiqueta;

    private String miString;

    private JCheckBox adLimon;

    private JCheckBox adBanana;

    private JCheckBox adNaranja;

    private JCheckBox adManzana;

    public PanelAdicionales(final FrameTiendaHelados.CambiadorPrecios theListener) {
        super();
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        //instantiate myLabel
        miString = "Adicionales:";
        miEtiqueta = new JLabel(miString);

        //instantiate check boxes
        adLimon = new JCheckBox("Limon");
        adBanana = new JCheckBox("Banana");
        adNaranja = new JCheckBox("Naranja");
        adManzana = new JCheckBox("Manzana");

        addElements();
        addListeners(theListener);
    }

    private void addListeners(final FrameTiendaHelados.CambiadorPrecios theListener) {
        adLimon.addActionListener(theListener);
        adBanana.addActionListener(theListener);
        adNaranja.addActionListener(theListener);
        adManzana.addActionListener(theListener);
    }

    // añadimos los elementos al panel.
    private void addElements() {

        add(miEtiqueta);
        add(adLimon);
        add(adBanana);
        add(adNaranja);
        add(adManzana);

    }

   /*
   private void format() {
        adLimon.setForeground(Color.GREEN);
        adBanana.setForeground(Color.YELLOW);
        adNaranja.setForeground(Color.ORANGE);
    }
    */

    public JCheckBox getLimon() {
        return adLimon;
    }

    public JCheckBox getBanana() {
        return adBanana;
    }

    public JCheckBox getNaranja() {
        return adNaranja;
    }

    public JCheckBox getManzana() {
        return adManzana;
    }
}