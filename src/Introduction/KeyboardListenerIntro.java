package Introduction;

import com.github.kwhat.jnativehook.GlobalScreen;
import com.github.kwhat.jnativehook.NativeHookException;
import com.github.kwhat.jnativehook.keyboard.NativeKeyEvent;
import com.github.kwhat.jnativehook.keyboard.NativeKeyListener;

    // In order to "listen" to the keyboard activity, the class MUST implement NativeKeyListener.
    // It would be clean to have individual listeners (i.e. Keyboard, Mouse) dedicated to their own classes.
public class KeyboardListenerIntro implements NativeKeyListener {
    // Remember to add the "libs" folder to your dependencies module.

    public static void main(String[] args) {
        // Creating an object of the class to call methods from a non-static context.
        KeyboardListenerIntro keyboardIntro = new KeyboardListenerIntro();
        keyboardIntro.startListener();
    }

    // Helper method to start the keyboard listener.
    // This could instead be implemented inside a "main" method, but I like doing it this way.
    private void startListener() {
        // Attempt to register the "NativeHook" that will monitor the keyboard.
        try {
            GlobalScreen.registerNativeHook();
        }
        catch (NativeHookException ex) {
            System.err.println("There was a problem registering the native hook.");
            System.err.println(ex.getMessage());

            // Terminate the program with the error printed if registration failed.
            System.exit(1);
        }

        /*
         From javadoc:
         "Adds the specified native key listener to receive key events from the native system.
         If listener is null, no exception is thrown and no action is performed."
         Must take an object of the class it is creating the listener from. Its parameter
         requires a "NativeKeyListener" object (so it can pass the output to methods like nativeKeyPressed())

         If doing it this way, you can either put "this" or new ClassName() as the parameter
         If doing it in the main method, you must pass new ClassName() to avoid static -> non static annoyances.
        */
        GlobalScreen.addNativeKeyListener(this);
    }

    // Just a useful method to know. Combining this with GlobalScreen.isNativeHookRegistered() will give the ability
    // To add a "stop key" to the listener, where if NativeKeyEvent is specificKey, the hook is unregistered (and stops listening).
    private void stopListener() throws NativeHookException {
        GlobalScreen.unregisterNativeHook();
    }


    // Please read the top level synopsis found https://docs.oracle.com/javase/7/docs/api/java/awt/event/KeyEvent.html
    // By registering the NativeHook at the GlobalScreen level, we give Java access to KeyEvents outside of normal restrictions.

    @Override
    // The KeyPressed and KeyReleased methods will always return a KeyCode. The KeyChar will always be undefined.
    // In this case, we are using the static method getKeyText() to convert the output of the object getKeyCode()
    // This is consistent with the Java KeyEvent class.
    public void nativeKeyPressed(NativeKeyEvent nativeEvent) {
        // NOTE: Returned keyText is for individual keys, for example shift + 1 will show shift + 1, NOT ! even if ! is typed.
        //System.out.println("KeyPressed: " + NativeKeyEvent.getKeyText(nativeEvent.getKeyCode()));
    }

    @Override
    // The KeyPressed and KeyReleased methods will always return a KeyCode. The KeyChar will always be undefined.
    // In this case, we are using the static method getKeyText() to convert the output of the object getKeyCode()
    // This is consistent with the Java KeyEvent class.
    public void nativeKeyReleased(NativeKeyEvent nativeEvent) {
        //System.out.println("KeyReleased: " + NativeKeyEvent.getKeyText(nativeEvent.getKeyCode()));
    }

    @Override
    // The KeyTyped will have a RawCode and KeyChar, but NOT a KeyCode. This is consistent with the Java KeyEvent class.
    // This is consistent with the Java KeyEvent class.
    public void nativeKeyTyped(NativeKeyEvent nativeEvent) {
        // NOTE: Returned keyText is for individual keys, for example shift + 1 will show shift + 1, NOT ! even if ! is typed.
        System.out.println("KeyTyped: " + nativeEvent.getKeyChar());
    }
}
