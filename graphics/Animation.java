package graphics;

import java.awt.image.BufferedImage;

public class Animation {

    private BufferedImage[] frames;
     private int currentFrame;
     private int numFrames;

     private int count;
     private int delay;

     private int timesPlayed;

     public Animation(BufferedImage[] frames) {

         timesPlayed = 0;
         setFrames(frames);
     }

     public Animation() {
         timesPlayed = 0;
     }

     public void setFrames(BufferedImage[] frames) {

         this.frames = frames;
         currentFrame = 0;
         count = 0;
         timesPlayed = 0;
         delay = 2; // time between movements
         numFrames = frames.length;
     }

     public void setDelay( int delay ) {
         this.delay = delay;
     }

     public void setFrame( int currentFrame ) {
         this.currentFrame = currentFrame;
     }

     public void setNumFrames( int numFrames ) {
         this.numFrames = numFrames;
     }

     public void update() {

         if ( delay == - 1 ) {
             return;
         }

         count++;

         if ( count == delay ) {
             currentFrame++;
             count = 0;
         }

         if ( currentFrame == numFrames ) {
             currentFrame = 0;
             timesPlayed++;
         }
     }

     public int getDelay() {
         return this.delay;
     }

     public int getFrame() {
         return currentFrame;
     }

     public int getCount() {
         return this.count;
     }

     public BufferedImage getImage() {
         return frames[currentFrame];
     }

     public boolean hasPlayedOnce() {
         return timesPlayed > 0;
     }

     public boolean hasPlayed(int i) {
         return timesPlayed == i;
     }




}
