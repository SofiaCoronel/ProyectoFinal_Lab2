package TiendaHelados;

import javax.swing.*;
import java.awt.*;

/**
 * esto representa un menú desplegable
 * con opciones de radio para seleccionar
 * tamaños de cono de helado.
  */
public class TamPanel extends JPanel {

    private static final long serialVersionUID = 1L;

    private JLabel miEtiqueta;

    private final String miTexto;

    // tamaño de conos.
    private final JComboBox miTam_C;

    // lista de opciones para la seleccion de tamaños.
    private final String[] miListaTamaño =
            {"N°1 (12 cm)", "N°2 (15 cm)", "N°3 (18 cm)"};


    public TamPanel(final FrameTiendaHelados.CambiadorPrecios theListener) {
        super();
        // layout.
        setLayout(new BoxLayout(this, 1));

        //instantiate myLabel
        miTexto = "Tamaño del HELADO:";
        miEtiqueta = new JLabel(miTexto);

        miTam_C = new JComboBox(miListaTamaño);
        miTam_C.setSelectedIndex(1);

        addButtons();
        format();
        addListeners(theListener);
    }

    private void addListeners(final FrameTiendaHelados.CambiadorPrecios theListener) {
        miTam_C.addActionListener(theListener);
    }

    private void addButtons() {
        add(miEtiqueta);
        add(miTam_C);
    }

    private void format() {
        // etiqueta invisible para formatear el tamaño de miTam_C
        final JLabel formato = new JLabel("                                ");
        final int fontSize = 20;
        formato.setFont(new Font("comic sans", Font.BOLD, fontSize));

        //max tamaño para miTam_C
        final Dimension max = new Dimension(formato.getMaximumSize());
        //min tamaño para miTam_C
        final Dimension min = new Dimension(formato.getMinimumSize());
        //pref tamaño
        final Dimension pref = new Dimension(formato.getPreferredSize());

        // establecer tamaño para menu desplegable.
        miTam_C.setMaximumSize(max);
        miTam_C.setMinimumSize(min);
        miTam_C.setPreferredSize(pref);

        miEtiqueta.setAlignmentX(Component.LEFT_ALIGNMENT);
        miTam_C.setAlignmentX(Component.LEFT_ALIGNMENT);
    }


    public JComboBox getSizesSelection() {
        return miTam_C;
    }
}