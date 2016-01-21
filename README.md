# 01-21 Databases demo code
Code demoing dialogs and databases


## Lab Instructions
First, if you need a refresher on **SQL** (or just want to practice), I've included a [short tutorial](Optional-SQLite-Tutorial.pdf) as a `.pdf` in this repository. You are welcome to read or run through it as you feel is necessary!

Otherwise, the goal of this lab is to practice working with a ___two-pane fragment layout___, similar to what you will have to do for your homework. **Your task** is to add a ___landscape mode___ display for our Movie application so that, when in "landscape" orientation, it shows the `MovieFragment` on the left side of the screen and the `DetailFragment` (if selected) on the right side.
- IMPORTANT NOTE: you should _not_ modify the fragments for this! Fragments are self-contained and don't care where they are positioned. All you need to do is adjust the resources and the `MovieActivity`.

### 1. Check out the code
Note that you can work with the _starter code_ for today's lecture, but it's been refactored and adjusted a bit in preparation for what we'll do today. I'd recommend instead working with the code from the end of the previous lecture. You can checkout this version of the code by checking out its [git tag](https://git-scm.com/book/en/v2/Git-Basics-Tagging):
```
git checkout -b dual-pane lab-code
```
This will create a new _branch_ called `dual-pane` that you can work in, separate from the stuff we'll doin lecture.

### 2. Support the landscape configuration
You will need to add an environment-specific layout resource to your application, one that applies when the phone is in __landscape orientation__. You can use Android Studio to add this resource file, or simply create a new `res/layout` folder with the appropriate config tag (e.g., the `-something` in the name).

- Note that you can switch the emulator into _landscape orientation_ by hitting `ctrl-F11`, You can also specify that you want the emulator to launch in landscape mode by editing the virtual device configuration (`Tools > Android > AVD Manager` in Android Studio)

This resource should look a lot like the `activity_main` resource used by default, except it should have _two_ containers (e.g., `id/container_left` and `id/container_right`).


### 3. Respond to different configurations
Inside `MovieActivity`, you'll need to determine what configuration you're in so you know where to put the fragments. The recommended way to do this is to specify an **instance variable** in your `onCreate()` method (since an orientation change causes the Activity to be recreated) that determines whether the current view is `dualPane` or not.

You can determine if the current layout is dual-pane by checking whether the second _container_ view is being shown. Use `findViewById()` to look up that View, and if it exists and <a href="http://developer.android.com/reference/android/view/View.html#getVisibility()">is visible</a>, then you know you're in "dual-pane" mode.
- There are also ways to [get information about the configuration] directly, which you could use to check for a landscape orientation. However, checking for a visible view is more flexible--it allows our `Activity` to work _whenever_  there is the second container available (such as if we decided to split the view for large tablets, for example). Let the Android system handle configurations, and have your code just react to what resources it chooses to use!


### 4. Place the fragments
Now you can choose where to put the fragments. _Whenever_ you add a Fragment to the Activity, you should check for whether you are in dual-pane mode. If you are, then you should put the Fragment in its appropriate container. If you're not, then you can... still put the Fragment in its appropriate container (which is probably a different container!)

Now you should be able to switch between orientations and have your app still work, and respond with the correct layout and behavior!

### 5. Other UI Fixes
It's possible some other UI issues have popped up in the process of adding this extra functionality. If you find any problems with the user experience, spend some time looking up how to solve it! It's the best way to learn the ins-and-outs of the system.


#### References
[Implementing Adaptive UI Flows](http://developer.android.com/training/multiscreen/adaptui.html)
[Handling Runtime Changes](http://developer.android.com/guide/topics/resources/runtime-changes.html)
