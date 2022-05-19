## How to use NativeKeyListener from JNativeHook

The NativeKeyListener interface combined with a GlobalScreen allows us to monitor key events beyond the normal scope of a Java application.

JNativeHook allows for a global key listener to be implemented. Java does have its own `KeyListener` interface https://docs.oracle.com/javase/7/docs/api/java/awt/event/KeyListener.html
but, this interface will only work within the Java window and not globally.

### Introduction
In order to use JNativeHook to track keyboard events:

- Get the JNativeHook jar and add that dependency to your project.
- Create a class to listen for keyboard events. This class must implement `NativeKeyListener`
- Optional (but not really): Override the default interface methods to provide implementation
    - `public void nativeKey<ACTION>>(NativeKeyEvent nativeEvent) {`
        - This `nativeEvent` will have information about the event such as `rawCode`, `keyCode`, and `keyChar`. You can
          use these values to do simple actions such as, `if(nativeEvent.getKeyCode()...)` call a method. This would have the functionality
          of calling a method simply by pressing a key anywhere at any time.
- Add your new class that implements `NativeKeyListener` to be registered by the `GlobalScreen`
    - This is what allows the program to listen for key inputs outside the normal scope of Java's implemented listeners.
    - Default implementation is:
        ```
        try {
            GlobalScreen.registerNativeHook();
        }
        catch (NativeHookException ex) {
            System.err.println("There was a problem registering the native hook.");
            System.err.println(ex.getMessage());

            // Terminate the program with the error printed if registration failed.
            System.exit(1);
        }
        GlobalScreen.addNativeKeyListener(new ClassName());
        ```
      replacing new ClassName() with the name of the class you are implementing the listener in.

### Examples
I am a fan of defining a class to initialize my keyboard listener, and providing helper methods within that class for additional functionality.
