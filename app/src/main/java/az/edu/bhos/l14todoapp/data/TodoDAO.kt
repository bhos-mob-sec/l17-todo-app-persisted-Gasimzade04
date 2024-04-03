package az.edu.bhos.l14todoapp.data

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import az.edu.bhos.l14todoapp.data.dto.TodoLocalDto
import kotlinx.coroutines.flow.Flow

@Dao
interface TodoDao {
    @Query("SELECT * FROM todos ORDER BY weekday")
    fun getTodosOrderedByWeekday(): Flow<List<TodoLocalDto>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAll(todos: List<TodoLocalDto>)
}
