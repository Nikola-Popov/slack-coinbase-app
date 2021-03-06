package io.slack.blockchain.commons.configurations.beans;

import static com.github.seratch.jslack.api.model.dialog.DialogSubType.EMAIL;
import static com.github.seratch.jslack.api.model.dialog.DialogSubType.NUMBER;
import static io.slack.blockchain.commons.configurations.BeanConfigurationConstants.AMOUNT_DIALOG_TEXT_ELEMENT;
import static io.slack.blockchain.commons.configurations.BeanConfigurationConstants.CURRENCY_SELECT_DIALOG_TEXT_ELEMENT;
import static io.slack.blockchain.commons.configurations.BeanConfigurationConstants.EMAIL_DIALOG_TEXT_ELEMENT;
import static io.slack.blockchain.interactive.components.dialogs.elements.constants.configuration.EmailConfigurationDialogTextElementConstants.EMAIL_ELEMENT_PLACEHOLDER;
import static io.slack.blockchain.interactive.components.dialogs.elements.constants.configuration.EmailConfigurationDialogTextElementConstants.EMAIL_LABEL;
import static io.slack.blockchain.interactive.components.dialogs.elements.constants.configuration.EmailConfigurationDialogTextElementConstants.EMAIL_MAX_LENGHTH;
import static io.slack.blockchain.interactive.components.dialogs.elements.constants.configuration.EmailConfigurationDialogTextElementConstants.EMAIL_NAME;
import static io.slack.blockchain.interactive.components.dialogs.elements.constants.transaction.AmountDialogTextElementConstants.AMOUNT_ELEMENT_PLACEHOLDER;
import static io.slack.blockchain.interactive.components.dialogs.elements.constants.transaction.AmountDialogTextElementConstants.AMOUNT_LABEL;
import static io.slack.blockchain.interactive.components.dialogs.elements.constants.transaction.AmountDialogTextElementConstants.AMOUNT_NAME;
import static io.slack.blockchain.interactive.components.dialogs.elements.constants.transaction.AmountDialogTextElementConstants.TEXT_ELEMENT_MAX_ELEMENT_LENGTH;
import static io.slack.blockchain.interactive.components.dialogs.elements.constants.transaction.CurrencyDialogSelectElementConstants.CURRENCY_ELEMENT_LABEL;
import static io.slack.blockchain.interactive.components.dialogs.elements.constants.transaction.CurrencyDialogSelectElementConstants.CURRENCY_ELEMENT_NAME;
import static io.slack.blockchain.interactive.components.dialogs.elements.constants.transaction.CurrencyDialogSelectElementConstants.CURRENCY_ELEMENT_PLACEHOLDER;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.github.seratch.jslack.api.methods.request.dialog.DialogOpenRequest;
import com.github.seratch.jslack.api.methods.request.dialog.DialogOpenRequest.DialogOpenRequestBuilder;
import com.github.seratch.jslack.api.model.dialog.Dialog;
import com.github.seratch.jslack.api.model.dialog.Dialog.DialogBuilder;
import com.github.seratch.jslack.api.model.dialog.DialogOption;
import com.github.seratch.jslack.api.model.dialog.DialogOption.DialogOptionBuilder;
import com.github.seratch.jslack.api.model.dialog.DialogSelectElement;
import com.github.seratch.jslack.api.model.dialog.DialogTextElement;

import io.slack.blockchain.interactive.components.dialogs.utils.CurrencyProvider;

@Configuration
public class DialogConfigurations {
	@Bean(name = AMOUNT_DIALOG_TEXT_ELEMENT)
	public DialogTextElement createAmountDialogTextElement() {
		return DialogTextElement.builder().label(AMOUNT_LABEL).name(AMOUNT_NAME).placeholder(AMOUNT_ELEMENT_PLACEHOLDER)
				.maxLength(TEXT_ELEMENT_MAX_ELEMENT_LENGTH).subtype(NUMBER).build();
	}

	@Bean(name = EMAIL_DIALOG_TEXT_ELEMENT)
	public DialogTextElement createEmailDialogTextElement() {
		return DialogTextElement.builder().label(EMAIL_LABEL).name(EMAIL_NAME).placeholder(EMAIL_ELEMENT_PLACEHOLDER)
				.maxLength(EMAIL_MAX_LENGHTH).subtype(EMAIL).build();
	}

	@Bean(name = CURRENCY_SELECT_DIALOG_TEXT_ELEMENT)
	public DialogSelectElement createCurrencySelectElement(final CurrencyProvider currencyProvider) {
		return DialogSelectElement.builder().name(CURRENCY_ELEMENT_NAME).label(CURRENCY_ELEMENT_LABEL)
				.placeholder(CURRENCY_ELEMENT_PLACEHOLDER).options(currencyProvider.provideSupportedCurrencies())
				.build();
	}

	@Bean
	public DialogBuilder createDialogBuilder() {
		return Dialog.builder();
	}

	@Bean
	public DialogOpenRequestBuilder createDialogOpenRequestBuilder() {
		return DialogOpenRequest.builder();
	}

	@Bean
	public DialogOptionBuilder createDialogOptionBuilder() {
		return DialogOption.builder();
	}

}
