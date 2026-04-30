package frc.robot.subsystems;

import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

import com.ctre.phoenix.motorcontrol.InvertType;
import com.ctre.phoenix.motorcontrol.NeutralMode;
import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;
public class Drivetrain extends SubsystemBase {
    // private motors and drive
    private DifferentialDrive Drive;

    /** Creates a new Drivetrain. */
    public Drivetrain() {
        WPI_VictorSPX leftLeader = new WPI_VictorSPX(Constants.DriveConstants.kLeftLeaderMotorPort); //port 0
        WPI_VictorSPX rightLeader = new WPI_VictorSPX(Constants.DriveConstants.kRightLeaderMotorPort); //port 2

        @SuppressWarnings("resource")
        WPI_VictorSPX leftFollower = new WPI_VictorSPX(Constants.DriveConstants.kLeftFollowerMotorPort); //port 1
        @SuppressWarnings("resource")
        WPI_VictorSPX rightFollower = new WPI_VictorSPX(Constants.DriveConstants.kRightFollowerMotorPort); //port 3

        leftFollower.follow(leftLeader);
        rightFollower.follow(rightLeader);

        leftLeader.setInverted(false);
        rightLeader.setInverted(true);

        leftLeader.setNeutralMode(NeutralMode.Brake);
        rightLeader.setNeutralMode(NeutralMode.Brake);

        leftFollower.setInverted(InvertType.FollowMaster);
        rightFollower.setInverted(InvertType.FollowMaster);

        Drive = new DifferentialDrive(leftLeader, rightLeader);        
    }
     
    public void arcadeDrive(double forward, double rotation) {
        Drive.arcadeDrive(forward, rotation);
    }
     
    public void tankDrive(double left, double right) {
        Drive.tankDrive(left, right);
    }

    public void stop() {
        Drive.stopMotor();
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
