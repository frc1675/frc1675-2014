package org.frc1675.oi.buttons;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj.buttons.Button;
import edu.wpi.first.wpilibj.buttons.JoystickButton;
import edu.wpi.first.wpilibj.command.Command;

/**
 * This is a button combo. Pass it a button and a rebindable button, run
 * setDefaultButtonBindings and setEscapeButtonBingings, passing in the command
 * you want run when the button is pressed for escape, and the command you want
 * to normally run for default.
 *
 * @author michael
 */
public class EscapeJoystickButton extends Button {

    private final RebindableJoystickButton rebindableJoystickButton;
    private final Button escapeButton;
    private final ButtonBindingProfile defaultBindingProfile;
    private final ButtonBindingProfile escapeBindingProfile;
    private final EscapeButtonScheduler escapeButtonScheduler;

    public EscapeJoystickButton(Button escapeButton, RebindableJoystickButton rebindableJoystickButton) {
        this.escapeButton = escapeButton;
        this.rebindableJoystickButton = rebindableJoystickButton;
        defaultBindingProfile = new ButtonBindingProfile();
        escapeBindingProfile = new ButtonBindingProfile();
        escapeButtonScheduler = new EscapeButtonScheduler();
        escapeButtonScheduler.initButton(defaultBindingProfile, escapeBindingProfile);
    }

    public void setDefaultButtonBindings(Command whenPressed, Command whileHeld, Command whenReleased) {
        if (whenPressed != null) {
            defaultBindingProfile.setWhenPressedCommand(whenPressed);
        }
        if (whileHeld != null) {
            defaultBindingProfile.setWhileHeldCommand(whileHeld);
        }
        if (whenReleased != null) {
            defaultBindingProfile.setWhenReleasedCommand(whenReleased);
        }
        escapeButtonScheduler.setDefaultButtonBindings();
    }

    public void setEscapeButtonBindings(Command whenPressed, Command whileHeld, Command whenReleased) {
        if (whenPressed != null) {
            escapeBindingProfile.setWhenPressedCommand(whenPressed);
        }
        if(whileHeld!=null){
            escapeBindingProfile.setWhileHeldCommand(whileHeld);
        }        
        if(whenReleased!=null){
            escapeBindingProfile.setWhenReleasedCommand(whenReleased);
        }
    }

    public boolean get() {
        return escapeButton.get();
    }
        
    private class ButtonBindingProfile{            
        private Command whenPressedCommand;
        private Command whileHeldCommand;
        private Command whenReleasedCommand;

        public ButtonBindingProfile(){
            whenPressedCommand = new NoOpCommand();
            whileHeldCommand = new NoOpCommand();
            whenReleasedCommand = new NoOpCommand();
        }
        
        private void setWhenPressedCommand(Command command){
            this.whenPressedCommand = command;
        }
        
        private Command getWhenPressedCommand(){
            return whenPressedCommand;
        }
        
        private void setWhileHeldCommand(Command command){
            this.whileHeldCommand = command;
        }
        
        private Command getWhileHeldCommand(){
            return whileHeldCommand;
        }

        private void setWhenReleasedCommand(Command command){
            this.whenReleasedCommand = command;
        }        
        
        private Command getWhenReleasedCommand(){
            return whenReleasedCommand;
        }
    }    
    
    private class EscapeButtonScheduler extends ButtonScheduler{
        private ButtonBindingProfile defaultBindingProfile;
        private ButtonBindingProfile escapeButtonProfile;
        private boolean whenPressedLast;
        private boolean whenReleasedLast;        
        
        public void execute() {           
            if(get()){
                whenReleasedLast = true;
                if(!whenPressedLast){
                    whenPressedLast = true;
                    setButtonBindings(escapeBindingProfile);
                }                
            }else{
                whenPressedLast = false;
                if(whenReleasedLast){
                    whenReleasedLast = false;
                    setButtonBindings(defaultBindingProfile);
                }                        
            }
        }        

        private void setButtonBindings(ButtonBindingProfile buttonBindingProfile){            
            rebindableJoystickButton.whenPressed(buttonBindingProfile.getWhenPressedCommand());
            rebindableJoystickButton.whileHeld(buttonBindingProfile.getWhileHeldCommand());
            rebindableJoystickButton.whenReleased(buttonBindingProfile.getWhenReleasedCommand());
        }        
        
        public void initButton(ButtonBindingProfile defaultProfile, ButtonBindingProfile escapeProfile){
            setButtonBindings(defaultProfile);
            this.defaultBindingProfile = defaultProfile;
            this.escapeButtonProfile = escapeProfile;
            this.start();
        }  
        
        public void setDefaultButtonBindings(){
            setButtonBindings(defaultBindingProfile);            
        }
    }
    
    private static class NoOpCommand extends Command{
        protected void initialize() {
        }

        protected void execute() {            
        }

        protected boolean isFinished() {
            return true;
        }

        protected void end() {            
        }

        protected void interrupted() {            
        }
    }
}
