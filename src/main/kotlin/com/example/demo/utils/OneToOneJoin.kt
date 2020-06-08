package com.example.demo.utils

import kotlin.reflect.KMutableProperty1
import kotlin.reflect.KProperty1

class OneToOneJoin<E, R, ID>(
        private val relation: KMutableProperty1<E, R?>,
        private val idFrom: KProperty1<E, ID>,
        private val idTo: KProperty1<R, ID>
) {
    fun E.loadBy(block: (ID) -> R) {
        val related = block(idFrom.get(this))
        relation.set(this, related)
    }

    fun List<E>.loadBy(block: (List<ID>) -> List<R>) {
        val related: Map<ID, R> = block(this.map(idFrom))
                .associateBy(idTo)

        this.forEach {
            val item = related.getOrDefault(idFrom(it), null)
            relation.set(it, item)
        }
    }
}

class NonNullOneToOneJoin<E, R, ID>(
        private val relation: KMutableProperty1<E, R>,
        private val idFrom: KProperty1<E, ID>,
        private val idTo: KProperty1<R, ID>
) {
    fun E.loadBy(block: (ID) -> R) {
        val related = block(idFrom.get(this))
        relation.set(this, related)
    }

    fun List<E>.loadBy(block: (List<ID>) -> List<R>) {
        val related: Map<ID, R> = block(this.map(idFrom))
                .associateBy(idTo)

        this.forEach {
            val item = related.getOrElse(idFrom(it)) { return@forEach }
            relation.set(it, item)
        }
    }
}


data class OnSpec<E, R, ID>(val from: KProperty1<E, ID>, val to: KProperty1<R, ID>)


infix fun <E, R, ID> KProperty1<E, ID>.eq(that: KProperty1<R, ID>) = OnSpec(this, that)


fun <E, R, ID> join(property: KMutableProperty1<E, R?>, on: OnSpec<E, R, ID>) = OneToOneJoin(property, on.from, on.to)

fun <E, R, ID> joinNonNull(property: KMutableProperty1<E, R>, on: OnSpec<E, R, ID>) = NonNullOneToOneJoin(property, on.from, on.to)
