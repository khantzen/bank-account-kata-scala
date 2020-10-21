package fr.noether.bank.reporting

import fr.noether.bank.account.Amount

case class BankReport(initialBalance: Amount, entries: Seq[ReportEntry]) {
  def lastAmount(): Amount = entries match {
    case Seq() => initialBalance
    case x => x.last.balanceAmount
  }

  def append(entry: ReportEntry): BankReport = BankReport(initialBalance, entries ++ Seq(entry))

  override def toString: String = entries
    .foldLeft(new StringBuilder("Operation Type|Date|Amount|Balance\r\n"))((acc, entry) =>
      acc.append(entry.toString).append("\r\n")
    ).toString()
}

object BankReport {
  def withInitialAmount(initialBalance: Amount): BankReport = BankReport(initialBalance, Seq())

  def empty(): BankReport = BankReport(Amount.ZERO, Seq())
}

