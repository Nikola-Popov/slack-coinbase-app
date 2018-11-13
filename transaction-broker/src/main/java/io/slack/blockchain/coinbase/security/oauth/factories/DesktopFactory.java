package io.slack.blockchain.coinbase.security.oauth.factories;

import static java.awt.Desktop.getDesktop;

import java.awt.Desktop;

import org.springframework.stereotype.Component;

@Component
public class DesktopFactory {
	public Desktop createDesktop() {
		return getDesktop();
	}
}
