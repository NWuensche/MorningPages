package morningpages.app.niklas.morningpages

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu

class WriteActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_write)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_write, menu)
        return super.onCreateOptionsMenu(menu)
    }

}
