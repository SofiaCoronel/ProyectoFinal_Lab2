package TiendaHelados;

import javax.swing.*;
import java.awt.*;

// Panel para el tipo de cono.
public class PanelTipoCono extends JPanel {

    private static final long serialVersionUID = 1L;

    private JLabel miLabel;
    private String miTexto;
    private JButton miBotonAzucar;
    private JButton miBotonWaffle;
    private final  JButton miBotonPapel;

    // tipos de conos.
    private final ButtonGroup miGrupoCono;

    public PanelTipoCono(FrameTiendaHelados.CambiadorPrecios theListener) {
        super();

        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        miTexto = "Tipo de Cono: ";
        miLabel = new JLabel(miTexto);

        miGrupoCono = new ButtonGroup();
        miBotonAzucar = new JButton("Cono Azucar");
        miBotonWaffle = new JButton("Cono Waffle");
        miBotonPapel = new JButton("Cono Papel");

        addButtons();
        format();
        addListeners(theListener);
    }

    private void addButtons() {
        // añadimos los botones.
        miGrupoCono.add(miBotonAzucar);
        miGrupoCono.add(miBotonWaffle);
        miGrupoCono.add(miBotonPapel);

        add(miLabel);
        add(miBotonAzucar);
        add(miBotonWaffle);
        add(miBotonPapel);
    }

    private void format() {

        // ajustar el botón de cono de azúcar al tamaño del botón de cono de waffle.
        miBotonAzucar.setPreferredSize(miBotonWaffle.getPreferredSize());
        miBotonAzucar.setMaximumSize(miBotonWaffle.getMaximumSize());
        miBotonAzucar.setMinimumSize(miBotonWaffle.getMinimumSize());

        // ajustar el botón de cono de papel al tamaño del botón de cono de waffle
        miBotonPapel.setPreferredSize(miBotonWaffle.getPreferredSize());
        miBotonPapel.setMaximumSize(miBotonWaffle.getMaximumSize());
        miBotonPapel.setMinimumSize(miBotonWaffle.getMinimumSize());

        // seleccionamos los colores de los botones.
        miBotonAzucar.setBackground(Color.WHITE);
        miBotonWaffle.setBackground(Color.WHITE);
        miBotonPapel.setBackground(Color.WHITE);

        // seleccionamos los colores del texto.
        miBotonAzucar.setForeground(Color.BLACK);
        miBotonWaffle.setForeground(Color.BLACK);
        miBotonPapel.setForeground(Color.BLACK);

        miBotonPapel.requestFocusInWindow();
    }

    private void addListeners(final FrameTiendaHelados.CambiadorPrecios theListener) {
        miBotonAzucar.addActionListener(theListener);
        miBotonWaffle.addActionListener(theListener);
        miBotonPapel.addActionListener(theListener);
    }

    public JButton getBotonAzucar() {
        return miBotonAzucar;
    }

    public JButton getBotonWaffle() {
        return miBotonWaffle;
    }

    public JButton getBotonPapel() {
        return miBotonPapel;
    }
}