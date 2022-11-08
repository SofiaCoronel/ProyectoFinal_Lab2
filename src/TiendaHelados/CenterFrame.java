package TiendaHelados;

import javax.swing.*;
import java.awt.*;

/*
 * representa un panel con el centro
 * de los sabores y paneles en
 * el marco principal.
 */
public class CenterFrame extends JPanel {

    private static final long serialVersionUID = 1L;

    // numero de elementos en este marco.
    private final int Elementos = 5;

    protected final PanelSabores Sabores;

    protected final PanelTipoCono PanelTipoCono;

    private final JLabel miCentro;

    private final JLabel miIzquierda;

    private final JLabel miDerecha;

    // constructor para centrar el marco.
    public CenterFrame(final FrameTiendaHelados.CambiadorPrecios theListener) {
        super();
        setLayout(new GridLayout(0, Elementos));

        // instanciamos los paneles.
        miIzquierda = new JLabel();
        miDerecha = new JLabel();
        miCentro = new JLabel();
        Sabores = new PanelSabores(theListener);
        PanelTipoCono = new PanelTipoCono(theListener);

        addElements();
        // damos formato a la apariencia de los elementos
        format();
    }

    // añadimos los elementos al panel.
    private void addElements() {
        add(miIzquierda);
        add(PanelTipoCono);
        add(miCentro);
        add(Sabores);
        add(miDerecha);
    }

    // formatear el tamaño y la visibilidad de los elementos.
    private void format() {

        miIzquierda.setVisible(false);
        miDerecha.setVisible(false);
        miCentro.setVisible(false);

    }

}