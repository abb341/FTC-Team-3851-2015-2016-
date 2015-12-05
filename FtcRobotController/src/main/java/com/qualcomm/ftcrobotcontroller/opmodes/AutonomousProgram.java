package com.qualcomm.ftcrobotcontroller.opmodes;

import com.qualcomm.robotcore.hardware.*;
import org.swerverobotics.library.*;
import org.swerverobotics.library.interfaces.*;

/**
 * A skeletal example of a do-nothing first OpMode. Go ahead and change this code
 * to suit your needs, or create sibling OpModes adjacent to this one in the same
 * Java package.
 */
@Autonomous(name="My First OpMode")
public class AutonomousProgram extends SynchronousOpMode {
/* Declare here any fields you might find useful. */
// DcMotor motorLeft = null;
// DcMotor motorRight = null;

    DcMotor arm = null;
    DcMotor lift1 = null;
    DcMotor lift2 = null;
    DcMotor intake = null;
    DcMotor drivel1 = null;
    DcMotor drivel2 = null;
    DcMotor driver1 = null;
    DcMotor driver2 = null;


    @Override public void main() throws InterruptedException
    {
/* Initialize our hardware variables. Note that the strings used here as parameters
* to 'get' must correspond to the names you assigned during the robot configuration
* step you did in the FTC Robot Controller app on the phone.
*/
// this.motorLeft = this.hardwareMap.dcMotor.get("motorLeft");
// this.motorRight = this.hardwareMap.dcMotor.get("motorRight");


        this.arm = this.hardwareMap.dcMotor.get("arm");
        this.lift1 = this.hardwareMap.dcMotor.get("lift1");
        this.lift2 = this.hardwareMap.dcMotor.get("lift2");
        this.intake = this.hardwareMap.dcMotor.get("intake");


// set motor channel modes

        arm.setChannelMode(DcMotorController.RunMode.RUN_W ITHOUT_ENCODERS) ;
        lift1.setChannelMode(DcMotorController.RunMode.RUN _WITHOUT_ENCODERS) ;
        lift2.setChannelMode(DcMotorController.RunMode.RUN _WITHOUT_ENCODERS) ;
        intake.setChannelMode(DcMotorController.RunMode.RU N_WITHOUT_ENCODERS) ;





// Wait for the game to start
        waitForStart();

// Go go gadget robot!
        while (opModeIsActive())
        {
            if (updateGamepads()) {
// The game pad state has changed. Do something with that!

                arm.setPower(0) ;

                lift1.setPower(0) ;

                lift2.setPower(0) ;

                intake.setPower(0) ;



                if (gamepad1.dpad_up)
                {
                    arm.setPower(1);
                }
                else if (gamepad1.dpad_down)
                {
                    arm.setPower(-1) ;
                }

                else if (gamepad1.y)
                {
                    lift1.setPower(1) ;
                }

                else if (gamepad1.a)
                {
                    lift1.setPower(-1);
                }

                else if (gamepad1.y)
                {
                    lift2.setPower(1);
                }

                else if (gamepad1.a)
                {
                    lift2.setPower(-1);
                }

                else if (gamepad1.x)
                {
                    intake.setPower(1);
                }

            }

            telemetry.update();
            idle();
        }
    }
}