public class Command {
    // Command interface
    interface Commander {
        void execute();
    }

    // Receiver
    static class Light {
        public void turnOn() {
            System.out.println("Light is on");
        }

        public void turnOff() {
            System.out.println("Light is off");
        }
    }

    // Concrete Command
    static class LightOnCommand implements Commander {
        private Light light;

        public LightOnCommand(Light light) {
            this.light = light;
        }

        public void execute() {
            light.turnOn();
        }
    }

    // Concrete Command
    static class LightOffCommand implements Commander {
        private Light light;

        public LightOffCommand(Light light) {
            this.light = light;
        }

        public void execute() {
            light.turnOff();
        }
    }

    // Invoker
    static class RemoteControl {
        private Commander command;

        public void setCommand(Commander command) {
            this.command = command;
        }

        public void pressButton() {
            command.execute();
        }
    }


    public static void main(String[] args) {
        Light light = new Light();

        LightOnCommand lightOn = new LightOnCommand(light);
        LightOffCommand lightOff = new LightOffCommand(light);

        RemoteControl remote = new RemoteControl();

        remote.setCommand(lightOn);
        remote.pressButton();

        remote.setCommand(lightOff);
        remote.pressButton();
    }


}