package io.slack.blockchain.commons.configurations.slack;

import static com.github.seratch.jslack.api.model.dialog.DialogSubType.EMAIL;
import static com.github.seratch.jslack.api.model.dialog.DialogSubType.NUMBER;
import static io.slack.blockchain.commons.configurations.slack.BeanConfigurationConstants.AMOUNT_DIALOG_TEXT_ELEMENT;
import static io.slack.blockchain.commons.configurations.slack.BeanConfigurationConstants.EMAIL_DIALOG_TEXT_ELEMENT;
import static io.slack.blockchain.interactive.components.dialogs.elements.constants.ConfigurationDetailsConstants.EMAIL_ELEMENT_PLACEHOLDER;
import static io.slack.blockchain.interactive.components.dialogs.elements.constants.ConfigurationDetailsConstants.EMAIL_LABEL;
import static io.slack.blockchain.interactive.components.dialogs.elements.constants.ConfigurationDetailsConstants.EMAIL_MAX_LENGHTH;
import static io.slack.blockchain.interactive.components.dialogs.elements.constants.TransactionDialogTextElementConstants.AMOUNT_ELEMENT_PLACEHOLDER;
import static io.slack.blockchain.interactive.components.dialogs.elements.constants.TransactionDialogTextElementConstants.AMOUNT_LABEL;
import static io.slack.blockchain.interactive.components.dialogs.elements.constants.TransactionDialogTextElementConstants.TEXT_ELEMENT_MAX_ELEMENT_LENGTH;
import static io.slack.blockchain.interactive.components.dialogs.elements.constants.TransactionSelectElementConstants.CURRENCY_ELEMENT_LABEL;
import static io.slack.blockchain.interactive.components.dialogs.elements.constants.TransactionSelectElementConstants.CURRENCY_ELEMENT_PLACEHOLDER;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.github.seratch.jslack.Slack;
import com.github.seratch.jslack.api.model.dialog.DialogSelectElement;
import com.github.seratch.jslack.api.model.dialog.DialogTextElement;

import io.slack.blockchain.interactive.components.dialogs.elements.UsersSelectElementFactory;
import io.slack.blockchain.interactive.components.dialogs.utils.CurrencyProvider;

@Configuration
public class SlackConfiguration {
	@Bean
	public Slack createSlack() {
		return Slack.getInstance();
	}

	@Bean(name = AMOUNT_DIALOG_TEXT_ELEMENT)
	public DialogTextElement createAmountDialogTextElement() {
		return DialogTextElement.builder().label(AMOUNT_LABEL).name(AMOUNT_LABEL.toLowerCase())
				.placeholder(AMOUNT_ELEMENT_PLACEHOLDER).maxLength(TEXT_ELEMENT_MAX_ELEMENT_LENGTH).subtype(NUMBER)
				.build();
	}

	@Bean(name = EMAIL_DIALOG_TEXT_ELEMENT)
	public DialogTextElement createEmailDialogTextElement() {
		return DialogTextElement.builder().label(EMAIL_LABEL).name(EMAIL_LABEL.toLowerCase())
				.placeholder(EMAIL_ELEMENT_PLACEHOLDER).maxLength(EMAIL_MAX_LENGHTH).subtype(EMAIL).build();
	}

	@Bean
	public DialogSelectElement createCurrencySelectElement(final CurrencyProvider currencyProvider) {
		return DialogSelectElement.builder().name(CURRENCY_ELEMENT_LABEL.toLowerCase()).label(CURRENCY_ELEMENT_LABEL)
				.placeholder(CURRENCY_ELEMENT_PLACEHOLDER).options(currencyProvider.provideSupportedCurrencies())
				.build();
	}

	@Bean
	public CurrencyProvider createCurrencyProvider() {
		return new CurrencyProvider();
	}

	@Bean
	public UsersSelectElementFactory createUsersSelectElementFactory() {
		return new UsersSelectElementFactory();
	}
}
