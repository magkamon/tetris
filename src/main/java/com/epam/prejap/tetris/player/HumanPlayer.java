package com.epam.prejap.tetris.player;

import com.epam.prejap.tetris.game.Move;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.jnativehook.GlobalScreen;
import org.jnativehook.NativeHookException;
import org.jnativehook.keyboard.NativeKeyEvent;
import org.jnativehook.keyboard.NativeKeyListener;

import java.util.Optional;

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

    //todo: implement a customizable key map for a user
    private static final String MOVE_RIGHT = "l";
    private static final String MOVE_LEFT = "h";
    private static final String MOVE_IMMEDIATELY_TO_BOTTOM = "d";


    @Override
    public Optional<Move> nextMove() {

            return Optional.empty();

    }

    /*
     * Instantiate a new <code>HumanPlayer</code> object with a native hook
     * @See GlobalScreen
     */
    public HumanPlayer() {
        try {
            GlobalScreen.registerNativeHook();
        } catch (NativeHookException e) {
            logger.error("Failed to register native hook! {}", e.getMessage());
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
        logger.info("I am pressed! {}", nativeKeyEvent.getKeyChar());
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
        logger.info("I am Typed! {}", nativeKeyEvent.getKeyChar());
    }
}
