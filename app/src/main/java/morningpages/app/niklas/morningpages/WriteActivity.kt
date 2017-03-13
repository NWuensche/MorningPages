package morningpages.app.niklas.morningpages

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.Menu
import java.util.*

class WriteActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_write)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_write, menu)
        menu!!.findItem(R.id.show_timer).title = intent.extras.getString("time")
        return super.onCreateOptionsMenu(menu)
    }

}
