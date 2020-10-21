package fr.noether.bank.account

case class BankReport(value: Seq[ReportEntry]) {
  def append(entry: ReportEntry): BankReport = BankReport(value ++ Seq(entry))

}

object BankReport {
  def empty(): BankReport = BankReport(Seq())
}

