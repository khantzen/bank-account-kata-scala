package fr.noether.bank.account.reporting

import fr.noether.bank.account.Amount
import fr.noether.bank.account.operation.OperationDate
import fr.noether.bank.account.operation.OperationType.OperationType

case class ReportEntry(operationType: OperationType, date: OperationDate, operationAmount: Amount, balanceAmount: Amount)
