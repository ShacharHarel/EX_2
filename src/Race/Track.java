package Race;

public class Track {
    private static int finshedRaces=0;
    public synchronized void raceFinished(){
        finshedRaces++;
    }
    public synchronized int getFinshedRaces(){
        return finshedRaces;
    }
}
