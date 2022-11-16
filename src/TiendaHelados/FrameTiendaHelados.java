package TiendaHelados;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

// Frame para la tienda de Helados.
public class FrameTiendaHelados extends JFrame {

    private static final long serialVersionUID = 1L;

    // tamaño de fuente de la etiqueda.
    private static final int FONTSIZE = 28;

    // texto del titulo.
    private final String miText;

    // etiqueta del encabezado.
    private JLabel miLabel;

    // panel a la izq del layout.
    private  final TamPanel miPanelL;

    // panel para los elementos centrales.
    private final CenterFrame miPanelC;

    // panel para los adicionales.
    private final PanelAdicionales miPanelR;

    // panel para la seccion de ordenar.
    private final Boton miPanelB;

    // actualizacion de precios.
    private final CambiadorPrecios miOyentePrecios;

    public FrameTiendaHelados() {
        super();
        miText = "Bienvenido a la Heladeria!";

        miOyentePrecios = new CambiadorPrecios();

        miPanelL = new TamPanel(miOyentePrecios);
        miPanelC = new CenterFrame(miOyentePrecios);
        miPanelR = new PanelAdicionales(miOyentePrecios);
        miPanelB = new Boton(miOyentePrecios);
        miOyentePrecios.actualizarOrdenTotal();

        constGUI();
        format();
    }


    // constructor GUI
    private void constGUI() {

        miLabel = new JLabel(miText);

        miLabel.setFont(new Font("Century Gothic", Font.BOLD, FONTSIZE));

        // etiqueta central.
        miLabel.setHorizontalAlignment(JLabel.CENTER);
        add(miLabel, BorderLayout.NORTH);

        //añadimos el panel oeste (tamaño - desplegable) al marco.
        add(miPanelL, BorderLayout.WEST);

        //añadimos al centro (tipo de cono y sabores).
        add(miPanelC, BorderLayout.CENTER);

        // añadimos al marco este (adicionales).
        add(miPanelR, BorderLayout.EAST);

        // agregar al panel inferior.
        add(miPanelB, BorderLayout.SOUTH);

        pack();
    }

    private void format() {
        // establecer el color de primer plano de la etiqueta
        miLabel.setForeground(Color.BLACK);

        // establecer el color de fondo de la etiqueta
        miLabel.setBackground(Color.DARK_GRAY);

    }

    protected class CambiadorPrecios implements ActionListener {

        // acumulado de la seccion de tamaño.
        private double miCostoTamanio = Costo.MED;

        // tamaño para el formulario de pedido.
        private String miSeleccionTamanio = Opciones.N_1;

        // acumulado de la seccion de cono
        private double miCostoCono = Costo.PAPEL;

        // seleccion de cono para el formulario de pedido.
        private String miSeleccionCono = Opciones.PAPEL;

        // acumulado de la seccion sabores.
        private double miCostoSabor = Costo.VAINILLA;

        // seleccion de sabor para el formulario de pedido.
        private String miSeleccionSabor = Opciones.VAINILLA;

        // acumulado de la seccion adicionales.
        private double miCostoAdicional = 0.0;

        // seleccion de sabor para el formulario de adicionales.
        private String miSeleccionAdicional = "";

        // orden total
        private double miTotal = miCostoTamanio + miCostoCono + miCostoSabor + miCostoAdicional;

        /**
         * Performs a change in the Final Price
         * Also updates the information for the order form.
         * @param theEvent is the component that was clicked by user.
         * @custom.post price updated to reflect selections.
         */
        @Override
        public void actionPerformed(final ActionEvent theEvent) {

            // obj para almacenar la fuente del evento.
            final Object fuente = theEvent.getSource();

            // opcion de adicionales.
            if (fuente == miPanelR.getBanana()
                    || fuente == miPanelR.getLimon()
                    || fuente == miPanelR.getNaranja()
                    || fuente == miPanelR.getManzana()) {
                actualizarCostoAdic();
            } else if (fuente == miPanelC.PanelTipoCono.getBotonAzucar()) { // selec. cono
                miCostoCono = Costo.AZUCAR;
                miSeleccionCono = Opciones.AZUCAR;
            } else if (fuente == miPanelC.PanelTipoCono.getBotonWaffle()) {
                miCostoCono = Costo.WAFFLE;
                miSeleccionCono = Opciones.WAFFLE;
            } else if (fuente == miPanelC.PanelTipoCono.getBotonPapel()) {
                miCostoCono = Costo.PAPEL;
                miSeleccionCono = Opciones.PAPEL;
            } else if (fuente == miPanelC.Sabores.getVaniBtn()) { // opciones de sabores.
                miCostoSabor = Costo.VAINILLA;
                miSeleccionSabor = Opciones.VAINILLA;
            } else if (fuente == miPanelC.Sabores.getChocBtn()) {
                miCostoSabor = Costo.CHOCOLATE;
                miSeleccionSabor = Opciones.CHOCOLATE;
            } else if (fuente == miPanelC.Sabores.getStrawBtn())  {
                miCostoSabor = Costo.FRUTILLA;
                miSeleccionSabor = Opciones.FRUTILLA;
            } else if (fuente == miPanelC.Sabores.getMangoBtn()) {
                miCostoSabor = Costo.MANGO;
                miSeleccionSabor = Opciones.MANGO;
            } else if (fuente == miPanelB.Centro.getOrderBtn()) {
                // resumen del pedido.
                orden();
            } else if (fuente == miPanelL.getSizesSelection()) {
                final String size = (String) miPanelL.getSizesSelection().getSelectedItem();
                if (size.equals("N°1 (12 cm)")) {
                    miCostoTamanio = Costo.PEQUEÑO;
                    miSeleccionTamanio = Opciones.N_1;
                } else if (size.equals("N°2 (15 cm)")) {
                    miCostoTamanio = Costo.MED;
                    miSeleccionTamanio = Opciones.N_2;
                } else if (size.equals("N°3 (18 cm)")) {
                    miCostoTamanio = Costo.GRANDE;
                    miSeleccionTamanio = Opciones.N_3;
                }
            }

            actualizarOrdenTotal();
        }

        private void orden() {
            final String orden = "Tu orden de HELADO" + "\n"
                    + "Tamaño:\n"
                    + miSeleccionTamanio + "\n"
                    + "---------------------------\n"
                    + "Tipo de Cono:\n"
                    + miSeleccionCono + "\n"
                    + "---------------------------\n"
                    + "Sabor:\n"
                    + miSeleccionSabor + "\n"
                    + "---------------------------\n"
                    + "Adicionales:\n"
                    + miSeleccionAdicional
                    + "___________________________"
                    + "\n"
                    + String.format(Opciones.MI_FORMATO, "Total:                "
                    + "                   ", miTotal) + "\n"
                    + "Confirmas la Orden?" + "\n";

            JOptionPane.showConfirmDialog(null, orden);


        }

        protected void actualizarOrdenTotal() {
            miTotal = miCostoTamanio + miCostoCono
                    + miCostoSabor + miCostoAdicional;
            miPanelB.Centro.setTotal(String.format("%.2f", miTotal));

        }

        /**
         * actualiza el costo del adicional elegido
         * cuando ocurre un evento de accion de mezcla.
         */
        private void actualizarCostoAdic() {
            // restablecer el costo de los adicionales.
            miCostoAdicional = 0.0;
            miSeleccionAdicional = "";

            // si se selecciona la mezcla, agrega el costo.
            if (miPanelR.getBanana().isSelected()) {
                miCostoAdicional += Costo.ADIC;
                miSeleccionAdicional += Opciones.BANANA;
            }
            if (miPanelR.getLimon().isSelected()) {
                miCostoAdicional += Costo.ADIC;
                miSeleccionAdicional += Opciones.LIMON;
            }
            if (miPanelR.getNaranja().isSelected()) {
                miCostoAdicional += Costo.ADIC;
                miSeleccionAdicional += Opciones.NARANJA;
            }
            if (miPanelR.getManzana().isSelected()) {
                miCostoAdicional += Costo.ADIC;
                miSeleccionAdicional += Opciones.MANZANA;
            }
        }
    }
}