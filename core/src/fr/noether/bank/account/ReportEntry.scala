package fr.noether.bank.account

import fr.noether.bank.account.OperationType.OperationType

case class ReportEntry(operationType: OperationType, date: OperationDate, operationAmount: Amount, balanceAmount: Amount) {

}
