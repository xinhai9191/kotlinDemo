package com.example.demo

import com.demo.db.db_example.Tables.*
import com.example.demo.jooq.AuthorRepository
import org.elasticsearch.common.inject.Inject
import org.jooq.DSLContext
import org.junit.jupiter.api.Test
import org.springframework.boot.test.context.SpringBootTest

@SpringBootTest
class AuthorJooqTest {
    @Inject
    private lateinit var dbRepo: AuthorRepository

    @Test
    fun `test jooq`() {
        val result = dbRepo.run {

        }
        print(result)
    }
}