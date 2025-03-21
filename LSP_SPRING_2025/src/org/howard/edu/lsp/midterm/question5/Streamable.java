package org.howard.edu.lsp.midterm.question5;

/**
 * Interface to represent streamable media content.
 * Ensures common behaviors across media types.
 */
public interface Streamable {
    void play();
    void pause();
    void stop();
}
