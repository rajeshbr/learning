class InMemoryExpenseRepository : ExpenseRepository {

    private val expenses = mutableListOf<Expense>()
    private var idGenerator = 0

    override fun add(expense: Expense): Expense {
        val newExpense = expense.copy(id = ++idGenerator)
        expenses.add(newExpense)
        return newExpense
    }

    override fun delete(id: Int): Boolean {
        return expenses.removeIf { it.id == id }
    }

    override fun list(): List<Expense> {
        return expenses.toList()
    }
}