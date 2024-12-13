package com.legend.kotlinspringcrud.board.entity

import com.legend.kotlinspringcrud.board.dto.BoardUpdateReqDto
import jakarta.persistence.*

@Entity
@Table(name = "boards")
class Board (
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0,

    @Column(nullable = false)
    var title: String,

    @Column(nullable = false)
    var content: String,

) {

    fun updateBoard(boardUpdateReqDto: BoardUpdateReqDto) {
        boardUpdateReqDto.title?.let { this.title = it }
        boardUpdateReqDto.content?.let { this.content = it}
    }


}