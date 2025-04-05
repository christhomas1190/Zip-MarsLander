public class Vehicle {
    int altitude= 8000;
    int prevAltitude= 8000;
    int velocity= 1000;
    int fuel = 12000;
    int burn = 0;
    int flying = FLYING;

    public Vehicle(int InitialAltitude) {
        // initialize the altitude AND previous altitude to initialAltitude
        altitude=InitialAltitude;
         prevAltitude=InitialAltitude;

    }

    int gravity = 100;
    /* The rate in which the spaceship descents in free fall (in ten seconds) */

    // Various end-of-game messages and status result codes.
    String dead = "\nCRASH!!\n\tThere were no survivors.\n\n";
    public static final int DEAD = -3;
    String crashed = "\nThe Starship crashed. Good luck getting back home. Elon is pissed.\n\n";
    public static final int CRASHED = -2;
    String emptyfuel = "\nThere is no fuel left. You're floating around like Major Tom.\n\n";
    public static final int EMPTYFUEL = -1;
    String success = "\nYou made it! Good job!\n\n";
    public static final int SUCCESS = 0;
    public static final int FLYING = 1;


    public Vehicle() {
        int altitude= 8000;
        int prevAltitude= 8000;
        int velocity= 1000;
        int fuel = 12000;
        int burn = 0;
        int flying = FLYING;}

    public String checkFinalStatus() {
        String s = "";
        if (this.altitude <= 0) {
            if (this.velocity > 10) {
                s = dead;
                flying = DEAD;
            }
            if (this.velocity < 10 && this.velocity > 3) {
                s = crashed;
                flying = CRASHED;
            }
            if (this.velocity < 3) {
                s = success;
                flying = SUCCESS;
            }
        } else {
            if (this.altitude > 0) {
                s = emptyfuel;
                flying = EMPTYFUEL;
            } }
        return s;
    }

    public int computeDeltaV() {
        // return velocity + gravity - burn amount
        return velocity +gravity - burn;
    }

    public void adjustForBurn(int burnAmount) {
        // set burn to burnamount requested
        // save previousAltitude with current Altitude
        // set new velocity to result of computeDeltaV function.
        // subtract speed from Altitude
        // subtract burn amount fuel used from tank
        burn=burnAmount;
        prevAltitude=altitude;
        velocity=computeDeltaV();
        altitude-=velocity;
        fuel-=burnAmount;
    }

    public boolean stillFlying() {
        if(altitude>0){
            return true;
        }else{
        return false;}
    }
    public boolean outOfFuel() {
        if(fuel<=0){
            return true;
        }else{
            return false;}
    }

    public DescentEvent getStatus(int tick) {
        // create a return a new DescentEvent object
        // filled in with the state of the vehicle.
        DescentEvent descentEvent=new DescentEvent(burn, altitude,fuel,velocity,prevAltitude);
        return descentEvent;
    }

}
