# ConstraintLayout-Keyframe-animations
ConstraintLayout Keyframe animations example

**How this works?**

Constraint Keyframe animation is not about changing layout.
It just get the ConstraintSet from target layout and apply it to current layout.
In this case, every child view in two layouts must have an id and the id needs to be the same.

Note: Only the constraint attributes are animated such as positions. Other attributes such as color, font size are not applied.

![screenrecord](/gif/keyframe-animations.gif)
