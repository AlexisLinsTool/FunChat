package com.alexis.funchat.util

/**
 * Class description:
 *
 * @author Alexis
 * @date 2019/5/16  8:22
 */
class CollectionsUtils private constructor() {

    init {
        throw UnsupportedOperationException()
    }

    companion object {

        fun <E> sizeOf(collection: Collection<E>?): Int {
            return if (Validator.isEmpty(collection)) 0 else collection!!.size
        }

        fun <K, V> sizeOf(map: Map<K, V>?): Int {
            return if (Validator.isEmpty(map)) 0 else map!!.size
        }

        fun <E> sizeOf(e: Array<E>?): Int {
            return if (Validator.isEmpty(e)) 0 else e!!.size
        }

        operator fun <E> get(collection: List<E>, index: Int): E? {
            return if (sizeOf(collection) == 0) null else collection[index]
        }
    }
}
