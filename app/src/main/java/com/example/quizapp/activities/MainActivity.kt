package com.example.quizapp.activities

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import com.example.quizapp.adapter.GridAdapter
import com.example.quizapp.constants.Constants
import com.example.quizapp.constants.QuizClass
import com.example.quizapp.databinding.ActivityMainBinding
import com.example.quizapp.models.Category


class MainActivity : AppCompatActivity() {

    private val binding: ActivityMainBinding by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(binding.root)

        val quizClass = QuizClass(this)

        val rvCategoryList = binding.rvCategoryList
        rvCategoryList?.layoutManager = GridLayoutManager(this,2)

        quizClass.getQuestionStatsList(object : QuizClass.QuestionStatCallback {
            override fun onQuestionStatFetched(map: Map<String, Category>) {
                val adapter = GridAdapter(Constants.getCategoryItemList(),map)
                rvCategoryList?.adapter = adapter
                adapter.setOnTouchResponse(object :GridAdapter.OnTouchResponse{
                    override fun onClick(id: Int) {
                        quizClass.getQuizList(10,id,null,null)
                    }

                })
            }

        })

        binding.btnRandomQuiz.setOnClickListener {
            quizClass.getQuizList(10, null, null, null)
        }

        binding.btnCustomQuiz.setOnClickListener {
            startActivity(Intent(this, CustomQuizActivity::class.java))
        }
    }
}