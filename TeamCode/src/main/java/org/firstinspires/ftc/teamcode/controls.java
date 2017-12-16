package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.util.ElapsedTime;
import com.qualcomm.robotcore.util.Range;

/**
 * Created by dave on 12/16/17.
 */

public abstract class controls extends LinearOpMode{
    //dclaring motors
    private DcMotor leftDrive = null;
    private DcMotor rightDrive = null;
    private DcMotor upDrive = null;

    //main navigation function takes in drive as acceleration forward or backward and turn witch controls steering
    public void navigate(int drive,int turn){
        double leftPower = Range.clip(drive + turn, -1.0, 1.0) ;
        double rightPower = Range.clip(drive - turn, -1.0, 1.0);
        leftDrive.setPower(leftPower);
        rightDrive.setPower(rightPower);
    }

    public void lifter_up(){

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
}
