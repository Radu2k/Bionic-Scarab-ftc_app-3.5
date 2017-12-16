package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.util.ElapsedTime;
import com.qualcomm.robotcore.util.Range;


public class controls extends LinearOpMode{
    //dclaring motors
    private DcMotor leftDrive = null;
    private DcMotor rightDrive = null;
    private DcMotor upDrive = null;

    //declaring tunning variables
    private double upStep=0.1; //how fast to lift the cube
    private double leftPower;
    private double rightPower;
    private double liftPower=0;
    private double powerRatio=99.0; //acceleration value the closer to 100 the faster the acceleration

    //main navigation function takes in drive as acceleration forward or backward and turn witch controls steering
    public void navigate(double drive,double turn){
        leftPower = (powerRatio*Range.clip(drive + turn, -1.0, 1.0)+(100.0-powerRatio)*leftPower)/100.0 ;
        rightPower = (powerRatio*Range.clip(drive - turn, -1.0, 1.0)+(100.0-powerRatio)*rightPower)/100.0;
        leftDrive.setPower(leftPower);
        rightDrive.setPower(rightPower);
    }
    //
    public void lifter_up(){

        upDrive.setPower(upStep);
    }

    public void lifter_down(){
        upDrive.setPower(-upStep);
    }

    public void lifter_stop(){
        upDrive.setPower(0);
    }

    //main setup phase required to set up motors
    public void runOpMode() {
        leftDrive = hardwareMap.get(DcMotor.class, "left_drive");
        rightDrive = hardwareMap.get(DcMotor.class, "right_drive");
        upDrive = hardwareMap.get(DcMotor.class, "up_drive");
        leftDrive.setDirection(DcMotor.Direction.FORWARD);
        rightDrive.setDirection(DcMotor.Direction.REVERSE);
        upDrive.setDirection(DcMotor.Direction.FORWARD);
    }
    controls(){
        runOpMode();
    }
}
