interface ExpenseRepository {
    fun add(expense: Expense): Expense
    fun delete(id: Int): Boolean
    fun list(): List<Expense>
}