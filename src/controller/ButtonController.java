package controller;

import java.awt.Component;
import java.awt.event.ActionEvent;

import model.interfaces.GameEngine;
import view.GameFrame;

public class ButtonController extends AbstractComponentController {

	public ButtonController(Component viewComponent, GameFrame gameFrame, GameEngine gameEngine) {
		super(viewComponent, gameFrame, gameEngine);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub

	}

}
