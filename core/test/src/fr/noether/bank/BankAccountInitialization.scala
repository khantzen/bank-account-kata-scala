package fr.noether.bank

import fr.noether.bank.account.{Amount, BankAccount}
import org.scalatest.GivenWhenThen
import org.scalatest.funspec.AnyFunSpec

class BankAccountInitialization
  extends AnyFunSpec
    with GivenWhenThen {

  describe("An account should start with an initiated amount") {
    it("Account with 0 should start at 0") {
      Given("A fresh Account")
      val bankAccount = BankAccount.freshAccount()
      Then("This account amount should be 0")
      assert(bankAccount.total() == Amount.ZERO)
    }

    it("Account with given amount 7527.75 should start with amount of 7527.75") {
      Given("Account with amount 7527.75")
      val bankAccount = BankAccount.startsWith(Amount.of(7527.75))
      Then("This account Amount should be 7527.75")
      assert(bankAccount.total() == Amount.of(7527.75))
    }

    it("Account with given amount 852.21 should start with amount of 852.21") {
      Given("Account with amount 852.21 ")
      val bankAccount = BankAccount.startsWith(Amount.of(852.21))
      Then("This account Amount should be 852.21")
      assert(bankAccount.total() == Amount.of(852.21))
    }
  }

  describe("Bank account should start with an empty historic") {
    it("Freshly created bank account should have an empty operation historic") {
      Given("A fresh Account")
      val bankAccount = BankAccount.freshAccount()
      Then("This account historic should be empty")
      assert(bankAccount.historicIsEmpty)
    }
  }
}
