package com.legend.kotlinspringcrud.board.repository

import com.legend.kotlinspringcrud.board.entity.Board
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface BoardRepository : JpaRepository<Board, Long> {
}