package TiendaHelados;

/**
 * opciones de tipo ennumerado para almacenar
 * representaciones de cadenas para opciones de pedido.
 */

public enum Opciones {;

    // ancho maximo para la cadena de formato.
    private static final int MI_MAX_ANCHO = 30;

    // string para las opciones.
    public static final String MI_FORMATO = "%-" + MI_MAX_ANCHO + "s$%.2f";

    // string que representa la seleccion de tamaños.
    public static final String N_1
            = String.format(MI_FORMATO, "N°1 (12 cm):                           ", Costo.MED);

    public static final String N_2
            = String.format(MI_FORMATO, "N°2 (15 cm):                           ", Costo.PEQUEÑO);

    public static final String N_3
            = String.format(MI_FORMATO, "N°3 (18 cm):                           ", Costo.GRANDE);

    // string que representa la seleccion de conos.
    public static final String AZUCAR
            = String.format(MI_FORMATO, "Cono Azucar:                           ", Costo.AZUCAR);

    public static final String WAFFLE
            = String.format(MI_FORMATO, "Cono Waffle:                           ", Costo.WAFFLE);

    public static final String PAPEL
            = String.format(MI_FORMATO, "Cono Papel:                            ", Costo.PAPEL);

    // cadena que representa la seleccion de sabores.
    public static final String VAINILLA
            = String.format(MI_FORMATO, "Vainilla:                              ", Costo.VAINILLA);

    public static final String FRUTILLA
            = String.format(MI_FORMATO, "Frutilla:                               ", Costo.FRUTILLA);

    public static final String CHOCOLATE
            = String.format(MI_FORMATO, "Chocolate:                              ", Costo.CHOCOLATE);

    public static final String MANGO
            = String.format(MI_FORMATO, "Mango:                                  ", Costo.MANGO);

    // cadena que representa la seleccion de adicionales.
    public static final String LIMON
            = String.format(MI_FORMATO + "\n", "Limon:                           ", Costo.ADIC);

    public static final String BANANA
            = String.format(MI_FORMATO + "\n", "Banana:                          ", Costo.ADIC);

    public static final String NARANJA
            = String.format(MI_FORMATO + "\n", "Naranja:                         ", Costo.ADIC);

    public static final String MANZANA
            = String.format(MI_FORMATO + "\n", "Manzana:                         ", Costo.ADIC);



}