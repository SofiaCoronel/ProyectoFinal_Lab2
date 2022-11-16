package TiendaHelados;

import javax.swing.*;

public class Boton extends JPanel {

    private static final long serialVersionUID = 1L;

    // el elemento a centrar.
    protected final PanelOrden Centro;

    // relleno izquierdo.
    private final JButton Izquierda;

    // relleno derecho.
    private final JButton Derecha;

    // Constructor.
    public Boton(final FrameTiendaHelados.CambiadorPrecios theListener) {
        super();

        // Panel con el boton para ordenar e informacion.
        Centro = new PanelOrden(theListener);
        Derecha = new JButton();
        Izquierda = new JButton();

        addElements();
        setSize();
    }

    // Añadimos los elementos.
    private void addElements() {
        add(Izquierda);
        add(Centro);
        add(Derecha);
    }

    private void setSize() {

        // no estan visibles, solo actuan como relleno
        Izquierda.setVisible(false);
        Derecha.setVisible(false);
    }

}