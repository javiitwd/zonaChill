package TEMA4.EXAMENES_TEMA4.CampeonatoPesca;

public class Equipo {
    private static final int TAM_EQUIPO = 5;
    private String nombre;
    private String region;
    private Pescador capitan;
    private Pescador[] pescadoresTotales;

    public Equipo(String nombre, String region, Pescador capitan) {
        this.nombre = nombre;
        this.region = region;
        this.capitan = capitan;
        pescadoresTotales = new Pescador[TAM_EQUIPO];
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public Pescador getCapitan() {
        return capitan;
    }

    public void setCapitan(Pescador capitan) {
        this.capitan = capitan;
    }

    public Pescador[] getPescadoresTotales() {
        return pescadoresTotales;
    }

    public void setPescadoresTotales(Pescador[] pescadoresTotales) {
        this.pescadoresTotales = pescadoresTotales;
    }

    private int miembrosEquipo() {

        int conteoPescadores = 0;
        for (int i = 0; i < pescadoresTotales.length; i++) {

            if (pescadoresTotales[i] != null) {
                conteoPescadores++;
            } else {
                return conteoPescadores;
            }
        }
        return conteoPescadores;
    }

    public void anadirPescador(Pescador pescador) throws CampeonatoPescaException {

        //Si hay hueco meto al pescador
        if (miembrosEquipo() < pescadoresTotales.length) {
            pescadoresTotales[miembrosEquipo()] = pescador;
        } else {
            throw new CampeonatoPescaException("No hay hueco");
        }
    }

    public Pescador buscarPescadorPorNombre(String pescador) throws CampeonatoPescaException {

        for (int i = 0; i < pescadoresTotales.length; i++) {

            //Recorro los miembros del equipo y miro sus nombre
            //Si alguno coincide con el nombre del pescador, le añado la captura
            if (pescadoresTotales[i].getNombre().equalsIgnoreCase(pescador)) {
                return pescadoresTotales[i];
            }
        }
        throw new CampeonatoPescaException("Pescador no encontrado en dicho equipo");
    }

    //Metodo para sacar el total de peso de capturas del equipo
    public double pesoTotalDeCapturasRealizadas() {
        double pesoTotalCapturas = 0;

        for (int i = 0; i < miembrosEquipo(); i++) {

            //Me aseguro de que hay miembros en la posicion i
            if (pescadoresTotales[i] != null) {

                //Sumo a una variable el total de peso de las capturas de cada pescador
                pesoTotalCapturas += pescadoresTotales[i].pesoTotalCapturasPescador();
            }
        }
        return pesoTotalCapturas;
    }
}