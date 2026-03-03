package com.example.retrofit

import android.app.ProgressDialog
import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import com.example.retrofit.databinding.ActivityMemeBinding
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class Meme : AppCompatActivity(){
    lateinit var binding: ActivityMemeBinding
    override fun onCreate(savedInstanceState: Bundle?){
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding= ActivityMemeBinding.inflate(layoutInflater)
        setContentView(binding.root)
        getData()
        binding.memebutton.setOnClickListener{
            getData()
        }
    }
       private fun getData(){
           val progressDialog = ProgressDialog(this)
           progressDialog.setMessage("Please Wait while the data is fetched")
           progressDialog.show()
        RetrofitInstance.apiInterface.getData().enqueue(object : Callback<responeData?>{
            override fun onResponse(call: Call<responeData?>, response: Response<responeData?>){

                binding.memetitle.text=response.body()?.title
                binding.memeAuthor.text=response.body()?.author
                Glide.with(this@Meme).load(response.body()?.url).into(binding.memeimage)
                progressDialog.dismiss()
           }
            override fun onFailure(call: Call<responeData?>, t: Throwable){
                Toast.makeText(this@Meme,"${t.localizedMessage}",Toast.LENGTH_SHORT)
                    .show()
                progressDialog.dismiss()
            }

        })
       }
}


