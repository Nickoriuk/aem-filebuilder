package io.redcastle.aem.filebuilder.model

/*
 * Generic method to support other types
 */
private fun vaultArray(type: String, values: List<Any>): String {
    return values.joinToString(prefix = "{$type}[", separator = ",", postfix = "]")
}
