import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertTrue
import kotlin.test.assertFalse
import kotlinx.datetime.LocalDate

class InMemoryExpenseRepositoryTest {

    @Test
    fun addAssignsIdAndListContains() {
        val repo = InMemoryExpenseRepository()
        val expense = Expense(0, 12.5, "Food", "Lunch", LocalDate.parse("2026-07-15"))
        val created = repo.add(expense)

        assertEquals(1, created.id, "First created expense should have id = 1")

        val all = repo.list()
        assertEquals(1, all.size, "Repository should contain one expense")
        assertEquals(created, all[0], "Stored expense should equal created expense")
    }

    @Test
    fun deleteRemovesExpense() {
        val repo = InMemoryExpenseRepository()
        val a = repo.add(Expense(0, 10.0, "T", "d1", LocalDate.parse("2026-07-15")))
        val b = repo.add(Expense(0, 20.0, "T", "d2", LocalDate.parse("2026-07-15")))

        assertTrue(repo.delete(a.id), "Deleting existing id should return true")

        val remaining = repo.list()
        assertEquals(1, remaining.size, "One expense should remain after deletion")
        assertEquals(b.id, remaining[0].id, "Remaining expense should be the second one added")

        assertFalse(repo.delete(999), "Deleting nonexistent id should return false")
    }

    @Test
    fun listIsSnapshot() {
        val repo = InMemoryExpenseRepository()
        repo.add(Expense(0, 1.0, "x", "", LocalDate.parse("2026-07-15")))

        val snapshot = repo.list()
        // Add another expense after taking the snapshot
        repo.add(Expense(0, 2.0, "y", "", LocalDate.parse("2026-07-15")))

        // Snapshot should not change
        assertEquals(1, snapshot.size, "Snapshot should not reflect subsequent additions")
    }
}
