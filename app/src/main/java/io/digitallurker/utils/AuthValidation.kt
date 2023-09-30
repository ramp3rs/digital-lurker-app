package io.digitallurker.utils

object AuthValidation {
    fun validate(vararg fields: String): List<Int> {
        val emptyIndexes = mutableListOf<Int>()
        for (f in fields.indices) {
            if (fields[f].isEmpty()) {
                emptyIndexes.add(f)
            }
        }
        return emptyIndexes
    }
}