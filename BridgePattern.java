// Implementor
interface Device {
    void togglePower();
    int getVolume();
    void setVolume(int volume);
}

// Abstraction
abstract class RemoteControl {
    protected Device device; // Bridge to the Device interface

    public RemoteControl(Device device) {
        this.device = device;
    }

    public abstract void power();
    public abstract void volumeUp();
    public abstract void volumeDown();
}

// Refined Abstraction 1
class AdvancedRemoteControl extends RemoteControl {
    public AdvancedRemoteControl(Device device) {
        super(device);
    }

    public void mute() {
        System.out.println("Muting the device.");
        device.setVolume(0);
    }

    @Override
    public void power() {
        device.togglePower();
    }

    @Override
    public void volumeUp() {
        device.setVolume(device.getVolume() + 10);
    }

    @Override
    public void volumeDown() {
        device.setVolume(device.getVolume() - 10);
    }
}

// Refined Abstraction 2
class BasicRemoteControl extends RemoteControl {

    public BasicRemoteControl(Device device) {
        super(device);
    }

    @Override
    public void power() {
        device.togglePower();
    }

    @Override
    public void volumeUp() {
        device.setVolume(device.getVolume() + 5);
    }

    @Override
    public void volumeDown() {
        device.setVolume(device.getVolume() - 5);
    }
}


// Concrete Implementor 1
class TV implements Device {
    private boolean isOn = false;
    private int volume = 30;

    @Override
    public void togglePower() {
        isOn = !isOn;
        System.out.println("TV power " + (isOn ? "ON" : "OFF"));
    }

    @Override
    public int getVolume() {
        return volume;
    }

    @Override
    public void setVolume(int volume) {
        this.volume = volume;
        System.out.println("TV volume set to " + this.volume);
    }
}

// Concrete Implementor 2
class Radio implements Device {
    private boolean isOn = false;
    private int volume = 50;

    @Override
    public void togglePower() {
        isOn = !isOn;
        System.out.println("Radio power " + (isOn ? "ON" : "OFF"));
    }

    @Override
    public int getVolume() {
        return volume;
    }

    @Override
    public void setVolume(int volume) {
        this.volume = volume;
        System.out.println("Radio volume set to " + this.volume);
    }
}

public class BridgePattern {
    public static void main(String[] args) {
        Device tv = new TV();
        Device radio = new Radio();

        RemoteControl basicRemote = new BasicRemoteControl(tv);

        AdvancedRemoteControl advancedRemote = new AdvancedRemoteControl(radio);

        System.out.println("Testing TV with Basic Remote:");
        basicRemote.power();
        basicRemote.volumeUp();
        basicRemote.volumeDown();

        System.out.println("\nTesting Radio with Advanced Remote:");
        advancedRemote.power();
        advancedRemote.volumeUp();
        advancedRemote.volumeDown();
        advancedRemote.mute();
    }
}






















// abstract class Device {
//     abstract public void turnOn();
//     abstract public void turnOff();
// }

// class Television extends Device {
//     @Override
//     public void turnOn() {
//         System.out.println("Turning on the TV");
//     }

//     @Override
//     public void turnOff() {
//         System.out.println("Turning off the TV");
//     }

//     public void changeChannel(int channel) {
//         System.out.println("Changing TV channel to: " + channel);
//     }
// }

// class DVDPlayer extends Device {
//     @Override
//     public void turnOn() {
//         System.out.println("Turning on the DVD Player");
//     }

//     @Override
//     public void turnOff() {
//         System.out.println("Turning off the DVD Player");
//     }

//     public void playDVD(String dvd){
//         System.out.println("DVD is playing: " + dvd);
//     }
// }

// abstract class Remote {
//     protected Device device;

//     public Remote(Device device) {
//         this.device = device;
//     }

//     public void on() {
//         device.turnOn();
//     }

//     public void off() {
//         device.turnOff();
//     }
// }

// class TVRemote extends Remote {
//     public TVRemote(Device device) {
//         super(device);
//     }
// }

// class DVDRemote extends Remote {
//     public DVDRemote(Device device) {
//         super(device);
//     }
// }

// public class BridgePattern {
//     public static void main(String[] args) {
//         Device television = new Television();
//         Remote tvRemote = new TVRemote(television); 
//         tvRemote.on();
//         tvRemote.off();

//         Device dvdPlayer = new DVDPlayer();
//         Remote dvdRemote = new DVDRemote(dvdPlayer);
//         dvdRemote.on();
//         dvdRemote.off();

//     }
// }
