package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.Drivetrain;
import frc.robot.subsystems.Limelight;
import frc.robot.subsystems.LimelightUpgrade;
import frc.robot.LimelightHelpers;

public class AutoAlignCommand extends Command {

    private final Drivetrain drivetrain;
    private final LimelightUpgrade limelight;
    
    private final double kpTurn_tagOne = 0.045;
    private final double kpDrive_tagOne = 0.34;

    private final double kpTurn_tagTwo = 0.048;
    private final double kpDrive_tagTwo = 0.2;

    private final double targetArea_tagOne = 5.0;
    private final double targetArea_tagTwo = 12.0;

    private final double kpTurn_tagThree = 0.05;
   

    public AutoAlignCommand(Drivetrain drivetrain, LimelightUpgrade limelight) {
        this.drivetrain = drivetrain;
        this.limelight = limelight;
        
        addRequirements(drivetrain);
    }

    
    @Override
    public void execute() {
        if (!limelight.hasTarget()) {
            drivetrain.arcadeDrive(0, 0);
            return;
        }
    
        double tagID = limelight.getTagID();
        double tx = limelight.getTx();
        double ta = limelight.getTA();
    
        // Declare these up-front so they are in scope everywhere in this method
        double turnCommand = 0.0;
        double driveCommand = 0.0;
    
        // --- Different behavior per tag ---
        if (tagID == 1) {
            // drive toward and align tightly
            LimelightHelpers.setPipelineIndex("limelight-bb", 0);
            turnCommand = kpTurn_tagOne * tx;
            driveCommand = (targetArea_tagOne - ta) * kpDrive_tagOne;

        } else if (tagID == 2) {
            // slower approach, maybe reversed
            turnCommand = kpTurn_tagTwo * tx;
            driveCommand = (targetArea_tagTwo - ta) * kpDrive_tagTwo;
        } else if (tagID == 3)
         {
            LimelightHelpers.setPipelineIndex("limelight-bb", 1);
            // only align angle, don’t drive forward
            turnCommand = kpTurn_tagThree * tx;
            driveCommand = 0.0;


        } else {
            drivetrain.arcadeDrive(0, 0);
         
            return;
        }
    
        // --- Clamp values for safety ---
        driveCommand = Math.max(-0.5, Math.min(0.5, driveCommand));
        turnCommand = Math.max(-0.5, Math.min(0.5, turnCommand));
    
        // --- Drive the robot ---
        drivetrain.arcadeDrive(driveCommand, -turnCommand);
    }
    

    @Override
    public boolean isFinished() {
    return false;
    }

    @Override
    public void end(boolean interrupted) {
        drivetrain.arcadeDrive(0, 0);
      
    }
}
        