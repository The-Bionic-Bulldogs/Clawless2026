package frc.robot.subsystems;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.LimelightHelpers;
public class LimelightUpgrade extends SubsystemBase {
    private final String limelightName = "limelight-bb";

    public boolean hasTarget() {
        return LimelightHelpers.getTV(limelightName);
    }

    public double getTx() {
        return LimelightHelpers.getTX(limelightName);
    }
    
    public double getTy() {
        return LimelightHelpers.getTY(limelightName);
    }
    public double getTA() {
        return LimelightHelpers.getTA(limelightName); // target area
    }

    public double getTagID() {
        return LimelightHelpers.getFiducialID(limelightName); // AprilTag ID
    }
    
    


}
