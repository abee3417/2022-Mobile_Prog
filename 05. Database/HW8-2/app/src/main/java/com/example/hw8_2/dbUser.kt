package com.example.hw8_2

import androidx.room.*

@Entity(tableName="users")
data class User(
    @PrimaryKey val uid: Int,
    @ColumnInfo(name = "name") val user_name: String?,
    @ColumnInfo(name = "pw") val pass_word: String?
)

@Dao
interface UserDao{
    @Query("SELECT * FROM users")
    fun getAll(): List<User>

    @Query("SELECT * FROM users WHERE uid IN (:userIds)")
    fun loadAllByIds(userIds: IntArray): List<User>

    @Query("SELECT * FROM users WHERE name LIKE :user_name AND " + "pw LIKE :pass_word LIMIT 1")
    fun findByName(user_name: String, pass_word: String): User

    @Insert
    fun insertAll(vararg users: User)

    @Delete
    fun delete(users: User)

}

@Database(entities = arrayOf(User::class), version=1)
abstract class UserDB : RoomDatabase(){
    abstract fun userDao(): UserDao
}