package org.frc1675.OI.buttons;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */


import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj.buttons.JoystickButton;
import edu.wpi.first.wpilibj.buttons.Trigger;
import edu.wpi.first.wpilibj.command.Command;

/**
 * Keeps a reference to a ButtonScheduler object for each method (whenPressed, 
 * whileHeld and whenReleased) so that different commands can be bound to the 
 * whenPressed, whileHeld and whenReleased methods of this button without 
 * creating overlap in the scheduler. Overlap occurs in the normal 
 * JoystickButton if more than one command is bound through a method (For 
 * example, if the whenPressed method is called twice, two commands will trigger
 * on one button press).
 * 
 * This is different from the JoystickButton class which doesn't keep a 
 * reference to the ButtonScheduler object it creates and creates a new 
 * ButtonScheduler object every time the whenPressed, whileHeld and whenReleased 
 * methods are called.
 * 
 * @author Michael
 */
public class RebindableJoystickButton extends JoystickButton {
    private final RebindableWhenPressScheduler rebindableWhenPressScheduler;
    private final RebindableWhileHeldScheduler rebindableWhileHeldScheduler;
    private final RebindableWhenReleaseScheduler rebindableWhenReleaseScheduler;

    public RebindableJoystickButton(GenericHID joystick, int buttonNumber) {
        super(joystick, buttonNumber);
        rebindableWhenPressScheduler = new RebindableWhenPressScheduler();
        rebindableWhileHeldScheduler = new RebindableWhileHeldScheduler();
        rebindableWhenReleaseScheduler = new RebindableWhenReleaseScheduler();
    }
    
    public void whenPressed(Command command) {
        rebindableWhenPressScheduler.initButton(command);
    }

    public void whileHeld(Command command) {
        rebindableWhileHeldScheduler.initButton(command);
    }

    public void whenReleased(Command command) {
        rebindableWhenReleaseScheduler.initButton(command);
    }

    private class RebindableWhenPressScheduler extends Trigger.ButtonScheduler {
        private boolean isOnScheduler;
        private boolean pressedLast;
        private Command command;

        public void execute() {
            if (get()) {
                if (!this.pressedLast) {
                    this.pressedLast = true;
                    command.start();
                }
            } else {
                this.pressedLast = false;
            }
        }

        private void initButton(Command command) {
            this.command = command;
            if (!isOnScheduler) {
                this.start();
                isOnScheduler = true;
            }
        }
    }

    private class RebindableWhileHeldScheduler extends Trigger.ButtonScheduler {
        private boolean isOnScheduler;
        private boolean pressedLast;
        private Command command;

        public void execute() {
            if (get()) {
                this.pressedLast = true;
                command.start();
            } else if (this.pressedLast) {
                this.pressedLast = false;
                command.cancel();
            }
        }

        private void initButton(Command command) {
            this.command = command;
            if (!isOnScheduler) {
                this.start();
                isOnScheduler = true;
            }
        }
    }

    private class RebindableWhenReleaseScheduler extends Trigger.ButtonScheduler {
        private boolean isOnScheduler;
        private boolean pressedLast;
        private Command command;

        public void execute() {
            if (get()) {
                this.pressedLast = true;
            } else if (this.pressedLast) {
                this.pressedLast = false;
                command.start();
            }
        }
        
        private void initButton(Command command){
            this.command = command;
            if(!isOnScheduler){
                this.start();
                isOnScheduler = true;
            }
        }
    }
}
