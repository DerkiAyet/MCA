// Subsystems
class DVDPlay {
    public void on() {
        System.out.println("DVD Player is ON.");
    }

    public void play(String movie) {
        System.out.println("Playing movie: " + movie);
    }

    public void stop() {
        System.out.println("DVD Player is stopping.");
    }

    public void off() {
        System.out.println("DVD Player is OFF.");
    }
}

class Projector {
    public void on() {
        System.out.println("Projector is ON.");
    }

    public void off() {
        System.out.println("Projector is OFF.");
    }

    public void setWideScreenMode() {
        System.out.println("Projector in wide-screen mode.");
    }
}

class Amplifier {
    public void on() {
        System.out.println("Amplifier is ON.");
    }

    public void setVolume(int level) {
        System.out.println("Setting volume to " + level);
    }

    public void off() {
        System.out.println("Amplifier is OFF.");
    }
}

class Lights {
    public void dim() {
        System.out.println("Lights are dimming.");
    }

    public void on() {
        System.out.println("Lights are ON.");
    }
}

class Screen {
    public void down() {
        System.out.println("Screen is coming down.");
    }

    public void up() {
        System.out.println("Screen is going up.");
    }
}

// The Facade

class HomeTheaterFacade {
    private DVDPlay dvdPlayer;
    private Projector projector;
    private Amplifier amplifier;
    private Lights lights;
    private Screen screen;

    public HomeTheaterFacade(DVDPlay dvdPlayer, Projector projector, Amplifier amplifier, Lights lights, Screen screen) {
        this.dvdPlayer = dvdPlayer;
        this.projector = projector;
        this.amplifier = amplifier;
        this.lights = lights;
        this.screen = screen;
    }

    public void watchMovie(String movie) {
        System.out.println("Get ready to watch a movie...");
        lights.dim();
        screen.down();
        projector.on();
        projector.setWideScreenMode();
        amplifier.on();
        amplifier.setVolume(10);
        dvdPlayer.on();
        dvdPlayer.play(movie);
    }

    public void endMovie() {
        System.out.println("Shutting down movie...");
        lights.on();
        screen.up();
        projector.off();
        amplifier.off();
        dvdPlayer.stop();
        dvdPlayer.off();
    }
}

public class FacadePattern {
    public static void main(String[] args) {
        DVDPlay dvdPlayer = new DVDPlay();
        Projector projector = new Projector();
        Amplifier amplifier = new Amplifier();
        Lights lights = new Lights();
        Screen screen = new Screen();

        HomeTheaterFacade homeTheater = new HomeTheaterFacade(dvdPlayer, projector, amplifier, lights, screen);

        homeTheater.watchMovie("The Dark Knight");
        System.out.println("\nMovie has ended.");
        homeTheater.endMovie();
    }
}


