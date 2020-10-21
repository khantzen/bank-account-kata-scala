package fr.noether.bank

import fr.noether.bank.account.{Amount, BankAccount}
import fr.noether.bank.operation.OperationType
import fr.noether.bank.reporting.BankReport
import fr.noether.bank.operation.{OperationDate, OperationType}
import fr.noether.bank.reporting.{BankReport, ReportEntry}
import org.scalatest.GivenWhenThen
import org.scalatest.funspec.AnyFunSpec

class HistoryReport
  extends AnyFunSpec
    with GivenWhenThen {

  describe("History report should relate on the bank account balance evolution according to the operation") {
    it("A bank account with only deposit") {
      Given("A bank account starting with 100")
      var bankAccount = BankAccount.startsWith(Amount.of(100))
      When("Deposit are made")
      bankAccount = bankAccount
        .deposit(Amount.of(150), OperationDate.from("2020-10-14 22:32:34"))
        .deposit(Amount.of(250), OperationDate.from("2020-10-22 23:33:35"))
      Then("Report should contains the two deposits with their date and amount at that moment")
      val expectedReport = BankReport.withInitialAmount(Amount.of(100))
        .append(ReportEntry(OperationType.DEPOSIT, OperationDate.from("2020-10-14 22:32:34"), Amount.of(150), Amount.of(250)))
        .append(reporting.ReportEntry(OperationType.DEPOSIT, OperationDate.from("2020-10-22 23:33:35"), Amount.of(250), Amount.of(500)))

      assert(bankAccount.report() == expectedReport)
    }

    it("A bank account with withdrawals and deposit") {
      Given("A bank account starting with 1000")
      var bankAccount = BankAccount.startsWith(Amount.of(1000))
      When("Operation are made")
      bankAccount = bankAccount
        .withdraw(Amount.of(1500), OperationDate.from("2020-10-10 21:32:15"))
        .deposit(Amount.of(1100), OperationDate.from("2020-10-11 12:12:12"))
      Then("Report should contains the operations with their date and amount at that moment")
      val expectedReport = BankReport.withInitialAmount(Amount.of(1000))
        .append(reporting.ReportEntry(OperationType.WITHDRAWAL, OperationDate.from("2020-10-10 21:32:15"),
          Amount.of(1500), Amount.of(-500)))
        .append(reporting.ReportEntry(OperationType.DEPOSIT, OperationDate.from("2020-10-11 12:12:12"), Amount.of(1100), Amount.of(600)))

      assert(bankAccount.report() == expectedReport)
    }

    it("Bank report should refer on the operation date to calculate the different amounts") {
      Given("A bank account starting with 100")
      var bankAccount = BankAccount.startsWith(Amount.of(1000))
      When("Deposit and withdraw are stored made with non sorted date")
      bankAccount = bankAccount
        .deposit(Amount.of(150), OperationDate.from("2020-10-09 20:32:10"))
        .withdraw(Amount.of(120), OperationDate.from("2013-10-09 20:32:10"))
        .deposit(Amount.of(500), OperationDate.from("2015-10-09 20:32:10"))
      Then("Report should contains the operation in the correct order following operation date")
      val expectedReport = BankReport.withInitialAmount(Amount.of(1000))
        .append(reporting.ReportEntry(OperationType.WITHDRAWAL, OperationDate.from("2013-10-09 20:32:10"), Amount.of(120), Amount.of(880)))
        .append(reporting.ReportEntry(OperationType.DEPOSIT, OperationDate.from("2015-10-09 20:32:10"), Amount.of(500), Amount.of(1380)))
        .append(reporting.ReportEntry(OperationType.DEPOSIT, OperationDate.from("2020-10-09 20:32:10"), Amount.of(150), Amount.of(1530)))

      assert(bankAccount.report() == expectedReport)
    }

  }
}
