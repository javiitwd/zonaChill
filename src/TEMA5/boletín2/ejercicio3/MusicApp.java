package TEMA5.boletín2.ejercicio3;


public class MusicApp {

    private MusicPlayer[] players;

    public MusicApp() {
        players = new MusicPlayer[]{new Spotify(), new iTunes(), new MP3Player()};
    }

    public void main(String[] args) {

        MusicApp app = new MusicApp();
        app.startMusic(players);
    }

    public void startMusic(MusicPlayer[] players) {
        for (MusicPlayer m : players) {
            if (m instanceof OnlineMusicPlayer) {
                //Lo convierto a la interfaz OnlineMusicPlayer para poder usar el metodo stream de esta interfaz
                OnlineMusicPlayer on = (OnlineMusicPlayer) m;
                on.stream();
                //Llamo a los metodos de la interfaz MusicPlayer
            }
            if (m instanceof OfflineMusicPlayer) {
                //Lo convierto a la interfaz OfflineMusicPlayer para poder usar el metodo load de esta interfaz
                OfflineMusicPlayer of = (OfflineMusicPlayer) m;
                of.load();
                //Llamo a los metodos de la interfaz MusicPlayer
            }
            m.play();
            m.stop();
        }
    }
}
