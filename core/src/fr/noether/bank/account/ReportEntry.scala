package fr.noether.bank.account

import fr.noether.bank.account.operation.OperationType.OperationType
import fr.noether.bank.account.operation.OperationDate

case class ReportEntry(operationType: OperationType, date: OperationDate, operationAmount: Amount, balanceAmount: Amount) {

}
