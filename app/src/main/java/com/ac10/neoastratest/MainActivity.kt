package com.ac10.neoastratest

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.MediaStore
import android.widget.Button
import android.widget.ImageView
import android.widget.Toast

class MainActivity : AppCompatActivity() {

    private lateinit var pickImage: Button
    private lateinit var imageIV: ImageView


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        pickImage = findViewById(R.id.button)
        imageIV = findViewById(R.id.imageView)

        pickImage.setOnClickListener {
            val intent = Intent(MediaStore.ACTION_PICK_IMAGES).apply {
                startActivityForResult(this, 1)
            }

        }



    }

    @Deprecated("Deprecated in Java")
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if (resultCode == RESULT_OK) {

            try {
                if (requestCode == 1) {
                    val selectedImageUri: Uri = data?.data!!
                    imageIV.setImageURI(selectedImageUri)

                    imageIV.setOnClickListener {
                        val intent = Intent(this@MainActivity, EditActivity::class.java)
                        intent.putExtra("imageUri", selectedImageUri.toString())
                        startActivity(intent)
                    }

                }
            } catch (exception: Exception) {
                Toast.makeText(this, "Error Occurred", Toast.LENGTH_SHORT).show()

            }


        }
    }


}