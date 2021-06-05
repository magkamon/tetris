package com.epam.prejap.tetris.player;

import com.epam.prejap.tetris.game.Move;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.jnativehook.GlobalScreen;
import org.jnativehook.NativeHookException;
import org.jnativehook.keyboard.NativeKeyEvent;
import org.jnativehook.keyboard.NativeKeyListener;

import java.io.PrintStream;
import java.util.Optional;
import java.util.logging.Level;

import static java.util.logging.Logger.*;

/*
 * @author Radosław Piwowarski
 * @version 1.0
 * @see https://github.com/kwhat/jnativehook
 */
public class HumanPlayer implements Player, NativeKeyListener {
    /*
     * logging facility
     */
    private static final Logger logger = LogManager.getLogger(HumanPlayer.class);
    private static final java.util.logging.Logger loggerNH = getLogger(GlobalScreen.class.getPackage().getName());
    private final PrintStream originStream = System.out;

    //todo: implement a customizable key map for a user
    private static final int MOVE_RIGHT = 'l';
    private static final int MOVE_LEFT = 'h';
    private static final int MOVE_IMMEDIATELY_TO_BOTTOM = NativeKeyEvent.VC_DOWN;

    private int currentMovement;

    @Override
    public Optional<Move> nextMove() {
        var result = switch (currentMovement) {
            case MOVE_RIGHT -> Move.RIGHT;
            case MOVE_LEFT -> Move.LEFT;
            case MOVE_IMMEDIATELY_TO_BOTTOM -> Move.TO_BOTTOM_NOW;
            default -> Move.NONE;
        };
        logger.debug("nextMove is {}", result);
        logger.debug("Value of currentMovement={}", currentMovement);
        return Optional.of(result);
    }

    /*
     * Instantiate a new <code>HumanPlayer</code> object with a native hook
     * @See GlobalScreen
     */
    public HumanPlayer() {
        try {
            loggerNH.setLevel(Level.OFF); // disable spam from JNativeHook
            System.setOut(null);
            GlobalScreen.registerNativeHook();
            GlobalScreen.addNativeKeyListener(this);
        } catch (NativeHookException e) {
            logger.error("Failed to register native hook! {}", e.getMessage());
        } finally {
            System.setOut(originStream);  //Restore sout
        }
    }

    /*
     * Release hook from register
     */
    public void killHumanPlayer() {
        try {
            GlobalScreen.unregisterNativeHook();
        } catch (NativeHookException e) {
            logger.error("Failed to unregister native hook!");
        }
    }

    /*
     * Capture pressed keys
     */
    @Override
    public void nativeKeyPressed(NativeKeyEvent nativeKeyEvent) {
        logger.info("I am pressed! {}", nativeKeyEvent.getKeyCode());
    }

    /*
     * Capture keys when released
     */
    @Override
    public void nativeKeyReleased(NativeKeyEvent nativeKeyEvent) {
        logger.info("I am released! {}", nativeKeyEvent.getKeyChar());

    }

    /*
     * Capture keys when typed, do not check if key was released or not
     */
    @Override
    public void nativeKeyTyped(NativeKeyEvent nativeKeyEvent) {
        logger.info("I am Typed! char={}, code={}",
                nativeKeyEvent.getKeyChar(),
                nativeKeyEvent.getKeyCode());
        if (nativeKeyEvent.getKeyCode() == MOVE_IMMEDIATELY_TO_BOTTOM)
            currentMovement = MOVE_IMMEDIATELY_TO_BOTTOM;
        else if (nativeKeyEvent.getKeyChar() == MOVE_RIGHT)
            currentMovement = MOVE_RIGHT;
        else if (nativeKeyEvent.getKeyChar() == MOVE_LEFT)
            currentMovement = MOVE_LEFT;
    }
}
