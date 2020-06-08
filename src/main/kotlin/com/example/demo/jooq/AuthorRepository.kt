package com.example.demo.jooq

import com.demo.db.db_example.Tables.*
import com.demo.db.db_example.tables.Author as AuthorTable
import org.jooq.DSLContext
import org.jooq.Record
import org.jooq.SelectFinalStep
import org.springframework.stereotype.Repository
import java.awt.print.Pageable
import java.util.Date

@Repository
class AuthorRepository(private val context: DSLContext) : JooqRepository {
    val a = AUTHOR.`as`("o")

    fun <R: SelectFinalStep<*>> withContext(block: (context: DSLContext) -> R) : R = block(context)
}

fun AuthorRepository.findAll(pageable: Pageable) {
    val result = withContext {
        it.selectFrom(this)
                .orderBy()
    }
}

fun AuthorTable.toAuthor(record: Record) = Author(
    id = record.get(ID, Int::class.java),
    firstName = record[FIRST_NAME],
    lastName = record[LAST_NAME],
    dateOfBirth = record.get(DATE_OF_BIRTH, Date::class.java),
    yearOfBirth = record.get(YEAR_OF_BIRTH, Int::class.java),
    distinguished = record.get(DISTINGUISHED, Int::class.java)
)
