package com.alexis.funchat.util

import java.util.regex.Matcher
import java.util.regex.Pattern

import androidx.annotation.*
import androidx.core.util.Preconditions

/**
 * Class description:
 *
 * @author Alexis
 * @date 2019/5/16  8:20
 */
class Validator private constructor() {

    init {
        Preconditions.checkArgument(false, "this method could not be invoke!")
    }

    companion object {

        /**
         * regex string to match number.
         */
        private val REGEX_NUMERIC = "-[0-9]+(.[0-9]+)?|[0-9]+(.[0-9]+)?"

        /**
         * regex string to match mobile number.
         *
         *
         * 移动：134,135,136,137,138,139,147,150,151,152,157,158,159,170,178,182,183,184,187,188
         * 联通：130,131,132,145,152,155,156,1709,171,176,185,186
         * 电信：133,134,153,1700,177,180,181,189
         */
        private val REGEX_MOBILE_NUMBER = "^1([378][0-9]|4[57]|5[0-35-9])\\d{8}$"

        /**
         * 判断对象是否为空
         *
         * @param reference reference
         * @param <T>       type
         * @return true null.
        </T> */
        fun <T> isNull(reference: T?): Boolean {
            return reference == null
        }

        /**
         * 判断对象是否不为空
         *
         * @param reference reference
         * @param <T>       type
         * @return true not null.
        </T> */
        fun <T> isNotNull(reference: T?): Boolean {
            return reference != null
        }

        /**
         * 判断集合是否为null/空.
         *
         * @param collection collection
         * @param <E>        type
         * @return true null or empty.
        </E> */
        fun <E> isEmpty(collection: Collection<E>?): Boolean {
            return collection == null || collection.isEmpty()
        }

        /**
         * 判断集合是否不为空.
         *
         * @param collection collection
         * @param <E>        type
         * @return true not empty.
        </E> */
        fun <E> isNotEmpty(collection: Collection<E>?): Boolean {
            return collection != null && !collection.isEmpty()
        }

        /**
         * 判断Map是否为null/空.
         *
         * @param map map
         * @param <K> type of key.
         * @param <V> type of value.
         * @return true null or empty.
        </V></K> */
        fun <K, V> isEmpty(map: Map<K, V>?): Boolean {
            return map == null || map.isEmpty()
        }

        /**
         * 判断Map是否不为null/空.
         *
         * @param map map
         * @param <K> type of key.
         * @param <V> type of value.
         * @return true not empty.
        </V></K> */
        fun <K, V> isNotEmpty(map: Map<K, V>?): Boolean {
            return map != null && !map.isEmpty()
        }

        /**
         * 判断字符串是否为null/empty.
         *
         * @param str string
         * @return true null or empty.
         */
        fun isEmpty(str: String?): Boolean {
            return str == null || str.trim { it <= ' ' }.isEmpty()
        }

        /**
         * 判断字符串是否不为null/empty.
         *
         * @param str string
         * @return true not empty.
         */
        fun isNotEmpty(str: String?): Boolean {
            return str != null && str.trim { it <= ' ' }.isNotEmpty()
        }

        /**
         * 判断字符串是否为null/empty.
         *
         * @param charSequence CharSequence
         * @return true null or empty.
         */
        fun isEmpty(charSequence: CharSequence?): Boolean {
            return charSequence == null || charSequence.isEmpty()
        }

        /**
         * 判断字符串是否不为null/empty.
         *
         * @param charSequence CharSequence
         * @return true not empty.
         */
        fun isNotEmpty(charSequence: CharSequence?): Boolean {
            return charSequence != null && charSequence.isNotEmpty()
        }

        /**
         * 判断数据是否为null/empty
         *
         * @param t   数组
         * @param <T> type
         * @return true null or empty.
        </T> */
        fun <T> isEmpty(t: Array<T>?): Boolean {
            return t == null || t.isEmpty()
        }

        /**
         * 判断数据是否不为null/empty
         *
         * @param t   数组
         * @param <T> type
         * @return true not empty.
        </T> */
        fun <T> isNotEmpty(t: Array<T>?): Boolean {
            return t != null && t.isNotEmpty()
        }

        /**
         * 判断字符串是否为数字
         *
         * @param value value
         * @return true numeric
         */
        fun isNumeric(value: String): Boolean {
            return if (isEmpty(value)) {
                false
            } else value.matches(REGEX_NUMERIC.toRegex())
        }

        /**
         * 验证手机号码
         *
         * @param mobiles mobiles
         * @return true is mobile number.
         */
        fun isMobileNumber(mobiles: String): Boolean {
            val pattern = Pattern.compile(REGEX_MOBILE_NUMBER)
            val matcher = pattern.matcher(mobiles)
            return matcher.matches()
        }
    }
}
