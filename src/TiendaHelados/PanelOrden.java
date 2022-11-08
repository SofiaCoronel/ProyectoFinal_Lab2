package TiendaHelados;

import javax.swing.*;

// muestra los totales y el boton del pedido.
public class PanelOrden extends JPanel {

    private static final long serialVersionUID = 1L;

    private final JLabel OrdenL;

    private final JLabel OrdenTotal;

    // etiqueta para delimitador de línea
    private final JLabel miLabelL;

    private String miString;

    private final JButton BotonOrdenar;

    public PanelOrden(final FrameTiendaHelados.CambiadorPrecios theListener) {
        super();
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        miString = "Precio:";

        // total de la venta.
        OrdenL = new JLabel(miString);
        OrdenTotal = new JLabel("8.99");
        miLabelL = new JLabel("-----------------");
        BotonOrdenar = new JButton("Ordenar");

        addButtons();
        addListeners(theListener);
    }

    private void addListeners(final FrameTiendaHelados.CambiadorPrecios theListener) {
        BotonOrdenar.addActionListener(theListener);
    }

    // metodo para establecer el total del pedido.
    protected void setTotal(final String elTotal) {
        OrdenTotal.setText(elTotal);
    }

    // añadimos los botones.
    private void addButtons() {
        add(OrdenL);
        add(OrdenTotal);
        add(miLabelL);
        add(BotonOrdenar);
    }

    // getter para el boton del pedido.
    public JButton getOrderBtn() {
        return BotonOrdenar;
    }
}