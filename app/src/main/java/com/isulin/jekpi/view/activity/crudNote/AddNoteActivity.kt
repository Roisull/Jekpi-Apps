package com.isulin.jekpi.view.activity.crudNote

import android.content.Intent
import android.os.AsyncTask
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.isulin.jekpi.R
import com.isulin.jekpi.dao.NoteDao
import com.isulin.jekpi.database.NotesDatabase
import com.isulin.jekpi.databinding.ActivityAddNoteBinding
import com.isulin.jekpi.databinding.ActivityMainBinding
import com.isulin.jekpi.entities.Note
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale
import androidx.room.OnConflictStrategy
import kotlinx.coroutines.runBlocking


class AddNoteActivity : AppCompatActivity() {
    lateinit var binding: ActivityAddNoteBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAddNoteBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        //        back from activity
        binding.ivBackFromActivityAddNote.setOnClickListener{
            onBackPressed()
        }
        //        end back from activity

//        create and save note
        // make date
        getCurrentDateTime()
        // end make date

        // button save note
        binding.ivSaveNoteActivityAddNote.setOnClickListener {
            saveNote()
        }
        //end button save note
//        end create and save note
    }
    private fun getCurrentDateTime(): String {
        val dateFormat = SimpleDateFormat("dd MMMM yyyy", Locale.getDefault())
        return dateFormat.format(Date())
    }
    private fun saveNote(){
        val title = binding.etAddTitleFragmentAddNote.text.toString().trim()
        val noteText = binding.etAddContentNoteActivityAddNote.text.toString().trim()
        val dateTime = getCurrentDateTime()

        if (title.isEmpty() && noteText.isEmpty()) {
            Toast.makeText(this, "Please enter a title or note", Toast.LENGTH_SHORT).show()
            return
        }

        val note = Note(
            id = 0, // Set the ID to 0 as it will be autogenerated by the database
            title = title,
            noteText = noteText,
            dateTime = dateTime,
            webLink = null,
            imagePath = null,
            bookmark = 0
        )

        // Save the note to the database using your NoteDao instance
        // noteDao.insertNote(note)

        Toast.makeText(this, "Note saved successfully", Toast.LENGTH_SHORT).show()
        finish() // Finish the activity and go back to the previous screen

        SaveNoteTask(NotesDatabase.getDatabase(applicationContext).noteDao()).executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, note)
    }

    private inner class SaveNoteTask(private val noteDao: NoteDao) : AsyncTask<Note, Void, Unit>() {

        override fun doInBackground(vararg params: Note) {
            runBlocking {
                noteDao.insertNote(params[0])
            }
        }

        override fun onPostExecute(result: Unit) {
            val intent = Intent()
            setResult(RESULT_OK, intent)
            Toast.makeText(this@AddNoteActivity, "Note saved successfully", Toast.LENGTH_SHORT).show()
            finish() // Finish the activity and go back to the previous screen
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        binding.root
    }
}