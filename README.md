# Flip Animation

An example of how to use the [ObjectAnimator](https://developer.android.com/reference/android/animation/ObjectAnimator) class to create a flip animation. What we do in this example is we scale the x axis from the current value to zero to simulate a fliping motion.

## Implemmentation

We must create am using the following [ofFloat](https://developer.android.com/reference/android/animation/ObjectAnimator#ofFloat(java.lang.Object,%20java.lang.String,%20float...)) static method:

```java
public static ObjectAnimator ofFloat (Object target, String propertyName, float... values)
```

To this method we pass some paramethers:

<b>target:</b> the view that we are going to animate (in or case, an ImageView).

<b>propertyName:</b> a string representing the animation name that we are going to use (in or case "scaleX").

<b>values:</b> the scales we are going to make on our image view (in our case, we pass 1f and 0d so it can scale from the actual size of the imageview (1f) to a zero width view (0f)).

You can also add some interpolators (such as DecelerateInterpolator() or AccelerateDecelerateInterpolator() to make an interpolation in the animation like so:

```kotlin
startAnim.interpolator = DecelerateInterpolator()
endAnim.interpolator = AccelerateDecelerateInterpolator()
```

To start our animation, all we have to do is to class start() on our ObjectAnimator object like so:

```kotlin
startAnim.start()
```

We can also add a listener to our ObjectAnimator to setup a callback when the animation ends:

```kotlin
startAnim.addListener(object : AnimatorListenerAdapter() {
    override fun onAnimationEnd(animation: Animator) {
        super.onAnimationEnd(animation)
        // do somehting when animation ends
    }
})
```
