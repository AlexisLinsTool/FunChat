package com.alexis.funchat.util


/**
 *  Class description:
 *
 *  @author Alexis
 *  @date   2019/5/30  20:17
 */
/**
 * 手机号验证
 */
val compPhone = Regex(pattern = "((\\d{4}-)?[1]([3]|[4]|[5]|[7]|[8])[0-9]{9})")
/**
 * Email验证
 */
val compMail = Regex(pattern = "^\\w+([-+.]\\w+)*@\\w+([-.]\\w+)*\\.\\w+([-.]\\w+)*\$")
val compYU = Regex(pattern = "[a-zA-Z0-9][-a-zA-Z0-9]{0,62}(/.[a-zA-Z0-9][-a-zA-Z0-9]{0,62})+/.?")
/**
 * uri路径验证
 */
val compURI = Regex(pattern = "^http://([\\w-]+\\.)+[\\w-]+(/[\\w-./?%&=]*)?\$")
/**
 * IP验证
 */
val compIP = Regex(pattern = "\\d+\\.\\d+\\.\\d+\\.\\d+ ")
/**腾讯QQ号从10000开始**/
val compQQ = Regex(pattern = "[1-9][0-9]{4,}")
/**
 * 账号可以包含字母、数字、下划线
 */
val compAccount = Regex(pattern = "^[a-zA-Z][a-zA-Z0-9_]{4,15}\$")
/**强密码(必须包含大小写字母和数字的组合，不能使用特殊字符，长度在8-16之间)**/
val compHeadPwd = Regex(pattern = "^(?=.*\\d)(?=.*[a-z])(?=.*[A-Z]).{8,16}\$")
val compCHN = Regex(pattern = "[\\u4e00-\\u9fa5]+")

fun String.isPhone(): Boolean {
    return this.matches(compPhone)
}

fun String.isMail():Boolean{
    return this.matches(compMail)
}

fun String.isYU():Boolean{
    return this.matches(compYU)
}

fun String.isURL():Boolean{
    return this.matches(compURI)
}

fun String.isIP():Boolean{
    return this.matches(compIP)
}

fun String.isQQ():Boolean{
    return this.matches(compQQ)
}

fun String.isAccount():Boolean{
    return this.matches(compAccount)
}

fun String.isHPwd():Boolean{
    return this.matches(compHeadPwd)
}

fun String.isCHN():Boolean{
    return this.matches(compCHN)
}
