package frc.subsystems;
import com.ctre.phoenix6.configs.TalonFXConfiguration;
import com.ctre.phoenix6.controls.PositionVoltage;
import com.ctre.phoenix6.hardware.TalonFX;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class Arm extends SubsystemBase {
  public final TalonFX FirstMotor = new TalonFX(1);
  public final TalonFX SecondMotor = new TalonFX(2);
  public final double ratio = 10.0;
  PositionVoltage request = new PositionVoltage(0);
  /** Creates a new Arm. */
  public Arm() {
    
      TalonFXConfiguration  ayar = new TalonFXConfiguration();
      ayar.Slot0.kP = 3.1;
      ayar.Slot0.kI = 0.0;
      ayar.Slot0.kD = 1.0;
      
     FirstMotor.getConfigurator().apply(ayar);
     SecondMotor.getConfigurator().apply(ayar);
  }

  public void setAngle(double rotation){
       double motorRotation = (rotation / 360.0) * ratio;
       double motorRotation2 = (rotation / 360.0) * ratio;
       FirstMotor.setControl(request.withPosition(motorRotation));
       SecondMotor.setControl(request.withPosition(motorRotation2));
    
    }
    
  public double getAngle(){
    double motorRotation = FirstMotor.getPosition().getValueAsDouble();
    double motorRotation2 = SecondMotor.getPosition().getValueAsDouble();
    double rotation = (motorRotation / ratio) * 360.0;
    double rotation2 = (motorRotation2 / ratio) * 360.0;
    return (rotation + rotation2) / 2.0;
  } 

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}

