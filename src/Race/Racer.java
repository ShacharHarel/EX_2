package Race;

public class Racer implements Runnable {
    private static int globalId =1;
    private int id;
    private int speed;
    private Track track;

    public Racer(int speed, Track track) {
        this.track = track;
        if(speed<1|| speed>10) throw new IllegalArgumentException("Speed must be between 1 and 10");
        this.speed = speed;
        this.id = globalId;
        globalId++;
    }

    public void go() {
        Thread.currentThread().setPriority(speed);
        for (int i=1; i<=100; i++){
            System.out.println("Runner " + id + " ran " + i + " meters");

            if (i==100){
                int place;
                synchronized (track) {
                    track.raceFinished();
                    place = track.getFinshedRaces();
                }
                    if (place == 1) System.out.println("Runner " + id + " finished 1st");
                    else if (place == 2) System.out.println("Runner " + id + " finished 2nd");
                    else if (place == 3) System.out.println("Runner " + id + " finished 3rd");
                    else System.out.println("Runner " + id + " finished " + place + "th");

            }

        }
    }
    public void run() {
        go();
    }

}
