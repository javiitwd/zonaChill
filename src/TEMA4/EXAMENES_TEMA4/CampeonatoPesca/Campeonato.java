package TEMA4.EXAMENES_TEMA4.CampeonatoPesca;

public class Campeonato {

    private String nombreCampeonato;
    private Equipo[] equiposCampeonato;

    public Campeonato(String nombreCampeonato) {
        this.nombreCampeonato = nombreCampeonato;
        this.equiposCampeonato = new Equipo[5];
    }

    private int contraEquipos() {
        int equipos = 0;
        for (int i = 0; i < equiposCampeonato.length; i++) {

            if (equiposCampeonato[i] != null) {
                equipos++;
            }
        }
        return equipos;
    }

    public void anadirEquipo(Equipo equipoAANadir) throws CampeonatoPescaException {

        if (equiposCampeonato.length < contraEquipos()) {
            throw new CampeonatoPescaException("No se pueden añadir más equipos");
        }
        equiposCampeonato[contraEquipos()] = equipoAANadir;
    }

    public Equipo buscarEquipoPorNombre(String nombre) throws CampeonatoPescaException {

        for (int i = 0; i < equiposCampeonato.length; i++) {

            if (equiposCampeonato[i] != null) {
                //Cuando coincida el nombre del equipo qye estamos buscando
                //llamamos al metodo para añadir al pescador de la clase equipo
                if (equiposCampeonato[i].getNombre().equalsIgnoreCase(nombre)) {

                    return equiposCampeonato[i];
                }
            } else {
                throw new CampeonatoPescaException("No hay equipos");
            }
        }
        throw new CampeonatoPescaException("Equipo no encontrado");
    }

    public Pescador buscarPescadorConMayorCapturaIndividual() {

        Pescador pescadorConMayorCapturaIndividual = null;
        double mayorPesoActual = 0;

        //De cada equipo del campeonato reviso sus pescadores
        for (int i = 0; i < equiposCampeonato.length; i++) {
            for (int j = 0; j < equiposCampeonato[i].getPescadoresTotales().length; j++) {

                //Me aseguro de que el equipo no es null
                if (equiposCampeonato[i] != null) {

                    //Del pescador j perteneciente el equipo i saco su mayor captura individual
                    //Si el peso de esta es mayor al de la actual lo sustituye, tanto el peso como el pescador
                    if (equiposCampeonato[i].getPescadoresTotales()[j].capturaMaximaDelPescador() > mayorPesoActual){

                        pescadorConMayorCapturaIndividual = equiposCampeonato[i].getPescadoresTotales()[j];
                        mayorPesoActual = (equiposCampeonato[i].getPescadoresTotales()[j].capturaMaximaDelPescador());
                    }
                }
            }
        }
        return pescadorConMayorCapturaIndividual;
    }

    public Equipo equipoConMayorCapuras(){
        double mayorPesoEquipo = 0;
        Equipo equipoConMasPeso = null;

        for (int i = 0; i < equiposCampeonato.length; i++) {

            //Me aseguro de que el equipo no es null
            if (equiposCampeonato[i] != null){
                //Recorro todos los equipos y saco su total de peso acumulado si es mayor que el actual lo sustituye
                if (equiposCampeonato[i].pesoTotalDeCapturasRealizadas() > mayorPesoEquipo){

                    mayorPesoEquipo = equiposCampeonato[i].pesoTotalDeCapturasRealizadas();
                    equipoConMasPeso = equiposCampeonato[i];
                }
            }
        }
        return equipoConMasPeso;
    }
}
