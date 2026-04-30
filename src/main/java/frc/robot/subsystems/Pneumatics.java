package frc.robot.subsystems;

import edu.wpi.first.wpilibj.PneumaticsModuleType;
import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class Pneumatics extends SubsystemBase{
private final Solenoid solenoid = new Solenoid(PneumaticsModuleType.CTREPCM,0);
    public Pneumatics() {
        
      }
public Command SolenoidFire(){
return runOnce(() ->{
solenoid.set(true);//sends air to A on solenoid controller

});
}
public Command SolenoidIdle(){
return runOnce(() -> {
solenoid.set(false);//sends air to B on solenoid controller
});
}
}