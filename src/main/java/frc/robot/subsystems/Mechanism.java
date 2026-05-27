package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import com.ctre.phoenix.motorcontrol.NeutralMode;
public class Mechanism extends SubsystemBase {

 // WPI_TalonSRX mechMotor1 = new WPI_TalonSRX(4);
    WPI_TalonSRX mechMotor2 = new WPI_TalonSRX(5);

    public Mechanism() {
     
  // mechMotor1.setNeutralMode(NeutralMode.Brake);
     mechMotor2.setNeutralMode(NeutralMode.Brake); 

     mechMotor2.setInverted(true);
    }

    public Command ArmExtend (double speed) {
        return runOnce(() -> {
   //       mechMotor1.set(speed);
            mechMotor2.set(speed);
        });
    }
 
   
    
    public Command ArmRetract (double speed) {
        return runOnce(() -> {
   //       mechMotor1.set(-speed);
            mechMotor2.set(-speed);
        });
    }
public Command ArmStop () {
        return runOnce(() -> {
   //       mechMotor1.set(0);
            mechMotor2.set(0);
        });
    }

 
}
