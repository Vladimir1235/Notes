package core.db.model

import androidx.room.*
import core.db.entity.NoteEntity

const val tableName = "notes"
const val foreignKey = "id"
const val selectAll = "select * from $tableName"
const val selectUnique = "select * from $tableName where $foreignKey in (:id)"

@Dao
abstract class NoteDao {
    @Transaction
    open suspend fun setAthlete(athlete: NoteEntity) {
        delete(athlete)
        insertAll(athlete)
    }

    @Query(selectAll)
    abstract suspend fun getAll(): List<NoteEntity>

    @Query(selectUnique)
    abstract suspend fun getSpecific(id: Long): NoteEntity

    @Transaction
    @Insert
    abstract suspend fun insertAll(vararg athletes: NoteEntity)

    @Transaction
    @Delete
    abstract suspend fun delete(athlete: NoteEntity)

}