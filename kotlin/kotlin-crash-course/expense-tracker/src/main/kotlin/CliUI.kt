import kotlinx.datetime.LocalDate


class CliUI (private val repo: ExpenseRepository ){

    fun run() {
        while (true) {
            println("Select one of the below options")
            println("1: Add")
            println("2: Delete")
            println("3: List")
            println("4: Exit")
            val input = readlnOrNull()
            if (input == null) {
                println("EOF detected. Exiting...")
                return
            }
            input.let { input ->
                when (input) {
                    "1" -> {
                        var amount: Double? = null
                        while (amount == null) {
                            println("Enter amount:")
                            amount = readlnOrNull()?.toDoubleOrNull()
                            if (amount == null) {
                                println("Invalid amount. Please enter a valid number.")
                            }
                        }
                        var category: String? = null
                        while (category == null || category.isBlank()) {
                            println("Enter category:")
                            category = readlnOrNull()?.takeIf { it.isNotBlank() }
                        }
                        var description: String? = null
                        while (description == null || description.isBlank()) {
                            println("Enter description:")
                            description = readlnOrNull()?.takeIf { it.isNotBlank() }
                        }
                        var date: LocalDate? = null
                        while (date == null) {
                            println("Enter date (yyyy-mm-dd):")
                            val dateInput = readlnOrNull() ?: ""
                            // Safely parse or return null on any failure/empty input
                            date = runCatching { LocalDate.parse(dateInput) }.getOrNull()
                            if (date == null) {
                                println("Invalid date format. Please try again.")
                            }
                        }
                        val expense = Expense(0, amount, category, description, date)
                        val created = repo.add(expense)
                        println("Expense added: $created")

                    }


                    "2" -> {
                        println("Enter id to delete:")
                        val id = readlnOrNull()?.toIntOrNull() ?: -1
                        if (repo.delete(id)) {
                            println("Expense deleted.")
                        } else {
                            println("Expense not found.")
                        }
                    }

                    "3" -> {
                        val all = repo.list()
                        if (all.isEmpty()) {
                            println("No expenses recorded.")
                        } else {
                            println("ID | Date       | Amount  | Category      | Description")
                            println("---+------------+---------+---------------+-----------------")
                            all.forEach { e ->
                                val amt = "%.2f".format(e.amount)
                                val cat = e.category.ifBlank { "Uncategorized" }
                                println("${e.id} | ${e.date} | ${amt.padStart(7)} | ${cat.padEnd(13)} | ${e.description}")
                            }

                            val total = all.sumOf { it.amount }
                            println()
                            println("Total: ${"%.2f".format(total)}")

                            val byCat = all.groupBy { it.category.ifBlank { "Uncategorized" } }
                                .mapValues { entry -> entry.value.sumOf { it.amount } }

                            println("Total by category:")
                            byCat.forEach { (cat, amt) ->
                                println("  ${cat}: ${"%.2f".format(amt)}")
                            }
                        }
                    }

                    "4" -> {
                        println("Exiting...")
                        return
                    }

                    else -> {
                        println("Invalid option. Please try again.")
                    }
                }
            }


        }
    }
    }