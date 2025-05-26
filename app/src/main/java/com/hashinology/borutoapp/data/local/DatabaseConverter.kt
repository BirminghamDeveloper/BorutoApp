package com.hashinology.borutoapp.data.local

import androidx.room.TypeConverter

class DatabaseConverter {
    private val separator = ","

    @TypeConverter
    fun convertListToString(list: List<String>): String{
        val sb = StringBuilder()
        for (item in list){
            sb.append(item).append(separator)
        }

        sb.setLength(sb.length - separator.length)
        return sb.toString()

//        return list.joinToString(separator = separator)
    }

    @TypeConverter
    fun convertStringToList(elemenrs: String): List<String>{
        return elemenrs.split(separator)
    }
}