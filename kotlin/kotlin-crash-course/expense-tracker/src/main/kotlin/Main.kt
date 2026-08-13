

fun main() {

    val expenseRepository: ExpenseRepository = InMemoryExpenseRepository()
    val cliUI = CliUI(expenseRepository)

    println("Expense Tracker Starting...")
    cliUI.run()


}