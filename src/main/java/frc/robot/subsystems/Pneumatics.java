package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj.PneumaticsModuleType;
import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.Commands;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class Pneumatics extends SubsystemBase{
private final Solenoid m_solenoid0 = new Solenoid(PneumaticsModuleType.CTREPCM,0);
private final Solenoid m_solenoid1 = new Solenoid(PneumaticsModuleType.CTREPCM,1);
private final Solenoid m_solenoid2 = new Solenoid(PneumaticsModuleType.CTREPCM,2);
private final Solenoid m_solenoid3 = new Solenoid(PneumaticsModuleType.CTREPCM,3);
    public Pneumatics() {
        
      }

public Command SolenoidFire0(double pPulselength){
return run(() ->{

m_solenoid0.set(true);//sends air to A on solenoid controller
/*Commands.waitSeconds(pPulselength);//wait how long the cannon will be on
m_solenoid.set(false);*/

});
}
public Command SolenoidFire1(double pPulselength){
return run(() ->{

m_solenoid1.set(true);//sends air to A on solenoid controller
/*Commands.waitSeconds(pPulselength);//wait how long the cannon will be on
m_solenoid.set(false);*/

});
}
public Command SolenoidFire2(double pPulselength){
return run(() ->{

m_solenoid2.set(true);//sends air to A on solenoid controller
/*Commands.waitSeconds(pPulselength);//wait how long the cannon will be on
m_solenoid.set(false);*/

});
}
public Command SolenoidFire3(double pPulselength){
  return run (() ->{
    m_solenoid3.set(true);//sends air to A on solenoid controller
    /*Commands.waitSeconds(pPulselength);//wait how long the cannon will be on
    m_solenoid.set(false);*/

  });
}
public Command SolenoidIdle0(){
return run(() -> {
m_solenoid0.set(false);//sends air to B on solenoid controller0.5
});
}

public Command SolenoidIdle1(){
return run(() -> {
m_solenoid1.set(false);//sends air to B on solenoid controller0.5
});
}
public Command SolenoidIdle2(){
return run(() -> {
m_solenoid2.set(false);//sends air to B on solenoid controller0.5
});
}
public Command SolenoidIdle3(){
return run(() -> {
m_solenoid3.set(false);//sends air to B on solenoid controller0.5
});
}}