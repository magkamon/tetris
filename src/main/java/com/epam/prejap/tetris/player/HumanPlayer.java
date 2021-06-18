package com.epam.prejap.tetris.player;

import com.epam.prejap.tetris.game.Move;
import org.jnativehook.GlobalScreen;
import org.jnativehook.NativeHookException;
import org.jnativehook.keyboard.NativeKeyEvent;
import org.jnativehook.keyboard.NativeKeyListener;

import java.util.Optional;
import java.util.logging.Level;

import static java.util.logging.Logger.getLogger;

/*
 * @author Radosław Piwowarski
 * @version 1.0
 * @see https://github.com/kwhat/jnativehook
 */
public class HumanPlayer implements Player, NativeKeyListener {
    /*
     * @see nextMove()
     */
    private int currentMovement;

    /*
     * @see interface Player
     */
    @Override
    public Optional<Move> nextMove() {
        var result = mapMoveToKey(currentMovement);
        currentMovement = 0;
        return Optional.of(result);
    }

    Move mapMoveToKey(int key) {
        return Move.of(key);
    }

    /*
     * Instantiate a new <code>HumanPlayer</code> object with a native hook
     * @see GlobalScreen
     */
    public HumanPlayer() {
        var loggerNH = getLogger(GlobalScreen.class.getPackage().getName()); // just to suspend spammer
        try {
            loggerNH.setLevel(Level.OFF); // disable spam from JNativeHook
            GlobalScreen.registerNativeHook();
            GlobalScreen.addNativeKeyListener(this);
        } catch (NativeHookException e) {
            System.err.println("Count not register native hook!");
        }
    }

    /*
     * Release hook from register
     * HumanPlayer can not take any action without registered hook, so
     * instance is as good as dead
     */
    public void killHumanPlayer() {
        try {
            GlobalScreen.unregisterNativeHook();
        } catch (NativeHookException e) {
            System.err.println("Could not unregister hook!");
        }
    }

    /*
     * Capture pressed keys
     */
    @Override
    public void nativeKeyPressed(NativeKeyEvent nativeKeyEvent) {
        /*
         * Not need to distinguish between pressed/released/typed
         */
    }

    /*
     * Capture keys when released
     */
    @Override
    public void nativeKeyReleased(NativeKeyEvent nativeKeyEvent) {
        /*
         * Not need to distinguish between pressed/released/typed
         */
    }

    /*
     * Capture keys when typed, do not check if key was released or not
     */
    @Override
    public void nativeKeyTyped(NativeKeyEvent nativeKeyEvent) {
        if (Move.of(nativeKeyEvent.getKeyChar()) != Move.NONE) {
            currentMovement = nativeKeyEvent.getKeyChar();
        }
    }
}
