package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import edu.wpi.first.wpilibj2.command.Command;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import com.ctre.phoenix6.signals.NeutralModeValue;
import com.ctre.phoenix.motorcontrol.NeutralMode;
public class Learn extends SubsystemBase {
    // WPI_TalonSRX mechMotor1 = new WPI_TalonSRX(null);
    WPI_TalonSRX motor1 = new WPI_TalonSRX(3);
  /** Creates a new Learn. */
  public Learn() {
motor1.setNeutralMode(NeutralMode.Coast);
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }

  @Override
  public void simulationPeriodic() {
    // This method will be called once per scheduler run during simulation
  }



}
//this is so tuff.