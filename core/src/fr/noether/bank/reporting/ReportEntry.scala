package fr.noether.bank.reporting

import fr.noether.bank.account.Amount
import fr.noether.bank.operation.OperationType.OperationType
import fr.noether.bank.operation.OperationDate

case class ReportEntry(operationType: OperationType, date: OperationDate, operationAmount: Amount, balanceAmount: Amount)
