import java.util.List;
import java.util.ArrayList;

interface Command {
    void execute();
    void revert();
}

abstract class Vehic {
    public abstract void accelerate();
    public abstract void decelerate();
    public abstract void start();
    public abstract void stop();
}

class Motorcycl extends Vehic {
    @Override
    public void accelerate() {
        System.out.println("Motorcycle is accelerating.");
    }

    @Override
    public void decelerate() {
        System.out.println("Motorcycle is decelerating.");
    }

    @Override
    public void start() {
        System.out.println("Motorcycle has started.");
    }

    @Override
    public void stop() {
        System.out.println("Motorcycle has stopped.");
    }
}

class Truck extends Vehic {
    @Override
    public void accelerate() {
        System.out.println("Truck is accelerating.");
    }

    @Override
    public void decelerate() {
        System.out.println("Truck is decelerating.");
    }

    @Override
    public void start() {
        System.out.println("Truck has started.");
    }

    @Override
    public void stop() {
        System.out.println("Truck has stopped.");
    }
}


class AccelerateMotorcycle implements Command {
    private final Vehic motorcycle;

    public AccelerateMotorcycle(Vehic motorcycle) {
        this.motorcycle = motorcycle;
    }

    @Override
    public void execute() {
        motorcycle.accelerate();
    }

    @Override
    public void revert() {
        motorcycle.decelerate();
    }
}


class StartMotorcycle implements Command {
    private final Vehic motorcycle;

    public StartMotorcycle(Vehic motorcycle) {
        this.motorcycle = motorcycle;
    }

    @Override
    public void execute() {
        motorcycle.start();
    }

    @Override
    public void revert() {
        motorcycle.stop();
    }
}


class StartAllVehics implements Command {
    private final List<Vehic> Vehics;

    public StartAllVehics(List<Vehic> Vehics) {
        this.Vehics = Vehics;
    }

    @Override
    public void execute() {
        for (Vehic Vehic : Vehics) {
            Vehic.start();
        }
    }

    @Override
    public void revert() {
        for (Vehic Vehic : Vehics) {
            Vehic.stop();
        }
    }
}


class GhostRider {
    private Command command;

    public void setCommand(Command command) {
        this.command = command;
    }

    public void takeAction() {
        if (command != null) {
            command.execute();
        }
    }

    public void revertAction() {
        if (command != null) {
            command.revert();
        }
    }
}

public class Comman{
    public static void main(String[] args) {
        Vehic motorcycle = new Motorcycl();
        Vehic truck = new Truck();

        GhostRider ghostRider = new GhostRider();

        Command accelerateCommand = new AccelerateMotorcycle(motorcycle);
        ghostRider.setCommand(accelerateCommand);
        ghostRider.takeAction();
        ghostRider.revertAction();

        Command startMotorcycleCommand = new StartMotorcycle(motorcycle);
        ghostRider.setCommand(startMotorcycleCommand);
        ghostRider.takeAction();
        ghostRider.revertAction();

        List<Vehic> Vehics = new ArrayList<>();
        Vehics.add(motorcycle);
        Vehics.add(truck);
        Command startAllVehicsCommand = new StartAllVehics(Vehics);
        ghostRider.setCommand(startAllVehicsCommand);
        ghostRider.takeAction();
        ghostRider.revertAction();
    }
}


