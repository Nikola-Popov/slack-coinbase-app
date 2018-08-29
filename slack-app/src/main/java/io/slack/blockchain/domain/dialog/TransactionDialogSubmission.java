package io.slack.blockchain.domain.dialog;

import io.slack.blockchain.commons.miscellaneous.trading.Currency;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class TransactionDialogSubmission extends DialogSubmission {
	private int amount;
	private Currency currency;
	private String user;
	private String responseUrl;
}
