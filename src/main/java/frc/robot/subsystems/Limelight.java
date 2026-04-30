package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import edu.wpi.first.networktables.NetworkTable;
import edu.wpi.first.networktables.NetworkTableInstance;



public class Limelight extends SubsystemBase {
    private final NetworkTable table = NetworkTableInstance.getDefault().getTable("limelight-bb");


    public boolean hasTarget() {
        double tv = table.getEntry("tv").getDouble(0.0);
        return tv == 1.0;
    }

    public double getTx() {
        return table.getEntry("tx").getDouble(0.0);
    }
    
    public double getTy() {
        return table.getEntry("ty").getDouble(0.0);
    }
    public double getTA() {
        return table.getEntry("ta").getDouble(0.0); // target area
    }

    public double getTagID() {
        return table.getEntry("tid").getDouble(-1); // AprilTag ID
    }

    public void setLEDMode(int mode) {
        // 0 = pipeline, 1 = force off, 2 = blink, 3 = force on
        table.getEntry("ledMode").setNumber(mode);
    }

    public void setBrightness(double brightness) {
        // Brightness range 0–100
        table.getEntry("ledStrength").setDouble(brightness);
    }

    public void setLEDOff() {
        setLEDMode(1);
    }

    public void setLEDOn() {
        setLEDMode(3);
    }

    public void setLEDBrightness(double percent) {
        // Some Limelight models use pipeline/LED current control differently, 
        // so we’ll use this method for flexibility
        setBrightness(percent);
    }


    public double getDistance() {
        double targetHeight = 0.65; // meters
        double limelightHeight = 0.3;
        double limelightAngle = 25.0; // degrees

        double ty = getTy();
        return (targetHeight - limelightHeight) /
               Math.tan(Math.toRadians(limelightAngle + ty));
    }
}
