Pong
===
Basic pieces of a version of Pong. I don't know that this is the best way
to approach this, but it's what I came up with during the hour that I had to
work on it.

Some notes:
* `Pong` is the JFrame that owns the JMenuBar (if we add one) and the PongPanel
* `PongPanel` is just the JPanel that paints the game scene. We pass in the two paddles and the ball. I'm not sure if the paddles and the ball should actually be passed in, or just fully encapsulated by the PongPanel. Maybe the Timer itself (next bullet) should also be in the PongPanel? I would understand more if I had some more time to work on this.
* `Timer` in Pong updates every 40 ms and redraws the screen. This can be paused or restarted with the spacebar. It would be cool to be change that number, to make the ball more faster or slower.
* The `Paddle` and `Ball` classes extend java.awt.Rectangle so that I could get the `intersects()` method. I am not sure if it would have been better to use encapsulation and then make my own interface. So, this may have been a hack!

TODO:
* Add a wall to the top and bottom, detect intersections with the ball, and bounce/reflect the ball as appropriate. The walls can probably just be other subclasses of Rectangle.
* Add "goals" (i.e. other walls) to the left and right side of the screen for scoring
* Move the paddles up and down
* Change the velocity of the ball, based on whether the paddle is moving when it hits the ball
* Lots of other things! There is a lot more that can be done with this.