# ConstraintLayout-Keyframe-animations Example

**How this works?**

Constraint Keyframe animation is not about changing layout.
It just get the ConstraintSet from target layout and apply it to current layout.
In this case, every child view in two layouts must have an id and the id needs to be the same.

Note: Only the constraint attributes are animated such as positions. Other attributes such as color, font size are not applied.

**Code**

```kotlin
  // custom transition
  val transition = ChangeBounds()
  transition.interpolator = AnticipateOvershootInterpolator(1.0f)
  transition.duration = 1000

  val constraintSet = ConstraintSet()
  constraintSet.clone(requireContext(), targetLayoutId)
  
  // ConstraintLayout from current layout
  val constraintLayout = binding.constraintLayout

  TransitionManager.beginDelayedTransition(constraintLayout, transition)
  constraintSet.applyTo(constraintLayout)
```

**Demo**

![screenrecord](/gif/keyframe-animations.gif)

**Resource**
https://developer.android.com/develop/ui/views/layout/constraint-layout#keyframe_animations
