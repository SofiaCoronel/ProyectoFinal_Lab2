package TiendaHelados;

import javax.swing.*;
import java.awt.*;

// panel para opciones de sabores.
public class PanelSabores extends JPanel {

    private static final long serialVersionUID = 1L;

    private JLabel miEtiqueta;

    private String miTexto;

    private final JCheckBox VainillaBtn;

    private  final JCheckBox ChocolateBtn;

    private final JCheckBox FrutillaBtn;

    private final JCheckBox MangoBtn;

    //private final ButtonGroup myGrupo;

    // constructor.
    public PanelSabores(final FrameTiendaHelados.CambiadorPrecios theListener) {
        super();
        // Layout.
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        miTexto = "Elige los Sabores:";
        miEtiqueta = new JLabel(miTexto);

        // instanciamos los botones.
        //myGrupo = new ButtonGroup();
        VainillaBtn = new JCheckBox("Vainilla = 0");
        ChocolateBtn = new JCheckBox("Chocolate = 40.0");
        FrutillaBtn = new JCheckBox("Frutilla = 50.0");
        MangoBtn = new JCheckBox("Mango = 80.50");

        addElements();
        addListeners(theListener);
    }

    private void addListeners(final FrameTiendaHelados.CambiadorPrecios theListener) {
        VainillaBtn.addActionListener(theListener);
        ChocolateBtn.addActionListener(theListener);
        FrutillaBtn.addActionListener(theListener);
        MangoBtn.addActionListener(theListener);
    }

    private void addElements() {
        /*myGrupo.add(VainillaBtn);
        myGrupo.add(FrutillaBtn);
        myGrupo.add(ChocolateBtn);
        myGrupo.add(MangoBtn);

         */

        // añadimos los elementos al panel.
        add(miEtiqueta);
        add(VainillaBtn);
        add(FrutillaBtn);
        add(ChocolateBtn);
        add(MangoBtn);


    }

    /*private void formato() {

        // establecemos tamaño a los botones.

        final Dimension max = new Dimension(VainillaBtn.getMaximumSize());
        final Dimension min = new Dimension(VainillaBtn.getMinimumSize());
        final Dimension pref = new Dimension(VainillaBtn.getPreferredSize());

        // establecemos el tamaño de los elementos.
        FrutillaBtn.setPreferredSize(pref);
        FrutillaBtn.setMaximumSize(max);
        FrutillaBtn.setMinimumSize(min);
        ChocolateBtn.setPreferredSize(pref);
        ChocolateBtn.setMaximumSize(max);
        ChocolateBtn.setMinimumSize(min);
        MangoBtn.setPreferredSize(pref);
        MangoBtn.setMaximumSize(max);
        MangoBtn.setMinimumSize(min);


        set background color for flavor buttons
        VainillaBtn.setBackground(Color.WHITE);
        FrutillaBtn.setBackground(Color.DARK_GRAY);
        ChocolateBtn.setBackground(Color.RED);
        MangoBtn.setBackground(Color.ORANGE);

        set text colors for flavor buttons
        VainillaBtn.setForeground(Color.GRAY);
        FrutillaBtn.setForeground(Color.GREEN);
        ChocolateBtn.setForeground(Color.BLUE);
        MangoBtn.setForeground(Color.MAGENTA);

    }*/


    public JCheckBox getVainillaBtn() {
        return VainillaBtn;
    }

    public JCheckBox getChocolateBtn() {
        return ChocolateBtn;
    }

    public JCheckBox getFrutillaBtn() {
        return FrutillaBtn;
    }


    public JCheckBox getMangoBtn() {
        return MangoBtn;
    }
}