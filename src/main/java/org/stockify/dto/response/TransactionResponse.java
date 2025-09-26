package org.stockify.dto.response;

import lombok.Value;
import org.stockify.model.enums.PaymentMethod;
import org.stockify.model.enums.TransactionType;
import io.swagger.v3.oas.annotations.media.Schema;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Set;

@Value
public class TransactionResponse {

    @Schema(description = "Unique identifier of the transaction", example = "1")
    Long id;

    @Schema(description = "Total amount of the transaction", example = "150.50")
    BigDecimal total;

    @Schema(description = "Date and time when the transaction was made", example = "2025-06-15T14:30:00")
    LocalDateTime dateTime;

    @Schema(description = "Payment method used in the transaction", example = "CASH")
    PaymentMethod paymentMethod;

    @Schema(description = "Description or notes about the transaction", example = "Paid by credit card")
    String description;

    @Schema(description = "Type of the transaction", example = "SALE")
    TransactionType type;


    @Schema(description = "Name of the store where the transaction took place", example = "Downtown Store")
    String storeName;

    @Schema(description = "Set of detailed transactions")
    Set<DetailTransactionResponse> detailTransactions;
}
