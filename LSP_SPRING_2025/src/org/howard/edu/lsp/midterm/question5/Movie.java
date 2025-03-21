package org.howard.edu.lsp.midterm.question5;

/**
 * Movie class implementing Streamable behavior and unique method.
 */
public class Movie implements Streamable {
    private String title;

    public Movie(String title) {
        this.title = title;
    }

    @Override
    public void play() {
        System.out.println("Playing movie: " + title);
    }

    @Override
    public void pause() {
        System.out.println("Paused movie: " + title);
    }

    @Override
    public void stop() {
        System.out.println("Stopped movie: " + title);
    }

    // Unique Movie method
    public void rewind(int minutes) {
        System.out.println("Rewinding movie: " + title + " by " + minutes + " minutes");
    }
}
