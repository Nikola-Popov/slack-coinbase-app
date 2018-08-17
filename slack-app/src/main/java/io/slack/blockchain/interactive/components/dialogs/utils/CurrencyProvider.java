package io.slack.blockchain.interactive.components.dialogs.utils;

import static io.slack.blockchain.commons.miscellaneous.trading.Currency.BCH;
import static io.slack.blockchain.commons.miscellaneous.trading.Currency.BTC;
import static io.slack.blockchain.commons.miscellaneous.trading.Currency.ETC;
import static io.slack.blockchain.commons.miscellaneous.trading.Currency.GBP;
import static io.slack.blockchain.commons.miscellaneous.trading.Currency.USD;
import static java.util.Arrays.asList;

import java.util.List;

import com.github.seratch.jslack.api.model.dialog.DialogOption;

public class CurrencyProvider {
	public List<DialogOption> provideSupportedCurrencies() {
		return (asList(DialogOption.builder().label(USD.toString()).value(USD.toString()).build(),
				DialogOption.builder().label(GBP.toString()).value(GBP.toString()).build(),
				DialogOption.builder().label(BTC.toString()).value(BTC.toString()).build(),
				DialogOption.builder().label(BCH.toString()).value(BCH.toString()).build(),
				DialogOption.builder().label(ETC.toString()).value(ETC.toString()).build()));
	}
}
