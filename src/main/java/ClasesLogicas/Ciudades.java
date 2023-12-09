package ClasesLogicas;

public enum Ciudades {
    ANGOL("Angol"),
    ARAUCO("Arauco"),
    BULNES("Bulnes"),
    CABRERO("Cabrero"),
    CAÑETE("Cañete"),
    CARAMPANGUE("Carampangue"),
    CAUQUENES("Cauquenes"),
    CHIGUAYANTE("Chiguayante"),
    CHILLAN("Chillán"),
    COBQUECURA("Cobquecura"),
    COELEMU("Coelemu"),
    CONCEPCION("Concepción"),
    CORONEL("Coronel"),
    CURANILAHUE("Curanilahue"),
    HUALQUI("Hualqui"),
    LAGUNILLAS("Lagunillas"),
    LAJA("Laja"),
    LEBU("Lebu"),
    LOS_ANGELES("Los Ángeles"),
    LOTA("Lota"),
    SAN_PEDRO_DE_LA_PAZ("San Pedro de la Paz"),
    SANTIAGO("Santiago"),
    TOME("Tomé"),
    VINA_DEL_MAR("Viña del Mar"),
    YUMBEL("Yumbel"),
    VALPARAISO("Valparaíso"),
    TALCAHUANO("Talcahuano");

    private final String nombre;

    Ciudades(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }
}