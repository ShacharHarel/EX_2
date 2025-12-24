//Haim Guetta- 209500585 ,Shahar Harel-211869490
package Race;

public class Track {
    private int finshedRaces=0;
    public synchronized void raceFinished(){
        finshedRaces++;
    }
    public synchronized int getFinshedRaces(){
        return finshedRaces;
    }
}
