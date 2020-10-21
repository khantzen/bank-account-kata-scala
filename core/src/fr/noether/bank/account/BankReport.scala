package fr.noether.bank.account

case class BankReport(initialBalance: Amount, entries: Seq[ReportEntry]) {
  def lastAmount(): Amount = entries match {
    case Seq() => initialBalance
    case x => x.last.balanceAmount
  }

  def append(entry: ReportEntry): BankReport = BankReport(initialBalance, entries ++ Seq(entry))

}

object BankReport {
  def withInitialAmount(initialBalance: Amount): BankReport = BankReport(initialBalance, Seq())

  def empty(): BankReport = BankReport(Amount.ZERO, Seq())
}

