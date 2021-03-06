package com.example.mvvmretrofit

import android.os.Bundle
import android.widget.Toast
import androidx.activity.viewModels
import androidx.lifecycle.Observer
import com.example.mvvmretrofit.databinding.ActivityMainBinding
import com.example.mvvmretrofit.ui.base.BaseActivity
import com.example.mvvmretrofit.ui.main.MainViewModel
import com.example.mvvmretrofit.utils.Status
import dagger.hilt.android.AndroidEntryPoint



@AndroidEntryPoint
class MainActivity : BaseActivity() {
    var binding:ActivityMainBinding? = null

    private val mViewModel by viewModels<MainViewModel> ()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        binding?.apply {
            setContentView(this.root)
            lifecycleOwner = this@MainActivity
            executePendingBindings()
        }
        init()
    }

    override fun initArguments() {
        mViewModel.getPosts()
    }

    override fun initViews() {
    }

    override fun setupListener() {
        binding?.referesh?.setOnClickListener {
            mViewModel.getPosts()
        }
    }

    override fun loadData() {
        mViewModel.userPostResponse.observe(this, Observer {
            it?:return@Observer
            when(it.status){
                Status.SUCCESS ->{
                    val posts  = it.data?.allPosts
            if (posts != null) {
                for (post in posts) {
                    var content: String = ""
                    content += "Id: ${post.id} \n"
                    content += "UserId: ${post.userId} \n"
                    content += "Title: ${post.title} \n"
                    content += "Text: ${post.description} \n"
                    binding?.textViewResult?.append(content)
                }
            }
                }
                Status.ERROR ->{
                    Toast.makeText(this,it.message, Toast.LENGTH_LONG).show()
                }
                Status.LOADING ->{

                }
            }
        })





    }
}