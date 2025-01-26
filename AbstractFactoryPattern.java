interface Button {
    void render();
}

interface Checkbox {
    void render();
}

// Windows-specific Button
class WindowsButton implements Button {
    @Override
    public void render() {
        System.out.println("Rendering Windows Button.");
    }
}
// Mac-specific Button
class MacButton implements Button {
    @Override
    public void render() {
        System.out.println("Rendering Mac Button.");
    }
}
// Windows-specific Checkbox
class WindowsCheckbox implements Checkbox {
    @Override
    public void render() {
        System.out.println("Rendering Windows Checkbox.");
    }
}
// Mac-specific Checkbox
class MacCheckbox implements Checkbox {
    @Override
    public void render() {
        System.out.println("Rendering Mac Checkbox.");
    }
}

interface GUIFactory {
    Button createButton();
    Checkbox createCheckbox();
}

class WindowsFactory implements GUIFactory {
    @Override
    public Button createButton() {
        return new WindowsButton();
    }

    @Override
    public Checkbox createCheckbox() {
        return new WindowsCheckbox();
    }
}

class MacFactory implements GUIFactory {
    @Override
    public Button createButton() {
        return new MacButton();
    }

    @Override
    public Checkbox createCheckbox() {
        return new MacCheckbox();
    }
}

//-----Client Side----
class Application {
    private Button button;
    private Checkbox checkbox;

    public Application(GUIFactory factory) {
        button = factory.createButton();
        checkbox = factory.createCheckbox();
    }

    public void render() {
        button.render();
        checkbox.render();
    }
}

public class AbstractFactoryPattern {
    public static void main(String[] args) {
        GUIFactory factory;
        // Example for Windows
        factory = new WindowsFactory();
        Application app = new Application(factory);
        app.render();
        // Example for macOS
        factory = new MacFactory();
        app = new Application(factory);
        app.render();
    }
}





