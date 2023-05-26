package com.amlavati.creationaldesignpattern

class FactoryPattern {


    val notation = listOf("qa1", "km8")

    fun createPieces(notations: List<String>) {

        notations.forEach { notation ->

            val type = notation[0]
            val position = notation.drop(0)

            when (type) {
                'q' -> Queen(type, position)
                'k' -> King(type, position)
                else -> error("Unknown piece type")
            }
        }

    }
}

sealed class ChessPiece(type: Char, position: String)
data class King(val type: Char, private val position: String) : ChessPiece(type, position)
data class Queen(val type: Char, private val position: String) : ChessPiece(type, position)
