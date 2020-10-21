package fr.noether.bank.account

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
      val expectedReport = BankReport.empty()
        .append(ReportEntry(OperationType.DEPOSIT, OperationDate.from("2020-10-14 22:32:34"), Amount.of(150), Amount.of(250)))
        .append(ReportEntry(OperationType.DEPOSIT, OperationDate.from("2020-10-22 23:33:35"), Amount.of(250), Amount.of(500)))

      assert(bankAccount.report() == expectedReport)
    }
  }
}
