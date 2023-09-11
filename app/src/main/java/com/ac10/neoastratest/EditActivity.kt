package com.ac10.neoastratest

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import androidx.core.net.toUri
import com.dsphotoeditor.sdk.activity.DsPhotoEditorActivity
import com.dsphotoeditor.sdk.utils.DsPhotoEditorConstants

class EditActivity : AppCompatActivity() {

    private lateinit var editedImage: ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_edit)
        editedImage = findViewById(R.id.editedImage)

        val imageUri = intent.getStringExtra("imageUri").toString()

        val dsPhotoEditorIntent = Intent(this, DsPhotoEditorActivity::class.java)
        dsPhotoEditorIntent.data = imageUri.toUri()
        dsPhotoEditorIntent.putExtra(
            DsPhotoEditorConstants.DS_PHOTO_EDITOR_OUTPUT_DIRECTORY,
            "Edited Image")
        startActivityForResult(dsPhotoEditorIntent, 100)



    }

    @Deprecated("Deprecated in Java")
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if (resultCode == RESULT_OK) {

            if(requestCode==100) {

                val outputUri: Uri? = data!!.data

                editedImage.setImageURI(outputUri)

            }
        }


    }






}