package com.example.andoidproject.db;



import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

@Dao
public interface QuestionDao {

    @Query("SELECT * " +
            "FROM question " +
            "WHERE tag = :tag " +
            "AND questiontext NOT IN (:questions)" +
            "ORDER BY RANDOM() " +
            "LIMIT 1")
    Question getQuestionRandomByTag(String tag, List<String> questions);

    @Query("SELECT reponse FROM question WHERE questiontext != :question AND reponse != :otherRep ORDER BY RANDOM() LIMIT 1")
    String getFalseAnswersByQuestion(String question, String otherRep);

    @Insert
    void insert(Question question);

    @Insert
    long[] insertAll(Question... questions);

    @Delete
    void delete(Question question);

    @Update
    void update(Question question);

}