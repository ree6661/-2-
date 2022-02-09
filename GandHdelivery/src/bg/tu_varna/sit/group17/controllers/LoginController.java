package bg.tu_varna.sit.group17.controllers;

import bg.tu_varna.sit.group17.application.Load;
import bg.tu_varna.sit.group17.application.LoggerApp;
import bg.tu_varna.sit.group17.database.Login;
import bg.tu_varna.sit.group17.database.users.Consumer;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;

public final class LoginController extends ControllerParent {

	private final LoggerApp logger = new LoggerApp(getClass().getName());
	private Login login;

	@FXML
	private TextField phone, pass;

	@Override
	public void initData(Load load, Consumer consumer) {
		this.load = load;
		this.consumer = consumer;
		this.login = new Login(load);
		load.getAvatar().reset();
	}

	@FXML
	void initialize() {
		logger.info("In login form");
	}

	@FXML
	void loginFx(ActionEvent event) {
		logger.info("Clicked login");
		String phoneNumber = this.phone.getText(), password = this.pass.getText();
		login.user(phoneNumber, password);
	}
}
